package wyf.zrk;

import java.util.*;

public class AnswerInfo {
	private int ai_id;
	private int q_id;
	private String ai_content;
	private Date ai_time;
	
	public void setAi_id(int ai_id) {
		this.ai_id = ai_id;
	}
	public int getAi_id() {
		return this.ai_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public int getQ_id() {
		return this.q_id;
	}
	public void setAi_content(String ai_content) {
		this.ai_content = ai_content;
	}
	public String getAi_content() {
		return this.ai_content;
	}
	public void setAi_time(Date ai_time) {
		this.ai_time = ai_time;
	}
	public Date getAi_time() {
		return this.ai_time;
	}
	
	
}