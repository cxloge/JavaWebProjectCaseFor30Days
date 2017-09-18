package wyf.wyy;
import java.util.*;
import javax.sql.*;
import java.io.*;
import org.springframework.jdbc.core.*;
import org.springframework.transaction.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.transaction.support.*;            
public class DBUtil{
	private JdbcTemplate jt;									//声明JdbcTemplate对象引用						
	private List rl = null;										//声明List对象引用
	private String sql = null;									//声明SQL字符串引用
	private DataSource ds;										//声明DataSource引用
	private DataSourceTransactionManager dtm;				
	private DefaultTransactionDefinition dtd;
	public void setJt(JdbcTemplate jt){						//jt成员的set方法
		this.jt = jt;										//设置jt属性的值
	}
	public void setDs(DataSource ds){
		this.ds=ds;
	}
	public int getTotal(String sql,int span){						//得到总页数
		int total = 0;										//声明页数返回值
		int rows = jt.queryForInt(sql);					//执行查询得到总记录条数
		total = rows/span+((rows%span==0)?0:1);			//计算得到总页数		
		return total;
	}
	public Vector<Vector<String>> getPageContent(String sql,int page,int span){
		Vector<Vector<String>> vlist = new Vector<Vector<String>>();	//创建信息向量
		int start = (page-1)*span;										//得到起始记录条数
		int end = start+span;											//结束记录条数
		rl = jt.queryForList(sql);									//搜索得到结果
		if(rl.size()!=0){				
			for(int i=start;i<end&&i<rl.size();i++){								//遍历查询结果
				Map map=(Map)rl.get(i);									//结果List中每一行为一个LinkedHashMap
				Set set=map.keySet();									//Map的键值为各个列的列名
				Vector<String> vtemp = new Vector<String>();			//创建临时信息向量				
				for(Object o:set){										
					String info = map.get(o).toString();				//对取出的信息进行转码
					vtemp.add(info);									//将信息添加进临时向量										
				}
				vlist.add(vtemp);										//将每条记录添加进返回向量			
			}
		}		
		return vlist;
	}
	public String getStringInfo(String sql){
		String info = null;
		try{
			info = (String)jt.queryForObject(sql,String.class);
		}
		catch(Exception e){
			info = null;
		}
		return info;
	}
	public boolean isExist(String sql){
		boolean result = false;
		rl = jt.queryForList(sql);							//执行查询
        if(rl.size()!=0){									//判断查询结果
        	result = true;									//如果存在用户则值标志位为true
        }
		return result;										//返回标志位
	}
	public boolean update(Vector<String> v){					//事务处理
		boolean flag = true;									//更新结果标志
		dtm = new DataSourceTransactionManager(ds);				//得到事务管理
		dtd = new DefaultTransactionDefinition();
        dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus ts = dtm.getTransaction(dtd);
        try{
        	for(int i=0;i<v.size();i++){
        		jt.update(v.get(i));						//执行更新        		
        	}
        	dtm.commit(ts);									//无异常发生则提交事务           	                             
       }
       catch(Exception e) {
           dtm.rollback(ts);								//发生异常，进行回滚				
           flag = false;									//更新标志设置为false
           e.printStackTrace();
       }      
		return flag;
	}					//处理事务的方法
	public boolean update(String sql){						//执行单个SQL语句的方法
		boolean flag = false;
		int result = jt.update(sql);		//执行更新得到更新记录条数
		if(result>=0){						//更新记录条数大于一时
			flag = true;					//将更新结果标志置为true
		}
		return flag;
	}
	public Vector<Vector<String>> getInfo(String sql){
		Vector<Vector<String>> vlist = new Vector<Vector<String>>();		//创建信息向量	
    	rl = jt.queryForList(sql);								//执行查询得到结果
		if(rl.size()!=0){
			for(int i=0;i<rl.size();i++){						//遍历查询结果
				Map map=(Map)rl.get(i);							//结果List中每一行为一个LinkedHashMap
				Set set=map.keySet();							//Map的键值为各个列的列名
				Vector<String> vtemp = new Vector<String>();	//创建临时信息向量
				for(Object o:set){	
					String info = map.get(o).toString();	//对取出的信息进行转码
					vtemp.add(info);						//将信息添加进临时向量										
				}
				vlist.add(vtemp);								//将每条记录添加进返回向量			
			}
		}
		return vlist;
	}
	public boolean canBorrow(String stuNO,String bNO){
		boolean flag = false;
		String sql = "select EndTime from order_list where "+
					 "BookNO='"+bNO+"'";	//搜索该书预订记录
		Vector<String> vtemp = new Vector<String>();
		rl = jt.queryForList(sql);									//执行查询得到结果
		if(rl.size()!=0){
				for(int i=0;i<rl.size();i++){						//遍历查询结果
				Map map=(Map)rl.get(i);								//结果List中每一行为一个LinkedHashMap
				Set set=map.keySet();								//Map的键值为各个列的列名				
				for(Object o:set){
					String info = map.get(o).toString();		//对取出的信息进行转码							
					vtemp.add(info);							//将信息添加进临时向量										
				}					
			}
			Calendar cal = Calendar.getInstance();					//得到当前时间						
			String now = DateUtil.getDateString(cal);				//转为字符串形式
			for(int i=0;i<vtemp.size();i++){
				String endTime = vtemp.get(i);						//得到截止日期
				int day = DateUtil.getDay(now,endTime);				//得到日期差
				if(day>0){
					sql = "select StudentNO from order_list"+
						  " where EndTime='"+endTime+"'";			//在预约范围内				
					String orStuNO = this.getStringInfo(sql);		//得到预约该书的学生学号
					if(orStuNO.equals(stuNO)){
						flag = true;
					}
				}
			}
		}
		else{
			flag =true;
		}
		return flag;		
	}
}