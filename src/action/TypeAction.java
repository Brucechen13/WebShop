package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.TypeManage;
import bean.Type;

import com.opensymphony.xwork2.Action;

public class TypeAction implements Action {
	private TypeManage manage;
	private String typename;
	private int typeid;
	private List<String> types;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public TypeManage getManage() {
		return manage;
	}

	public void setManage(TypeManage manage) {
		this.manage = manage;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	public String purchase() throws Exception {
		// TODO Auto-generated method stub
		
		return "purchase";
	}
	public String manage() throws Exception {
		types = manage.showAllTypes();
		return "manage";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/*HttpServletRequest request = ServletActionContext.getRequest();
		int id = (int)request.getAttribute("type");
		Type type = manage.getType(id);
		this.setTypename(type.getName());*/
		types = manage.showAllTypes();
		return SUCCESS;
	}

}
