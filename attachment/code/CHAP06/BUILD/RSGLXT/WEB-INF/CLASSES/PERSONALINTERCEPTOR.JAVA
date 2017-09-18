package wyf.cgq;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;
import java.util.*;
public class PersonalInterceptor extends AbstractInterceptor
{
	public String intercept(ActionInvocation  invocation) throws Exception
	{
		Map session=invocation.getInvocationContext().getSession();
		Object right=session.get("right");
		if(right!=null&&(((String)right).equals("manage")||((String)right).equals("personal")))
		{
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}