package wyf.zrk;

import java.util.*;
import javax.faces.model.*;

public class MyQuestionBean {
	private DataModel dm = new ListDataModel();
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private MyQuestionDetailBean mqdb;
	private List<QuestionInfo> list;
	private boolean flag;
	
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setMqdb(MyQuestionDetailBean mqdb) {
		this.mqdb = mqdb;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public String getInitList() {
		list = getMyQuestion();
		if(list.size()!=0) {
			flag = true;
		}
		else {
			flag = false;
		}
		return "";
	}
	
	public List<QuestionInfo> getMyQuestion() {
		String hql = "from QuestionInfo as qi where qi.u_id="
							+ulb.getUser().getU_id();
		List<QuestionInfo> ls = (List<QuestionInfo>)db.getInfo(hql);
		try {
			for(QuestionInfo qi:ls) {
				qi.setQ_title(new String(qi.getQ_title().getBytes("ISO-8859-1"),"gbk"));
				qi.setQ_content(new String(qi.getQ_content().getBytes("ISO-8859-1"),"gbk"));
				qi.setQ_flag(new String(qi.getQ_flag().getBytes("ISO-8859-1"),"gbk"));
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public DataModel getQuestionList() {
		this.dm.setWrappedData(list);
		return dm;	
	}
	
	public String getSelectObj() {
		this.mqdb.setQi((QuestionInfo)dm.getRowData());		
		return "myquestiondetail";
	}
	
	public void deleteSelectObj() {
		QuestionInfo qi = (QuestionInfo)dm.getRowData();
		String msg = db.deleteObj("questioninfo",qi);
	}
	
}