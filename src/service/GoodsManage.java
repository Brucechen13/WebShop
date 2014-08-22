package service;

import java.util.List;

import javax.annotation.Resource;

import dao.IGoodsDao;
import bean.Goods;

public class GoodsManage implements IGoodsManage{
	@Resource  
	private IGoodsDao goodsDao;
	private TypeManage typeManage;
	
	

	public TypeManage getTypeManage() {
		return typeManage;
	}



	public void setTypeManage(TypeManage typeManage) {
		this.typeManage = typeManage;
	}



	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}



	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}



	@Override
	public List<Goods> showAllGoods() {
		// TODO Auto-generated method stub
		System.out.println("------show goods");
		return goodsDao.showAllGoods();
	}



	@Override
	public void AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.AddGoods(goods);
	}



	@Override
	public void modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.modifyGoods(goods);
	}



	@Override
	public void deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.deleteGoods(goods);
	}



	@Override
	public Goods getGoods(int id) {
		// TODO Auto-generated method stub
		return goodsDao.getGoods(id);
	}



	@Override
	public List<Goods> searchTrue(String name) {
		// TODO Auto-generated method stub
		return goodsDao.searchTrue(name);
	}



	@Override
	public List<Goods> searchFalse(String name) {
		// TODO Auto-generated method stub
		return goodsDao.searchFalse(name);
	}



	@Override
	public List<Goods> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		return goodsDao.queryByPage(pageSize, pageNow);
	}

}
