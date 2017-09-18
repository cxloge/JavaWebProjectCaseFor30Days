package wyf;
import java.util.*;
import javax.sql.*;
import java.io.*;
import javax.faces.model.*;
import org.springframework.jdbc.core.*;
import org.springframework.transaction.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.transaction.support.*;            
public class DBUtil{
	public JdbcTemplate jt;									//声明JdbcTemplate对象引用						
	private List rl = null;										//声明List对象引用
	private String sql = null;									//声明SQL字符串引用
	private DataSource ds;										//声明DataSource引用
	private DataSourceTransactionManager dtm;				
	private DefaultTransactionDefinition dtd;
	public void setJt(JdbcTemplate jt){						//jt成员的setter方法
		this.jt = jt;										//设置jt属性的值
	}
	public void setDs(DataSource ds){
		this.ds=ds;
	}

	public int getTotal(String sql,int span){			//得到总页数
		int total = 0;									//声明页数返回值
		sql = "select count(*) from ("+sql+")a";
		int rows = jt.queryForInt(sql);					//执行查询得到总记录条数		
		total = rows/span+((rows%span==0)?0:1);			//计算得到总页数						
		return total;
	}
	
	public SelectItem[] getResType(){
		sql = "select GId,GName from group_info";		//搜索出资源类别信息的SQL语句
		rl = jt.queryForList(sql);						//执行查询得到结果
		SelectItem[] list=new SelectItem[rl.size()];
		if(rl.size()!=0){
			for(int i=0;i<rl.size();i++){
				Map map = (Map)rl.get(i);
				int gid = Integer.valueOf(map.get("GID").toString());
				String gname = map.get("GNAME").toString();
				list[i] = new SelectItem(gid,gname);
			}
		}
		return list;
	}
	
	public Vector getResList(String sql,int curPage,int span){
		Vector al = new Vector();
		int startRow = (curPage-1)*span;					//计算起始行数
		int endRow = startRow + span;						//计算结束行数
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=startRow;i<rl.size()&&i<endRow;i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				ResItem ri = new ResItem();					//创建一个ResItem对象			
				ri.setRid(map.get("RID").toString());		//设置rid属性值
				ri.setRname(map.get("RNAME").toString());	//设置rname属性值
				ri.setRspec(map.get("RSPEC").toString());	//设置rspec属性值
				ri.setRdetail(map.get("RDETAIL").toString());//设置rdetail属性值
				ri.setRprice(map.get("RPRICE").toString());	//设置rprice属性值
				ri.setGid(map.get("GID").toString());		//设置资源的gid属性值
				ri.setRstatus(map.get("RSTATUS").toString());
				al.add(ri);									//将此课程对象放进返回List中
			}
		}
		return al;														//返回结果
	}
	
	public Vector getUserList(String sql,int curPage,int span){
		Vector al = new Vector();
		int startRow = (curPage-1)*span;					//计算起始行数
		int endRow = startRow + span;						//计算结束行数
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=startRow;i<rl.size()&&i<endRow;i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				User_Item ui = new User_Item();				//创建一个User_Item对象			
				ui.setUsid(map.get("USID").toString());		//设置usid属性值
				ui.setUname(map.get("UNAME").toString());	//设置uname属性值
				ui.setUgender(map.get("UGENDER").toString());//设置ugender属性值
				ui.setUemail(map.get("UEMAIL").toString());//设置uemail属性值
				ui.setUphone(map.get("UPHONE").toString());	//设置uphone属性值
				al.add(ui);									//将此课程对象放进返回List中
			}
		}
		return al;														//返回结果
	}
	
	public Vector getOrderList(String sql,int curPage,int span){
		Vector al = new Vector();
		int startRow = (curPage-1)*span;					//计算起始行数
		int endRow = startRow + span;						//计算结束行数
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=startRow;i<rl.size()&&i<endRow;i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				List_Item li = new List_Item();					//创建一个List_Item对象			
				li.setOId(map.get("OID").toString());			//设置OId属性值
				li.setOTime(map.get("OTIME").toString());		//设置OTime属性值
				li.setOStatus(map.get("OSTATUS").toString());	//设置OStatus属性值
				li.setODetail(map.get("ODETAIL").toString());	//设置ODetail属性值
				li.setUname(map.get("UNAME").toString());		//设置Uname属性值
				al.add(li);										//将此课程对象放进返回List中
			}
		}
		return al;												//返回结果
	}
	
	public Vector getOrderDetail(String sql){
		Vector al = new Vector();
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=0;i<rl.size();i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				Info_Item ii = new Info_Item();				//创建一个Info_Item对象			
				ii.setEnd(map.get("END").toString());		//设置end属性值
				ii.setStart(map.get("ST").toString());		//设置start属性值
				ii.setStatus(map.get("STATUS").toString());	//设置status属性值
				ii.setRname(map.get("RNAME").toString());	//设置rname属性值
				ii.setRid(map.get("RID").toString());		//设置rid属性值
				ii.setGname(map.get("GNAME").toString());	//设置gname属性值
				ii.setOrid(map.get("ORID").toString());		//设置orid属性值
				al.add(ii);									//将此课程对象放进返回List中
			}
		}
		return al;	
	}
	
	public Vector getResOrderList(String sql){
		Vector al = new Vector();
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=0;i<rl.size();i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				Info_Item ii = new Info_Item();				//创建一个Info_Item对象			
				ii.setEnd(map.get("END").toString());		//设置end属性值
				ii.setStart(map.get("ST").toString());		//设置start属性值
				ii.setStatus(map.get("STATUS").toString());	//设置status属性值
				al.add(ii);									//将此课程对象放进返回List中
			}
		}
		return al;		
	}
	
	public Vector getGroupList(String sql){
		Vector al = new Vector();
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=0;i<rl.size();i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				GroupItem gi = new GroupItem();				//创建一个GroupItem 对象			
				gi.setGid(map.get("GID").toString());		//设置gid属性值
				gi.setGname(map.get("GNAME").toString());	//设置gname属性值
				al.add(gi);									//将此课程对象放进返回List中
			}
		}
		return al;	
	}
	
	public Vector getAdminList(String sql,int curPage,int span){
		Vector al = new Vector();
		int startRow = (curPage-1)*span;					//计算起始行数
		int endRow = startRow + span;						//计算结束行数		
		rl = jt.queryForList(sql);							//搜索得到结果
		if(rl.size()!=0){									//结果不为空的情况
			for(int i=startRow;i<rl.size()&&i<endRow;i++){	//遍历结果
				Map map=(Map)rl.get(i);						//结果List中每一行为一个LinkedHashMap
				Admin_Item ai = new Admin_Item();			//创建一个Admin_Item对象			
				ai.setAid(map.get("AID").toString());		//设置aid属性值
				ai.setAname(map.get("ANAME").toString());	//设置aname属性值
				ai.setAlevel(map.get("ALEVEL").toString().trim());	//设置alevel属性值
				al.add(ai);									//将此课程对象放进返回List中
			}
		}
		return al;
	}
	
	public String getStringInfo(String sql){
		String info = null;										//声明返回字符串引用
		try{
			info = (String)jt.queryForObject(sql,String.class);		//执行查询
		}
		catch(Exception e){
			info = null;
		}
		return info;											//返回查询结果
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
        		jt.update(v.get(i));								//执行更新       		
        	}
        	dtm.commit(ts);									//无异常发生则提交事务
       }
       catch(Exception e){
           dtm.rollback(ts);								//发生异常，进行回滚
           flag = false;									//更新标志设置为false
       }
		return flag;
	}
	
	public boolean update(String sql){						//执行单个SQL语句的方法
		boolean flag = false;
		int result = jt.update(sql);		//执行更新得到更新记录条数
		if(result>=0){						//更新记录条数大于一时
			flag = true;					//将更新结果标志置为true
		}
		return flag;						//返回更新结果标志位
	}
}