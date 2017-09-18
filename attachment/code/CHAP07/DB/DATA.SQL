drop trigger tr_admininfo;
drop sequence sq_admininfo;
drop table admininfo;

drop trigger tr_orderinfo;
drop sequence sq_orderinfo;
drop table orderinfo;

drop trigger tr_msginfo;
drop sequence sq_msginfo;
drop table msginfo;

drop trigger tr_relationinfo;
drop sequence sq_relationinfo;
drop table relationinfo;

drop trigger tr_traininfo;
drop sequence sq_traininfo;
drop table traininfo;

drop trigger tr_stationinfo;
drop sequence sq_stationinfo;
drop table stationinfo;

drop trigger tr_typeinfo;
drop sequence sq_typeinfo;
drop table typeinfo;

drop sequence sq_userinfo;
drop trigger tr_userinfo;
drop table userinfo;

create table userinfo
(
	userid number,
	uname varchar2(50) not null unique,
	upwd varchar2(20) not null,
	ugender varchar(4) default '男',
	constraint PK_userinfo primary key(userid)
);

create sequence sq_userinfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_userinfo
  before insert on userinfo  for each row 
  begin
      select sq_userinfo.nextval 
      into :new.userid
      from dual;
  end;
/
--------------------------------------------


create table typeinfo
(
	tid number,
	tname varchar2(50) not null unique,
	constraint PK_typeinfo primary key(tid)
);
create sequence sq_typeinfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_typeinfo
  before insert on typeinfo for each row
  begin
    select sq_typeinfo.nextval
    into :new.tid
    from dual;
  end;
/
--------------------------------------------


create table stationinfo
(
	sid number,
	sname varchar2(50) not null unique,
	constraint PK_stationinfo primary key(sid)
);
create sequence sq_stationinfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_stationinfo
  before insert on stationinfo for each row
  begin
    select sq_stationinfo.nextval
    into :new.sid
    from dual;
  end;
/
-----------------------------------------------



create table traininfo
(
	tid number,
	tname varchar2(50) not null unique,
	tstartid number not null,
	tendid number not null,
	ttypeid number not null,
	constraint PK_traininfo primary key(tid),
	constraint FK_tstartid foreign key(tstartid) references stationinfo(sid),
	constraint FK_tendid foreign key(tendid) references stationinfo(sid),
	constraint FK_ttypeid foreign key(ttypeid) references typeinfo(tid)
);
create sequence sq_traininfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_traininfo
  before insert on traininfo for each row
  begin
    select sq_traininfo.nextval
    into :new.tid
    from dual;
  end;
/
-----------------------------------------------


create table relationinfo
(
	rid number,
	tid number not null,
	sid number not null,
	rarrive date, 
	rstart date,
	rsequence number not null,
	constraint PK_relationinfo primary key(rid),
	constraint FK_rsid foreign key(sid) references stationinfo(sid),
	constraint FK_tid foreign key(tid) references typeinfo(tid)
);
create sequence sq_relationinfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_relationinfo
  before insert on relationinfo for each row
  begin
    select sq_relationinfo.nextval
    into :new.rid
    from dual;
  end;
/
------------------------------------------


create table msginfo
(
	mid number,			--主键
	mtype number not null,		--1--转让  2--求购
	mname varchar2(20) not null,	--车次名字
	userid number not null,		--发布信息的用户
	mpublishtime date,		--发布时间
	mlinkman varchar2(50) not null,	--联系人
	mtel varchar2(20) not null,	--联系电话
	mticketprice varchar2(20),	--转让价格
	mtickettime date not null,	--车票日期
	mstart varchar2(50) not null,	--出发城市
	mend varchar2(50) not null,	--目的城市
	mmsg varchar2(1000),		--信息内容
	mlevel varchar2(20),		--席别
	mamount number not null,	--数量
	constraint PK_msginfo primary key(mid),
	constraint FK_uid foreign key(userid) references userinfo(userid)
);
create sequence sq_msginfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_msginfo
  before insert on msginfo for each row
  begin
    select sq_msginfo.nextval
    into :new.mid
    from dual;
  end;
/
------------------------------------------


create table orderinfo
(
	oid number,
	userid number not null,
	ostart varchar2(50) not null,
	oend varchar2(50) not null,
	tid number not null,
	linkman varchar2(50) not null,
	address varchar2(200) not null,
	tel varchar2(20) not null,
	amount number not null,
	tdate date not null,
	ostate varchar2(50) default '未处理',
	constraint PK_orderinfo primary key(oid),
	constraint FK_otid foreign key(tid) references traininfo(tid),
	constraint FK_ouid foreign key(userid) references userinfo(userid)
);
create sequence sq_orderinfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_orderinfo
  before insert on orderinfo for each row
  begin
    select sq_orderinfo.nextval
    into :new.oid
    from dual;
  end;
/

--------------------------------------------------


create table admininfo
(
	aid number,
	aname varchar2(50) not null unique,
	apwd varchar2(20) not null,
	alevel varchar2(20) default '普通',
	constraint PK_admininfo primary key(aid)
);
create sequence sq_admininfo start with 1 increment by 1 maxvalue 1E30 nocycle nocache;
create trigger tr_admininfo
  before insert on admininfo for each row
  begin
    select sq_admininfo.nextval
    into :new.aid
    from dual;
  end;
/














