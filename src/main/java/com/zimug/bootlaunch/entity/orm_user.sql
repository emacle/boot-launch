/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-04-08 15:27:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orm_user
-- ----------------------------
DROP TABLE IF EXISTS `orm_user`;
CREATE TABLE `orm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orm_user
-- ----------------------------
INSERT INTO `orm_user` VALUES ('3', 'hello', 'bbbbbbbbbbbbb', null, null, null, null, null, null, null);
INSERT INTO `orm_user` VALUES ('4', 'wrold', 'aaaaa', null, null, null, null, null, null, null);
INSERT INTO `orm_user` VALUES ('5', 'pocoyo', 'bbbbbbbbbbbbb', null, null, null, null, null, null, null);
INSERT INTO `orm_user` VALUES ('6', 'pocoyo', 'bbbbbbbbbbbbb', null, null, null, null, null, null, null);
INSERT INTO `orm_user` VALUES ('7', 'hello', 'bbbbbbbbbbbbb', null, null, null, null, null, null, null);
