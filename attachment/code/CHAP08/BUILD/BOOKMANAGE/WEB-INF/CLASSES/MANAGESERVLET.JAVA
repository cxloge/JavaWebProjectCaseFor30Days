package wyf.wyy;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;
public class ManageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{		
		this.doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("gbk");						//设置req编码为GBK
		res.setCharacterEncoding("gbk");						//设置res编码为GBK
		String action = req.getParameter("action");				//得到请求action动作
		System.out.println(" action ManageServlet"+action);
		final int day = 60;										//借阅天数
		final int order = 1;									//为预约同学保持图书天数
		String sql = "";										//声明SQL语句引用
		String message = "";									//声明消息字符串
		Vector<Vector<String>> v = new Vector<Vector<String>>();//声明信息向量引用
		Vector<String> student;									//声明存放学生信息的向量
		Vector<String> ve = new Vector<String>();				//创建向量存放SQL语句
		HttpSession session = req.getSession();					//得到session
		WebApplicationContext wac = 
			WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		StuDB sdb = (StuDB)wac.getBean("StuDB");						//得到StuDB对象
        DBUtil dbu = (DBUtil)wac.getBean("DBUtil");						//得到DBUtil对象
        StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean          
		if(action.equals("login")){								//管理员登陆
			String mID = req.getParameter("uname").trim();		//得到要登陆的管理员名
			String mPwd = req.getParameter("pwd").trim();		//得到要登陆的管理员密码
			sql = "select * from manage where ManageID='"+
				  mID+"' and managePwd='"+mPwd+"'";
			if(dbu.isExist(sql)){									//如果此条记录存在
				sql = "select ManageLevel from manage where"+
					  " ManageID='"+mID+"'";						//得到管理员级别的SQL
				String adLevel = dbu.getStringInfo(sql);
				System.out.println("登陆管理员级别 "+adLevel);
				session.setAttribute("adLevel",adLevel);			//放进session
				session.setAttribute("adName",mID);				//将管理员名放进session
			}
			else{
				message = "非法的用户名和密码，请核对后登陆";	//登陆失败提示消息
				req.setAttribute("message",message);			//设置提示消息
			}
			req.getRequestDispatcher("admin_login.jsp").forward(req,res);
		}
		else if(action.equals("logout")){									//注销
			req.getSession(true).invalidate();								//使session失效
			req.getRequestDispatcher("admin_login.jsp").forward(req,res); 	//转发至登陆页面
		}
		else if(action.equals("adManage")){									//查看管理员信息
			String mID = (String)session.getAttribute("adName");			//得到登陆的管理员ID		
			if(mID!=null){						//将管理员级别放进session
				res.sendRedirect("admin_manage.jsp");							//转向账号维护页面				
			}
			else{																//管理员没有登陆
				message = "对不起，您还没有登陆，请先登陆。";					//给出提示消息
				req.setAttribute("message",message);							//设置提示消息	
				req.getRequestDispatcher("admin_login.jsp").forward(req,res);	//转发消息到登陆页面				
			}
		}
		else if(action.equals("adChangePwd")){							//管理员修改密码
			String oldPwd = req.getParameter("oldPwd").trim();			//得到学生输入的旧密码
    		String newPwd = req.getParameter("newPwd").trim();			//得到要修改后的密码 
    		String mID = (String)session.getAttribute("adName");		//得到登陆的管理员ID   		
    		sql = "select * from manage where ManageID='"+
				  mID+"' and managePwd='"+oldPwd+"'";					//确认密码是否正确的SQL
			if(dbu.isExist(sql)){
				sql = "update manage set ManagePwd='"+newPwd+
					  "' where ManageID='"+mID+"'";						//更新密码的SQL语句
				if(dbu.update(sql)){
					message = "密码修改成功，下次请用新密码登陆。";	   //修改密码成功的提示
				}
				else{
					message = "未知错误，密码修改失败。";				//修改失败
				}
			}	
    		else{															 //密码修改失败
    			message = "旧密码输入错误，请核对后重新修改。";				//修改失败的提示信息
    		}    	
 			req.setAttribute("message", message);							 //设置消息
    		req.getRequestDispatcher("admin_manage.jsp").forward(req,res); 	 //没有登陆则转发至登陆页面   	
		}
		else if(action.equals("befor_aa")){										//添加管理员操作
			String adLevel = (String)session.getAttribute("adLevel");			//得到管理员级别
			if(adLevel.equals("1")){
				res.sendRedirect("add_admin.jsp");								//有权限则发送到管理页面
			}
			else{				
				message = "您不是超级管理员，没有对管理员进行管理的功能。"; 		 //给出提示信息
				req.setAttribute("message",message);
				req.getRequestDispatcher("admin_info_one.jsp").forward(req,res);	//转发
			}																		//调用方法执行判断权限
		}
		else if(action.equals("addAdmin")){
			String adID = req.getParameter("adID").trim();
			String adPwd = req.getParameter("adPwd").trim();
			System.out.println(adID+" "+adPwd+" ");
			sql = "select * from manage where ManageID='"+adID+"'";		//查看该管理员名是否已经存在的SQL
			if(dbu.isExist(sql)){
				message = "管理员名已存在，请核对后重新添加！！！";
			}
			else{
				sql = "insert into manage(ManageID,ManagePwd) values('"+
					   adID+"','"+adPwd+"')";									//插入新管理员的SQL
				if(dbu.update(sql)){
					message = "成功添加管理员。";							//成功插入提示消息
				}
				else{
					message = "未知错误添加失败。";						   //添加失败提示消息
				}
			}			
			req.setAttribute("message",message);							//设置消息
			req.getRequestDispatcher("add_admin.jsp").forward(req,res);		//转发
		}
		else if(action.equals("befor_rp")){									//进入重置密码页面之前
			String adLevel = (String)session.getAttribute("adLevel");		//得到管理员级别
			if(adLevel.equals("1")){
				res.sendRedirect("admin_resetPwd.jsp");						//有权限则发送到管理页面
			}
			else{				
				message = "您不是超级管理员，没有对管理员进行管理的功能。"; 		 //给出提示信息
				req.setAttribute("message",message);
				req.getRequestDispatcher("admin_info_one.jsp").forward(req,res);	//转发
			}								
		}
		else if(action.equals("reset_admin_pwd")){									//重置管理员密码
			String adID = req.getParameter("adID").trim();							//得到要重置的管理员名
			String adPwd = req.getParameter("adPwd").trim();						//得到重置密码
			sql = "select * from manage where ManageID='"+adID+"'";					//查看该管理员是否存在的SQL
			if(dbu.isExist(sql)){
				sql = "update manage set ManagePwd='"+adPwd+"' "+
					  "where ManageID='"+adID+"'";									//更新密码的SQL语句
				if(dbu.update(sql)){
					message = "密码重置成功！！！";								   //重置成功消息
				}
				else{
					message = "未知错误，重置失败。";								  //失败消息
				}				
			}
			else{
				message = "该管理员不存在，请核对后重新输入。";						//管理员不存在的消息							
			}
			req.setAttribute("message",message);
			req.getRequestDispatcher("admin_resetPwd.jsp").forward(req,res);
		}
		else if(action.equals("befor_la")){
			System.out.println("管理员列表之前"+status);
			String adLevel = (String)session.getAttribute("adLevel");
			if(adLevel.equals("1")){
				sql = "select ManageID,ManageLevel from manage";					//搜索管理员列表的SQL
				status.setSql(sql);													//保存SQL语句
				int span = status.getSpan();										//得到每页显示记录条数
				v = dbu.getPageContent(sql,1,span);
				sql = "select count(*) from manage";								//得到记录总条数的SQL
				int total = dbu.getTotal(sql,span);										//执行查询得到总页数
				status.setTotal(total);												//保存总共有多少页
				status.setCurPage(1);												//设置当前显示第一页
				req.setAttribute("v",v);
				req.getRequestDispatcher("list_admin.jsp").forward(req,res);		//转发到列表页面				
			}
			else{
				message = "您不是超级管理员，没有对管理员进行管理的功能。"; 		 //没有权限的提示消息
				req.setAttribute("message",message);
				req.getRequestDispatcher("admin_info_one.jsp").forward(req,res);		//转发到列表页面	
			}
		}
		else if(action.equals("delAdmin")){
			String mID = req.getParameter("mID").trim();							//得到要删除的管理员名
			sql = "delete from manage where ManageID='"+mID+"'";					//删除的SQL语句
			if(dbu.update(sql)){
				message = "删除管理员"+mID+"成功<a href='StudentServlet?"+		 	//删除成功的提示消息
						  "action=changePage&url=list_admin.jsp&"+
    					  "curPage=1'/><br>点击这里返回";
			}
			else{
				message = "未知错误，删除失败<a href='StudentServlet?"+				//删除成功的提示消息
						  "action=changePage&url=list_admin.jsp&"+
    					  "curPage=1'/><br>点击这里返回";							   //删除失败提示消息
			}
			req.setAttribute("message",message);
			req.getRequestDispatcher("admin_info_one.jsp").forward(req,res);		 //发送到消息显示页面
		}
//=====================管理员管理部分结束============================================================
		else if(action.equals("stu_manage")){										 //进入学生管理之前
			String mID = (String)session.getAttribute("adName");					 //得到登陆的管理员名
			if(mID!=null){
				res.sendRedirect("stu_manage.jsp");									 //转发到学生管理页面				
			}
			else{
				message = "对不起，您还没有登陆，请先登陆。";								 //没有登陆的提示消息
				req.setAttribute("message",message);								 //设置消息
				req.getRequestDispatcher("admin_login.jsp").forward(req,res);		 //发送到登陆页面
			}
		}
		else if(action.equals("add_stu")){											//添加学生
			String stuNO = req.getParameter("stuNO").trim();						//得到添加学生的学号
			String stuName = req.getParameter("stuName").trim();					//得到学生姓名
			String age = req.getParameter("age").trim();							//得到学生年龄
			String gender = req.getParameter("gender");							    //得到学生性别
			String stuClass = req.getParameter("stuClass").trim();					//得到学生的班级
			String dep = req.getParameter("dep").trim();							//得到学生系别
			sql = "select * from student where StudentNO='"+stuNO+"'";				//查看该学号是否已经存在
			if(dbu.isExist(sql)){
				message = "该学号学生已经存在。请核对后添加！";					   //给出提示消息
			}
			else{
				sql = "insert into student values('"+stuNO+"','"+stuNO+
				  	  "','"+stuName+"','"+age+"','"+gender+"','"+stuClass+
				  	  "','"+dep+"',"+1+")";											//插入新学生的SQL语句
				if(dbu.update(sql)){
					message = "添加新生成功。";									 //插入成功消息
				}
				else{
					message = "位置错误添加失败。";									//其他错误信息
				}
			}			
			req.setAttribute("message",message);
			req.getRequestDispatcher("stu_manage.jsp").forward(req,res);			
		}
		else if(action.equals("list_stu")){											 //列出所有学生信息
			sql = "select * from student";											 //查找所有学生的SQL
			int span = status.getSpan();										     //得到每页显示多少条记录
			v = dbu.getPageContent(sql,1,span);										 //得到当前页显示内容
			status.setSql(sql);														 //保存SQL
			sql = "select count(*) from student";									 //统计学生记录条数			
			int total = dbu.getTotal(sql,span);										 //计算得到总页数			
			status.setTotal(total);													 //保存总页数
			status.setCurPage(1);													 //设置当前为第一页		
			req.setAttribute("v",v);												 //设置信息向量
			req.getRequestDispatcher("list_stu.jsp").forward(req,res);				 //转发			
		}
		else if(action.equals("delStu")){							//删除学生
			String stuNO = req.getParameter("stuNO");				//得到要删除的学生学号
			sql = "delete from student where StudentNO='"+stuNO+"'";//删除学生的SQL语句
			if(dbu.update(sql)){
				message = "删除成功<a href='ManageServlet?action"+
						  "=list_stu'>返回";						  //删除成功提示
			}
			else{
				message = "未知错误，删除失败。<a href='ManageServlet"+
						  "?action=list_stu'>返回";						  	  //删除失败提示消息
			}
			req.setAttribute("message",message);								//设置提示消息
			req.getRequestDispatcher("admin_info_two.jsp").forward(req,res);	//转发
		}
		else if(action.equals("editStu")){										//修改学生信息
			String stuNO = req.getParameter("stuNO");							//得到该生学号			
			student = sdb.getStuInfo(stuNO);									//得到该生信息
			req.setAttribute("student",student);								//设置信息向量
			req.getRequestDispatcher("edit_stu.jsp").forward(req,res);			//转发
		}
		else if(action.equals("save_stu")){											//修改好信息进行保存时
			String stuNO = req.getParameter("stuNO").trim();						//得到修改前的学生学号
			String newNO = req.getParameter("newNO").trim();						//得到修改后的学号
			String stuName = req.getParameter("stuName").trim();					//得到修改后的学生姓名
			String age = req.getParameter("age").trim();							//得到修改后的学生年龄
			String gender = req.getParameter("gender");							    //得到修改后的学生性别
			String stuClass = req.getParameter("stuClass").trim();					//得到修改后的学生的班级
			String dep = req.getParameter("dep").trim();							//得到修改后的学生系别
			String per = req.getParameter("per");									//得到修改后的借书权限
			sql = "select * from student where StudentNO='"+newNO+"'";				//查看新修改的学号是否已经存在的SQL语句
			if(!newNO.equals(stuNO)&&dbu.isExist(sql)){
				message = "修改后的学号已经存在。";			   					 //新学号已经存在的提示信息
			}			
			else{
				sql = "update student set StudentNO='"+newNO+"',"+
					  "Name='"+stuName+"',Age="+age+",Gender"+
					  "='"+gender+"',Class='"+stuClass+"',Department"+
					  "='"+dep+"',Permitted="+per+" where StudentNO='"+
					  stuNO+"'";												   //更新该生信息的SQL语句
				System.out.println(sql);
				if(dbu.update(sql)){											   //判断更新结果
					message = "修改保存成功。";									//修改成功提示
				}
				else{
					message = "未知错误，修改失败";								  //修改失败提示
				}
			}
			student = sdb.getStuInfo(newNO);										//得到该生信息
			req.setAttribute("student",student);									//设置该生信息向量
			req.setAttribute("message",message);								   //设置提示消息
			req.getRequestDispatcher("edit_stu.jsp").forward(req,res);			   //转发
		}
		else if(action.equals("search_stu")){									//查询学生
			String stuNO = req.getParameter("stuNO").trim();					//得到要查询的学号
			sql = "select * from student where StudentNO='"+stuNO+"'";			//查询信息的SQL
			v = dbu.getInfo(sql);												//执行查询得到结果
			req.setAttribute("v",v);											//设置学生信息
			req.getRequestDispatcher("list_stu.jsp").forward(req,res);			//转发信息
		}
//============================学生管理结束========================================================
		else if(action.equals("book_manage")){													//图书管理
			String mID = (String)session.getAttribute("adName");				//得到登陆的管理员名
			if(mID!=null){
				res.sendRedirect("book_manage.jsp");							//转发到学生管理页面				
			}
			else{
				message = "对不起，您还没有登陆，请先登陆。";					//没有登陆的提示消息
				req.setAttribute("message",message);							//设置消息
				req.getRequestDispatcher("admin_login.jsp").forward(req,res);	//发送到登陆页面
			}						
		}
		else if(action.equals("add_book")){
			String bNO = req.getParameter("bNO").trim();					//得到图书编号
			String bName = req.getParameter("bName").trim();				//得到图书名称
			String author = req.getParameter("author").trim();				//得到图书作者
			String publish = req.getParameter("publish").trim();			//得到图书出版社名称
			String isbn = req.getParameter("isbn").trim();					//得到图书ISBN号
			String price = req.getParameter("price").trim();				//得到图书价格
			Calendar cal = Calendar.getInstance();							//得到当前日期对象
			String now = DateUtil.getDateString(cal);						//转换成字符串格式
			sql = "select * from book where BookNO='"+bNO+"'";				//查看该图书编号是否存在的SQL语句
			if(dbu.isExist(sql)){
				message = "该图书编号已经存在，请核对后输入。";			   //图书编号以存在的的提示信息
			}
			else{
				sql = "insert into book values('"+bNO+"','"+bName+
				  	  "','"+author+"','"+publish+"',"+"'"+isbn+
				  	  "',"+now+",'"+price+"',"+0+")";					//插入图书记录的SQL语句
				if(dbu.update(sql)){
					message = "添加图书成功。";								//添加成功的提示消息
				}
				else{
					message = "未知错误，添加失败。";							 //添加失败消息
				}
			}
			req.setAttribute("message",message);							//设置提示消息
			req.getRequestDispatcher("book_manage.jsp").forward(req,res);	//转发到显示页面
		}
		else if(action.equals("list_book")){						//所有图书列表
			sql = "select * from book";								//搜索所有图书记录的SQL
			int span = status.getSpan();							//得到每页显示多少条记录
			int page = 1;											//当前显示第一页
			v = dbu.getPageContent(sql,1,span);						//得到当前页显示内容			
			status.setSql(sql);										//保存SQL语句
			sql = "select count(*) from book";						//搜索记录总条数的SQL语句
			int total = dbu.getTotal(sql,span);						//得到总条数
			status.setTotal(total);									//保存记录条数
			req.setAttribute("v",v);								//设置信息向量
			req.getRequestDispatcher("list_book.jsp").forward(req,res);
		}
		else if(action.equals("delBook")){							//删除图书
			String bNO = req.getParameter("bNO").trim();			//得到要删除的图书编号
			sql = "delete from book where BookNO='"+bNO+"'";		//删除该图书的SQL语句
			if(dbu.update(sql)){
				message = "删除成功<a href='ManageServlet?"+
						  "action=list_book'>返回";				  //删除成功信息
			}
			else{
				message = "未知错误删除失败<a href='ManageServlet?"+
						  "action=list_book'>返回";				  //删除失败提示消息
			}
			req.setAttribute("message",message);					//设置消息
			req.getRequestDispatcher("list_book.jsp").forward(req,res);
		}
		else if(action.equals("editBook")){							//编辑图书信息
			String bNO = req.getParameter("bNO").trim();				//得到图书编号
			sql = "select * from book where BookNO='"+bNO+"'";			//搜索图书信息的SQL
			v = dbu.getInfo(sql);										//执行查询得到信息
			System.out.println(v.size());
			req.setAttribute("v",v);									//设置信息向量
			req.getRequestDispatcher("edit_book.jsp").forward(req,res); //发送到编辑图书页面
		}
		else if(action.equals("save_book")){
			String newBNO = req.getParameter("newNO").trim();				//得到修改后的书号
			String bName = req.getParameter("bName").trim();				//得到修改后的书名
			String author = req.getParameter("author").trim();				//得到修改后作者名
			String publish = req.getParameter("publish").trim();			//得到修改后图书出版社名称
			String isbn = req.getParameter("isbn").trim();					//得到修改后图书ISBN号
			String price = req.getParameter("price").trim();				//得到修改后图书价格
			String bNO = req.getParameter("bNO").trim();					//得到修改前的书号
			sql = "select * from book where BookNO='"+newBNO+"'";			//查看修改后的图书编号是否存在的SQL
			if(!bNO.equals(newBNO)&&dbu.isExist(sql)){
				message = "修改后的图书编号已存在，请核对输入。";			  //提示消息
			}
			else{
				sql = "update book set BookNO='"+newBNO+"',"+
					  "BookName='"+bName+"',Author='"+author+
					  "',Publish='"+publish+"',BookIsbn='"+
					  isbn+"',BookPrice="+price+" where BookNO"+
					  "='"+bNO+"'";											//更新该图书信息的SQL语句
				if(dbu.update(sql)){
					message = "图书信息修改成功。";						   //修改成功提示消息
				}
				else{
					message = "未知错误，修改失败。";							  //修改失败提示信息
				}				
			}
			sql = "select * from book where BookNO='"+newBNO+"'";			//搜索修改后的图书信息的SQL语句
			v = dbu.getInfo(sql);											//执行查询得到图书信息
			req.setAttribute("v",v);										//设置图书信息
			req.setAttribute("message",message);							//设置提示消息
			req.getRequestDispatcher("edit_book.jsp").forward(req,res); 	//发送到编辑图书页面
		}
		else if(action.equals("search_book")){								//查找图书
			String condition = req.getParameter("condition");				//得到查找条件
			String key = req.getParameter("key");							//得到查找关键字
			sql = "select * from book where "+condition+
				  " like '%"+key+"%'";										//查询的SQL语句
			v = dbu.getInfo(sql);											//执行查询得到结果
			req.setAttribute("v",v);										//设置查询结果
			req.getRequestDispatcher("list_book.jsp").forward(req,res);		//转发
		}
//===============================图书管理结束==============================================
		else if(action.equals("borrow_manage")){							//进入借阅管理时判断管理员是否登陆
			String mID = (String)session.getAttribute("adName");					 //得到登陆的管理员名
			if(mID!=null){
				res.sendRedirect("borrow_manage.jsp");								 //转发到学生管理页面				
			}
			else{
				message = "对不起，您还没有登陆，请先登陆。";						 //没有登陆的提示消息
				req.setAttribute("message",message);								 //设置消息
				req.getRequestDispatcher("admin_login.jsp").forward(req,res);		 //发送到登陆页面
			}
		}
		else if(action.equals("borrow_book")){										//学生借书
			String stuNO = req.getParameter("stuNO");								//得到要借书的学号
			String bNO = req.getParameter("bNO");									//得到要借的书号			
			sql = "select Permitted from student where StudentNO='"+stuNO+"'";		//得到该生权限的SQL语句
			String per = dbu.getStringInfo(sql);									//执行查询
			if(per!=null){
				if(per.equals("1")){													//有权限借书
					if(sdb.getCurMoney(stuNO).size()>0){								//该生有超期的书没还
						message = "该生有书超期，不可借书。";
					}
					else{
						sql = "select * from book where BookNO='"+bNO+"'";				//查看该书是否存在的SQL
						if(dbu.isExist(sql)){
							if(dbu.canBorrow(stuNO,bNO)){
								Calendar now = Calendar.getInstance();							//得到当前日期
								String start = DateUtil.getDateString(now);						//转换成字符串格式
								String end = DateUtil.addSomeDay(start,day);					//得到应归还日期
								sql = "insert into borrow_list(StudentNO,BookNO,StartTime,"+
									  "End) values('"+stuNO+"','"+bNO+"','"+start+"',"+
									  "'"+end+"')";												//向借阅表中插入借书记录的SQL
								ve.add(sql);
								sql = "update book set BookStatus=1 where BookNO='"+bNO+"'";	//更新图书状态的SQL
								ve.add(sql);
								if(dbu.update(ve)){
									message = "借书成功。";
								}
								else{
									message = "未知错误，借书失败";
								}
							}
							else{
								message = "该书已被人预约，不可借出。";
							}							
						}
						else{
							message = "该图书编号对应图书不存在，请核对后重新输入。";		  //图书不存在提示
						}					
					}
				}
				else{
					message = "该生没有借书权限。";
				}			
			}
			else{
				message = "没有该学号学生，请核对后输入";									  //没有该学号学生
			}
			req.setAttribute("message",message);
			req.getRequestDispatcher("borrow_manage.jsp").forward(req,res);
		}
		else if(action.equals("return_book")){													//学生还书
			String bNO = req.getParameter("bNO");						//得到要还书的书号
			Calendar cal = Calendar.getInstance();					//得到当前时间						
			String now = DateUtil.getDateString(cal);				//转为字符串形式
			String temp = "";											//声临时明字符串引用				
			sql = "select BorrowNO from borrow_list where BookNO='"+
				  bNO+"' and Deal!=1";									//查找该借书记录对应借书号的SQL
			String boNO = dbu.getStringInfo(sql);						//执行查询得到借书记录号
			if(boNO!=null){
				sql = "select StudentNO from borrow_list where "+
					  "BorrowNO='"+boNO+"'";
				String stuNO = dbu.getStringInfo(sql);					//得到该生学号
				sql = "select Pay from amercement where BorrowNO='"+
					  boNO+"' and Detail='丢书罚款'";											//查看该记录是否在罚款表中且没有处理存在如果存在则是挂失的图书归还
				String pay = dbu.getStringInfo(sql);					//得到是否处理
				boolean flag = false;									//是否可还书
				if(pay!=null){
					if(pay.equals("1")){
						message = "该书为丢失图书且处理完毕，不该再还书。";
					}
					else{												//挂失但未处理					
						temp = "delete from amercement where BorrowNO"+	
   							   "='"+boNO+"'";							//删除此罚款记录的SQL语句	
						ve.add(temp);						
						flag = true;									//标志位为true;
					}
				}
				if(pay==null||flag==true){								//是否可还书
					sql = "select End from borrow_list where BorrowNO='"+					  	   
					       boNO+"'";						//得到该书应该归还的时间										
					String end = dbu.getStringInfo(sql);	//执行查询得到应归还时间										
					int days = DateUtil.getDay(now,end);					//得到日期差	
					if(days==day){
						message = "当天借的书不能当天还。";
					}
					else{
						if(days<0){												//图书已超期	
							double money = -days*0.1;							//计算罚款
							temp = "insert into amercement(BorrowNO,StudentNO"+							
							   	   ",Detail,Mulct) values('"+boNO+"','"+stuNO+							
							   	   "','超期罚款',"+money+")";					//插入超期罚款记录的SQL				
							ve.add(temp);
							temp = "update student set Permitted=0 where "+
								   "StudentNO='"+stuNO+"'";						//更新该生结束权限的SQL
							ve.add(temp);
						}
						temp = "update book set BookStatus=0 where"+
							   " BookNO='"+bNO+"'";							//更新此图书状态为在馆
						ve.add(temp);
						temp = "update borrow_list set Deal=1 where"+
							   " BorrowNO='"+boNO+"'";							//更新借阅记录为已归还
						ve.add(temp);
						sql = "select OrderNO from order_list where"+
							  " BookNO='"+bNO+"' and (EndTime is null"+
							  " or EndTime='图书已丢失')";						   	//查看该书是否被预约
						String oNO = dbu.getStringInfo(sql);						//得到预约编号					
						if(oNO!=null){											//被预约
							String endTime = "";
							endTime = DateUtil.addSomeDay(now,order);			//为预约同学保存图书天数
							temp = "update order_list set EndTime='"+
								   endTime+"' where OrderNO='"+oNO+"'";			//更新预约表
							ve.add(temp);
						}
						if(dbu.update(ve)){
						message = "还书成功";
						}
						else{
							message = "未知错误，还书失败。";
						}						
					}						
				}
			}
			else{
				message = "没有对应的借书记录，请核对输入。";
			}
			req.setAttribute("message",message);
			req.getRequestDispatcher("return_book.jsp").forward(req,res);		
		}
		else if(action.equals("get_amer_list")){					//查看该生的欠费状态
			String stuNO = req.getParameter("stuNO");
			sql = "select Name from student where StudentNO='"+stuNO+"'";
    		String stuName = dbu.getStringInfo(sql);
    		if(stuName!=null){    			
				sql = "select BookName,Detail,StartTime,End,Mulct,AmerceNO from "+
					  "book,borrow_list,amercement where amercement.StudentNO='"+
	    			  stuNO+"' and Pay="+0+" and (amercement.BorrowNO="+
	    			  "borrow_list.BorrowNO and borrow_list.BookNO=book.BookNO)";//得到罚款表中没有缴纳的罚款记录
	    		v = dbu.getInfo(sql);											//得到当前超期罚款信息
	    		req.setAttribute("va",v);										//设置信息向量
	    		v = sdb.getCurMoney(stuNO);	    		
	    		req.setAttribute("vb",v);										//设置信息向量  
				req.setAttribute("stuName",stuName);							//设置学生姓名信息
	    		req.getRequestDispatcher("list_amerce.jsp").forward(req,res);	//转发到显示页面 
    		}
    		else{
    			message = "没有该学号对应的学生，请核对后输入。";
    			req.setAttribute("message",message);
				req.getRequestDispatcher("amerce.jsp").forward(req,res);		
    		}		 
		}
		else if(action.equals("amerce")){
			String aNO = req.getParameter("AmerceNO");						//得到罚款记录的主键
			sql = "select StudentNO from amercement where AmerceNO"+
				  "='"+aNO+"'";
			String stuNO = dbu.getStringInfo(sql);							//得到该生学号
			Calendar cal = Calendar.getInstance();							//得到当前时间
			String now = DateUtil.getDateString(cal);						//转换为字符串格式
			sql = "update amercement set Pay=1,PayTime='"+now+"'"+
				  " where AmerceNO='"+aNO+"'";								//更新记录
			if(dbu.update(sql)){
				message = "缴纳成功<a href='ManageServlet?"+
						  "action=get_amer_list&stuNO="+stuNO+"'>返回";		  		//提示信息
			}
			else{
				message = "缴纳失败<a href='ManageServlet?"+
						  "action=get_amer_list&stuNO="+stuNO+"'>返回";		  //提示信息
			}
			req.setAttribute("message",message);
			System.out.println(message);
			req.getRequestDispatcher("list_amerce.jsp").forward(req,res);	//准发
		}
	}
}
