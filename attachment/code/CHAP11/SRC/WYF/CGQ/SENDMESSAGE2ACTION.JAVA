package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;

public class SendMessage2Action extends SendMessageAction{
	private InsertDB insertDB;
	private String receiver;
	private String info;
	private String content;
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
	}
	public void setInfo(String info){
		this.info=info;
	}
	public void setReceiver(String receiver){
		this.receiver=receiver;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String execute(){
		SendMsg msg=new SendMsg();
		msg.setToU(this.receiver.trim());
		msg.setFromU((String)this.getSession().get("user"));
		msg.setInfo(this.info);
		msg.setContent(this.content);
		msg.setTime(new Date());
		this.insertDB.saveMsg(msg);
		return "success";
	}
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}