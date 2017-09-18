package wyf.zrk;

import java.util.*;

public class QuestionInfoBean {
	private DButilDAOImpl db;
	private UserLoginBean ulb;
	private InfoBean info;
	private String title;
	private String content;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	
	public String saveQuestion() {
		QuestionInfo qi = new QuestionInfo();
		try {
			qi.setQ_content(new String(this.content.getBytes(),"ISO-8859-1"));
			qi.setQ_title(new String(this.title.getBytes(),"ISO-8859-1"));
			qi.setQ_flag(new String("否".getBytes(),"ISO-8859-1"));
			qi.setU_id(this.ulb.getUser().getU_id());
			qi.setQ_time(new Date());			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String msg = db.insertObj("questioninfo",qi);
		
		if(msg.equals("yes")) {
			this.info.setMsg("恭喜您，问题提问成功！");
		}
		else if(msg.equals("no")) {
			this.info.setMsg("错误，问题提问失败！");
		}
		return "info";		
	}
	
	
	
}