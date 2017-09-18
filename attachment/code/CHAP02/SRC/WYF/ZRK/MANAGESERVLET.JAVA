package wyf.zrk;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;
import org.springframework.web.context.support.*;
import org.springframework.web.context.*;
import org.springframework.beans.factory.*;
import java.text.DateFormat;


public class ManageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
				throws ServletException,IOException{
		this.doPost(request,response);							//调用doPost方法
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
				throws ServletException,IOException{
		request.setCharacterEncoding("gbk");					//设置请求编码格式
		response.setCharacterEncoding("gbk");					//设置响应编码
		response.setContentType("text/html;charset=gbk");		//设置请求页面格式
		PrintWriter out = response.getWriter();					//得到输出流对象
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("userBean");
    	if(userBean==null){
    		userBean = new UserBean();
    	}
		//获取WebApplicationContext
		WebApplicationContext wac=
		   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DButil db = (DButil)wac.getBean("DButil");
		DBinsert dbin = (DBinsert)wac.getBean("DBinsert");
		DBupdate dbup = (DBupdate)wac.getBean("DBupdate");
		DBdelete dbde = (DBdelete)wac.getBean("DBdelete");
		String action = request.getParameter("action").trim();	//得到请求动作
		if(action.equals("login")){								//动作为登陆时
			String aname = request.getParameter("uname").trim();//得到用户名
			String apwd = request.getParameter("upwd").trim();	//得到密码
			aname = new String(aname.getBytes(),"ISO-8859-1");	//将用户名转码
			apwd = new String(apwd.getBytes(),"ISO-8859-1");	//将密码转码
			System.out.println(aname+"\t"+apwd);
			String hql = "from AdminInfo as p "+				//hql语句
				"where p.aname='"+aname+"' and p.apwd='"+apwd+"'";
			List<AdminInfo> list = (List<AdminInfo>)db.getInfo(hql);
			String url = "";									//记录提示信息
			if(!list.isEmpty()){
				AdminInfo ai = list.get(0);
				url = "/index.jsp";
				session.setAttribute("admin",aname);			//将管理员名存入session
				session.setAttribute("alevel",ai.getAlevel());	//将管理员级别存入session
			}
			else{
				String msg = "对不起,登陆失败!!!";
				request.setAttribute("msg",msg);				//将错误信息添加到请求中
				url = "/info.jsp";
			}
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response); 						//页面跳转
		}
		else if(action.equals("logout")){						//当管理员注销时
    		request.getSession(true).invalidate();				//使session失效
    		response.sendRedirect("adminlogin.jsp");			//页面跳转
		}
		else if(action.equals("search")){						//请求动作为搜索时
			String key = request.getParameter("key").trim();	//得到搜索关键字
			String type = request.getParameter("type").trim();	//得到搜索类型
			userBean.setNowPage(1);
			key = new String(key.getBytes(),"ISO-8859-1");
			String hql = "";									//记录搜索内容
			String tp = "";										//记录搜索内容总页数
			String url = "";									//用来存放跳转地址
			if(type.equals("goodsinfo")){						//当搜索商品表时
				String myradio = request.getParameter("myradio");
				if(myradio!=null&&myradio.trim().equals("class")){
					hql = "from GoodsInfo as gi where gi.gcid in "+
							"(select gc.gcid from GoodsClassInfo as "+
							"gc where gc.gcname like '%"+key+"%')";
					tp = "select count(*) from GoodsInfo as gi where gi.gcid in "+
							"(select gc.gcid from GoodsClassInfo as "+
							"gc where gc.gcname like '%"+key+"%')";
				}
				else{
					hql = "from GoodsInfo where gname like '%"+key+"%'";
					tp = "select count(*) from GoodsInfo where gname like '%"+key+"%'";
				}
				url = "/goodsmanage.jsp";								//跳转页面
			}
			else if(type.equals("goodsclassinfo")){						//当搜索类别时
				hql = "from GoodsClassInfo where gcname like '%"+key+"%'";//搜索类别的hql
				tp = "select count(*) from GoodsClassInfo where gcname like '%"+key+"%'";//搜索总页数的hql
				url = "/goodsclassmanage.jsp";							//记住跳转页			
			}
			else if(type.equals("consumerinfo")){						//当搜索客户时
				hql = "from ConsumerInfo where cname like '%"+key+"%'";	//得到搜索的hql
				tp = "select count(*) from ConsumerInfo where cname like '%"+key+"%'"; //搜索总页数的hql
				url = "/consumermanage.jsp";							//要跳转到的url			
			}
			else if(type.equals("providerinfo")){
				hql = "from ProviderInfo where pname like '%"+key+"%'";	//得到搜索的hql
				tp = "select count(*) from ProviderInfo where pname like '%"+key+"%'"; //搜索总页数的hql
				url = "/providermanage.jsp";							//要跳转到的url			
			}
			else if(type.equals("stockinfo")){
				hql = "from StockInfo where sid like '%"+key+"%'";		//得到搜索的hql
				tp = "select count(*) from StockInfo where sid like '%"+key+"%'";//得到搜索总页数的hql
				url = "/stockmanage.jsp";								//要跳转到的url				
			}
			else if(type.equals("sellinfo")){
				hql = "from SellInfo where eid like '%"+key+"%'";		//得到搜索对象的hql
				tp = "select count(*) from SellInfo where eid like '%"+key+"%'";//得到搜索总页数的hql
				url = "/sellmanage.jsp";								//要跳转到的url		
			}
			else if(type.equals("admininfo")){
				hql = "from AdminInfo where aname like '%"+key+"%'";	//得到搜索对象的hql
				tp = "select count(*) from AdminInfo where aname like '%"+key+"%'";//得到搜索总页数的hql
				url = "/adminmanage.jsp";								//要跳转到的url
			}
			else if(type.equals("sta")){								//库存统计
				String myradio = request.getParameter("myradio").trim();
				int gamount = Integer.parseInt(key);
				if(myradio.equals("more")){
					hql = "from GoodsInfo as gi where gi.gamount>="+gamount;
					tp = "select count(*) from GoodsInfo as gi where gi.gamount>="+gamount;
				}
				else{
					hql = "from GoodsInfo as gi where gi.gamount<="+gamount;
					tp = "select count(*) from GoodsInfo as gi where gi.gamount<="+gamount;
				}
				url = "/statistic.jsp";									//要跳转到的url
			}
			else if(type.equals("consumerback")){						//客户退货
				hql = "from ConsumerBack as cb where cb.cbid like '%"+key+"%'";
				tp = "select count(*) from ConsumerBack as cb where cb.cbid like '%"+key+"%'";
				url = "/consumerbackmanage.jsp";				
			}
			else if(type.equals("providerback")){
				hql = "from ProviderBack as pb where pb.pbid like '%"+key+"%'";
				tp = "select count(*) from ProviderBack as pb where pb.pbid like '%"+key+"%'";
				url = "/providerbackmanage.jsp";
			}	
			userBean.setHql(hql);										//记住当前hql
			userBean.setPageHql(tp);									//记住搜索总页数的hql
			int totalPage = db.getTotalPage(tp,userBean.getSpan());
			userBean.setTotalPage(totalPage);							//记住当前总页数
			List list = db.getPageContent(hql,userBean.getNowPage(),userBean.getSpan());			
			request.setAttribute("goodslist",list);						//将页面内容放入请求中											
			ServletContext sc = getServletContext();					//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);								//页面跳转
		}
		else if(action.equals("changePage")){
			String page = request.getParameter("page").trim();				//得到要跳转到的页数
			String url = request.getParameter("pagename").trim();			//得到页面的名字
			userBean.setNowPage(Integer.parseInt(page));					//记录页数
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到商品列表	
			request.setAttribute("goodslist",goodslist);					//将列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("addGoods")){
			String gname = request.getParameter("gname").trim();	//得到商品名称
			String gcname = request.getParameter("gcname").trim();	//得到商品类别
			String gunit = request.getParameter("gunit").trim();	//得到商品单位
			String pin = request.getParameter("gpin").trim();		//得到商品进价
			String pout = request.getParameter("gpout").trim();		//得到商品售价
			String amount = request.getParameter("gamount").trim();	//得到商品数量
			String gid = db.getId("GoodsInfo","gid");				//得到商品的ID
			gname = new String(gname.getBytes(),"ISO-8859-1");		//转码
			gcname = new String(gcname.getBytes(),"ISO-8859-1");	//转码
			String hql = "select gg.gcid from GoodsClassInfo as gg where gg.gcname='"+gcname+"'";
			String gcid = (String)((db.getInfo(hql)).get(0));		//得到类别ID			
			String temp = "from GoodsInfo as gi where gi.gname='"+gname+"'";
			List li = db.getInfo(temp);
			String url = "";
			if(li.isEmpty()){
				gunit = new String(gunit.getBytes(),"ISO-8859-1");		//转码
				double gpin = Double.parseDouble(pin);					//将String转为double型
				double gpout = Double.parseDouble(pout);				//将String转为double型
				int gamount = Integer.parseInt(amount);					//将String转为int型
				GoodsInfo gi = new GoodsInfo(gid,gname,gcid,gunit,gpin,gpout,gamount);	
				dbin.insertTable("GoodsInfo",gi);							//更新表格
				//out.println("eval(\'alert(\'恭喜你,添加成功!!!\')\')");			
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
				userBean.setTotalPage(totalPage);						//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());	//得到商品列表
				request.setAttribute("goodslist",goodslist);			//将列表放到请求中				
				url = "/goodsmanage.jsp";
			}
			else{
				url = "/info.jsp";
				String msg = "该物品已经存在,不可添加!!!";
				request.setAttribute("msg",msg);
			}
			ServletContext sc = getServletContext();				//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);							//页面跳转				
		}
		else if(action.equals("lookGoods")){
			String gid = request.getParameter("gid").trim();		//得到商品ID
			GoodsInfo gi = (GoodsInfo)db.getObject("GoodsInfo",gid);//得到商品对象
			request.setAttribute("object",gi);						//将商品对象放入请求中
			ServletContext sc = getServletContext();				//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifygoods.jsp");
			rd.forward(request,response);							//页面跳转
		}
		else if(action.equals("modifyGoods")){
			String gid = request.getParameter("gid").trim();		//得到商品的ID
			String gname = request.getParameter("gname").trim();	//得到商品名称
			String gcname = request.getParameter("gcname").trim();	//得到商品类别
			String gunit = request.getParameter("gunit").trim();	//得到商品单位
			String pin = request.getParameter("gpin").trim();		//得到商品进价
			String pout = request.getParameter("gpout").trim();		//得到商品售价
			String amount = request.getParameter("gamount").trim();	//得到商品数量
			gname = new String(gname.getBytes(),"ISO-8859-1");		//转码			
			gcname = new String(gcname.getBytes(),"ISO-8859-1");	//转码
			gunit = new String(gunit.getBytes(),"ISO-8859-1");		//转码
			double gpin = Double.parseDouble(pin);					//将String转为double型
			double gpout = Double.parseDouble(pout);				//将String转为double型
			int gamount = Integer.parseInt(amount);					//将String转为int型
			String hql = "select gcid from GoodsClassInfo where gcname='"+gcname+"'";
			String gcid = (String)((db.getInfo(hql)).get(0));		//得到类别ID
			GoodsInfo gi = new GoodsInfo(gid,gname,gcid,gunit,gpin,gpout,gamount);
			dbup.updateTable("GoodsInfo",gi,gid);
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());
			request.setAttribute("goodslist",goodslist);			//
			ServletContext sc = getServletContext();				//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsmanage.jsp");
			rd.forward(request,response);							//页面跳转
		}
		else if(action.equals("deleteGoods")){								//当动作为删除商品时
			String gid = request.getParameter("gid").trim();				//得到商品ID
			dbde.deleteTable("GoodsInfo",gid);
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
			userBean.setTotalPage(totalPage);								//记住当前总页数		
			userBean.setNowPage(1);											//设置当前页为1
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到商品列表	
			request.setAttribute("goodslist",goodslist);					//将列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addGoodsClass")){							//当动作为添加商品类别时
			String gcname = request.getParameter("gcname").trim();			//得到要添加的类名
			gcname = new String(gcname.getBytes(),"ISO-8859-1");			//将类名转码			
			String hql = "from GoodsClassInfo as gci where gci.gcname='"+gcname+"'";
			List gclist = db.getInfo(hql);
			String url = "/goodsclassmanage.jsp";
			if(gclist.isEmpty()){
				String gcid = db.getId("GoodsClassInfo","gcid");				//得到要插入的类的ID
				GoodsClassInfo gci = new GoodsClassInfo(gcid,gcname);
				dbin.insertTable("GoodsClassInfo",gci);
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
				userBean.setTotalPage(totalPage);						//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());	//得到商品类别列表
				request.setAttribute("goodslist",goodslist);			//将列表放到请求中				
			}
			else{
				url = "/info.jsp";
				String msg = "该类别已经存在!!!";
				request.setAttribute("msg",msg);
			}

			ServletContext sc = getServletContext();				//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);							//页面跳转			
		}
		else if(action.equals("lookGoodsClass")){
			String gcid = request.getParameter("gcid").trim();						//得到商品类别ID
			GoodsClassInfo gci =(GoodsClassInfo)db.getObject("GoodsClassInfo",gcid);//得到类别对象
			request.setAttribute("object",gci);										//将类别对象放入请求中
			ServletContext sc = getServletContext();								//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifygoodsclass.jsp");
			rd.forward(request,response);											//页面跳转
		}
		else if(action.equals("modifyGoodsClass")){						//修改商品类别时
			String gcid = request.getParameter("gcid").trim();			//得到要修改类的ID
			String gcname = request.getParameter("gcname").trim();		//得到类名
			gcname = new String(gcname.getBytes(),"ISO-8859-1");		//将类名转码
			String url = "/goodsclassmanage.jsp";
			String hql = "from GoodsClassInfo as gci where gci.gcname='"+gcname+"'";
			List list = db.getInfo(hql);
			if(list.isEmpty()){
				GoodsClassInfo gci = new GoodsClassInfo(gcid,gcname);		//创建对象
				dbup.updateTable("GoodsClassInfo",gci,gcid);					//更新对象
				List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到要显示的内容
				request.setAttribute("goodslist",goodslist);				//将内容存入请求中				
			}
			else{
				url = "/info.jsp";
				String msg = "该类名已经存在,不可修改!!!";
				request.setAttribute("msg",msg);
			}
			ServletContext sc = getServletContext();					//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);								//页面跳转
		}
		else if(action.equals("deleteGoodsClass")){
			String gcid = request.getParameter("gcid").trim();				//得到类别ID
			dbde.deleteTable("GoodsClassInfo",gcid);							//将该对象删除
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
			userBean.setTotalPage(totalPage);								//记住当前总页数		
			userBean.setNowPage(1);											//设置当前页为1
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到商品列表	
			request.setAttribute("goodslist",goodslist);					//将列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsclassmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addConsumer")){
			String cname = request.getParameter("cname").trim();			//得到客户名
			String clinkman = request.getParameter("clinkman").trim();		//得到联系人
			String caddress = request.getParameter("caddress").trim();		//得到公司地址
			String ctel = request.getParameter("ctel").trim();				//得到公司电话
			String cemail = request.getParameter("cemail").trim();			//得到公司E-mail
			String cremark = request.getParameter("cremark").trim();		//得到客户备注
			if(cemail.equals("")){
				cemail = "暂无";
			}
			if(cremark.equals("")){
				cremark = "暂无";
			}
			cname = new String(cname.getBytes(),"ISO-8859-1");				//将名字转码
			clinkman = new String(clinkman.getBytes(),"ISO-8859-1");		//将联系人转码
			caddress = new String(caddress.getBytes(),"ISO-8859-1");		//将地址转码
			ctel = new String(ctel.getBytes(),"ISO-8859-1");				//将电话转码
			cemail = new String(cemail.getBytes(),"ISO-8859-1");			//将E-mail转码
			cremark = new String(cremark.getBytes(),"ISO-8859-1");			//将备注转码
			String url = "/consumermanage.jsp";
			String temp = "from ConsumerInfo as ci where ci.cname='"+cname+"'";
			List clist = db.getInfo(temp);
			if(clist.isEmpty()){
				String cid = db.getId("ConsumerInfo","cid");					//得到ID
				ConsumerInfo ci = new ConsumerInfo(cid,cname,clinkman,caddress,ctel,cemail,cremark);
				dbin.insertTable("ConsumerInfo",ci);						//更新表格		
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
				userBean.setTotalPage(totalPage);						//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());	//得到列表
				request.setAttribute("goodslist",goodslist);			//将列表放到请求中				
			}
			else{
				String msg = "该客户已存在!!!";
				url = "/info.jsp";
				request.setAttribute("msg",msg);
			}
			ServletContext sc = getServletContext();				//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);							//页面跳转			
		}
		else if(action.equals("lookConsumer")){
			String cid = request.getParameter("cid").trim();					//得到客户ID
			String type = request.getParameter("type").trim();					//得到查看类型
			String url = "/lookconsumer.jsp";									//跳转页面
			if(type.equals("modify")){											//当类型为修改时
				url = "/modifyconsumer.jsp";									//更改URL
			}
			ConsumerInfo ci =(ConsumerInfo)db.getObject("ConsumerInfo",cid);	//得到对象
			request.setAttribute("object",ci);									//将类别对象放入请求中
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("modifyConsumer")){
			System.out.println("modifyConsumer");
			String cid = request.getParameter("cid").trim();
			String cname = request.getParameter("cname").trim();			//得到客户名
			String clinkman = request.getParameter("clinkman").trim();		//得到联系人
			String caddress = request.getParameter("caddress").trim();		//得到公司地址
			String ctel = request.getParameter("ctel").trim();				//得到公司电话
			String cemail = request.getParameter("cemail").trim();			//得到公司E-mail
			String cremark = request.getParameter("cremark").trim();		//得到客户备注
			if(cemail.equals("")){
				cemail = "暂无";
			}
			if(cremark.equals("")){
				cremark = "暂无";
			}
			cname = new String(cname.getBytes(),"ISO-8859-1");				//将名字转码
			clinkman = new String(clinkman.getBytes(),"ISO-8859-1");		//将联系人转码
			caddress = new String(caddress.getBytes(),"ISO-8859-1");		//将地址转码
			ctel = new String(ctel.getBytes(),"ISO-8859-1");				//将电话转码
			cemail = new String(cemail.getBytes(),"ISO-8859-1");			//将E-mail转码
			cremark = new String(cremark.getBytes(),"ISO-8859-1");			//将备注转码
			ConsumerInfo ci = new ConsumerInfo(cid,cname,clinkman,caddress,ctel,cemail,cremark);
			dbup.updateTable("ConsumerInfo",ci,cid);						//更新表格			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());		//得到列表
			request.setAttribute("goodslist",goodslist);				//将列表放到请求中
			ServletContext sc = getServletContext();					//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/consumermanage.jsp");
			rd.forward(request,response);								//页面跳转
		}		
		else if(action.equals("deleteConsumer")){
			String cid = request.getParameter("cid").trim();				//得到客户ID
			dbde.deleteTable("ConsumerInfo",cid);								//将该对象删除
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
			userBean.setTotalPage(totalPage);								//记住当前总页数		
			userBean.setNowPage(1);											//设置当前页为1
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到列表	
			request.setAttribute("goodslist",goodslist);					//将列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/consumermanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addProvider")){			
			String pname = request.getParameter("pname").trim();			//得到供应商名
			String plinkman = request.getParameter("plinkman").trim();		//得到联系人
			String paddress = request.getParameter("paddress").trim();		//得到公司地址
			String ptel = request.getParameter("ptel").trim();				//得到公司电话
			String pemail = request.getParameter("pemail").trim();			//得到公司E-mail
			String premark = request.getParameter("premark").trim();		//得到客户备注
			if(pemail.equals("")){
				pemail = "暂无";
			}
			if(premark.equals("")){
				premark = "暂无";
			}
			pname = new String(pname.getBytes(),"ISO-8859-1");				//将名字转码
			plinkman = new String(plinkman.getBytes(),"ISO-8859-1");		//将联系人转码
			paddress = new String(paddress.getBytes(),"ISO-8859-1");		//将地址转码
			ptel = new String(ptel.getBytes(),"ISO-8859-1");				//将电话转码
			pemail = new String(pemail.getBytes(),"ISO-8859-1");			//将E-mail转码
			premark = new String(premark.getBytes(),"ISO-8859-1");			//将备注转码			
			String temp = "from ProviderInfo as pi where pi.pname='"+pname+"'";
			List plist = db.getInfo(temp);
			String url = "/providermanage.jsp";
			if(plist.isEmpty()){
				String pid = db.getId("ProviderInfo","pid");					//得到ID
				ProviderInfo pi = new ProviderInfo(pid,pname,plinkman,paddress,ptel,pemail,premark);
				dbin.insertTable("ProviderInfo",pi);								//更新表格		
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
				userBean.setTotalPage(totalPage);								//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());			//得到列表
				request.setAttribute("goodslist",goodslist);					//将列表放到请求中				
			}
			else{
				url = "/info.jsp";
				String msg = "该供应商已经存在!!!";
				request.setAttribute("msg",msg);
			}
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("lookProvider")){
			String pid = request.getParameter("pid").trim();				//得到供应商ID
			String type = request.getParameter("type").trim();				//得到查看类型
			String url = "/lookprovider.jsp";								//跳转地址
			if(type.equals("modify")){										//当类型为修改时
				url = "/modifyprovider.jsp";
			}
			ProviderInfo pi =(ProviderInfo)db.getObject("ProviderInfo",pid);//得到对象
			request.setAttribute("object",pi);								//将对象放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("modifyProvider")){
			String pid = request.getParameter("pid").trim();				//得到供应商ID
			String pname = request.getParameter("pname").trim();			//得到供应商名
			String plinkman = request.getParameter("plinkman").trim();		//得到联系人
			String paddress = request.getParameter("paddress").trim();		//得到公司地址
			String ptel = request.getParameter("ptel").trim();				//得到公司电话
			String pemail = request.getParameter("pemail").trim();			//得到公司E-mail
			String premark = request.getParameter("premark").trim();		//得到客户备注
			if(pemail.equals("")){
				pemail = "暂无";
			}
			if(premark.equals("")){
				premark = "暂无";
			}
			pname = new String(pname.getBytes(),"ISO-8859-1");				//将名字转码
			plinkman = new String(plinkman.getBytes(),"ISO-8859-1");		//将联系人转码
			paddress = new String(paddress.getBytes(),"ISO-8859-1");		//将地址转码
			ptel = new String(ptel.getBytes(),"ISO-8859-1");				//将电话转码
			pemail = new String(pemail.getBytes(),"ISO-8859-1");			//将E-mail转码
			premark = new String(premark.getBytes(),"ISO-8859-1");			//将备注转码
			ProviderInfo pi = new ProviderInfo(pid,pname,plinkman,paddress,ptel,pemail,premark);
			dbup.updateTable("ProviderInfo",pi,pid);							//更新表格				
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/providermanage.jsp");
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("deleteProvider")){
			String pid = request.getParameter("pid").trim();				//得到供应商ID
			dbde.deleteTable("ProviderInfo",pid);								//将该对象删除
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
			userBean.setTotalPage(totalPage);								//记住当前总页数		
			userBean.setNowPage(1);											//设置当前页为1
			List goodslist = db.getPageContent(userBean.getHql(),
								userBean.getNowPage(),userBean.getSpan());	//得到列表	
			request.setAttribute("goodslist",goodslist);					//将列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/providermanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addStock")){
			String stp = request.getParameter("stp").trim();				//得到总价格
			String pname = request.getParameter("pname").trim();			//得到供应商
			String sbuyer = request.getParameter("sbuyer").trim();			//得到采购人
			double stotalprice = Double.parseDouble(stp);					//类型转换
			pname = new String(pname.getBytes(),"ISO-8859-1");				//将供应商名转码
			sbuyer = new String(sbuyer.getBytes(),"ISO-8859-1");			//将采购人转码
			String hql = "select pid from ProviderInfo where pname='"+pname+"'";
			String pid = (String)((db.getInfo(hql)).get(0));				//得到供应商ID			
			String sid = db.getId("StockInfo","sid");						//得到要插入的类的ID
			StockInfo si = new StockInfo(sid,pid,new Date(),stotalprice,sbuyer);
			dbin.insertTable("StockInfo",si);									//插入记录			
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setTotalPage(totalPage);								//记住当前总页数			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/stockmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("lookStock")){
			String sid = request.getParameter("sid").trim();				//得到采购表ID
			String type = request.getParameter("type").trim();				//得到查看
			String url = "/addstockdetail.jsp";								//目的地
			if(type.equals("look")){										//当为查看时
				url = "/lookstock.jsp";										//设置URL
			}
			else if(type.equals("modify")){									//当为修改时
				url = "/modifystock.jsp";									//设置URL
			}
			StockInfo si =(StockInfo)db.getObject("StockInfo",sid);			//得到对象
			String hql = "from StockDetail as sd where sd.sid='"+sid+"'";	//搜索对象的hql
			List<StockDetail> list = (List<StockDetail>)db.getInfo(hql);	//得到对象列表			
			request.setAttribute("si",si);									//将对象放到请求中
			request.setAttribute("list",list);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("addStockDetail")){							//当添加采购明细
			String sid = request.getParameter("sid").trim();				//得到采购单ID
			String amount = request.getParameter("sdamount").trim();		//得到采购数量
			String gname = request.getParameter("gname").trim();			//得到商品名字
			gname = new String(gname.getBytes(),"ISO-8859-1");				//将商品名字转码
			String hql = "from GoodsInfo as gi where gi.gname='"+gname+"'";	//搜索商品
			List<GoodsInfo> list = (List<GoodsInfo>)db.getInfo(hql);		//得到商品列表
			GoodsInfo gi = list.get(0);										//得到商品对象
			String sdid = db.getId("StockDetail","sdid");					//得到明细ID
			int sdamount = Integer.parseInt(amount);						//转换类型
			double sdprice = gi.getGpin();									//进价
			double sdtotalprice = sdprice*sdamount;							//得到总价
			StockDetail sd = new StockDetail(sdid,sid,gi.getGid(),sdamount,sdprice,sdtotalprice);
			dbin.insertTable("StockDetail",sd);								//插入记录
			StockInfo si =(StockInfo)db.getObject("StockInfo",sid);			//得到采购对象
			String temp = "from StockDetail as sd where sd.sid='"+sid+"'";	//搜索对象的hql
			List<StockDetail> li = (List<StockDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("si",si);									//将对象放到请求中
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/addstockdetail.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("modifyStock")){									//当修改采购信息时
			String sid = request.getParameter("sid").trim();					//得到采购ID
			String pname = request.getParameter("pname").trim();				//得到供应商名字
			String sbuyer = request.getParameter("sbuyer").trim();				//得到采购者
			String sdate = request.getParameter("sdate").trim();				//得到采购日期
			sbuyer = new String(sbuyer.getBytes(),"ISO-8859-1");				//转码
			pname = new String(pname.getBytes(),"ISO-8859-1");					//软码
			String hql = "from ProviderInfo as pi where pi.pname='"+pname+"'";	//搜索供应商ID的hql			
			ProviderInfo pi = (ProviderInfo)db.getInfo(hql).get(0);				//得到供应商对象
			StockInfo si = (StockInfo)db.getObject("StockInfo",sid);			//得到采购对象
			si.setPid(pi.getPid());												//设置采购商ID
			si.setSdate(db.getDate(sdate));										//设置采购日期
			si.setSbuyer(sbuyer);												//设置采购者
			dbup.updateTable("StockInfo",si,sid);									//执行更新
			String temp = "from StockDetail as sd where sd.sid='"+sid+"'";	//搜索对象的hql
			List<StockDetail> li = (List<StockDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("si",si);									//将对象放到请求中
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifystock.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("modifyStockDetail")){						//修改采购明细时
			String sdid = request.getParameter("sdid").trim();				//得到采购明细ID
			String sdamount = request.getParameter("sdamount").trim();		//得到修改数量
			StockDetail sd = (StockDetail)db.getObject("StockDetail",sdid);	//得到采购明细对象
			sd.setSdamount(Integer.parseInt(sdamount));						//设置数量
			dbup.updateTable("StockDetail",sd,sdid);							//执行更新
			String sid = sd.getSid();										//得到Sid
			StockInfo si =(StockInfo)db.getObject("StockInfo",sid);			//得到采购对象
			String temp = "from StockDetail as sd where sd.sid='"+sid+"'";	//搜索对象的hql
			List<StockDetail> li = (List<StockDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("si",si);									//将对象放到
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifystock.jsp");
			rd.forward(request,response);									//页面跳转			
		}
		else if(action.equals("deleteStockDetail")){
			String sdid = request.getParameter("sdid").trim();
			String sid = request.getParameter("sid").trim();
			StockDetail sd = (StockDetail)db.getObject("StockDetail",sdid);
			dbde.deleteTable("StockDetail",sdid);
			StockInfo si =(StockInfo)db.getObject("StockInfo",sid);			//得到采购对象
			String temp = "from StockDetail as sd where sd.sid='"+sid+"'";	//搜索对象的hql
			List<StockDetail> li = (List<StockDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("si",si);									//将对象放到请求中
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifystock.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("deleteStock")){
			String sid = request.getParameter("sid").trim();
			dbde.deleteTable("StockInfo",sid);
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setNowPage(1);											//设置当前页为第一页
			userBean.setTotalPage(totalPage);								//记住当前总页数			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/stockmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addSell")){
			String cname = request.getParameter("cname").trim();			//得到客户名称
			String etp = request.getParameter("etotalprice").trim();		//得到总价格
			String eseller = request.getParameter("eseller").trim();		//得到销售表
			double etotalprice = Double.parseDouble(etp);					//类型转换
			eseller = new String(eseller.getBytes(),"ISO-8859-1");			//转码
			cname = new String(cname.getBytes(),"ISO-8859-1");				//转码
			String hql = "select cid from ConsumerInfo where cname ='"+cname+"'";
			String cid = (String)((db.getInfo(hql)).get(0));				//得到客户ID
			String eid = db.getId("SellInfo","eid");						//得到销售ID
			SellInfo ei = new SellInfo(eid,cid,new Date(),etotalprice,eseller);
			dbin.insertTable("SellInfo",ei);									//插入记录		
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setTotalPage(totalPage);								//记住当前总页数			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/sellmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("lookSell")){
			String eid = request.getParameter("eid").trim();				//得到销售表ID
			String type = request.getParameter("type").trim();				//得到查看
			String url = "/addselldetail.jsp";								//目的地
			if(type.equals("look")){										//当为查看时
				url = "/looksell.jsp";										//设置URL
			}
			else if(type.equals("modify")){									//当为修改时
				url = "/modifysell.jsp";									//设置URL
			}
			SellInfo ei =(SellInfo)db.getObject("SellInfo",eid);			//得到对象
			String hql = "from SellDetail as ed where ed.eid='"+eid+"'";	//搜索对象的hql
			List<SellDetail> list = (List<SellDetail>)db.getInfo(hql);		//得到对象列表			
			request.setAttribute("ei",ei);									//将对象放到请求中
			request.setAttribute("list",list);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("addSellDetail")){
			String eid = request.getParameter("eid").trim();				//得到销售单ID
			String amount = request.getParameter("edamount").trim();		//得到销售数量
			String gname = request.getParameter("gname").trim();			//得到商品名字
			gname = new String(gname.getBytes(),"ISO-8859-1");				//将商品名字转码
			String hql = "from GoodsInfo as gi where gi.gname='"+gname+"'";	//搜索商品
			List<GoodsInfo> list = (List<GoodsInfo>)db.getInfo(hql);		//得到商品列表
			GoodsInfo gi = list.get(0);										//得到商品对象
			String edid = db.getId("SellDetail","edid");					//得到明细ID
			int edamount = Integer.parseInt(amount);						//转换类型
			String url = "/addselldetail.jsp";
			if(gi.getGamount()>=edamount){										//商品数量够时
				double edprice = gi.getGpout();									//售价
				double edtotalprice = edprice*edamount;							//得到总价
				SellDetail ed = new SellDetail(edid,eid,gi.getGid(),edamount,edprice,edtotalprice);
				dbin.insertTable("SellDetail",ed);								//插入记录
				SellInfo ei =(SellInfo)db.getObject("SellInfo",eid);			//得到采购对象
				String temp = "from SellDetail as sd where sd.eid='"+eid+"'";	//搜索对象的hql
				List<SellDetail> li = (List<SellDetail>)db.getInfo(temp);		//得到对象列表
				request.setAttribute("ei",ei);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中				
			}
			else{																//商品数量不足
				url = "/info.jsp";												//跳转页面
				String msg = "商品数量不足,剩余量为:"+gi.getGamount();		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("modifySell")){			
			String eid = request.getParameter("eid").trim();					//得到采购ID
			String cname = request.getParameter("cname").trim();				//得到供应商名字
			String eseller = request.getParameter("eseller").trim();				//得到采购者
			String edate = request.getParameter("edate").trim();				//得到采购日期
			eseller = new String(eseller.getBytes(),"ISO-8859-1");				//转码
			cname = new String(cname.getBytes(),"ISO-8859-1");					//软码
			String hql = "from ConsumerInfo as ci where ci.cname='"+cname+"'";	//搜索供应商ID的hql			
			ConsumerInfo ci = (ConsumerInfo)db.getInfo(hql).get(0);				//得到供应商对象
			SellInfo ei = (SellInfo)db.getObject("SellInfo",eid);			//得到采购对象
			ei.setCid(ci.getCid());												//设置采购商ID
			ei.setEdate(db.getDate(edate));										//设置采购日期
			ei.setEseller(eseller);												//设置采购者
			dbup.updateTable("SellInfo",ei,eid);									//执行更新
			String temp = "from SellDetail as ed where ed.eid='"+eid+"'";	//搜索对象的hql
			List<SellDetail> li = (List<SellDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("ei",ei);									//将对象放到请求中
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifysell.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("modifySellDetail")){
			String edid = request.getParameter("edid").trim();				//得到销售明细ID
			String amount = request.getParameter("edamount").trim();		//得到修改数量
			int edamount = Integer.parseInt(amount);
			SellDetail ed = (SellDetail)db.getObject("SellDetail",edid);	//得到销售明细对象
			GoodsInfo gi = (GoodsInfo)db.getObject("GoodsInfo",ed.getGid());
			String url = "/modifysell.jsp";
			if((gi.getGamount()+ed.getEdamount()-edamount)>=0){
				ed.setEdamount(edamount);										//设置数量
				dbup.updateTable("SellDetail",ed,edid);							//执行更新
				String eid = ed.getEid();										//得到Eid
				SellInfo ei =(SellInfo)db.getObject("SellInfo",eid);			//得到销售对象
				String temp = "from SellDetail as ed where ed.eid='"+eid+"'";	//搜索对象的hql
				List<SellDetail> li = (List<SellDetail>)db.getInfo(temp);		//得到对象列表
				request.setAttribute("ei",ei);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中				
			}
			else{
				url = "/info.jsp";												//跳转页面
				String msg = "商品数量不足,剩余量为:"+gi.getGamount();		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("deleteSellDetail")){							//当动作为删除销售明细时
			String edid = request.getParameter("edid").trim();				//得到明细ID
			String eid = request.getParameter("eid").trim();				//得到销售ID
			SellDetail ed = (SellDetail)db.getObject("SellDetail",edid);	//得到销售明细对象
			dbde.deleteTable("SellDetail",edid);								//删除对象
			SellInfo ei =(SellInfo)db.getObject("SellInfo",eid);			//得到销售对象
			String temp = "from SellDetail as ed where ed.eid='"+eid+"'";	//搜索对象的hql
			List<SellDetail> li = (List<SellDetail>)db.getInfo(temp);		//得到对象列表
			request.setAttribute("ei",ei);									//将对象放到请求中
			request.setAttribute("list",li);								//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifysell.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("deleteSell")){								//当动作为删除销售时
			String eid = request.getParameter("eid").trim();				//得到销售ID
			dbde.deleteTable("SellInfo",eid);
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setNowPage(1);											//设置当前页为第一页
			userBean.setTotalPage(totalPage);								//记住当前总页数			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/sellmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("changepwd")){								//修改密码
			String aname = request.getParameter("aname").trim();
			String apwd = request.getParameter("apwd").trim();
			String fpwd = request.getParameter("fpwd").trim();
			aname = new String(aname.getBytes(),"ISO-8859-1");	//将用户名转码
			apwd = new String(apwd.getBytes(),"ISO-8859-1");	//将密码转码
			fpwd = new String(fpwd.getBytes(),"ISO-8859-1");	//将新密码转码
			String hql = "from AdminInfo as p "+				//hql语句
				"where p.aname='"+aname+"' and p.apwd='"+apwd+"'";
			String msg = "";									//记录提示信息			
			List<AdminInfo> list = (List<AdminInfo>)db.getInfo(hql);
			if(!list.isEmpty()){
				AdminInfo ai = list.get(0);
				ai.setApwd(fpwd);
				dbup.updateTable("AdminInfo",ai,ai.getAid());
				msg = "密码修改成功!!!";
			}
			else{
				msg = "对不起,用户名或密码错误!!!";	
			}	
			request.setAttribute("msg",msg);				//将错误信息添加到请求中
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/info.jsp");
			rd.forward(request,response); 						//页面跳转
		}
		else if(action.equals("addAdmin")){
			String aname = request.getParameter("aname").trim();			//得到管理员名称
			String apwd = request.getParameter("apwd").trim();				//得到密码
			aname = new String(aname.getBytes(),"ISO-8859-1");				//转码
			apwd = new String(apwd.getBytes(),"ISO-8859-1");				//转码
			String hql = "from AdminInfo as ai where ai.aname='"+aname+"'";	//搜索管理员
			List list = db.getInfo(hql);									//得到列表
			String url = "";												//用来存放跳转地址
			if(list.isEmpty()){												//当管理员不存在时
				String aid = db.getId("AdminInfo","aid");					//得到管理员ID
				AdminInfo ai = new AdminInfo(aid,aname,apwd,new String("普通".getBytes(),"ISO-8859-1"));
				dbin.insertTable("AdminInfo",ai);								//添加对象
				url = "/adminmanage.jsp";									//设置跳转地址
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());
				userBean.setTotalPage(totalPage);								//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());			//得到列表
				request.setAttribute("goodslist",goodslist);					//将列表放到请求中
			}
			else{															//当管理员存在时
				String msg = "对不起,该管理员已经存在!!!";					//提示信息
				request.setAttribute("msg",msg);							//将信息放入请求中
				url = "/info.jsp";											//设置跳转地址
			}
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("deleteAdmin")){						//当动作为删除管理员时
			String aid = request.getParameter("aid").trim();
			AdminInfo ai = (AdminInfo)db.getObject("AdminInfo",aid);
			String alevel = new String(ai.getAlevel().getBytes("ISO-8859-1"),"gbk");
			String url = "/adminmanage.jsp";
			if(alevel.equals("普通")){
				dbde.deleteTable("AdminInfo",aid);
				int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
				userBean.setNowPage(1);											//设置当前页为第一页
				userBean.setTotalPage(totalPage);								//记住当前总页数			
				List goodslist = db.getPageContent(userBean.getHql(),
							userBean.getNowPage(),userBean.getSpan());			//得到列表
				request.setAttribute("goodslist",goodslist);					//将列表放到请求中				
			}
			else{
				String msg = "超级管理员不可以删除!!!";
				request.setAttribute("msg",msg);
				url = "/info.jsp";
			}
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("resetApwd")){
			String aname = request.getParameter("aname").trim();			//得到管理员名称
			String apwd = request.getParameter("apwd").trim();				//得到新密码
			aname = new String(aname.getBytes(),"ISO-8859-1");				//转码
			apwd = new String(apwd.getBytes(),"ISO-8859-1");				//转码
			
			String hql = "from AdminInfo where aname='"+aname+"'";
			AdminInfo ai = ((List<AdminInfo>)db.getInfo(hql)).get(0);
			ai.setApwd(apwd);
			dbup.updateTable("AdminInfo",ai,ai.getAid());
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中			
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/adminmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addConsumerBack")){
			String eid = request.getParameter("eid").trim();				//得到销售表ID
			String cbid = db.getId("ConsumerBack","cbid");					//得到要添加的ID
			SellInfo si = (SellInfo)db.getObject("SellInfo",eid);			//得到销售表对象
			String cid = si.getCid();										//得到客户ID
			ConsumerBack cb = new ConsumerBack(cbid,cid,eid,new Date());	//得到退货对象
			dbin.insertTable("ConsumerBack",cb);								//添加对象
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setTotalPage(totalPage);								//记住当前总页数
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中			
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/consumerbackmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("addProviderBack")){
			String sid = request.getParameter("sid").trim();				//得到采购表ID
			String pbid = db.getId("ProviderBack","pbid");					//得到要添加的ID
			StockInfo si = (StockInfo)db.getObject("StockInfo",sid);			//得到采购表对象
			String pid = si.getPid();										//得到供应商ID
			ProviderBack pb = new ProviderBack(pbid,pid,sid,new Date());	//得到退货对象
			dbin.insertTable("ProviderBack",pb);								//添加对象
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setTotalPage(totalPage);								//记住当前总页数			
			List goodslist = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());			//得到列表
			request.setAttribute("goodslist",goodslist);					//将列表放到请求中			
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/providerbackmanage.jsp");
			rd.forward(request,response);									//页面跳转
		}
		else if(action.equals("lookConsumerBack")){
			String cbid = request.getParameter("cbid").trim();				//得到退货表ID
			String type = request.getParameter("type").trim();				//得到查看类型
			String url = "/addconsumerbackdetail.jsp";						//跳转URL
			if(type.equals("look")){										//当查看类型为look时
				url = "/lookconsumerback.jsp";								//设置URL
			}
			else if(type.equals("modify")){									//当查看类型为modify时
				url = "/modifyconsumerback.jsp";													//设置URL
			}
			ConsumerBack cb = (ConsumerBack)db.getObject("ConsumerBack",cbid);			//得到对象
			String hql = "from ConsumerBackDetail as cbd where cbd.cbid='"+cbid+"'";	//搜索对象的hql
			List<ConsumerBackDetail> list = (List<ConsumerBackDetail>)db.getInfo(hql);	//得到对象列表
			request.setAttribute("cb",cb);												//将对象放到请求中
			request.setAttribute("list",list);											//将对象列表放入请求中
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转	
		}
		else if(action.equals("lookProviderBack")){
			String pbid = request.getParameter("pbid").trim();				//得到采购表ID
			String type = request.getParameter("type").trim();				//得到查看类型
			String url = "/addproviderbackdetail.jsp";
			if(type.equals("look")){										//当查看类型为look时
				url = "/lookproviderback.jsp";													//设置URL
			}
			else if(type.equals("modify")){									//当查看类型为modify时
				url = "/modifyproviderback.jsp";													//设置URL
			}
			ProviderBack pb = (ProviderBack)db.getObject("ProviderBack",pbid);	//得到采购退货对象
			String hql = "from ProviderBackDetail as pbd where pbd.pbid='"+pbid+"'";
			List<ProviderBackDetail> list = (List<ProviderBackDetail>)db.getInfo(hql);
			request.setAttribute("pb",pb);
			request.setAttribute("list",list);
			ServletContext sc = getServletContext();						//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);									//页面跳转			
		}
		else if(action.equals("addConsumerBackDetail")){			
			String cbid = request.getParameter("cbid").trim();				//得到退货单ID
			String gname = request.getParameter("gname").trim();			//得到退货商品名
			String amount = request.getParameter("cbdamount").trim();		//得到退货数量
			gname = new String(gname.getBytes(),"ISO-8859-1");				//将商品名字转码			
			String hql = "from GoodsInfo as gi where gi.gname='"+gname+"'";	//搜索商品			
			List<GoodsInfo> list = (List<GoodsInfo>)db.getInfo(hql);		//得到商品列表			
			GoodsInfo gi = list.get(0);										//得到商品对象			
			String gid = gi.getGid();
			ConsumerBack cb = (ConsumerBack)db.getObject("ConsumerBack",cbid);
			int cbdamount = Integer.parseInt(amount);				//转换类型
			double cbdprice = gi.getGpout();
			double cbdtotalprice = cbdprice*cbdamount;			
			String temp = "from SellDetail as ed where ed.eid='"
						+cb.getEid()+"' and ed.gid='"+gi.getGid()+"'";
			SellDetail sd = ((List<SellDetail>)db.getInfo(temp)).get(0);
			String cbdid = db.getId("ConsumerBackDetail","cbdid");			//得到明细ID		
			String url = "/addconsumerbackdetail.jsp";
			if(sd.getEdamount()>=cbdamount){
				ConsumerBackDetail cbd = new ConsumerBackDetail(cbdid,cbid,gid,cbdamount,cbdprice,cbdtotalprice);
				dbin.insertTable("ConsumerBackDetail",cbd);
				String cbdtemp = "from ConsumerBackDetail as cbd where cbd.cbid='"+cbid+"'";	//搜索对象的hql
				List<ConsumerBackDetail> li = (List<ConsumerBackDetail>)db.getInfo(cbdtemp);		//得到对象列表				
				request.setAttribute("cb",cb);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中
			}
			else{
				url = "/info.jsp";												//跳转页面
				String msg = "退货数量超出销售数量,销售量为:"+sd.getEdamount();		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中		
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("addProviderBackDetail")){			
			String pbid = request.getParameter("pbid").trim();				//得到退货单ID
			String gname = request.getParameter("gname").trim();			//得到退货商品名
			String amount = request.getParameter("pbdamount").trim();		//得到退货数量
			gname = new String(gname.getBytes(),"ISO-8859-1");				//将商品名字转码			
			String hql = "from GoodsInfo as gi where gi.gname='"+gname+"'";	//搜索商品			
			List<GoodsInfo> list = (List<GoodsInfo>)db.getInfo(hql);		//得到商品列表			
			GoodsInfo gi = list.get(0);										//得到商品对象			
			String gid = gi.getGid();
			ProviderBack pb = (ProviderBack)db.getObject("ProviderBack",pbid);
			int pbdamount = Integer.parseInt(amount);				//转换类型
			double pbdprice = gi.getGpin();
			double pbdtotalprice = pbdprice*pbdamount;			
			String temp = "from StockDetail as sd where sd.sid='"
						+pb.getSid()+"' and sd.gid='"+gi.getGid()+"'";
			StockDetail sd = ((List<StockDetail>)db.getInfo(temp)).get(0);
			String pbdid = db.getId("ProviderBackDetail","pbdid");			//得到明细ID		
			String url = "/addproviderbackdetail.jsp";
			if(sd.getSdamount()>=pbdamount){
				ProviderBackDetail pbd = new ProviderBackDetail(pbdid,pbid,gid,pbdamount,pbdprice,pbdtotalprice);
				dbin.insertTable("ProviderBackDetail",pbd);
				String pbdtemp = "from ProviderBackDetail as pbd where pbd.pbid='"+pbid+"'";	//搜索对象的hql
				List<ProviderBackDetail> li = (List<ProviderBackDetail>)db.getInfo(pbdtemp);		//得到对象列表				
				request.setAttribute("pb",pb);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中
			}
			else{
				url = "/info.jsp";												//跳转页面
				String msg = "退货数量超出采购数量,采购量为:"+sd.getSdamount();		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中		
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("modifyConsumerBackDetail")){
			String cbdid = request.getParameter("cbdid").trim();				//得到退货明细ID
			String amount = request.getParameter("cbdamount").trim();			//得到修改后数量
			int cbdamount = Integer.parseInt(amount);							//数量类型转换
			ConsumerBackDetail cbd = (ConsumerBackDetail)db.getObject("ConsumerBackDetail",cbdid);	//得到明细对象
			ConsumerBack cb = (ConsumerBack)db.getObject("ConsumerBack",cbd.getCbid());//得到退货单对象
			String hql = "from SellDetail as ed where ed.eid='"
							+cb.getEid()+"' and ed.gid='"+cbd.getGid()+"'";
			SellDetail sd = ((List<SellDetail>)db.getInfo(hql)).get(0);			//得到对应的销售明细对象
			String url = "/modifyconsumerback.jsp";								//跳转地址
			if(sd.getEdamount()+cbd.getCbdamount()>=cbdamount){
				cbd.setCbdamount(cbdamount);
				dbup.updateTable("ConsumerBackDetail",cbd,cbdid);
				String cbdtemp = "from ConsumerBackDetail as cbd where cbd.cbid='"+cb.getCbid()+"'";	//搜索对象的hql
				List<ConsumerBackDetail> li = (List<ConsumerBackDetail>)db.getInfo(cbdtemp);		//得到对象列表				
				request.setAttribute("cb",cb);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中
			}
			else{
				url = "/info.jsp";												//跳转页面
				String msg = "退货数量超出销售数量,最大退货量为:"
									+(sd.getEdamount()+cbd.getCbdamount());		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中		
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转	
		}
		else if(action.equals("deleteConsumerBackDetail")){
			String cbdid = request.getParameter("cbdid").trim();
			String cbid = request.getParameter("cbid").trim();
			ConsumerBackDetail cbd = (ConsumerBackDetail)db.getObject("ConsumerBackDetail",cbdid);
			dbde.deleteTable("ConsumerBackDetail",cbdid);			
			ConsumerBack cb = (ConsumerBack)db.getObject("ConsumerBack",cbid);			
			String cbdtemp = "from ConsumerBackDetail as cbd where cbd.cbid='"+cbid+"'";	//搜索对象的hql
			List<ConsumerBackDetail> li = (List<ConsumerBackDetail>)db.getInfo(cbdtemp);	//得到对象列表										
			request.setAttribute("cb",cb);													//将对象放到请求中
			request.setAttribute("list",li);												//将对象列表放入请求中			
			ServletContext sc = getServletContext();										//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifyconsumerback.jsp");
			rd.forward(request,response);													//页面跳转
		}
		else if(action.equals("modifyProviderBackDetail")){
			String pbdid = request.getParameter("pbdid").trim();				//得到退货明细ID
			String amount = request.getParameter("pbdamount").trim();			//得到修改后数量
			int pbdamount = Integer.parseInt(amount);							//数量类型转换
			ProviderBackDetail pbd = (ProviderBackDetail)db.getObject("ProviderBackDetail",pbdid);	//得到明细对象
			ProviderBack pb = (ProviderBack)db.getObject("ProviderBack",pbd.getPbid());//得到退货单对象
			String hql = "from StockDetail as sd where sd.sid='"
							+pb.getSid()+"' and sd.gid='"+pbd.getGid()+"'";
			StockDetail sd = ((List<StockDetail>)db.getInfo(hql)).get(0);			//得到对应的销售明细对象
			String url = "/modifyproviderback.jsp";									//跳转地址
			if(sd.getSdamount()+pbd.getPbdamount()>=pbdamount){
				pbd.setPbdamount(pbdamount);
				dbup.updateTable("ProviderBackDetail",pbd,pbdid);
				String pbdtemp = "from ProviderBackDetail as pbd where pbd.pbid='"+pb.getPbid()+"'";	//搜索对象的hql
				List<ProviderBackDetail> li = (List<ProviderBackDetail>)db.getInfo(pbdtemp);		//得到对象列表				
				request.setAttribute("pb",pb);									//将对象放到请求中
				request.setAttribute("list",li);								//将对象列表放入请求中
			}
			else{
				url = "/info.jsp";												//跳转页面
				String msg = "退货数量超出采购数量,最大退货量为:"
									+(sd.getSdamount()+pbd.getPbdamount());		//提示信息
				request.setAttribute("msg",msg);								//将信息放入请求中		
			}
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);										//页面跳转			
		}
		else if(action.equals("deleteProviderBackDetail")){
			String pbdid = request.getParameter("pbdid").trim();							//得到要删除的明细ID
			String pbid = request.getParameter("pbid").trim();								//得到采购ID
			ProviderBackDetail pbd = (ProviderBackDetail)db.getObject("ProviderBackDetail",pbdid);//得到明细对象
			dbde.deleteTable("ProviderBackDetail",pbdid);										//删除对象
			ProviderBack pb = (ProviderBack)db.getObject("ProviderBack",pbid);				//得到采购对象
			String pbdtemp = "from ProviderBackDetail as pbd where pbd.pbid='"+pbid+"'";	//搜索对象的hql
			List<ProviderBackDetail> li = (List<ProviderBackDetail>)db.getInfo(pbdtemp);	//得到对象列表										
			request.setAttribute("pb",pb);													//将对象放到请求中
			request.setAttribute("list",li);												//将对象列表放入请求中			
			ServletContext sc = getServletContext();										//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/modifyproviderback.jsp");
			rd.forward(request,response);													//页面跳转
		}
		else if(action.equals("deleteProviderBack")){
			String pbid = request.getParameter("pbid").trim();					//得到要删除的退货表ID
			dbde.deleteTable("ProviderBack",pbid);			
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setNowPage(1);												//设置当前页为第一页
			userBean.setTotalPage(totalPage);									//记住当前总页数			
			List list = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());				//得到列表
			request.setAttribute("goodslist",list);								//将列表放到请求中
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/providerbackmanage.jsp");
			rd.forward(request,response);										//页面跳转
		}
		else if(action.equals("deleteConsumerBack")){
			String cbid = request.getParameter("cbid").trim();					//得到要删除的退货表ID
			dbde.deleteTable("ConsumerBack",cbid);			
			int totalPage = db.getTotalPage(userBean.getPageHql(),userBean.getSpan());			
			userBean.setNowPage(1);												//设置当前页为第一页
			userBean.setTotalPage(totalPage);									//记住当前总页数			
			List list = db.getPageContent(userBean.getHql(),
						userBean.getNowPage(),userBean.getSpan());				//得到列表
			request.setAttribute("goodslist",list);								//将列表放到请求中
			ServletContext sc = getServletContext();							//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/consumerbackmanage.jsp");
			rd.forward(request,response);										//页面跳转
		}
	}
}