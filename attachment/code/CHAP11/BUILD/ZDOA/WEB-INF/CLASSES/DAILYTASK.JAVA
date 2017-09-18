package wyf.cgq;
import java.util.*;
public class DailyTask extends TimerTask{
	private InsertDB insertDB;//声明InsertDB的引用
	private SearchDB searchDB;//声明SearchDB的引用
	public void setInsertDB(InsertDB insertDB){//InsertDB的setter方法
		this.insertDB=insertDB;	}
	public void setSearchDB(SearchDB searchDB){//SearchDB的setter方法
		this.searchDB=searchDB;	}
	public void run(){//重写的run方法
		Date d=new Date();//获得当前时间
		String strmonth="";
		String strdate="";
		int year=d.getYear()+1900;//获得年
		int month=d.getMonth()+1;//获得月
		if(month<10){strmonth=0+""+month;	}//组织月的字符串
		else{strmonth=month+"";	}
		int date=d.getDate();//获得天
		if(date<10){strdate=0+""+date;	}
		else{strdate=date+"";	}//组织天的字符串
		String sql="select * from oa_attinfo where to_char(att_time,'YYYY-MM-DD')='"+
					year+"-"+strmonth+"-"+strdate+"'";//组织查询的sql
		List list=this.searchDB.getArrayList(sql);//进行查询
		if(list.size()==0){//如果查到0条记录
			String sql1="insert into oa_attinfo(att_user) select user_number from oa_user";
			this.insertDB.update(sql1);//插入新的记录
		}	}}