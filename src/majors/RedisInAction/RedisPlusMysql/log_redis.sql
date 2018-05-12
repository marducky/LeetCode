/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : janus_qmz

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-09 17:46:37
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_redis
-- ----------------------------
DROP TABLE IF EXISTS `log_redis`;
CREATE TABLE `log_redis` (
  `log_id`   BIGINT(20) NOT NULL AUTO_INCREMENT,
  `log_info` VARCHAR(1500)       DEFAULT NULL,
  `log_time` VARCHAR(20)         DEFAULT NULL,
  PRIMARY KEY (`log_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of log_redis
-- ----------------------------
INSERT INTO `log_redis` VALUES ('1',
                                '2018-04-16 13:02:03.770 ERROR 15680 --- [main] c.n.m.n.p.s.d.c.DuerosController         : Internal Server Error',
                                '2018-04-16 13:02:03');
INSERT INTO `log_redis` VALUES ('2', NULL, NULL);
