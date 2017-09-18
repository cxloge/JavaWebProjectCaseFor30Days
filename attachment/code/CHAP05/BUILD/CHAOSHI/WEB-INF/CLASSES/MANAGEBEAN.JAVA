package wyf.hxl;
import java.util.*;
public class ManageBean
{
	private int totolPage=1;
	private int totolCount=0;
	private int showPage=1;
	private String sql="";
	private static int quantity=2;
	public static void setQuantity(int n)
	{
		quantity=n;
	}
	public static int getQuantity()
	{
		return quantity;
	}	
	public void setSql(String n)
	{
		this.sql=n;
	}
	public String getSql()
	{
		return sql;
	}
	public void setTotolCount(int n)
	{
		this.totolCount=n;
	}
	public int getTotolCount()
	{
		return totolCount;
	}

	public void setTotolPage(int n)
	{
		this.totolPage=n;
	}
	public int getTotolPage()
	{
		return this.totolPage;
	}
	public void setShowPage(int n)
	{
		this.showPage=n;
	}
	public int getShowPage()
	{
		return this.showPage;
	}
	
}