package wyf.zrk;

import java.util.*;
import org.springframework.orm.hibernate3.*;
import org.hibernate.*;

public class DBupdate{	
	private SessionFactory sf;
	private DButil db;
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	public DButil getDb(){
		return this.db;
	}
	public void setDb(DButil db){
		this.db = db;
	}
	public void updateTable(String tablename,Object obj,String id){
		Session sess = sf.openSession();						//创建会话
		Transaction t = sess.beginTransaction();				//开始一个事务
		if(tablename.equals("GoodsInfo")){						//当表名为GoodsInfo时
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,id);
			gi.setGname(((GoodsInfo)obj).getGname());			//修改商品名字
			gi.setGcid(((GoodsInfo)obj).getGcid());				//修改商品类别号
			gi.setGunit(((GoodsInfo)obj).getGunit());			//修改商品单位
			gi.setGpin(((GoodsInfo)obj).getGpin());				//修改商品进价
			gi.setGpout(((GoodsInfo)obj).getGpout());			//修改商品售价
			gi.setGamount(((GoodsInfo)obj).getGamount());		//修改商品数量
			sess.save(gi);										//保存对象
		}
		else if(tablename.equals("GoodsClassInfo")){			//当修改类别表时
			GoodsClassInfo gci = (GoodsClassInfo)sess.get(GoodsClassInfo.class,id);
			gci.setGcname(((GoodsClassInfo)obj).getGcname());	//修改名字
			sess.save(gci);										//保存对象
		}
		else if(tablename.equals("ConsumerInfo")){				//当修改客户资料时
			ConsumerInfo ci = (ConsumerInfo)sess.get(ConsumerInfo.class,id);
			ci.setCname(((ConsumerInfo)obj).getCname());		//修改客户名
			ci.setClinkman(((ConsumerInfo)obj).getClinkman());	//修改联系人
			ci.setCaddress(((ConsumerInfo)obj).getCaddress());	//修改公司地址
			ci.setCtel(((ConsumerInfo)obj).getCtel());			//修改电话
			ci.setCemail(((ConsumerInfo)obj).getCemail());		//修改E-mail
			ci.setCremark(((ConsumerInfo)obj).getCremark());	//修改备注
			sess.save(ci);
		}
		else if(tablename.equals("ProviderInfo")){				//当修改供应商对象时
			ProviderInfo pi = (ProviderInfo)sess.get(ProviderInfo.class,id);
			pi.setPname(((ProviderInfo)obj).getPname());		//修改供应商名字
			pi.setPlinkman(((ProviderInfo)obj).getPlinkman());	//修改联系人
			pi.setPaddress(((ProviderInfo)obj).getPaddress());	//修改公司地址
			pi.setPtel(((ProviderInfo)obj).getPtel());			//修改电话
			pi.setPemail(((ProviderInfo)obj).getPemail());		//修改E-mail
			pi.setPremark(((ProviderInfo)obj).getPremark());	//修改备注
			sess.save(pi);										//保存对象
		}
		else if(tablename.equals("StockInfo")){					//当修改采购对象时
			StockInfo si = (StockInfo)sess.get(StockInfo.class,id);
			si.setPid(((StockInfo)obj).getPid());				//修改供应商ID
			si.setSdate(((StockInfo)obj).getSdate());			//修改日期
			si.setSbuyer(((StockInfo)obj).getSbuyer());			//修改采购人
			sess.save(si);										//保存对象
		}
		else if(tablename.equals("StockDetail")){								//当修改采购明细时
			StockDetail sd = (StockDetail)sess.get(StockDetail.class,id);		//得到对象
			StockDetail temp = (StockDetail)obj;								//强制类型转换
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,sd.getGid());	//得到商品对象
			gi.setGamount(gi.getGamount()-sd.getSdamount()+temp.getSdamount());	//修改商品数量
			sess.save(gi);														//保存商品
			sd.setSdamount(temp.getSdamount());									//修改明细数量
			sd.setSdtotalprice(sd.getSdamount()*sd.getSdprice());
			sess.save(sd);														//保存明细对象
			t.commit();
			db.updateTotalprice("StockInfo",sd.getSid());
			t = sess.beginTransaction();
		}
		else if(tablename.equals("SellInfo")){
			SellInfo ei = (SellInfo)sess.get(SellInfo.class,id);
			ei.setCid(((SellInfo)obj).getCid());					//修改客户ID
			ei.setEdate(((SellInfo)obj).getEdate());				//修改日期
			ei.setEseller(((SellInfo)obj).getEseller());			//修改采购人
			sess.save(ei);											//保存对象
		}
		else if(tablename.equals("SellDetail")){								//当修改销售明细时
			SellDetail ed = (SellDetail)sess.get(SellDetail.class,id);			//得到明细对象
			SellDetail temp = (SellDetail)obj;									//强制类型转换
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,ed.getGid());	//得到商品对象
			gi.setGamount(gi.getGamount()+ed.getEdamount()-temp.getEdamount());	//修改商品数量
			sess.save(gi);														//保存商品对象
			ed.setEdamount(temp.getEdamount());									//修改明细数量
			ed.setEdtotalprice(ed.getEdamount()*ed.getEdprice());
			sess.save(ed);														//保存明细对象
			t.commit();
			db.updateTotalprice("SellInfo",ed.getEid());
			t = sess.beginTransaction();
		}
		else if(tablename.equals("AdminInfo")){
			AdminInfo ai = (AdminInfo)sess.get(AdminInfo.class,id);
			AdminInfo temp = (AdminInfo)obj;
			ai.setApwd(temp.getApwd());
			sess.save(ai);
		}
		else if(tablename.equals("ConsumerBackDetail")){						//修改销售退货明细时
			ConsumerBackDetail cbd = (ConsumerBackDetail)sess.get(ConsumerBackDetail.class,id);
			ConsumerBackDetail temp = (ConsumerBackDetail)obj;							//强制类型转换
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,cbd.getGid());			//得到销售商品对象
			gi.setGamount(gi.getGamount()-cbd.getCbdamount()+temp.getCbdamount());		//修改商品数量
			sess.save(gi);																//保存商品对象
			ConsumerBack cb = (ConsumerBack)sess.get(ConsumerBack.class,cbd.getCbid());	//得到退货对象
			String hql = "from SellDetail as ed where ed.eid='"
							+cb.getEid()+"' and ed.gid='"+cbd.getGid()+"'";				//搜索销售对象的hql
			SellDetail sd = ((List<SellDetail>)db.getInfo(hql)).get(0);					//得到销售对象
			SellDetail sdtemp = (SellDetail)sess.get(SellDetail.class,sd.getEdid());	//用get得到销售对象
			sdtemp.setEdamount(sdtemp.getEdamount()+cbd.getCbdamount()-temp.getCbdamount());//修改销售数量
			sdtemp.setEdtotalprice(sdtemp.getEdamount()*sdtemp.getEdprice());			//修改销售总价
			sess.save(sdtemp);															//保存销售对象
			t.commit();
			db.updateTotalprice("SellInfo",sdtemp.getEid());
			t = sess.beginTransaction();
			cbd.setCbdamount(temp.getCbdamount());										//修改明细数量
			cbd.setCbdtotalprice(cbd.getCbdamount()*cbd.getCbdprice());					//修改明细总价
			sess.save(cbd);																//保存明细对象
		}
		else if(tablename.equals("ProviderBackDetail")){
			ProviderBackDetail pbd = (ProviderBackDetail)sess.get(ProviderBackDetail.class,id);
			ProviderBackDetail temp = (ProviderBackDetail)obj;							//强制类型转换
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,pbd.getGid());			//得到销售商品对象
			gi.setGamount(gi.getGamount()+pbd.getPbdamount()-temp.getPbdamount());		//修改商品数量
			sess.save(gi);																//保存商品对象
			ProviderBack pb = (ProviderBack)sess.get(ProviderBack.class,pbd.getPbid());	//得到退货对象
			String hql = "from StockDetail as sd where sd.sid='"
							+pb.getPid()+"' and sd.gid='"+pbd.getGid()+"'";				//搜索采购对象的hql
			StockDetail sd = ((List<StockDetail>)db.getInfo(hql)).get(0);					//得到采购对象
			StockDetail sdtemp = (StockDetail)sess.get(StockDetail.class,sd.getSdid());	//用get得到采购对象
			sdtemp.setSdamount(sdtemp.getSdamount()+pbd.getPbdamount()-temp.getPbdamount());//修改采购数量
			sdtemp.setSdtotalprice(sdtemp.getSdamount()*sdtemp.getSdprice());			//修改采购总价
			sess.save(sdtemp);															//保存采购对象
			t.commit();
			db.updateTotalprice("StockInfo",sdtemp.getSid());								//更新父表总价
			t = sess.beginTransaction();
			pbd.setPbdamount(temp.getPbdamount());										//修改明细数量
			pbd.setPbdtotalprice(pbd.getPbdamount()*pbd.getPbdprice());					//修改明细总价
			sess.save(pbd);																//保存明细对象
		}
		t.commit();													//提交事务
		sess.close();												//关闭会话
	}
}