package wyf.zrk;

import java.util.*;

public interface BookTicket{
	 //向购物车中添加车票
	 public void addToCart(TicketItem ti);

     //从购物车中删除车票的方法
	 public boolean removeFromCart(String id);
 
	 //获取车票列表
	 public Vector<TicketItem> getCart();
	 
     //清空购物车
	 public void clearCart();
}