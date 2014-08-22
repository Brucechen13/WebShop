package service;

import java.util.List;

import bean.Type;
import dao.TypeDao;

public class TypeManage {
private TypeDao typeDao;
	
	

	public TypeDao getTypeDao() {
		return typeDao;
	}



	public void setTypeDao(TypeDao ordersDao) {
		this.typeDao = ordersDao;
	}



	public List<Type> showAllOrders() {
		// TODO Auto-generated method stub
		System.out.println("------show orders");
		//return ordersDao.showAllOrders();
		return null;
	}



	public void AddType(Type goods) {
		// TODO Auto-generated method stub
		typeDao.AddType(goods);
	}



	public void modifyType(Type goods) {
		// TODO Auto-generated method stub
		typeDao.modifyType(goods);
	}



	public void deleteType(Type goods) {
		// TODO Auto-generated method stub
		typeDao.deleteType(goods);
	}



	public Type getType(int id) {
		// TODO Auto-generated method stub
		return typeDao.getType(id);
	}
	public Type getType(String name) {
		// TODO Auto-generated method stub
		return typeDao.getType(name);
	}
	public List<String> showAllTypes(){
		return typeDao.showAllTypes();
	}

}
