drop sequence borrow_pk;
drop trigger borrow_list_pk;

drop sequence amercement_pk;
drop trigger amercement_pk;

drop sequence order_list_pk;
drop trigger order_list_pk;

drop table order_list;
drop table amercement;
drop table borrow_list;
drop table student;
drop table book;
drop table manage;

create table student
(
   StudentNO varchar(20) primary key,  	/*学号即登录名*/
   Password varchar(20),    		/*密码*/
   Name varchar(20),      		/*学生姓名*/
   Age int,        			/*学生年龄*/
   Gender varchar(2),      		/*学生性别*/
   Class varchar(50),      		/*所在班级*/
   Department varchar(50),    		/*所在系*/
   Permitted int      			/*借书权限 1:有借书权限 0:没有权限*/
 );
create table book
(
   BookNO varchar(10) primary key,  	/*图书编号*/
   BookName varchar(50),   		/*书名*/
   Author varchar(50),    		/*作者*/
   Publish varchar(50),   		/*出版社*/
   BookIsbn varchar(20),  		/*ISBN号*/
   BuyTime varchar(50),   		/*购进时间*/
   BookPrice number(5,2),    		/*图书价格*/
   BookStatus int default 0   		/*Borrowed 2:丢失  1:借出  0:在库考虑2*/
);
create table borrow_list
(
  BorrowNO int,				/*借书表主键，子增列*/
  StudentNO varchar(20),		/*学号外键*/
  BookNO varchar(10),			/*书号外键*/
  StartTime varchar(20) not null,	/*开始时间*/
  End varchar(20) not null,		/*结束时间*/
  XuJie int default 0,			/*是否续借标志*/
  Deal int default 0,			/*0:未归还 1:已归还 2:丢失*/
  primary key(BorrowNO),		/*主键*/
  Foreign key(StudentNO) references student(StudentNO) on delete cascade, 
  Foreign key(BookNO) references book(BookNO) on delete cascade
);

CREATE SEQUENCE borrow_pk START WITH 1 INCREMENT BY 1 MAXVALUE 1E30 NOCYCLE NOCACHE;   
CREATE TRIGGER borrow_list_pk
  BEFORE INSERT ON borrow_list   
  FOR EACH ROW
  BEGIN   
      select borrow_pk.nextval
      into :new.BorrowNO
      from dual;  
  END;
/
create table amercement			/*欠款表*/
(
  AmerceNO number,			/*罚款主键*/
  BorrowNO number,			/*罚款记录对应的借书记录*/
  StudentNO varchar(20),		/*罚款记录对应的学生学号*/
  Detail varchar(20) not null,		/*罚款项目 超期/丢书*/
  Mulct number(5,2) not null,		/*罚款金额*/
  Pay number(1) default 0,		/*是否缴纳默认为没有缴纳*/
  PayTime varchar(20),			/*缴纳时间*/
  primary key(AmerceNO),
  Foreign key(BorrowNO) references borrow_list(BorrowNO) on delete cascade,
  Foreign key(StudentNO) references student(StudentNO) on delete cascade
);
CREATE SEQUENCE amercement_pk START WITH 1 INCREMENT BY 1 MAXVALUE 1E30 NOCYCLE NOCACHE;   
CREATE TRIGGER amercement_pk
  BEFORE INSERT ON amercement   
  FOR EACH ROW
  BEGIN   
      select amercement_pk.nextval
      into :new.AmerceNO
      from dual;  
  END;  
/
create table order_list
(
  OrderNO number,
  StudentNO varchar(20),	/*预约图书的学生学号*/
  BookNO varchar(10),		/*所预约图书书号*/
  EndTime varchar(20),		/*预约图书截止日期*/
  primary key(OrderNO),
  Foreign key(StudentNO) references student(StudentNO) on delete cascade, 
  Foreign key(BookNO) references book(BookNO) on delete cascade  
); 
CREATE SEQUENCE order_list_pk START WITH 1 INCREMENT BY 1 MAXVALUE 1E30 NOCYCLE NOCACHE;   
CREATE TRIGGER order_list_pk
  BEFORE INSERT ON order_list   
  FOR EACH ROW
  BEGIN   
      select order_list_pk.nextval
      into :new.OrderNO
      from dual;  
  END;
/

create table manage
(
  ManageID varchar(20),			/*管理员登录名*/
  ManagePwd varchar(20) not null,	/*管理员密码*/
  ManageLevel number(1) default 0,	/*管理员级别 1:超级管理员*/
  primary key(ManageID)
);




-------------------------------------------------------------


insert into manage values('wyf','123456',1);
insert into manage values('wyy','123456',0);
insert into manage values('zrk','123456',0);
insert into manage values('cgq','123456',0);
insert into manage values('hxl','123456',0);
insert into manage values('zrx','123456',0);
insert into manage values('xzh','123456',0);
insert into manage values('syb','123456',0);

insert into student values('200501','200501','张三',20,'男','07级计算机3班','计控学院',1);
insert into student values('200502','200502','李四',22,'男','05级测绘1班','交通学院',1);
insert into student values('200503','200503','胡亮',21,'男','06级机械设计1班','机械学院',1);
insert into student values('200504','200504','曹飞',21,'女','06级土木工程2班','建工学院',1);
insert into student values('200505','200505','王霞',20,'女','07级物流管理1班','经管学院',1);
insert into student values('200506','200506','黄佳',22,'女','05级计算机1班','计控学院',1);
insert into student values('200507','200507','林珊',21,'女','06级仪表1班','计控学院',1);
insert into student values('200508','200508','高原',21,'男','07级造价1班','建工学院',1);

insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('368779','使用Ant进行Java开发','[美]Erik Hatcher Steve Lougharn','电子工业出版社','7121016834','2008-5-26',69.00);
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('454908','精通CSS+DIV网页样式与布局','曾顺编著','人民邮电出版社','9787115163042','2008-2-13',49.00);
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('487923','Visual C++面向对象编程','王育坚编著','清华大学出版社','9787302069140','2008-2-13',35.00);
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('358134','JavaSE6.0编程指南','吴亚峰 纪超编著','人民邮电出版社','9787115167408','2007-12-14','98.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('123456','NetBeans权威指南','刘斌 费冬冬 丁旋编著','电子工业出版社','9787121063206','2007-11-14','75.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('133456','Jsp2.0技术手册','林上杰 林康司编著','电子工业出版社','9787505398245','2007-12-14','59.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('233456','大话设计模式','程杰 著','清华大学出版社','9787302162063','2008-5-14','45.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('333456','红楼梦','曹雪芹 高鄂','延边人民出版社','9787806484852','2008-5-14','26.80');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('351160','UNIX初级教程','[美]Amir Afzal 著','电子工业出版社','9787121058981','2008-5-14','39.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('543235','Spring2.0技术手册','林信良 著','电子工业出版社','9787121039850','2008-5-14','49.80');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('463235','Struts2权威指南','李刚编著','电子工业出版社','9787121048531','2008-5-14','79.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('643457','XML实践教程','张秋香等编著','清华大学出版社','9787302154884','2008-5-14','39.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('354770','精通JavaWeb开发','王俊标编著','人民邮电出版社','9787115155351','2008-6-14','59.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('967564','数据库系统概论','萨师煊 王珊','高等教育出版社','9787040074949','2008-8-14','25.10');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('876462','JAVA面向对象编程 ','孙卫琴 编著','电子工业出版社','9787121025389','2008-7-14','65.80');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('465127','Java程序员面试宝典','欧立奇 朱梅 段韬 编著','电子工业出版社','9787121045523','2008-7-14','46.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('620928','Java与模式(含盘) ','阎宏 编著','电子工业出版社','9787505380004','2008-7-14','88.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('217690','Effective Java中文版','(美)布洛克 著 潘爱民 译','机械工业出版社','9787111113850','2008-9-14','39.00');
insert into book(BookNO,BookName,Author,Publish,BookIsbn,BuyTime,BookPrice) values('532870','Tomcat与Java Web开发技术详解(含盘)','孙卫琴，李洪成 编著','电子工业出版社','9787505393929','2008-9-14','45.00');


insert into borrow_list (StudentNO,BookNO,StartTime,End)values('200501','368779','2008-9-26','2008-11-15');
insert into borrow_list (StudentNO,BookNO,StartTime,End)values('200501','454908','2008-9-1','2008-10-30');
insert into borrow_list (StudentNO,BookNO,StartTime,End)values('200501','487923','2008-9-1','2008-10-30');
insert into borrow_list (StudentNO,BookNO,StartTime,End)values('200501','333456','2008-7-1','2008-9-1');
insert into borrow_list(StudentNO,BookNO,StartTime,End)values('200501','351160','2008-10-1','2008-11-30');
update book set BookStatus=1 where BookNO='368779';
update book set BookStatus=1 where BookNO='454908';
update book set BookStatus=1 where BookNO='487923';
update book set BookStatus=1 where BookNO='358134';

insert into order_list(StudentNO,BookNO,EndTime)values ('200502','358134','2008-10-16');
insert into order_list(StudentNO,BookNO)values ('200502','333456');
update book set BookStatus=1 where BookName='红楼梦';

insert into order_list(StudentNO,BookNO,EndTime)values ('200502','358134','2008-10-16');
insert into order_list(StudentNO,BookNO)values ('200502','333456');

commit;