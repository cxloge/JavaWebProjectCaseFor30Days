package wyf.zrk;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.naming.*;
import javax.ejb.*;
import wyf.zrk.DButil;
import wyf.zrk.BookTicket;

public class ManageServlet extends HttpServlet
{
	public  void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	this.doPost(request,response);
    }
	public  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{	
    	request.setCharacterEncoding("gb2312");								//设置编码格式
    	response.setContentType("text/html;charset=gb2312");				//设置响应编码格式		
    	response.setCharacterEncoding("gb2312");							//设置字符集
    	HttpSession session = request.getSession(true);						//得到session对象    	
    	PrintWriter out = response.getWriter();								//拿到输出流对象    	
		DButil db = null;													//声明引用
		BookTicket bt = null;
		Context ctx = null;
	    try{
	        Hashtable<String,String> ht = new Hashtable<String,String>();	//创建一个map
	        ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
	        ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
	        ctx = new InitialContext(ht);									//初始化上下文
	        db = (DButil)ctx.lookup("java:comp/env/ejb/DButilLocal");		//得到远程接口引用
	    } 
	    catch (Exception e){e.printStackTrace();}							//打印异常
        if(session.getAttribute("bt") == null){			 					//当对象不存在时
			try{				
				bt=(BookTicket)ctx.lookup("java:comp/env/ejb/BookTicketLocal");//得到远程接口引用
	 			session.setAttribute("bt",bt);									//将对象放到session中
		 	}
		 	catch(Exception ce){ce.printStackTrace();}							//打印异常
		}
		else{																	//当session中存在时
		    bt = (BookTicket)session.getAttribute("bt");						//得到引用
		}
    	String action = request.getParameter("action");						//拿到请求的动作
		if(action==null){													//当动作为null时
			String msg = "无效路径，请核对后再输入！！！";					//提示信息
			request.setAttribute("msg",msg);								//将信息放入请求中
			forward(request,response,"/info.jsp");							//页面跳转
		}
		else{
			action = action.trim();											//去掉action前后的不可见字符			
			if(action.equals("initial")){									//当动作为初始化时
				String sql = "select mid,mtype,to_char(mtickettime,'yyyy-mm-dd hh:mi:ss'),mname,mlinkman,mtel from msginfo";
				List<String[]> ls = db.getInfo(sql);						//得到搜索结果
				session.setAttribute("initlist",ls);						//将结果放入会话中
				forward(request,response,"/index.jsp");						//页面跳转
			}
			else if(action.equals("login")){								//当动作为登录时
				String uname = request.getParameter("uname");				//得到用户名
				String upwd = request.getParameter("upwd");					//得到密码
				if(uname==null||upwd==null||uname.equals("")||upwd.equals("")){//当用户名或密码为null时
					String msg = "用户名和密码均不能为空，请重新输入！！！";//得到提示信息
					request.setAttribute("msg",msg);						//将提示信息放入请求中
					forward(request,response,"/info.jsp");					//页面跳转
				}
				else{
					String sql = "select 1 from userinfo where uname='"		//核对用户名和密码
							+uname.trim()+"' and upwd='"+upwd.trim()+"'";	//是否正确的SQL
					sql = new String(sql.getBytes(),"ISO-8859-1");			//将sql转码
					List<String[]> ls = db.getInfo(sql);					//得到查询结果
					if(ls.size()!=0){										//当没有查询到时
						session.setAttribute("user",uname.trim());
						if(session.getAttribute("flag")==null){
							session.setAttribute("flag","no");
						}
						String flag = (String)session.getAttribute("flag");
						if(flag.equals("no")){
							forward(request,response,"/index.jsp");				//页面跳转
						}
						else{
							String url = (String)session.getAttribute("url");
							forward(request,response,url);
						}						
					}
					else{
						String msg = "对不起，用户名或密码错误，请重新登录！！！";
						request.setAttribute("msg",msg);					//将提示信息放入请求中
						forward(request,response,"/info.jsp");				//页面跳转
					}
				}
			}
			else if(action.equals("logout")){								//当动作为注解时
				session.invalidate();										//使session失效
				forward(request,response,"/ManageServlet?action=initial");	//页面跳转
			}
			else if(action.equals("checkUname")){							//当动作为检查用户名是否可用时
				String uname = request.getParameter("uname");				//得到用户输入的名字
				if(uname==null){											//当名字为空时
					out.println("no");										//返回no
				}
				else{														//当名字不为空时
					System.out.println("the name is :"+uname);
					uname = new String(uname.trim().getBytes(),"ISO-8859-1");//将名字转码
					String sql = "select 1 from userinfo where uname='"+uname+"'";//搜索该名字是否存在的sql
					List<String[]> ls = db.getInfo(sql);					//得到查询结果
					if(ls.size()!=0){										//当没有查询到时
						out.println("no");									//用户名不可用
					}
					else{
						out.println("ok");									//用户名可用
					}
				}
			}
			else if(action.equals("register")){								//当动作为注册时
				
				System.out.println("come in");
				
				String uname = request.getParameter("uname");				//得到用户名
				String upwd_first = request.getParameter("upwd_first");		//得到第一次输入的密码
				String upwd_second = request.getParameter("upwd_second");	//得到第二次输入的密码
				String ugender = request.getParameter("UserSex");			//得到性别
				String identify = request.getParameter("identify");			//得到验证码
				if(uname==null||upwd_first==null||upwd_second==null||ugender==null||identify==null){//当有输入项为空时
					out.println("<script language=\"JavaScript\"> alert(\"信息输入不合法！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示用户
				}
				else if(!identify.toLowerCase().trim().equals(((String)session.getAttribute("randNum")).toLowerCase())){			//当输入验证码错误时
					out.println("<script language=\"JavaScript\"> alert(\"验证码错误！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示用户
				}
				else if(!upwd_first.trim().equals(upwd_second.trim())){						//当两次输入的密码不一致时
					out.println("<script language=\"JavaScript\"> alert(\"两次密码输入不一致！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示用户
				}
				else{																		//当输入的信息正确时
					uname = new String(uname.trim().getBytes(),"ISO-8859-1");				//将名字转码
					String temp = "select 1 from userinfo where uname='"+uname+"'";
					List<String[]> ls = db.getInfo(temp);									//得到查询列表
					if(ls.size()==0){
						ugender = new String(ugender.trim().getBytes(),"ISO-8859-1");			//将性别转码
						String sql = "insert into userinfo(uname,upwd,ugender) values('"+
										uname+"','"+upwd_first+"','"+ugender+"')";				//插入记录的SQL语句
						int i = db.updateDb(sql);												//执行插入操作
						if(i==1){																//插入成功时
							out.println("<script language=\"JavaScript\"> alert(\"恭喜你，注册成功！！！\");"
									+"window.location.href=\"index.jsp\"</script>");			//提示用户
						}
						else{																	//插入失败时
							out.println("<script language=\"JavaScript\"> alert(\"对不起，注册失败！！！\");"
									+"window.location.href=\"register.jsp\"</script>");			//提示用户
						}						
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"用户名已被占用！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示用户
					}

				}
			}
			else if(action.equals("lookUserInfo")){											//当动作为查看用户信息时
				if(session.getAttribute("user")==null){										//判断用户是否登录
					out.println("<script language=\"JavaScript\"> alert(\"请先登录！！！\");"
								+"window.location.href=\"index.jsp\"</script>");			//提示用户登录
				}
				else{																		//用户已经登录
					String uname = new String(((String)session.getAttribute("user")).trim().getBytes(),"ISO-8859-1");//将用户名转码
					String sql = "select ugender from userinfo where uname='"+uname+"'";	//搜索用户性别的SQL语句
					List<String[]> ls = db.getInfo(sql);									//得到查询列表
					String ugender = (ls.get(0))[0];										//得到用户性别
					request.setAttribute("ugender",ugender);								//将性别放入会话中
					forward(request,response,"/modifyUserInfo.jsp");						//页面跳转
				}
			}
			else if(action.equals("modifyUserInfo")){										//当动作为修改用户信息时								
				String upwd_old = request.getParameter("upwd_old");
				String upwd_first = request.getParameter("upwd_first");						//得到第一次输入的密码
				String upwd_second = request.getParameter("upwd_second");					//得到第二次输入的密码
				String ugender = request.getParameter("UserSex");							//得到用户性别
				String identify = request.getParameter("identify");							//得到验证码
				if(upwd_old==null||upwd_first==null||upwd_second==null||ugender==null||identify==null){//当输入为空时
					out.println("<script language=\"JavaScript\"> alert(\"信息输入不合法！！！\");"
								+"window.location.href=\"modifyuserinfo.jsp\"</script>");	//提示用户信息
				}
				else if(!identify.trim().toLowerCase().equals(((String)session.getAttribute("randNum")).toLowerCase())){
					out.println("<script language=\"JavaScript\"> alert(\"验证码错误！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示用户验证码错误
				}
				else if(!upwd_first.trim().equals(upwd_second.trim())){						//两次输入密码不一致时
					out.println("<script language=\"JavaScript\"> alert(\"两次密码输入不一致！！！\");"
								+"window.location.href=\"register.jsp\"</script>");			//提示密码输入不一致
				}
				else{
					String uname = new String(((String)session.getAttribute("user")).trim().getBytes(),"ISO-8859-1");
					String test = "select 1 from userinfo where uname='"+uname+"' and upwd='"+upwd_old.trim()+"'";
					List<String[]> ls = db.getInfo(test);
					if(ls.size()!=0){
						ugender = new String(ugender.trim().getBytes(),"ISO-8859-1");
						String sql = "update userinfo set upwd='"+upwd_first+"',ugender='"+ugender+"' where uname='"+uname+"'";
						int i = db.updateDb(sql);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜你，资料修改成功！！！\");"
									+"window.location.href=\"index.jsp\"</script>");
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，资料修改失败！！！\");"
									+"window.location.href=\"ManageServlet?action=lookUserInfo\"</script>");
						}						
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"旧口令输入错误！！！\");"
									+"window.location.href=\"ManageServlet?action=lookUserInfo\"</script>");
					}
				}
			}
			else if(action.equals("zzcx")){
				System.out.println("zzcx");
				String start = request.getParameter("start");
				String end = request.getParameter("end");
				if(start==null||end==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入错误，请重新输入！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					List<String[]> ls = db.zzcx(start.trim(),end.trim());
					session.setAttribute("start",start.trim());
					session.setAttribute("end",end.trim());
					if(ls.size()==0){
						List<String> mid = db.searchMidStation(start,end);
						if(mid.size()==0){
							String msg = "没有查询到你要的车次！！！";
							request.setAttribute("msg",msg);
							forward(request,response,"/info.jsp");							
						}
						else{
							session.setAttribute("mid",mid);
							forward(request,response,"/midstation.jsp");
						}
					}
					else{
						session.setAttribute("list_train",ls);
						forward(request,response,"/trainsearch.jsp");
					}
				}
			}
			else if(action.equals("czcx")){
				System.out.println("czcx");
				String station = request.getParameter("station");
				if(station==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入错误，请重新输入！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					List<String[]> ls = db.czcx(station.trim());
					if(ls.size()==0){
						String msg = "没有查询到你要的车次！！！";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");
					}
					else{
						request.setAttribute("station",station);
						session.setAttribute("list_train",ls);
						forward(request,response,"/trainsearch.jsp");
					}
				}
			}
			else if(action.equals("cccx")){
				System.out.println("cccx");
				String train = request.getParameter("train");
				String flag = request.getParameter("flag");
				if(train==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入错误，请重新输入！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					List<String[]> ls = db.cccx(train.trim().toUpperCase());
					if(ls.size()==0){
						String msg = "没有查询到你要的车次！！！";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");
					}
					else{
						System.out.println("train name is : "+train);
						request.setAttribute("list",ls);
						request.setAttribute("tname",train);
						if(flag==null){
							forward(request,response,"/traindetail.jsp");
						}
						else if(flag.trim().equals("1")){
							forward(request,response,"/traindetail_a.jsp");
						}
						else{
							forward(request,response,"/traindetail_b.jsp");
						}
						
					}
				}
			}
			else if(action.equals("midSearch")){
				String midstation = request.getParameter("mid");
				if(midstation==null){
						String msg = "系统错误！！！";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");	
				}
				else{
					String start = (String)session.getAttribute("start");
					String end = (String)session.getAttribute("end");
					List<String[]> first = db.zzcx(start,midstation.trim());
					List<String[]> sec = db.zzcx(midstation.trim(),end);
					
					System.out.println(first);
					System.out.println(sec);
					
					for(String[] str:sec){
						first.add(str);
					}
					session.setAttribute("mid_train",first);
					forward(request,response,"/trainsearch_a.jsp");
				}
			}
			else if(action.equals("publish")){
				String amount = request.getParameter("mamount");
				String mname = request.getParameter("mname");
				String mtype = request.getParameter("msg_type");
				String mtickettime = request.getParameter("mtickettime");
				String mstart = request.getParameter("mstart");
				String mend = request.getParameter("mend");
				String mticketprice = request.getParameter("mticketprice");
				String mlinkman = request.getParameter("mlinkman");
				String mtel = request.getParameter("mtel");
				String mmsg = request.getParameter("mmsg");
				String mlevel = request.getParameter("mlevel");
				String identify = request.getParameter("identify");
				if(mtype==null||mtickettime==null||mstart==null||mend==null||mlevel==null||mname==null||
						mticketprice==null||mlinkman==null||mtel==null||mmsg==null||identify==null||amount==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入不合法！！！\");"
								+"window.location.href=\"publishmsg.jsp\"</script>");		
				}
				else if(!identify.trim().toLowerCase().equals(((String)session.getAttribute("randNum")).toLowerCase())){
					out.println("<script language=\"JavaScript\"> alert(\"验证码错误！！！\");"
								+"window.location.href=\"publishmsg.jsp\"</script>");
				}
				else{
					int type = Integer.parseInt(mtype.trim());
					int mamount = Integer.parseInt(amount.trim());
					String uname = new String(((String)session.getAttribute("user")).trim().getBytes(),"ISO-8859-1");
					mtickettime = mtickettime.trim();
					mlinkman = new String(mlinkman.trim().getBytes(),"ISO-8859-1");
					mtel = mtel.trim();
					mticketprice = mticketprice.trim();
					mlevel = new String(mlevel.trim().getBytes(),"ISO-8859-1");
					if(mticketprice.equals("")){
						mticketprice = new String("不限".getBytes(),"ISO-8859-1");
					}
					mstart =  new String(mstart.trim().getBytes(),"ISO-8859-1");
					mend =  new String(mend.trim().getBytes(),"ISO-8859-1");
					mmsg =  new String(mmsg.trim().getBytes(),"ISO-8859-1");
					mname =  new String(mname.trim().getBytes(),"ISO-8859-1");
					String sql = "insert into msginfo(mamount,mtype,mname,uid,mpublishtime,mlinkman,mtel,mticketprice,"+
								"mtickettime,mstart,mend,mmsg,mlevel) values("+mamount+","+type+",'"+mname+"',(select uid from userinfo "+
								"where uname='"+uname+"'),sysdate,'"+mlinkman+"','"+mtel+"','"+mticketprice+"',to_date('"+mtickettime
								+"','yyyy-mm-dd'),'"+mstart+"','"+mend+"','"+mmsg+"','"+mlevel+"')";
					int i = db.updateDb(sql);
					if(i==1){
						out.println("<script language=\"JavaScript\"> alert(\"恭喜你，信息发布成功！！！\");"
								+"window.location.href=\"ManageServlet?action=initial\"</script>");
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"对不起，信息发布失败！！！\");"
								+"window.location.href=\"publishmsg.jsp\"</script>");
					}
				}
			}
			else if(action.equals("getTicketMsg")){
				String type = request.getParameter("type");
				if(type==null||!type.trim().matches("\\d")){
						out.println("<script language=\"JavaScript\"> alert(\"非法URL！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					int mtype = Integer.parseInt(type.trim());
					String pagesql = "select count(*) from msginfo";
					String sql = "";
					if(mtype==3){
						sql = "select mtype,to_char(mtickettime,'yyyy-mm-dd'),mname,mticketprice,mlevel,mamount,mid from msginfo";
					}
					else{
						sql = "select mtype,to_char(mtickettime,'yyyy-mm-dd'),mname,mticketprice,mlevel,mamount,mid"+
										" from msginfo where mtype="+mtype;
						pagesql = "select count(*) from msginfo where mtype="+mtype;
					}
					int totalpage = db.getTotalPage(pagesql);
					int nowpage = 1;
					System.out.println("the totalpage is :"+totalpage);
					session.setAttribute("totalpage",totalpage);
					session.setAttribute("nowpage",nowpage);
					session.setAttribute("sql",sql);
					List<String[]> ls = db.getPageContent(sql,1);
					session.setAttribute("list",ls);
					forward(request,response,"/messageinfo.jsp");
				}
			}
			else if(action.equals("lookdetail")){
				String id = request.getParameter("mid");
				String flag = request.getParameter("flag");
				if(id==null||!id.trim().matches("\\d+")){
					out.println("<script language=\"JavaScript\"> alert(\"非法URL！！！\");"
							+"window.location.href=\"messageinfo.jsp\"</script>");
				}
				else{
					int mid = Integer.parseInt(id.trim());
					String sql = "select mname,mtype,mlevel,to_char(mtickettime,'yyyy-mm-dd'),mticketprice,"+
									"mstart,mend,to_char(mpublishtime,'yyyy-mm-dd hh:mi:ss'),mlinkman,mtel,mmsg from msginfo"+
									" where mid="+mid;
					List list = db.getInfo(sql);
					if(list.size()!=0){
						request.setAttribute("list",list.get(0));
						request.setAttribute("flag",flag);
						forward(request,response,"/lookdetail.jsp");
					}
					else{
						String msg = "非法的URL！！！";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");
					}
				}
			}
			else if(action.equals("changePage")){
				String page = request.getParameter("page");
				String pagename = request.getParameter("pagename");
				if(page==null||pagename==null){
					String msg = "系统错误！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					int nowpage = Integer.parseInt(page.trim());
					pagename = pagename.trim();
					String sql = (String)session.getAttribute("sql");
					List<String[]> list = db.getPageContent(sql,nowpage);
					session.setAttribute("list",list);
					session.setAttribute("nowpage",nowpage);
					forward(request,response,pagename);
				}
			}
			else if(action.equals("msgManage")){
				String user = (String)session.getAttribute("user");
				user = new String(user.getBytes(),"ISO-8859-1");
				String pagesql = "select count(*) from msginfo where uid = "+
									"(select uid from userinfo where uname='"+user+"')";
				String sql = "select mtype,to_char(mtickettime,'yyyy-mm-dd'),mname,mid from msginfo "+
							"where uid = (select uid from userinfo where uname='"+user+"')";
				int totalpage = db.getTotalPage(pagesql);
				int nowpage = 1;
				System.out.println("the totalpage is :"+totalpage);
				session.setAttribute("totalpage",totalpage);
				session.setAttribute("nowpage",nowpage);
				session.setAttribute("sql",sql);
				List<String[]> ls = db.getPageContent(sql,1);
				session.setAttribute("list",ls);
				forward(request,response,"/messagemanage.jsp");
			}
			else if(action.equals("delMsg")){
				String mid = request.getParameter("mid");
				if(mid==null){
					String msg = "系统错误！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");	
				}
				else{
					int id = Integer.parseInt(mid.trim());
					String val = "select 1 from msginfo where mid="+id;
					List<String[]> ls = db.getInfo(val);
					if(ls.size()!=0){
						String sql = "delete from msginfo where mid="+id;
						int i = db.updateDb(sql);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜你，删除成功！！！\");"
									+"window.location.href=\"ManageServlet?action=msgManage\"</script>");
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，删除失败！！！\");"
									+"window.location.href=\"messagemanage.jsp\"</script>");
						}
					}
					forward(request,response,"/ManageServlet?action=msgManage");					
				}
			}
			else if(action.equals("zzSearch")){
				String tstart = request.getParameter("tstart");
				String tend = request.getParameter("tend");
				if(tstart==null||tend==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入有误！！！\");"
							+"window.location.href=\"bookticket_a.jsp\"</script>");
				}
				else{
					List<String[]> ls = db.zzcx(tstart.trim(),tend.trim());
					session.setAttribute("start",tstart.trim());
					session.setAttribute("end",tend.trim());
					if(ls.size()==0){
						String msg = "没有搜索到您要的车次";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");
					}
					else{
						request.setAttribute("list",ls);
						forward(request,response,"/bookticket_b.jsp");
					}
				}
			}
			else if(action.equals("book")){
				String tname = request.getParameter("tname");
				if(tname==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					List<String[]> ls = db.cccx(tname.trim());
					if(ls.size()==0){
						String msg = "没有搜索到您要的车次";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");
					}
					else{
						TicketItem ti = new TicketItem();
						ti.setTname(tname.trim());
						bt.addToCart(ti);
						session.setAttribute("stationlist",ls);
						forward(request,response,"/bookticket_c.jsp");						
					}
				}			
			}
			else if(action.equals("saveStation")){
				String tstart = request.getParameter("tstart");
				String tend = request.getParameter("tend");
				System.out.println("the start and end is:"+tstart+"\t"+tend);
				if(tstart==null||tend==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					Vector<TicketItem> v = bt.getCart();
					TicketItem ti = v.get(0);
					String tname = ti.getTname();
					String sql = "select 1 from (select rsequence from relationinfo "+
									"where tid=(select tid from traininfo where tname='"+
									tname+"') and sid=(select sid from stationinfo where "+
									"sname='"+tstart+"')) A,"+
									"(select rsequence from relationinfo "+
									"where tid=(select tid from traininfo where tname='"+
									tname+"') and sid=(select sid from stationinfo where "+
									"sname='"+tend+"')) B "+
									"where A.rsequence<B.rsequence";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()==0){
						out.println("<script language=\"JavaScript\"> alert(\"站点选择错误，出发站只能在目的站前面！\");"
								+"window.location.href=\"bookticket_c.jsp\"</script>");
					}
					else{
						ti.setTstart(tstart.trim());
						ti.setTend(tend.trim());
						forward(request,response,"/bookticket_d.jsp");						
					}
				}
			}
			else if(action.equals("saveMsg")){
				String linkman = request.getParameter("linkman");
				String tamount = request.getParameter("tamount");
				String tdate = request.getParameter("tdate");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				if(linkman==null||tamount==null||tdate==null||address==null||tel==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					String[] tt = tdate.trim().split("-");					
					Date day = new Date(Integer.parseInt(tt[0])-1900,Integer.parseInt(tt[1])-1,Integer.parseInt(tt[2])+1);
					if(day.before(new Date())){
						String msg = "您预订的车票已过期，请核查！";
						request.setAttribute("msg",msg);
						forward(request,response,"/info.jsp");	
					}
					else{
						TicketItem ti = bt.getCart().get(0);
						ti.setLinkman(linkman.trim());
						ti.setTamount(Integer.parseInt(tamount.trim()));
						ti.setTdate(tdate.trim());
						ti.setAddress(address.trim());
						ti.setTel(tel.trim());
						session.setAttribute("ti",ti);
						forward(request,response,"/bookticket_e.jsp");
					}				
				}
			}
			else if(action.equals("look")){
				TicketItem ti = bt.getCart().get(0);
				request.setAttribute("ti",ti);
				forward(request,response,"/bookticket_f.jsp");
			}
			else if(action.equals("delete")){
				bt.clearCart();
				forward(request,response,"/index.jsp");
			}
			else if(action.equals("subOrder")){
				TicketItem ti = bt.getCart().get(0);
				String user = (String)session.getAttribute("user");
				if(user==null){
					session.setAttribute("flag","yes");
					session.setAttribute("url","/bookticket_e.jsp");
					out.println("<script language=\"JavaScript\"> alert(\"请先登录！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					String sql = "insert into orderinfo(uid,ostart,oend,tid,linkman,"+
									"address,tel,amount,tdate) values((select uid from "+
									"userinfo where uname='"+user+"'),'"+ti.getTstart()+"','"+
									ti.getTend()+"',(select tid from traininfo where tname='"+
									ti.getTname()+"'),'"+ti.getLinkman()+"','"+ti.getAddress()+"','"+
									ti.getTel()+"',"+ti.getTamount()+",to_date('"+ti.getTdate()+"','yyyy-mm-dd'))";
					System.out.println(sql);
					sql = new String(sql.getBytes(),"ISO-8859-1");
					int i = db.updateDb(sql);
					if(i==1){
						bt.clearCart();
						out.println("<script language=\"JavaScript\"> alert(\"恭喜您,预订成功！！！\");"
								+"window.location.href=\"index.jsp\"</script>");	
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"预订失败！！！\");"
								+"window.location.href=\"bookticket_e.jsp\"</script>");
					}
				}
			}
			else if(action.equals("modify")){
				String tamount = request.getParameter("tamount");
				String tdate = request.getParameter("tdate");
				String linkman = request.getParameter("linkman");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				if(tamount==null||tdate==null||linkman==null||address==null||tel==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					String[] tt = tdate.trim().split("-");					
					Date day = new Date(Integer.parseInt(tt[0])-1900,Integer.parseInt(tt[1])-1,Integer.parseInt(tt[2])+1);
					if(day.before(new Date())){
						out.println("<script language=\"JavaScript\"> alert(\"您预订的车票已过期！！！\");"
								+"window.location.href=\"ManageServlet?action=look\"</script>");
					}
					else{
						TicketItem ti = bt.getCart().get(0);
						ti.setAddress(address.trim());
						ti.setTamount(Integer.parseInt(tamount.trim()));
						ti.setLinkman(linkman.trim());
						ti.setTel(tel);
						ti.setTdate(tdate);
						session.setAttribute("ti",ti);
						forward(request,response,"/bookticket_e.jsp");						
					}
				}
			}
			else if(action.equals("lookBookInfo")){
				String user = (String)session.getAttribute("user");
				if(user==null){
					out.println("<script language=\"JavaScript\"> alert(\"请先登录！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
				}
				else{
					String sql = "select O.oid,T.tname,to_char(O.tdate,'yyyy-mm-dd'),"+
									"O.ostate from orderinfo O,traininfo T "+
									"where O.tid=T.tid and uid=(select uid"+
									" from userinfo where uname='"+user.trim()+"') order by O.tdate desc";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					String pagesql = "select count(*) from orderinfo where uid="+
										"(select uid from userinfo where uname='"
										+user.trim()+"')";
					pagesql = new String(pagesql.getBytes(),"ISO-8859-1");
					int totalpage = db.getTotalPage(pagesql);
					int nowpage = 1;
					System.out.println("the totalpage is :"+totalpage);
					session.setAttribute("totalpage",totalpage);
					session.setAttribute("nowpage",nowpage);
					session.setAttribute("sql",sql);
					List<String[]> ls = db.getPageContent(sql,1);
					if(ls.size()==0){
						out.println("<script language=\"JavaScript\"> alert(\"您没有任何预订信息！！！\");"
								+"window.location.href=\"index.jsp\"</script>");
					}
					else{
						session.setAttribute("list",ls);
						forward(request,response,"/myorder.jsp");
					}
				}
			}
			else if(action.equals("delOrder")){
				String oid = request.getParameter("oid");
				if(oid==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");	
				}
				else{
					int id = Integer.parseInt(oid.trim());
					String val = "select 1 from orderinfo where oid="+id;
					List<String[]> ls = db.getInfo(val);
					if(ls.size()!=0){
						String sql = "delete from orderinfo where oid="+id;
						int i = db.updateDb(sql);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜你，删除成功！！！\");"
									+"window.location.href=\"ManageServlet?action=lookBookInfo\"</script>");
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，删除失败！！！\");"
									+"window.location.href=\"myorder.jsp\"</script>");
						}
					}
					forward(request,response,"/ManageServlet?action=lookBookInfo");					
				}
			}
			else if(action.equals("getOrderDetail")){
				String oid = request.getParameter("oid");
				String url = request.getParameter("url");
				if(oid==null||url==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					int id = Integer.parseInt(oid.trim());
					String sql = "select O.oid,T.tname,O.ostart,O.oend,O.linkman,"+
									"O.address,O.tel,O.amount,to_char(O.tdate,'yyyy-mm-dd'),"+
									"O.ostate from orderinfo O,traininfo T "+
									"where O.tid=T.tid and O.oid="+id;
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()==0){
						out.println("<script language=\"JavaScript\"> alert(\"系统错误！！！\");"
								+"window.location.href=\"myorder.jsp\"</script>");
					}
					else{
						request.setAttribute("list",ls);
						forward(request,response,url);
					}				
				}
			}
			else if(action.equals("modifyOrder")){
				String oid = request.getParameter("oid");
				String tamount = request.getParameter("tamount");
				String tdate = request.getParameter("tdate");
				String linkman = request.getParameter("linkman");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				if(oid==null||oid.equals("")||tamount==null||tamount.equals("")||tdate==null||linkman==null||address==null||tel==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");	
				}
				else{
					int id = Integer.parseInt(oid.trim());
					int amount = Integer.parseInt(tamount.trim());
					String sql = "update orderinfo set amount="+amount+",tdate=to_date('"+
									tdate.trim()+"','yyyy-mm-dd'),linkman='"+linkman+"',tel='"+
									tel.trim()+"',address='"+address.trim()+"' "+
									"where oid="+id;
					sql = new String(sql.getBytes(),"ISO-8859-1");
					int i = db.updateDb(sql);
					if(i==1){
						out.println("<script language=\"JavaScript\"> alert(\"恭喜您，订单修改成功！！！\");"
									+"window.location.href=\"myorder.jsp\"</script>");
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"对不起，修改失败！！！\");"
									+"window.location.href=\"myorder.jsp\"</script>");	
					}					
				}
			}
			else if(action.equals("adminLogin")){
				String aname = request.getParameter("aname");
				String apwd = request.getParameter("apwd");
				String identify = request.getParameter("identify");
				if(aname==null||apwd==null||identify==null){
					out.println("<script language=\"JavaScript\"> alert(\"信息输入不合法！！！\");"
								+"window.location.href=\"adminlogin.jsp\"</script>");			//提示用户
				}
				else if(!identify.toLowerCase().trim().equals(((String)session.getAttribute("randNum")).toLowerCase())){			//当输入验证码错误时
					out.println("<script language=\"JavaScript\"> alert(\"验证码错误！！！\");"
								+"window.location.href=\"adminlogin.jsp\"</script>");			//提示用户
				}
				else{
					String sql = "select alevel from admininfo where aname='"+aname.trim()
									+"' and apwd='"+apwd.trim()+"'";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()==0){
						String msg = "对不起，用户名或密码错误，请重新登录！！！";
						request.setAttribute("msg",msg);									//将提示信息放入请求中
						forward(request,response,"/info.jsp");								//页面跳转	
					}
					else{
						session.setAttribute("admin",aname.trim());
						session.setAttribute("level",ls.get(0)[0]);
						forward(request,response,"/ManageServlet?action=lookOrder&flag=3");						
					}
				}
			}
			else if(action.equals("lookOrder")){
				String flag = request.getParameter("flag");
				if(flag==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");		
				}
				else{
					String sql = "select O.oid,to_char(O.tdate,'yyyy-mm-dd'),O.ostart,O.oend,T.tname,O.ostate "+
								"from orderinfo O,traininfo T where O.tid=T.tid";
					String pagesql = "select count(*) from orderinfo";
					if(flag.equals("1")){			//1-代表查看未处理订单
						sql = sql+" and O.ostate='未处理' order by O.tdate desc";
						pagesql = pagesql+" where ostate='未处理'";
					}
					else if(flag.equals("2")){		//2-代表查看已处理订单
						sql = sql+" and O.ostate!='未处理' order by O.tdate desc";
						pagesql = pagesql+" where ostate!='未处理'";
					}
					else{
						sql = sql+" order by O.tdate desc";
					}
					sql = new String(sql.getBytes(),"ISO-8859-1");
					pagesql = new String(pagesql.getBytes(),"ISO-8859-1");
					int totalpage = db.getTotalPage(pagesql);
					int nowpage = 1;
					System.out.println("the totalpage is :"+totalpage);
					session.setAttribute("totalpage",totalpage);
					session.setAttribute("nowpage",nowpage);
					session.setAttribute("sql",sql);
					List<String[]> ls = db.getPageContent(sql,1);
					session.setAttribute("list",ls);
					forward(request,response,"/ordermanage.jsp");
				}				
			}
			else if(action.equals("adminLogout")){
				session.invalidate();										//使session失效
				forward(request,response,"/adminlogin.jsp");				//页面跳转
			}
			else if(action.equals("sendOrder")){
				String oid = request.getParameter("oid");
				String flag = request.getParameter("flag");
				if(oid==null||flag==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					int id = Integer.parseInt(oid.trim());
					String str = (flag.trim().equals("1"))?"已订到票":"未订到票";
					String sql = "update orderinfo set ostate='"+str+"' where oid="+id;
					sql = new String(sql.getBytes(),"ISO-8859-1");
					int i = db.updateDb(sql);
					if(i==1){
						out.println("<script language=\"JavaScript\"> alert(\"恭喜您，订单发送成功！！！\");"
								+"window.location.href=\"ManageServlet?action=lookOrder&flag=3\"</script>");
					}
					else{
						out.println("<script language=\"JavaScript\"> alert(\"订单发送失败！！！\");"
								+"window.location.href=\"ordermanage.jsp\"</script>");
					}
				}
			}
			else if(action.equals("addAdmin")){
				String aname = request.getParameter("aname");
				String first = request.getParameter("first");
				String second = request.getParameter("second");
				if(aname==null||first==null||second==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else if(!first.trim().equals(second.trim())){
					out.println("<script language=\"JavaScript\"> alert(\"两次输入密码不一致！！！\");"
								+"window.location.href=\"resetpwd.jsp\"</script>");	
				}
				else{
					String sql = "select 1 from admininfo where aname='"+aname+"'";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()!=0){
						out.println("<script language=\"JavaScript\"> alert(\"该用户已存在！！！\");"
								+"window.location.href=\"addadmin.jsp\"</script>");			
					}
					else{
						String temp = "insert into admininfo(aname,apwd) values('"
										+aname.trim()+"','"+first.trim()+"')";
						temp = new String(temp.getBytes(),"ISO-8859-1");
						int i = db.updateDb(temp);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜您，添加成功！！！\");"
									+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");	
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，添加失败！！！\");"
									+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");
						}
					}
				}				
			}
			else if(action.equals("lookAdmin")){
				String sql = "select aid,aname,alevel from admininfo";
				String pagesql = "select count(*) from admininfo";
				int totalpage = db.getTotalPage(pagesql);
				int nowpage = 1;
				System.out.println("the totalpage is :"+totalpage);
				session.setAttribute("totalpage",totalpage);
				session.setAttribute("nowpage",nowpage);
				session.setAttribute("sql",sql);
				List<String[]> ls = db.getPageContent(sql,1);
				session.setAttribute("list",ls);
				forward(request,response,"/adminmanage.jsp");				
			}
			else if(action.equals("delAdmin")){
				String aid = request.getParameter("aid");
				if(aid==null||aid.equals("")){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else{
					int id = Integer.parseInt(aid.trim());
					String test = "select alevel from admininfo where aid="+id;
					List<String[]> ls = db.getInfo(test);
					
					for(String[] str:ls){
						for(String ss:str){
							System.out.println(ss);
						}
					}
					
					if(ls.size()!=0){
						String level = ls.get(0)[0];
						if(level.equals("超级")){
							String msg = "超级管理员不可以被删除！！！";
							request.setAttribute("msg",msg);
							forward(request,response,"/info.jsp");	
						}
						else{
							String sql = "delete from admininfo where aid="+id;
							int i = db.updateDb(sql);
							if(i==1){
								out.println("<script language=\"JavaScript\"> alert(\"恭喜您，删除成功！！！\");"
										+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");	
							}
							else{
								out.println("<script language=\"JavaScript\"> alert(\"对不起，删除失败！！！\");"
										+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");
							}							
						}						
					}
					else{
						out.println("<script language=\"JavaScript\">"
										+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");
					}
				}
			}
			else if(action.equals("resetPwd")){
				String aname = request.getParameter("aname");
				String first = request.getParameter("first");
				String second = request.getParameter("second");
				if(aname==null||first==null||second==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else if(!first.trim().equals(second.trim())){
					out.println("<script language=\"JavaScript\"> alert(\"两次输入密码不一致！！！\");"
								+"window.location.href=\"resetpwd.jsp\"</script>");	
				}
				else{
					String sql = "select 1 from admininfo where aname='"+aname+"'";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()==0){
						out.println("<script language=\"JavaScript\"> alert(\"该用户不存在！！！\");"
								+"window.location.href=\"resetpwd.jsp\"</script>");			
					}
					else{
						String temp = "update admininfo set apwd='"+first.trim()+
										"' where aname='"+aname.trim()+"'";
						temp = new String(temp.getBytes(),"ISO-8859-1");
						int i = db.updateDb(temp);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜您，重置成功！！！\");"
									+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");	
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，重置失败！！！\");"
									+"window.location.href=\"ManageServlet?action=lookAdmin\"</script>");
						}
					}
				}				
			}
			else if(action.equals("modAdminPwd")){
				String oldpwd = request.getParameter("oldpwd");
				String first = request.getParameter("first");
				String second = request.getParameter("second");
				if(session.getAttribute("admin")==null){
					out.println("<script language=\"JavaScript\"> alert(\"请登录！！！\");"
							+"window.location.href=\"adminlogin.jsp\"</script>");
				}
				else if(oldpwd==null||first==null||second==null){
					String msg = "非法的URL！！！";
					request.setAttribute("msg",msg);
					forward(request,response,"/info.jsp");
				}
				else if(!first.trim().equals(second.trim())){
					out.println("<script language=\"JavaScript\"> alert(\"两次输入密码不一致！！！\");"
								+"window.location.href=\"modifypwd.jsp\"</script>");	
				}
				else{
					String aname = (String)session.getAttribute("admin");
					String sql = "select 1 from admininfo where aname='"+aname.trim()
									+"' and apwd='"+oldpwd.trim()+"'";
					sql = new String(sql.getBytes(),"ISO-8859-1");
					List<String[]> ls = db.getInfo(sql);
					if(ls.size()==0){
						out.println("<script language=\"JavaScript\"> alert(\"旧密码输入错误！！！\");"
								+"window.location.href=\"modifypwd.jsp\"</script>");	
					}
					else{
						String temp = "update admininfo set apwd='"+first.trim()+
										"' where aname='"+aname.trim()+"'";
						temp = new String(temp.getBytes(),"ISO-8859-1");
						int i = db.updateDb(temp);
						if(i==1){
							out.println("<script language=\"JavaScript\"> alert(\"恭喜您，密码修改成功！！！\");"
									+"window.location.href=\"ManageServlet?action=lookOrder&flag=3\"</script>");	
						}
						else{
							out.println("<script language=\"JavaScript\"> alert(\"对不起，密码修改失败！！！\");"
									+"window.location.href=\"modifypwd.jsp\"</script>");
						}
					}					
				}				
			}			
		}
	}
	protected void forward(HttpServletRequest request,HttpServletResponse response,String url)
    throws ServletException,IOException 
    {	
    	ServletContext sc = getServletContext();							//得到上下文
		RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
		dispatcher.forward(request,response);								//页面跳转
    }
}