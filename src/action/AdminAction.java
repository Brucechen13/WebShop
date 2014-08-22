package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AdminAction implements Action {
	private String adminname;
	private String adminpassword;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		if("root".equals(session.get("admin"))){
			return SUCCESS;
		}
		HttpServletRequest req1 = ServletActionContext.getRequest();
		
		if(req1.getParameter("adminpassword").equals("123456")&&req1.getParameter("adminname").equals("root")){
			
			session.put("admin","root");
			return SUCCESS;
		}
		return LOGIN;
	}
	public String quit() throws Exception{
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		session.remove("admin");
		return LOGIN ;
	}
	public String login() throws Exception {
		// TODO Auto-generated method stub
		return LOGIN;
	}
	

}
