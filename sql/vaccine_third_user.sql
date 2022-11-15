/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.10.14
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 172.16.10.14:3306
 Source Schema         : nat-web-admin

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 29/03/2021 15:50:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vaccine_third_user
-- ----------------------------
DROP TABLE IF EXISTS `vaccine_third_user`;
CREATE TABLE `vaccine_third_user`  (
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
	`nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
	`user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户类型',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `db_permissions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '数据库权限',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `vaccine_third_user`(`user_id`, `user_name`, `nick_name`, `user_type`, `password`, `db_permissions`, `status`, `create_by`, `create_time`) VALUES ('0', 'SZJK_U1', '卫生部',  'LANGCHAO','$2a$10$gnInnOf1NmpylRJ02ShVL.FZDqynIEbGp8S.fZseO/9RJ2lc.DG.W', '34c0f8379a11af8b4b4e1624bc5b7744', '0', NULL, NULL);
INSERT INTO `vaccine_third_user`(`user_id`, `user_name`, `nick_name`, `user_type`, `password`, `db_permissions`, `status`, `create_by`, `create_time`) VALUES ('1', 'SZJK_U2', '卫生部',  'LANGCHAO','$2a$10$KVj.0MqHVwP5YF8JT4yB5eRFJJGnKc2gLrNTWkfscm2UGvTG.v232', '34c0f8379a11af8b4b4e1624bc5b7744', '0', NULL, NULL);
INSERT INTO `vaccine_third_user`(`user_id`, `user_name`, `nick_name`, `user_type`, `password`, `db_permissions`, `status`, `create_by`, `create_time`) VALUES ('2', 'SZJK_U3', '卫生部',  'LANGCHAO','$2a$10$GE16gO8TNNajbbLrdkCekeaxTJeBpfbmsFYDfRw285.aXAjhU7D4y', '34c0f8379a11af8b4b4e1624bc5b7744', '0', NULL, NULL);
INSERT INTO `vaccine_third_user`(`user_id`, `user_name`, `nick_name`, `user_type`, `password`, `db_permissions`, `status`, `create_by`, `create_time`) VALUES ('3', 'admin', '卫生部',  'LANGCHAO','$2a$10$jDImu79xv6yStBLub2L1ueSawQshA2NkGptX8LprDMRyHTHGlXU7i', '34c0f8379a11af8b4b4e1624bc5b7744', '0', NULL, NULL);
INSERT INTO `vaccine_third_user`(`user_id`, `user_name`, `nick_name`, `user_type`, `password`, `db_permissions`, `status`, `create_by`, `create_time`) VALUES ('4', 'SZJK_U4', '腾讯',  'LANGCHAO','$2a$10$8.fAqscA6rKvSivuOdhdt.k8.ehO.CFcuk8OEnyjqznF.J7.jkREm', '34c0f8379a11af8b4b4e1624bc5b7744', '0', NULL, NULL);

