drop table AdminInfo;
drop table ProviderBackDetail;
drop table ProviderBack;
drop table ConsumerBackDetail;
drop table ConsumerBack;
drop table SellDetail;
drop table SellInfo;
drop table StockDetail;
drop table StockInfo;
drop table GoodsInfo;
drop table GoodsClassInfo;
drop table ProviderInfo;
drop table ConsumerInfo;

create table ConsumerInfo
(
	Cid varchar(20) primary key,
	Cname varchar(50) not null,
	Clinkman varchar(50) not null,
	Caddress varchar(50) not null,
	Ctel varchar(20) not null,
	Cemail varchar(50) default '暂无',
	Cremark varchar(100) default '暂无'
)engine innodb;


insert into consumerinfo values('10001','奇川贸易','张先生','唐山','1234567','ligong@sina.com','暂无');
insert into consumerinfo values('10002','唐山物流','王先生','保定','2134567','hebei@sina.com','暂无');
insert into consumerinfo values('10003','理工货运','张先生','唐山','1234567','heut@sina.com','暂无户');
insert into consumerinfo values('10004','唐山科技','张先生','唐山','1234567','heut@sina.com','暂无');
insert into consumerinfo values('10005','河北贸易','张先生','唐山','1234567','heut@sina.com','暂无');






create table ProviderInfo
(
	Pid varchar(20) primary key,
	Pname varchar(50) not null,
	Plinkman varchar(50) not null,
	Paddress varchar(50) not null,
	Ptel varchar(20) not null,
	Pemail varchar(50),
	Premark varchar(100)
)engine innodb;


insert into ProviderInfo values('10001','河北数码','张先生','唐山','1234567','ligong@sina.com','暂无');
insert into ProviderInfo values('10002','唐山数码','王先生','保定','2134567','hebei@sina.com','暂无');
insert into ProviderInfo values('10003','北京数码','张先生','唐山','1234567','heut@sina.com','暂无');
insert into ProviderInfo values('10004','唐山电脑城','张先生','唐山','1234567','heut@sina.com','暂无');
insert into ProviderInfo values('10005','河北电脑城','张先生','唐山','1234567','heut@sina.com','暂无');




create table GoodsClassInfo
(
	GCid varchar(20) primary key,
	GCname varchar(50) not null
)engine innodb;

insert into GoodsClassInfo values('10001','水果');
insert into GoodsClassInfo values('10002','电脑');
insert into GoodsClassInfo values('10003','手机');
insert into GoodsClassInfo values('10004','电视');
create table GoodsInfo
(
	Gid varchar(20) primary key,
	Gname varchar(50) not null,
	GCid varchar(20),
	Gamount int not null,
	Gunit varchar(10) not null,
	Gpin double not null,
	Gpout double not null,
	Foreign key(GCid) references GoodsClassInfo(GCid) on delete cascade
)engine innodb;

insert into GoodsInfo values('10001','苹果','10001',20,'斤',10,20);
insert into GoodsInfo values('10002','梨','10001',20,'斤',10,20);
insert into GoodsInfo values('10003','桃子','10001',20,'斤',10,20);
insert into GoodsInfo values('10004','桔子','10001',20,'斤',10,20);
insert into GoodsInfo values('10005','香焦','10001',20,'斤',10,20);
insert into GoodsInfo values('10006','联想笔记本5000','10002',20,'台',10,20);
insert into GoodsInfo values('10007','苹果笔记本4100','10002',20,'台',10,20);
insert into GoodsInfo values('10008','惠普笔记本3240','10002',20,'台',10,20);
insert into GoodsInfo values('10009','夏新手机M630','10003',20,'台',10,20);
insert into GoodsInfo values('10010','诺基亚5200','10003',20,'台',10,20);
insert into GoodsInfo values('10011','索爱1100','10003',20,'台',10,20);
insert into GoodsInfo values('10012','联想电视机','10004',20,'台',10,20);
insert into GoodsInfo values('10013','TCL电视机','10004',20,'台',10,20);

create table StockInfo
(
	Sid varchar(20) primary key,
	Pid varchar(20),
	Sdate Date,
	Sbuyer varchar(50),
	Stotalprice double not null,
	Foreign key(Pid) references ProviderInfo(Pid) on delete cascade
)engine innodb;



create table StockDetail
(
	SDid varchar(20) primary key,
	Sid varchar(20),
	Gid varchar(20),
	SDamount int not null,
	SDprice double,
	SDtotalprice double,
	Foreign key(Sid) references StockInfo(Sid) on delete cascade,
	Foreign key(Gid) references GoodsInfo(Gid) on delete cascade
)engine innodb;

create table SellInfo
(
	Eid varchar(20) primary key,
	Cid varchar(20),
	Edate Date,
	Eseller varchar(50),
	Etotalprice double not null,
	Foreign key(Cid) references ConsumerInfo(Cid) on delete cascade
)engine innodb;

create table SellDetail
(
	EDid varchar(20) primary key,
	Eid varchar(20),
	Gid varchar(20),
	EDamount int not null,
	EDprice double,
	EDtotalprice double,
	Foreign key(Eid) references SellInfo(Eid) on delete cascade,
	Foreign key(Gid) references GoodsInfo(Gid) on delete cascade
)engine innodb;



create table ConsumerBack
(
	CBid varchar(20) primary key,
	Cid varchar(20),
	Eid varchar(20),
	CBdate date,
	Foreign key(Cid) references ConsumerInfo(Cid) on delete cascade,
	Foreign key(Eid) references SellInfo(Eid) on delete cascade
)engine innodb;




create table ConsumerBackDetail
(
	CBDid varchar(20) primary key,
	CBid varchar(20),
	Gid varchar(20),
	CBDamount int not null,
	CBDprice double,
	CBDtotalprice double,
	Foreign key(CBid) references ConsumerBack(CBid) on delete cascade,
	Foreign key(Gid) references GoodsInfo(Gid) on delete cascade	
)engine innodb;

create table ProviderBack
(
	PBid varchar(20) primary key,
	Pid varchar(20),
	Sid varchar(20),
	PBdate date,
	Foreign key(Pid) references ProviderInfo(Pid) on delete cascade,
	Foreign key(Sid) references StockInfo(Sid) on delete cascade
)engine innodb;


create table ProviderBackDetail
(
	PBDid varchar(20),
	PBid varchar(20),
	Gid varchar(20),
	PBDamount int not null,
	PBDprice double,
	PBDtotalprice double,
	Foreign key(PBid) references ProviderBack(PBid) on delete cascade,
	Foreign key(Gid) references GoodsInfo(Gid) on delete cascade		
)engine innodb;

create table AdminInfo
(
	Aid varchar(20) primary key,
	Aname varchar(50) not null,
	Apwd varchar(20) not null,
	Alevel varchar(20) default '普通'
);



insert into AdminInfo values('10001','zrk','12345','超级');
insert into AdminInfo values('10002','cgq','12345','普通');
insert into AdminInfo values('10003','hxl','12345','普通');
