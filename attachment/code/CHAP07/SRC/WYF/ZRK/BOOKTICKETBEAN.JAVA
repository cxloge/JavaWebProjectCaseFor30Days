package wyf.zrk;
import java.util.*;
import javax.annotation.*;
import javax.ejb.*;
import javax.sql.*;
import java.sql.*;
@Stateful
public class BookTicketBean implements BookTicketLocal,BookTicketRemote{
	//存储预订车票信息的列表
    private Vector<TicketItem> cart = new Vector<TicketItem>();	
	public void addToCart(TicketItem ti){	//由于一次只可以预订一种车次，故cart中只
		if(cart.size()==0){					//可以放一个对象，在此就不再需要进行判断
			cart.add(ti);
		}
		else{
			cart.clear();
			cart.add(ti);
		}							
	}
     //从购物车中删除车票的方法
	 public boolean removeFromCart(String tname){
	 	boolean flag = false;	 	
	 	for(TicketItem ti:cart){	
			if(ti.getTname().equals(tname)){				
				cart.remove(ti);
				flag = true;
	        }
		}
	 	return flag;
	 } 
	 //获取车票列表
	 public Vector<TicketItem> getCart(){
	 	return cart;
	 }	 
     //清空购物车
	 public void clearCart(){
	 	cart.clear();
	 }	
}