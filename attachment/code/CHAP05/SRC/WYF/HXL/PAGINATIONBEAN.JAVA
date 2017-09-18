package wyf.hxl;
import java.util.*;
public class PaginationBean
{
	private int totolPage=1;
	private int totolCount=0;
	private int showPage=1;
	private String sql="";
	private Map<String,Integer> cart = new HashMap<String,Integer>();

	public Map<String,Integer> getCart()
	{
		return cart;
	}

	public void setSql(String n)
	{
		this.sql=n;System.out.println("$$"+n);
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
	public void buy(String goodsid)
	{
		if(cart.containsKey(goodsid))
		{//用户不是第一次购买商品
			
			cart.put(goodsid,cart.get(goodsid)+1);//该种商品数量加1
		}
		else
		{//用户第一次购买
			cart.put(goodsid,1);
		}
	}
	public Vector<String[]> getCartContent()
	{
		Vector<String[]> vv = new Vector<String[]>();
		
		Set<String> goodsid = cart.keySet();//得到Map中的键值
		
		for(String str:goodsid)//得到各物品的信息
		{
			String[] a = new String[4];
			a[2] = str;
			//得到商品数量
			a[3] = cart.get(str).toString();
			try{
				str = new String(str.getBytes(),"ISO-8859-1");	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			//得到商品名称和价格
			String sql = "select goodsname,gprice from goodsmessage where goodsid='"+str+"'";
			Vector<String[]> vt = DB.getMessage(sql);
			String[] gmeg = vt.get(0);
			a[0] = gmeg[0];
			a[1] = gmeg[1];
			vv.add(a);
		}
		return vv;
	}
	public double getAccount()
	{
		double num = 0.00;
		//得到所买商品的信息
		Vector<String[]> ginfo = this.getCartContent();
		for(String[] str:ginfo)
		{//得到商品总价
			num += Double.parseDouble(str[3])*Double.parseDouble(str[1]);
		}
		//使商品保留两位小数
		num = Math.round(num*100)/100.00;
		return num;
	}
	
	public void removeItem(String goodsid)
	{ 
		try{
			goodsid= new String(goodsid.getBytes("iso-8859-1"),"gb2312");
			cart.remove(goodsid);
		}
		catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
	}
}