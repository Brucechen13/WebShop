package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Save;
import bean.User;

public class SaveDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void AddSave(Save user) {
		System.out.println("-------SavesDaoImp.AddUser-----------");
		getSession().save(user);
	}

	public void modifySave(Save user) {
		System.out.println("-------SaveDaoImp.modifyUser-----------");
		getSession().update(user);
	}

	public void deleteSave(Save user) {
		System.out.println("-------SaveDaoImp.deleteUser-----------");
		getSession().delete(user);
	}
	
	public Save getSave(int id) {
		// TODO Auto-generated method stub
		return (Save) getSession().get(Save.class, id);
	}
	public List<Save> getUserSave(User user) {
		// TODO Auto-generated method stub
		String hql="FROM Save where user=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, user);
		return query.list();
	}

}
