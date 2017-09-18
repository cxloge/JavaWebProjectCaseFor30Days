package wyf.zrk;

import java.util.*;

public class AdminIndexBean {
	private DButilDAOImpl db;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	
	public int getLookHouseCount() {
		int count = 0;
		try {
			String hql = "from RelationToUserAndMsg as rt where rt.r_agree='"+
							new String("·ñ".getBytes(),"ISO-8859-1")+"'";
			List<RelationToUserAndMsg> ls = (List<RelationToUserAndMsg>)db.getInfo(hql);
			count = ls.size();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return count;
	}
	public int getLookQuestionCount() {
		int count = 0;
		try {
			String hql = "from QuestionInfo as qi where qi.q_flag='"+
							new String("·ñ".getBytes(),"ISO-8859-1")+"'";
			List ls = db.getInfo(hql);
			count = ls.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
}