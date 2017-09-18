drop table goodsmessage;
drop table mmanager;
drop table gcustomer;
drop table cart;
drop table ordergoodsmeg;
drop table ordermeg;
create table goodsmessage
(
goodsid int auto_increment,
goodsname varchar(50) not null,
gtype varchar(50) not null,
gprice double not null, 
gdate date not null,
gamount int not null,
gimgurl varchar(100) default 'img/wel.gif',
gintroduction text not null,
constraint pk primary key(goodsid) 
);

create table mmanager
(
mname varchar(50) primary key,
mpw varchar(50) not null,
mpermitted varchar(50) not null
);
insert into mmanager values('hxl','123456','³¬¼¶');
create table gcustomer
(
cname varchar(50) primary key,
cpw varchar(50) not null,
cemail varchar(50)
);
insert into gcustomer values('hxl','123456','huxinlang@163.com');

create table ordergoodsmeg
(
oid int not null, 
goodsid int not null,
goodsname varchar(50) not null,
gprice double not null, 
orderamount int not null,
buytime datetime not null
);
create table ordermeg
(
oid int primary key,
cname varchar(50) not null,
receivename varchar(50) not null,
receiveadds varchar(50) not null,
receivetel varchar(50) not null,
allmoney double not null,
zhuangtai varchar(50) default 'Î´·¢ËÍ',
buytime datetime not null
);



