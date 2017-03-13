/*
Navicat MySQL Data Transfer

Source Server         : centosserver
Source Server Version : 50173
Source Host           : 101.200.55.205:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-13 10:34:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ShUser
-- ----------------------------
DROP TABLE IF EXISTS `ShUser`;
CREATE TABLE `ShUser` (
  `ShUserId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` smallint(6) NOT NULL,
  `Introduce` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` varchar(30) NOT NULL,
  PRIMARY KEY (`ShUserId`)
) ENGINE=MyISAM AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ShUser
-- ----------------------------
INSERT INTO `ShUser` VALUES ('101', '张三', '123', '0', 'hello', '13788888888', '北苑1栋');
INSERT INTO `ShUser` VALUES ('102', '李四', '123456', '0', '你才我是谁', '13948526412', '北苑2栋');
INSERT INTO `ShUser` VALUES ('103', 'Elle', '111', '0', '我就是我，不一样的烟火。', '13742516324', '饭堂');
INSERT INTO `ShUser` VALUES ('104', 'Abigail', '222', '0', '我是个知性的女子。', '13945218963', '图书馆');
INSERT INTO `ShUser` VALUES ('105', 'Emma', '333', '0', '我是个美丽的女人。', '18842563214', '教学楼');
INSERT INTO `ShUser` VALUES ('106', '许飞', '444', '0', '我是一个男人。', '13645214789', '实验楼');
INSERT INTO `ShUser` VALUES ('107', '刘备', '555', '0', '我是一个奇男子。', '15642154212', '北苑11栋');
INSERT INTO `ShUser` VALUES ('108', '关羽', '666', '0', '我是一个男生。', '18814545874', '北苑3栋');
INSERT INTO `ShUser` VALUES ('1', 'Admin', '123', '0', '管理员', '15454874545', '北苑');
