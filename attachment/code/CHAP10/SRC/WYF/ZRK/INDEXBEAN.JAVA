package wyf.zrk;

import javax.faces.event.*;
import javax.faces.model.*;
import java.util.*;

public class IndexBean {
	private UserLoginBean userLoginBean;
	private DButilDAOImpl db;
	private ShowRentMsgBean srmb;
	private ShowSaleMsgBean ssmb;
	private AllRentInfoBean arib;
	private AllQiuGouInfoBean qgib;
	private AllSaleInfoBean asib;
	private AllQiuZuInfoBean qzib;
	private boolean qiuZuShow;
	private boolean rentShow;
	private boolean qiuGouShow;
	private boolean saleShow;
	private List<SaleInfo> saleList;
	private List<SaleInfo> qiuGouList;
	private List<RentInfo> rentList;
	private List<RentInfo> qiuZuList;
	
	public String getInitList() {
		saleList = this.getSale("出售");
		qiuGouList = this.getSale("求购");
		rentList = this.getRent("出租");
		qiuZuList = this.getRent("求租");
		if(saleList.size()!=0) {
			saleShow = true;
		}
		if(qiuGouList.size()!=0) {
			qiuGouShow = true;
		}
		if(rentList.size()!=0) {
			rentShow = true;
		}
		if(qiuZuList.size()!=0) {
			qiuZuShow = true;
		}
		return "";
	}
	
	public boolean isQiuZuShow() {
		return this.qiuZuShow;
	}
	public boolean isRentShow() {
		return this.rentShow;
	}
	public boolean isQiuGouShow() {
		return this.qiuGouShow;
	}
	public boolean isSaleShow() {
		return this.saleShow;
	}	
	public void setUserLoginBean(UserLoginBean ulb){
		this.userLoginBean = ulb;
	}
	public UserLoginBean getUserLoginBean(){
		return this.userLoginBean;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setSrmb(ShowRentMsgBean srmb) {
		this.srmb = srmb;
	}
	public ShowRentMsgBean getSrmb() {
		return this.srmb;
	}
	public void setSsmb(ShowSaleMsgBean ssmb) {
		this.ssmb = ssmb;
	}
	public ShowSaleMsgBean getSsmb() {
		return this.ssmb;
	}
	public void setArib(AllRentInfoBean arib) {
		this.arib = arib;
	}
	public void setQgib(AllQiuGouInfoBean qgib) {
		this.qgib = qgib;
	}
	public void setQzib(AllQiuZuInfoBean qzib) {
		this.qzib = qzib;
	}
	public void setAsib(AllSaleInfoBean asib) {
		this.asib = asib;
	}	
	public String logout(){
		boolean flag = userLoginBean.isFlag();
		if(flag){
			userLoginBean.setFlag(false);
		}
		return "logout";
	}
	
	public List<SaleInfo> getSale(String type) {	
		String hql = "";
		try {
			hql = "from SaleInfo as si where si.s_msgtype='"
						+new String(type.getBytes(),"ISO-8859-1")+"' order by si.s_publishtime desc";		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<SaleInfo> ls = (List<SaleInfo>)db.getInfo(hql);
		List<SaleInfo> list = new ArrayList<SaleInfo>();
		try {
			for(int i=0;i<ls.size()&&i<5;i++){
				SaleInfo si = ls.get(i);
				si.setS_msgtype(new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk"));
				si.setS_location(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
				si.setS_type(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
				si.setS_wuye(new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk"));
				list.add(si);
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	public List<RentInfo> getRent(String type) {
		String hql = "";
		try {
			hql = "from RentInfo ri where ri.r_msgtype='"+
					new String(type.getBytes(),"ISO-8859-1")+"' order by ri.r_publishtime desc";			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<RentInfo> ls = (List<RentInfo>)db.getInfo(hql);
		List<RentInfo> list = new ArrayList<RentInfo>();
		try {
			for(int i=0;i<5&&i<ls.size();i++) {
				RentInfo ri = ls.get(i);
				ri.setR_msgtype(new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_location(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_type(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_wuye(new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk"));
				list.add(ri);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
	private DataModel saleModel;
	private DataModel rentModel;
	private DataModel qiuGouModel;
	private DataModel qiuZuModel;
	
	public DataModel getSaleList() {
		if(saleModel==null) {
			saleModel = new ListDataModel();			
		}
		saleModel.setWrappedData(this.saleList);
		return saleModel;		
	}	
	public DataModel getQiuGouList() {
		if(qiuGouModel==null) {
			qiuGouModel = new ListDataModel();
		}
		qiuGouModel.setWrappedData(this.qiuGouList);
		return qiuGouModel;
	}
	public DataModel getRentList() {
		if(rentModel==null) {
			rentModel = new ListDataModel();
		}
		rentModel.setWrappedData(this.rentList);
		return rentModel;
	}
	public DataModel getQiuZuList() {
		if(qiuZuModel==null) {
			qiuZuModel = new ListDataModel();
		}
		qiuZuModel.setWrappedData(this.qiuZuList);
		return qiuZuModel;
	}
	
	public String getSelectRentObj() {
		this.srmb.setRi((RentInfo)rentModel.getRowData());
		return "rent";
	}
	
	public String getSelectQiuZuObj() {
		this.srmb.setRi((RentInfo)qiuZuModel.getRowData());
		return "qiuzu";
	}
	
	public String getSelectSaleObj() {
		this.ssmb.setSi((SaleInfo)saleModel.getRowData());
		return "sale";
	}	
	
	public String getSelectQiuGouObj() {
		this.ssmb.setSi((SaleInfo)qiuGouModel.getRowData());
		return "qiugou";
	}
	
	public String allQiuGouInfo() {
		String hql = "";
		String pageHql = "";
		try {
			pageHql = "from SaleInfo as si where si.s_msgtype='"+
						new String("求购".getBytes(),"ISO-8859-1")+"'";
			hql = "from SaleInfo as si where si.s_msgtype='"
						+new String("求购".getBytes(),"ISO-8859-1")+"' order by si.s_publishtime desc";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.qgib.setHql(hql);
		this.qgib.setNowPage(1);
		this.qgib.setPageHql(pageHql);
		return "allqiugouinfo";
	}
	
	public String allSaleInfo() {
		String hql = "";
		String pageHql = "";
		try {
			pageHql = "from SaleInfo as si where si.s_msgtype='"+
						new String("出售".getBytes(),"ISO-8859-1")+"'";
			hql = "from SaleInfo as si where si.s_msgtype='"
						+new String("出售".getBytes(),"ISO-8859-1")+"' order by si.s_publishtime desc";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.asib.setHql(hql);
		this.asib.setNowPage(1);
		this.asib.setPageHql(pageHql);
		return "allsaleinfo";
	}
	
	public String allQiuZuInfo() {
		String hql = "";
		String pageHql = "";
		try {
			hql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("求租".getBytes(),"ISO-8859-1")+"' order by ri.r_publishtime desc";	
			pageHql = "from RentInfo as ri where ri.r_msgtype='"+
						new String("求租".getBytes(),"ISO-8859-1")+"'";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.qzib.setHql(hql);
		this.qzib.setNowPage(1);
		this.qzib.setPageHql(pageHql);
		return "allqiuzuinfo";
	}
	
	public String allRentInfo() {
		String hql = "";
		String pageHql = "";
		try {
			hql = "from RentInfo as ri where ri.r_msgtype='"
						+new String("出租".getBytes(),"ISO-8859-1")+"' order by ri.r_publishtime desc";
			pageHql = "from RentInfo as ri where ri.r_msgtype='"+
						new String("出租".getBytes(),"ISO-8859-1")+"'";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.arib.setHql(hql);
		this.arib.setNowPage(1);
		this.arib.setPageHql(pageHql);
		return "allrentinfo";
	}
	
	
	
}