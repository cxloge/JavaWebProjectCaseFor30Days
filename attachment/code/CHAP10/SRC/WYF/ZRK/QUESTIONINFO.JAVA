package wyf.zrk;

import java.util.*;

public class QuestionInfo {
	private int q_id;
	private String q_title;
	private String q_content;
	private String q_flag;
	private int u_id;
	private Date q_time;
	
	public void setQ_id(int id) {
		this.q_id = id;
	}
	public int getQ_id() {
		return this.q_id;
	}
	public void setQ_title(String title) {
		this.q_title = title;
	}
	public String getQ_title() {
		return this.q_title;
	}
	public void setQ_content(String content) {
		this.q_content = content;
	}
	public String getQ_content() {
		return this.q_content;
	}
	public void setQ_flag(String flag) {
		this.q_flag = flag;
	}
	public String getQ_flag() {
		return this.q_flag;
	}
	public void setU_id(int id) {
		this.u_id = id;
	}
	public int getU_id() {
		return this.u_id;
	}
	public void setQ_time(Date q_time) {
		this.q_time = q_time;
	}
	public Date getQ_time() {
		return this.q_time;
	}
	
	
}