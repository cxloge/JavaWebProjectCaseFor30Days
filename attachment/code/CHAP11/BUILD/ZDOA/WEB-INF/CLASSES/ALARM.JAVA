package wyf.cgq;
import java.util.*;
public class Alarm{
	private String number;
	private String fromuser;
	private String title;
	private String detail;
	private Date time;
	private String deptNumber;
	
	private String fromuserName;
	private int state;
	private String deptName;
	public Alarm(){
	}
	public Alarm(String detail, String fromuser, String number, Date time,
			String title,String deptNumber) {
		super();
		this.detail = detail;
		this.fromuser = fromuser;
		this.number = number;
		this.time = time;
		this.title = title;
		this.deptNumber=deptNumber;
	}
	public Alarm(String number,int state,String title,String deptName,Date time,String fromuserName){
		this.number=number;
		this.state=state;
		this.title=title;
		this.deptName=deptName;
		this.fromuserName=fromuserName;
		this.time=time;
	}
	public Alarm(String title,Date time,String fromuserName,String deptName,String detail){
		this.title=title;
		this.deptName=deptName;
		this.fromuserName=fromuserName;
		this.time=time;
		this.detail=detail;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setDeptNumber(String deptNumber){
		this.deptNumber=deptNumber;
	}
	public String getDeptNumber(){
		return this.deptNumber;
	}
	public String getDeptName(){
		return this.deptName;
	}
	public String getFromuserName(){
		return this.fromuserName;
	}
	public int getState(){
		return this.state;
	}
}