package wyf.cgq;
import java.util.*;
public class Transfile{
	private String fileNumber;
	private String fileName;
	private String fileRealname;
	private String fromUser;
	private String toUser;
	private Date transTime;
	private String fileInfo;
	private String realUserName;
	private String time;
	private String fileType;
	public Transfile(){
	}	
	public Transfile(String fileNumber,String fileName,String fileRealname,String fromUser,String toUser,Date transTime,String fileInfo,String fileType){
		this.fileNumber=fileNumber;
		this.fileName=fileName;
		this.fileRealname=fileRealname;
		this.fromUser=fromUser;
		this.toUser=toUser;
		this.transTime=transTime;
		this.fileInfo=fileInfo;
		this.fileType=fileType;
	}
	public Transfile(String fileName,String fileRealname,String fromUser,String toUser,String time,String fileInfo,String realUserName,String fileNumber)
	{
		this.fileNumber=fileNumber;
		this.fileName=fileName;
		this.fileRealname=fileRealname;
		this.fromUser=fromUser;
		this.toUser=toUser;
		this.time=time;
		this.fileInfo=fileInfo;
		this.realUserName=realUserName;
	}
	public void setFileNumber(String fileNumber){
		this.fileNumber=fileNumber;
	}
	public String getFileNumber(){
		return this.fileNumber;
	}
	public void setFileName(String fileName){
		this.fileName=fileName;
	}
	public String getFileName(){
		return this.fileName;
	}
	public void setFileRealname(String fileRealname){
		this.fileRealname=fileRealname;
	}
	public String getFileRealname(){
		return this.fileRealname;
	}
	public void setFromUser(String fromUser){
		this.fromUser=fromUser;
	}
	public String getFromUser(){
		return this.fromUser;
	}
	public void setToUser(String toUser){
		this.toUser=toUser;
	}
	public String getToUser(){
		return this.toUser;
	}
	public void setTransTime(Date transTime){
		this.transTime=transTime;
	}
	public Date getTransTime(){
		return this.transTime;
	}
	public void setFileInfo(String fileInfo){
		this.fileInfo=fileInfo;
	}
	public String getFileInfo(){
		return this.fileInfo;
	}
	public void setRealUserName(String realUserName){
		this.realUserName=realUserName;
	}
	public String getRealUserName(){
		return this.realUserName;
	}
	public void setFileType(String fileType){
		this.fileType=fileType;
	}
	public String getFileType(){
		return this.fileType;
	}
	public String getTime(){
		return time;
	}
}