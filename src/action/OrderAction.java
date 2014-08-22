package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.OrdersManage;
import bean.Goods;
import bean.Orders;
import bean.Save;
import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction implements Action {
	private List<Orders> orders;
	private OrdersManage manage;
	private List<Save> saves;
	private int pageNow = 1 ; //初始化为1,默认从第一页开始显示
    private int pageSize = 2 ; //每页显示2条记录
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Save> getSaves() {
		return saves;
	}

	public void setSaves(List<Save> saves) {
		this.saves = saves;
	}

	private List<String> statusinfo = new ArrayList<>(Arrays.asList("未提交","已提交","已发货","已签收"));

	public List<String> getStatusinfo() {
		return statusinfo;
	}

	public void setStatusinfo(List<String> statusinfo) {
		this.statusinfo = statusinfo;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public OrdersManage getManage() {
		return manage;
	}

	public void setManage(OrdersManage manage) {
		this.manage = manage;
	}
	public String manage() throws Exception {
		//statusinfo = new ArrayList<>(Arrays.asList("未提交1","已提交","已发货","已签收"));
		orders = manage.queryByPage(pageSize, pageNow);
		return "manage";
	}
	public String modify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		String status = request.getParameter("status");
		String newstatus = request.getParameter("newstatus");
		if(!status.equals(newstatus)){
			Orders order = manage.getOrders(id);
			order.setStatus(newstatus);
			manage.modifyOrders(order);
		}
		orders = manage.queryByPage(pageSize, pageNow);
		return "manage";
	}
	
	public String purchase() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int goodid = Integer.valueOf(request.getParameter("id"));		
		int userid = Integer.valueOf(request.getParameter("userid"));
		Goods good = manage.getGoodsManage().getGoods(goodid);
		User user = manage.getUserManage().getUser(userid);
		if(user.getMoney()>good.getPrice()){
			Orders order = new Orders();
			order.setGood(good);
			order.setUser(user);
			order.setStatus(statusinfo.get(0));
			manage.AddOrders(order);
			
			orders = manage.getAllOrders(user);
			return "orders";
		}
		else{
			return "lessmoney";
		}
	}
	public String showOrders() throws Exception {
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		String name = session.get("user");
		User user = manage.getUserManage().getUser(name);
		orders = manage.getAllOrders(user);
		return "orders";
	}
	public String save() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("goodid"));
		Goods good = manage.getGoodsManage().getGoods(id);
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		String name = session.get("user");
		User user = manage.getUserManage().getUser(name);
		Save save = new Save();
		save.setGood(good);
		save.setUser(user);
		manage.getSaveManage().AddSave(save);
		System.out.println(id);
		return "save";
	}
	public String undoSave() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		manage.getSaveManage().deleteSave(manage.getSaveManage().getSave(id));
		return userSave();
	}
	public String undoOrder() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		status=new String(status.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(status);
		if(status.equals("未提交")){
			manage.deleteOrders(manage.getOrders(id));
			return showOrders();
		}
		return "undoFail";
	}
	public String userSave() throws Exception {
		Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		String name = session.get("user");
		User user = manage.getUserManage().getUser(name);
		saves = manage.getSaveManage().getUserSave(user);
		return "userSave";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//Map<String,String> session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
		//String name = session.get("user");
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getAttribute("userid");
		orders = manage.getAllOrders(user);
		return SUCCESS;
	}

}
