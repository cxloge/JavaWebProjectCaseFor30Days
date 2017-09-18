package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class DelTransFileAction extends ReceiveFileAction{
	private String inputPath;
	private List<String> delList;
	public void setInputPath(String inputPath){
		this.inputPath=inputPath;
	}
	public String getInputPath(){
		return ServletActionContext.getRequest().getRealPath(inputPath);
	}
	public void setDelList(List delList){
		this.delList=delList;
	}
	public String execute(){
		this.delete();
		
		return "success";
	}
	public void delete(){
		String usernumber=(String)this.getSession().get("user");
		if(delList!=null){
			this.getInsertDB().delRecord(usernumber,delList);
			int size=delList.size();
			for(int i=0;i<size;i++){
				String filename=delList.get(i);
				String sql="select count(*) from oa_transfile where transfile_name='"+filename+"'";
				List list=this.getSearchDB().getArrayList(sql);
				int total=((BigDecimal)list.get(0)).intValue();
				if(total>0){
					continue;
				}
				String realpath=ServletActionContext.getRequest().getRealPath(inputPath);
				File file=new File(realpath+"\\"+filename);
				if(file!=null){
					file.delete();
				}
			
			}
		}
		
	}

}
