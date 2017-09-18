package wyf.zrk;

import java.util.*;
import org.springframework.orm.hibernate3.*;
import org.hibernate.*;

public class DButil {
	private SessionFactory sf;
	public SessionFactory getSf(){
		return this.sf;
	}
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	public String getId(String tablename,String columnname){
		Session sess = sf.openSession();						//创建会话
		String hql = "select Max("+columnname+") from "+tablename;
		Query q = sess.createQuery(hql);						//进行查询
		List<String> result = q.list();							//得到结果列表
		if(result.get(0)==null){								//当表中没有记录进
			return "10001";
		}
		int id = Integer.parseInt(result.get(0));				//将id转化为int型
		id++;													//将id自加
		sess.close();
		return Integer.valueOf(id).toString();					//返回id
	}
	public List<?> getInfo(String hql){
		Session sess = sf.openSession();						//创建会话
		Query q = sess.createQuery(hql);						//执行查询
		List<?> list = q.list();								//得到结果列表
		sess.close();
		return list;											//将结果列表返回
	}
	public List<?> getPageContent(String hql,int page,int span){//得到某页的内容
		List temp = new ArrayList();							//创建list,用来存放页面内容
		Session sess = sf.openSession();						//创建会话
		Query q = sess.createQuery(hql);						//执行查询
		List list = q.list();									//得到结果
		int i = 0;												//标志位,用来记录条数
		while((page-1)*span+i<list.size()&&i<span){							
			temp.add(list.get((page-1)*span+i));				//将结果添加到temp中
			i++;												//标志位自加
		}
		sess.close();
		return temp;											//将结果返回
	}
	public int getTotalPage(String hql,int span){				//用来得到总页数
		Session sess = sf.openSession();						//创建会话
		Query q = sess.createQuery(hql);						//执行查询
		List<Long> list = q.list();								//得到结果列表
		int count = (list.get(0)).intValue();					//得到总记录条数
		int page = (count%span==0)?(count/span):(count/span+1);	//得到总页数
		sess.close();
		return page;											//将总页数返回
	}
	public List<String> getGoodsClass(){
		Session sess = sf.openSession();						//得到session对象
		String hql = "select gcname from GoodsClassInfo";		//得到所有的类名的hql
		Query q = sess.createQuery(hql);						//执行查询
		List<String> name = q.list();							//得到列表
		sess.close();
		return name;											//将结果返回
	}

	public Object getObject(String tablename,String id){
		Session sess = sf.openSession();						//创建会话
		Object obj = null;										//声明引用
		if(tablename.equals("GoodsInfo")){						//当得到商品对象时
			obj = sess.get(GoodsInfo.class,id);					//得到对象			
		}
		else if(tablename.equals("GoodsClassInfo")){			//当得到类别对象时
			obj = sess.get(GoodsClassInfo.class,id);			//得到对象
		}
		else if(tablename.equals("ConsumerInfo")){				//得到客户对象时
			obj = sess.get(ConsumerInfo.class,id);				//得到对象
		}
		else if(tablename.equals("ProviderInfo")){				//得到供应商对象时
			obj = sess.get(ProviderInfo.class,id);				//得到对象
		}
		else if(tablename.equals("StockInfo")){					//得到采购信息时
			obj = sess.get(StockInfo.class,id);					//得到对象
		}
		else if(tablename.equals("StockDetail")){				//当得到采购明细时
			obj = sess.get(StockDetail.class,id);				//得到对象
		}
		else if(tablename.equals("SellInfo")){					//当得到销售对象时
			obj = sess.get(SellInfo.class,id);					//得到对象
		}
		else if(tablename.equals("SellDetail")){				//当得到销售明细对象时
			obj = sess.get(SellDetail.class,id);				//得到对象
		}
		else if(tablename.equals("AdminInfo")){
			obj = sess.get(AdminInfo.class,id);
		}
		else if(tablename.equals("ConsumerBack")){
			obj = sess.get(ConsumerBack.class,id);
		}
		else if(tablename.equals("ProviderBack")){
			obj = sess.get(ProviderBack.class,id);
		}
		else if(tablename.equals("ConsumerBackDetail")){
			obj = sess.get(ConsumerBackDetail.class,id);
		}
		else if(tablename.equals("ProviderBackDetail")){
			obj = sess.get(ProviderBackDetail.class,id);
		}
		sess.close();											//关闭会话
		return obj;												//返回对象
	}

	public List<String> getProvider(){
		Session sess = sf.openSession();				//创建会话
		String hql = "select pname from ProviderInfo";	//得到所有的供应商的hql
		Query q = sess.createQuery(hql);				//执行查询
		List<String> name = q.list();					//得到列表
		sess.close();
		return name;									//将结果返回
	}
	public List<String> getGoods(){
		Session sess = sf.openSession();				//创建会话
		String hql = "select gname from GoodsInfo";		//得到搜索商品名字的hql
		Query q = sess.createQuery(hql);				//执行搜索
		List<String> name  = q.list();					//得到列表
		sess.close();									//关闭会话
		return name;									//返回
	}
	public List<String> getConsumer(){
		Session sess = sf.openSession();				//创建会话
		String hql = "select cname from ConsumerInfo";	//得到搜索客户名字的hql
		Query q = sess.createQuery(hql);				//执行查询
		List<String> name = q.list();					//得到列表
		sess.close();									//关闭会话
		return name;									//返回
	}
	public List<String> getAdmin(){
		Session sess = sf.openSession();				//创建会话
		String hql = "select aname from AdminInfo";		//得到搜索管理员名字的hql
		Query q = sess.createQuery(hql);				//执行查询
		List<String> name = q.list();					//得到列表
		sess.close();									//关闭会话
		return name;									//返回
	}
	public Date getDate(String now){
		String[] dd = now.split("-");					//将时期分割
		int year = Integer.parseInt(dd[0])-1900;		//得到年份
		int month = Integer.parseInt(dd[1])-1;			//得到月份
		int day = Integer.parseInt(dd[2]);				//得到天数
		return new Date(year,month,day);				//返回日期对象
	}
	public void updateTotalprice(String name,String id){
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();					//开始一个事务
		if(name.equals("StockInfo")){
			String hql = "select sum(sd.sdtotalprice) from"+
						" StockDetail as sd where sd.sid='"+id+"'";
			List<Double> list = (List<Double>)getInfo(hql);
			StockInfo si = (StockInfo)sess.get(StockInfo.class,id);
			si.setStotalprice(list.get(0));
			sess.save(si);
		}
		else if(name.equals("SellInfo")){
			String hql = "select sum(sd.edtotalprice) from"+
							" SellDetail as sd where sd.eid='"+id+"'";
			List<Double> list = (List<Double>)getInfo(hql);
			SellInfo si = (SellInfo)sess.get(SellInfo.class,id);
			si.setEtotalprice(list.get(0));
			sess.save(si);
		}
		t.commit();
		sess.close();
	}
}