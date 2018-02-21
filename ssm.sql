/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-02-21 13:25:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', 'qqq', '16');
INSERT INTO `user` VALUES ('111111', 'ww', '17');
INSERT INTO `user` VALUES ('1111', '李四', '21');
INSERT INTO `user` VALUES ('123', 'aa', '22');
INSERT INTO `user` VALUES ('123', 'pan', '23');
INSERT INTO `user` VALUES ('123', 'zz', '24');
INSERT INTO `user` VALUES ('123456', 'sss', '25');
INSERT INTO `user` VALUES ('123', 'jing', '26');
INSERT INTO `user` VALUES ('12321', '静静', '28');
INSERT INTO `user` VALUES ('123', 'ddd', '29');
INSERT INTO `user` VALUES ('123', 'www', '30');
INSERT INTO `user` VALUES ('123456', 'ttt', '31');
INSERT INTO `user` VALUES ('123', 'panpan', '32');
INSERT INTO `user` VALUES ('111111', 'rr', '34');
INSERT INTO `user` VALUES ('123', '王五', '35');
