/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : everyday

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-11-11 21:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` varchar(255) NOT NULL COMMENT '资源表id',
  `url` varchar(255) DEFAULT NULL COMMENT '资源链接',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '/admin', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `resource` VALUES ('2', '/user', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `resource` VALUES ('3', '/hello', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `resource` VALUES ('4', '/', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `update_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `role` VALUES ('2', 'ADMIN', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` varchar(255) NOT NULL COMMENT '角色资源中间表id',
  `role_id` varchar(255) DEFAULT NULL,
  `resource_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '2');
INSERT INTO `role_resource` VALUES ('2', '1', '3');
INSERT INTO `role_resource` VALUES ('4', '2', '1');
INSERT INTO `role_resource` VALUES ('5', '2', '2');
INSERT INTO `role_resource` VALUES ('6', '2', '3');

-- ----------------------------
-- Table structure for solution
-- ----------------------------
DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution` (
  `id` varchar(255) NOT NULL,
  `http` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of solution
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `status` tinyint(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '2019-05-09 12:45:12', '2019-05-09 12:45:12', null, null);
INSERT INTO `user` VALUES ('2', 'admin', '123456', '0000-00-00 00:00:00', '0000-00-00 00:00:00', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL COMMENT '中间表id',
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `role_id` varchar(255) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
