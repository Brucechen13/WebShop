package dao;
import java.util.List;

import bean.Goods;
import bean.User;
public interface IUserDao {
	public List<User> showAllUsers();
	public  void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public boolean ValidUser(String name, String password);
	public User getUser(int id);
	public User getUser(String name);
}
