package wyf.cgq;
import java.util.*;
public class Impleey
{
	private String impId;
	private String impName;
	private String impGender;
	private Date impBirth;
	private String impEmail;
	private String departName;
	private String departId;
	private String impRoll;
	private double impSalary;
	private String impTel;
	private String impPic;
	private String impBio;
	private String impState;
	public Impleey(String impId,String impName,String impGender,
					Date impBirth,String departName,String impRoll,
					double impSalary,String impTel)
	{
		this.impId=impId;
		this.impName=impName;
		this.impGender=impGender;
		this.impBirth=impBirth;
		this.departName=departName;
		this.impRoll=impRoll;
		this.impSalary=impSalary;
		this.impTel=impTel;
	}
	
	public Impleey(String impId,String impName,String impGender,
					Date impBirth,String departName,String impRoll,
					double impSalary,String impTel,String impEmail,
					String impPic,String impBio,String impState)
	{
		this(impId,impName,impGender,
					impBirth,departName,impRoll,
					impSalary,impTel);
		this.impEmail=impEmail;
		this.impPic=impPic;
		this.impBio=impBio;
		this.impState=impState;
	}
	public Impleey(String impId,String impName,String impGender,
					Date impBirth,String departId,String impRoll,
					double impSalary,String impTel,String impEmail,
					String impBio,String impState)
	{
		this.impId=impId;
		this.impName=impName;
		this.impGender=impGender;
		this.impBirth=impBirth;
		this.departId=departId;
		this.impRoll=impRoll;
		this.impSalary=impSalary;
		this.impTel=impTel;
		this.impEmail=impEmail;
		this.impBio=impBio;
		this.impState=impState;
	}
	public String getDepartId()
	{
		return this.departId;
	}
	public String getImpId()
	{
		return this.impId;
	}
	public String getImpName()
	{
		return this.impName;
	}
	public String getImpGender()
	{
		return this.impGender;
	}
	public Date getImpBirth()
	{
		return this.impBirth;
	}
	public String getDepartName()
	{
		return this.departName;
	}
	public String getImpRoll()
	{
		return this.impRoll;
	}
	public double getImpSalary()
	{
		return this.impSalary;
	}
	public String getImpTel()
	{
		return this.impTel;
	}
	public String getImpEmail()
	{
		return this.impEmail;
	}
	public String getImpPic()
	{
		return this.impPic;
	}
	public String getImpBio()
	{
		return this.impBio;
	}
	public String getImpState()
	{
		return this.impState;
	}
}