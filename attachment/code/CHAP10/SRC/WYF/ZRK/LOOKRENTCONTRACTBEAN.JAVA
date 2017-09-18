package wyf.zrk;

import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;

public class LookRentContractBean {
	private DataModel dm = new ListDataModel();
	private DButilDAOImpl db;
	private List<ContractRentInfo> list;
	private boolean flag;
	private int nowPage = 1;
	private int totalPage;
	private int span = 10;
	private String hql;
	private String pageHql;
	private ModifyRentContractBean mrcb;
	
	public void setMrcb(ModifyRentContractBean mrcb) {
		this.mrcb = mrcb;
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
		hql = "from ContractRentInfo";
		pageHql = "from ContractRentInfo";
		this.list = (List<ContractRentInfo>)db.getPageList(this.span,this.nowPage,hql);
		this.totalPage = db.getTotalPage(pageHql,this.span);
		if(this.list.size()!=0) {
			this.flag = true;
		}
		else {
			this.flag = false;
		}
		try {
			for(ContractRentInfo cri:list) {
				cri.setCr_address(new String(cri.getCr_address().getBytes("ISO-8859-1"),"gbk"));
				cri.setCr_first(new String(cri.getCr_first().getBytes("ISO-8859-1"),"gbk"));
				cri.setCr_firstagent(new String(cri.getCr_firstagent().getBytes("ISO-8859-1"),"gbk"));
				cri.setCr_second(new String(cri.getCr_second().getBytes("ISO-8859-1"),"gbk"));
				cri.setCr_secondagent(new String(cri.getCr_secondagent().getBytes("ISO-8859-1"),"gbk"));
				cri.setCr_state(new String(cri.getCr_state().getBytes("ISO-8859-1"),"gbk"));
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
		ContractRentInfo cri = (ContractRentInfo)dm.getRowData();
		this.mrcb.setCri(cri);		
		return "modify";
	}
	
	
	
	
	
	
}