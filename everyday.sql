/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : everyday

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-29 12:44:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(128) NOT NULL,
  `resourceIds` varchar(256) DEFAULT NULL,
  `appSecret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `grantTypes` varchar(256) DEFAULT NULL,
  `redirectUrl` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientdetails
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('0918132d29ec11ea8b3e10c37b4ae890', 'user', '$2a$10$CrQihthBWjHSpEPFO.w2H.Ohwu3NI/MaSwj43K3qEb0xhZeWZfYY2', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('1676fbef29e211ea8b3e10c37b4ae890', 'user', '$2a$10$3kUsJZ4bPPTiTVDddGwzVu8BXPkDOWrHxXZ43Wf2obQfqb8lgQoay', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('2b77b523249711eab9f310c37b4ae890', 'user', '$2a$10$pzCJoOx9Uhk/q5j6KdUfAusUI0Clh2WjX4BBpdcTUl350AnlPn2DC', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, 'false');
INSERT INTO `oauth_client_details` VALUES ('3a0fbc6229f411ea8b3e10c37b4ae890', 'user', '$2a$10$yt7Se2NkMJ.5jlZFCEBTvuCyqzMuPpxBIUVnzC/69Z4KEcNk7I8HC', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('63afb80729f011ea8b3e10c37b4ae890', 'user', '$2a$10$huRIVvliouwm8yYYqYauruS3/EnCQdRYibJrdYu..7JLWbnheMyeW', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('8305dacf29e811ea8b3e10c37b4ae890', 'user', '$2a$10$4nLuwHnHYtfmMYD5WYX3Re5gRK/thCCPlKiPUIlNQcqR2ageOEPii', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('8a508ad929ec11ea8b3e10c37b4ae890', 'user', '$2a$10$hrOlZVuqlQalSEDptFz7Kud5nFzCIhE94fOqX9tCkQuNQuH50MKeC', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('8c5376f129ec11ea8b3e10c37b4ae890', 'user', '$2a$10$AdCEZ9SpLkay3B5fQLkHSOFg23nKsa5/YDzaqpABFLqgRCJ5qIaMK', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('909e689529ec11ea8b3e10c37b4ae890', 'user', '$2a$10$inEYubEok1qMBhX5ggJCuOfmQ4OPwI4Any7zAaaYCYKzDp9xSDbo2', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('9713adac29e811ea8b3e10c37b4ae890', 'user', '$2a$10$ucVIK7ldlNAzzW.CtmAyLe5u9Cm4tXtFp8vGEeR/oLBNA2fYd9hfa', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('aed9c66828a311ea8f6810c37b4ae890', 'user', '$2a$10$EU5V/QhKWYNJMfdeh/UaYO8iQJVZo5Ndqt3sL4NT1hIGgnAPWIcT6', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('cli-1', 'user', '$2a$10$LGLVwY6UNllKRePYwlkZG.p5PPrd6NCwvHRPemWkhVFn.TWCZ6Zo6', 'ROLE_ADMIN,ROLE_USER', 'password,client_credentials,implicit,refresh_token', 'https://www.baidu.com', null, null, null, null, 'false');
INSERT INTO `oauth_client_details` VALUES ('d832cced29eb11ea8b3e10c37b4ae890', 'user', '$2a$10$yuSiQKS/UJmwuV9nXyB6UuEDuEM73X9GppnWoPZs.4pf48xoeG2xq', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('d9b2287c29e811ea8b3e10c37b4ae890', 'user', '$2a$10$id5fbQRCY5IIyGAZgP1b6.yQkwgZMMHX2mlM7rgK2p5NxIN/tLgEm', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('f555683829e711ea8b3e10c37b4ae890', 'user', '$2a$10$aB2dLA5kricvrxjVKCgfvuA.9GmRHqYLtntUUaRwsyvW8vmZ5tl02', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('ff04b2a929e611ea8b3e10c37b4ae890', 'user', '$2a$10$GKRklxJ7uINMI.72JykHNOQCzUWv5cBX0VA1I52vEZbPavpKLBVHy', 'ROLE_USER', 'password,client_credentials,implicit,refresh_token', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------
INSERT INTO `oauth_code` VALUES ('YssDev', 0x524F4C455F55534552);
INSERT INTO `oauth_code` VALUES ('slYpoJ', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000A524F4C455F41444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740005636C692D31737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000474000D726573706F6E73655F74797065740004636F646574000C72656469726563745F75726974001568747470733A2F2F7777772E62616964752E636F6D740009636C69656E745F696471007E001774000573636F706574000078737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000002740009524F4C455F5553455274000A524F4C455F41444D494E78017371007E0026770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007871007E001F707371007E0026770C000000103F400000000000017400057265732D31787371007E0026770C000000103F4000000000000171007E001D787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200486F72672E737072696E676672616D65776F726B2E73656375726974792E7765622E61757468656E7469636174696F6E2E57656241757468656E7469636174696F6E44657461696C7300000000000001A40200024C000D72656D6F74654164647265737371007E000E4C000973657373696F6E496471007E000E787074000F303A303A303A303A303A303A303A3174002030463536303238344334423637364245393744374336433145323544463436457073720029636F6D2E796C2E6F61757468327365727665722E636F6E6669672E4A69655573657244657461696C7300000000000000010200014C0005726F6C657371007E000878720017636F6D2E796C2E636F6D6D6F6E2E706F6A6F2E557365722E9C40FF55D8B7160200074C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0005656D61696C71007E000E4C0002696471007E000E4C000870617373776F726471007E000E4C00067374617475737400104C6A6176612F6C616E672F427974653B4C000A75706461746554696D6571007E00394C0008757365726E616D6571007E000E7872001B636F6D2E796C2E636F6D6D6F6E2E706F6A6F2E42617365506F6A6F10884714A6D1145F020000787070707400013274003C243261243130243578524F485863394C666C792F71334D58714B46307572764D3464412E615066707854553065697165306633766467667972533457707074000561646D696E7371007E000B0000000177040000000173720017636F6D2E796C2E636F6D6D6F6E2E706F6A6F2E526F6C65E2523038192FFAFF0200044C000A63726561746554696D6571007E00394C0002696471007E000E4C00046E616D6571007E000E4C000A75706461746554696D6571007E00397871007E003B707400013274000541444D494E7078);

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

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
INSERT INTO `resource` VALUES ('1', '/admin', '2019-05-09 12:45:12', '2019-05-09 12:45:12');
INSERT INTO `resource` VALUES ('2', '/user', '2019-05-09 12:45:12', '2019-05-09 12:45:12');
INSERT INTO `resource` VALUES ('3', '/hello', '2019-05-09 12:45:12', '2019-05-09 12:45:12');
INSERT INTO `resource` VALUES ('4', '/', '2019-05-09 12:45:12', '2019-05-09 12:45:12');

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
INSERT INTO `role` VALUES ('1', 'USER', '2019-05-09 12:45:12', '2019-05-09 12:45:12');
INSERT INTO `role` VALUES ('2', 'ADMIN', '2019-05-09 12:45:12', '2019-05-09 12:45:12');

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
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(255) NOT NULL,
  `operate_user` varchar(255) DEFAULT NULL,
  `clazz_name` varchar(255) DEFAULT NULL,
  `clazzSimple_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `modular` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `log_content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('2407416c29f411ea8b3e10c37b4ae890', 'admin', 'com.yl.userservice.controller.UserController', 'UserController', 'getUserById', 'user', '-1', '{\"e\" : \"1\"}', '2019-12-29 12:31:57');
INSERT INTO `sys_log` VALUES ('3a11a64529f411ea8b3e10c37b4ae890', 'anonymous', 'com.yl.userservice.controller.UserRegistController', 'UserRegistController', 'addUser', 'user', '-1', '{\"errorList\" {username = 123, password = 123, client_id = 123, client_secret = 123, grant_type = null, }\"mesList\" {autoGrowNestedPaths = true, autoGrowCollectionLimit = 256,}', '2019-12-29 12:32:34');

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
INSERT INTO `user` VALUES ('0906d4be29ec11ea8b3e10c37b4ae890', '123', '$2a$10$F3ulyu6ktRMtUkeW2TaMAuujNyJOcvMJdXr/x5VEoTFUG/GDqPSsK', '2019-12-29 11:33:55', '2019-12-29 11:33:55', null, null);
INSERT INTO `user` VALUES ('1', 'zhangsan', '$2a$10$5xROHXc9Lfly/q3MXqKF0urvM4dA.aPfpxTU0eiqe0f3vdgfyrS4W', '2019-05-09 12:45:12', '2019-05-09 12:45:12', null, null);
INSERT INTO `user` VALUES ('165ae95629e211ea8b3e10c37b4ae890', '123', '$2a$10$KDSg1.84.9iT1zVijRGAXejfVTcrRBgEWyq5B.w31NW.PWmV1A/6u', '2019-12-29 10:22:43', '2019-12-29 10:22:43', null, null);
INSERT INTO `user` VALUES ('2', 'admin', '$2a$10$5xROHXc9Lfly/q3MXqKF0urvM4dA.aPfpxTU0eiqe0f3vdgfyrS4W', '2019-05-09 12:45:12', '2019-05-09 12:45:12', null, null);
INSERT INTO `user` VALUES ('2b4835d9249711eab9f310c37b4ae890', 'yangjie', '$2a$10$ncWVxuyVySP1AV.J2ulyJ.wUyduvha2CUPyMT1YI30rPLXRXtyY3K', '2019-12-22 16:43:52', '2019-12-22 16:43:52', null, null);
INSERT INTO `user` VALUES ('39e4bd1829f411ea8b3e10c37b4ae890', '123', '$2a$10$dQ9ZwXivnGTo.2y2UCQceOkFdv1gid60RwN.ElEwFd7jQ6SNhbd2W', '2019-12-29 12:32:33', '2019-12-29 12:32:33', null, null);
INSERT INTO `user` VALUES ('638edd7e29f011ea8b3e10c37b4ae890', '123', '$2a$10$fS.92Ah5UxV3207byBNm.O/iro/I6unpzNFUSdlXrwMDdPOiSkNHq', '2019-12-29 12:05:05', '2019-12-29 12:05:05', null, null);
INSERT INTO `user` VALUES ('82d950d529e811ea8b3e10c37b4ae890', '123', '$2a$10$J7.0JwPltd7HfxXgCnqVfOA3HpiipcyFyznKsBWWsiOxrqEZKhu9a', '2019-12-29 11:08:42', '2019-12-29 11:08:42', null, null);
INSERT INTO `user` VALUES ('8978af8f29ec11ea8b3e10c37b4ae890', '123', '$2a$10$PnM56dhZz0ytQ6Rt4CkcReKeZvPLSWk3vwgQmCHh4fKhwRzQUXHim', '2019-12-29 11:37:31', '2019-12-29 11:37:31', null, null);
INSERT INTO `user` VALUES ('8a41b91329ec11ea8b3e10c37b4ae890', '123', '$2a$10$mCcvM5n8CSWLNxLn6VPPgOmf5vugEBWgrDpjEiHpMaI/C.iHIoz1O', '2019-12-29 11:37:32', '2019-12-29 11:37:32', null, null);
INSERT INTO `user` VALUES ('908795ba29ec11ea8b3e10c37b4ae890', '123', '$2a$10$RP2jRAnW5xm2.0lvM9CaGeAgoc.5ejZqGDd35xJJy5zS50Yd61sZS', '2019-12-29 11:37:43', '2019-12-29 11:37:43', null, null);
INSERT INTO `user` VALUES ('96f1e1b729e811ea8b3e10c37b4ae890', '123', '$2a$10$Ut6Uxv3p5QoOmW5/wuQb/.LxcaYI9pU1y8GkdD0k7RUClMbwyFelm', '2019-12-29 11:09:16', '2019-12-29 11:09:16', null, null);
INSERT INTO `user` VALUES ('aec1f90c28a311ea8f6810c37b4ae890', 'yangjie', '$2a$10$gJno2OdTvaPVnEB3jGqrwO8uR8RwbcGbOFzwsicZAIm.B2yLZhxQq', '2019-12-27 20:23:36', '2019-12-27 20:23:36', null, null);
INSERT INTO `user` VALUES ('d8179ee229eb11ea8b3e10c37b4ae890', '123', '$2a$10$u3zqYpImyAOQzZKY0LCutOZMGVhHvgbSCPp2n1jp08.7PlW8Y10Ca', '2019-12-29 11:32:33', '2019-12-29 11:32:33', null, null);
INSERT INTO `user` VALUES ('d9894eba29e811ea8b3e10c37b4ae890', '123', '$2a$10$LMDizfQ41ddiA1sJnvXABu1UgwZy.j9redXdvRgEKLfTCEHX9PYca', '2019-12-29 11:11:07', '2019-12-29 11:11:07', null, null);
INSERT INTO `user` VALUES ('f523fc4d29e711ea8b3e10c37b4ae890', '123', '$2a$10$M4TKKc2Ty0Jfg4CZVmiyveAFqQuD7pnFf6hUHa0tNP3jish/DdZcW', '2019-12-29 11:04:44', '2019-12-29 11:04:44', null, null);
INSERT INTO `user` VALUES ('fef26c1629e611ea8b3e10c37b4ae890', '123', '$2a$10$s4v4Sd564.xmAXuw6C07Wu2qde5pNKP19Kz3jIdRdeRdRu8adaZ6.', '2019-12-29 10:57:51', '2019-12-29 10:57:51', null, null);

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
