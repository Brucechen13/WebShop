package dao;
import java.util.List;

import bean.Goods;
public interface IGoodsDao {
	public List<Goods> showAllGoods();
	public List<Goods> searchTrue(String name);
	public List<Goods> searchFalse(String name);
	public List<Goods> queryByPage (int pageSize, int pageNow);
	public  void AddGoods(Goods goods);
	public void modifyGoods(Goods goods);
	public void deleteGoods(Goods goods);
	public Goods getGoods(int id);

}
