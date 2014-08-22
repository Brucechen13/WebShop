package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.UserManageImp;
import bean.Goods;
import bean.Type;
import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UserAction implements Action {
	private List<User> users;
	private UserManageImp manage;

	public List<User> getUsers() {
		return users;
	}

	public UserManageImp getManage() {
		return manage;
	}

	public void setManage(UserManageImp manage) {
		this.manage = manage;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String add() throws Exception {//删除用户
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = manage.getUser(request.getParameter("username"));
		int money = Integer.parseInt(request.getParameter("money"));
		int scope = Integer.parseInt(request.getParameter("scope"));
		if(user.getMoney()!=money || user.getScope()!=scope){
			user.setMoney(money);
			user.setScope(scope);
			manage.modifyUser(user);
		}
		users = new ArrayList<User>();
		users.add(user);
		return "info";
	}
	
	public String info() throws Exception {
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		String name = session.get("user");
		User user = manage.getUser(name);
		users = new ArrayList<User>();
		users.add(user);
		return "info";
	}
	
	public String purchase() throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		String name = session.get("user");
		User user = manage.getUser(name);
		users = new ArrayList<User>();
		users.add(user);
		return "purchase";
	}
	
	public String modify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		User user = manage.getUser(id);
		users = new ArrayList<User>();
		users.add(user);
		return "modify";
	}
	
	public String del() throws Exception {//删除用户
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		manage.deleteUser(manage.getUser(id));
		users = manage.showAllUsers();
		return "manage";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		users = manage.showAllUsers();
		return SUCCESS;
	}

}
