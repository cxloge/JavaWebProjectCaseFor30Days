package wyf.cgq;
import java.util.*;
public class Attinfo{
	private String attTime;
	private String attName;
	private String deptName;
	private int startState;
	private String startTime;
	private String startIp;
	private int endState;
	private String endTime;
	private String endIp;
	public Attinfo(){
	}
	public Attinfo(String attName, String attTime, String deptName,
			String endIp, int endState, String endTime, String startIp,
			int startState, String startTime) {
		this.attName = attName;
		this.attTime = attTime;
		this.deptName = deptName;
		this.endIp = endIp;
		this.endState = endState;
		this.endTime = endTime;
		this.startIp = startIp;
		this.startState = startState;
		this.startTime = startTime;
	}
	public String getAttTime() {
		return attTime;
	}
	public void setAttTime(String attTime) {
		this.attTime = attTime;
	}
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getStartState() {
		return startState;
	}
	public void setStartState(int startState) {
		this.startState = startState;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStartIp() {
		return startIp;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public int getEndState() {
		return endState;
	}
	public void setEndState(int endState) {
		this.endState = endState;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndIp() {
		return endIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
}