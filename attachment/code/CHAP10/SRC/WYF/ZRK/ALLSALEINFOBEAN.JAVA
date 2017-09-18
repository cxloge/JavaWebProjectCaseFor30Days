package wyf.zrk;

import javax.faces.model.*;
import java.util.*;

public class AllSaleInfoBean {
	private DButilDAOImpl db;
	private int nowPage = 1;
	private DataModel dm = new ListDataModel();
	private int totalPage;
	private int span = 10;
	private ShowSaleMsgBean ssmb;
	private String hql;
	private String pageHql;
	private boolean showList;
	private List<SaleInfo> list;
	
	public boolean isShowList() {
		return this.showList;
	}
	
	public void setHql(String hql) {
		this.hql = hql;
	}
	public void setPageHql(String pageHql) {
		this.pageHql = pageHql;
	}
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setSpan(int span) {
		this.span = span;
	}
	public int getSpan() {
		return this.span;
	}
	public int getNowPage() {
		return this.nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public void setSsmb(ShowSaleMsgBean ssmb) {
		this.ssmb = ssmb;
	}
	public ShowSaleMsgBean getSsmb() {
		return this.ssmb;
	}
	public int getTotalPage() {
		this.totalPage = db.getTotalPage(pageHql,this.span);		
		return this.totalPage;
	}
	public String getInitList() {
		this.list = (List<SaleInfo>)db.getPageList(this.span,this.nowPage,hql);
		if(this.list.size()!=0) {
			this.showList = true;
		}
		else {
			this.showList = false;
		}
		for(SaleInfo si:list) {
			try {
				si.setS_msgtype(new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk"));
				si.setS_location(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
				si.setS_type(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
				si.setS_wuye(new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk"));				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	public DataModel getObjList() {
		this.dm.setWrappedData(list);
		return dm;		
	}
	
	public void nextPage() {
		if(this.nowPage<this.getTotalPage()) {
			this.nowPage++;
		}
		System.out.println(this.nowPage);
	}
	public void prePage() {
		if(this.nowPage>1) {
			this.nowPage--;
		}
		System.out.println(this.nowPage);
	}
	
	public String getSelectSaleObj() {
		this.ssmb.setSi((SaleInfo)dm.getRowData());
		return "sale";		
	}
}