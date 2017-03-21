/*
Navicat MySQL Data Transfer

Source Server         : LocalConnect
Source Server Version : 50707
Source Host           : localhost:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50707
File Encoding         : 65001

Date: 2017-03-21 11:25:35
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
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('1', '新版本上线 大家多留意', '2017-03-13 00:00:00', '1号公告');
INSERT INTO `announcement` VALUES ('2', '优惠多多，全场打折，请大家为我们多提意见', '2017-03-10 00:00:00', '2号公告');
INSERT INTO `announcement` VALUES ('3', '全场半价', '2017-03-11 09:01:00', '3号公告');
INSERT INTO `announcement` VALUES ('4', '请大家关注我们的微信', '2017-03-12 00:00:00', '4号公告');
INSERT INTO `announcement` VALUES ('5', 'SAFSAFASFAFSS', '2017-03-20 17:44:16', '测试公告标题');

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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '1', '1');

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
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('101', '101', '1', 'Samsung', '2017-03-19 18:43:18', 'wodei jlgjadhgljhfdjhgjdshgjfdjj', '0', '3000');
INSERT INTO `good` VALUES ('102', '102', '2', '五年高考三年模拟', '2017-03-19 18:43:13', '就会受到客观环境都卡死联合国4', '0', '50');
INSERT INTO `good` VALUES ('110', '106', '10', '眼镜盒', '2017-03-19 18:48:57', '可爱，很喜欢', '0', '20');

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
) ENGINE=MyISAM AUTO_INCREMENT=10203 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodcollect
-- ----------------------------

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
) ENGINE=MyISAM AUTO_INCREMENT=102002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodcomment
-- ----------------------------

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
) ENGINE=MyISAM AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shuser
-- ----------------------------
INSERT INTO `shuser` VALUES ('101', '张三', '123', '0', 'hello', '13788888888', '北苑1栋');
INSERT INTO `shuser` VALUES ('102', '李四', '123456', '0', '你才我是谁', '13948526412', '北苑2栋');
INSERT INTO `shuser` VALUES ('103', 'Elle', '111', '0', '我就是我，不一样的烟火。', '13742516324', '饭堂');
INSERT INTO `shuser` VALUES ('104', 'Abigail', '222', '0', '我是个知性的女子。', '13945218963', '图书馆');
INSERT INTO `shuser` VALUES ('105', 'Emma', '333', '0', '我是个美丽的女人。', '18842563214', '教学楼');
INSERT INTO `shuser` VALUES ('106', '许飞', '444', '0', '我是一个男人。', '13645214789', '实验楼');
INSERT INTO `shuser` VALUES ('107', '刘备', '555', '0', '我是一个奇男子。', '15642154212', '北苑11栋');
INSERT INTO `shuser` VALUES ('108', '关羽', '666', '0', '我是一个男生。', '18814545874', '北苑3栋');
INSERT INTO `shuser` VALUES ('1', 'Admin', '123', '0', '管理员', '15454874545', '北苑');
INSERT INTO `shuser` VALUES ('111', '4554878', '123', '1', '3444365', '454', '12');
INSERT INTO `shuser` VALUES ('112', '测试用户22', '12345678', '1', '  试试saf       asf               	', '124545454455', 'asfasfdsafds');
INSERT INTO `shuser` VALUES ('113', '测试用户333', '12345678', '1', '                     afsasf', '14547714454', 'asfsa');
