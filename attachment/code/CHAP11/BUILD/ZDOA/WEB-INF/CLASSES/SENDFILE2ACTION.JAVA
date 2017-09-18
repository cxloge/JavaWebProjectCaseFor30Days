package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;

public class SendFile2Action extends SendFileAction{
	private InsertDB insertDB;//声明InsertDB的引用
	private String info;//声明用于存放文件主题的属性
	private String touser;//用于存放文件接收者
	private String savePath;//用于存放文件存储路径
	private File myFile;//接收到的文件
	private String myFileType;//文件类型
	private String myFileName;//文件名字
	public void setInsertDB(InsertDB insertDB){//InsertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setInfo(String info){//info的setter方法
		this.info=info;
	}
	public void setTouser(String touser){//touser的setter方法
		this.touser=touser;
	}
	public void setSavePath(String savePath){//savaPath的setter方法
		this.savePath=savePath;
	}
	public String getSavePath(){//savaPath的getter方法
		return ServletActionContext.getRequest().getRealPath(savePath);
	}                                                                    
	public void setMyFile(File myFile){//myFile的setter方法
		this.myFile=myFile;
	}
	public File getMyFile(){//myFile的getter方法
		return this.myFile;
	}
	public void setMyFileContentType(String myFileType) {//MyFileContentType的setter方法
		this.myFileType=myFileType;
	}

	public void setMyFileFileName(String myFileName) {//MyFileFileName的setter方法
		this.myFileName=myFileName;
	}
	public String getMyFileContentType() {//MyFileContentType的getter方法
		return this.myFileType;
	}
	public String getMyFileFileName() {//MyFileFileName的getter方法
		return this.myFileName;
	}
	public String execute(){//重写的execute方法
		if(this.myFileName!=null&&!this.myFileName.equals("")){//如果文件确实存在
			String filename=new Long(new Date().getTime()).toString()+this.myFileName.substring(this.myFileName.lastIndexOf("."),this.myFileName.length());//以当前时间为该文件的文字
			FileOutputStream fos=null;//文件输出流
			FileInputStream fis=null;//文件输入流
			try{
					fos=new FileOutputStream(this.getSavePath()+"\\"+filename);//创建文件输出流
					fis=new FileInputStream(this.getMyFile());//创建文件输入流
					byte[] buffer=new byte[1024];//创建byte数组
					int length=0;
					while((length=fis.read(buffer))>0){
						fos.write(buffer,0,length);//读取文件并写入
					}
				}
				catch(Exception e){
					System.out.println("上传失败");//上传失败
					return SUCCESS;
				}
				finally{
					try{
						if(fos!=null){//关闭输出流
						fos.close();
						}
						if(fis!=null){//关闭输入流
							fis.close();
						}
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			String[] touserarray=this.touser.split(";");//分解收件人列表
			int size=touserarray.length;//获得收件人个数
			List userlist=new ArrayList();//创建一个ArrayList
			for(int i=0;i<size;i++){//遍历收件人列表
				Transfile tf=new Transfile();//创建Transfile对象
				tf.setFileName(filename);
				tf.setFileRealname(this.myFileName);
				tf.setFromUser((String)this.getSession().get("user"));
				tf.setToUser(touserarray[i].trim());
				tf.setTransTime(new Date());
				tf.setFileInfo(this.info);
				tf.setFileType(this.myFileType);//设置Transfile对象的相应属性
				userlist.add(tf);//将对象放入list
			}
			this.insertDB.saveTransFile(userlist);//调用insertDB的相应方法保存信息
		}
		return "success";
	}
	public Map getSession(){//获得session的方法
		return ActionContext.getContext().getSession();
	}
}