package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class UploadShare2Action extends UploadShareAction{
	private InsertDB insertDB;
	private String savePath;
	private String type;
	private String title;
	private String info;
	private File shareFile;
	private String shareFileType;
	private String shareFileName;
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
	}
	public void setSavePath(String savePath){
		this.savePath=savePath;
		System.out.println("savePath:"+savePath);
	}
	public String getSavePath(){
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public void setType(String type){
		this.type=type;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setInfo(String info){
		this.info=info;
	}                                                                   
	public void setShareFile(File shareFile){
		this.shareFile=shareFile;
	}
	public File getShareFile(){
		System.out.println("shareFile:"+shareFile);
		return this.shareFile;
	}
	public void setShareFileContentType(String shareFileType) {
		this.shareFileType=shareFileType;
	}

	public void setShareFileFileName(String shareFileName) {
		this.shareFileName=shareFileName;
	}
	public String getShareFileContentType() {
		return this.shareFileType;
	}
	public String getShareFileFileName() {
		return this.shareFileName;
	}
	public String execute(){
		if(this.shareFileName!=null&&!this.shareFileName.equals("")){
			String filename=new Long(new Date().getTime()).toString()+this.shareFileName.substring(this.shareFileName.lastIndexOf("."),this.shareFileName.length());
			FileOutputStream fos=null;
			FileInputStream fis=null;
			int filesize=0;
			try{
					fos=new FileOutputStream(this.getSavePath()+"\\"+filename);
					fis=new FileInputStream(this.getShareFile());
					
					byte[] buffer=new byte[1024];
					int length=0;
					filesize=fis.available()/1000;
					System.out.println("fos:&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+filesize);
					while((length=fis.read(buffer))>0){
						fos.write(buffer,0,length);
					}
					fos.flush();
				}
				catch(Exception e){
					System.out.println("ÉÏ´«Ê§°Ü");
					return SUCCESS;
				}
				finally{
					try{
						if(fos!=null){
						fos.close();
						}
						if(fis!=null){
							fis.close();
						}
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
				ShareFile sf=new ShareFile();
				sf.setName(filename);
				sf.setRealname(this.shareFileName);
				sf.setFromuser((String)this.getSession().get("user"));
				sf.setTime(new Date());
				sf.setTitle(this.title);
				sf.setInfo(this.info);
				sf.setSize(filesize);
				sf.setFiletype(this.shareFileType);
				sf.setType(this.type);
				this.insertDB.saveShareFile(sf);
		}
		return "success";
	}
}