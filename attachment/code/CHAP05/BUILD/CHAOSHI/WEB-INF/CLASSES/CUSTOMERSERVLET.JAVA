package wyf.hxl;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CustomerServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		this.doPost(request,response);	
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		request.setCharacterEncoding("GB2312");
		response.setCharacterEncoding("GB2312");
		response.setContentType("text/html;charset=GB2312");
		HttpSession session=request.getSession(true);
		PrintWriter out=response.getWriter();
		PaginationBean handlePage = (PaginationBean)session.getAttribute("handlePage");
		if(handlePage==null){
			handlePage = new PaginationBean();
			session.setAttribute("handlePage",handlePage);
		}		
		String action=request.getParameter("action");
		if(action==null){return;}
		if(action.equals("denglu"))	
		{
			String zname = request.getParameter("zname");
			String zpassword = request.getParameter("zpassword");
			String cname = new String(zname.getBytes(),"ISO-8859-1");
			String sql = "select cname from gcustomer where cname='"+cname+"' and cpw='"+zpassword+"'";
			boolean s = DB.selectMsg(sql);
			if(s)
			{
				session.setAttribute("user",zname);
				String fromWhere=(String)session.getAttribute("fromWhere");
				if(fromWhere!=null)
				{
					if(fromWhere.equals("jz"))
					{//回结账
						this.getServletContext().getRequestDispatcher("/CustomerServlet?action=jiezhang").forward(request,response);
						return;
					}
					else if(fromWhere.equals("wddd"))
					{//回我的订单
						this.getServletContext().getRequestDispatcher("/CustomerServlet?action=modify2").forward(request,response);
						return;						
					}
					else if(fromWhere.equals("mmcz"))
					{//回密码重置
						this.getServletContext().getRequestDispatcher("/customerpwchange.jsp").forward(request,response);
						return;						
					}										
				}		
				this.getServletContext().getRequestDispatcher("/pagination.jsp").forward(request,response);
			}		
		    else
		    {
			   String msg = "对不起,登录失败,请重新登录!!!";
			   request.setAttribute("msg",msg);
			   this.getServletContext().getRequestDispatcher("/customermanage.jsp").forward(request,response);
		    }
		}
		else if(action.equals("zhuce")){
			String zname = request.getParameter("cname");
			String zpassword = request.getParameter("cpassword");
			String spw = request.getParameter("spw");
			String email = request.getParameter("email");
			String cname = new String(zname.getBytes(),"ISO-8859-1");
			String cpw = new String(zpassword.getBytes(),"ISO-8859-1");
			String cemail = new String(email.getBytes(),"ISO-8859-1");
			String sql = "select cname from gcustomer where cname='"+cname+"'";
			boolean s = DB.selectMsg(sql);
			if(s)
			{
				String msg ="网络有重名，请重新注册！！";
				request.setAttribute("msg",msg);
				this.getServletContext().getRequestDispatcher("/customerzc.jsp").forward(request,response);
			}
			else{
				String sql0 = "insert into gcustomer(cname,cpw,cemail)"+" values('"+cname+"','"+cpw+"','"+cemail+"')";
				int flag=DB.updateMeg(sql0);
				if(flag==0)	
				{
					String msg = "注册失败，请重新注册！！";
					request.setAttribute("msg",msg);
					this.getServletContext().getRequestDispatcher("/customerzc.jsp").forward(request,response);
				}
				else{
					session.setAttribute("user",cname);
					this.getServletContext().getRequestDispatcher("/pagination.jsp").forward(request,response);
				}
			}
		}
		else if(action.equals("resetpwd"))
    	{//重置密码时
    		String aname = (String)session.getAttribute("user");
    		String apwd = request.getParameter("apwd").trim();
    		String temp = "select * from gcustomer where cname='"+aname+"'";
    		temp = new String(temp.getBytes(),"ISO-8859-1");
    		boolean flag = DB.selectMsg(temp);
    		String msg = "";
    		if(!flag)
    		{
    			msg = "对不起,用户名错误！";
    		}
    		else
    		{
    			String sql = "update gcustomer set cpw='"+apwd+"' where cname='"+aname+"'";
    			sql = new String(sql.getBytes(),"ISO-8859-1");
    			int i = DB.updateMeg(sql);
    			if(i==1)
    			{
    				msg="恭喜您,密码修改成功！";
    			}
    			else
    			{
    				msg = "对不起,密码修改失败！";    				
    			}
    		}
    		request.setAttribute("msg",msg);
    		this.getServletContext().getRequestDispatcher("/customerpwchange.jsp").forward(request,response);
    	}
		else if(action.equals("logout"))
		{
			//当用户注销登录时
    		//使session失效
    		request.getSession(true).invalidate();
    		response.sendRedirect("pagination.jsp");
    	}
    	else if(action.equals("quanbuxinxi"))
    	{
			handlePage.setShowPage(1);
			String sql = "select goodsid,goodsname,gprice,gtype,gimgurl,gamount from goodsmessage";
			handlePage.setSql(sql);
			int totolPage = DB.totolPage(sql);
			handlePage.setTotolPage(totolPage);	
			Vector<String[]> vv = DB.selectPageMeg(1,sql);
			if(vv.size()==0)
			{
				String msg = "商场已经售空商品！！";
				pageForward(msg,request,response);
			}
			else
			{
				request.setAttribute("vv",vv);
    			String url = "/pagination.jsp";
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher(url);
				rd.forward(request,response);
			}
    	}
		else if(action.equals("searchthing"))
		{	
			String searchthing = request.getParameter("searchthings").trim();
			handlePage.setShowPage(1);
			String searchth = new String(searchthing.getBytes(),"ISO-8859-1");
			String sql = "select goodsid,goodsname,gprice,gtype,gimgurl,gamount "
			             +" from goodsmessage where goodsname like '%"+searchth+"%'";
			handlePage.setSql(sql);
			int totolPage = DB.totolPage(sql);
			handlePage.setTotolPage(totolPage);	
			Vector<String[]> vv = DB.selectPageMeg(1,sql);
			if(vv.size()==0)
			{
				String msg = "对不起，没有查询到相关<br/>的商品信息！！";
				pageForward(msg,request,response);
			}
			else
			{
				request.setAttribute("vv",vv);
    			String url = "/pagination.jsp";
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher(url);
				rd.forward(request,response);
			}				
		}
		else if(action.equals("search"))
		{
			String gtype = request.getParameter("gtype").trim();
			handlePage.setShowPage(1);			
			String sql = "select goodsid,goodsname,gprice,gtype,gimgurl,gamount"
			             +" from goodsmessage where gtype='"+gtype+"'";
			sql = new String(sql.getBytes(),"ISO-8859-1");
			handlePage.setSql(sql);
			int totolPage = DB.totolPage(sql);
			handlePage.setTotolPage(totolPage);
			Vector<String[]> vv = DB.selectPageMeg(1,sql);
			request.setAttribute("vv",vv);
			String url = "/pagination.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);			
		}
		else if(action.equals("next"))
		{	
			int p=handlePage.getShowPage();
			int q=handlePage.getTotolPage();
			if(p<q)
			{
				p++;
			}
			handlePage.setShowPage(p);
			String sql=handlePage.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url = "/pagination.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("before"))
		{	
			int p=handlePage.getShowPage();
			if(p>1)
			{
				p--;
			}			
			handlePage.setShowPage(p);
			String sql=handlePage.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url = "/pagination.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("pageChange"))
		{
			String  page =request.getParameter("changePage");
			int p = Integer.parseInt(page.trim());
			handlePage.setShowPage(p);
			String sql=handlePage.getSql();
			Vector<String[]> vv =DB.selectPageMeg(handlePage.getShowPage(),sql);	
			request.setAttribute("vv",vv);
			String url = "/pagination.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("buy"))
		{
	  	    //得到要购买东西的ID
	    	String goodsid = request.getParameter("goodsid").trim();
	    	String sqlw=(String)handlePage.getSql();
	    	if(sqlw.trim().equals(""))
	    	{
	    		String	sqlq = "select goodsid,goodsname,gprice,gtype,gimgurl,gamount from goodsmessage where goodsid="+Integer.parseInt(goodsid);
				//得到要购买东西的
    			handlePage.setSql(sqlq);
	    	}
    		handlePage.buy(goodsid);
    		//得到搜索当前内容的sql
    		String sql = handlePage.getSql();
    		int page = handlePage.getShowPage();
    		session.setAttribute("handlePage",handlePage);
			String url = "/pagination.jsp";
    		//返回后,得到页面内容
    		Vector<String[]> vv = DB.selectPageMeg(page,sql);
    		String msg=null;
    		if(vv.size()==0)
    		{//缺少用户需要的商品
    			msg = "抱歉，您需要的\\n商品,暂时缺货!";
    			request.setAttribute("msg",msg);
    		}
			request.setAttribute("vv",vv);
			//forward到要去的页面
    		ServletContext sc = getServletContext(); //得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);	
		}
     	else if(action.equals("delete"))
		{
			String goodsid = request.getParameter("goodsid");
			handlePage.removeItem(goodsid);
    		session.setAttribute("handlePage",handlePage);
    		response.sendRedirect("cart.jsp");
		}
		else if(action.equals("customermodify"))
		{				
    		String cpw = request.getParameter("cpw").trim();//得到用户修改后的信息
    		String cemail = request.getParameter("cemail").trim();
    		String cname = (String)session.getAttribute("user");    		
    		cname = new String(cname.getBytes(),"ISO-8859-1");//汉字转码
    		//更新数据库用户信息
    		String sql = "update gcustomer set cpw='"+cpw
    					+"',cemail='"+cemail+"' where cname='"+cname+"'";
    		int i = DB.updateMeg(sql);
    		if(i==0)
    		{//更改信息失败
    			String msg = "对不起,信息修改失败!!!";
    			pageForward(msg,request,response);	
    		}
    		else
    		{//信息修改成功
    			response.sendRedirect("customerxgxx.jsp");    			
    		}
		}
		else if(action.equals("change"))
		{
			//得到修改物品的名称和修改后的数量
    		String gnum = request.getParameter("gnum").trim();
    		String goodsid = request.getParameter("goodsid").trim();
    		int num = 0;
    		try
    		{
    			num = Integer.parseInt(gnum);
    		}
    		catch(Exception e)
    		{
    			//修改的数量不合法时
    			String msg = "对不起,数量修改错误!!!";
    			pageForward(msg,request,response);
    		}
    		//得到库存数量
    		String sql = "select gamount from goodsmessage where goodsid='"+goodsid+"'";
    		sql = new String(sql.getBytes(),"iso-8859-1");
			String c = DB.selectAmount(sql);
			int count = Integer.parseInt(c);
    		if(count<num)
    		{//当库存少于修改的值时
    			String msg = "对不起，"+goodsid+"号商品库存不够，库存\\n数量只有 "+count+"，不能修改为"+num+"!";
    			request.setAttribute("msg",msg);
    		}
    		else
    		{//当库存够时
	    		//得到用户的购物车
	    		Map<String,Integer> cart = handlePage.getCart();
	    		//修改商品数量
	    		cart.put(goodsid,num);
	    		session.setAttribute("handlePage",handlePage);	    		
	    	}
	    	this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request,response);
		}
		else if(action.equals("jiezhang"))
		{
			session.setAttribute("fromWhere","jz");			
			if(session.getAttribute("user")==null)
			{
				this.getServletConfig().getServletContext().getRequestDispatcher("/customermanage.jsp").forward(request,response);
				return;
			}    		
    		Map<String,Integer> cart = handlePage.getCart();//得到用户的购物车
    		Set<String> goodsid = cart.keySet();
    		String msg = "";
    		for(String str:goodsid)
    		{
    			//得到商品数量
    			int count = cart.get(str); 
    			//得到库存里商品的数量
	    		String sql = "select gamount from goodsmessage where goodsid="+Integer.parseInt(str);
				int ga = DB.getSelectId(sql);
    			if(ga<count)
    			{
    				msg = "对不起，"+goodsid+"号商品库存不够，库存\\n数量只有 "+ga+"，不能结账!";
    			}
    		}
    		if(msg.equals(""))
    		{//当meg为空时，代表库存够    		
    			int oid = DB.getID("ordergoodsmeg","oid");
	    		for(String str:goodsid)
	    		{	
	    			int count = cart.get(str); //得到商品数量
	    			//得到库存里商品的数量
	    			String sqlx="select gprice from goodsmessage where goodsid="+Integer.parseInt(str);
	    			sqlx=new String(sqlx.getBytes(),"iso-8859-1");
	    			double gprice=DB.selectPrice(sqlx);
		    		String sql = "select gamount from goodsmessage where goodsid="+Integer.parseInt(str);
					int ga = DB.getSelectId(sql);
					String sqly="select goodsname from goodsmessage where goodsid="+Integer.parseInt(str);
					sqly=new String(sqly.getBytes(),"iso-8859-1");
					String gb = DB.selectAmount(sqly);					
	    			String sqlz = "insert into ordergoodsmeg(oid,goodsid,goodsname,gprice,orderamount,buytime) values("
	    			+oid+","+str+",'"+gb+"',"+gprice+","+count+",now())";
	    			sqlz=new String(sqlz.getBytes(),"iso-8859-1");
	    			int flag =DB.updateMeg(sqlz);
	    			if(flag==0)
	    			{
	    				msg = "对不起,订单提交失败!!!";
						pageForward(msg,request,response);
	    			}
	    			else
		    		{
		    			int i = ga-count;
		    			String sql1 = "update goodsmessage set gamount ="+i
    					+" where goodsid="+Integer.parseInt(str);
    					int f =DB.updateMeg(sql1);
		    			session.setAttribute("handlePage",handlePage);
		    		
		    		}		
	    		}
				String sqldd="select max(oid)from ordergoodsmeg";
				int  orderid=DB.getSelectId(sqldd);
				request.setAttribute("orderid",orderid);
    			String url = "/receive.jsp";//forward到要去的页面
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
    		}
    		else
    		{//提示用户库存不够
    			request.setAttribute("msg",msg);
    			this.getServletContext().getRequestDispatcher("/cart.jsp").forward(request,response);
    		}
		}
		else if(action.equals("saveRec"))
		{
			//收到各参数
			String orederid=request.getParameter("orderid");
    		String recname = request.getParameter("recname");
    		String recadr = request.getParameter("recadr");
    		String rectel = request.getParameter("rectel");    		
    		String [] recMsg=new String[3];
    		recMsg[0] = recname.trim();
    		recMsg[1] = recadr.trim();
    		recMsg[2] = rectel.trim();
			//得到向订单基本信息表中插入数据的sql
			String sqldd="select max(oid)from ordergoodsmeg";
			int  i=DB.getSelectId(sqldd);
    		double oprice = handlePage.getAccount();
    		String cname = (String)session.getAttribute("user");
    		cname=new String(cname.getBytes(),"iso-8859-1");
    		String upsql = "insert into ordermeg(oid,cname,receivename,receiveadds,receivetel,"+
    		    "allmoney,buytime) values("+i+",'"+cname+"','"+recMsg[0]+"','"+recMsg[1]+"','"+recMsg[2]+"',"+oprice+",now())";
    		upsql=new String(upsql.getBytes(),"iso-8859-1");   	
    		int flag = DB.updateMeg(upsql);	
    		String msg = "";
    		if(flag==1)
    		{    		
				int mmname=Integer.parseInt(orederid); 
		      	String sql = "select oid,receivename,receiveadds,receivetel,allmoney,zhuangtai from ordermeg where oid='"+mmname+"'";
		        sql = new String(sql.getBytes(),"ISO-8859-1");
		      	String[] vl = DB.getString(sql);
		      	if(vl.length==0)
		      	{
		      		msg = "对不起,没有订单！";
					pageForward(msg,request,response);
		      	}
		      	else
		      	{
		      		request.setAttribute("list",vl);
		      		session.setAttribute("handlePage",handlePage);
					String url = "/customerdd.jsp";//forward到要去的页面
					ServletContext sc = getServletContext(); 
					RequestDispatcher rd = sc.getRequestDispatcher(url); 
					rd.forward(request,response); 
				
		      	}
    		}
    		else
    		{    			
    			msg = "对不起,订单提交失败";
				pageForward(msg,request,response);
    		}
    		//将收货人信息和javaBean对象设为空
    		session.setAttribute("handlePage",null);	    		
		}
		else if(action.equals("getMessage"))
    	{//用户请求得到某商品的详细信息时
	    	//得到商品ID
    		String goodsid = request.getParameter("goodsid").trim();
       		String sql = "select goodsid,goodsname,gtype,gprice,gdate,gamount,"
       		+"gimgurl,gintroduction from goodsmessage where goodsid="+goodsid;
    		String wsql=new String(sql.getBytes(),"iso-8859-1"); 
    		//得到该商品的详细信息
    		Vector<String[]> vv = DB.getMessage(wsql);	 		
			request.setAttribute("vv",vv);
			String url = "/goodsmessage.jsp";//forward到要去的页面
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
    	}
    	else if(action.equals("delete1"))
		{
			String mname = request.getParameter("oid").trim();
			int mmname=Integer.parseInt(mname);	
			String sw1="delete from ordergoodsmeg where oid="+mmname;			
    		int eee=DB.updateMeg(sw1);
    		String sw0= "delete from ordermeg where oid="+mmname;
    		int ee=DB.updateMeg(sw0);
    		if(ee==1&&eee>=1)
    		{
    			String msg = "删除成功!!!";
				pageForward(msg,request,response); 
    		}    		
    		else
    		{
				String msg = "该订单已经不存在!!!";
				pageForward(msg,request,response);
    		}
		}
		else if(action.equals("change1"))
		{
			String sno=request.getParameter("oid").trim();
			String sname=request.getParameter("goodsname").trim();
			int mmname=Integer.parseInt(sno); 
			String receiveshuliang=request.getParameter("receiveshuliang").trim();
			int receivesl=Integer.parseInt(receiveshuliang);
			String sql="update ordergoodsmeg set orderamount ="+receivesl+" where oid="+mmname
			+" and goodsname='"+sname+"'";
			sql=new String(sql.getBytes(),"iso-8859-1"); 
			int f =DB.updateMeg(sql); 
			String sqlz="select gprice,orderamount from ordergoodsmeg where oid="+sno;
			sqlz = new String(sqlz.getBytes(),"ISO-8859-1");
	      	Vector<String[]> vc = DB.getMessage(sqlz);
	      	double gprice=0.00;
	      	for(String[] str:vc)
	      	{	      		
	      		double jg=(double)Double.parseDouble(str[0]);
	      		int sl=Integer.parseInt(str[1]);
	      		gprice+=jg*sl;	
	      	}
	      	String sqlx="update ordermeg set allmoney ="+gprice+" where oid="+sno;
			sqlx=new String(sqlx.getBytes(),"iso-8859-1");
			int ff =DB.updateMeg(sqlx); 
	      	String sqlh = "select oid,receivename,receiveadds,receivetel,allmoney from ordermeg where oid='"+mmname+"'";
	        sql = new String(sqlh.getBytes(),"ISO-8859-1");
	      	String[] vl = DB.getString(sql);
      		request.setAttribute("list",vl);
      		session.setAttribute("handlePage",handlePage);
			String url = "/customerddxiugai.jsp";//forward到要去的页面
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response);			
		}
		else if(action.equals("tijiao"))
		{			
			String mname = request.getParameter("oid").trim();
			int mmname=Integer.parseInt(mname); 	
			String receivename = request.getParameter("receivename").trim();
			String receiveadds = request.getParameter("receiveadds").trim();
			String receivetel = request.getParameter("receivetel").trim();			
			String sql="update ordermeg  set receivename='"+receivename+"',receiveadds='"+receiveadds+
			"',receivetel='"+receivetel+"' where oid="+mmname;
			sql=new String(sql.getBytes(),"iso-8859-1");  
			int f =DB.updateMeg(sql);
			String sqlr = "select oid,receivename,receiveadds,receivetel,allmoney,zhuangtai from ordermeg where oid="+mmname;
	        sqlr = new String(sqlr.getBytes(),"ISO-8859-1");
	      	String[] vg = DB.getString(sqlr);
			if(f==0)
	      	{
	      		String msg = "对不起,没有订单！";
				pageForward(msg,request,response);
	      	}
	      	else
	      	{
	      		
	      		request.setAttribute("list",vg);
	      		session.setAttribute("handlePage",handlePage);
	      		String url = "/customerdd.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
		}
		else if(action.equals("modify"))
		{
	     	String mname = request.getParameter("oid").trim();
			int mmname=Integer.parseInt(mname); 
	      	String sql = "select oid,receivename,receiveadds,receivetel,allmoney from ordermeg where oid='"+mmname+"'";
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	      	String[] vl = DB.getString(sql);
	      	if(vl.length==0)
	      	{
	      		String msg = "对不起,没有订单！";
				pageForward(msg,request,response);
	      	}
	      	else
	      	{	      	
	      		request.setAttribute("list",vl);
	      		session.setAttribute("handlePage",handlePage);
				String url = "/customerddxiugai.jsp";//forward到要去的页面
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);			
	      	}
		}
		else if(action.equals("modify1"))
		{
	     	String mname = request.getParameter("oid").trim();
			int mmname=Integer.parseInt(mname); 
	      	String sql = "select oid,receivename,receiveadds,receivetel,allmoney,zhuangtai from ordermeg where oid='"+mmname+"'";
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	      	String[] vl = DB.getString(sql);
	      	if(vl.length==0)
	      	{
	      		String msg = "对不起,没有订单！";
				pageForward(msg,request,response);
	      	}
	      	else
	      	{	      	
	      		request.setAttribute("list",vl);
	      		session.setAttribute("handlePage",handlePage);
				String url = "/customerdd.jsp";//forward到要去的页面
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);			
	      	}
		}
		else if(action.equals("modify2"))
		{
		    session.setAttribute("fromWhere","wddd");
		    if(session.getAttribute("user")==null)
			{
				response.sendRedirect("customermanage.jsp");
			}
			else
			{
		     	String cname=(String)session.getAttribute("user");
		     	cname=new String(cname.getBytes(),"iso-8859-1");
		      	String sql = "select oid,receivename,receiveadds,receivetel,"+
		      	"allmoney,zhuangtai,buytime,cname from ordermeg where cname='"+cname+"'";
		        sql = new String(sql.getBytes(),"ISO-8859-1");
		      	Vector<String[]> vl = DB.getMessage(sql);
	      		if(vl.size()==0)
		      	{
		      		String msg="没有订单！";
		      		pageForward(msg,request,response);
		      	}
		      	else
		      	{
		      		request.setAttribute("use",cname);
		      		request.setAttribute("list",vl);
		      		session.setAttribute("handlePage",handlePage);
					String url = "/ddbiao.jsp";//forward到要去的页面
					ServletContext sc = getServletContext(); 
					RequestDispatcher rd = sc.getRequestDispatcher(url); 
					rd.forward(request,response); 
				}
	      	}
		}
		else if(action.equals("paixu"))
		{
	    	session.setAttribute("wdddpx","desc");
	    	if(session.getAttribute("user")==null)
	    	{
	    		response.sendRedirect("customermanage.jsp");
	    	}
	    	else{	    	
		     	String cname=(String)request.getParameter("user");
		     	cname=new String(cname.getBytes(),"iso-8859-1");
		      	String sql = "select oid,receivename,receiveadds,receivetel,"+
	      		"allmoney,zhuangtai,buytime from ordermeg where cname='"+cname+"' order by buytime desc";
		        sql = new String(sql.getBytes(),"ISO-8859-1");		        
		      	Vector<String[]> vl = DB.getMessage(sql);
	      		if(vl.size()==0)
		      	{
		      		String msg="没有订单！";
		      		pageForward(msg,request,response);
		      	}
		      	else
		      	{
		      		request.setAttribute("use",cname);
		      		request.setAttribute("list",vl);
		      		session.setAttribute("handlePage",handlePage);
					String url = "/ddbiao.jsp";//forward到要去的页面
					ServletContext sc = getServletContext(); 
					RequestDispatcher rd = sc.getRequestDispatcher(url); 
					rd.forward(request,response); 
				}
			}
		}
		else if(action.equals("paixus"))
		{	    	
	     	session.setAttribute("wdddpx","asc");
	    	if(session.getAttribute("user")==null)
	    	{
	    		response.sendRedirect("customermanage.jsp");
	    	}
	    	else
	    	{
		     	String cname=(String)request.getParameter("user");
		     	cname=new String(cname.getBytes(),"iso-8859-1");
		      	String sql = "select oid,receivename,receiveadds,receivetel,"+
	      		"allmoney,zhuangtai,buytime from ordermeg where cname='"+cname+"' order by buytime asc";
		        sql = new String(sql.getBytes(),"ISO-8859-1");		        
		      	Vector<String[]> vl = DB.getMessage(sql);
	      		if(vl.size()==0)
		      	{
		      		String msg="没有订单！";
		      		pageForward(msg,request,response);
		      	}
		      	else
		      	{
		      		request.setAttribute("use",cname);
		      		request.setAttribute("list",vl);
		      		session.setAttribute("handlePage",handlePage);
					String url = "/ddbiao.jsp";//forward到要去的页面
					ServletContext sc = getServletContext(); 
					RequestDispatcher rd = sc.getRequestDispatcher(url); 
					rd.forward(request,response); 
				}	    		
	    	}	     	
		}
	}
	public void pageForward(String msg,HttpServletRequest request,HttpServletResponse response)
    							throws ServletException,IOException
    {
		request.setAttribute("msg",msg);
		String url = "/error.jsp";
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(url); 
		rd.forward(request,response);   	
    }
}

