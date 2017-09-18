package wyf.cgq;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;
import java.util.*;
public class RightInterceptor extends AbstractInterceptor
{
	public String intercept(ActionInvocation  invocation) throws Exception
	{
		Map session=invocation.getInvocationContext().getSession();
		Object right=session.get("right");
		if(right!=null&&((String)right).equals("manage"))
		{
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}