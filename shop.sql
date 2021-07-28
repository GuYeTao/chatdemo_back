/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 28/07/2021 14:09:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_ transportlist
-- ----------------------------
DROP TABLE IF EXISTS `t_ transportlist`;
CREATE TABLE `t_ transportlist`  (
  `transportId` int(11) NOT NULL AUTO_INCREMENT COMMENT '运单号',
  `orderId` int(11) NULL DEFAULT NULL COMMENT '订单号',
  `riderId` int(11) NULL DEFAULT NULL COMMENT '运单的配送骑手id',
  `transportState` bit(1) NULL DEFAULT NULL COMMENT '运单状态（待收货、待评价）',
  `transportDeliverTime` datetime NULL DEFAULT NULL COMMENT '运单发货时间',
  `transportArriveTime` datetime NULL DEFAULT NULL COMMENT '运单送达时间',
  PRIMARY KEY (`transportId`) USING BTREE,
  INDEX `riderId`(`riderId`) USING BTREE,
  INDEX `t_ transportlist_ibfk_1`(`orderId`) USING BTREE,
  CONSTRAINT `t_ transportlist_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `t_orderlist` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_ transportlist_ibfk_2` FOREIGN KEY (`riderId`) REFERENCES `t_rider` (`riderId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address`  (
  `addressId` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '该地址对应的用户名',
  `addressUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `addressSite` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `addressTel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货号码',
  PRIMARY KEY (`addressId`) USING BTREE,
  INDEX `t_address_ibfk_1`(`userId`) USING BTREE,
  CONSTRAINT `t_address_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart`  (
  `cartId` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '购物车所属用户id',
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '购物车中商品id',
  `cartNum` int(11) NULL DEFAULT NULL COMMENT '购买商品数量',
  PRIMARY KEY (`cartId`) USING BTREE,
  INDEX `t_cart_ibfk_1`(`userId`) USING BTREE,
  INDEX `t_cart_ibfk_2`(`goodsId`) USING BTREE,
  CONSTRAINT `t_cart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_cart_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`goodsId`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_chat`;
CREATE TABLE `t_chat`  (
  `chatId` int(11) NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `merchantId` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `chatTime` datetime NULL DEFAULT NULL COMMENT '聊天内容发送时间',
  `chatMsg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聊天内容',
  `chatWho` bit(1) NULL DEFAULT NULL COMMENT '判断是用户说的话还是商家说的话',
  `del` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`chatId`) USING BTREE,
  INDEX `t_chat_ibfk_1`(`userId`) USING BTREE,
  INDEX `t_chat_ibfk_2`(`merchantId`) USING BTREE,
  CONSTRAINT `t_chat_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_chat_ibfk_2` FOREIGN KEY (`merchantId`) REFERENCES `t_merchant` (`merchantId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 424 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluate`;
CREATE TABLE `t_evaluate`  (
  `evaluateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id（楼顶）',
  `userId` int(11) NULL DEFAULT NULL COMMENT '写评价的用户id',
  `evaluateMsg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `evaluateTime` datetime NULL DEFAULT NULL COMMENT '发表评价时间',
  `evaluateRepId` int(11) NULL DEFAULT NULL COMMENT '评价回复的评价的id（上一个楼顶、自连接）',
  PRIMARY KEY (`evaluateId`) USING BTREE,
  INDEX `evaluateRepId`(`evaluateRepId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `t_evaluate_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_evaluate_ibfk_2` FOREIGN KEY (`evaluateRepId`) REFERENCES `t_evaluate` (`evaluateId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_evaluateindex
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluateindex`;
CREATE TABLE `t_evaluateindex`  (
  `elaIndexId` int(11) NOT NULL AUTO_INCREMENT COMMENT '索引id',
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `evaluateId` int(11) NULL DEFAULT NULL COMMENT '对商品的评价id',
  PRIMARY KEY (`elaIndexId`) USING BTREE,
  INDEX `t_evaluateindex_ibfk_2`(`evaluateId`) USING BTREE,
  INDEX `t_evaluateindex_ibfk_3`(`goodsId`) USING BTREE,
  CONSTRAINT `t_evaluateindex_ibfk_2` FOREIGN KEY (`evaluateId`) REFERENCES `t_evaluate` (`evaluateId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_evaluateindex_ibfk_3` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `typeId` int(11) NULL DEFAULT NULL COMMENT '商品种类id',
  `goodsName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片链接',
  `goodsDetail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsStorage` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `goodsSale` int(11) NULL DEFAULT NULL COMMENT '商品销量',
  `goodsPrice` double NULL DEFAULT NULL COMMENT '商品价格',
  `goodsGrade` double NULL DEFAULT NULL COMMENT '商品评分',
  `goodsGradeNumber` int(11) NULL DEFAULT NULL COMMENT '参与评分人数',
  `goodsCreateTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品上架时间',
  `goodsState` bit(1) NULL DEFAULT NULL COMMENT '商品状态（是否在销售状态）',
  `goodsCollectNumber` int(11) NULL DEFAULT NULL COMMENT '商品收藏量',
  PRIMARY KEY (`goodsId`) USING BTREE,
  INDEX `t_goods_ibfk_1`(`typeId`) USING BTREE,
  CONSTRAINT `t_goods_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_goodstype` (`typeId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `t_goodstype`;
CREATE TABLE `t_goodstype`  (
  `typeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类id',
  `typeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类名',
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_gtotlist
-- ----------------------------
DROP TABLE IF EXISTS `t_gtotlist`;
CREATE TABLE `t_gtotlist`  (
  `gtotId` int(11) NOT NULL AUTO_INCREMENT COMMENT '运单里一种商品的id',
  `orderId` int(11) NULL DEFAULT NULL COMMENT '订单号',
  `transportId` int(11) NULL DEFAULT NULL COMMENT '运单号',
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `gtotSaleNum` int(11) NULL DEFAULT NULL COMMENT '销售量',
  `gtotEvaluateState` bit(1) NULL DEFAULT NULL COMMENT '该订单该运单该商品是否被评价',
  PRIMARY KEY (`gtotId`) USING BTREE,
  INDEX `t_gtotlist_ibfk_1`(`orderId`) USING BTREE,
  INDEX `t_gtotlist_ibfk_2`(`goodsId`) USING BTREE,
  INDEX `t_gtotlist_ibfk_3`(`transportId`) USING BTREE,
  CONSTRAINT `t_gtotlist_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `t_orderlist` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_gtotlist_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`goodsId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_gtotlist_ibfk_3` FOREIGN KEY (`transportId`) REFERENCES `t_ transportlist` (`transportId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_merchant
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant`  (
  `merchantId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `merchantName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名',
  `merchantPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家密码',
  PRIMARY KEY (`merchantId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_orderlist
-- ----------------------------
DROP TABLE IF EXISTS `t_orderlist`;
CREATE TABLE `t_orderlist`  (
  `orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `userId` int(11) NULL DEFAULT NULL COMMENT '创建订单的用户id',
  `addressId` int(11) NULL DEFAULT NULL COMMENT '订单送货地址id',
  `orderState` int(11) NULL DEFAULT NULL COMMENT '订单状态（待付款、待发货、待收货、待评价、已退货）',
  `orderCreateTime` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `t_orderlist_ibfk_1`(`userId`) USING BTREE,
  INDEX `t_orderlist_ibfk_3`(`addressId`) USING BTREE,
  CONSTRAINT `t_orderlist_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_orderlist_ibfk_3` FOREIGN KEY (`addressId`) REFERENCES `t_address` (`addressId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay`  (
  `payId` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付账单id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '支付所属用户id',
  `orderId` int(11) NULL DEFAULT NULL COMMENT '支付的订单号',
  `payWayId` int(11) NULL DEFAULT NULL COMMENT '支付方式',
  `payPrice` double NULL DEFAULT NULL COMMENT '支付价格',
  `payTime` datetime NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`payId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  INDEX `payWayId`(`payWayId`) USING BTREE,
  CONSTRAINT `t_pay_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_pay_ibfk_2` FOREIGN KEY (`orderId`) REFERENCES `t_orderlist` (`orderId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_pay_ibfk_3` FOREIGN KEY (`payWayId`) REFERENCES `t_payway` (`payWayId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_payway
-- ----------------------------
DROP TABLE IF EXISTS `t_payway`;
CREATE TABLE `t_payway`  (
  `payWayId` int(11) NOT NULL AUTO_INCREMENT,
  `payWayType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`payWayId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_pictures
-- ----------------------------
DROP TABLE IF EXISTS `t_pictures`;
CREATE TABLE `t_pictures`  (
  `picId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) NULL DEFAULT NULL,
  `pictureUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`picId`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `t_pictures_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_rider
-- ----------------------------
DROP TABLE IF EXISTS `t_rider`;
CREATE TABLE `t_rider`  (
  `riderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '骑手id',
  `riderName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '骑手名',
  `riderPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '骑手密码',
  PRIMARY KEY (`riderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `userPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `userTel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户电话',
  `userPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像的链接',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_vip
-- ----------------------------
DROP TABLE IF EXISTS `t_vip`;
CREATE TABLE `t_vip`  (
  `vipId` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员卡id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '支付所属用户id',
  `vipremainder` double NULL DEFAULT NULL COMMENT '卡内余额',
  PRIMARY KEY (`vipId`) USING BTREE,
  INDEX `t_vip_ibfk_1`(`userId`) USING BTREE,
  CONSTRAINT `t_vip_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_userinfo` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- View structure for v_cart
-- ----------------------------
DROP VIEW IF EXISTS `v_cart`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_cart` AS select `t_cart`.`cartId` AS `cartId`,`t_cart`.`userId` AS `userId`,`t_cart`.`goodsId` AS `goodsId`,`t_cart`.`cartNum` AS `cartNum`,`t_goods`.`goodsName` AS `goodsName`,`t_goods`.`goodsPicture` AS `goodsPicture`,`t_goods`.`goodsPrice` AS `goodsPrice`,`t_goods`.`goodsStorage` AS `goodsStorage`,`t_goods`.`goodsSale` AS `goodsSale` from (`t_cart` join `t_goods` on((`t_cart`.`goodsId` = `t_goods`.`goodsId`)));

-- ----------------------------
-- View structure for v_order
-- ----------------------------
DROP VIEW IF EXISTS `v_order`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_order` AS select `t_orderlist`.`orderId` AS `orderId`,`t_userinfo`.`userId` AS `userId`,`t_userinfo`.`userName` AS `userName`,`t_userinfo`.`userTel` AS `userTel`,`t_address`.`addressUser` AS `addressUser`,`t_address`.`addressSite` AS `addressSite`,`t_address`.`addressTel` AS `addressTel`,`t_orderlist`.`orderState` AS `orderState`,`t_orderlist`.`orderCreateTime` AS `orderCreateTime` from ((`t_orderlist` join `t_userinfo` on((`t_orderlist`.`userId` = `t_userinfo`.`userId`))) join `t_address` on(((`t_orderlist`.`addressId` = `t_address`.`addressId`) and (`t_userinfo`.`userId` = `t_address`.`userId`)))) where ((`t_orderlist`.`addressId` = `t_address`.`addressId`) and (`t_orderlist`.`userId` = `t_userinfo`.`userId`) and (`t_userinfo`.`userId` = `t_address`.`userId`));

-- ----------------------------
-- View structure for v_orderdetail
-- ----------------------------
DROP VIEW IF EXISTS `v_orderdetail`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_orderdetail` AS select `t_userinfo`.`userId` AS `userId`,`t_address`.`addressId` AS `addressId`,`t_orderlist`.`orderId` AS `orderId`,`t_gtotlist`.`gtotSaleNum` AS `gtotSaleNum`,`t_gtotlist`.`gtotEvaluateState` AS `gtotEvaluateState`,`t_goods`.`goodsName` AS `goodsName`,`t_goods`.`goodsPicture` AS `goodsPicture`,`t_goods`.`goodsPrice` AS `goodsPrice`,`t_goodstype`.`typeName` AS `typeName`,`t_goods`.`goodsId` AS `goodsId` from (((((`t_orderlist` join `t_userinfo` on((`t_orderlist`.`userId` = `t_userinfo`.`userId`))) join `t_address` on(((`t_orderlist`.`addressId` = `t_address`.`addressId`) and (`t_userinfo`.`userId` = `t_address`.`userId`)))) join `t_gtotlist` on((`t_orderlist`.`orderId` = `t_gtotlist`.`orderId`))) join `t_goods` on((`t_gtotlist`.`goodsId` = `t_goods`.`goodsId`))) join `t_goodstype` on((`t_goods`.`typeId` = `t_goodstype`.`typeId`))) where ((`t_orderlist`.`userId` = `t_userinfo`.`userId`) and (`t_userinfo`.`userId` = `t_address`.`userId`) and (`t_orderlist`.`addressId` = `t_address`.`addressId`) and (`t_orderlist`.`orderId` = `t_gtotlist`.`orderId`) and (`t_gtotlist`.`goodsId` = `t_goods`.`goodsId`) and (`t_goods`.`typeId` = `t_goodstype`.`typeId`));

-- ----------------------------
-- View structure for v_transport
-- ----------------------------
DROP VIEW IF EXISTS `v_transport`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_transport` AS select `t_ transportlist`.`transportId` AS `transportId`,`t_ transportlist`.`riderId` AS `riderId`,`t_ transportlist`.`transportDeliverTime` AS `transportDeliverTime`,`t_ transportlist`.`transportArriveTime` AS `transportArriveTime`,`t_ transportlist`.`transportState` AS `transportState`,`t_rider`.`riderName` AS `riderName`,`t_orderlist`.`addressId` AS `addressId`,`t_address`.`addressUser` AS `addressUser`,`t_address`.`addressSite` AS `addressSite`,`t_address`.`addressTel` AS `addressTel`,`t_orderlist`.`userId` AS `userId`,`t_ transportlist`.`orderId` AS `orderId` from (((`t_ transportlist` join `t_rider`) join `t_orderlist`) join `t_address`) where ((`t_orderlist`.`orderId` = `t_ transportlist`.`orderId`) and (`t_address`.`addressId` = `t_orderlist`.`addressId`) and (`t_ transportlist`.`riderId` = `t_rider`.`riderId`));

-- ----------------------------
-- View structure for v_transportdetail
-- ----------------------------
DROP VIEW IF EXISTS `v_transportdetail`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_transportdetail` AS select `t_ transportlist`.`transportId` AS `transportId`,`t_orderlist`.`orderId` AS `orderId`,`t_orderlist`.`userId` AS `userId`,`t_ transportlist`.`transportDeliverTime` AS `transportDeliverTime`,`t_ transportlist`.`transportArriveTime` AS `transportArriveTime`,`t_ transportlist`.`riderId` AS `riderId`,`t_gtotlist`.`goodsId` AS `goodsId`,`t_gtotlist`.`gtotSaleNum` AS `gtotSaleNum`,`t_goods`.`goodsName` AS `goodsName`,`t_goodstype`.`typeName` AS `typeName`,`t_goods`.`goodsPicture` AS `goodsPicture`,`t_ transportlist`.`transportState` AS `transportState` from ((((`t_ transportlist` join `t_orderlist` on((`t_ transportlist`.`orderId` = `t_orderlist`.`orderId`))) join `t_gtotlist` on(((`t_orderlist`.`orderId` = `t_gtotlist`.`orderId`) and (`t_ transportlist`.`transportId` = `t_gtotlist`.`transportId`)))) join `t_goods` on((`t_gtotlist`.`goodsId` = `t_goods`.`goodsId`))) join `t_goodstype` on((`t_goods`.`typeId` = `t_goodstype`.`typeId`))) where ((`t_orderlist`.`orderId` = `t_ transportlist`.`orderId`) and (`t_orderlist`.`orderId` = `t_gtotlist`.`orderId`) and (`t_ transportlist`.`transportId` = `t_gtotlist`.`transportId`) and (`t_gtotlist`.`goodsId` = `t_goods`.`goodsId`) and (`t_goods`.`typeId` = `t_goodstype`.`typeId`));

SET FOREIGN_KEY_CHECKS = 1;
