/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 12/01/2021 14:05:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_
-- ----------------------------
DROP TABLE IF EXISTS `user_`;
CREATE TABLE `user_` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_wallet` decimal(65,2) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_
-- ----------------------------
BEGIN;
INSERT INTO `user_` VALUES (1, 'dante', '123456789', '123456', 10000.00, '2021-01-05 15:28:04', '2021-01-05 15:28:07');
INSERT INTO `user_` VALUES (2, 'DT', '987654321', '654321', 100.00, '2021-01-05 15:54:52', '2021-01-05 16:05:56');
INSERT INTO `user_` VALUES (3, 'SpringBoot', '111111111', 'maven', 1.00, '2021-01-05 16:06:39', '2021-01-05 16:06:41');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
