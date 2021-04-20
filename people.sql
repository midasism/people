/*
 Navicat Premium Data Transfer

 Source Server         : 实验
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : people

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 20/04/2021 11:39:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) NULL DEFAULT NULL COMMENT '记录的日期',
  `job_id` int(5) NULL DEFAULT NULL COMMENT '工号',
  `state` int(11) NULL DEFAULT NULL COMMENT '考勤状态（-1 迟到    0：正常）',
  `arrival_time` datetime(0) NULL DEFAULT NULL COMMENT '到达时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (3, '2020-12-27 14:15:08', 8, -1, '2020-12-28 14:15:15');
INSERT INTO `attendance` VALUES (4, '2020-12-27 14:15:23', 7, 0, '2020-12-28 14:15:30');
INSERT INTO `attendance` VALUES (5, '2020-12-27 14:15:42', 6, 0, '2020-12-28 07:15:49');
INSERT INTO `attendance` VALUES (6, '2020-12-27 14:16:03', 5, 0, '2020-12-28 08:16:09');
INSERT INTO `attendance` VALUES (7, '2020-12-27 14:16:30', 4, 0, '2020-12-28 14:16:35');
INSERT INTO `attendance` VALUES (8, '2020-12-28 02:42:28', 13, 0, '2020-12-28 02:42:09');
INSERT INTO `attendance` VALUES (9, '2020-12-28 08:57:58', 18, 0, '2020-12-28 08:49:45');
INSERT INTO `attendance` VALUES (10, '2020-12-28 09:17:07', 19, 0, '2020-12-28 09:16:59');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '技术部');
INSERT INTO `department` VALUES (2, '运营部');
INSERT INTO `department` VALUES (3, '人事部');

-- ----------------------------
-- Table structure for dimission
-- ----------------------------
DROP TABLE IF EXISTS `dimission`;
CREATE TABLE `dimission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `outdate` datetime(0) NULL DEFAULT NULL COMMENT '离职时间',
  PRIMARY KEY (`id`, `job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dimission
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `job_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '工号，登录账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hiredate` datetime(0) NULL DEFAULT NULL COMMENT '入职时间',
  `job_status` int(11) NULL DEFAULT NULL COMMENT '在职状态（1在职 0未入职 -1离职）',
  `enabled` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户是否可用 默认1',
  `level` int(3) NULL DEFAULT NULL COMMENT '权限等级',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (4, '123456', '孟显赫', '男', '340202197104106891', '1213023504@qq.com', '13160679267', '2020-12-27 20:41:36', 0, '0', 0);
INSERT INTO `employee` VALUES (5, '123456', '你好', '男', '131122197404123979', '548857594@qq.com', '18150388643', '2020-12-16 20:41:55', 1, '1', 1);
INSERT INTO `employee` VALUES (6, '123456', '王泉成', '男', '141130198509277099', '1215356457@qq.com', '18150388265', '2020-12-25 20:41:44', -1, '1', 0);
INSERT INTO `employee` VALUES (7, '123456', '张三', '男', '430900198306141777', '1213023763@qq.com', '18150388802', '2020-12-26 20:41:39', -1, '1', 0);
INSERT INTO `employee` VALUES (8, '123456', '小红', '女', '152526198707214777', '1215356412@qq.com', '18150382353', '2020-12-23 20:41:48', 1, '1', 0);
INSERT INTO `employee` VALUES (9, '123456', '小莹', '女', '500114197005227938', '1215354326@qq.com', '13160679267', '2020-12-18 20:41:51', 1, '1', 0);
INSERT INTO `employee` VALUES (10, '123456', '小王', '男', '500114197005227938', '1215354326@qq.com', '13160679243', '2020-12-28 01:54:14', 1, '1', 0);
INSERT INTO `employee` VALUES (18, '123123', 'JavaWeb', '男', '150981199909152295', '1213023502@qq.com', '18150388894', '2020-12-28 08:47:25', 1, '1', 0);
INSERT INTO `employee` VALUES (19, '123123', 'javaWEB2020', '男', '150981199909152220', '1213023502@qq.com', '18150388894', '2020-12-28 09:15:30', -1, '1', 0);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(5) NOT NULL,
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`, `job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of office
-- ----------------------------

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '岗位号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, 'Java工程师');
INSERT INTO `position` VALUES (2, 'C++工程师');
INSERT INTO `position` VALUES (3, '产品经理');
INSERT INTO `position` VALUES (4, '产品总监');
INSERT INTO `position` VALUES (5, '技术总监');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(5) NULL DEFAULT NULL COMMENT '工号',
  `basic` int(11) NULL DEFAULT NULL COMMENT '基础工资',
  `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
  `check` int(11) NULL DEFAULT NULL COMMENT '考勤所得',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, 4, 9000, 200, 500);
INSERT INTO `salary` VALUES (2, 5, 8000, 200, 300);
INSERT INTO `salary` VALUES (3, 6, 10000, 200, 500);
INSERT INTO `salary` VALUES (4, 7, 6000, 200, 100);
INSERT INTO `salary` VALUES (5, 8, 7000, 200, 300);
INSERT INTO `salary` VALUES (6, 9, 3500, 200, 300);

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NULL DEFAULT NULL,
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `p_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES (1, 8, '运营', '产品经理');
INSERT INTO `work` VALUES (2, 9, '技术', 'java工程师');
INSERT INTO `work` VALUES (3, 7, '技术', 'python工程师');
INSERT INTO `work` VALUES (4, 5, '运营', '技术总监');
INSERT INTO `work` VALUES (5, 4, '技术', 'C++工程师');
INSERT INTO `work` VALUES (6, 10, '技术', '技术总监');
INSERT INTO `work` VALUES (9, 18, '技术', 'Java工程师');
INSERT INTO `work` VALUES (10, 19, '技术', 'Java工程师');

SET FOREIGN_KEY_CHECKS = 1;
