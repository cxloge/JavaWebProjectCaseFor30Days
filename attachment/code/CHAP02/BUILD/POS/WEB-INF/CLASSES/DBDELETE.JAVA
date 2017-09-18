package wyf.zrk;

import java.util.*;
import org.springframework.orm.hibernate3.*;
import org.hibernate.*;

public class DBdelete{	
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
	public void deleteTable(String tablename,String id){
		Session sess = sf.openSession();							//创建会话
		Transaction t = sess.beginTransaction();					//开始一个事务
		if(tablename.equals("GoodsInfo")){							//当表名为GoodsInfo时
			GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,id);	//得到对象
			if(gi!=null){
				sess.delete(gi);									//将该对象删除
			}
		}
		else if(tablename.equals("GoodsClassInfo")){				//删除类别对象时
			GoodsClassInfo gci = (GoodsClassInfo)sess.get(GoodsClassInfo.class,id);
			if(gci!=null){
				sess.delete(gci);									//删除
			}
		}
		else if(tablename.equals("ConsumerInfo")){					//删除客户对象时
			ConsumerInfo ci = (ConsumerInfo)sess.get(ConsumerInfo.class,id);
			if(ci!=null){
				sess.delete(ci);									//删除对象
			}
		}
		else if(tablename.equals("ProviderInfo")){					//删除供应商对象时
			ProviderInfo pi = (ProviderInfo)sess.get(ProviderInfo.class,id);
			if(pi!=null){											//当对象不为空
				sess.delete(pi);									//删除对象
			}
		}
		else if(tablename.equals("StockDetail")){
			StockDetail sd = (StockDetail)sess.get(StockDetail.class,id);		//得到StockDetail对象
			if(sd!=null){
				GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,sd.getGid());//得到GoodsInfo对象
				gi.setGamount(gi.getGamount()-sd.getSdamount());	//何改数量	
				sess.save(gi);										//保存对象		
				sess.delete(sd);									//删除对象		
				t.commit();
				db.updateTotalprice("StockInfo",sd.getSid());			//更新父表总价
				t = sess.beginTransaction();
			}
		}
		else if(tablename.equals("StockInfo")){						//当删除对象为stockinfo时
			StockInfo si = (StockInfo)sess.get(StockInfo.class,id);	//得到对象
			if(si!=null){											//当对象不为空时
				String hql = "from StockDetail as sd where sd.sid='"+id+"'";		//得到明细列表的hql
				List<StockDetail> list = (List<StockDetail>)db.getInfo(hql);			//得到列表
				for(StockDetail sd:list){											//循环
					GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,sd.getGid());//得到GoodsInfo对象
					gi.setGamount(gi.getGamount()-sd.getSdamount());				//何改数量	
					sess.save(gi);													//保存对象
				}				
				sess.delete(si);													//删除对象
			}
		}
		else if(tablename.equals("SellDetail")){									//当删除销售明细对象时
			SellDetail ed = (SellDetail)sess.get(SellDetail.class,id);				//得到明细对象
			if(ed!=null){															//当对象不为空时
				GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,ed.getGid());	//得到商品对象
				gi.setGamount(gi.getGamount()+ed.getEdamount());					//修改商品数量
				sess.save(gi);														//保存商品对象
				sess.delete(ed);													//删除明细
				t.commit();
				db.updateTotalprice("SellInfo",ed.getEid());							//更新父表总价
				t = sess.beginTransaction();
			}
		}
		else if(tablename.equals("SellInfo")){
			SellInfo ei = (SellInfo)sess.get(SellInfo.class,id);					//得到要删除的对象
			if(ei!=null){															//当对象存在
				String hql = "from SellDetail as ed where ed.eid='"+id+"'";			//搜索对应的明细
				List<SellDetail> list = (List<SellDetail>)db.getInfo(hql);				//得到明细对象
				for(SellDetail ed:list){
					GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,ed.getGid());//得到GoodsInfo对象
					gi.setGamount(gi.getGamount()+ed.getEdamount());				//何改数量	
					sess.save(gi);													//保存对象	
				}
				sess.delete(ei);													//删除对象
			}			
		}
		else if(tablename.equals("AdminInfo")){										//删除管理员时
			AdminInfo ai = (AdminInfo)sess.get(AdminInfo.class,id);					//得到管理员对象
			if(ai!=null){															//当对象不为空
				sess.delete(ai);													//删除对象
			}
		}
		else if(tablename.equals("ConsumerBackDetail")){										//删除客户退货明细
			ConsumerBackDetail cbd = (ConsumerBackDetail)sess.get(ConsumerBackDetail.class,id);	//得到对象
			if(cbd!=null){																		//当对象不为空
				ConsumerBack cb = (ConsumerBack)sess.get(ConsumerBack.class,cbd.getCbid());		//得到客户对象
				String hql = "from SellDetail as ed where ed.eid='"
							+cb.getEid()+"' and ed.gid='"+cbd.getGid()+"'";
				SellDetail temp = ((List<SellDetail>)db.getInfo(hql)).get(0);						//得到对应的销售明细对象
				SellDetail sd = (SellDetail)sess.get(SellDetail.class,temp.getEdid());			//得到明细对象
				sd.setEdamount(sd.getEdamount()+cbd.getCbdamount());							//修改销售数量
				sd.setEdtotalprice(sd.getEdamount()*sd.getEdprice());							//修改销售总价格
				sess.save(sd);																	//保存对象
				GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,cbd.getGid());				//得到商品对象
				gi.setGamount(gi.getGamount()-cbd.getCbdamount());								//修改商品数量
				sess.save(gi);																	//保存商品对象
				sess.delete(cbd);																//删除明细对象
				t.commit();
				db.updateTotalprice("SellInfo",sd.getEid());										//更新父表总价格
				t = sess.beginTransaction();
			}			
		}
		else if(tablename.equals("ProviderBackDetail")){
			ProviderBackDetail pbd = (ProviderBackDetail)sess.get(ProviderBackDetail.class,id);	//得到对象
			if(pbd!=null){																		//当对象不为空
				ProviderBack pb = (ProviderBack)sess.get(ProviderBack.class,pbd.getPbid());		//得到供应商对象
				String hql = "from StockDetail as sd where sd.sid='"
							+pb.getSid()+"' and sd.gid='"+pbd.getGid()+"'";
				StockDetail temp = ((List<StockDetail>)db.getInfo(hql)).get(0);					//得到对应的采购明细对象
				StockDetail sd = (StockDetail)sess.get(StockDetail.class,temp.getSdid());		//得到明细对象
				sd.setSdamount(sd.getSdamount()+pbd.getPbdamount());							//修改采购数量
				sd.setSdtotalprice(sd.getSdamount()*sd.getSdprice());							//修改采购总价格
				sess.save(sd);																	//保存对象
				GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,pbd.getGid());				//得到商品对象
				gi.setGamount(gi.getGamount()+pbd.getPbdamount());								//修改商品数量
				sess.save(gi);																	//保存商品对象
				sess.delete(pbd);																//删除明细对象
				t.commit();
				db.updateTotalprice("StockInfo",sd.getSid());										//更新父表总价格
				t = sess.beginTransaction();
			}
		}
		else if(tablename.equals("ProviderBack")){
			ProviderBack pb = (ProviderBack)sess.get(ProviderBack.class,id);					//得到要删除的对象
			if(pb!=null){
				String pbdtemp = "from ProviderBackDetail as pbd where pbd.pbid='"+pb.getPbid()+"'";
				List<ProviderBackDetail> list = (List<ProviderBackDetail>)db.getInfo(pbdtemp);
				for(ProviderBackDetail pbd:list){
					String hql = "from StockDetail as sd where sd.sid='"
								+pb.getSid()+"' and sd.gid='"+pbd.getGid()+"'";
					StockDetail temp = ((List<StockDetail>)db.getInfo(hql)).get(0);					//得到对应的采购明细对象
					StockDetail sd = (StockDetail)sess.get(StockDetail.class,temp.getSdid());		//得到明细对象
					sd.setSdamount(sd.getSdamount()+pbd.getPbdamount());							//修改采购数量
					sd.setSdtotalprice(sd.getSdamount()*sd.getSdprice());							//修改采购总价格
					sess.save(sd);																	//保存对象
					GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,pbd.getGid());				//得到商品对象
					gi.setGamount(gi.getGamount()+pbd.getPbdamount());								//修改商品数量
					sess.save(gi);																	//保存商品对象
					sess.delete(pbd);																//删除明细对象
					t.commit();
					db.updateTotalprice("StockInfo",sd.getSid());										//更新父表总价格
					t = sess.beginTransaction();
				}
				sess.delete(pb);
			}
		}
		else if(tablename.equals("ConsumerBack")){
			ConsumerBack cb = (ConsumerBack)sess.get(ConsumerBack.class,id);					//得到要删除的对象	
			if(cb!=null){
				String cbdtemp = "from ConsumerBackDetail as cbd where cbd.cbid='"+cb.getCbid()+"'";
				List<ConsumerBackDetail> list = (List<ConsumerBackDetail>)db.getInfo(cbdtemp);
				for(ConsumerBackDetail cbd:list){					
					String hql = "from SellDetail as ed where ed.eid='"
								+cb.getEid()+"' and ed.gid='"+cbd.getGid()+"'";
					SellDetail temp = ((List<SellDetail>)db.getInfo(hql)).get(0);						//得到对应的销售明细对象
					SellDetail sd = (SellDetail)sess.get(SellDetail.class,temp.getEdid());			//得到明细对象
					sd.setEdamount(sd.getEdamount()+cbd.getCbdamount());							//修改销售数量
					sd.setEdtotalprice(sd.getEdamount()*sd.getEdprice());							//修改销售总价格
					sess.save(sd);																	//保存对象
					GoodsInfo gi = (GoodsInfo)sess.get(GoodsInfo.class,cbd.getGid());				//得到商品对象
					gi.setGamount(gi.getGamount()-cbd.getCbdamount());								//修改商品数量
					sess.save(gi);																	//保存商品对象
					sess.delete(cbd);																//删除明细对象
					t.commit();
					db.updateTotalprice("SellInfo",sd.getEid());
					t = sess.beginTransaction();
				}		
				sess.delete(cb);
			}		
		}
		t.commit();										//提交事务
		sess.close();									//关闭会话
	}
}