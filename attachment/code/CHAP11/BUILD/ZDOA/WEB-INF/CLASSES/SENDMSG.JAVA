package wyf.cgq;
import java.util.*;
public class SendMsg{
	private String number;
	private String fromU;
	private String toU;
	private String info;
	private String content;
	private Date time;
	private String time2;
	private String fromUName;
	public SendMsg(){
	}
	public SendMsg(String content, String fromU, String info, String number,
			Date time, String toU) {
		this.content = content;
		this.fromU = fromU;
		this.info = info;
		this.number = number;
		this.time = time;
		this.toU = toU;
	}
	public SendMsg(String number,String fromUName,String info,String time2){
		this.number=number;
		this.fromUName=fromUName;
		this.info=info;
		this.time2=time2;
	}
	public SendMsg(String number,String fromUName,String info,String content,String time2){
		this.number=number;
		this.fromUName=fromUName;
		this.info=info;
		this.content=content;
		this.time2=time2;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFromU() {
		return fromU;
	}
	public void setFromU(String fromU) {
		this.fromU = fromU;
	}
	public String getToU() {
		return toU;
	}
	public void setToU(String toU) {
		this.toU = toU;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public void setFromUName(String fromUName){
		this.fromUName=fromUName;
	}
	public String getFromUName(){
		return this.fromUName;
	}
}
