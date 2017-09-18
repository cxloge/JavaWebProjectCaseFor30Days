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
	u_gender char(2) default '��',
	u_email varchar(50) not null,
	constraint PK_userinfo primary key(u_id)
)engine innodb;

insert into userinfo(u_name,u_pwd,u_email) values('zrk','860607','zhairuike@163.com');

create table rentinfo
(
	r_id int auto_increment,				#--��������Ϊ����
	r_msgtype varchar(10) not null,			#--��������
	r_location varchar(200) not null,		#--����λ��
	r_detail varchar(200) not null,			#--��ϸλ��
	r_longitude double not null,			#--����
	r_latitude double not null,				#--γ��
	r_wuye varchar(100) not null,			#--��ҵ
	r_type varchar(100) not null,			#--��������
	r_area double not null,					#--�������
	r_lease int not null,					#--����
	r_price double not null,				#--����
	r_linkman varchar(50) not null,			#--��ϵ��
	r_address varchar(200) not null,		#--��ϵ��λ��
	r_tel varchar(20) not null,				#--��ϵ�˵绰
	r_email varchar(50) not null,			#--��ϵ��E-mail
	r_publishtime date not null,			#--����ʱ��
	r_remark varchar(200),					#--��ע
	u_id int not null,						#--��Ϣ������ID
	r_high varchar(20) not null,			#--¥��߶�
	constraint PK_rentinfo primary key(r_id),
	constraint FK_rentinfo_userinfo foreign key(u_id) references userinfo(u_id) on delete cascade
)engine innodb;



create table saleinfo
(
	s_id int auto_increment,				#--����
	s_msgtype varchar(10) not null,			#--�󹺻��߳���
	s_location varchar(200) not null,		#--λ��
	s_detail varchar(200) not null,			#--��ϸλ��
	s_longitude double not null,			#--����
	s_latitude double not null,				#--γ��
	s_wuye varchar(100) not null,			#--��ҵ
	s_type varchar(100) not null,			#--����
	s_area double not null,					#--���
	s_price double not null,				#--�۸�
	s_linkman varchar(50) not null,			#--��ϵ��
	s_address varchar(200) not null,		#--��ϵ�˵�ַ
	s_tel varchar(20) not null,				#--��ϵ�˵绰
	s_email varchar(50) not null,			#--��ϵ��E-mail
	s_publishtime date not null,			#--����ʱ��
	s_remark varchar(200),					#--��ע
	u_id int not null,						#--��Ϣ������ID
	s_high varchar(20) not null,			#--¥��߶�
	constraint PK_saleinfo primary key(s_id),
	constraint FK_saleinfo_userinfo foreign key(u_id) references userinfo(u_id) on delete cascade
)engine innodb;


create table RelationToUserAndMsg
(
	rtuam_id int auto_increment,
	r_type varchar(10) not null,
	s_id int,
	u_id int not null,
	r_agree char(2) default '��',
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
	a_gender char(2) default '��',
	a_level varchar(10) default '��ͨ',
	constraint PK_admininfo primary key(a_id)
)engine innodb;

insert into admininfo(a_name,a_pwd,a_level) values('zrk','860607','����');

create table questioninfo
(
	q_id int auto_increment,					#--����ID
	q_title text not null,						#--����
	q_content text not null,					#--��������
	q_flag char(2) default '��',				#--�Ƿ�ش��
	u_id int not null,							#--�����û�ID
	q_time date not null,						#--����ʱ��
	constraint PK_questioninfo primary key(q_id),
	constraint FK_questioninfo_userinfo foreign key(u_id) references userinfo(u_id)
)engine innodb;

create table answerinfo
(
	ai_id int auto_increment,					#--�ظ�ID
	q_id int not null,							#--����ID
	ai_content text not null,					#--�ظ�����
	ai_time date not null,						#--�ظ�ʱ��
	constraint PK_answerinfo primary key(ai_id),
	constraint FK_answerinfo_questioninfo foreign key(q_id) references questioninfo(q_id)
)engine innodb;

create table contractrentinfo
(												#--���޺�ͬ
	cr_id int auto_increment,					#--��ͬID��
	cr_first varchar(50) not null,				#--�׷������ⷽ��
	cr_second varchar(50) not null,				#--�ҷ������ⷽ��
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
(												#--������ͬ
	cs_id int auto_increment,
	cs_first varchar(50) not null,				#--���۷�
	cs_second varchar(50) not null,				#--�󹺷�
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






