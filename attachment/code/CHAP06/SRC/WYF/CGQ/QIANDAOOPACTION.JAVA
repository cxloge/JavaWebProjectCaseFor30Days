package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class QianDaoOpAction extends ActionSupport
{
	private Date opDate;
	private String result;
	public String getResult()
	{
		return this.result;
	}
	@RequiredFieldValidator(message="${getText(\"validate.qiandaoEM\")}")
	public void setOpDate(Date opDate)
	{
		System.out.println(opDate+"==============================");
		this.opDate=opDate;
		ActionContext.getContext().getSession().put("opdate",opDate);
	}
	public Date getOpDate()
	{
		return this.opDate;
	}
	public String execute()
	{
		Date now=new Date();
		this.opDate=(Date)(ActionContext.getContext().getSession().get("opdate"));
		System.out.println(opDate);
		if(opDate.after(now))
		{
			System.out.println("日期太大");
			this.result="你选择的日期大于当天时间，请重新选择";
			return "fail";
		}
		else
		{
			return "success";
		}
		
	}
}