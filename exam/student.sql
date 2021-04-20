/*
Navicat MySQL Data Transfer

Source Server         : txt
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring_exam

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-04-20 20:28:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `clazz` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
