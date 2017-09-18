package wyf.zrk;

import javax.faces.model.*;
import java.util.*;

public class AllRentInfoBean {
	private DButilDAOImpl db;
	private int nowPage = 1;
	private DataModel dm = new ListDataModel();
	private int totalPage;
	private int span = 2;
	private ShowRentMsgBean srmb;
	private String hql;
	private String pageHql;
	private boolean showList;
	private List<RentInfo> list;
	
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
	public void setSrmb(ShowRentMsgBean srmb) {
		this.srmb = srmb;
	}
	public ShowRentMsgBean getSrmb() {
		return this.srmb;
	}
	public int getTotalPage() {
		this.totalPage = db.getTotalPage(pageHql,this.span);		
		return this.totalPage;
	}
	public String getInitList() {
		this.list = (List<RentInfo>)db.getPageList(this.span,this.nowPage,hql);
		if(this.list.size()!=0) {
			this.showList = true;
		}
		else {
			this.showList = false;
		}
		for(RentInfo ri:list) {
			try {
				ri.setR_msgtype(new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_location(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_type(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_wuye(new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk"));				
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
	}
	public void prePage() {
		if(this.nowPage>1) {
			this.nowPage--;
		}
	}
	
	public String getSelectRentObj() {
		this.srmb.setRi((RentInfo)dm.getRowData());
		return "rent";		
	}
}