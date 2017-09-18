package wyf.wyy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;

public class StudentServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
    	this.doPost(req,res);
    }   	    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
    	res.setCharacterEncoding("GBK");				//设置res编码为GBK								
    	req.setCharacterEncoding("GBK");				//设置req编码为GBK
    	HttpSession session = req.getSession();			//得到session对象
    	String action = req.getParameter("action");		//得到action动作
    	String message = "";							//声明消息字符串
    	String sql = "";								//声明SQL语句字符串
    	Vector<Vector<String>> v;						//声明信息向量引用
    	Vector<String> student;							//存放学生信息的向量
    	Vector<String> ve = new Vector<String>();		//存放临时SQL语句
    	final int delay = 30;							//续借图书天数
    	final int distance = 5;							//限制可以续借的时间
    	String stuNO = (String)session.getAttribute("stuNO");//得到当前登陆的学生信息
    	//获取Web环境中的Spring容器引用
        WebApplicationContext wac
           = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        StuDB sdb = (StuDB)wac.getBean("StuDB");						//得到StuDB对象
        DBUtil dbu = (DBUtil)wac.getBean("DBUtil");						//得到DBUtil对象    	
    	if(action.equals("login")){							
			stuNO = req.getParameter("uname").trim();			//得到登陆用户名
			String pwd = req.getParameter("pwd").trim();				//得到登陆密码			
			if((sdb.verify(stuNO,pwd))){								//登陆成功								
    			student = sdb.getStuInfo(stuNO);						//执行查询得到该学生信息
    			session.setAttribute("stuNO",stuNO);					//将学号放进session
    			session.setAttribute("stuName",student.get(1));			//将学生姓名放进session		
			}
			else{
				message = "非法的用户名和密码，请核对后重新登陆。";	 //登陆失败消息
				req.setAttribute("message", message);					//设置消息						
			}
			req.getRequestDispatcher("login.jsp").forward(req,res);	//转发置login页面							
    	}
    	else if(action.equals("logout")){
			req.getSession(true).invalidate();							//使session失效
			req.getRequestDispatcher("login.jsp").forward(req,res); 	//转发至登陆页面
    	}
    	else if(action.equals("stuInfo")){								//查看学生信息
    		if(stuNO!=null){											//学生已经登陆
    			student = sdb.getStuInfo(stuNO);						//查询得到学生信息
    			req.setAttribute("student",student);					//设置学生信息
    			req.getRequestDispatcher("stuInfo.jsp").forward(req,res);//没有登陆则转发至登陆页面
    		}
    		else{
    			message = "您还没有登陆，请先登陆再查看。"	;			 //提示消息
    			req.setAttribute("message", message);					//设置消息
    			req.getRequestDispatcher("login.jsp").forward(req,res); //没有登陆则转发至登陆页面
    		}
    	}
    	else if(action.equals("stuChangePwd")){
    		String oldPwd = req.getParameter("oldPwd").trim();			//得到学生输入的旧密码
    		String newPwd = req.getParameter("newPwd").trim();			//得到要修改后的密码    		
    		boolean flag = sdb.changePwd(stuNO,oldPwd,newPwd);			//调用更新学生密码的方法
    		if(flag==true){												//更新成功
    			message = "密码修改成功，下次请用新密码登陆。";			//给学生用户的提示消息    			
    		}
    		else{														//密码修改失败
    			message = "旧密码输入错误，请核对后重新修改。";			//修改失败的提示信息
    		}
    		student = sdb.getStuInfo(stuNO);						//查询得到学生信息
    		req.setAttribute("student",student);						//设置学生信息
 				req.setAttribute("message", message);						//设置消息
    		req.getRequestDispatcher("stuInfo.jsp").forward(req,res); 	//没有登陆则转发至登陆页面   		
    	}
			else if(action.equals("cb")){											//当前借阅图书查询
				if(stuNO!=null){													//学生已经登陆
					sql = "select borrow_list.BookNO,BookName,Author,"+
			    		  "Publish,StartTime,End,BorrowNO from borrow_list,book"+
			    		  " where borrow_list.StudentNO='"+stuNO+"' and"+
			    		  " borrow_list.BookNO=book.BookNO and Deal="+0;			//查询当前借阅图书的SQL
					v = dbu.getInfo(sql);											//查询得到当前借书记录
					for(int i=0;i<v.size();i++){
						Vector<String> vtemp = v.get(i);							//遍历取出每一条记录
						String end = vtemp.get(5);									//得到归还时间字符串表示
						Calendar cal = Calendar.getInstance();						//得到当前时间
						String now = DateUtil.getDateString(cal);					//转换为字符串表示
						if(DateUtil.getDay(now,end)<0){								//图书已超期
							String newEnd = "<font color='red'/>"+end;				//将超期的书归还日期设置为红色字体
							vtemp.setElementAt(newEnd,5);
						}
					}
					req.setAttribute("v",v);										//设置信息向量
					req.getRequestDispatcher("current_book.jsp").forward(req,res); 	//转发至显示页面    			
				}
				else{
					message = "您还没有登陆，请先登陆再查看。"	;			 //提示消息
					req.setAttribute("message", message);					//设置消息
					req.getRequestDispatcher("login.jsp").forward(req,res); //没有登陆则转发至登陆页面
				}    		
			}
		  else if(action.equals("bh")){										//借阅历史查询    	
    		StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
    		int page = 1;													//当前显示第一页
    		int span = status.getSpan();									//得到每页显示多少条记录  		
    		sql = "select borrow_list.BookNO,BookName,Author,"+
    		  	  "Publish,StartTime,End,Deal from borrow_list,book "+
    		  	  "where borrow_list.StudentNO='"+stuNO+"' and"+
    		      " borrow_list.BookNO=book.BookNO and Deal!="+0;			//查询当前学生借阅历史的SQL
    		status.setSql(sql);												//保存SQL语句
    		v = dbu.getPageContent(sql,page,span);							//得到当前页显示记录
    		sql = "select count(*) from borrow_list where StudentNO"+
    			  "='"+stuNO+"' and Deal!="+0;								//得到总页数的SQL
    		int total = dbu.getTotal(sql,span);								//得到总页数			
    		status.setCurPage(page);										//设置当前显示第一页
    		status.setTotal(total);											//保存总页数
    		session.setAttribute("status",status);							//放进session    		
    		req.setAttribute("v",v);
    		req.getRequestDispatcher("borrow_history.jsp").forward(req,res);//转发
    	}
    	else if(action.equals("changePage")){								//点击换页时
    		String curPageStr = req.getParameter("curPage").trim();			//得到换页的参数
    		String url = req.getParameter("url").trim();					//得到要转发的页面
    		System.out.println(url+"要转向的页面"+"第"+curPageStr+"页");
    		int page = Integer.parseInt(curPageStr);						//转成整型数值
    		StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
    		status.setCurPage(page);										//保存当前页
    		int span = status.getSpan();									//得到每页显示记录条数
    		sql = status.getSql();											//得到查询记录的SQL语句
    		v = dbu.getPageContent(sql,page,span);							//得到改变后的显示记录
    		session.setAttribute("status",status);							//保存状态到session
    		req.setAttribute("v",v);										//设置记录内容
    		req.getRequestDispatcher(url).forward(req,res);//转发    		
    	}
    	else if(action.equals("lb")){										//丢书记录    	
    		StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的JavaBean
    		int page = 1;													//当前显示第一页
    		int span = status.getSpan();									//得到每页显示多少条记录
    		sql = "select borrow_list.BookNO,BookName,Author,"+
    		  	  "Publish,StartTime from borrow_list,book "+
    		  	  "where borrow_list.StudentNO='"+stuNO+"' and"+
    		      " borrow_list.BookNO=book.BookNO and Deal="+2;			//从借书记录中搜索丢失记录的SQL
    		status.setSql(sql);												//保存SQL语句
    		v = dbu.getPageContent(sql,page,span);							//执行查询    		
    		sql = "select count(*) from borrow_list where StudentNO='"+
    			  stuNO+"' and Deal="+2;									//得到记录总条数的SQL
    		int total = dbu.getTotal(sql,span);								//得到总页数
    		status.setTotal(total);											//保存总页数    		
    		status.setCurPage(page);										//设置当前显示第一页
    		session.setAttribute("status",status);							//保存状态到session
    		req.setAttribute("v",v);										//设置要显示记录内容
    		req.getRequestDispatcher("lost_book.jsp").forward(req,res);		//转发
    	}
			else if(action.equals("guashi")){							//图书挂失
				String loseNO = req.getParameter("loseNO").trim();		//得到挂失图书对应借阅记录的主键编号    		
				sql = "update book set BookStatus="+2+" where "+
					  "BookNO=(select BookNO from borrow_list "+
					  "where BorrowNO='"+loseNO+"')";					//更新图书状态的的SQL
				ve.add(sql);											//将SQL语句添加进向量
				sql = "update borrow_list set Deal="+2+" where "+
					  "BorrowNO='"+loseNO+"'";							//更新借书记录的Deal字段的SQL语句
				ve.add(sql);											//将SQL语句添加进向量
				sql = "insert into amercement(BorrowNO,StudentNO,"+
					  "Detail,Mulct) values('"+loseNO+"','"+stuNO+
					  "','丢书罚款',(select BookPrice from book,"+
					  "borrow_list where borrow_list.BookNO="+
					  "book.BookNO and borrow_list.BorrowNO='"+loseNO+"'))";//向罚款记录中插入该生丢书罚款记录
				ve.add(sql);											//将SQL语句添加进向量
				Calendar cal = Calendar.getInstance();					//得到当前日期
				String now = DateUtil.getDateString(cal);				//转换为日期格式
				sql = "select End from borrow_list where BorrowNO='"+
					  loseNO+"'";										//得到该书应该归还的时间的SQL语句
				String end = dbu.getStringInfo(sql);					//执行查询得到应归还时间
				int days = DateUtil.getDay(now,end);					//得到日期差
				if(days<0){												//图书已超期
					double money = -days*0.1;							//计算罚款
					sql = "insert into amercement(BorrowNO,StudentNO"+
					   	   ",Detail,Mulct) values('"+loseNO+"','"+stuNO+
					   	   "','超期罚款',"+money+")";					//插入超期罚款记录的SQL
					ve.add(sql);										//将SQL语句添加进向量
				}
				sql = "update student set Permitted=0 where StudentNO"+
					  "='"+stuNO+"'";									//更新该学生的借书权限
				ve.add(sql);
				sql = "select OrderNO from order_list where BookNO="+
					  "(select BookNO from borrow_list where BorrowNO='"+
					  loseNO+"') and EndTime is null";					//查看该预订列表中是否有该书的预约记录
				String OrderNO = dbu.getStringInfo(sql);
				System.out.println(sql+OrderNO+"预约列表");
				if(OrderNO!=null){
					sql = "update order_list set EndTime='图书已丢失' where "+
						  "EndTime is null and OrderNO='"+OrderNO+"'";	//更新预订列表中该图书的预订记录设置截止时间为”该书已丢失“
					ve.add(sql);										//将SQL语句添加进向量
				}
				boolean flag = dbu.update(ve); 							//调用事务处理方法执行更新
				sql = "select BookName from book,borrow_list where "+
					  "borrow_list.BookNO=book.BookNO and BorrowNO='"+
					  loseNO+"'";										//得到挂失图书的书名的SQL
				String bookName = dbu.getStringInfo(sql);				//执行查询得到图书名
				if(flag==true){
					message = "<font color='red'/>"+bookName+"，挂失成功，"+
							  "您失去借书权限，请到管理处交纳罚款，开通借书权限。";//给出挂失提示消息
				}
				else{
					message = "<font color='red'/>"+bookName+"挂失失败，"+
							  "发生未知错误！！！";							   //挂失失败提示消息
				}
				req.setAttribute("message",message);							//设置消息
				req.getRequestDispatcher("stu_info_one.jsp").forward(req,res);	//发回页面
			}
    	else if(action.equals("xujie")){									//续借图书
    		String bNO = req.getParameter("borrowNO");						//得到要续借的结束记录号
    		sql = "select XuJie from borrow_list where BorrowNO="+bNO;	//查询是否已经续借的标志
    		String flag = dbu.getStringInfo(sql).trim();							//执行查询得到结果
    		if(flag.equals("1")){											//已经续借过一次
    			message = "该书已经续借过一次，不能再次续借。";			   //给出提示消息
    		}
    		else{
    			sql = "select order_list.BookNO from borrow_list,"+
    				  "order_list where BorrowNO="+bNO+" and "+
    				  "borrow_list.BookNO=order_list.BookNO";				//查询该书是否在被预约的SQL
    			if(dbu.isExist(sql)){
    				message = "该书已经被预约，请您按时还书。";			//给出提示消息		
    			}
    			else{
    				sql = "select End from borrow_list where BorrowNO"+
    					  " ='"+bNO+"'";									//此书的应该归还的时间
    				String end = dbu.getStringInfo(sql);					//执行查询得到结果
    				Calendar cal = Calendar.getInstance();					//得到当前时间
    				String now = DateUtil.getDateString(cal);			//转换为字符串格式
    				String newEnd = DateUtil.addSomeDay(end,delay);			//将归还日期加上续借天数
    				int day = DateUtil.getDay(now,end);						//得到距离还书日期的天数
    				if(day>distance){
    					message = "续借图书只能在归还前5天续借。";		  //不在归还前5天的提示消息
    				}
    				else{
    					if(day<=0){											//图书已经超期
    						message = "图书已超期，不可续借，请"+
    								  "尽快还书。";						   //超期提示消息
    					}
    					else{
    						sql = "update borrow_list set End='"+newEnd+"'"+
    							  ",Xujie=1 where BorrowNO='"+bNO+"'";		//更新借阅记录表的SQL
    						if(dbu.update(sql)){
    							message = "续借成功，新的归还日期为"+newEnd;//续借成功信息
    						}
    					}
    				}
    			}			
    		}
    		req.setAttribute("message",message);						//设置提示消息
    		req.getRequestDispatcher("stu_info_one.jsp").forward(req,res);//转发    
    	}
    	else if(action.equals("fk")){										//罚款记录    	
    		StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的JavaBean
    		int span = status.getSpan();									//得到每页显示多少条记录
    		int page =	1;													//当前显示第一页
    		sql = "select PayTime,Detail,Mulct,BookName from book,"+
    			  "borrow_list,amercement where amercement.StudentNO='"+
    			  stuNO+"' and Pay="+1+" and (amercement.BorrowNO="+
    			  "borrow_list.BorrowNO and borrow_list.BookNO=book.BookNO)";//得到已经缴费的记录的SQL语句    		
    		status.setSql(sql);												//保存SQL    		
    		v = dbu.getPageContent(sql,page,span);							//得到当前页显示的内容    		
    		sql = "select count(*) from amercement where StudentNO='"+
    			  stuNO+"' and Pay="+1;										//得到记录总条数的SQL语句
    		int total = dbu.getTotal(sql,span);								//执行查询得到记录总条数
    		sql = "select sum(Mulct) from amercement";						//得到已缴纳罚款总和的SQL
    		String money = dbu.getStringInfo(sql);							//执行查询   
    		status.setTotal(total);											//保存总页数    		
    		status.setCurPage(page);										//设置当前显示第一页
    		status.setMoney(money);											//保存已缴欠款
    		session.setAttribute("status",status);							//保存状态到session
    		req.setAttribute("v",v);										//设置要显示记录内容
    		req.getRequestDispatcher("account.jsp").forward(req,res);		//转发
    	}
    	else if(action.equals("cf")){										//当前罚款，即还为缴纳的欠款    
    		sql = "select BookName,Detail,StartTime,End,Mulct from book,"+
    			  "borrow_list,amercement where amercement.StudentNO='"+
    			  stuNO+"' and Pay="+0+" and (amercement.BorrowNO="+
    			  "borrow_list.BorrowNO and borrow_list.BookNO=book.BookNO)";//得到罚款表中没有缴纳的罚款记录
    		v = dbu.getInfo(sql);
    		v.addAll(sdb.getCurMoney(stuNO));								//得到当前借书记录中超期的罚款信息
    		req.setAttribute("v",v);										//设置信息向量
    		req.getRequestDispatcher("current_amerce.jsp").forward(req,res);//转发到显示页面    		    		
    	}
    	else if(action.equals("gs")){											//读者挂失图书证
    		String pwd = req.getParameter("pwd");								//得到输入的密码
    		if(sdb.verify(stuNO,pwd)){
    			sql = "update student set Permitted="+0+" where StudentNO"+
    				  "='"+stuNO+"'";											//更新该学生的借书权限的SQL语句
	    		if(dbu.update(sql)==true){
	    			message = "挂失成功。";											//挂失成功的提示消息
	    		}
	    		else{
	    			message = "未知错误，挂失失败。";								//挂失失败的提示消息
	    		}
	    	}
	    	else{
	    		message = "密码错误，挂失失败。";
	    	}    		
    		req.setAttribute("message",message);							//设置提示消息
    		req.getRequestDispatcher("lost_card.jsp").forward(req,res);		//转发到页面
    	}
		else if(action.equals("inform")){									//预约通知列表
			sql = "select order_list.StudentNO,Class,BookName,Author,"+
				  "book.BookNO,EndTime from student,book,order_list "+
				  "where student.StudentNO=order_list.StudentNO and "+
				  "book.BookNO=order_list.BookNO and EndTime is not null";	//搜索所有预订记录的SQL语句
			StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
			if(status==null){
				status = new StatusBean();									//为空则创建一个Bean对象
			}
			int span = status.getSpan();									//得到每页显示多少条记录
			int page =	1;													//当前显示第一页
			status.setSql(sql);												//保存SQL    	
			v = dbu.getPageContent(sql,page,span);							//得到当前页显示的内容
			sql = "select count(*) from student,book,order_list "+
				  "where student.StudentNO=order_list.StudentNO and "+
				  "book.BookNO=order_list.BookNO and EndTime is not null";
			int total = dbu.getTotal(sql,span);								//执行查询得到记录总条数
			status.setTotal(total);											//保存总页数    		
			status.setCurPage(page);										//设置当前显示第一页
			session.setAttribute("status",status);							//保存状态到session
			req.setAttribute("v",v);										//设置要显示记录内容
			req.getRequestDispatcher("order_list.jsp").forward(req,res);	//转发	
		}
		else if(action.equals("simple")){										//查询图书search book
			String key = req.getParameter("key").toUpperCase();				//得到关键字
			String condition = req.getParameter("condition");				//得到查询条件
			sql = "select BookNO,BookName,Author,Publish,BookIsbn,"+
				  "BuyTime,BookPrice,BookStatus from book where upper("+
				  condition+") like '%"+key+"%'";							//模糊查询的SQL语句
			StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
			int span = status.getSpan();									//得到每页显示多少条记录
			int page =	1;													//当前显示第一页   		
			status.setSql(sql);												//保存SQL    	
			v = dbu.getPageContent(sql,page,span);							//得到当前页显示的内容    		
			sql = "select count(*) from book where "+condition+" like "+
				  "'%"+key+"%'";											//得到记录总条数的SQL语句
			int total = dbu.getTotal(sql,span);								//执行查询得到记录总条数
			status.setTotal(total);											//保存总页数    		
			status.setCurPage(page);										//设置当前显示第一页
			session.setAttribute("status",status);							//保存状态到session
			req.setAttribute("v",v);										//设置要显示记录内容
			req.getRequestDispatcher("query_book_result.jsp").forward(req,res);	//转发	
		}
		else if(action.equals("complex")){									//复杂查询
			String BookName = req.getParameter("BookName").toUpperCase();	//得到书名查询关键字
			String Author = req.getParameter("Author").toUpperCase();		//得到作者查询关键字
			String Publish = req.getParameter("Publish").toUpperCase();		//得到出版社查询关键字
			sql = "select BookNO,BookName,Author,Publish,BookIsbn,"+
				  "BuyTime,BookPrice,BookStatus from book where upper("+
				  "BookName) like '%"+BookName+"%' and upper(Author) like"+
				  "'%"+Author+"%' and upper(Publish) like '%"+Publish+"%'";	//模糊查询的SQL语句
			StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
			int span = status.getSpan();									//得到每页显示多少条记录
			int page =	1;													//当前显示第一页   		
			status.setSql(sql);												//保存SQL    	
			v = dbu.getPageContent(sql,page,span);							//得到当前页显示的内容    		
			sql = "select count(*) from book where upper(BookName) like "+
				  "'%"+BookName+"%' and upper(Author) like'%"+Author+"%' "+
				  "and upper(Publish) like '%"+Publish+"%'";					//得到记录总条数的SQL语句
			System.out.println(sql);
			int total = dbu.getTotal(sql,span);								//执行查询得到记录总条数
			status.setTotal(total);											//保存总页数    		
			status.setCurPage(page);										//设置当前显示第一页
			session.setAttribute("status",status);							//保存状态到session
			req.setAttribute("v",v);										//设置要显示记录内容
			req.getRequestDispatcher("query_book_result.jsp").forward(req,res);	//转发	
		}
    	else if(action.equals("order")){									//预约图书
    		String bookNO = req.getParameter("bookNO");						//得到预约图书编号
    		sql = "select Permitted from student where StudentNO='"+stuNO+"'";//查看该生权限
    		String per = dbu.getStringInfo(sql);							//得到权限
    		if(per.equals("0")){
    			message = "您没有借书权限，所以不可预订，请到管理处开通。"
    					  +"<a href='StudentServlet?action=changePage"+
	    				  "&url=query_book_result.jsp&curPage=1'/><br>"+
	    				  "点击这里返回"; 									 //提示消息
    		}
    		else{	
	    		sql = "insert into order_list(StudentNO,BookNO)values "+
	    			  "('"+stuNO+"','"+bookNO+"')";							//向预约表中插入预约记录的SQL语句
	    		if(dbu.update(sql)==true){
	    			message = "预约成功，请关注预约通知，并按时取书。"+
	    					  "<a href='StudentServlet?action=changePage"+
	    					  "&url=query_book_result.jsp&curPage=1'/><br>"+
	    					  "点击这里返回";		  //预约成功提示消息		
	    		}
	    		else{
	    			message = "很抱歉，由于未知错误，预约失败。"+
	    					  "<a href='StudentServlet?action=changePage"+
	    					  "&url=query_book_result.jsp&curPage=1'/><<返回";    	  //预约失败提示消息
	    		}
    		}    		
    		req.setAttribute("message",message);							//设置提示消息
    		req.getRequestDispatcher("stu_info_two.jsp").forward(req,res);	//转发
    	}
    	else if(action.equals("sarchMyOrder")){								//查询自己的预订
    		String studentNO = req.getParameter("stuNO");					//得到要查询预订记录的学号
    		sql = "select order_list.StudentNO,Class,BookName,Author,"+
    			  "book.BookNO,EndTime from student,book,order_list "+
    			  "where student.StudentNO=order_list.StudentNO and "+
    			  "book.BookNO=order_list.BookNO and order_list.StudentNO"+
    			  "='"+studentNO+"' and EndTime is not null";				//搜索所有预订记录的SQL语句
    		System.out.println(sql);
    		StatusBean status = (StatusBean)session.getAttribute("status");	//得到记录状态的Bean
    		int span = status.getSpan();									//得到每页显示多少条记录
    		int page =	1;													//当前显示第一页
    		status.setSql(sql);												//保存SQL    	
    		v = dbu.getPageContent(sql,page,span);							//得到当前页显示的内容
    		sql = "select count(*) from order_list where StudentNO"+
    			  "='"+studentNO+"'";										//搜索记录总条数的SQL			
    		int total = dbu.getTotal(sql,span);								//执行查询得到记录总条数
    		status.setTotal(total);											//保存总页数    		
    		status.setCurPage(page);										//设置当前显示第一页
    		session.setAttribute("status",status);							//保存状态到session
    		req.setAttribute("v",v);										//设置要显示记录内容
    		req.getRequestDispatcher("order_list.jsp").forward(req,res);	//转发	
    	}
    }
}