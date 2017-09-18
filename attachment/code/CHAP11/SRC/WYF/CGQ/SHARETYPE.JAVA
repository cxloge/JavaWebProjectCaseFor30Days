package wyf.cgq;
public class ShareType{
	private String typeNumber;
	private String typeName;
	public ShareType(){
	}
	public ShareType(String typeNumber,String typeName){
		this.typeNumber=typeNumber;
		this.typeName=typeName;
	}
	public void setTypeNumber(String typeNumber){
		this.typeNumber=typeNumber;
	}
	public String getTypeNumber(){
		return this.typeNumber;
	}
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
	public String getTypeName(){
		return this.typeName;
	}
}