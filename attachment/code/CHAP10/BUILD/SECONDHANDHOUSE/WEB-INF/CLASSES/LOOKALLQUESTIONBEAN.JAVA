package wyf.zrk;

import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;

public class LookAllQuestionBean {
	private DataModel dm = new ListDataModel();
	private DButilDAOImpl db;
	private QuestionDetailBean qdb;
	private boolean flag;
	private List<QuestionInfo> ls;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setQdb(QuestionDetailBean qdb) {
		this.qdb = qdb;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public String getInitList() {
		try {
			String hql = "from QuestionInfo as qi where qi.q_flag='·ñ' order by qi.q_time";
			hql = new String(hql.getBytes(),"ISO-8859-1");
			ls = (List<QuestionInfo>)db.getInfo(hql);
			if(ls.size()!=0) {
				this.flag = true;
			}
			else {
				this.flag = false;
			}
			for(QuestionInfo qi:ls) {
				qi.setQ_content(new String(qi.getQ_content().getBytes("ISO-8859-1"),"gbk"));
				qi.setQ_title(new String(qi.getQ_title().getBytes("ISO-8859-1"),"gbk"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public DataModel getQuestionObj() {
		this.dm.setWrappedData(ls);
		return dm;
	}
	
	public String getSelectObj() {
		QuestionInfo qi = (QuestionInfo)dm.getRowData();
		this.qdb.setQi(qi);
		return "detail";
	}
	
}