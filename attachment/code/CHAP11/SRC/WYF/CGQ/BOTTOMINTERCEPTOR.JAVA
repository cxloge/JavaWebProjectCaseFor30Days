package wyf.cgq;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;
import java.util.*;
public class BottomInterceptor extends AbstractInterceptor
{
	public String intercept(ActionInvocation  invocation) throws Exception
	{
		int rights=0;
		Map session=invocation.getInvocationContext().getSession();
		Object right=session.get("right");
		if(right!=null)
		{
			rights=(Integer)right;
		}
		Object user=session.get("user");
		if(right!=null&&rights>0&&user!=null)
		{
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}