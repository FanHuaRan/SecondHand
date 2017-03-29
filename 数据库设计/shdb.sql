/*
Navicat MySQL Data Transfer

Source Server         : LocalConnect
Source Server Version : 50707
Source Host           : localhost:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50707
File Encoding         : 65001

Date: 2017-03-29 22:58:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `AnnouncementId` int(11) NOT NULL AUTO_INCREMENT,
  `AnnoContent` varchar(200) NOT NULL,
  `AnnoTime` datetime NOT NULL,
  `AnnounceTitle` varchar(25) NOT NULL,
  PRIMARY KEY (`AnnouncementId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('6', '这是一条测试公告，查过20个字符，嘿嘿，可以的    	ds', '2017-03-29 16:39:03', '2017/03/29公告');
INSERT INTO `announcement` VALUES ('2', '优惠多多，全场打折，请大家为我们多提意见', '2017-03-10 00:00:00', '2号公告');
INSERT INTO `announcement` VALUES ('3', '全场半价', '2017-03-11 09:01:00', '3号公告');
INSERT INTO `announcement` VALUES ('4', '请大家关注我们的微信', '2017-03-12 00:00:00', '4号公告');
INSERT INTO `announcement` VALUES ('5', 'SAFSAFASFAFSS', '2017-03-20 17:44:16', '测试公告标题');
INSERT INTO `announcement` VALUES ('7', 'asfaf14454545545545454541asasdadadadsadadadsasdadasdas', '2017-03-29 16:43:42', '啥时发放2');

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `AuthorityId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserId` int(11) NOT NULL,
  `ShRoleId` smallint(6) NOT NULL,
  PRIMARY KEY (`AuthorityId`),
  KEY `FK_Reference_1` (`ShUserId`),
  KEY `FK_Reference_2` (`ShRoleId`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '1', '1');
INSERT INTO `authority` VALUES ('3', '114', '2');
INSERT INTO `authority` VALUES ('4', '115', '2');
INSERT INTO `authority` VALUES ('5', '116', '2');
INSERT INTO `authority` VALUES ('6', '117', '2');
INSERT INTO `authority` VALUES ('7', '118', '2');
INSERT INTO `authority` VALUES ('8', '111', '2');
INSERT INTO `authority` VALUES ('9', '112', '2');
INSERT INTO `authority` VALUES ('10', '113', '2');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `GoodId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserId` int(11) NOT NULL,
  `GoodTypeId` int(11) NOT NULL,
  `GoodName` varchar(10) NOT NULL,
  `DesTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Description` varchar(50) NOT NULL,
  `IsSell` tinyint(4) NOT NULL,
  `GoodPrice` float NOT NULL,
  PRIMARY KEY (`GoodId`),
  KEY `FK_Reference_5` (`ShUserId`),
  KEY `FK_Reference_6` (`GoodTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('101', '1', '1', 'Samsung', '2017-03-29 20:57:54', '这是我的三星手机', '1', '3000');
INSERT INTO `good` VALUES ('102', '1', '2', '五年高考三年模拟', '2017-03-29 20:57:54', '就会受到客观环境都卡死联合国4', '0', '50');
INSERT INTO `good` VALUES ('110', '118', '10', '眼镜盒', '2017-03-29 20:59:48', '可爱，很喜欢', '0', '20');
INSERT INTO `good` VALUES ('113', '1', '1', '测试商品2', '2017-03-21 18:24:03', '沙发沙发斯蒂芬第三个', '1', '9.88');

-- ----------------------------
-- Table structure for goodcollect
-- ----------------------------
DROP TABLE IF EXISTS `goodcollect`;
CREATE TABLE `goodcollect` (
  `GoodCollectId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserId` int(11) NOT NULL,
  `GoodId` int(11) NOT NULL,
  PRIMARY KEY (`GoodCollectId`),
  KEY `FK_Reference_3` (`ShUserId`),
  KEY `FK_Reference_4` (`GoodId`)
) ENGINE=MyISAM AUTO_INCREMENT=10214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodcollect
-- ----------------------------
INSERT INTO `goodcollect` VALUES ('10213', '1', '101');
INSERT INTO `goodcollect` VALUES ('10212', '1', '113');

-- ----------------------------
-- Table structure for goodcomment
-- ----------------------------
DROP TABLE IF EXISTS `goodcomment`;
CREATE TABLE `goodcomment` (
  `GoodCommentId` int(11) NOT NULL AUTO_INCREMENT,
  `GoodId` int(11) NOT NULL,
  `ShUserId` int(11) NOT NULL,
  `ComTime` datetime NOT NULL,
  `ComContent` varchar(50) NOT NULL,
  PRIMARY KEY (`GoodCommentId`),
  KEY `FK_Reference_7` (`GoodId`),
  KEY `FK_Reference_8` (`ShUserId`)
) ENGINE=MyISAM AUTO_INCREMENT=102015 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodcomment
-- ----------------------------
INSERT INTO `goodcomment` VALUES ('102002', '101', '1', '2017-03-28 13:07:35', '测试留言哦哦');
INSERT INTO `goodcomment` VALUES ('102003', '101', '1', '2017-03-28 13:15:01', '暗示法撒发放');
INSERT INTO `goodcomment` VALUES ('102004', '101', '1', '2017-03-28 13:16:24', '测试公告3');
INSERT INTO `goodcomment` VALUES ('102005', '101', '1', '2017-03-28 13:18:24', '测试留言444');
INSERT INTO `goodcomment` VALUES ('102006', '101', '1', '2017-03-28 13:20:45', '测试留言5555');
INSERT INTO `goodcomment` VALUES ('102007', '101', '1', '2017-03-28 13:21:41', '测试留言666');
INSERT INTO `goodcomment` VALUES ('102008', '101', '1', '2017-03-28 13:22:19', '测试留言6666');
INSERT INTO `goodcomment` VALUES ('102009', '101', '1', '2017-03-28 17:19:05', '留言咯');
INSERT INTO `goodcomment` VALUES ('102010', '113', '1', '2017-03-29 21:07:32', '这个商品真好啊');
INSERT INTO `goodcomment` VALUES ('102011', '113', '1', '2017-03-29 21:22:42', '杀神风');
INSERT INTO `goodcomment` VALUES ('102012', '113', '1', '2017-03-29 21:24:31', '我是一个测试评价哈');
INSERT INTO `goodcomment` VALUES ('102013', '113', '1', '2017-03-29 21:26:05', '楼上真有道理');
INSERT INTO `goodcomment` VALUES ('102014', '113', '1', '2017-03-29 21:26:42', '我服');

-- ----------------------------
-- Table structure for goodtype
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype` (
  `GoodTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `GoodTypeName` varchar(20) NOT NULL,
  PRIMARY KEY (`GoodTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES ('1', '数码产品');
INSERT INTO `goodtype` VALUES ('2', '书籍');
INSERT INTO `goodtype` VALUES ('3', '护肤');
INSERT INTO `goodtype` VALUES ('4', '美妆');
INSERT INTO `goodtype` VALUES ('5', '衣物');
INSERT INTO `goodtype` VALUES ('6', '自行车');
INSERT INTO `goodtype` VALUES ('7', '运动户外');
INSERT INTO `goodtype` VALUES ('8', '宠物');
INSERT INTO `goodtype` VALUES ('9', '首饰');
INSERT INTO `goodtype` VALUES ('10', '杂物');

-- ----------------------------
-- Table structure for shrole
-- ----------------------------
DROP TABLE IF EXISTS `shrole`;
CREATE TABLE `shrole` (
  `ShRoleId` smallint(6) NOT NULL AUTO_INCREMENT,
  `ShRoleName` varchar(10) NOT NULL,
  PRIMARY KEY (`ShRoleId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shrole
-- ----------------------------
INSERT INTO `shrole` VALUES ('1', 'Admin');
INSERT INTO `shrole` VALUES ('2', 'User');

-- ----------------------------
-- Table structure for shuser
-- ----------------------------
DROP TABLE IF EXISTS `shuser`;
CREATE TABLE `shuser` (
  `ShUserId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` smallint(6) NOT NULL,
  `Introduce` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` varchar(30) NOT NULL,
  PRIMARY KEY (`ShUserId`)
) ENGINE=MyISAM AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shuser
-- ----------------------------
INSERT INTO `shuser` VALUES ('1', 'Admin', '12345678', '0', '我是管理员 哈哈哈 啊哈哈哈 啊哈哈哈', '1545487454522', '北苑');
INSERT INTO `shuser` VALUES ('111', '4554878', '123', '1', '我是一个测试用户，这是我的个人宣言！！1', '454', '12');
INSERT INTO `shuser` VALUES ('112', '测试用户22', '12345678', '1', '我是一个测试用户，这是我的个人宣言！！1', '124545454455', 'asfasfdsafds');
INSERT INTO `shuser` VALUES ('113', '测试用户333', '12345678', '1', '我是一个测试用户，这是我的个人宣言！！1', '14547714454', 'asfsa');
INSERT INTO `shuser` VALUES ('114', '测试用户3333', '12345678', '0', '我是一个测试用户，这是我的个人宣言！！1', '1548787844', 'sfaffa');
INSERT INTO `shuser` VALUES ('115', '测试用户4444', '12345678', '0', '我是一个测试用户，这是我的个人宣言！！1', 'asfasf', 'asf');
INSERT INTO `shuser` VALUES ('116', '测试用户33332', '12345678', '0', '我是一个测试用户，这是我的个人宣言！！1', '1548787844', 'sfaffa');
INSERT INTO `shuser` VALUES ('117', '测试用户3333', '12345678', '0', '我是一个测试用户，这是我的个人宣言！！1', '1548787844', 'sfaffa');
INSERT INTO `shuser` VALUES ('118', '测试用户0329', '12345678', '0', '我是一个测试用户，这是我的个人宣言！！1', '1215454545', '成都是');
