#用户角色分组表
/*create table DY_User_Group
(
	UGID int auto_increment,	#分组ID
	UGDetail varchar(50),			#分组描述
	Primary key(GID)					#主键	
)engine innodb;*/
#用户角色表
create table DY_User
(
	UID int auto_increment,														#头像ID
	UName varchar(20) unique not null,								#用户名	
	UPwd varchar(20) not null,												#密码
	UGender char(2) default '男',																	#性别 男 or女
	UEmail varchar(40),																#邮箱
	URole int default 0, 															#是否是管理员 0-学生 1-老师 2-后台管理员
	UHead varchar(50) default 'UserHead/no_head.gif',	#用户图像URL
	URegDate date, 																		#用户注册日期
	ULastLogin datetime,															#最后登陆日期
	ULastEmit datetime, 															#最后发表日期
	UPermit int default 1, 														#权限 1-可发表 0-不可发表
	Primary key(UID)																	#主键
)engine innodb;
#课程表
create table DY_Topic_Group
(
	TGID int auto_increment,				#课程ID
	TGName varchar(50) not null,		#课程名称
	TDetail varchar(200) not null,	#课程描述
	Primary key(TGID)								#主键
)engine innodb
auto_increment=10000;
#话题表
create table DY_Topic
(
	TID int auto_increment,						#话题主键
	UID int,													#发帖人-外键
	TGID int,													#帖子所属板块
	TTitle varchar(200) not null,			#话题标题
	TContent text not null,						#话题内容
	TDate datetime not null,					#发表时间
	TReadCount int default 0,					#阅读次数
	Primary key(TID),									#主键
	Foreign key(UID)references DY_User(UID) on delete cascade,
	Foreign key(TGID)references DY_Topic_Group(TGID) on delete cascade
)engine innodb;
#回帖表
create table DY_Revert
(
	RID int auto_increment,				#回帖主键
	TID int,											#所回复主题的主键
	UID int,											#对应用户的主键
	RTitle varchar(200),					#回贴小标题
	RContent text not null,				#回帖内容
	RDate datetime not null,			#回帖时间
	Primary key(RID),							#主键
	Foreign key(TID)references DY_Topic(TID) on delete cascade,
	Foreign key(UID)references DY_User(UID) on delete cascade
)engine innodb;
#关系表
create table DY_TU
(
	TUID int auto_increment,				#关系表主键
	UID int,												#学生ID
	TGID int,												#课程ID
	Primary key(TUID),
	Foreign key(UID)references DY_User(UID) on delete cascade,
	Foreign key(TGID)references DY_Topic_Group(TGID) on delete cascade
)engine innodb;
#申请表
create table DY_Apply
(
	AID int auto_increment,						#申请表的ID
	UID int,													#申请人ID
	TGID int,													#所申请课的ID
	AReason varchar(200) not null,		#申请原因
	AFlag int default 0,							#申请是否处理0未处理 1已经处理
	AStatus char(10) default '申请中',#申请的处理结果
	Primary key(AID),
	Foreign key(UID)references DY_User(UID) on delete cascade,
	Foreign key(TGID)references DY_Topic_Group(TGID) on delete cascade
)engine innodb;


#插入用户
insert into DY_User(UName,UPwd,UGender,UEmail,URegDate) values('xyz','123456','男','asdf@163.com',now());
insert into DY_User(UName,UPwd,UGender,UEmail,URegDate) values('zrk','123456','男','asdf@163.com',now());
insert into DY_User(UName,UPwd,UGender,UEmail,URegDate) values('xzh','123456','女','wereq@163.com',now());
insert into DY_User(UName,UPwd,UGender,UEmail,URegDate) values('wyf','123456','男','wereq@163.com',now());


#新建课程
insert into DY_Topic_Group(TGName,TDetail) values('Java网络编程','计算机与自动控制学院');
insert into DY_Topic_Group(TGName,TDetail) values('数据库系统概论','计算机与自动控制学院');
insert into DY_Topic_Group(TGName,TDetail) values('C语言程序设计','计算机与自动控制学院');
insert into DY_Topic_Group(TGName,TDetail) values('高等数学','理学院');
insert into DY_Topic_Group(TGName,TDetail) values('线性代数','理学院');
insert into DY_Topic_Group(TGName,TDetail) values('自动控制原理','机械学院');
insert into DY_Topic_Group(TGName,TDetail) values('大学英语1','外国语学院');
insert into DY_Topic_Group(TGName,TDetail) values('运筹学','经济管理学院');
insert into DY_Topic_Group(TGName,TDetail) values('xxx','xxxx');

#更新用户权限和选择课程
update DY_User set URole=1 where UName='zrk';		#更新zrk为老师
insert into DY_TU(UID,TGID) values (2,10000);
insert into DY_TU(UID,TGID) values (2,10001);
insert into DY_TU(UID,TGID) values (2,10002);		#设置zrk为这三门课的老师
insert into DY_TU(UID,TGID) values (1,10001);
insert into DY_TU(UID,TGID) values (1,10003);
insert into DY_TU(UID,TGID) values (1,10005);		#设置1号学生的课程

#提出问题
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'Integer类的一个小问题 ==比较','Integer内的值的大小在Byte范围内时，==比较返回true 在那范围之外返回false 
这是为什么呢，为什么会这样》？ ',20,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'怎样学习框架ssh','学习struts spring hibernate 的顺序是ssh吗  顺便根据我的情况推荐几本书',15,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(2,10003,'C++很难吗？应该怎么样学习呢','请给我推荐几本C++的书，给我讲些学习方法谢谢',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(2,10001,'测试','测试测试测试测试测试测试测试测试测试',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'JAVA很难吗？应该怎么样学习呢','请给我推荐几本JAVA的书，给我讲些学习方法谢谢',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10002,'请教一句SQL这么写。。','这个SQL好难啊，应该怎么学呢',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10002,'测试71','测试测试测试测试测试测试测试测试测试7',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'测试81','测试测试测试测试测试测试测试测试测试8',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10002,'测试91','测试测试测试测试测试测试测试测试测试9',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'测试101','测试测试测试测试测试测试测试测试测试10',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10002,'测试111','测试测试测试测试测试测试测试测试测试11',12,now());
insert into DY_Topic(UID,TGID,TTitle,TContent,TReadCount,TDate) values(1,10001,'测试121','测试测试测试测试测试测试测试测试测试12',12,now());
#回复问题
insert into DY_Revert(TID,UID,RTitle,RContent,RDate) values(2,3,'','看书，上网问问题',now());
insert into DY_Revert(TID,UID,RTitle,RContent,RDate) values(1,3,'','传说新版本的JAVA 会自动缓存BYTE范围内的值.',now());
insert into DY_Revert(TID,UID,RTitle,RContent,RDate) values(1,3,'','楼主懂了吗？可以参考Java里的源代码',now());
insert into DY_Revert(TID,UID,RTitle,RContent,RDate) values(1,3,'','谢谢大家指教',now());
insert into DY_Revert(TID,UID,RTitle,RContent,RDate) values(3,3,'','认真学习，专心研究的话就好学',now());



