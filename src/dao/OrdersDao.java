package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Orders;
import bean.User;

public class OrdersDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Orders> showAllOrders() {
		// TODO Auto-generated method stub
		String hql="FROM Orders";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	public void AddOrders(Orders user) {
		System.out.println("-------OrdersDaoImp.AddUser-----------"+user.getStatus());
		getSession().save(user);
	}

	public void modifyOrders(Orders user) {
		System.out.println("-------UserDaoImp.modifyUser-----------");
		getSession().update(user);
	}

	public void deleteOrders(Orders user) {
		System.out.println("-------UserDaoImp.deleteUser-----------");
		getSession().delete(user);
	}
	
	public Orders getOrders(int id) {
		// TODO Auto-generated method stub
		return (Orders) getSession().get(Orders.class, id);
	}
	public List<Orders> getAllOrders(User user) {
		// TODO Auto-generated method stub
		String hql="FROM Orders orders where orders.user=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, user);
		return query.list();
	}
	public List<Orders> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="FROM Orders";
		Query query=getSession().createQuery(hql);
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
