package wyf.zrk;

import java.util.*;

public class QuestionDetailBean {
	private DButilDAOImpl db;
	private QuestionInfo qi;
	private InfoBean info;
	private String title;
	private String content;
	private String uname;
	private Date qtime;
	private String answer;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setQi(QuestionInfo qi) {
		this.qi = qi;
	}
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public String getTitle() {
		return this.qi.getQ_title();
	}
	public String getContent() {
		return this.qi.getQ_content();
	}
	public String getUname() {
		String name = "";
		String hql = "from UserInfo as ui where ui.u_id="+qi.getU_id();
		List<UserInfo> ls = (List<UserInfo>)db.getInfo(hql);
		UserInfo ui = ls.get(0);
		try {
			name = new String(ui.getU_name().getBytes("ISO-8859-1"),"gbk");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	public Date getQtime() {
		return this.qi.getQ_time();
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer() {
		return this.answer;
	}
	
	public String adminAnswer() {
		try {
			AnswerInfo ai = new AnswerInfo();
			ai.setQ_id(this.qi.getQ_id());
			ai.setAi_content(new String(answer.getBytes(),"ISO-8859-1"));
			ai.setAi_time(new Date());
			String msg = db.insertObj("answerinfo",ai);
			qi.setQ_flag(new String("是".getBytes(),"ISO-8859-1"));
			String ms = db.updateObj("questioninfo",qi);
			info.setUrl("AdminIndex.jsp");
			if(msg.equals("yes")&&ms.equals("yes")) {
				info.setMsg("恭喜您，信息回复成功！");
			}
			else {
				info.setMsg("Sorry，信息回复失败！");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "info";
	}
	
	
}