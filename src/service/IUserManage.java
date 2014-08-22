package service;

import java.util.List;

import bean.Goods;
import bean.User;

public interface IUserManage {
	public List<User> showAllUsers();
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public boolean ValidUser(String name, String password);
	public User getUser(int id);
	public User getUser(String name);
}
