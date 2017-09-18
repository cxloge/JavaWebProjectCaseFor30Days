package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class ChangepicAction extends UserDetailAction{
	private InsertDB insertDB;
	private String savePath;
	private File pic;
	private String picType;
	private String picName;
	private String result="";
	private String oldpic;
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
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
	public String getResult(){
		return this.result;
	}
	public void setOldpic(String oldpic){
		this.oldpic=oldpic;
	}
	public String execute(){
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
				this.result="–ﬁ∏ƒ ß∞‹£¨«Î÷ÿ ‘£°£°£°";
				return SUCCESS;
			}
			String sql="update oa_user set user_imgpath='"+picname+"' where user_number='"+
					this.getUserNumber()+"'";
			System.out.println(sql);
			int i=insertDB.update(sql);
			if(i<1){
				this.result="–ﬁ∏ƒ ß∞‹£¨«Î÷ÿ ‘£°£°£°";
				return "success";
			}
			String path=this.getPath();
			File file=new File(this.getSavePath()+"\\"+this.oldpic.substring(path.length()-1,this.oldpic.length()));
			file.delete();
		}
		
		return "success";
	}
}
