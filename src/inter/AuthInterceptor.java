package inter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = arg0.getInvocationContext();
		if(ctx.getSession().get("user") == null && ctx.getSession().get("admin")==null)
			return "login";
		//test user
		return arg0.invoke();
	}

}
