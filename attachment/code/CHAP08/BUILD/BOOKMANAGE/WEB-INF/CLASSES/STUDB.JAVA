package wyf.wyy;
import java.util.*;
import java.io.*;
import org.springframework.jdbc.core.*;
public class StuDB {
	private JdbcTemplate jt;								//声明JdbcTemplate对象引用					
	private List rl = null;									//声明List对象引用
	private String sql = null;								//声明SQL字符串引用
	public void setJt(JdbcTemplate jt){						//jt成员的set方法
		this.jt = jt;										//设置jt属性的值
	}
	public boolean verify(String StuNO,String pwd){	//登陆验证
		boolean result = false;								//登陆成功失败标志
		sql = "select * from student where "+				//创建SQL语句
			  "StudentNO='"+StuNO+"' and Password='"+pwd+"'";
        rl = jt.queryForList(sql);							//执行查询
        if(rl.size()!=0){									//判断查询结果
        	result = true;									//如果存在用户则值标志位为true
        }
		return result;										//返回标志位
	}
	public Vector<String> getStuInfo(String stuNO){
		Vector<String> vinfo = new Vector<String>();		//创建信息向量
		sql = "select StudentNO,Name,Age,Gender,"+
    		  "Class,Department,Permitted from"+
    		  " student where StudentNO='"+stuNO+"'";		//创建SQL语句
		rl = jt.queryForList(sql);							//得到学生信息
		if(rl.size()!=0){
			for(int i=0;i<rl.size();i++){					//遍历查询结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				Set set=map.keySet();						//Map的键值为各个列的列名
				for(Object o:set){
						String info = map.get(o).toString();//对取出的信息进行转码
						vinfo.add(info);						//将信息添加进返回向量									
				}
				if(vinfo.get(6).equals("1")){
					String per = (this.getCurMoney(stuNO).size()>0)?"0":"1";
					vinfo.set(6,per);
				}
			}
		}
		return vinfo;											//返回查询结果
	}
	public boolean changePwd(String stuNO,String oldPwd,String newPwd){
		boolean flag = false;								//更新结果标志
		sql = "select * from student where "+				//创建查询用户名和密码是否匹配的SQL语句
			  "StudentNO='"+stuNO+"' and Password='"+oldPwd+"'";
		rl = jt.queryForList(sql);							//执行查询
		if(rl.size()!=0){									//用户名和密码匹配
			sql = "update student set Password='"+newPwd+
				  "' where StudentNO='"+stuNO+"'";			//更新密码SQL语句
			jt.execute(sql);								//执行更新
			flag = true;									//更新成功设置标志位			
		}
		return flag;
	}
	public Vector<Vector<String>> getCurMoney(String stuNO){
		Vector<Vector<String>> vlist = new Vector<Vector<String>>();	//创建信息向量
		sql = "select BookName,'超期罚款',StartTime,End from book,"+
			  "borrow_list where StudentNO='"+stuNO+"' and book.BookNO"+
			  "=borrow_list.BookNO and Deal=0";							//搜索出当前借书记录							
		rl = jt.queryForList(sql);										//执行查询得到结果
		if(rl.size()!=0){
			for(int i=0;i<rl.size();i++){						//遍历查询结果
				Map map=(Map)rl.get(i);							//结果List中每一行为一个LinkedHashMap
				Set set=map.keySet();							//Map的键值为各个列的列名
				Vector<String> vtemp = new Vector<String>();	//创建临时信息向量
				for(Object o:set){
					String info = map.get(o).toString();		//对取出的信息进行转码
					vtemp.add(info);						//将信息添加进临时向量										
				}
				String end = vtemp.get(3);							//得到应该归还图书的日期字符串
				String now = 
					DateUtil.getDateString(Calendar.getInstance());	//得到一个当前日期的实例
				int exceed = DateUtil.getDay(end,now);				//得到超期天数
				if(exceed>0){
					vtemp.add(String.valueOf(exceed/10.0));			//将超期转换成超期罚款并添加到向量
					vlist.add(vtemp);								//将超期记录添加进返回向量	
				}					
			}
		}
		return vlist;	
	}
}