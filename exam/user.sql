/*
Navicat MySQL Data Transfer

Source Server         : txt
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring_exam

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-04-20 20:28:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `roldId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
