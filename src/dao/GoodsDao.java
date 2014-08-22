package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Goods;
import bean.User;

public class GoodsDao implements IGoodsDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Goods> showAllGoods() {
		// TODO Auto-generated method stub
		String hql="FROM Goods";
		Query query=getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		System.out.println("add"+goods.getName());
		getSession().save(goods);
	}

	@Override
	public void modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		getSession().update(goods);
	}

	@Override
	public void deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		System.out.println("delelte--------");
		//Session session = getSession();  
		//Transaction tx = session.beginTransaction();  
		getSession().delete(goods);
		//tx.commit();
		//session.close();
		
		
	}

	@Override
	public Goods getGoods(int id) {
		// TODO Auto-generated method stub
		return (Goods) getSession().get(Goods.class, id);
	}

	@Override
	public List<Goods> searchTrue(String name) {
		// TODO Auto-generated method stub
		String hql="FROM Goods good where good.name=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, name);
		return query.list();
	}

	@Override
	public List<Goods> searchFalse(String name) {
		// TODO Auto-generated method stub
		String hql="FROM Goods good where good.name like ?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, "%"+name+"%");
		return query.list();
	}

	@Override
	public List<Goods> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="FROM Goods";
		Query query=getSession().createQuery(hql);
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
