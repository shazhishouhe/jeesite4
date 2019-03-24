/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : jeesite2

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-24 21:12:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `icw_oa_doc`
-- ----------------------------
DROP TABLE IF EXISTS `icw_oa_doc`;
CREATE TABLE `icw_oa_doc` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `doc_title` varchar(200) NOT NULL COMMENT '标题',
  `doc_type` varchar(200) DEFAULT NULL COMMENT '类型',
  `doc_keyword` varchar(200) DEFAULT NULL COMMENT '关键字',
  `doc_content` longtext COMMENT '内容',
  `doc_send_username` varchar(200) DEFAULT NULL COMMENT '发送人',
  `doc_isattac` varchar(1) DEFAULT NULL COMMENT '是否有附件',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='OA文档发布';

-- ----------------------------
-- Records of icw_oa_doc
-- ----------------------------
INSERT INTO `icw_oa_doc` VALUES ('1109714939438874624', '测试通知公告', '0', '测试通知公告', '测试通知公告', '', '', '0', 'system', '2019-03-24 15:13:54', 'system', '2019-03-24 15:13:54', null);
INSERT INTO `icw_oa_doc` VALUES ('1109715098021314560', '测试通知公告2', '0', '测试通知公告2', '测试通知公告2', '', '', '0', 'system', '2019-03-24 15:14:32', 'system', '2019-03-24 15:14:32', null);
INSERT INTO `icw_oa_doc` VALUES ('1109716317523591168', '规章制度', '1', '规章制度', '规章制度', '超级管理员', '', '0', 'system', '2019-03-24 15:19:22', 'system', '2019-03-24 15:19:22', null);
INSERT INTO `icw_oa_doc` VALUES ('1109716341556953088', '规章制度2', '1', '规章制度2', '规章制度2', '超级管理员', '', '0', 'system', '2019-03-24 15:19:28', 'system', '2019-03-24 15:19:28', null);
INSERT INTO `icw_oa_doc` VALUES ('1109716390315737088', '学习园地', '2', '学习园地', '学习园地', '超级管理员', '', '0', 'system', '2019-03-24 15:19:40', 'system', '2019-03-24 15:19:40', null);
INSERT INTO `icw_oa_doc` VALUES ('1109716455570718720', '学习园地2', '2', '学习园地2', '学习园地2', '超级管理员', '', '0', 'system', '2019-03-24 15:19:55', 'system', '2019-03-24 15:19:55', null);
