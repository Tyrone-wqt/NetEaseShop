/*
Navicat MySQL Data Transfer

Source Server         : mysql_test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : neteasejob

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-03-13 18:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `orderDate` datetime NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('9', '17', '1', '3', '2018-03-13 18:13:17', '15.00');
INSERT INTO `orders` VALUES ('10', '18', '1', '1', '2018-03-13 18:14:56', '323.00');
