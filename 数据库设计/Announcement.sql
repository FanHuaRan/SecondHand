/*
Navicat MySQL Data Transfer

Source Server         : centosserver
Source Server Version : 50173
Source Host           : 101.200.55.205:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-13 11:47:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Announcement
-- ----------------------------
DROP TABLE IF EXISTS `Announcement`;
CREATE TABLE `Announcement` (
  `AnnouncementId` int(11) NOT NULL AUTO_INCREMENT,
  `AnnoContent` varchar(200) NOT NULL,
  `AnnoTime` datetime NOT NULL,
  `AnnounceTitle` varchar(25) NOT NULL,
  PRIMARY KEY (`AnnouncementId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Announcement
-- ----------------------------
INSERT INTO `Announcement` VALUES ('1', '我的教科书的结果来看时间管理快速搭建管理开发的就算了感觉发呆了', '0000-00-00 00:00:00', '关于1的公告');
INSERT INTO `Announcement` VALUES ('2', '砂锅捣蒜广东省广东分公司丰富的说法', '0000-00-00 00:00:00', '关于2的公告');
