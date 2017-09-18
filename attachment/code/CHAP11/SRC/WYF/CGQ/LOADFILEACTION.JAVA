package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
public class LoadFileAction extends ReceiveFileAction{
	private String fileNumber;//要下载的文件的编号
	private String inputPath;//文件的存储路径
	private String fileName;//文件的名字
	private String downloadName;//文件下载后的名字
	private String fileType;//文件的类型
	public void setInputPath(String inputPath){//inputPath的setter方法
		this.inputPath=inputPath;
	}
	public String getInputPath(){//inputPath的getter方法
		return ServletActionContext.getRequest().getRealPath(inputPath);
	}
	public InputStream getInputName(){//返回输入流的方法
		InputStream is=ServletActionContext.getServletContext().getResourceAsStream(this.inputPath+"\\"+fileName);//获得输入流
		return is;//返回输入流
	}
	public String getDownloadName(){//获得下载后文件名字的方法
		try{   
  				downloadName = new String(downloadName.getBytes(), "ISO-8859-1");   
  		   }//转码，以便传输
  		   catch (UnsupportedEncodingException e){   
            e.printStackTrace();  
        }   
        return downloadName;   //返回名字
	}
	public String getFileType(){//获得文件类型的方法
		if(fileType.equals("application/octet-stream"));
		this.fileType="application/octet-stream;charset=ISO8859-1";//获得文件类型
		return this.fileType;//返回文件类型
	}
	public void setFileNumber(String fileNumber){//设置文件编号的方法
		this.fileNumber=fileNumber;
	}
	public String execute(){//重写的execute方法
		String sql="select transfile_name,transfile_realname,transfile_type "+
				"from oa_transfile where transfile_number='"+fileNumber+"'";
		List list=this.getSearchDB().getArrayList(sql);//执行sql,获得list
		if(list.size()<=0){//如果小于零，说明不存在
			return "input";//返回逻辑视图
		}
		Object[] o=(Object[])list.get(0);//获得第一个对象
		this.fileName=(String)o[0];//获得文件名字
		this.downloadName=(String)o[1];//获得下载后的名字，即文件原始名字
		this.fileType=(String)o[2];//获得文件类型
		return "success";//返回逻辑视图
	}
}
