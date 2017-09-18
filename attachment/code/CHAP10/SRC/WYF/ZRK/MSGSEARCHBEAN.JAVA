package wyf.zrk;

import javax.faces.model.SelectItem;

public class MsgSearchBean {
	private String location;
	private String type;
	private String size;
	private String area;
	private String price;
	private AllRentInfoBean arib;
	private AllQiuGouInfoBean qgib;
	private AllSaleInfoBean asib;
	private AllQiuZuInfoBean qzib;
	
	public void setLocation(String location) {		
		if(location.equals("地区不限")) {
			this.location = "%";
		}
		else {
			try {
				this.location = new String(location.getBytes(),"ISO-8859-1");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String getLocation() {
		return this.location;
	}
	public void setType(String type) {
		if(type.equals("物业不限")) {
			this.type = "%";
		}
		else {
			try {
				this.type = new String(type.getBytes(),"ISO-8859-1");
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
	}
	public String getType()	{
		return this.type;
	}
	public void setSize(String size) {
		if(size.equals("户型不限")) {
			this.size = "%";
		}
		else {
			try {
				this.size = new String(size.getBytes(),"ISO-8859-1");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String getSize() {
		return this.size;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getArea() {
		return this.area;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice() {
		return this.price;
	} 
	public void setArib(AllRentInfoBean arib) {
		System.out.println("set the arib...");
		this.arib = arib;
	}
	public void setQgib(AllQiuGouInfoBean qgib) {
		System.out.println("set the qgib");
		this.qgib = qgib;
	}
	public void setQzib(AllQiuZuInfoBean qzib) {
		System.out.println("set the qiuzu ib./");
		this.qzib = qzib;
	}
	public void setAsib(AllSaleInfoBean asib) {
		System.out.println("set the sale info bean...");
		this.asib = asib;
	}
	
	public SelectItem[] getHouseLocation(){
		SelectItem[] si = new SelectItem[]{
			new SelectItem("地区不限","地区不限"),
			new SelectItem("路南区","路南区"),
			new SelectItem("路北区","路北区"),	
			new SelectItem("丰润区","丰润区"),
			new SelectItem("丰南区","丰南区"),
			new SelectItem("古冶区","古冶区"),
			new SelectItem("开平区","开平区"),
			new SelectItem("遵化市","遵化市"),
			new SelectItem("迁安市","迁安市"),
			new SelectItem("滦　县","滦　县"),
			new SelectItem("滦南县","滦南县"),
			new SelectItem("乐亭县","乐亭县"),
			new SelectItem("迁西县","迁西县"),
			new SelectItem("玉田县","玉田县"),
			new SelectItem("唐海县","唐海县")
		};
		return si;
	}
	
	public SelectItem[] getHouseType(){
		SelectItem[] si = new SelectItem[]{
			new SelectItem("物业不限","物业不限"),
			new SelectItem("普通住宅","普通住宅"),
			new SelectItem("公寓","公寓"),
			new SelectItem("别墅","别墅"),
			new SelectItem("商铺","商铺"),
			new SelectItem("商品房","商品房"),
			new SelectItem("其它","其它")
		};
		return si;
	}
	
	public SelectItem[] getHouseSize() {
		SelectItem[] si = new SelectItem[] {
			new SelectItem("户型不限","户型不限"),
			new SelectItem("单人间","单人间"),
			new SelectItem("一室一厅","一室一厅"),
			new SelectItem("两室一厅","两室一厅"),
			new SelectItem("两室两厅","两室两厅"),
			new SelectItem("三室一厅","三室一厅"),
			new SelectItem("三室二厅","三室二厅"),
			new SelectItem("四室一厅","四室一厅"),
			new SelectItem("四室二厅","四室二厅"),
			new SelectItem("五室一厅","五室一厅"),
			new SelectItem("五室二厅","五室二厅"),
			new SelectItem("别墅","别墅"),
			new SelectItem("厂房","厂房"),
			new SelectItem("门面房","门面房"),
			new SelectItem("仓库","仓库"),
			new SelectItem("车库","车库"),
			new SelectItem("其它","其它")
		};
		return si;
	}	
	
	public SelectItem[] getHouseArea(){
		SelectItem[] si = new SelectItem[] {
			new SelectItem("0-1000000","面积不限"),
			new SelectItem("0-50","50平米以下"),
			new SelectItem("50-70","50-70平米"),
			new SelectItem("70-90","70-90平米"),
			new SelectItem("90-110","90-110平米"),
			new SelectItem("110-130","110-130平米"),
			new SelectItem("130-150","130-150平米"),
			new SelectItem("150-1000000","150平米以上")
		};
		return si;
	}
	
	public SelectItem[] getHousePrice()	{
		SelectItem[] si = new SelectItem[] {
			new SelectItem("0-1000000","价格不限"),
			new SelectItem("0-60","60万元以下"),
			new SelectItem("60-80","60-80万元"),
			new SelectItem("80-100","80-100万元"),
			new SelectItem("100-120","100-120万元"),
			new SelectItem("120-150","120-150万元"),
			new SelectItem("150-200","150-200万元"),
			new SelectItem("200-1000000","200万元以上")
		};
		return si;
	}
	public SelectItem[] getMonthPrice() {
		SelectItem[] si = new SelectItem[] {
			new SelectItem("0-1000000","价格不限"),
			new SelectItem("0-300","300元以下/月"),
			new SelectItem("300-500","300-500元/月"),
			new SelectItem("500-800","500-800元/月"),
			new SelectItem("800-1000","800-1000元/月"),
			new SelectItem("1000-1000000","1000元以上/月")
		};
		return si;
	}
	
	
	public String chuZuSearch() {
		String hql = "";
		String pageHql = "";
		String[] housearea = this.area.split("-");
		String[] houseprice = this.price.split("-");
		try {
			hql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("出租".getBytes(),"ISO-8859-1")
						+"' and ri.r_location like '"+this.location
						+"' and ri.r_wuye like '"+this.type
						+"' and ri.r_type like '"+this.size
						+"' and ri.r_area>="+Integer.parseInt(housearea[0])
						+" and ri.r_area<="+Integer.parseInt(housearea[1])
						+" and ri.r_price>="+Integer.parseInt(houseprice[0])
						+" and ri.r_price<="+Integer.parseInt(houseprice[1])
						+" order by ri.r_publishtime desc";
			pageHql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("出租".getBytes(),"ISO-8859-1")
						+"' and ri.r_location like '"+this.location
						+"' and ri.r_wuye like '"+this.type
						+"' and ri.r_type like '"+this.size
						+"' and ri.r_area>="+Integer.parseInt(housearea[0])
						+" and ri.r_area<="+Integer.parseInt(housearea[1])
						+" and ri.r_price>="+Integer.parseInt(houseprice[0])
						+" and ri.r_price<="+Integer.parseInt(houseprice[1]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.arib.setHql(hql);
		this.arib.setNowPage(1);
		this.arib.setPageHql(pageHql);
		return "allrentinfo";
	}
	
	public String qiuZuSearch() {
		String hql = "";
		String pageHql = "";
		String[] housearea = this.area.split("-");
		String[] houseprice = this.price.split("-");
		try {
			hql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("求租".getBytes(),"ISO-8859-1")
						+"' and ri.r_location like '"+this.location
						+"' and ri.r_wuye like '"+this.type
						+"' and ri.r_type like '"+this.size
						+"' and ri.r_area>="+Integer.parseInt(housearea[0])
						+" and ri.r_area<="+Integer.parseInt(housearea[1])
						+" and ri.r_price>="+Integer.parseInt(houseprice[0])
						+" and ri.r_price<="+Integer.parseInt(houseprice[1])
						+" order by ri.r_publishtime desc";
			pageHql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("求租".getBytes(),"ISO-8859-1")
						+"' and ri.r_location like '"+this.location
						+"' and ri.r_wuye like '"+this.type
						+"' and ri.r_type like '"+this.size
						+"' and ri.r_area>="+Integer.parseInt(housearea[0])
						+" and ri.r_area<="+Integer.parseInt(housearea[1])
						+" and ri.r_price>="+Integer.parseInt(houseprice[0])
						+" and ri.r_price<="+Integer.parseInt(houseprice[1]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.qzib.setHql(hql);
		this.qzib.setNowPage(1);
		this.qzib.setPageHql(pageHql);
		return "allqiuzuinfo";
	}
	
	public String chuShouSearch() {
		String hql = "";
		String pageHql = "";
		String[] housearea = this.area.split("-");
		String[] houseprice = this.price.split("-");
		try {
			hql = "from SaleInfo as si where si.s_msgtype='"
						+new String("出售".getBytes(),"ISO-8859-1")
						+"' and si.s_location like '"+this.location
						+"' and si.s_wuye like '"+this.type
						+"' and si.s_type like '"+this.size
						+"' and si.s_area>="+Integer.parseInt(housearea[0])
						+" and si.s_area<="+Integer.parseInt(housearea[1])
						+" and si.s_price>="+Integer.parseInt(houseprice[0])
						+" and si.s_price<="+Integer.parseInt(houseprice[1])
						+" order by si.s_publishtime desc";
			pageHql = "from SaleInfo as si where si.s_msgtype='"
						+new String("出售".getBytes(),"ISO-8859-1")
						+"' and si.s_location like '"+this.location
						+"' and si.s_wuye like '"+this.type
						+"' and si.s_type like '"+this.size
						+"' and si.s_area>="+Integer.parseInt(housearea[0])
						+" and si.s_area<="+Integer.parseInt(housearea[1])
						+" and si.s_price>="+Integer.parseInt(houseprice[0])
						+" and si.s_price<="+Integer.parseInt(houseprice[1]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.asib.setHql(hql);
		this.asib.setNowPage(1);
		this.asib.setPageHql(pageHql);
		return "allsaleinfo";
	}
	
	public String qiuGouSearch() {
		String hql = "";
		String pageHql = "";
		String[] housearea = this.area.split("-");
		String[] houseprice = this.price.split("-");
		try {
			hql = "from SaleInfo as si where si.s_msgtype='"
						+new String("求购".getBytes(),"ISO-8859-1")
						+"' and si.s_location like '"+this.location
						+"' and si.s_wuye like '"+this.type
						+"' and si.s_type like '"+this.size
						+"' and si.s_area>="+Integer.parseInt(housearea[0])
						+" and si.s_area<="+Integer.parseInt(housearea[1])
						+" and si.s_price>="+Integer.parseInt(houseprice[0])
						+" and si.s_price<="+Integer.parseInt(houseprice[1])
						+" order by si.s_publishtime desc";
			pageHql = "from SaleInfo as si where si.s_msgtype='"
						+new String("求购".getBytes(),"ISO-8859-1")
						+"' and si.s_location like '"+this.location
						+"' and si.s_wuye like '"+this.type
						+"' and si.s_type like '"+this.size
						+"' and si.s_area>="+Integer.parseInt(housearea[0])
						+" and si.s_area<="+Integer.parseInt(housearea[1])
						+" and si.s_price>="+Integer.parseInt(houseprice[0])
						+" and si.s_price<="+Integer.parseInt(houseprice[1]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.qgib.setHql(hql);
		this.qgib.setNowPage(1);
		this.qgib.setPageHql(pageHql);
		return "allqiugouinfo";
	}
	
}