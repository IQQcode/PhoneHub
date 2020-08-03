/*
 Navicat Premium Data Transfer

 Source Server         : Mr.Q
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db_phone_store

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 02/08/2020 18:54:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer_address
-- ----------------------------
DROP TABLE IF EXISTS `buyer_address`;
CREATE TABLE `buyer_address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `area_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址编码',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer_address
-- ----------------------------
INSERT INTO `buyer_address` VALUES (35, 'iqqcode', '13636363636', '陕西省西安市临潼区123号', '710048', '2020-07-31 19:03:18', '2020-07-31 19:03:18');
INSERT INTO `buyer_address` VALUES (36, '小Q', '13678787878', '内蒙古呼和浩特市赛罕塔拉区123号', '014100', '2020-08-01 14:58:09', '2020-08-01 14:55:46');
INSERT INTO `buyer_address` VALUES (37, 'Jack', '13678789632', '浙江省杭州市西湖区123号路456单元', '456899', '2020-08-02 15:58:44', '2020-08-02 15:58:04');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `phone_id` int(11) NULL DEFAULT NULL COMMENT '商品编号',
  `phone_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `phone_quantity` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `phone_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品小图',
  `specs_id` int(11) NULL DEFAULT NULL COMMENT '规格编号',
  `specs_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格名称',
  `specs_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '规格单价',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态，默认0未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('123456', '张三', '13678787878', '广东省深圳市罗湖区科技路123号456室', 1, 'Honor 8A', 1, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', 1, '32GB', 320000.00, 6400.00, 1, '2020-08-01 16:26:12', '2020-08-02 17:04:56');
INSERT INTO `order_master` VALUES ('1586242977480760998', 'iqqcode', '13636363636', '陕西省西安市临潼区123号', 1, 'Honor 8A', 1, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', 2, '64GB', 320000.00, 6400.00, 1, '2020-08-01 16:18:17', '2020-08-02 17:04:56');
INSERT INTO `order_master` VALUES ('1596359185731247628', '张三', '13678789632', '陕西省西安市长安区123号', 1, 'Honor 8A', 1, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', 1, '32GB', 280000.00, 2810.00, 0, '2020-04-01 18:03:08', '2020-08-01 22:13:03');

-- ----------------------------
-- Table structure for phone_category
-- ----------------------------
DROP TABLE IF EXISTS `phone_category`;
CREATE TABLE `phone_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_category
-- ----------------------------
INSERT INTO `phone_category` VALUES (1, '魅焰红', 1, '2020-04-01 18:39:43', '2020-04-01 20:35:54');
INSERT INTO `phone_category` VALUES (2, '极光蓝', 2, '2020-04-01 18:39:43', '2020-04-01 20:35:54');
INSERT INTO `phone_category` VALUES (3, '铂光金', 3, '2020-04-01 18:39:43', '2020-04-01 20:35:54');
INSERT INTO `phone_category` VALUES (4, '幻夜黑', 4, '2020-04-01 18:39:43', '2020-04-01 20:35:54');

-- ----------------------------
-- Table structure for phone_info
-- ----------------------------
DROP TABLE IF EXISTS `phone_info`;
CREATE TABLE `phone_info`  (
  `phone_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `phone_price` decimal(8, 2) NOT NULL COMMENT '商品单价',
  `phone_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `phone_stock` int(11) NOT NULL COMMENT '库存',
  `phone_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `phone_tag` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`phone_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_info
-- ----------------------------
INSERT INTO `phone_info` VALUES (1, 'Honor 8A', 2800.00, '魅焰红', 5, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', 1, '2020-04-01 18:03:08', '2020-08-01 22:13:03', '720P珍珠屏&Micro USB接口');
INSERT INTO `phone_info` VALUES (2, 'Honor 10 青春版', 2800.00, '极光蓝', 100, '../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg', 2, '2020-04-01 18:03:08', '2020-04-01 22:30:42', '720P珍珠屏&EMUI9 Lite');
INSERT INTO `phone_info` VALUES (3, 'Honor V20', 3450.00, '铂光金', 100, '../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg', 3, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '2+1独立三卡槽');
INSERT INTO `phone_info` VALUES (4, 'HUAWEI Mate 20 Pro', 4550.00, '幻夜黑', 100, '../static/cb819ad9-ec6f-4123-a4e9-aa629e2f8224.jpg', 4, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '内存3GB&EMUI9 Lite');
INSERT INTO `phone_info` VALUES (5, 'HUAWEI nova 5 Pro', 5450.00, '魅焰红', 100, '../static/8a0f5be0-3c78-4f23-b58b-dc2a92f1f95a.jpg', 1, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '内存3GB&Micro USB接口');
INSERT INTO `phone_info` VALUES (6, 'HUAWEI P30', 8700.00, '极光蓝', 100, '../static/6dcad185-315f-40f0-87f2-52910f49c8b7.jpg', 2, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&内存3GB');
INSERT INTO `phone_info` VALUES (7, 'HUAWEI P30 Pro', 8988.00, '铂光金', 100, '../static/b12a46a9-3738-49ab-ab3a-6878539bd76b.jpg', 3, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&Micro USB接口');
INSERT INTO `phone_info` VALUES (8, 'HUAWEI 畅想9 Plus', 2760.00, '幻夜黑', 100, '../static/15a5dcf2-4b50-41a0-93e8-08df97c21341.jpg', 4, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '内存3GB&存储32GB');
INSERT INTO `phone_info` VALUES (9, 'SAMSUNG G S10', 7254.00, '魅焰红', 100, '../static/a4f0cef8-59da-4f7c-abfa-d373f6648035.jpg', 1, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&存储32GB');
INSERT INTO `phone_info` VALUES (10, 'OPPO K3', 2889.00, '极光蓝', 100, '../static/efc31538-a1f0-4dba-a673-4369f17e5708.jpg', 2, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '存储32GB&Micro USB接口');
INSERT INTO `phone_info` VALUES (11, 'Iphone XR', 9888.00, '铂光金', 100, '../static/4ef5a3c0-ad88-495f-a6bc-a31c1dde667b.jpg', 3, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '1300万像素&Micro USB接口');
INSERT INTO `phone_info` VALUES (12, 'MI 8', 5888.00, '幻夜黑', 100, '../static/aff8224c-3196-42a9-ae9e-4f06e20555c4.jpg', 4, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '内存3GB&存储32GB');
INSERT INTO `phone_info` VALUES (13, 'VIVO X27', 2888.00, '魅焰红', 100, '../static/cdf065ec-e409-4204-93e6-600e172e461a.jpg', 1, '2020-04-01 18:14:54', '2020-04-01 22:30:42', 'F/1.8光圈&Micro USB接口');
INSERT INTO `phone_info` VALUES (14, 'Iphone 6', 5678.00, '极光蓝', 100, '../static/899a9c64-62d0-416d-b320-e730b4585cb0.jpg', 2, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&F/1.8光圈');
INSERT INTO `phone_info` VALUES (15, 'Iphone 7', 5576.00, '铂光金', 100, '../static/67aa6e9b-681f-4a6f-aae4-97eb3ec51b08.jpg', 3, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&1300万像素');
INSERT INTO `phone_info` VALUES (16, 'Iphone 8', 6212.00, '幻夜黑', 100, '../static/a8b5b846-7fbb-4e7b-abcf-01ae73979000.jpg', 4, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '内存3GB&F/1.8光圈');
INSERT INTO `phone_info` VALUES (17, 'Meizu 16s', 1220.00, '魅焰红', 100, '../static/1a2b8e30-6e98-405f-9a18-9cd31ff96c35.jpg', 1, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '720P珍珠屏&Micro USB接口');
INSERT INTO `phone_info` VALUES (18, 'Iphone X', 6770.00, '极光蓝', 100, '../static/39197368-aeaf-48ea-b399-5ad65f7b6c47.jpg', 2, '2020-04-01 18:14:54', '2020-04-01 22:30:42', 'F/1.8光圈&Micro USB接口');
INSERT INTO `phone_info` VALUES (19, 'HUAWEI P20', 5580.00, '铂光金', 100, '../static/f382351b-7fc8-4b34-bcce-162085e75191.jpg', 3, '2020-04-01 18:14:54', '2020-04-01 22:30:42', '1300万像素&Micro USB接口');

-- ----------------------------
-- Table structure for phone_specs
-- ----------------------------
DROP TABLE IF EXISTS `phone_specs`;
CREATE TABLE `phone_specs`  (
  `specs_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `specs_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specs_stock` int(11) NOT NULL COMMENT '库存',
  `specs_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `specs_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小图',
  `specs_preview` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预览图',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`specs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_specs
-- ----------------------------
INSERT INTO `phone_specs` VALUES (1, '1', '32GB', 3, 280000.00, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', '2020-08-02 17:07:01', '2020-04-01 22:16:36');
INSERT INTO `phone_specs` VALUES (2, '1', '64GB', 3, 320000.00, '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', '../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg', '2020-08-01 22:07:13', '2020-04-01 22:16:36');

SET FOREIGN_KEY_CHECKS = 1;
