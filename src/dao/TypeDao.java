package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Goods;
import bean.Type;
import bean.User;

public class TypeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void AddType(Type user) {
		System.out.println("-------TypeDaoImp.AddUser-----------");
		getSession().save(user);
	}

	public void modifyType(Type user) {
		System.out.println("-------TypeDaoImp.modifyUser-----------");
		getSession().update(user);
	}

	public void deleteType(Type user) {
		System.out.println("-------TypeDaoImp.deleteUser-----------");
		getSession().delete(user);
	}
	
	public Type getType(int id) {
		// TODO Auto-generated method stub
		return (Type) getSession().get(Type.class, id);
	}
	public Type getType(String name) {
		// TODO Auto-generated method stub
		String hql="FROM Type where name=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, name);
		return (Type) query.list().get(0);
		//return (Type) getSession().get(Type.class, id);
	}
	public List<String> showAllTypes(){
		String hql="select name FROM Type";
		Query query=getSession().createQuery(hql);
		return query.list();
	}

}
