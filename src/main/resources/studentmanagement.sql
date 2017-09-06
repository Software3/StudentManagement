/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : studentmanagement

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-08-09 10:06:14
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
  PRIMARY KEY (`content`,`date`,`student_id`),
  KEY `award_fk_1` (`student_id`),
  CONSTRAINT `award_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of award_record
-- ----------------------------

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

-- ----------------------------
-- Table structure for `signon`
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon` (
  `student_id` bigint(20) NOT NULL COMMENT '学生编号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signon
-- ----------------------------

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

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `majors` varchar(100) NOT NULL,
  `role` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verify_log
-- ----------------------------

-- ----------------------------
-- Table structure for `withdraw_inst`
-- ----------------------------
DROP TABLE IF EXISTS `withdraw_inst`;
CREATE TABLE `withdraw_inst` (
  `inst_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) NOT NULL,
  `describe` varchar(300) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`inst_id`),
  KEY `inst_fk_1` (`student_id`),
  CONSTRAINT `inst_fk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of withdraw_inst
-- ----------------------------
