package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class AddUser2Action extends UserDetailAction{
	private InsertDB insertDB;
	private String savePath;
	private File pic;
	private String picType;
	private String picName;
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
	}
	
	
	public void setSavePath(String savePath){
		this.savePath=savePath;
	}
	public String getSavePath(){
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public void setPic(File pic){
		this.pic=pic;
	}
	public File getPic(){
		return this.pic;
	}
	public void setPicContentType(String picType){
		this.picType=picType;
	}
	public String getPicContentType() {
		return this.picType;
	}
	public void setPicFileName(String picName){
		this.picName=picName;
	}
	public String getPicFileName(){
		return this.picName;
	}
	public String execute(){
		if(!this.getPwd1().equals(this.getPwd2())){
			this.setResult("两次密码输入不匹配");
			return "success";
		}
		if(this.getPwd1().equals("")){
			this.setResult("密码不能为空");
			return "success";
		}
		String picname="";
		if(this.getPicFileName()!=null&&(!this.getPicFileName().equals(""))){
			picname=new Date().getTime()+this.getPicFileName().substring(this.getPicFileName().lastIndexOf("."),this.getPicFileName().length());
			try{
				FileOutputStream fos=new FileOutputStream(this.getSavePath()+"\\"+picname);
				FileInputStream fis=new FileInputStream(getPic());
				byte[] buffer=new byte[1024];
				int length=0;
				while((length=fis.read(buffer))>0){
					fos.write(buffer,0,length);
				}
			}
			catch(Exception e){
				this.setResult("添加失败，请重试");
				return SUCCESS;
			}
			String timetemp=this.getBirth();
			String[] s1=timetemp.split("-");
			int year=new Integer(s1[0]);
			int month=new Integer(s1[1]);
			int day=new Integer(s1[2]);
			Date birthday=new Date(year-1900,month-1,day);
			NewUser nu=new NewUser(birthday,this.getDept(),this.getEmail(),this.getGender(),
						this.getGroup(),picname,this.getJianli(),this.getTel(),this.getRealName(),
						this.getRole(),this.getSalary(),this.getName(),this.getPwd1());
			insertDB.saveNewUser(nu);
			this.setResult("添加成功");
		}
		return "success";
	}
}