/*
Navicat MySQL Data Transfer

Source Server         : mysql_test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : neteasejob

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-03-13 18:46:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cTitle` varchar(80) NOT NULL,
  `cAbstract` varchar(140) NOT NULL,
  `cText` varchar(1000) NOT NULL,
  `cPrice` decimal(10,2) NOT NULL,
  `cImgUrl` varchar(255) CHARACTER SET latin1 NOT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('17', '测试1 编辑1', '测试1 编辑1', '测试1 编辑1', '15.00', 'https://www.baidu.com/img/bd_logo1.png', '2');
INSERT INTO `content` VALUES ('18', '测试2', '测试2', '测试2 第一次编辑', '323.00', 'img/6456663a-a294-4958-9219-98c3a06b6ce2.jpg', '2');
INSERT INTO `content` VALUES ('20', '测试4', '测试4', '测试4', '12.00', 'img/12b912c3-cd69-4632-98b9-efd59b582041.jpg', '2');
