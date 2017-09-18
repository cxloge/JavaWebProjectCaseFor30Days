package wyf.hxl;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ManageServlet extends HttpServlet
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
		ManageBean spSearch = (ManageBean)session.getAttribute("spSearch");
		if(spSearch==null){
			spSearch = new ManageBean();
		}		
		String action=request.getParameter("action").trim();	
		if(action.equals("add"))
		{     
			String gn = request.getParameter("goodsname");
			String gt = request.getParameter("gtype");
			String gprice = request.getParameter("gprice");
			String gdate = request.getParameter("gdate");
			String gamount = request.getParameter("gamount");
			String gimgurl = request.getParameter("Gimgurl");
			String gi = request.getParameter("gintroduction");
			int shumu = Integer.parseInt(gamount);			

			String sql3 = "insert into goodsmessage(goodsname,gtype,gprice,gdate,"
			+"gamount,gimgurl,gintroduction) values('"+gn+"','"+gt+"','"
			+gprice+"',now(),"+shumu+",'"+gimgurl+"','"+gi+"')";
			sql3= new String(sql3.getBytes(),"iso-8859-1");
			int flag = DB.updateMeg(sql3);
			String msg=null;
			if(flag==0)
			{
				msg = "添加商品失败，请重新添加！！！";
			}
			else
			{
				msg = "添加商品成功！！！";			
			}
			request.setAttribute("msg",msg);
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/goodsmanage.jsp");
			rd.forward(request,response);
		}
		else if(action.equals("mandenglu"))
		{
			String mmname = request.getParameter("mmname");
			String mmpassword = request.getParameter("mmpassword");
			String cname = new String(mmname.getBytes(),"ISO-8859-1");
			String sql = "select mname from mmanager where mname='"+cname+"' and mpw='"+mmpassword+"'";
			boolean s = DB.selectMsg(sql);
			if(s)
			{
				session.setAttribute("manager",cname);
				String sql1 = "select mpermitted from mmanager where mname='"+cname+"' and mpw='"+mmpassword+"'";
				String sql11 = new String(sql1.getBytes(),"ISO-8859-1");
				String str = DB.selectAmount(sql11).trim();	
				System.out.println("str"+str+"|"+session.getId());		
				if(str.equals("超级"))
				{
					session.setAttribute("chaoji","超级");
				}
				else if(str.equals("普通"))
				{
					session.setAttribute("name",cname);
					session.setAttribute("putong","普通");
				}
				ServletContext sc = getServletContext();			//得到上下文 
				RequestDispatcher rd = sc.getRequestDispatcher("/spgltree.jsp");
				rd.forward(request,response);
			}
			else
			{
				String msg = "对不起,登录失败,请重新登录!!!";
				request.setAttribute("msg",msg);
				ServletContext sc = getServletContext();			//得到上下文 
				RequestDispatcher rd = sc.getRequestDispatcher("/admindl.jsp");
				rd.forward(request,response);
			}
		}
		else if(action.equals("tianjia"))
		{
			String mname = request.getParameter("mname");
			String mpassword = request.getParameter("mpassword");
			String mpw = request.getParameter("mpw");
			String quanxian = request.getParameter("quanxian");
			String cname = new String(mname.getBytes(),"ISO-8859-1");
			String cpw = new String(mpassword.getBytes(),"ISO-8859-1");
			String cquanxian = new String(quanxian.getBytes(),"ISO-8859-1");
			String sql = "select mname from mmanager where mname='"+cname+"'";
			boolean s = DB.selectMsg(sql);
			String msg=null;
			if(s)
			{
				msg ="该管理员已经存在，请重新添加！";				
			}
			else
			{
				String sql0 = "insert into mmanager(mname,mpw,mpermitted )"+" values('"+cname+"','"+cpw+"','"+cquanxian+"')";
				int flag=DB.updateMeg(sql0);
				if(flag==0)
				{
					msg = "添加失败，请重新添加！";
				}
				else
				{
					msg="恭喜您，管理员添加成功！";					
				}	
			}
			request.setAttribute("msg",msg);
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/manzc.jsp");
			rd.forward(request,response);						
		}
		else if(action.equals("mandelete"))
		{
			String mname = request.getParameter("mname").trim();
    		String sql = "delete from mmanager where mname='"+mname+"'";
    		sql = new String(sql.getBytes(),"ISO-8859-1");
    		int i = DB.updateMeg(sql);
    		String msg=null;
    		if(i==1)
    		{
    			msg = "恭喜您,管理员删除成功!!!";
    		}
    		else
    		{
    			msg = "对不起,管理员删除失败!!!";
    		}
			request.setAttribute("msg",msg);
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/mandelete.jsp");
			rd.forward(request,response);						    		
		}
		else if(action.equals("resetpwd"))
    	{//重置密码时
    		String aname = request.getParameter("aname").trim();
    		String apwd = request.getParameter("apwd").trim();
    		String temp = "select * from mmanager where mname='"+aname+"'";
    		temp = new String(temp.getBytes(),"ISO-8859-1");
    		boolean flag = DB.selectMsg(temp);
    		String msg =null;
    		if(!flag)
    		{
    			msg = "对不起,用户名输入错误!!!";
    		}
    		else
    		{
    			String sql = "update mmanager set mpw='"+apwd+"' where mname='"+aname+"'";
    			sql = new String(sql.getBytes(),"ISO-8859-1");
    			int i = DB.updateMeg(sql);
    			if(i==1)
    			{
    				msg = "恭喜您,密码重置成功!!!";
    			}
    			else
    			{
    				msg = "对不起,密码重置失败!!!";
    			}
    		}
			request.setAttribute("msg",msg);
			ServletContext sc = getServletContext();			//得到上下文 
			RequestDispatcher rd = sc.getRequestDispatcher("/manchangepw.jsp");
			rd.forward(request,response);    		
    	}
    	else if(action.equals("logout"))
		{
			//当管理员注销登录时
    		//使session失效
    		request.getSession(true).invalidate();
    		this.getServletContext().getRequestDispatcher("/admindl.jsp").forward(request,response);
			return;	
    	}
    	else if(action.equals("goodsdelete"))
		{
			String goodsid = request.getParameter("goodsid").trim();
			int gid=Integer.parseInt(goodsid);
			String sqlorder="select count(*) from ordergoodsmeg where goodsid="+gid;
			boolean flag = DB.selectMsg(sqlorder);
			String msg=null;
			if(flag)
			{
				msg=goodsid+"号商品已经售出，为了统计\\n账目方便，故不予删除！";
			}
			else
			{				
	    		String sql = "delete from goodsmessage where goodsid="+goodsid;
	    		int i = DB.updateMeg(sql);
	    		if(i==1)
	    		{
	    			msg=goodsid+"号商品删除成功！";
	    		}
	    		else
	    		{
	                msg=goodsid+"号商品删除失败！";
	    		}				
			}
    		request.setAttribute("msg",msg);
		    String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);
		}
		else if(action.equals("goodsxiugai"))
		{
			//得到修改物品的信息
    		String goodsname = request.getParameter("goodsname").trim();
    		String gtype = request.getParameter("splx").trim();
    		String gprice = request.getParameter("spjg").trim();
    		String gdate = request.getParameter("sjqq").trim();
    		String gamount = request.getParameter("spsl").trim();
    		String gimgurl = request.getParameter("url").trim();
    		String gintroduction = request.getParameter("gintroduction").trim();
    		String goodsid=request.getParameter("goodsid").trim();			
			int gnum = Integer.parseInt(gamount);
			double gjg = Double.parseDouble(gprice);
			String sql = "update goodsmessage  set goodsname='"+goodsname+"',gtype='"+gtype+
			"',gprice="+gjg+",gdate='"+gdate+"',gamount="+gnum+",gimgurl='"+gimgurl+
			"',gintroduction='"+gintroduction+"' where goodsid="+goodsid;
			sql = new String(sql.getBytes(),"iso-8859-1");
			int i = DB.updateMeg(sql);
			String msg =null;
			if(i==1)
			{
				msg=goodsid+"号商品信息修改成功！";
			}
			else
			{
				msg = "对不起,修改失败!!!";
			}
			request.setAttribute("msg",msg);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);	
	    }
	    else if(action.equals("orderxiugai"))
		{			
			//得到修改订单的信息
    		String oid  = request.getParameter("oid").trim();
			int gnum = Integer.parseInt(oid);
			String sql = "update ordermeg  set zhuangtai='已发送' where oid="+gnum;
			sql = new String(sql.getBytes(),"iso-8859-1");
			int i = DB.updateMeg(sql);
			String msg=null;
			if(i==1)
			{
				msg = "恭喜您,"+oid+"号订单发送成功!!!";
			}
			else
			{
				msg = "对不起,"+oid+"号订单发送失败!!!";
			}
			request.setAttribute("msg",msg);
			String ddfs=(String)session.getAttribute("ddfs");
			if(ddfs==null)
			{
				ddfs="ordergl";
			}
			this.getServletContext().getRequestDispatcher("/ManageServlet?action="+ddfs).forward(request,response);	
	    }
	    else if(action.equals("searchorder"))
	    {
	     	String ddfs=(String)session.getAttribute("ddfs");
			if(ddfs==null)
			{
				ddfs="ordergl";
			}	
		    String ddtitle="";
		    String ddmsg="";
			if(ddfs.equals("ordergl"))
			{
			   ddtitle="";
			   ddmsg="";
			}
		    else if(ddfs.equals("orderyfs"))
			{
			   ddtitle=" and zhuangtai='已发送'";
			   ddmsg="已发送";
			}
		    else if(ddfs.equals("orderwfs"))
			{
			   ddtitle=" and zhuangtai='未发送'";
			   ddmsg="未发送";
			}	    	
	    	String oid = request.getParameter("searchorder").trim();
	    	String msg=null;
	   		if(oid.equals(""))
	    	{
	    		msg = "请输入要查询的订单的订单号！！";				
	    	}
	    	else
	    	{
	    		int ss = Integer.parseInt(oid);
		    	String sql = "select oid,cname,receivename,receiveadds,receivetel,allmoney,"+
		    	"zhuangtai from ordermeg where oid="+ss+ddtitle;
		      	String sql11 = new String(sql.getBytes(),"ISO-8859-1");
		      	Vector<String[]> vv = DB.getMessage(sql11);
		      	request.setAttribute("vv",vv);	
		      	if(vv.size()==0)
		      	{
		      		msg="对不起，没有"+oid+"号"+ddmsg+"订单的信息！";
		      	}			
	    	}
	    	request.setAttribute("msg",msg);
	    	ServletContext sc = getServletContext(); 
		    RequestDispatcher rd = sc.getRequestDispatcher("/orderdetail.jsp"); 
			rd.forward(request,response);	    	 
	    }
	    else if(action.equals("searchgoods"))
	    {	
			String searchgoods = request.getParameter("searchgoods").trim();
			spSearch.setShowPage(1);
			String searchth = new String(searchgoods.getBytes(),"ISO-8859-1");
			String sql = "select goodsname,gtype,gprice,gdate,gamount,gimgurl,gintroduction,"
			             +"goodsid from goodsmessage where goodsname like '%"+searchth+"%'";
			spSearch.setSql(sql);
			int totolPage = DB.totolPage(sql);
			spSearch.setTotolPage(totolPage);	
			Vector<String[]> vv = DB.selectPageMeg(1,sql);
			if(vv.size()==0)
			{
				String msg = "没有查询到相关信息！！";
				request.setAttribute("msg",msg);
			}
			request.setAttribute("vv",vv);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request,response);				
		}
	    else if(action.equals("next"))
		{	
			int p=spSearch.getShowPage();
			int q=spSearch.getTotolPage();
			if(p<q)
			{
				p++;
			}
			spSearch.setShowPage(p);
			String sql11="select goodsname,gtype,gprice,gdate,gamount,gimgurl,gintroduction,goodsid from goodsmessage";
			String sql111=new String(sql11.getBytes(),"iso-8859-1");
			spSearch.setSql(sql111);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url="";
			if(vv==null)
			{
				String sqli="select goodsid,goodsname,gprice,gtype,gimgurl,gamount,gintroduction from goodsmessage";
				spSearch.setShowPage(1);
				int nowpage = spSearch.getShowPage();
		        int totolpage = DB.totolPage("select * from goodsmessage");
		        spSearch.setTotolPage(totolpage);
		        spSearch.setSql(sqli);
				vv = DB.selectPageMeg(nowpage,sqli);
				url = "/goodsmd.jsp";				
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
			}
			else
			{
				url = "/goodsmd.jsp";	
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
			}			
		}	
		else if(action.equals("before"))
		{	
			int p=spSearch.getShowPage();
			if(p>1){
				p--;
			}
			spSearch.setShowPage(p);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("pageChange"))
		{
			String  page =request.getParameter("changePage");
			int p = Integer.parseInt(page.trim());
			spSearch.setShowPage(p);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(spSearch.getShowPage(),sql);	
			request.setAttribute("vv",vv);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("next1"))
		{	
			int p=spSearch.getShowPage();
			int q=spSearch.getTotolPage();
			if(p<q)
			{
				p++;
			}
			spSearch.setShowPage(p);
			String sql11="select goodsname,gtype,gprice,gdate,gamount,gimgurl,gintroduction,goodsid from goodsmessage";
			String sql111=new String(sql11.getBytes(),"iso-8859-1");
			spSearch.setSql(sql111);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url="";
			if(vv==null)
			{
				String sqli="select goodsid,goodsname,gprice,gtype,gimgurl,gamount,gintroduction from goodsmessage";
				spSearch.setShowPage(1);
				int nowpage = spSearch.getShowPage();
		        int totolpage = DB.totolPage("select * from goodsmessage");
		        spSearch.setTotolPage(totolpage);
		        spSearch.setSql(sqli);
				vv = DB.selectPageMeg(nowpage,sqli);
				url = "/goodsmd.jsp";				
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
			}
			else
			{
				url = "/goodsmd.jsp";	
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response);
			}
			
		}	
		else if(action.equals("before1"))
		{	
			int p=spSearch.getShowPage();
			if(p>1){
				p--;
			}
			spSearch.setShowPage(p);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(p,sql);	
			request.setAttribute("vv",vv);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("pageChange1"))
		{
			String  page =request.getParameter("changePage1");
			int p = Integer.parseInt(page.trim());
			spSearch.setShowPage(p);
			String sql=spSearch.getSql();
			Vector<String[]> vv =DB.selectPageMeg(spSearch.getShowPage(),sql);	
			request.setAttribute("vv",vv);
			String url = "/goodsmd.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("ordergl"))
		{
		    String chaoji=(String)session.getAttribute("chaoji");
		    String putongF=(String)session.getAttribute("putong");
		    if(chaoji==null&&putongF==null)
		    {
		      request.setAttribute("msg", "对不起，只有管理员才可以\\n使用此项功能，请登陆！");
	          this.getServletContext().getRequestDispatcher("/dl.jsp").forward(request,response);
	          return;
		    }			
			String pxfs=request.getParameter("pxfs");
			if(pxfs==null)
			{
				pxfs="asc";
			}			
			session.setAttribute("pxfs",pxfs);
			session.setAttribute("ddfs","ordergl");			
			spSearch.setShowPage(1);
			String sql = "select oid,cname,receivename,receiveadds,receivetel,allmoney,"+
	      	"zhuangtai,buytime from ordermeg order by buytime "+pxfs;
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	        spSearch.setSql(sql);
			int totolPage = DB.totolPage(sql);
			spSearch.setTotolPage(totolPage);	
			Vector<String[]> vv = DB.selectPageMeg(1,sql);
	      	request.setAttribute("vv",vv);
	      	session.setAttribute("spSearch",spSearch);
	      	if(vv.size()==0)
	      	{
	      		String msg = "对不起,没有订单！";
				request.setAttribute("msg",msg);
				String url = "/welcome.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	      	else
	      	{
	      		
	      		String url = "/ordercx.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	    }
	    else if(action.equals("xia"))
		{	
			int p=spSearch.getShowPage();
			int q=spSearch.getTotolPage();			
			if(p<q)
			{
				p++;
			}
			spSearch.setShowPage(p);
			String sqle=spSearch.getSql();
			Vector<String[]> vv3 =DB.selectPageMeg(p,sqle);	
			request.setAttribute("vv",vv3);
			String url = "/ordercx.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("qian"))
		{	
			int p=spSearch.getShowPage();
			if(p>1){
				p--;
			}			
			spSearch.setShowPage(p);
			String sqlw=spSearch.getSql();
			Vector<String[]> vv2 =DB.selectPageMeg(p,sqlw);	
			request.setAttribute("vv",vv2);
			String url = "/ordercx.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("huan"))
		{
			String  page =request.getParameter("huan");
			int p = Integer.parseInt(page.trim());
			spSearch.setShowPage(p);
			String sqlq=spSearch.getSql();
			Vector<String[]> vv1=DB.selectPageMeg(spSearch.getShowPage(),sqlq);	
			request.setAttribute("vv",vv1);
			String url = "/ordercx.jsp";
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher(url); 
			rd.forward(request,response); 
		}
		else if(action.equals("orderyfs"))
		{
		    String chaoji=(String)session.getAttribute("chaoji");
		    String putongF=(String)session.getAttribute("putong");
		    if(chaoji==null&&putongF==null)
		    {
		      request.setAttribute("msg", "对不起，只有管理员才可以\\n使用此项功能，请登陆！");
	          this.getServletContext().getRequestDispatcher("/dl.jsp").forward(request,response);
	          return;
		    }		    
			String pxfs=request.getParameter("pxfs");
			if(pxfs==null)
			{
				pxfs="asc";
			}			
			session.setAttribute("pxfs",pxfs);		  
			session.setAttribute("ddfs","orderyfs");		    
			spSearch.setShowPage(1);
			String sql = "select oid,cname,receivename,receiveadds,receivetel,allmoney,"+
	      	"zhuangtai,buytime from ordermeg where zhuangtai='已发送' order by buytime "+pxfs;
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	        spSearch.setSql(sql);
			int totolPage = DB.totolPage(sql);
			spSearch.setTotolPage(totolPage);	
			Vector<String[]> vvyfs = DB.selectPageMeg(1,sql);	      	
	      	if(vvyfs.size()==0)
	      	{
	      		String msg = "对不起,没有订单！";
				request.setAttribute("msg",msg);
				String url = "/welcome.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	      	else
	      	{
	      		request.setAttribute("vv",vvyfs);
	      		session.setAttribute("spSearch",spSearch);
	      		String url = "/ordercx.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	   	}
	   	else if(action.equals("orderwfs"))
		{
		    String chaoji=(String)session.getAttribute("chaoji");
		    String putongF=(String)session.getAttribute("putong");
		    if(chaoji==null&&putongF==null)
		    {
		      request.setAttribute("msg", "对不起，只有管理员才可以\\n使用此项功能，请登陆！");
	          this.getServletContext().getRequestDispatcher("/dl.jsp").forward(request,response);
	          return;
		    }    
			String pxfs=request.getParameter("pxfs");
			if(pxfs==null)
			{
				pxfs="asc";
			}			
			session.setAttribute("pxfs",pxfs);		  
			session.setAttribute("ddfs","orderwfs");   
			spSearch.setShowPage(1);
			String sql = "select oid,cname,receivename,receiveadds,receivetel,allmoney,"+
	      	"zhuangtai,buytime from ordermeg where zhuangtai='未发送' order by buytime "+pxfs;
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	        spSearch.setSql(sql);
			int totolPage = DB.totolPage(sql);
			spSearch.setTotolPage(totolPage);	
			Vector<String[]> vvwfs = DB.selectPageMeg(1,sql);	      	
	      	if(vvwfs.size()==0)
	      	{
	      		String msg = "对不起,没有未发送的订单，\\n系统将跳转回欢迎页！";
				request.setAttribute("msg",msg);
				String url = "/welcome.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	      	else
	      	{
	      		request.setAttribute("vv",vvwfs);
	      		session.setAttribute("spSearch",spSearch);
	      		String url = "/ordercx.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	    }
	    else if(action.equals("chakan"))
		{		
	     	String mname = request.getParameter("oid").trim();
			int mmname=Integer.parseInt(mname); 
	      	String sql="select oid,cname,receivename,receiveadds,receivetel,"
	      	+"allmoney,zhuangtai,buytime from ordermeg where oid="+mmname;
	        sql = new String(sql.getBytes(),"ISO-8859-1");
	      	Vector<String[]> vl = DB.getMessage(sql);
	      	if(vl.size()==0)
	      	{
		      	String msg = "对不起,没有订单！";
				request.setAttribute("msg",msg);
				String url = "/welcome.jsp";
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 
	      	}
	      	else
	      	{
	      	
	      		request.setAttribute("vv",vl);
	      		session.setAttribute("spSearch",spSearch);
				String url = "/orderdetail.jsp";//forward到要去的页面
				ServletContext sc = getServletContext(); 
				RequestDispatcher rd = sc.getRequestDispatcher(url); 
				rd.forward(request,response); 				
	      	}
		}		
	}
	public void pageForward(String msg,HttpServletRequest request,HttpServletResponse response)
    							throws ServletException,IOException
    {
		request.setAttribute("msg",msg);
		String url = "/houtaierror.jsp";
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(url); 
		rd.forward(request,response);   	
    }	
}		