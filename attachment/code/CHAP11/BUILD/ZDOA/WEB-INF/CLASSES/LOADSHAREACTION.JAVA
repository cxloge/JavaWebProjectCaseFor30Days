package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
public class LoadShareAction extends ViewShareAction{
	private String fileNumber;
	private String inputPath;
	private String fileName;
	private String downloadName;
	private String fileType;
	public void setInputPath(String inputPath){
		this.inputPath=inputPath;
	}
	public String getInputPath(){
		return ServletActionContext.getRequest().getRealPath(inputPath);
	}
	public InputStream getInputName(){
		InputStream is=ServletActionContext.getServletContext().getResourceAsStream(this.inputPath+"\\"+fileName);
		return is;
	}
	public String getDownloadName(){
		try{   
  				downloadName = new String(downloadName.getBytes(), "ISO-8859-1");   
  		   }
  		   catch (UnsupportedEncodingException e){   
            e.printStackTrace();  
        }   
        return downloadName;   

	}
	public String getFileType(){
		if(fileType.equals("application/octet-stream"));
		this.fileType="application/octet-stream;charset=ISO8859-1";
		return this.fileType;
	}
	public void setFileNumber(String fileNumber){
		this.fileNumber=fileNumber;
	}
	public String execute(){
		String sql="select share_name,share_realname,share_filetype "+
				"from oa_sharefile where share_number='"+fileNumber+"'";
		List list=this.getSearchDB().getArrayList(sql);
		if(list.size()<=0)
		{
			return "input";
		}
		Object[] o=(Object[])list.get(0);
		this.fileName=(String)o[0];
		this.downloadName=(String)o[1];
		this.fileType=(String)o[2];
		return "success";
	}

}
