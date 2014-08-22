package service;

import java.util.List;

import bean.Save;
import bean.User;
import dao.SaveDao;

public class SaveManage {
private SaveDao saveDao;
	
	

	public SaveDao getSaveDao() {
		return saveDao;
	}



	public void setSaveDao(SaveDao saveDao) {
		this.saveDao = saveDao;
	}



	public List<Save> showAllOrders() {
		// TODO Auto-generated method stub
		System.out.println("------show orders");
		//return ordersDao.showAllOrders();
		return null;
	}



	public void AddSave(Save goods) {
		// TODO Auto-generated method stub
		saveDao.AddSave(goods);
	}



	public void modifySave(Save goods) {
		// TODO Auto-generated method stub
		saveDao.modifySave(goods);
	}



	public void deleteSave(Save goods) {
		// TODO Auto-generated method stub
		saveDao.deleteSave(goods);
	}



	public Save getSave(int id) {
		// TODO Auto-generated method stub
		return saveDao.getSave(id);
	}
	public List<Save> getUserSave(User user) {
		return saveDao.getUserSave(user);
	}

}
