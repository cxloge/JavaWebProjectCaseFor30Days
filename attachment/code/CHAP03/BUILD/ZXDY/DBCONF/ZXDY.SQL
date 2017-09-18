-- MySQL dump 10.11
--
-- Host: localhost    Database: zxdy
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dy_apply`
--

DROP TABLE IF EXISTS `dy_apply`;
CREATE TABLE `dy_apply` (
  `AID` int(11) NOT NULL auto_increment,
  `UID` int(11) default NULL,
  `TGID` int(11) default NULL,
  `AReason` varchar(200) NOT NULL,
  `AFlag` int(11) default '0',
  `AStatus` char(10) default '申请中',
  PRIMARY KEY  (`AID`),
  KEY `UID` (`UID`),
  KEY `TGID` (`TGID`),
  CONSTRAINT `dy_apply_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `dy_user` (`UID`) ON DELETE CASCADE,
  CONSTRAINT `dy_apply_ibfk_2` FOREIGN KEY (`TGID`) REFERENCES `dy_topic_group` (`TGID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_apply`
--

LOCK TABLES `dy_apply` WRITE;
/*!40000 ALTER TABLE `dy_apply` DISABLE KEYS */;
INSERT INTO `dy_apply` VALUES (2,1,10002,'范德萨发大萨菲',1,'拒绝申请'),(3,1,10004,'范德萨发大',0,'申请中'),(4,1,10000,'fsfaf',1,'拒绝申请'),(5,1,10002,'dsf',1,'拒绝申请'),(7,3,10002,'范德萨发大是',1,'同意申请'),(8,1,10002,'feafdsafdsafdas',1,'同意申请'),(9,1,10000,'fefewfewa',1,'同意申请'),(10,1,10003,'21',0,'申请中'),(11,1,10008,'fdsa',0,'申请中'),(12,1,10006,'想学习',0,'申请中');
/*!40000 ALTER TABLE `dy_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dy_revert`
--

DROP TABLE IF EXISTS `dy_revert`;
CREATE TABLE `dy_revert` (
  `RID` int(11) NOT NULL auto_increment,
  `TID` int(11) default NULL,
  `UID` int(11) default NULL,
  `RTitle` varchar(200) default NULL,
  `RContent` text NOT NULL,
  `RDate` datetime NOT NULL,
  PRIMARY KEY  (`RID`),
  KEY `TID` (`TID`),
  KEY `UID` (`UID`),
  CONSTRAINT `dy_revert_ibfk_1` FOREIGN KEY (`TID`) REFERENCES `dy_topic` (`TID`) ON DELETE CASCADE,
  CONSTRAINT `dy_revert_ibfk_2` FOREIGN KEY (`UID`) REFERENCES `dy_user` (`UID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_revert`
--

LOCK TABLES `dy_revert` WRITE;
/*!40000 ALTER TABLE `dy_revert` DISABLE KEYS */;
INSERT INTO `dy_revert` VALUES (1,2,3,'','看书，上网问问题','2008-12-08 11:08:31'),(2,1,3,'','传说新版本的JAVA 会自动缓存BYTE范围内的值.','2008-12-08 11:08:31'),(3,1,3,'','楼主懂了吗？可以参考Java里的源代码','2008-12-08 11:08:31'),(4,1,3,'','谢谢大家指教','2008-12-08 11:08:31'),(5,3,3,'','认真学习，专心研究的话就好学','2008-12-08 11:08:31'),(6,10,1,'','\r\n测试测试测试测试测试测试测试测试测试10\r\n测试测试测试测试测试测试测试测试测试10\r\n测试测试测试测试测试测试测试测试测试10','2008-12-08 20:13:07'),(7,10,1,'回答 xyz 的问题','\r\n测试测试测试测试测试测试测试测试测试10\r\n测试测试测试测试测试测试测试测试测试10\r\n测试测试测试测试测试测试测试测试测试10','2008-12-08 20:13:15'),(8,1,2,'','都是一个人????','2008-12-10 23:01:33'),(9,6,2,'','新版本会缓存的 呵呵','2008-12-11 23:24:32'),(10,8,1,'','再次测试啊啊啊 啊','2008-12-12 01:16:36'),(11,10,1,'','学生\r\n\r\n注册时间 2008-12-08\r\n\r\n最后登陆 2008-12-12\r\n 2楼  发表于 2008-12-08 20:13:15 回答 xyz 的问题\r\n测试测试测试测试测试测试测试测试测试10 测试测试测试测试测试测试测试测试测试10 测试测试测试测试测试测试测试测试测试10 ','2008-12-12 01:16:56'),(12,4,2,'','回答过的问题嘛算法','2008-12-12 10:58:57'),(13,10,2,'','回答过了，是不是没有了么','2008-12-12 13:08:35'),(14,3,2,'','回答了 谢谢 呵呵。。。','2008-12-12 13:27:24'),(15,15,1,'','bbbbbbbbbbbbbbbbb','2009-03-16 20:45:19'),(16,15,1,'','ccccccccccccccc','2009-03-16 20:59:07'),(17,17,1,'','ssssssssssssssssss','2009-03-16 21:00:10');
/*!40000 ALTER TABLE `dy_revert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dy_topic`
--

DROP TABLE IF EXISTS `dy_topic`;
CREATE TABLE `dy_topic` (
  `TID` int(11) NOT NULL auto_increment,
  `UID` int(11) default NULL,
  `TGID` int(11) default NULL,
  `TTitle` varchar(200) NOT NULL,
  `TContent` text NOT NULL,
  `TDate` datetime NOT NULL,
  `TReadCount` int(11) default '0',
  PRIMARY KEY  (`TID`),
  KEY `UID` (`UID`),
  KEY `TGID` (`TGID`),
  CONSTRAINT `dy_topic_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `dy_user` (`UID`) ON DELETE CASCADE,
  CONSTRAINT `dy_topic_ibfk_2` FOREIGN KEY (`TGID`) REFERENCES `dy_topic_group` (`TGID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_topic`
--

LOCK TABLES `dy_topic` WRITE;
/*!40000 ALTER TABLE `dy_topic` DISABLE KEYS */;
INSERT INTO `dy_topic` VALUES (1,1,10001,'怎样学习框架ssh','学习struts spring hibernate 的顺序是ssh吗  顺便根据我的情况推荐几本书','2008-12-08 11:07:16',31),(2,2,10003,'C++很难吗？应该怎么样学习呢','请给我推荐几本C++的书，给我讲些学习方法谢谢','2008-12-08 11:07:16',19),(3,2,10001,'测试','测试测试测试测试测试测试测试测试测试','2008-12-08 11:07:16',19),(4,1,10001,'JAVA很难吗？应该怎么样学习呢','请给我推荐几本JAVA的书，给我讲些学习方法谢谢','2008-12-08 11:07:16',14),(5,1,10002,'请教一句SQL这么写。。','这个SQL好难啊，应该怎么学呢','2008-12-08 11:07:16',12),(6,1,10001,'Integer类的一个小问题 ==比较','Integer内的值的大小在Byte范围内时，==比较返回true 在那范围之外返回false \n这是为什么呢，为什么会这样》？ ','2008-12-08 11:07:34',32),(7,1,10002,'测试71','测试测试测试测试测试测试测试测试测试7','2008-12-08 11:08:09',13),(8,1,10001,'测试81','测试测试测试测试测试测试测试测试测试8','2008-12-08 11:08:09',21),(9,1,10002,'测试91','测试测试测试测试测试测试测试测试测试9','2008-12-08 11:08:09',16),(10,1,10001,'测试101','测试测试测试测试测试测试测试测试测试10','2008-12-08 11:08:09',29),(11,1,10002,'测试111','测试测试测试测试测试测试测试测试测试11','2008-12-08 11:08:09',12),(12,1,10001,'测试121','测试测试测试测试测试测试测试测试测试12','2008-12-08 11:08:09',13),(13,1,10005,'自动控制的课本是哪个？','自动控制的课本是哪个？自动控制的课本是哪个？自动控制的课本是哪个？','2008-12-12 01:18:07',2),(14,1,10000,'我是第一个来到这里的','第一个提问的哦 呵呵','2008-12-12 14:01:29',1),(15,1,10000,'aaaaaaaaaa','aabbbbbbbbbbbbbbbbbbbb','2009-03-16 20:44:05',6),(16,1,10000,'bbccccccccccccc','aaaaaaaaaaaaaa','2009-03-16 20:58:57',0),(17,1,10000,'11111111111111111','22222222222222222222','2009-03-16 21:00:00',2);
/*!40000 ALTER TABLE `dy_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dy_topic_group`
--

DROP TABLE IF EXISTS `dy_topic_group`;
CREATE TABLE `dy_topic_group` (
  `TGID` int(11) NOT NULL auto_increment,
  `TGName` varchar(50) NOT NULL,
  `TDetail` varchar(200) NOT NULL,
  PRIMARY KEY  (`TGID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_topic_group`
--

LOCK TABLES `dy_topic_group` WRITE;
/*!40000 ALTER TABLE `dy_topic_group` DISABLE KEYS */;
INSERT INTO `dy_topic_group` VALUES (10000,'Java网络编程','计算机与自动控制学院'),(10001,'数据库系统概论','计算机与自动控制学院'),(10002,'C语言程序设计','计算机与自动控制学院'),(10003,'高等数学','理学院'),(10004,'线性代数','理学院'),(10005,'自动控制原理','机械学院'),(10006,'大学英语1','外国语学院'),(10007,'运筹学','经济管理学院'),(10008,'运筹学','经济管理学院'),(10009,'大学物理','基础课程'),(10010,'高等数学','基础课程');
/*!40000 ALTER TABLE `dy_topic_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dy_tu`
--

DROP TABLE IF EXISTS `dy_tu`;
CREATE TABLE `dy_tu` (
  `TUID` int(11) NOT NULL auto_increment,
  `UID` int(11) default NULL,
  `TGID` int(11) default NULL,
  PRIMARY KEY  (`TUID`),
  KEY `UID` (`UID`),
  KEY `TGID` (`TGID`),
  CONSTRAINT `dy_tu_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `dy_user` (`UID`) ON DELETE CASCADE,
  CONSTRAINT `dy_tu_ibfk_2` FOREIGN KEY (`TGID`) REFERENCES `dy_topic_group` (`TGID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_tu`
--

LOCK TABLES `dy_tu` WRITE;
/*!40000 ALTER TABLE `dy_tu` DISABLE KEYS */;
INSERT INTO `dy_tu` VALUES (1,2,10000),(2,2,10001),(3,2,10002),(4,1,10001),(6,1,10005),(10,3,10002),(12,1,10000),(13,1,10002),(14,3,10001),(15,4,10001),(17,7,10001);
/*!40000 ALTER TABLE `dy_tu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dy_user`
--

DROP TABLE IF EXISTS `dy_user`;
CREATE TABLE `dy_user` (
  `UID` int(11) NOT NULL auto_increment,
  `UName` varchar(20) NOT NULL,
  `UPwd` varchar(20) NOT NULL,
  `UGender` char(2) default '男',
  `UEmail` varchar(40) default NULL,
  `URole` int(11) default '0',
  `UHead` varchar(50) default 'UserHead/no_head.jpg',
  `URegDate` date default NULL,
  `ULastLogin` datetime default NULL,
  `ULastEmit` datetime default NULL,
  `UPermit` int(11) default '1',
  PRIMARY KEY  (`UID`),
  UNIQUE KEY `UName` (`UName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dy_user`
--

LOCK TABLES `dy_user` WRITE;
/*!40000 ALTER TABLE `dy_user` DISABLE KEYS */;
INSERT INTO `dy_user` VALUES (1,'xyz','123456','男','fgdsa@163.com',0,'UserHead/1.jpg','2008-12-08','2009-03-16 22:16:20','2009-03-16 21:00:10',1),(2,'zrk','123456','男','sfdsaga@163.com',1,'UserHead/2.JPG','2008-12-08','2009-03-16 23:12:04','2008-12-12 13:27:24',1),(3,'胡再芬','123456','女','wereq@163.com',0,'UserHead/3.jpg','2008-12-08','2008-12-12 09:26:47',NULL,1),(4,'wyf','123456','男','gr4eg@163.com',3,'UserHead/1.jpg','2008-12-08','2009-03-17 15:11:32','2008-12-12 14:01:29',1),(5,'fdsa','123123','男','rfews@3421.com',0,'UserHead/no_head.jpg','2009-03-16','2009-03-16 17:41:24','2009-03-16 17:41:24',1),(7,'wfa','123123','男','fdsa@123.com',0,'UserHead/no_head.jpg','2009-03-16','2009-03-16 17:44:32','2009-03-16 17:44:32',1),(8,'few','123123','男','fdsa@123.com',0,'UserHead/no_head.jpg','2009-03-16','2009-03-16 17:45:11','2009-03-16 17:45:11',1);
/*!40000 ALTER TABLE `dy_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2009-03-17  7:23:17
