/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : studentmanagement

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-12-24 15:15:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `award_record`
-- ----------------------------
DROP TABLE IF EXISTS `award_record`;
CREATE TABLE `award_record` (
  `content` varchar(50) NOT NULL COMMENT '奖励名称',
  `date` date NOT NULL COMMENT '获奖日期',
  `student_id` bigint(20) NOT NULL COMMENT '学生编号',
  `degree` varchar(20) DEFAULT NULL COMMENT '等级，如一、二、三等、优生',
  `level` varchar(20) DEFAULT NULL COMMENT '级别，国际级、国家级、省级、市级、校级',
  `rank` int(11) unsigned DEFAULT NULL COMMENT '排名',
  PRIMARY KEY (`content`,`date`,`student_id`),
  KEY `award_fk_1` (`student_id`),
  CONSTRAINT `award_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of award_record
-- ----------------------------
INSERT INTO `award_record` VALUES ('机器学习大赛', '2017-08-01', '3903150326', '优生', '国家级', '2');

-- ----------------------------
-- Table structure for `failexam_record`
-- ----------------------------
DROP TABLE IF EXISTS `failexam_record`;
CREATE TABLE `failexam_record` (
  `term` varchar(20) DEFAULT NULL COMMENT '学期',
  `subject` varchar(20) NOT NULL COMMENT '科目',
  `student_id` bigint(20) NOT NULL COMMENT '学生编号',
  PRIMARY KEY (`subject`,`student_id`),
  KEY `failexam_fk_1` (`student_id`),
  CONSTRAINT `failexam_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of failexam_record
-- ----------------------------
INSERT INTO `failexam_record` VALUES ('2015-2016-2', '高数下', '3903150326');

-- ----------------------------
-- Table structure for `parent`
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent` (
  `name` varchar(20) NOT NULL COMMENT '家长姓名',
  `phone` varchar(20) NOT NULL COMMENT '家长联系方式',
  `relation` int(4) NOT NULL COMMENT '学生家长关系',
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`student_id`,`name`),
  CONSTRAINT `parent_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parent
-- ----------------------------
INSERT INTO `parent` VALUES ('李华', '15616188082', '0', '3903150326');
INSERT INTO `parent` VALUES ('王五', '15616188023', '1', '3903150326');

-- ----------------------------
-- Table structure for `signon`
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon` (
  `student_id` bigint(20) NOT NULL COMMENT '学生编号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `authorities` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signon
-- ----------------------------
INSERT INTO `signon` VALUES ('111', '111', 'ROLE_ADMIN');
INSERT INTO `signon` VALUES ('222', '222', 'ROLE_ADMIN');
INSERT INTO `signon` VALUES ('3903150326', '3903150326', 'ROLE_USER');
INSERT INTO `signon` VALUES ('3903150327', '3903150327', 'ROLE_USER');
INSERT INTO `signon` VALUES ('3903150332', '3903150332', 'ROLE_USER');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '学生编号',
  `name` varchar(20) NOT NULL COMMENT '学生姓名',
  `sex` int(4) NOT NULL COMMENT '性别',
  `residence` varchar(50) DEFAULT NULL COMMENT '家庭居住地',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `native_place` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `employment_unit` varchar(50) DEFAULT NULL COMMENT '就业单位',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `counselor_name` varchar(20) NOT NULL COMMENT '辅导员姓名',
  `counselor_phone` varchar(20) NOT NULL COMMENT '辅导员联系方式',
  `student_type` varchar(20) NOT NULL COMMENT '学生类型',
  `verify_state` int(4) NOT NULL DEFAULT '0' COMMENT '审核状态',
  `id_photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3903150326', '李涛江', '1', '河南省辉县市', '1998-04-17', '河南省辉县市', '软件工程', '中南大学', '修改备注~~~success!', '辅导员', '15616188082', '2', '1', null);
INSERT INTO `student` VALUES ('3903150327', '陈铭明', '1', '', null, '', '软件工程', '', '', '辅导员', '', '0', '0', null);
INSERT INTO `student` VALUES ('3903150332', '葛凡', '1', '', '2001-01-03', '', '软件工程', '中南大学', '备注啊', '辅导员', '15616188082', '0', '0', null);

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `majors` varchar(100) NOT NULL,
  `role` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('辅导员', '111', null, '15166669999', null, '软件工程', '0');
INSERT INTO `teacher` VALUES ('副书记', '222', null, '15166889999', null, '软件工程', '1');

-- ----------------------------
-- Table structure for `verify_log`
-- ----------------------------
DROP TABLE IF EXISTS `verify_log`;
CREATE TABLE `verify_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NOT NULL COMMENT '学生编号',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `counselor_name` varchar(20) NOT NULL COMMENT '辅导员姓名',
  `verify_operate` int(4) NOT NULL COMMENT '审核执行的操作',
  `date` date NOT NULL DEFAULT '0000-00-00' COMMENT '日志日期',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verify_log
-- ----------------------------
INSERT INTO `verify_log` VALUES ('1', '3903150326', '李涛江 ', '111', '1', '2017-07-14');
INSERT INTO `verify_log` VALUES ('2', '3903150326', '李涛江 ', '111', '0', '2017-07-14');
INSERT INTO `verify_log` VALUES ('3', '3903150326', '李涛江 ', '111', '0', '2017-07-14');
INSERT INTO `verify_log` VALUES ('4', '3903150326', '李涛江 ', '111', '0', '2017-07-14');
INSERT INTO `verify_log` VALUES ('5', '3903150326', '李涛江 ', '111', '0', '2017-07-14');
INSERT INTO `verify_log` VALUES ('6', '3903150326', '李涛江 ', '111', '1', '2017-07-14');

-- ----------------------------
-- Table structure for `withdraw_inst`
-- ----------------------------
DROP TABLE IF EXISTS `withdraw_inst`;
CREATE TABLE `withdraw_inst` (
  `inst_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`inst_id`),
  KEY `inst_fk_1` (`student_id`),
  CONSTRAINT `inst_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of withdraw_inst
-- ----------------------------
