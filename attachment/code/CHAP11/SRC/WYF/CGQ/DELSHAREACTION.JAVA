package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class DelShareAction extends ViewShareAction{
	private String inputPath;
	private String delfile;
	public void setInputPath(String inputPath){
		this.inputPath=inputPath;
	}
	public String getInputPath(){
		return ServletActionContext.getRequest().getRealPath(inputPath);
	}
	public void setDelfile(String delfile){
		this.delfile=delfile;
	}
	public String execute(){
		this.delete();
		return "success";
	}
	public void delete(){
		if(delfile!=null){
			this.getInsertDB().delShareFile(this.delfile);
			String realpath=ServletActionContext.getRequest().getRealPath(inputPath);
			File file=new File(realpath+"\\"+delfile);
			if(file!=null){
				file.delete();
			}	
		}
	}
}
