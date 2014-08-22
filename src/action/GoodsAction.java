package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.GoodsManage;
import bean.Type;
import bean.Goods;
import bean.Orders;

import com.opensymphony.xwork2.Action;


public class GoodsAction implements Action {
	private String goodname;
	private int goodprice;
	private String type;
	private int pageNow = 1 ; //初始化为1,默认从第一页开始显示
    private int pageSize = 5 ; //每页显示5条记录
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(int goodprice) {
		this.goodprice = goodprice;
	}

	private List<Goods> lg;
	public List<Goods> getLg() {
		return lg;
	}
	public void setLg(List<Goods> lg) {
		this.lg = lg;
	}

	private GoodsManage manage;
	public GoodsManage getManage() {
		return manage;
	}
	public void setManage(GoodsManage manage) {
		this.manage = manage;
	}
	
	public String info() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods good = manage.getGoods(id);
		lg = new ArrayList<Goods>();
		lg.add(good);
		
		return "info";
	}
	public String search() throws Exception {
		System.out.println(goodname+" "+type);
		if(type.equals("0")){
			lg = manage.searchTrue(goodname);
		}
		else{
			lg = manage.searchFalse(goodname);
		}
		return SUCCESS;
	}
	public String purchase() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods good = manage.getGoods(id);
		lg = new ArrayList<Goods>();
		lg.add(good);
		//request.setAttribute("type", good.getType());
		return "purchase";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lg = manage.queryByPage(pageSize, pageNow);
		 return SUCCESS ;
	}
	public String manage() throws Exception {
		// TODO Auto-generated method stub
		lg = manage.showAllGoods();
		return "manage";
	}
	public String del() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		manage.deleteGoods(manage.getGoods(id));
		lg = manage.showAllGoods();
		return "manage";
	}
	public String add() throws Exception{
		Goods goods = new Goods();
		goods.setName(goodname);
		goods.setPrice(goodprice);
		Type type = manage.getTypeManage().getType(this.type);
		goods.setType(type);
		manage.AddGoods(goods);
		lg = manage.showAllGoods();
		return "manage";
	}

}
