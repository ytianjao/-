/*
 Navicat Premium Data Transfer

 Source Server         : miaosha
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : biaodan

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 11/06/2022 18:48:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biaodan_col_counts_11
-- ----------------------------
DROP TABLE IF EXISTS `biaodan_col_counts_11`;
CREATE TABLE `biaodan_col_counts_11`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `col1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col9` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col10` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col11` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biaodan_col_counts_11
-- ----------------------------
INSERT INTO `biaodan_col_counts_11` VALUES (1, '', '重量(g/\n支)', '圆周(mm)', '吸阻(Pa)', '总通风率\n(%)', '硬度(%)', '长度(mm)', '烟支水分\n(%)', '端部落丝\n量(mg)', '卷烟机\n空头剔\n除率(%)', '包装机空\n头剔除率\n(%)');
INSERT INTO `biaodan_col_counts_11` VALUES (2, '第二份', '0.83', '24.21', '1096', '32.6', '65.52', '84.1', '12.04', '5.33', '0.46', '0.97');
INSERT INTO `biaodan_col_counts_11` VALUES (3, '第三份', '0.839', '24.19', '1113', '31.8', '65.6', '84.1', '11.99', '5.57', '1.35', '0.52');
INSERT INTO `biaodan_col_counts_11` VALUES (4, '第四份', '0.836', '24.21', '1102', '30.9', '64.6', '84.3', '12.11', '5.35', '1.5', '0.32');
INSERT INTO `biaodan_col_counts_11` VALUES (5, '第五份', '0.838', '24.19', '1106', '31.3', '65.6', '84.2', '11.93', '4.98', '0.95', '0.3');
INSERT INTO `biaodan_col_counts_11` VALUES (6, '第六份', '0.836', '24.16', '1100', '31', '67.1', '84.3', '12.27', '4.36', '0.84', '0.13');
INSERT INTO `biaodan_col_counts_11` VALUES (7, '第七份', '0.838', '24.2', '1096', '31.5', '65.4', '84.3', '12.14', '4.71', '1.04', '0.2');
INSERT INTO `biaodan_col_counts_11` VALUES (8, '平均值', '0.84', '24.19', '1102.17', '31.52', '65.64', '84.22', '12.08', '5.05', '1.02', '0.41');

-- ----------------------------
-- Table structure for biaodan_col_counts_3
-- ----------------------------
DROP TABLE IF EXISTS `biaodan_col_counts_3`;
CREATE TABLE `biaodan_col_counts_3`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `col1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biaodan_col_counts_3
-- ----------------------------

-- ----------------------------
-- Table structure for biaodan_table2
-- ----------------------------
DROP TABLE IF EXISTS `biaodan_table2`;
CREATE TABLE `biaodan_table2`  (
  `col1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col9` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col10` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `col11` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of biaodan_table2
-- ----------------------------
INSERT INTO `biaodan_table2` VALUES ('序号', '重量(g/\n支)', '圆周(mm)', '吸阻(Pa)', '总通风率\n(%)', '硬度(%)', '长度(mm)', '烟支水分\n(%)', '端部落丝\n量(mg)', '卷烟机\n空头剔\n除率(%)', '包装机空\n头剔除率\n(%)', 4);
INSERT INTO `biaodan_table2` VALUES ('第二份', '0.83', '24.21', '1096', '32.6', '65.52', '84.1', '12.04', '5.33', '0.46', '0.97', 11);
INSERT INTO `biaodan_table2` VALUES ('第三份', '0.839', '111', '1113', '31.8', '65.6', '84.1', '11.99', '5.57', '1.35', '0.52', 12);
INSERT INTO `biaodan_table2` VALUES ('第四份', '0.836', '24.21', '1102', '30.9', '64.6', '84.3', '12.11', '5.35', '1.5', '0.32', 13);
INSERT INTO `biaodan_table2` VALUES ('第五份', '0.838', '24.19', '1106', '31.3', '65.6', '84.2', '11.93', '4.98', '0.95', '0.3', 14);
INSERT INTO `biaodan_table2` VALUES ('第六份', '0.836', '24.16', '1100', '31', '67.1', '84.3', '12.27', '4.36', '0.84', '0.13', 15);
INSERT INTO `biaodan_table2` VALUES ('第七份', '0.838', '24.2', '1096', '31.5', '65.4', '84.3', '12.14', '4.71', '1.04', '0.2', 16);

SET FOREIGN_KEY_CHECKS = 1;
