package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class ComSalaryOpAction extends ActionSupport
{
	/*private Date salaryMonth;
	public void setSalaryMonth(Date salaryMonth)
	{
		this.salaryMonth=salaryMonth;
		System.out.println(this.salaryMonth);
	}
	public Date getSalaryMonth()
	{
		return this.salaryMonth;
	}*/
	private String salaryMonth;
	private String result;
	public String getResult()
	{
		String s=result;
		this.result="";
		return s;
	}
	@RequiredStringValidator(message="${getText(\"validate.salaryMontEM\")}")
	public void setSalaryMonth(String salaryMonth)
	{
		this.salaryMonth=salaryMonth;
		ActionContext.getContext().getSession().put("salaryMonth",salaryMonth);
	}
	public String getSalaryMonth()
	{
		return this.salaryMonth;
	}
	
	public String execute()
	{
		Date now=new Date();
		int year=now.getYear()+1900;
		int opyear=Integer.parseInt(salaryMonth.substring(0,4));
		if(year<opyear)
		{
			this.result="该月还未结束，不能发放！！！";
			return "fail";
		}
		int month=now.getMonth()+1;
		int opmonth=Integer.parseInt(salaryMonth.substring(5));
		if(opmonth>=month)
		{
			this.result="该月还未结束，不能发放！！！";
			return "fail";
		}
		return "success";
	}
}