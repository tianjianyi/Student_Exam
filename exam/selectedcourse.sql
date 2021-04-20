/*
Navicat MySQL Data Transfer

Source Server         : txt
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring_exam

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-04-20 20:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for selectedcourse
-- ----------------------------
DROP TABLE IF EXISTS `selectedcourse`;
CREATE TABLE `selectedcourse` (
  `studentId` varchar(30) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
