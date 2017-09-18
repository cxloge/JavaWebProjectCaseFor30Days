package wyf.zrk;

import java.util.*;
import org.springframework.orm.hibernate3.*;
import org.hibernate.*;

public class DBinsert{	
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
	public void insertTable(String tablename,Object obj){		//用来保存对象
		Session sess = sf.openSession();						//创建会话
		Transaction t = sess.beginTransaction();				//创建一个事务
		if(tablename.equals("GoodsInfo")){						//当为商品时
			GoodsInfo gi = (GoodsInfo)obj;						//强制类型转换
			sess.save(gi);										//保存对象
		}
		else if(tablename.equals("GoodsClassInfo")){			//当为商品类别时
			GoodsClassInfo gci = (GoodsClassInfo)obj;			//强制类型转换
			sess.save(gci);										//保存对象
		}
		else if(tablename.equals("ConsumerInfo")){				//当为客户时
			ConsumerInfo ci = (ConsumerInfo)obj;				//强制类型转换
			sess.save(ci);										//保存对象
		}
		else if(tablename.equals("ProviderInfo")){				//当为供应商时
			ProviderInfo pi = (ProviderInfo)obj;				//强制类型转换
			sess.save(pi);										//保存对象
		}
		else if(tablename.equals("StockInfo")){					//当保存采购对象时
			StockInfo si = (StockInfo)obj;						//强制类型转换
			sess.save(si);										//保存对象
		}
		else if(tablename.equals("StockDetail")){				//当保存对象为采购明细时
			StockDetail sd = (StockDetail)obj;					//强制类型转换
			String hql = "from StockDetail as sd where sd.gid='"
						+sd.getGid()+"' and sd.sid='"+sd.getSid()+"'";
			List<StockDetail> list = (List<StockDetail>)db.getInfo(hql);
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,sd.getGid());
			gi.setGamount(gi.getGamount()+sd.getSdamount());	//设置商品数量
			sess.save(gi);										//保存商品对象
			if(!list.isEmpty()){
				StockDetail sdtemp = (StockDetail)sess.get(StockDetail.class,list.get(0).getSdid());
				sdtemp.setSdamount(sdtemp.getSdamount()+sd.getSdamount());
				sdtemp.setSdtotalprice(sdtemp.getSdamount()*sdtemp.getSdprice());
				sess.save(sdtemp);
			}
			else{
				sess.save(sd);										//删除明细对象				
			}
			t.commit();
			db.updateTotalprice("StockInfo",sd.getSid());
			t = sess.beginTransaction();			
		}
		else if(tablename.equals("SellInfo")){					//当保存销售对象时
			SellInfo ei = (SellInfo)obj;						//强制类型转换
			sess.save(ei);										//保存对象
		}
		else if(tablename.equals("SellDetail")){				//当保存销售明细时
			SellDetail ed = (SellDetail)obj;					//强制类型转换
			String hql = "from SellDetail as sd where sd.gid='"
					+ed.getGid()+"' and sd.eid='"+ed.getEid()+"'";
			List<SellDetail> list = (List<SellDetail>)db.getInfo(hql);
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,ed.getGid());
			gi.setGamount(gi.getGamount()-ed.getEdamount());	//设置数量
			sess.save(gi);	
			if(!list.isEmpty()){				
				SellDetail sdtemp = (SellDetail)sess.get(SellDetail.class,list.get(0).getEdid());
				sdtemp.setEdamount(sdtemp.getEdamount()+ed.getEdamount());
				sdtemp.setEdtotalprice(sdtemp.getEdamount()*sdtemp.getEdprice());
				sess.save(sdtemp);
			}
			else{
				sess.save(ed);										//保存对象
			}
			t.commit();
			db.updateTotalprice("SellInfo",ed.getEid());
			t = sess.beginTransaction();
		}
		else if(tablename.equals("AdminInfo")){					//添加管理员对象时
			AdminInfo ai = (AdminInfo)obj;						//强制类型转换
			sess.save(ai);										//保存对象
		}
		else if(tablename.equals("ConsumerBack")){				//添加客户退货
			ConsumerBack cb = (ConsumerBack)obj;				//强制类型转换
			sess.save(cb);										//保存对象
		}
		else if(tablename.equals("ProviderBack")){				//添加采购退货
			ProviderBack pb = (ProviderBack)obj;				//强制类型转换
			sess.save(pb);										//保存对象
		}
		else if(tablename.equals("ConsumerBackDetail")){
			ConsumerBackDetail cbd = (ConsumerBackDetail)obj;			
			ConsumerBack cb = (ConsumerBack)sess.get(ConsumerBack.class,cbd.getCbid());			
			String temp = "from SellDetail as ed where ed.eid='"
						+cb.getEid()+"' and ed.gid='"+cbd.getGid()+"'";
			SellDetail sd = ((List<SellDetail>)db.getInfo(temp)).get(0);		
			String hql = "from ConsumerBackDetail as cbd where cbd.gid='"
					+cbd.getGid()+"' and cbd.cbid='"+cbd.getCbid()+"'";
			List<ConsumerBackDetail> list = (List<ConsumerBackDetail>)db.getInfo(hql);		
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,cbd.getGid());
			gi.setGamount(gi.getGamount()+cbd.getCbdamount());
			sess.save(gi);				
			SellDetail sdtemp = (SellDetail)sess.get(SellDetail.class,sd.getEdid());
			sdtemp.setEdamount(sdtemp.getEdamount()-cbd.getCbdamount());
			sdtemp.setEdtotalprice(sdtemp.getEdamount()*sdtemp.getEdprice());
			sess.save(sdtemp);
			t.commit();
			db.updateTotalprice("SellInfo",sdtemp.getEid());			
			t = sess.beginTransaction();
			if(!list.isEmpty()){				
				ConsumerBackDetail cbdtemp = 
					(ConsumerBackDetail)sess.get(ConsumerBackDetail.class,list.get(0).getCbdid());
				cbdtemp.setCbdamount(cbdtemp.getCbdamount()+cbd.getCbdamount());
				cbdtemp.setCbdtotalprice(cbdtemp.getCbdamount()*cbdtemp.getCbdprice());			
				sess.save(cbdtemp);
			}
			else{				
				sess.save(cbd);			
			}			
		}
		else if(tablename.equals("ProviderBackDetail")){
			ProviderBackDetail pbd = (ProviderBackDetail)obj;
			ProviderBack pb = (ProviderBack)sess.get(ProviderBack.class,pbd.getPbid());
			String temp = "from StockDetail as sd where sd.sid='"
						+pb.getSid()+"' and sd.gid='"+pbd.getGid()+"'";
			StockDetail sd = ((List<StockDetail>)db.getInfo(temp)).get(0);
			String hql = "from ProviderBackDetail as pbd where pbd.gid='"
					+pbd.getGid()+"' and pbd.pbid='"+pbd.getPbid()+"'";
			List<ProviderBackDetail> list = (List<ProviderBackDetail>)db.getInfo(hql);	
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,pbd.getGid());
			gi.setGamount(gi.getGamount()-pbd.getPbdamount());
			sess.save(gi);
			StockDetail sdtemp = (StockDetail)sess.get(StockDetail.class,sd.getSdid());
			sdtemp.setSdamount(sdtemp.getSdamount()-pbd.getPbdamount());
			sdtemp.setSdtotalprice(sdtemp.getSdamount()*sdtemp.getSdprice());
			sess.save(sdtemp);
			t.commit();
			db.updateTotalprice("StockInfo",sdtemp.getSid());
			t = sess.beginTransaction();
			if(!list.isEmpty()){
				ProviderBackDetail pbdtemp = 
					(ProviderBackDetail)sess.get(ProviderBackDetail.class,list.get(0).getPbdid());
				pbdtemp.setPbdamount(pbdtemp.getPbdamount()+pbd.getPbdamount());
				pbdtemp.setPbdtotalprice(pbdtemp.getPbdamount()*pbdtemp.getPbdprice());			
				sess.save(pbdtemp);		
			}
			else{
				sess.save(pbd);
			}
		}
		t.commit();												//提交事务
		sess.close();											//关闭会话
	}
}