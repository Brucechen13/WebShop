package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import bean.Goods;
import bean.User;

public class UserDao implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddUser(User user) {
		System.out.println("-------UserDaoImp.AddUser-----------"
				+ user.getUsername());
		getSession().save(user);
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("-------UserDaoImp.modifyUser-----------"
				+ user.getUsername());
		getSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		System.out.println("-------UserDaoImp.deleteUser-----------"
				+ user.getUsername());
		getSession().delete(user);
	}
	
	@Override
	public boolean ValidUser(String name, String password){
		System.out.println("-------UserDaoImp.validUser-----------"
				+ name);
		String hql="FROM User u WHERE  u.username=? AND u.password=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0,name);
		query.setParameter(1,password);
		List<User> rs= query.list();
		return (rs!=null && rs.size()>0)?true:false;
	}

	@Override
	public List<User> showAllUsers() {
		// TODO Auto-generated method stub
		String hql="FROM User";
		Query query=getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class, id);
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		String hql="FROM User where username=?";		
		Query query=getSession().createQuery(hql);
		query.setParameter(0,name);
		return (User) query.list().get(0);
	}
}
