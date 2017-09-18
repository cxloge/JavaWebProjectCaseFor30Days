package wyf.zrk;

import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;

public class LookSaleContractBean {
	private DataModel dm = new ListDataModel();
	private DButilDAOImpl db;
	private List<ContractSaleInfo> list;
	private boolean flag;
	private int nowPage = 1;
	private int totalPage;
	private int span = 10;
	private String hql;
	private String pageHql;
	private ModifySaleContractBean mscb;
	
	public void setMscb(ModifySaleContractBean mscb) {
		this.mscb = mscb;
	}
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public void setPageHql(String pageHql) {
		this.pageHql = pageHql;
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
	public int getTotalPage() {
		return this.totalPage;
	}
	public String getInitList() {
		System.out.println("init the list");
		hql = "from ContractSaleInfo";
		pageHql = "from ContractSaleInfo";
		this.list = (List<ContractSaleInfo>)db.getPageList(this.span,this.nowPage,hql);
		this.totalPage = db.getTotalPage(pageHql,this.span);
		if(this.list.size()!=0) {
			this.flag = true;
		}
		else {
			this.flag = false;
		}
		try {
			for(ContractSaleInfo csi:list) {
				csi.setCs_first(new String(csi.getCs_first().getBytes("ISO-8859-1"),"gbk"));
				csi.setCs_second(new String(csi.getCs_second().getBytes("ISO-8859-1"),"gbk"));
				csi.setCs_state(new String(csi.getCs_state().getBytes("ISO-8859-1"),"gbk"));
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
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
	public String modifyState() {
		ContractSaleInfo csi = (ContractSaleInfo)dm.getRowData();
		this.mscb.setCsi(csi);
		return "modify";
	}
	
	
	
	
	
	
}