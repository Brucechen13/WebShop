package action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import service.*;

public class LoginAction implements Action{
	private String username;
	private String password;
	private UserManageImp manage;
	public UserManageImp getManage() {
		return manage;
	}
	public void setManage(UserManageImp manage) {
		this.manage = manage;
	}
	public String quit() throws Exception{
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		session.remove("user");
		return LOGIN ;
	}
	public String execute() throws Exception{
		//ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext-common.xml");
		//UserManageImp manage = (UserManageImp)ctx.getBean("userManage");
		
		if(manage.ValidUser(getUsername(), getPassword())){
			System.out.print("***********sure");
			Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
			session.put("user",getUsername());
			return SUCCESS;
		}
		System.out.print("************no");
		return LOGIN ;
	}
	public String register() throws Exception{
		System.out.println("注册");
		return "register";
	}
	public String validRegister() throws Exception{
		
		System.out.println(this.username+" " + this.password);
		//System.out.println("1"+(String[])(ActionContext.getContext().getParameters().get("password2"))[0]);
		//Map request = (Map) ActionContext.getContext().get("request");
		//System.out.println(request.get("password2"));
		//System.out.println(request.size()+" "+request.keySet());
		HttpServletRequest req1 = ServletActionContext.getRequest();
		//Session session = ServletActionContext.se
		
		
		String password2 = req1.getParameter("password");
		if(password2.equalsIgnoreCase(password)){
			System.out.println("成功注册");
			User user = new User();
			user.setMoney(100);//初始金钱
			user.setScope(0);//初始积分
			user.setPassword(password);
			user.setUsername(username);
			manage.addUser(user);
			Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
			session.put("user", user.getUsername());
			//session.put("user", user.getUsername());
			return SUCCESS;
		}
		System.out.println("重新注册");
		return "register";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
