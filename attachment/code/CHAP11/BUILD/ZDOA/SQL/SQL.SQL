drop table oa_docdept;
drop table oa_doc;
drop table oa_attinfo;
drop table oa_attendtime;
drop table oa_alarm;
drop table oa_message;
drop table oa_sharefile;
drop table oa_sharetype;
drop table oa_transfile;
drop table oa_user;
drop table oa_role;
drop table oa_group;
drop table oa_dept;
create table oa_dept(
	dept_number varchar2(32) primary key,
	dept_name varchar2(50) not null,
	dept_info varchar2(1000) default '');
/* [部门] 部门编号，部门名称，部门简介 */
insert into oa_dept values(
	'10000','总经理室',
	'负责管理公司的重大业务'
);
insert into oa_dept values(
	'10001','市场部',
	'市场部是为实现企业的经营目标制定策略的部门，而销售部是落实策略并具体执行销售计划以完成企业经营目标的部门。因此，两者之间是指导与被指导，策略和执行、协作和交流的关系。目前在多数企业里，市场部在营销系统中的地位要高于销售部的地位。但在许多中小企业或者以销售为主的企业，销售部处于主导地位，市场部仍处于从属地位，发挥不了对销售的指导作用，仅为企业或者销售部做一些服务性和事务性的工作。'
);
insert into oa_dept values(
	'10002','技术部',
	'研究提出科技发展的宏观战略和科技促进经济社会发展的方针、政策、法规；研究科技促进经济社会发展的重大问题；研究确定科技发展的重大布局和优先领域；推动国家科技创新体系建设，提高国家科技创新能力。 组织编制全国民用科学技术发展的中长期规划和年度计划。研究提出科技体制改革的方针、政策和措施；推动建立适应社会主义市场经济和科技自身发展规律的科技创新体制和科技创新机制'
);
insert into oa_dept values(
	'10003','公关部',
	'公关部有这一套合理的工作模式。每周有固定的例会时间，总结上周的工作，并布置下周工作，集体讨论遇到各种问题，依靠集体的智慧，出色地完成工作。部门内部有着明确的分工，责任明确；接到具体任务时，大家分工合作，讲求团队精神，极大地提高了工作效率。'
);
insert into oa_dept values(
	'10004','财务部',
	'主要职能是在本机构一定的整体目标下，关于资产的购置(投资)，资本的融通(筹资)和经营中现金流量(营运资金)，以及利润分配的管理。'
);
insert into oa_dept values(
	'10005','后勤部',
	'根据上级指示精神结合我院实际，制定总务科管理规章制度和学期工作计划，并负责组织实施，检查落实执行情况。'
);
create table oa_group(
	group_number varchar2(32) primary key,
	dept_number varchar2(32) not null,
	group_name varchar2(50) not null,
	group_info varchar2(500),
	constraint fk_group_dept foreign key(dept_number) references oa_dept(dept_number)
);
/* [组] 组编号，所属部门编号，组名称，组简介*/
insert into oa_group values(
	'20000','10000','总经理办公室',
	'负责与营销沟通，提高所开发的产品的市场竞争能力； '
);
insert into oa_group values(
	'20001','10001','市场部办公室',
	'负责与营销沟通，提高所开发的产品的市场竞争能力； '
);
insert into oa_group values(
	'20002','10001','市场部职工',
	'负责与营销沟通'
);
insert into oa_group values(
	'20003','10002','技术部办公室',
	'负责组织本部门员工对专业技术知识和新工艺技术的学习，不断提高整体技术水平； '
);
insert into oa_group values(
	'20004','10002','开发组',
	'负责项目的开发'
);
insert into oa_group values(
	'20005','10002','测试组',
	'负责对项目进行测试'
);
insert into oa_group values(
	'20006','10002','维护组',
	'负责对项目进行维护'
);
insert into oa_group values(
	'20007','10003','公关部办公室',
	'组着集体活动，招待客人'
);
insert into oa_group values(
	'20008','10003','公关部职工',
	'集体活动，招待客人'
);
insert into oa_group values(
	'20009','10004','财务部办公室',
	'负责工资计算'
);
insert into oa_group values(
	'20010','10004','财务部职工',
	'负责工资计算，发放工资'
);
insert into oa_group values(
	'20011','10005','后勤部办公室',
	'负责公司的后勤工作'
);
insert into oa_group values(
	'20012','10005','后勤部职工',
	'负责后勤工作'
);
create table oa_role(
	role_number varchar2(32) primary key,
	group_number varchar2(32) not null,
	role_name varchar2(50) not null,
	role_right number(1) not null,
	constraint fk_role_group foreign key(group_number) references oa_group(group_number)
);

/*[职位及权限] 职位编号，所属组编号，职位名称，职位权限*/

insert into oa_role values(
	'30000','20000','总经理',3
);
insert into oa_role values(
	'300001','20000','总经理秘书',1
);
insert into oa_role values(
	'30001','20001','市场部经理',2
);
insert into oa_role values(
	'30002','20001','普通职工',1
);
insert into oa_role values(
	'30003','20002','普通职工',1
);
insert into oa_role values(
	'30004','20003','技术部经理',2
);
insert into oa_role values(
	'30005','20003','普通职工',1
);
insert into oa_role values(
	'30006','20004','组长',1
);
insert into oa_role values(
	'30007','20004','普通职工',1
);
insert into oa_role values(
	'30008','20005','组长',1
);
insert into oa_role values(
	'30009','20005','普通职工',1
);
insert into oa_role values(
	'30010','20006','组长',1
);
insert into oa_role values(
	'30011','20006','普通职工',1
);

insert into oa_role values(
	'30012','20007','公关部经理',2
);
insert into oa_role values(
	'30013','20007','普通职工',1
);
insert into oa_role values(
	'30014','20008','普通职工',1
);
insert into oa_role values(
	'30015','20009','财务部经理',2
);
insert into oa_role values(
	'30016','20009','普通职工',1
);
insert into oa_role values(
	'30018','20010','普通职工',1
);
insert into oa_role values(
	'30019','20011','后勤部经理',2
);
insert into oa_role values(
	'30020','20011','普通职工',1
);
insert into oa_role values(
	'30021','20012','普通职工',1
);
create table oa_user(
	user_number varchar2(32) primary key,
	user_name varchar2(20) not null,
	user_pwd varchar2(20) not null,
	user_realname varchar2(50) not null,
	user_gender char(2) check(user_gender='男' or user_gender='女'),
	user_birth date,
	dept_number varchar2(32) not null,
	group_number varchar2(32) not null,
	user_email varchar2(50),
	user_phone varchar2(20),
	role_number varchar2(32) not null,
	user_jianli varchar2(4000) default '',
	user_imgpath varchar2(100),
	user_salary number(7,2),
	constraint fk_user_dept foreign key(dept_number) references oa_dept(dept_number),
	constraint fk_user_group foreign key(group_number) references oa_group(group_number),
	constraint fk_user_role foreign key(role_number) references oa_role(role_number)
);
/*【用户】用户编号，用户名称，用户密码，真是姓名，性别，生日，所属部门编号，所属组编号，用户邮箱
   用户电话，职位编号，用户简历，头像名称，基本薪资*/
 insert into oa_user values(
 	'200801','cgq','cgq','张亮','男',to_date('1986-10-19','YYYY-MM-DD'),'10000',
 	'20000','zhangliang@163.com','03158071479','30000',
 	'毕业与河北理工大学，计算机科学与技术学院计算机科学与技术学院计算机科学与技术学院',
 	'default.png',3000
 );
 insert into oa_user values(
 	'200802','zxm','zxm','张敏','男',to_date('1986-11-19','YYYY-MM-DD'),'10001',
 	'20001','zhangmin111@163.com','03258071479','30001',
 	'毕业与河北理工大学，计算机科学与技术学院计算机科学与技术学院计算机科学与技术学院',
 	'default.png',2500
 );
 insert into oa_user values(
 	'200803','wyy','wyy','汪亮','男',to_date('1986-12-19','YYYY-MM-DD'),'10001',
 	'20001','wangliang123@163.com','03158071479','30001',
 	'毕业与河北理工大学，计算机科学与技术学院计算机科学与技术学院计算机科学与技术学院',
 	'default.png',2800
 );
 create table oa_transfile(
 	transfile_number varchar2(32) primary key,
 	transfile_name varchar2(100) not null,
 	transfile_realname varchar2(50) not null,
 	transfile_fromuser varchar2(32) not null,
 	transfile_touser varchar2(32) not null,
 	transfile_time date default sysdate not null,
 	transfile_info varchar2(100) not null,
 	transfile_type varchar2(50),
 	constraint fk_transfile_user foreign key(transfile_fromuser) references oa_user(user_number)
 );
 /*【文件传输】文件编号，文件名字，文件原始名字，发送者，接收者，发送时间，文件简介，属性类型*/

create table oa_sharetype(
	type_number varchar2(32) primary key,
	type_name varchar2(20) not null
);
/*【共享类型】类型编号，类型名称*/
insert into oa_sharetype values('40001','企业文档');
insert into oa_sharetype values('40002','图片资源');
insert into oa_sharetype values('40004','工具资源');
insert into oa_sharetype values('40003','文本资源');
insert into oa_sharetype values('40005','图片资源1');
insert into oa_sharetype values('40006','工具资源1');
insert into oa_sharetype values('40007','文本资源1');
create table oa_sharefile(
 	share_number varchar2(32) primary key,
 	share_name varchar2(100) not null,
 	share_realname varchar2(50) not null,
 	share_fromuser varchar2(32) not null,
 	share_time date default sysdate not null,
 	share_title varchar2(50) not null,
	share_info varchar2(200) not null,
	share_size number(8,2) not null,
 	share_filetype varchar2(50) not null,
	share_type varchar2(32) not null,
 	constraint fk_share_user foreign key(share_fromuser) references oa_user(user_number),
	constraint fk_share_type foreign key(share_type) references oa_sharetype(type_number)
 );
/*【共享文件】文件编号，文件名字，文件原始名字，共享者编号，共享时间，文件标题，文件信息，文件大小，文件属性类型（如文本文件，图片等），文件类型*/
create table oa_message(
	message_number varchar2(32) primary key,
	message_fromuser varchar2(32) not null,
	message_touser varchar2(32) not null,
	message_info varchar2(100) not null,
	message_content varchar2(4000) not null,
	message_time date default sysdate not null,
	constraint fk_message_user foreign key(message_fromuser) references oa_user(user_number),
	constraint fk_message_user1 foreign key(message_touser) references oa_user(user_number)
);
/* 消息编号，消息发送者，消息接收者，消息主题，消息内容，发送时间*/

create table oa_alarm(
	alarm_number varchar2(32) primary key,
	alarm_fromuser varchar2(32),
	alarm_dept varchar2(32),
	alarm_title varchar2(100),
	alarm_detail varchar2(2000),
	alarm_time date,
	alarm_state number(1) default 0,
	constraint fk_alarm_user foreign key(alarm_fromuser) references oa_user(user_number),
	constraint fk_alarm_dept foreign key(alarm_dept) references oa_dept(dept_number)
);
/* 报警编号，报警者，部门，主题，详细信息，时间，状态（0表示没有阅读，1表示已经被阅读）*/



create table oa_attendtime(
	att_starthour number(2) primary key,
	att_startmin number(2),
	att_endhour number(2),
	att_endmin number(2)
);
/* 上班的小时，上班的分钟，下班的小时，下班的分钟 */

insert into oa_attendtime values(8,30,17,30);

create table oa_attinfo(
	att_user varchar2(32),
	att_time date default sysdate,
	att_startstate number(1) default 0,
	att_starttime varchar2(10) default '缺勤',
	att_startip varchar2(15) default '无数据',
	att_endstate number(1) default 0,
	att_endtime varchar2(10) default '缺勤',
	att_endip varchar2(15) default '无数据',
	constraint attinfo primary key(att_user,att_time)
);
/* 员工编号，考勤日期，上班考勤状态0:缺勤，1，迟到，2，正常，上班考勤时间，上班考勤ip，下班考勤状态，下班考勤时间，下班考勤ip */


create table oa_doc(
	doc_num number(5) primary key,
	doc_from varchar2(32),
	doc_title varchar2(100),
	doc_content varchar2(2000),
	doc_type number(1),
	doc_time date,
	doc_state number(1) default(0),
	constraint fk_doc_user foreign key(doc_from) references oa_user(user_number)
);
/* 申请编号，申请发起者，申请主题，申请内容，申请类型1：一级审批2：二级审批，申请状态0：审批中，1：成功2：失败， */
create table oa_docdept(
	dept_num varchar2(32),
	doc_num number(5),
	doc_type number(1),
	dept_state number(1),
	constraint docdept primary key(dept_num,doc_num),
	constraint fk_docdept_doc foreign key(doc_num) references oa_doc(doc_num)
);

/* 审批部门编号，申请编号，所属审批阶段1：一级审批部门2：二级审批部门，审批状态0：未审批1：同意2：反对 */











 