package wyf.cgq;
import com.opensymphony.xwork2.*;
import java.util.*;
public class SalaryTableAction
{
	private double jiaBanFei=50;
	private double queQinFei=50;
	private double qingJiaFei=10;
	private int pageSpan=5;
	private List salaryList;
	
	private String departId="0000";
	private int currenPage=1;
	private int maxPage;
	private int totalMessage;
	public void setPageSpan(int pageSpan)
	{
		this.pageSpan=pageSpan;
		ActionContext.getContext().getSession().put("pageSpan",pageSpan);
		this.setCurrenPage(1);
	}
	public int getPageSpan()
	{
		Object obj=ActionContext.getContext().getSession().get("pageSpan");
		if(obj!=null)
		{
			this.pageSpan=(Integer)obj;
		}
		return this.pageSpan;
	}
	public Map getSpanList()
	{
		Map map=new HashMap();
		map.put(1,"每页1条");
		map.put(2,"每页2条");
		map.put(5,"每页5条");
		map.put(10,"每页10条");
		map.put(15,"每页15条");
		return map;
	}
	public void setDepartId(String departId)
	{
		this.departId=departId;
		ActionContext.getContext().getSession().put("departId",departId);
	}
	public String getDepartId()
	{
		Object obj=ActionContext.getContext().getSession().get("departId");
		if(obj!=null)
		{
			this.departId=(String)departId;
		}
		return this.departId;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.maxPage=totalMessage%pageSpan==0?(totalMessage/pageSpan):(totalMessage/pageSpan+1);
		return this.maxPage;
	}
	public void setCurrenPage(int currenPage)
	{
		this.currenPage=currenPage;
		//ActionContext.getContext().getSession().put("currenPage",currenPage);
	}
	public Map getDepartList()
	{
		Map map=ManageDB.getDepartList();
		map.put("0000","全部");
		return map;
	}
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public int getTotalMessage()
	{
		return totalMessage;
	}
	public List getSalaryList()
	{
		return salaryList;
	}
	public String execute()
	{
		this.pageSpan=this.getPageSpan();
		String salaryMonth=(String)(ActionContext.getContext().getSession().get("salaryMonth"));
		String year=salaryMonth.substring(0,4);
		String month=salaryMonth.substring(5);
		salaryList=ManageDB.getSalaryList(jiaBanFei,qingJiaFei,queQinFei,this.getDepartId(),year,month,currenPage,pageSpan);
		totalMessage=ManageDB.getSalaryTotalMessage(departId,year,month);
		return "success";
	}
}