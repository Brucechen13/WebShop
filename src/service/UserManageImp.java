package service;


import java.util.List;

import javax.annotation.Resource;

import dao.IUserDao;
import bean.Goods;
import bean.User;

public class UserManageImp implements IUserManage {
	
	@Resource  
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		System.out.println("------UserManageImp.adddUser--------"+user.getUsername());
		userDao.AddUser(user);
		
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("------UserManageImp.modifyUser--------"+user.getUsername());
		userDao.modifyUser(user);

	}

	@Override
	public void deleteUser(User user) {
		System.out.println("------UserManageImp.deleteUser--------"+user.getUsername());
		userDao.deleteUser(user);
	}
	@Override
	public boolean ValidUser(String name, String password){
		System.out.println("-------UserManageImp.validUser-----------"
				+ name);
		return userDao.ValidUser(name, password);
	}

	@Override
	public List<User> showAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("------show Users");
		return userDao.showAllUsers();
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userDao.getUser(name);
	}
}
