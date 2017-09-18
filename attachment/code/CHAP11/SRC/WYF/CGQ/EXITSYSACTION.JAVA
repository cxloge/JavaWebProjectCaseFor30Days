package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ExitSysAction{

	public String execute(){
		ActionContext.getContext().getSession().clear();
		return "success";
	}	
}