package wyf.zrk;

import java.util.*;

public class MyQuestionDetailBean {
	private AnswerInfo ai;
	private QuestionInfo qi;
	private DButilDAOImpl db;
	private UserLoginBean ulb;
	private String content;
	private String publishTime;
	private String answerTime;
	private boolean flag;
	private String answerContent;
	
	public void setQi(QuestionInfo qi) {
		this.qi = qi;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public String getContent() {
		return this.qi.getQ_content();
	}
	public String getPublishTime() {
		return this.qi.getQ_time().toString().substring(0,10);
	}
	public String getAnswerTime() {
		return this.ai.getAi_time().toString().substring(0,10);
	}
	public boolean getFlag() {
		return this.flag;
	}
	public String getAnswerContent() {
		String msg = this.ai.getAi_content();
		try {
			msg = new String(msg.getBytes("ISO-8859-1"),"gbk");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public String getInitList() {
		String hql = "from AnswerInfo as ai where ai.q_id="+qi.getQ_id();
		List<AnswerInfo> ls = (List<AnswerInfo>)db.getInfo(hql);
		if(ls.size()!=0) {
			this.ai = ls.get(0);
			this.flag = true;
		}
		else {
			this.flag = false;
		}
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}