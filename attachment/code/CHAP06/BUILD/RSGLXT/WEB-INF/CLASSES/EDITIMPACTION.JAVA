package wyf.cgq;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import java.util.*;
import java.io.*;
import org.apache.struts2.*;
public class EditImpAction extends EditImpBaseAction
{
	private File pic;
	private String picType;
	private String picName;
	private String savePath;
	@RequiredStringValidator(message="${getText(\"validate.impIdEM\")}",shortCircuit=true)
    @RegexFieldValidator(message="${getText(\"validate.impIdE\")}",
                        expression="[\\d]{6,10}",shortCircuit=true)
	public void setImpId(String impId)
	{
		super.setImpId(impId);
	}
	@RequiredStringValidator(message="${getText(\"validate.impNameEM\")}",shortCircuit=true)
	public void setImpName(String impName)
	{
		super.setImpName(impName);
	}
	@RequiredStringValidator(message="${getText(\"validate.impGenderEM\")}",shortCircuit=true)
	public void setImpGender(String impGender)
	{
		super.setImpGender(impGender);
	}
	@RequiredFieldValidator(message="${getText(\"validate.impBirthEM\")}",shortCircuit=true)
	public void setImpBirth(Date impBirth)
	{
		super.setImpBirth(impBirth);
	}
	public void setDepartId(String departId)
	{
		super.setDepartId(departId);
	}
	@RequiredStringValidator(message="${getText(\"validate.impRollEM\")}",shortCircuit=true)
	public void setImpRoll(String impRoll)
	{
		super.setImpRoll(impRoll);
	}
	@RequiredFieldValidator(message="${getText(\"validate.impSalaryEM\")}",shortCircuit=true)
	@DoubleRangeFieldValidator(message="${getText(\"validate.impimpSalaryE\")}",
                       minInclusive="0.0",shortCircuit=true)
	public void setImpSalary(double impSalary)
	{
		super.setImpSalary(impSalary);
	}
	@RequiredStringValidator(message="${getText(\"validate.impTelEM\")}",shortCircuit=true)
	@RegexFieldValidator(message="${getText(\"validate.impTelE\")}",
                        expression="[\\d]{5,20}",shortCircuit=true)
	public void setImpTel(String impTel)
	{
		super.setImpTel(impTel);
	}
	@RequiredStringValidator(message="${getText(\"validate.impEmailEM\")}",shortCircuit=true)
	//@RegexFieldValidator(message="${getText(\"validate.impEmailE\")}",
    //                    expression="[\\w\\d\\.\\_-]\\+@[\\w\\d\\.\\_-]\\+\\.[\\.\\w\\d]\\+")
    @RegexFieldValidator(message="${getText(\"validate.impEmailE\")}",
                        expression="[.-_a-zA-Z0-9]+@[-_a-zA-Z0-9]+\\.[.a-zA-Z0-9]+",shortCircuit=true)
                        
	public void setImpEmail(String impEmail)
	{
		super.setImpEmail(impEmail);
	}
	@RequiredStringValidator(message="${getText(\"validate.impBioEM\")}",shortCircuit=true)
	public void setImpBio(String impBio)
	{
		super.setImpBio(impBio);
	}
	public void setPic(File pic)
	{
		this.pic=pic;
	}
	public File getPic()
	{
		return this.pic;
	}
	public void setPicContentType(String picType) 
	{
		this.picType = picType; 
	}

	public void setPicFileName(String picName) 
	{
		this.picName = picName; 
	}


	public String getPicContentType() 
	{
		return (this.picType); 
	}

	public String getPicFileName() 
	{
		return (this.picName); 
	}
	public void setSavePath(String savePath)
	{
		this.savePath=savePath;
	}
	public String getSavePath()
	{
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public String execute()
	{
		String picname="";
		if(this.getPicFileName()!=null&&(!this.getPicFileName().equals("")))
		{
			picname=this.getImpId()+this.getPicFileName().subSequence(this.getPicFileName().lastIndexOf("."),this.getPicFileName().length());
			try
			{
				FileOutputStream fos=new FileOutputStream(this.getSavePath()+"\\"+picname);
				FileInputStream fis=new FileInputStream(getPic());
				byte[] buffer=new byte[1024];
				int length=0;
				while((length=fis.read(buffer))>0)
				{
					fos.write(buffer,0,length);
				}
			}
			catch(Exception e)
			{
				this.setResult("提交失败");
				return SUCCESS;
			}
		}
		if(ManageDB.updateImp(this.getImpId(),this.getImpName(),this.getImpGender(),this.getImpBirth(),
			this.getImpEmail(),this.getDepartId(),this.getImpRoll(),this.getImpSalary(),this.getImpTel(),
			picname,this.getImpBio(),this.savePath.substring(1,this.savePath.length())+"/"))
		{
			this.setResult("提交成功");
		}
		else
		{
			this.setResult("提交失败");
		}
		return "success";
	}
}