package wyf.cgq;
import java.util.*;
public class ShareFile{
	private String number;
	private String name;
	private String realname;
	private String fromuser;//共享人的编号
	private Date time;
	private String title;
	private String info;
	private int size;
	private String filetype;
	private String type;
	private String username;//共享人的姓名
	private String typename;
	public ShareFile(){
	}
	public ShareFile(String filetype, String fromuser, String info,
			String name, String number, String realname, int size, Date time,
			String title, String type) {
		this.filetype = filetype;
		this.fromuser = fromuser;
		this.info = info;
		this.name = name;
		this.number = number;
		this.realname = realname;
		this.size = size;
		this.time = time;
		this.title = title;
		this.type = type;
		
	}
	public ShareFile(String number,String name,String realname,String username,
					int size,Date time,String title,String typename){
		this.number=number;
		this.name=name;
		this.realname=realname;
		this.username=username;
		this.size=size;
		this.time=time;
		this.title=title;
		this.typename=typename;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	public void setTypename(String typename){
		this.typename=typename;
	}
	public String getTypename(){
		return this.typename;
	}
}