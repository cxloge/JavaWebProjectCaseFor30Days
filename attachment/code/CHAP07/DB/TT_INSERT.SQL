------------------------------insert  userinfo start--------------------------------

insert into userinfo(uname,upwd) values('zrk','860607');
insert into userinfo(uname,upwd) values('wyf','123456');

------------------------------insert  userinfo end--------------------------------

------------------------------insert  typeinfo start--------------------------------

insert into typeinfo(tname) values('动车组');
insert into typeinfo(tname) values('空调快速');
insert into typeinfo(tname) values('空调普快');
insert into typeinfo(tname) values('空调特快');
insert into typeinfo(tname) values('普快');

------------------------------insert  typeinfo end--------------------------------


------------------------------insert  stationinfo start--------------------------------

insert into stationinfo(sname) values('北京');
insert into stationinfo(sname) values('天津');
insert into stationinfo(sname) values('唐山');
insert into stationinfo(sname) values('廊坊');
insert into stationinfo(sname) values('塘沽');
insert into stationinfo(sname) values('滦县');
insert into stationinfo(sname) values('昌黎');
insert into stationinfo(sname) values('北戴河');
insert into stationinfo(sname) values('石家庄');
insert into stationinfo(sname) values('山海关');
insert into stationinfo(sname) values('锦州');
insert into stationinfo(sname) values('沈阳');
insert into stationinfo(sname) values('四平');
insert into stationinfo(sname) values('长春');
insert into stationinfo(sname) values('哈尔滨');
insert into stationinfo(sname) values('肇东');
insert into stationinfo(sname) values('安达');
insert into stationinfo(sname) values('大庆');
insert into stationinfo(sname) values('泰康');
insert into stationinfo(sname) values('齐齐哈尔');

insert into stationinfo(sname) values('本溪');
insert into stationinfo(sname) values('凤凰城');
insert into stationinfo(sname) values('丹东');

insert into stationinfo(sname) values('北京西');
insert into stationinfo(sname) values('保定');

insert into stationinfo(sname) values('定州');
insert into stationinfo(sname) values('高碑店');
insert into stationinfo(sname) values('杨村');
insert into stationinfo(sname) values('天津北');
insert into stationinfo(sname) values('秦皇岛');


------------------------------insert  stationinfo end--------------------------------

------------------------------insert  traininfo start--------------------------------

insert into traininfo(tname,tstartid,tendid,ttypeid) values
(
	'K39',
	(select sid from stationinfo where sname='北京'),
	(select sid from stationinfo where sname='齐齐哈尔'),
	(select tid from typeinfo where tname='空调快速')
);
insert into traininfo(tname,tstartid,tendid,ttypeid) values
(
	'4424',
	(select sid from stationinfo where sname='石家庄'),
	(select sid from stationinfo where sname='唐山'),
	(select tid from typeinfo where tname='普快')
);

insert into traininfo(tname,tstartid,tendid,ttypeid) values
(
	'K27',
	(select sid from stationinfo where sname='北京'),
	(select sid from stationinfo where sname='丹东'),
	(select tid from typeinfo where tname='空调快速')
);

insert into traininfo(tname,tstartid,tendid,ttypeid) values
(
	'D574',
	(select sid from stationinfo where sname='石家庄'),
	(select sid from stationinfo where sname='北京西'),
	(select tid from typeinfo where tname='动车组')
);

insert into traininfo(tname,tstartid,tendid,ttypeid) values
(
	'T582',
	(select sid from stationinfo where sname='石家庄'),
	(select sid from stationinfo where sname='秦皇岛'),
	(select tid from typeinfo where tname='空调特快')
);


------------------------------insert  traininfo end--------------------------------

insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='北京'),
	null,
	to_date('22:56','hh24:mi'),
	1
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='天津'),
	to_date('0:29','hh24:mi'),
	to_date('0:37','hh24:mi'),
	2
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='唐山'),
	to_date('01:48','hh24:mi'),
	to_date('01:50','hh24:mi'),
	3
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='山海关'),
	to_date('03:48','hh24:mi'),
	to_date('03:56','hh24:mi'),
	4
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='锦州'),
	to_date('05:54','hh24:mi'),
	to_date('05:59','hh24:mi'),
	5
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='沈阳'),
	to_date('08:35','hh24:mi'),
	to_date('08:50','hh24:mi'),
	6
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='四平'),
	to_date('10:47','hh24:mi'),
	to_date('10:49','hh24:mi'),
	7
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='长春'),
	to_date('12:03','hh24:mi'),
	to_date('12:10','hh24:mi'),
	8
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='哈尔滨'),
	to_date('14:45','hh24:mi'),
	to_date('15:05','hh24:mi'),
	9
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='肇东'),
	to_date('15:47','hh24:mi'),
	to_date('15:49','hh24:mi'),
	10
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='安达'),
	to_date('16:33','hh24:mi'),
	to_date('16:35','hh24:mi'),
	11
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='大庆'),
	to_date('16:58','hh24:mi'),
	to_date('17:03','hh24:mi'),
	12
);

insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='泰康'),
	to_date('17:37','hh24:mi'),
	to_date('17:41','hh24:mi'),
	13
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K39'),
	(select sid from stationinfo where sname='齐齐哈尔'),
	to_date('18:33','hh24:mi'),
	null,
	14
);

insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='北京'),
	null,
	to_date('17:30','hh24:mi'),
	1
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='天津'),
	to_date('19:03','hh24:mi'),
	to_date('19:11','hh24:mi'),
	2
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='唐山'),
	to_date('20:22','hh24:mi'),
	to_date('20:25','hh24:mi'),
	3
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='北戴河'),
	to_date('21:50','hh24:mi'),
	to_date('21:52','hh24:mi'),
	4
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='山海关'),
	to_date('22:29','hh24:mi'),
	to_date('22:40','hh24:mi'),
	5
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='锦州'),
	to_date('00:38','hh24:mi'),
	to_date('00:51','hh24:mi'),
	6
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='沈阳'),
	to_date('03:25','hh24:mi'),
	to_date('03:40','hh24:mi'),
	7
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='本溪'),
	to_date('04:46','hh24:mi'),
	to_date('04:49','hh24:mi'),
	8
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='凤凰城'),
	to_date('06:28','hh24:mi'),
	to_date('06:30','hh24:mi'),
	9
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='K27'),
	(select sid from stationinfo where sname='丹东'),
	to_date('07:17','hh24:mi'),
	null,
	10
);

insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='D574'),
	(select sid from stationinfo where sname='石家庄'),
	null,
	to_date('06:35','hh24:mi'),
	1
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='D574'),
	(select sid from stationinfo where sname='保定'),
	to_date('07:27','hh24:mi'),
	to_date('07:28','hh24:mi'),
	2
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='D574'),
	(select sid from stationinfo where sname='北京西'),
	to_date('08:33','hh24:mi'),
	null,
	3
);


insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='石家庄'),
	null,
	to_date('07:33','hh24:mi'),
	1
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='定州'),
	to_date('08:11','hh24:mi'),
	to_date('08:15','hh24:mi'),
	2
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='保定'),
	to_date('08:47','hh24:mi'),
	to_date('08:51','hh24:mi'),
	3
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='高碑店'),
	to_date('09:22','hh24:mi'),
	to_date('09:24','hh24:mi'),
	4
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='北京西'),
	to_date('10:22','hh24:mi'),
	to_date('10:35','hh24:mi'),
	5
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='廊坊'),
	to_date('11:12','hh24:mi'),
	to_date('11:27','hh24:mi'),
	6
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='杨村'),
	to_date('11:46','hh24:mi'),
	to_date('12:11','hh24:mi'),
	7
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='天津北'),
	to_date('12:34','hh24:mi'),
	to_date('12:40','hh24:mi'),
	8
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='塘沽'),
	to_date('13:07','hh24:mi'),
	to_date('13:09','hh24:mi'),
	9
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='唐山'),
	to_date('13:56','hh24:mi'),
	to_date('14:05','hh24:mi'),
	10
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='昌黎'),
	to_date('15:03','hh24:mi'),
	to_date('15:05','hh24:mi'),
	11
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='北戴河'),
	to_date('15:22','hh24:mi'),
	to_date('15:24','hh24:mi'),
	12
);
insert into relationinfo(tid,sid,rarrive,rstart,rsequence) values
(
	(select tid from traininfo where tname='T582'),
	(select sid from stationinfo where sname='秦皇岛'),
	to_date('15:42','hh24:mi'),
	null,
	13
);
------------------------------------------------------
insert into admininfo(aname,apwd,alevel) values('zrk','860607','超级');
insert into admininfo(aname,apwd) values('Tom','123456');















