package wyf.cgq;
import java.util.*;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateTemplate;
public class LoginDB{
	private SessionFactory sf;//声明Hibernate的会话工厂
	public void setSf(SessionFactory sf){
		this.sf=sf;//会话工厂的setter方法
	}
	public List getUser(String hql){//获得用户的方法
		Session session=sf.openSession();//打开会话
		Query q=session.createQuery(hql);//查询Hql
		List list=q.list();//获得查询列表
		session.close();//关闭会话
		return list;//返回查询出来的列表
	}
}