/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : refined_blood_hall

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-22 16:09:37
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nowcoder2018
-- ----------------------------
DROP TABLE IF EXISTS `nowcoder2018`;
CREATE TABLE `nowcoder2018` (
  `nId`            INT(11) NOT NULL AUTO_INCREMENT,
  `nCompany`       VARCHAR(255)     DEFAULT '',
  `nMeetingGray`   VARCHAR(255)     DEFAULT NULL,
  `nResumeGray`    VARCHAR(255)     DEFAULT NULL,
  `nWrittenGray`   VARCHAR(255)     DEFAULT NULL,
  `nAuditionGray`  VARCHAR(255)     DEFAULT NULL,
  `nSendOfferGary` VARCHAR(255)     DEFAULT NULL,
  `nUrlPer`        VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`nId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 202
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of nowcoder2018
-- ----------------------------
INSERT INTO `nowcoder2018` VALUES ('1', '阿里巴巴', '7月4日-8月18日', '7月4日-8月18日', '8月23日-8月25日', '7月3日-9月', '', '7月4日-8月18日');
INSERT INTO `nowcoder2018`
VALUES ('2', '腾讯', '7月25日-9月8日', '8月3日-9月8日', '9月12日-9月13日', '9月20日-10月20日', '', '8月3日-9月8日');
INSERT INTO `nowcoder2018`
VALUES ('3', '京东', '', '7月14日-10月31日', '8月15日-10月10日', '8月-11月', '9月25日-11月', '7月14日-10月31日');
INSERT INTO `nowcoder2018`
VALUES ('4', '百度', '7月29日开始', '7月29日-9月22日', '9月11日-9月27日', '9月15日-10月22日', '9月27日-11月', '7月29日-9月22日');
INSERT INTO `nowcoder2018`
VALUES ('5', '网易', '7月17日-8月8日', '8月9日-9月6日', '8月12日&9月9日', '8月中下旬&9月-10月', '面试后7-10个工作日', '8月9日-9月6日');
INSERT INTO `nowcoder2018` VALUES ('6', '网易游戏', '7月中旬开始', '7月中旬开始', '', '线上笔试后的5-7个工作日', '面试结束后的一周内', '7月中旬开始');
INSERT INTO `nowcoder2018` VALUES ('7', '蘑菇街', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('8', '奇虎360', '8月1日-8月13日', '8月14日开始', '8月25日-8月26日', '8月15日-8月23日', '8月31日', '8月14日开始');
INSERT INTO `nowcoder2018`
VALUES ('9', '美团点评', '8月10日开始', '8月20日-10月9日', '8.31_9.14_10.11', '8月下旬-10月21日', '', '8月20日-10月9日');
INSERT INTO `nowcoder2018` VALUES ('10', '携程', '8月2日-8月10日', '待定', '', '', '', '待定');
INSERT INTO `nowcoder2018` VALUES ('11', ' 亚信', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('12', '深信服', '', '8月23日-宣讲会结束', '', '', '', '8月23日-宣讲会结束');
INSERT INTO `nowcoder2018` VALUES ('13', '华为', '', '7月10日开始', '', '', '', '7月10日开始');
INSERT INTO `nowcoder2018`
VALUES ('14', '唯品会', '7月24日-8月20日', '7月22日-9月27日', '9月16日-9月17日', '9月21日-10月11日', '10月中下旬', '7月22日-9月27日');
INSERT INTO `nowcoder2018` VALUES ('15', '好未来', '', '7月12日开始', '', '', '', '7月12日开始');
INSERT INTO `nowcoder2018`
VALUES ('16', '完美世界', '7月17日-8月18日', '8月28日-9月底/10月', '9.26_9.28_10月中旬', '10月中旬-10月底', '10月-11月', '8月28日-9月底/10月');
INSERT INTO `nowcoder2018`
VALUES ('17', '迅雷', '8月7日-9月18日', '8月7日-9月18日', '9月18日', '9月下旬-10月上旬', '10月下旬', '8月7日-9月18日');
INSERT INTO `nowcoder2018` VALUES ('18', '谷歌', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('19', '小米', '8月17日开始', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('20', '微软', '', '9月1日-9月26日', '9月29日', '10月中旬-11月', '11月开始', '9月1日-9月26日');
INSERT INTO `nowcoder2018`
VALUES ('21', '搜狐', '7月25日-8月25日', '8月5日-9月12日', '9月17日', '9月2日-9月3日&9月下旬', '9月下旬-10月初', '8月5日-9月12日');
INSERT INTO `nowcoder2018` VALUES ('22', '新浪', '', '8月1日-9月15日', '9月16日-9月17日', '', '', '8月1日-9月15日');
INSERT INTO `nowcoder2018` VALUES ('23', '优酷', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('24', '搜狗', '', '8月-10月', '9月8日&9月28日', '9月-11月', '9月中旬', '8月-10月');
INSERT INTO `nowcoder2018` VALUES ('25', '人人', '', '8月17日开始', '9月13日', '', '', '8月17日开始');
INSERT INTO `nowcoder2018`
VALUES ('26', '亚马逊', '', '8月7日-10月15日', '9月10日-10月31日', '9月15日-11月10日', '9月20日-11月20日', '8月7日-10月15日');
INSERT INTO `nowcoder2018` VALUES ('27', '4399', '8月10日开始', '8月10日开始', '', '', '', '8月10日开始');
INSERT INTO `nowcoder2018`
VALUES ('28', '爱奇艺', '8月18日-9月8日', '8月28日-10月26日', '9.10_10.14_10.28', '', '', '8月28日-10月26日');
INSERT INTO `nowcoder2018` VALUES ('29', '今日头条', '8月1日-10月10日', '8月1日开始', '', '', '', '8月1日开始');
INSERT INTO `nowcoder2018`
VALUES ('30', '网龙', '', '8月16日-9月22日', '8月16日-9月23日', '9月22日-9月28日', '9月25日-9月29日', '8月16日-9月22日');
INSERT INTO `nowcoder2018`
VALUES ('31', '滴滴出行', '8月7日-8月25日', '即日-10月30日', '9.10_9.23_10.9', '9月12日-10月13日', '10月-11月', '即日-10月30日');
INSERT INTO `nowcoder2018` VALUES ('32', '链家网', '7月14日开始', '8月16日-10月20日', '', '', '', '8月16日-10月20日');
INSERT INTO `nowcoder2018` VALUES ('33', '乐视', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('34', '搜狐畅游', '8月9日-8月31日', '8月11日-9月15日', '9月17日', '9月下旬-10月上旬', '9月开始', '8月11日-9月15日');
INSERT INTO `nowcoder2018` VALUES ('35', '途牛', '8月8日开始', '待定', '', '', '', '待定');
INSERT INTO `nowcoder2018` VALUES ('36', '盛大', '7月26日开始', '8月14日-9月9日', '9月10日', '9月-10月', '9月下旬开始', '8月14日-9月9日');
INSERT INTO `nowcoder2018` VALUES ('37', ' 创新工场', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('38', '暴风科技', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('39', '咪咕', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('40', '去哪儿网', '8月11日开始', '8月11日-10月20日', '9月中旬-10月中旬', '9月中旬-10月中旬', '10月底之前', '8月11日-10月20日');
INSERT INTO `nowcoder2018` VALUES ('41', '小红书', '', '9月1日-10月25日', '', '', '', '9月1日-10月25日');
INSERT INTO `nowcoder2018`
VALUES ('42', '拼多多', '7月25日-7月31日', '7月10日-8月31日', '9月中旬-10月下旬', '9月中旬-10月下旬', '', '7月10日-8月31日');
INSERT INTO `nowcoder2018` VALUES ('43', '猪八戒网', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('44', ' 巨人网络', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('45', '瓜子二手车', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('46', '趣加', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('47', '点点客', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('48', '卷皮 ', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('49', '百视通', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('50', '惠普', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('51', '方正世纪 ', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('52', '浪潮集团 ', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('53', '华硕电脑 ', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('54', '索尼电子', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('55', '三星电子(中国)研发中心', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('56', 'oppo', '', '9月-10月14日', '9月16日&10月15日', '9.20-9.19_10.18-10.28', '', '9月-10月14日');
INSERT INTO `nowcoder2018` VALUES ('57', '爱立信南京', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('58', 'vivo', '', '9月6日-9月22日', '9月15日&9月23日', '9.17-19_9.25-27', '', '9月6日-9月22日');
INSERT INTO `nowcoder2018` VALUES ('59', '兴唐通讯', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('60', '奥克斯', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('61', '爱普生中国', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('62', '国美电器', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('63', '顺丰', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('64', '国家电网', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('65', '\r\n丰田汽车中国', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('66', '贝卡尔特', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('67', '西门子', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('68', '中国邮政', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('69', '时速云', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('70', '犀牛云', '', '', '', '', '', 'hr@99cloud.net');
INSERT INTO `nowcoder2018`
VALUES ('71', '联想', '8月14日开始', '8月14日-9月24日', '9月25日-10月9日', '10月14日-10月22日', '11月', '8月14日-9月24日');
INSERT INTO `nowcoder2018` VALUES ('72', '九州云', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('73', '亚马逊', '', '8月7日-10月15日', '9月10日-10月31日', '9月15日-11月10日', '9月20日-11月20日', '8月7日-10月15日');
INSERT INTO `nowcoder2018` VALUES ('74', '青云', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('75', 'Ucloud', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('76', '灵犀', '', '', '', '', '', 'zhaolu@yun-ji.cn');
INSERT INTO `nowcoder2018` VALUES ('77', '海康威视', '7月21日开始', '7月21日开始', '', '', '', '7月21日开始');
INSERT INTO `nowcoder2018` VALUES ('78', 'Facebook', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('79', 'Linkin', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('80', '苏宁', '7月21日-7月24日', '', '', '7月24日-8月底', '', '');
INSERT INTO `nowcoder2018` VALUES ('81', 'Uber', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('82', '有云科技', '', '', '', '', '', 'https://www.ustack.com/about/jobs');
INSERT INTO `nowcoder2018` VALUES ('83', 'CVTE', '7月28日开始', '7月28日开始', '7月26日-7月30日', '', '', '7月28日开始');
INSERT INTO `nowcoder2018` VALUES ('84', '趋势科技', '', '8月14日开始', '9月上旬-10月上旬', '9月上旬-10月上旬', '', '8月14日开始');
INSERT INTO `nowcoder2018` VALUES ('85', '七牛云', '', '7月14日', '', '', '', 'http://career.qiniu.com/campus/tech');
INSERT INTO `nowcoder2018` VALUES ('86', '领英', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('87', '绿盟', '', '8月下旬-10月中旬', '8月下旬-10月中旬', '9月下旬-10月下旬', '9月末起', '8月下旬-10月中旬');
INSERT INTO `nowcoder2018` VALUES ('88', 'Intel', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('89', '知道创宇', '', '', '', '', '', '');
INSERT INTO `nowcoder2018`
VALUES ('90', 'IBM', '', '8月21日-10月15日', '', '9月11日-11月30日', '10月16日-12月15日', '8月21日-10月15日');
INSERT INTO `nowcoder2018` VALUES ('91', 'EMC', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('92', '安恒', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('93', 'Akamai', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('94', '西门子', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('95', '诺基亚', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('96', 'SAP', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('97', '三未信安', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('98', '易云股份', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('99', 'HGST', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('100', 'Rancher Labs', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('101', '科大讯飞', '7月26日开始', '7月26日开始', '9月中旬开始', '', '', '7月26日开始');
INSERT INTO `nowcoder2018` VALUES ('102', '灵雀云', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('103', 'DaoCloud', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('104', '思科系统（中国）网络技术有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('105', 'NetApp中国公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('106', '希捷（中国）有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('107', 'Radware（中国）有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('108', '汉柏科技有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('109', '飞塔信息科技(北京)有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('110', '美国思杰公司（citrix', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('111', '甲骨文软件系统有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('112', '曙光信息产业股份有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('113', '电讯盈科企业方案', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('114', '青牛（北京）技术有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('115', '上海威达云信息技术有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('116', '上海有孚计算机网络有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('117', '数云集团', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('118', '上海驻云信息科技有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('119', '上海国富光启云计算科技股份有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('120', '上海艾讯云计算有限公司', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('125', '远景能源', '全年开启', '全年开启', '', '宣讲会后一周', '', '全年开启');
INSERT INTO `nowcoder2018` VALUES ('126', '金山', '8月1日-8月25日', '8月1日-9月22日', '9月', '8月下旬&9月下旬', '', '8月1日-9月22日');
INSERT INTO `nowcoder2018` VALUES ('127', '猪八戒', '8月1日-9月9日', '8月1日开始', '9月中旬开始', '9月下旬开始', '', '8月1日开始');
INSERT INTO `nowcoder2018` VALUES ('128', '吉比特', '7月15日开始', '7月15日开始', '', '笔试后1-2天&笔试后1周', '', '7月15日开始');
INSERT INTO `nowcoder2018` VALUES ('129', 'NVIDIA', '8月1日开始', '8月2日开始', '', '', '', '8月2日开始');
INSERT INTO `nowcoder2018` VALUES ('130', 'FreeWheel', '8月2日开始', '8月2日开始', '', '', '', '8月2日开始');
INSERT INTO `nowcoder2018` VALUES ('131', '便利蜂', '8月2日开始', '待定', '', '', '', '待定');
INSERT INTO `nowcoder2018` VALUES ('132', '三七互娱', '8月5日开始', '8月10日-9月初', '9月-10月', '9月-10月', '10月下旬', '8月10日-9月初');
INSERT INTO `nowcoder2018` VALUES ('133', '58同城', '', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('134', '多益网络', '8月8日开始', '8月8日开始', '8月26日&9月16日', '', '', '8月8日开始');
INSERT INTO `nowcoder2018` VALUES ('135', '猿辅导', '', '8月8日开始', '', '8.21-25_9.25-29', '', '8月8日开始');
INSERT INTO `nowcoder2018`
VALUES ('136', '有赞', '8月9日-9月15日', '8月25日-10月15日', '9月21日&10月17日', '9月下旬-11月上旬', '10月-11月', '8月25日-10月15日');
INSERT INTO `nowcoder2018` VALUES ('137', '巨人网络', '', '8月10日-9月5日', '', '', '', '8月10日-9月5日');
INSERT INTO `nowcoder2018` VALUES ('138', '图森科技', '', '8月10日开始', '', '', '', '8月10日开始');
INSERT INTO `nowcoder2018`
VALUES ('139', '商汤科技', '8月8日-8月18日', '8月21日-10月8日', '9月17日&10月12日', '8.21-9.1&9月-10月', '10月上旬-11月上旬', '8月21日-10月8日');
INSERT INTO `nowcoder2018`
VALUES ('140', '猎豹移动', '8月23日-9月6日', '8月23日-10月13日', '9月13日、23日 10月14日', '', '', '8月23日-10月13日');
INSERT INTO `nowcoder2018`
VALUES ('141', '美丽联合', '8月15日-8月29日', '8月15日-9月21日', '9月22日-9月25日', '10月开始', '9月中旬&11月', '8月15日-9月21日');
INSERT INTO `nowcoder2018`
VALUES ('142', '欢聚时代', '8月15日开始', '8月15日-9月25日', '9月中旬-9月下旬', '9月下旬-10月中旬', '9月下旬-10月中旬', '8月15日-9月25日');
INSERT INTO `nowcoder2018` VALUES ('143', '中国银联', '8月11日开始', '8月11日-8月25日', '8月30日', '9月-10月', '9月-10月', '8月11日-8月25日');
INSERT INTO `nowcoder2018` VALUES ('144', 'Vipkid', '8月14日开始', '', '', '', '', '');
INSERT INTO `nowcoder2018` VALUES ('145', '旷视科技', '8月11日开始', '8月14日- 9月30日', '9月', '8月-9月', '9月开始', '8月14日- 9月30日');
INSERT INTO `nowcoder2018` VALUES ('146', '触宝', '8月14日开始', '9月1日-10月30日', '', '', '', '9月1日-10月30日');
INSERT INTO `nowcoder2018` VALUES ('147', '中兴', '8月开始', '8月开始', '8月底-9月初', '9月-10月', '9月-10月', '8月开始');
INSERT INTO `nowcoder2018`
VALUES ('148', '微策略', '8月11日-9月11日', '8月18日-10月23日', '9月-10月&10月24日', '笔试后一周', '面试后两周内', '8月18日-10月23日');
INSERT INTO `nowcoder2018` VALUES ('149', '招银网络科技', '8月16日开始', '9月23日截止', '', '9月18日-10月28日', '', '9月23日截止');
INSERT INTO `nowcoder2018` VALUES
  ('150', 'ThoughtWorks', '8月14日-9月8日', '8月1日-10月13日', '10月9日-10月18日', '10月19日-10月22日', '10月23日-11月', '8月1日-10月13日');
INSERT INTO `nowcoder2018` VALUES ('151', '金山云', '8月14日-8月25日', '待定', '', '8月21日-9月8日', '9月初', '待定');
INSERT INTO `nowcoder2018` VALUES ('152', '宁波银行', '8月6日-8月25日', '8月6日-8月25日', '', '8月14日-9月上旬', '', '8月6日-8月25日');
INSERT INTO `nowcoder2018` VALUES ('153', '饿了么', '8月17日开始', '待定', '', '', '', '待定');
INSERT INTO `nowcoder2018` VALUES ('154', '汇顶科技', '8月17日开始', '8月开始', '', '', '', '8月开始');
INSERT INTO `nowcoder2018` VALUES ('155', '招商银行信用卡中心', '8月18日开始', '8月16日-10月8日', '', '', '', '8月16日-10月8日');
INSERT INTO `nowcoder2018` VALUES ('156', '地平线机器人', '8月17日-8月25日', '8月11日开始', '宣讲会现场', '笔试后一天', '9月中下旬', '8月11日开始');
INSERT INTO `nowcoder2018` VALUES ('157', '涂鸦移动', '', '8月23日开始', '', '', '', '8月23日开始');
INSERT INTO `nowcoder2018` VALUES ('158', '贝贝', '8月23日开始', '8月23日开始', '', '', '', '8月23日开始');
INSERT INTO `nowcoder2018`
VALUES ('159', '美图网', '8月21日开始', '8月21日-10月10日', '9月4日&10月12日', '9月中旬-11月上旬', '10月下旬-11月上旬', '8月21日-10月10日');
INSERT INTO `nowcoder2018`
VALUES ('160', '上汽集团', '8月18日开始', '8月18日-8月31日', '9月1日-9月3日', '9月9日', '9月10日', '8月18日-8月31日');
INSERT INTO `nowcoder2018` VALUES ('161', '酷家乐', '8月18日开始', '8月18日开始', '', '', '', '8月18日开始');
INSERT INTO `nowcoder2018` VALUES ('162', 'Hypereal', '8月18日开始', '8月18日开始', '', '', '', '8月18日开始');
INSERT INTO `nowcoder2018` VALUES ('163', '依图科技', '8月18日开始', '8月18日开始', '', '', '', '8月18日开始');
INSERT INTO `nowcoder2018`
VALUES ('164', '51信用卡', '9月1日-9月15日', '9月16日-10月15日', '9月18日&10月18日', '9月-10月', '', '9月16日-10月15日');
INSERT INTO `nowcoder2018` VALUES ('165', '数码视讯', '8月28日开始', '待定', '', '', '', '待定');
INSERT INTO `nowcoder2018` VALUES ('166', '百词斩', '', '8月开始', '', '', '', '8月开始');
INSERT INTO `nowcoder2018` VALUES ('167', '艺龙', '', '8月21日-9月20日', '9月26日', '10月', '', '8月21日-9月20日');
INSERT INTO `nowcoder2018` VALUES ('168', '摩拜', '', '8月31日-10月16日', '10月19日', '10月21日-10月28日', '11月3日', '8月31日-10月16日');
INSERT INTO `nowcoder2018` VALUES ('169', '凤凰网', '8月28日-9月15日', '8月-10月', '9月-10月', '9月-11月', '9月-12月', '8月-10月');
INSERT INTO `nowcoder2018` VALUES ('170', '虹软', '8月31日开始', '8月31日开始', '', '', '', '8月31日开始');
INSERT INTO `nowcoder2018` VALUES ('171', '同花顺', '9月5日开始', '9月5日开始', '9月中旬开始', '9月下旬开始', '', '9月5日开始');
INSERT INTO `nowcoder2018`
VALUES ('172', '作业帮', '8月15日-11月20日', '8月15日-9月20日', '8月20日-9月15日', '8月20日-9月20日', '', '8月15日-9月20日');
INSERT INTO `nowcoder2018` VALUES ('173', '陌陌', '', '9月7日开始', '', '10月中旬', '10月下旬', '9月7日开始');
INSERT INTO `nowcoder2018` VALUES ('174', '斗鱼', '', '9月15日-9月20日', '9月', '9月', '9月底-10月初', '9月15日-9月20日');
INSERT INTO `nowcoder2018` VALUES ('175', '蜜柚', '', '9月1日-11月30日', '9月18日-11月30日', '9月18日-11月30日', '', '9月1日-11月30日');
INSERT INTO `nowcoder2018` VALUES ('176', 'Hulu', '', '截止9月18日', '9月21日', '', '', '截止9月18日');
INSERT INTO `nowcoder2018` VALUES ('177', 'VIVO', '', '9月6日-9月22日', '9月15日&9月23日', '9.17-19_9.25-27', '', '9月6日-9月22日');
INSERT INTO `nowcoder2018` VALUES ('178', '河狸家', '', '9月8日开始', '', '', '', '9月8日开始');
INSERT INTO `nowcoder2018`
VALUES ('179', 'bilibili', '', '9月4日-10月16日', '9.15_9.29_10.19', '10月19日后', '', '9月4日-10月16日');
INSERT INTO `nowcoder2018` VALUES ('180', '知乎', '', '8月开始', '', '', '', '8月开始');
INSERT INTO `nowcoder2018` VALUES ('181', '万科', '', '9月8日开始', '', '', '', '9月8日开始');
INSERT INTO `nowcoder2018` VALUES ('182', '国家电网信通产业集团', '', '9月开始', '', '', '', '9月开始');
INSERT INTO `nowcoder2018`
VALUES ('183', 'OPPO', '', '9月-10月14日', '9月16日&10月15日', '9.20-9.19_10.18-10.28', '', '9月-10月14日');
INSERT INTO `nowcoder2018` VALUES ('184', '中国联通', '', '9月9日开始', '', '', '', '9月9日开始');
INSERT INTO `nowcoder2018` VALUES ('185', '微众银行', '9月12日-9月24日', '9月12日开始', '', '', '', '9月12日开始');
INSERT INTO `nowcoder2018` VALUES ('186', '广发银行', '', '8月28日-10月20日', '10月28日', '11月开始', '11月-12月', '8月28日-10月20日');
INSERT INTO `nowcoder2018` VALUES ('187', '中国人寿', '', '10月22日截止', '', '', '', '10月22日截止');
INSERT INTO `nowcoder2018` VALUES ('188', '爱立信', '', '8月28日开始', '', '', '', '8月28日开始');
INSERT INTO `nowcoder2018` VALUES ('189', '第四范式', '', '9月开始', '', '', '', '9月开始');
INSERT INTO `nowcoder2018` VALUES ('190', '酷狗音乐', '', '9月30日截止', '', '', '', '9月30日截止');
INSERT INTO `nowcoder2018` VALUES ('191', '新东方', '', '8月17日开始', '', '', '', '8月17日开始');
INSERT INTO `nowcoder2018` VALUES ('192', '浪潮', '', '8月1日-11月15日', '', '', '', '8月1日-11月15日');
INSERT INTO `nowcoder2018` VALUES ('193', '神州信息', '', '8月22日开始', '', '', '', '8月22日开始');
INSERT INTO `nowcoder2018` VALUES ('194', 'Pony.ai', '', '10月31日截止', '', '', '', '10月31日截止');
INSERT INTO `nowcoder2018` VALUES ('195', '货车帮', '', '10月开始', '', '', '', '10月开始');
INSERT INTO `nowcoder2018` VALUES ('196', '豆瓣', '', '10月开始', '', '', '', '10月开始');
INSERT INTO `nowcoder2018` VALUES ('197', 'ofo', '', '10月20日截止', '', '', '', '10月20日截止');
INSERT INTO `nowcoder2018` VALUES ('198', '一点资讯', '', '9月开始', '', '', '', '9月开始');
INSERT INTO `nowcoder2018` VALUES ('199', '趣店', '', '8月7日-10月31日', '', '', '', '8月7日-10月31日');
INSERT INTO `nowcoder2018` VALUES ('200', '优信集团', '', '11月30日截止', '', '', '', '11月30日截止');
INSERT INTO `nowcoder2018` VALUES ('201', '神州付', '', '11月30日截止', '', '', '', '11月30日截止');
