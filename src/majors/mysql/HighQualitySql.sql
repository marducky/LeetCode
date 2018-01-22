/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : refined_blood_hall

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-22 16:24:33
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for highqualitysql
-- ----------------------------
DROP TABLE IF EXISTS `highqualitysql`;
CREATE TABLE `highqualitysql` (
  `id`      VARCHAR(20)
            COLLATE utf8_unicode_ci NOT NULL,
  `name`    VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex`     VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `slary`   VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `school`  VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `isMar`   VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  `like`    VARCHAR(255)
            COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- ----------------------------
-- Records of highqualitysql
-- ----------------------------
