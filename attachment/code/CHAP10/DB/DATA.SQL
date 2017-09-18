drop table contractsaleinfo;
drop table contractrentinfo;
drop table answerinfo;
drop table questioninfo;
drop table admininfo;
drop table relationtouserandmsg;
drop table saleinfo;
drop table rentinfo;
drop table userinfo;

create table userinfo
(
	u_id int auto_increment,
	u_name varchar(50) not null unique,
	u_pwd varchar(20) not null,
	u_gender char(2) default '男',
	u_email varchar(50) not null,
	constraint PK_userinfo primary key(u_id)
)engine innodb;

insert into userinfo(u_name,u_pwd,u_email) values('zrk','860607','zhairuike@163.com');

create table rentinfo
(
	r_id int auto_increment,				#--自增列做为主键
	r_msgtype varchar(10) not null,			#--求租或出租
	r_location varchar(200) not null,		#--地理位置
	r_detail varchar(200) not null,			#--详细位置
	r_longitude double not null,			#--经度
	r_latitude double not null,				#--纬度
	r_wuye varchar(100) not null,			#--物业
	r_type varchar(100) not null,			#--房屋类型
	r_area double not null,					#--房屋面积
	r_lease int not null,					#--租期
	r_price double not null,				#--月租
	r_linkman varchar(50) not null,			#--联系人
	r_address varchar(200) not null,		#--联系人位置
	r_tel varchar(20) not null,				#--联系人电话
	r_email varchar(50) not null,			#--联系人E-mail
	r_publishtime date not null,			#--发布时间
	r_remark varchar(200),					#--备注
	u_id int not null,						#--信息发布人ID
	r_high varchar(20) not null,			#--楼层高度
	constraint PK_rentinfo primary key(r_id),
	constraint FK_rentinfo_userinfo foreign key(u_id) references userinfo(u_id) on delete cascade
)engine innodb;



create table saleinfo
(
	s_id int auto_increment,				#--主键
	s_msgtype varchar(10) not null,			#--求购或者出售
	s_location varchar(200) not null,		#--位置
	s_detail varchar(200) not null,			#--详细位置
	s_longitude double not null,			#--经度
	s_latitude double not null,				#--纬度
	s_wuye varchar(100) not null,			#--物业
	s_type varchar(100) not null,			#--类型
	s_area double not null,					#--面积
	s_price double not null,				#--价格
	s_linkman varchar(50) not null,			#--联系人
	s_address varchar(200) not null,		#--联系人地址
	s_tel varchar(20) not null,				#--联系人电话
	s_email varchar(50) not null,			#--联系人E-mail
	s_publishtime date not null,			#--发布时间
	s_remark varchar(200),					#--备注
	u_id int not null,						#--信息发布人ID
	s_high varchar(20) not null,			#--楼层高度
	constraint PK_saleinfo primary key(s_id),
	constraint FK_saleinfo_userinfo foreign key(u_id) references userinfo(u_id) on delete cascade
)engine innodb;


create table RelationToUserAndMsg
(
	rtuam_id int auto_increment,
	r_type varchar(10) not null,
	s_id int,
	u_id int not null,
	r_agree char(2) default '否',
	r_linkman varchar(20) not null,
	r_tel varchar(20) not null,
	r_email varchar(50) not null,
	constraint PK_relationtouserandmsg primary key(rtuam_id),
	constraint FK_relationtouserandmsg_userinfo foreign key(u_id) references userinfo(u_id) on delete cascade
)engine innodb;

create table AdminInfo
(
	a_id int auto_increment,
	a_name varchar(50) not null unique,
	a_pwd varchar(20) not null,
	a_gender char(2) default '男',
	a_level varchar(10) default '普通',
	constraint PK_admininfo primary key(a_id)
)engine innodb;

insert into admininfo(a_name,a_pwd,a_level) values('zrk','860607','超级');

create table questioninfo
(
	q_id int auto_increment,					#--问题ID
	q_title text not null,						#--标题
	q_content text not null,					#--问题内容
	q_flag char(2) default '否',				#--是否回答过
	u_id int not null,							#--发表用户ID
	q_time date not null,						#--发表时间
	constraint PK_questioninfo primary key(q_id),
	constraint FK_questioninfo_userinfo foreign key(u_id) references userinfo(u_id)
)engine innodb;

create table answerinfo
(
	ai_id int auto_increment,					#--回复ID
	q_id int not null,							#--问题ID
	ai_content text not null,					#--回复内容
	ai_time date not null,						#--回复时间
	constraint PK_answerinfo primary key(ai_id),
	constraint FK_answerinfo_questioninfo foreign key(q_id) references questioninfo(q_id)
)engine innodb;

create table contractrentinfo
(												#--租赁合同
	cr_id int auto_increment,					#--合同ID号
	cr_first varchar(50) not null,				#--甲方（出租方）
	cr_second varchar(50) not null,				#--乙方（承租方）
	cr_begintime date not null,
	cr_endtime date not null,
	cr_price double not null,
	cr_firstagent varchar(50),
	cr_secondagent varchar(50),
	cr_firsttel varchar(20),
	cr_secondtel varchar(20),
	cr_address varchar(200) not null,
	cr_signtime date not null,
	cr_state varchar(20) not null,
	constraint PK_contractrentinfo primary key(cr_id)
)engine innodb;

create table contractsaleinfo
(												#--买卖合同
	cs_id int auto_increment,
	cs_first varchar(50) not null,				#--出售方
	cs_second varchar(50) not null,				#--求购方
	cs_firstcardid char(18) not null,
	cs_secondcardid char(18) not null,
	cs_houselocation varchar(200) not null,
	cs_housearea double not null,
	cs_houseprice double not null,
	cs_firstagent varchar(50),
	cs_secondagent varchar(50),
	cs_firsttel varchar(20),
	cs_secondtel varchar(20),
	cs_signtime date not null,
	cs_state varchar(20) not null,
	constraint PK_constractsaleinfo primary key(cs_id)
)engine innodb;







