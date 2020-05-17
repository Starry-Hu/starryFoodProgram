/*
 Navicat Premium Data Transfer

 Source Server         : starry_food
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : starryfood

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/05/2020 09:15:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员uuid',
  `admin_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `admin_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员名称\r\n',
  `admin_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员账户密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '管理员账户创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '管理员账户更新时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `is_del` int(1) NULL DEFAULT 0 COMMENT '是否删除  是则为1 否则为0',
  PRIMARY KEY (`admin_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '管理员', 'admin', '2019-07-03 22:59:51', NULL, '1', NULL, 0);
INSERT INTO `admin` VALUES ('285D6EA6CDD74108AEE77EF35B7F2E31', 'adminDelete', '测试删除', '123', '2019-12-04 15:48:44', '2019-12-12 22:10:14', '1', '1', 1);
INSERT INTO `admin` VALUES ('7694B15218AA47A9B54E6349FE0FC174', '18830258065', '胡胡胡', '123456', '2019-12-04 15:42:14', NULL, '1', NULL, 0);
INSERT INTO `admin` VALUES ('8CC97E4A3C7B4A18BAD3C38039B8AC8C', 'admin2', 'yj', '123', '2019-12-04 08:43:43', '2019-12-04 15:46:39', '1', '1', 0);

-- ----------------------------
-- Table structure for cart_food
-- ----------------------------
DROP TABLE IF EXISTS `cart_food`;
CREATE TABLE `cart_food`  (
  `cart_food_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '购物车与菜品关系这个表的主键',
  `cart_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '对应的购物车id',
  `food_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '对应的菜品id',
  `food_num` int(11) NULL DEFAULT NULL COMMENT '对应的菜品数量',
  `food_one_total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '对应的该类菜品的总价格',
  PRIMARY KEY (`cart_food_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_food
-- ----------------------------
INSERT INTO `cart_food` VALUES ('0FB553B6A9EB4DEB98F926C0185F6E4F', '1', '6', 2, 60.00);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的uuid',
  `customer_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号id',
  `customer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `customer_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码 ',
  `customer_cart_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '购物车id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` int(1) NULL DEFAULT 0 COMMENT '是否删除  是为1 否为0',
  PRIMARY KEY (`customer_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '123', '哈啊哈哈', '123', '1', '2019-07-03 21:47:30', '2019-12-03 15:41:31', 0);
INSERT INTO `customer` VALUES ('2', '12345', '啥啥啥', '544', '12343', '2019-11-13 01:29:39', '2019-11-22 16:06:50', 0);
INSERT INTO `customer` VALUES ('3417BA636C284B0592A88BB5F4EE46AF', '1234', 'ssdae', '12345', 'DDDD36EE1E2A40278E6B2C11B031C173', '2019-11-22 14:55:15', '2019-11-22 14:56:04', 0);
INSERT INTO `customer` VALUES ('3A4E057B10BC4C6BB6224CD52DC5E1CF', '111', '111', '111', '92DA5C8DBDA146EF9DFBB4A2BE682664', '2019-07-04 23:02:39', '2019-11-24 15:37:08', 0);
INSERT INTO `customer` VALUES ('7F629C4978BA4FE9811619EC284EB87D', 'qwe', '顾客1', '123', '249F1078EF614901B30D04A9726CDFE9', '2019-12-04 15:52:17', NULL, 0);
INSERT INTO `customer` VALUES ('CEBB17B0A35541E39C13A6A6F4F9BDDF', '123456', '哈哈哈22', '123456', '6388E10167794D89B6AEC0470E4F71B3', '2019-11-22 14:52:05', '2019-12-04 15:51:39', 1);
INSERT INTO `customer` VALUES ('D851E515A9304E93ADD46AF8F9EDEF3B', '13324567389', '哈哈哈', '123456', 'A8EAEBDAE6C54169802C515FAE028355', '2019-11-22 14:49:17', '2019-11-22 16:06:47', 1);

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `food_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜品的id',
  `food_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `food_kind_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜品所属种类id',
  `food_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `food_measurement` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格/份...',
  `food_introduce` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '介绍',
  `food_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示的图片路径',
  `food_has_sold` int(11) NULL DEFAULT NULL COMMENT '已销售量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `is_del` int(1) NULL DEFAULT 0 COMMENT '是否删除  是为1 否为0',
  PRIMARY KEY (`food_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('018AE49756524705BC9F2CC5B6B00BA7', '荷包蛋吐司', '018AE49756524705BC9F2CC5B6B00BA7', 12.00, '/个', '啊士大夫', 'images/5.png', NULL, '2019-12-04 17:00:01', NULL, '1', NULL, 0);
INSERT INTO `food` VALUES ('1', '减脂鸡胸肉', '650867FB1F39452FB2DFE199E4817F96', 33.00, '/份', '鸡胸脯肉蛋白质含量较高，且易被人体吸收入利用，有增强体力，强壮身体的作用，所含对人体生长发育有重要作用的磷脂类，是中国人膳食结构中脂肪和磷脂的重要来源之一。因为鸡胸脯肉是高蛋白，低脂肪的食材，所以对正在减肥没你来说一定是一个不错的选择。', 'images/4.png', 16, '2019-07-02 11:28:42', '2019-12-04 15:15:58', '1', '1', 0);
INSERT INTO `food` VALUES ('2', '鸡肉咖喱沙拉2222', '018AE49756524705BC9F2CC5B6B00BA7', 14.00, '/份', '有机鸡肉咖喱沙拉，既有营养又口感丰富，有机鸡肉口感嫩滑，咖喱和苹果醋的香气相得益彰，鸡肉、法诺和坚果的搭配正好软硬适中。', 'images/3.png', 20, '2019-07-03 19:16:38', '2019-12-04 15:16:29', '1', '1', 0);
INSERT INTO `food` VALUES ('3', '奶油蘑菇意面', '855E8046B23344E9878F292FBB6F70B3', 28.00, '/份', '奶油蘑菇意面主要是以蘑菇，意大利面为主要食材的菜品，千万不要以为是白酱就觉得淡而无味，相反，味道特别鲜美，入口是厚重的奶香，其中有蘑菇的鲜味，培根的香味，最后是调味和奶油香气收尾，配合的特别完美。', 'images/1.png', 22, '2019-07-05 00:20:26', '2019-12-04 15:14:39', '1', '1', 0);
INSERT INTO `food` VALUES ('4', '培根披萨', '66CE24CC1C65401AAC4922164EBF1D69', 32.00, '/8寸', '绝对环保又美味的鲜虾培根披萨,从打饼胚、炒披萨酱到蔬菜培根脱水、刨芝士丝,一切的一切都是自己亲手操作,瞧瞧尧同学啃得多香啊! ', 'images/menu-7.jpg', 16, '2019-07-05 10:29:19', '2019-12-04 15:16:18', '1', '1', 0);
INSERT INTO `food` VALUES ('5', '青菜拉面', '855E8046B23344E9878F292FBB6F70B3', 15.00, '/份', '青菜圆蛤拉面是以圆蛤、拉面为原料的菜品。10个，拉面：适量，青菜：适量，盐：少许，鸡精：少许，芝麻油：一勺。', 'images/menu-9.jpg', 12, '2019-07-05 10:38:08', NULL, '1', '', 0);
INSERT INTO `food` VALUES ('569160D760174772B6AF45E1A81C83AD', 'hahha', '12', 12.00, '/个', '简介', 'images/5.png', NULL, '2019-11-22 16:06:05', '2019-11-22 16:06:23', '1', '1', 1);
INSERT INTO `food` VALUES ('5B2AB928268849F8BEDBBA54A57F58D8', 'hshfaj', '917F3D0C3A1E4C1FBCDEA0696D7E8324', 12.00, '/个', '测试简介', 'images/menu-4.jpg', NULL, '2019-12-04 17:02:59', '2019-12-04 17:03:22', '1', '1', 0);
INSERT INTO `food` VALUES ('6', '鲜虾披萨', '66CE24CC1C65401AAC4922164EBF1D69', 30.00, '/8寸', '至尊鲜虾披萨是以 面粉、牛奶 、盐、砂糖等食材制成的一道美食。调料主要为砂糖、干酵母、黄油，该道菜通过将食材放入烤箱烘焙制作而成。', 'images/menu-16.jpg', 26, '2019-07-05 10:40:09', '2019-12-04 15:15:35', '1', '1', 0);
INSERT INTO `food` VALUES ('7', '橄榄油版面', '855E8046B23344E9878F292FBB6F70B3', 12.00, '/份', '橄榄油版面橄榄油版面橄榄油版面橄榄油版面制作而成。', 'images/menu-2.jpg', 15, '2019-07-05 11:43:30', '2019-12-04 11:24:43', '1', '1', 0);

-- ----------------------------
-- Table structure for food_kind
-- ----------------------------
DROP TABLE IF EXISTS `food_kind`;
CREATE TABLE `food_kind`  (
  `food_kind_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜品种类id',
  `food_kind_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜品种类名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '菜品种类创建时间\r\n',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '菜品种类修改时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `is_del` int(1) NULL DEFAULT 0 COMMENT '是否删除 0为否，1为是',
  PRIMARY KEY (`food_kind_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food_kind
-- ----------------------------
INSERT INTO `food_kind` VALUES ('018AE49756524705BC9F2CC5B6B00BA7', '甜品', '2019-12-04 15:12:57', '1', NULL, NULL, 0);
INSERT INTO `food_kind` VALUES ('12', '甜品2', '2019-12-02 17:08:30', '1', '2019-12-04 15:19:38', '1', 1);
INSERT INTO `food_kind` VALUES ('4D3CC2600C42413D8BC7F5EBBF9A9925', '测试菜品种类22', '2019-12-12 21:53:43', '1', '2019-12-12 21:55:32', '1', 1);
INSERT INTO `food_kind` VALUES ('650867FB1F39452FB2DFE199E4817F96', '肉', '2019-12-04 15:12:40', '1', NULL, NULL, 0);
INSERT INTO `food_kind` VALUES ('66CE24CC1C65401AAC4922164EBF1D69', '披萨', '2019-12-03 11:31:23', '1', '2019-12-04 15:16:42', '1', 0);
INSERT INTO `food_kind` VALUES ('855E8046B23344E9878F292FBB6F70B3', '面条', '2019-12-03 18:08:04', '1', NULL, NULL, 0);
INSERT INTO `food_kind` VALUES ('917F3D0C3A1E4C1FBCDEA0696D7E8324', '主食2', '2019-12-04 16:05:29', '1', '2019-12-04 17:13:07', '1', 0);

-- ----------------------------
-- Table structure for order_food
-- ----------------------------
DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food`  (
  `order_food_uuid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'uuid',
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `food_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选择的菜品id',
  `food_num` int(11) NULL DEFAULT NULL COMMENT '选择的菜品数量',
  `food_one_total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '选择的该类菜品总价格',
  PRIMARY KEY (`order_food_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_food
-- ----------------------------
INSERT INTO `order_food` VALUES ('22C70CAF03804F97B7380F292F60C027', 'B6A71CED86D342C8A47F7F10027742C3', '4', 1, 32.00);
INSERT INTO `order_food` VALUES ('35710FA36BF34AD394EC67E87C154B58', 'E870A3F41FA2490D94C28500697E94A1', '2', 1, 14.00);
INSERT INTO `order_food` VALUES ('5006B99039204BFFA215F11E2096E2BA', 'EA338F6CB05941FD82B432912A3CFFDD', '6', 1, 30.00);
INSERT INTO `order_food` VALUES ('5666EF8C6221493DBF82540C829D4568', 'E870A3F41FA2490D94C28500697E94A1', '7', 1, 12.00);
INSERT INTO `order_food` VALUES ('60A8384DB9D04521994B05E8F1024EF9', '7568258706FA4B6EA953355BC725C764', '1', 3, 99.00);
INSERT INTO `order_food` VALUES ('7FE7FA85F1D04504A0957BC747C0BA38', '8369738F825F46B7BC2C74EA0A47E7AE', '5', 1, 15.00);
INSERT INTO `order_food` VALUES ('B01D0439F5D04C549ADDBE4CCD7DBD10', '7568258706FA4B6EA953355BC725C764', '5B2AB928268849F8BEDBBA54A57F58D8', 1, 12.00);
INSERT INTO `order_food` VALUES ('D26D80F59C424E15B1D8304A987A481A', '8369738F825F46B7BC2C74EA0A47E7AE', '2', 1, 14.00);

-- ----------------------------
-- Table structure for order_make
-- ----------------------------
DROP TABLE IF EXISTS `order_make`;
CREATE TABLE `order_make`  (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单id',
  `order_create_customer` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '顾客id',
  `order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间（下单时间）',
  `order_sum_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价（所有菜品的）',
  `order_deal_admin` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理者',
  `order_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最近更新时间',
  `order_condition` int(1) NULL DEFAULT NULL COMMENT '订单状态  0等待接单 1已接单制作中 2完成制作等待支付 3支付完成',
  `is_del` int(1) NULL DEFAULT 0 COMMENT '是否删除  是为1  否为0',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_make
-- ----------------------------
INSERT INTO `order_make` VALUES ('7568258706FA4B6EA953355BC725C764', '1', '2019-12-12 21:47:32', 111.00, NULL, NULL, 0, 0);
INSERT INTO `order_make` VALUES ('8369738F825F46B7BC2C74EA0A47E7AE', '1', '2019-12-04 17:12:43', 29.00, '1', '2019-12-05 21:47:58', 3, 0);
INSERT INTO `order_make` VALUES ('B6A71CED86D342C8A47F7F10027742C3', '2', '2019-12-04 15:58:16', 32.00, NULL, NULL, 0, 0);
INSERT INTO `order_make` VALUES ('E870A3F41FA2490D94C28500697E94A1', '2', '2019-12-04 17:08:53', 26.00, NULL, NULL, 0, 0);
INSERT INTO `order_make` VALUES ('EA338F6CB05941FD82B432912A3CFFDD', '1', '2019-12-03 16:15:26', 30.00, '1', '2019-12-04 15:40:22', 3, 0);

SET FOREIGN_KEY_CHECKS = 1;
