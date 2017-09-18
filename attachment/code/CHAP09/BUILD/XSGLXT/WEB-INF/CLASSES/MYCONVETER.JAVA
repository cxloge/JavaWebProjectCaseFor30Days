package wyf.cgq;
import javax.faces.convert.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.application.*;

public class MyConveter implements Converter{
	public Object getAsObject(FacesContext context,UIComponent component,String value){		
		try{
		  double score=Double.parseDouble((String)value);//将用户输入的数据转化为数字
		  return score;			
		}
		catch(NumberFormatException e){//如果转换出现错误
			FacesMessage message = new FacesMessage(//封装错误信息
                 FacesMessage.SEVERITY_ERROR, 
                 "分数格式不对", 
                 "分数格式不对，请重新输入！");
			throw new ConverterException(message);//将错误信息抛出
		}}
	public String getAsString(FacesContext context,UIComponent component,Object value){	
		return ((Double)value).toString();//将数字转换为字符串返回
	}}