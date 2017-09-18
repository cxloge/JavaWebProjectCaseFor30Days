package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class MainManageAction extends ActionSupport{
	private SearchDB searchDB;//声明SearchDB的引用
	private int zongjingli=0;//用于表示总经理室紧急事务个数
	private int shichang=0;//用于表示市场部紧急事务个数
	private int jishu=0;//用于表示技术部紧急事务个数
	private int gongguan=0;//用于表示公关部紧急事务个数
	private int caiwu=0;//用于表示财务部紧急事务个数
	private int houqin=0;//用于表示后勤部紧急事务个数
	public void setSearchDB(SearchDB searchDB)
	{this.searchDB=searchDB;}//用于注入searchDB的方法
	public int getZongjingli(){return this.zongjingli;}//zongjingli的getter方法
	public int getShichang(){return this.shichang;}//shichang的getter方法
	public int getJishu(){return this.jishu;}//jishu的getter方法
	public int getGongguan(){return this.gongguan;}//gongguan的getter方法
	public int getCaiwu(){return this.caiwu;}//caiwu的getter方法
	public int getHouqin(){return this.houqin;}//houqin的getter方法
	public int getTotal(){//total的getter方法
		return this.zongjingli+this.shichang+this.jishu+this.gongguan+this.caiwu+this.houqin;
	}
	public int getRight(){//right的getter方法
		return (Integer)ActionContext.getContext().getSession().get("right");
	}
	public String execute(){
		String sql="select alarm_dept,count(*) from oa_alarm where alarm_state=0 group by alarm_dept";
		List list=this.searchDB.getArrayList(sql);//调用getArrayList获得搜索的列表
		int size=list.size();//获得列表大小
		for(int i=0;i<size;i++){//遍历列表
			Object[] o=(Object[])list.get(i);//获得列表中的一个对象
			String deptnumber=(String)o[0];//获得部门的编号
			if(deptnumber.equals("10000")){//如果是1000说明是总经理室
				zongjingli=((java.math.BigDecimal)o[1]).intValue();
			}
			else if(deptnumber.equals("10001")){//如果是10001说明是市场部
				shichang=((java.math.BigDecimal)o[1]).intValue();
			}
			else if(deptnumber.equals("10002")){//如果是10002说明是技术部
				jishu=((java.math.BigDecimal)o[1]).intValue();
			}
			else if(deptnumber.equals("10003")){//如果是10003说明是公关部
				gongguan=((java.math.BigDecimal)o[1]).intValue();
			}
			else if(deptnumber.equals("10004")){//如果是10004说明是财务部
				caiwu=((java.math.BigDecimal)o[1]).intValue();
			}
			else if(deptnumber.equals("10005")){//如果是10005说明是后勤部
				houqin=((java.math.BigDecimal)o[1]).intValue();
			}
		}
		return "success";
	}
}