package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class TopAction extends ActionSupport{
	public String execute(){
		return SUCCESS;
	}
	public int getRight(){
		return (Integer)ActionContext.getContext().getSession().get("right");
	}
}