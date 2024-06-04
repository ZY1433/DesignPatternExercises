/*
 Navicat Premium Data Transfer

 Source Server         : yy
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : teashop

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 31/05/2024 13:43:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '正常',
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `c_name`(`c_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '夏日清爽', '正常');
INSERT INTO `tb_category` VALUES (2, '冬日温暖', '正常');
INSERT INTO `tb_category` VALUES (3, '果茶系列', '正常');
INSERT INTO `tb_category` VALUES (4, '咖啡系列', '正常');
INSERT INTO `tb_category` VALUES (9, '奶茶系列', '正常');
INSERT INTO `tb_category` VALUES (12, '抹茶', '移除');
INSERT INTO `tb_category` VALUES (13, '抹茶', '移除');

-- ----------------------------
-- Table structure for tb_deal
-- ----------------------------
DROP TABLE IF EXISTS `tb_deal`;
CREATE TABLE `tb_deal`  (
  `dd_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dd_date` datetime NOT NULL,
  `total` float(5, 2) NOT NULL,
  `e_id` int(11) NOT NULL,
  `isMer` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否',
  `m_id` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `point` int(11) NULL DEFAULT NULL,
  `num` int(11) NOT NULL,
  `status` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '有效',
  PRIMARY KEY (`dd_id`) USING BTREE,
  INDEX `f_emp`(`e_id`) USING BTREE,
  CONSTRAINT `tb_deal_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `tb_employe` (`e_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_deal
-- ----------------------------
INSERT INTO `tb_deal` VALUES ('202404290001', '2024-04-29 15:12:02', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202404290002', '2024-04-29 15:23:57', 44.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202404290003', '2024-04-29 17:02:21', 53.20, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202404290004', '2024-04-29 17:04:36', 714.90, 1, '否', '', 0, 65, '有效');
INSERT INTO `tb_deal` VALUES ('202404290005', '2024-04-29 17:35:35', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202404290006', '2024-04-29 17:52:51', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202404290007', '2024-04-29 17:54:59', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202404290008', '2024-04-29 17:57:14', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202404290009', '2024-04-29 19:20:47', 720.00, 1, '否', '', 0, 36, '有效');
INSERT INTO `tb_deal` VALUES ('202404290010', '2024-04-29 19:21:55', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040001', '2024-05-04 16:19:51', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040002', '2024-05-04 16:23:24', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040003', '2024-05-04 16:53:07', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040004', '2024-05-04 17:09:27', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040005', '2024-05-04 21:07:11', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040006', '2024-05-04 21:07:23', 11.40, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040007', '2024-05-04 21:11:53', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040008', '2024-05-04 21:12:06', 18.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405040009', '2024-05-04 21:13:02', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040010', '2024-05-04 21:13:54', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040011', '2024-05-04 21:18:39', 37.20, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405040012', '2024-05-04 21:18:59', 9.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040013', '2024-05-04 21:21:50', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040014', '2024-05-04 22:33:40', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040015', '2024-05-04 23:36:53', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040016', '2024-05-04 23:44:57', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405040017', '2024-05-04 23:51:57', 48.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405050001', '2024-05-05 10:01:57', 22.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405050002', '2024-05-05 10:15:40', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050003', '2024-05-05 10:49:07', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050004', '2024-05-05 11:39:16', 22.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405050005', '2024-05-05 12:03:23', 30.00, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405050006', '2024-05-05 12:10:47', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050007', '2024-05-05 12:21:57', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050008', '2024-05-05 12:27:55', 78.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405050009', '2024-05-05 13:31:37', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050010', '2024-05-05 13:34:47', 20.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405050011', '2024-05-05 13:34:54', 9.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050012', '2024-05-05 13:36:27', 27.00, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405050013', '2024-05-05 13:36:39', 27.00, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405050014', '2024-05-05 13:38:43', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050015', '2024-05-05 13:38:58', 46.00, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405050016', '2024-05-05 13:40:09', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050017', '2024-05-05 14:32:50', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050018', '2024-05-05 14:39:07', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050019', '2024-05-05 15:03:40', 42.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405050020', '2024-05-05 15:05:55', 42.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405050021', '2024-05-05 15:26:01', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405050022', '2024-05-05 15:27:21', 22.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405050023', '2024-05-05 16:16:46', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405270001', '2024-05-27 17:05:00', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405280001', '2024-05-28 15:02:26', 20.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405280002', '2024-05-28 17:49:49', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405290001', '2024-05-29 19:57:13', 26.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405300001', '2024-05-30 14:33:08', 24.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405300002', '2024-05-30 15:33:12', 56.00, 1, '否', '', 0, 4, '有效');
INSERT INTO `tb_deal` VALUES ('202405300003', '2024-05-30 18:51:39', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405300004', '2024-05-30 18:52:06', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405300005', '2024-05-30 23:13:20', 21.50, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405300006', '2024-05-30 23:15:33', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405300007', '2024-05-30 23:15:58', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405300008', '2024-05-30 23:53:23', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310001', '2024-05-31 11:53:18', 28.80, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405310002', '2024-05-31 11:55:06', 20.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405310003', '2024-05-31 11:56:32', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310004', '2024-05-31 11:56:56', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310005', '2024-05-31 11:57:14', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310006', '2024-05-31 11:57:33', 10.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310007', '2024-05-31 12:13:30', 10.80, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310008', '2024-05-31 12:14:45', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310009', '2024-05-31 12:21:33', 24.70, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405310010', '2024-05-31 12:43:43', 19.80, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405310011', '2024-05-31 12:57:50', 12.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310012', '2024-05-31 13:09:59', 19.80, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405310013', '2024-05-31 13:14:25', 30.00, 1, '否', '', 0, 2, '有效');
INSERT INTO `tb_deal` VALUES ('202405310014', '2024-05-31 13:14:46', 9.00, 1, '否', '', 0, 1, '有效');
INSERT INTO `tb_deal` VALUES ('202405310015', '2024-05-31 13:18:51', 34.20, 1, '否', '', 0, 3, '有效');
INSERT INTO `tb_deal` VALUES ('202405310016', '2024-05-31 13:36:35', 21.60, 1, '否', '', 0, 2, '有效');

-- ----------------------------
-- Table structure for tb_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_detail`;
CREATE TABLE `tb_detail`  (
  `dd_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_id` int(11) NOT NULL,
  `c_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `d_id` int(11) NOT NULL,
  `d_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` int(11) NOT NULL,
  `price` float(5, 2) NOT NULL,
  PRIMARY KEY (`dd_id`, `c_id`, `d_id`, `price`) USING BTREE,
  INDEX `f_d`(`d_id`) USING BTREE,
  INDEX `f_cid`(`c_id`) USING BTREE,
  INDEX `f_dname`(`d_name`) USING BTREE,
  INDEX `f_cname`(`c_name`) USING BTREE,
  CONSTRAINT `tb_detail_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `tb_category` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_detail_ibfk_2` FOREIGN KEY (`c_name`) REFERENCES `tb_category` (`c_name`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `tb_detail_ibfk_3` FOREIGN KEY (`dd_id`) REFERENCES `tb_deal` (`dd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_detail_ibfk_4` FOREIGN KEY (`d_name`) REFERENCES `tb_drink` (`d_name`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_detail
-- ----------------------------
INSERT INTO `tb_detail` VALUES ('202404290001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202404290002', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202404290002', 1, '夏日清爽', 8, '草莓气泡', 2, 24.00);
INSERT INTO `tb_detail` VALUES ('202404290002', 1, '夏日清爽', 9, '荔枝汽泡', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202404290003', 3, '果茶系列', 21, '草莓多多', 1, 19.00);
INSERT INTO `tb_detail` VALUES ('202404290003', 3, '果茶系列', 25, '柠檬百香果', 3, 34.20);
INSERT INTO `tb_detail` VALUES ('202404290004', 4, '咖啡系列', 15, '卡布奇诺', 7, 6.30);
INSERT INTO `tb_detail` VALUES ('202404290004', 4, '咖啡系列', 15, '卡布奇诺', 3, 54.00);
INSERT INTO `tb_detail` VALUES ('202404290004', 4, '咖啡系列', 15, '卡布奇诺', 15, 216.00);
INSERT INTO `tb_detail` VALUES ('202404290004', 9, '奶茶系列', 39, '黑砖奶茶', 4, 48.00);
INSERT INTO `tb_detail` VALUES ('202404290004', 9, '奶茶系列', 39, '黑砖奶茶', 11, 105.60);
INSERT INTO `tb_detail` VALUES ('202404290004', 9, '奶茶系列', 39, '黑砖奶茶', 25, 285.00);
INSERT INTO `tb_detail` VALUES ('202404290005', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202404290006', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202404290007', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202404290008', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202404290009', 1, '夏日清爽', 2, '芒果汽泡', 36, 720.00);
INSERT INTO `tb_detail` VALUES ('202404290010', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405040001', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405040002', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040003', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040004', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040005', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040006', 1, '夏日清爽', 8, '草莓气泡', 1, 11.40);
INSERT INTO `tb_detail` VALUES ('202405040007', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405040008', 1, '夏日清爽', 4, '翠峰茉莉', 2, 18.00);
INSERT INTO `tb_detail` VALUES ('202405040009', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040010', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405040011', 1, '夏日清爽', 4, '翠峰茉莉', 1, 7.20);
INSERT INTO `tb_detail` VALUES ('202405040011', 1, '夏日清爽', 4, '翠峰茉莉', 1, 8.00);
INSERT INTO `tb_detail` VALUES ('202405040011', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405040011', 1, '夏日清爽', 4, '翠峰茉莉', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040012', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405040013', 9, '奶茶系列', 11, '布丁奶茶', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040015', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405040016', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405040017', 1, '夏日清爽', 8, '草莓气泡', 4, 48.00);
INSERT INTO `tb_detail` VALUES ('202405050001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405050001', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050002', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050003', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050004', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050004', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405050005', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050005', 2, '冬日温暖', 3, '红糖枸杞', 2, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050006', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050007', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050008', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050008', 1, '夏日清爽', 2, '芒果汽泡', 1, 22.00);
INSERT INTO `tb_detail` VALUES ('202405050008', 1, '夏日清爽', 2, '芒果汽泡', 2, 36.00);
INSERT INTO `tb_detail` VALUES ('202405050009', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050010', 2, '冬日温暖', 3, '红糖枸杞', 2, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050011', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405050012', 1, '夏日清爽', 4, '翠峰茉莉', 3, 27.00);
INSERT INTO `tb_detail` VALUES ('202405050013', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405050013', 2, '冬日温暖', 3, '红糖枸杞', 2, 18.00);
INSERT INTO `tb_detail` VALUES ('202405050014', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405050015', 3, '果茶系列', 23, '巨峰葡萄', 1, 16.00);
INSERT INTO `tb_detail` VALUES ('202405050015', 3, '果茶系列', 23, '巨峰葡萄', 1, 18.00);
INSERT INTO `tb_detail` VALUES ('202405050015', 3, '果茶系列', 24, '冰霜西瓜汁', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405050016', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050017', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405050018', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050019', 9, '奶茶系列', 28, '珍珠奶茶', 1, 8.00);
INSERT INTO `tb_detail` VALUES ('202405050019', 9, '奶茶系列', 28, '珍珠奶茶', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050019', 9, '奶茶系列', 28, '珍珠奶茶', 2, 24.00);
INSERT INTO `tb_detail` VALUES ('202405050020', 9, '奶茶系列', 28, '珍珠奶茶', 1, 8.00);
INSERT INTO `tb_detail` VALUES ('202405050020', 9, '奶茶系列', 28, '珍珠奶茶', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050020', 9, '奶茶系列', 28, '珍珠奶茶', 2, 24.00);
INSERT INTO `tb_detail` VALUES ('202405050021', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050022', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405050022', 9, '奶茶系列', 27, '草莓奶茶', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405050023', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405270001', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405280001', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405280002', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405290001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405290001', 4, '咖啡系列', 16, '摩卡咖啡', 1, 14.00);
INSERT INTO `tb_detail` VALUES ('202405300001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405300001', 2, '冬日温暖', 26, '可乐煲姜', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405300002', 1, '夏日清爽', 2, '芒果汽泡', 1, 20.00);
INSERT INTO `tb_detail` VALUES ('202405300002', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405300002', 3, '果茶系列', 24, '冰霜西瓜汁', 2, 24.00);
INSERT INTO `tb_detail` VALUES ('202405300004', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405300005', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405300005', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.50);
INSERT INTO `tb_detail` VALUES ('202405300006', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405300007', 2, '冬日温暖', 3, '红糖枸杞', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405300008', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405310001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405310001', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.60);
INSERT INTO `tb_detail` VALUES ('202405310001', 1, '夏日清爽', 4, '翠峰茉莉', 1, 7.20);
INSERT INTO `tb_detail` VALUES ('202405310002', 9, '奶茶系列', 20, '焦糖奶茶', 2, 20.00);
INSERT INTO `tb_detail` VALUES ('202405310003', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405310004', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405310005', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405310006', 1, '夏日清爽', 9, '荔枝汽泡', 1, 10.00);
INSERT INTO `tb_detail` VALUES ('202405310007', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.80);
INSERT INTO `tb_detail` VALUES ('202405310008', 1, '夏日清爽', 8, '草莓气泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405310009', 1, '夏日清爽', 1, '柠檬汽泡', 1, 11.40);
INSERT INTO `tb_detail` VALUES ('202405310009', 1, '夏日清爽', 1, '柠檬汽泡', 1, 13.30);
INSERT INTO `tb_detail` VALUES ('202405310010', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405310010', 1, '夏日清爽', 4, '翠峰茉莉', 1, 10.80);
INSERT INTO `tb_detail` VALUES ('202405310011', 1, '夏日清爽', 1, '柠檬汽泡', 1, 12.00);
INSERT INTO `tb_detail` VALUES ('202405310012', 2, '冬日温暖', 13, '巧克力', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405310012', 2, '冬日温暖', 13, '巧克力', 1, 10.80);
INSERT INTO `tb_detail` VALUES ('202405310013', 4, '咖啡系列', 16, '摩卡咖啡', 1, 14.00);
INSERT INTO `tb_detail` VALUES ('202405310013', 4, '咖啡系列', 16, '摩卡咖啡', 1, 16.00);
INSERT INTO `tb_detail` VALUES ('202405310014', 1, '夏日清爽', 4, '翠峰茉莉', 1, 9.00);
INSERT INTO `tb_detail` VALUES ('202405310015', 9, '奶茶系列', 27, '草莓奶茶', 1, 9.50);
INSERT INTO `tb_detail` VALUES ('202405310015', 9, '奶茶系列', 27, '草莓奶茶', 1, 11.40);
INSERT INTO `tb_detail` VALUES ('202405310015', 9, '奶茶系列', 27, '草莓奶茶', 1, 13.30);
INSERT INTO `tb_detail` VALUES ('202405310016', 9, '奶茶系列', 20, '焦糖奶茶', 2, 21.60);

-- ----------------------------
-- Table structure for tb_drink
-- ----------------------------
DROP TABLE IF EXISTS `tb_drink`;
CREATE TABLE `tb_drink`  (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`d_id`) USING BTREE,
  INDEX `d_id`(`d_id`) USING BTREE,
  INDEX `f_c`(`c_id`) USING BTREE,
  INDEX `name_uni`(`d_name`) USING BTREE,
  CONSTRAINT `tb_drink_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `tb_category` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_drink
-- ----------------------------
INSERT INTO `tb_drink` VALUES (1, '柠檬汽泡', 1, 12, '在售');
INSERT INTO `tb_drink` VALUES (2, '芒果汽泡', 1, 20, '在售');
INSERT INTO `tb_drink` VALUES (3, '红糖枸杞', 2, 10, '在售');
INSERT INTO `tb_drink` VALUES (4, '翠峰茉莉', 1, 10, '在售');
INSERT INTO `tb_drink` VALUES (5, '芝士莓莓', 1, 18, '停售');
INSERT INTO `tb_drink` VALUES (8, '草莓气泡', 1, 12, '在售');
INSERT INTO `tb_drink` VALUES (9, '荔枝汽泡', 1, 10, '在售');
INSERT INTO `tb_drink` VALUES (10, '西瓜汽泡', 1, 10, '在售');
INSERT INTO `tb_drink` VALUES (11, '布丁奶茶', 9, 12, '在售');
INSERT INTO `tb_drink` VALUES (12, '百香果可乐', 1, 14, '在售');
INSERT INTO `tb_drink` VALUES (13, '巧克力', 2, 10, '在售');
INSERT INTO `tb_drink` VALUES (14, '拿铁咖啡', 4, 15, '在售');
INSERT INTO `tb_drink` VALUES (15, '卡布奇诺', 4, 18, '在售');
INSERT INTO `tb_drink` VALUES (16, '摩卡咖啡', 4, 14, '在售');
INSERT INTO `tb_drink` VALUES (17, '现磨咖啡', 4, 14, '在售');
INSERT INTO `tb_drink` VALUES (19, '丝滑奶茶', 9, 10, '在售');
INSERT INTO `tb_drink` VALUES (20, '焦糖奶茶', 9, 10, '在售');
INSERT INTO `tb_drink` VALUES (21, '草莓多多', 3, 18, '在售');
INSERT INTO `tb_drink` VALUES (22, '鲜橙多多', 3, 14, '在售');
INSERT INTO `tb_drink` VALUES (23, '巨峰葡萄', 3, 16, '在售');
INSERT INTO `tb_drink` VALUES (24, '冰霜西瓜汁', 3, 12, '在售');
INSERT INTO `tb_drink` VALUES (25, '柠檬百香果', 3, 12, '在售');
INSERT INTO `tb_drink` VALUES (26, '可乐煲姜', 2, 10, '在售');
INSERT INTO `tb_drink` VALUES (27, '草莓奶茶', 9, 12, '在售');
INSERT INTO `tb_drink` VALUES (28, '珍珠奶茶', 9, 10, '在售');
INSERT INTO `tb_drink` VALUES (32, '元气芒芒', 3, 10, '在售');
INSERT INTO `tb_drink` VALUES (33, '柠乐', 1, 6, '在售');
INSERT INTO `tb_drink` VALUES (39, '黑砖奶茶', 9, 12, '在售');
INSERT INTO `tb_drink` VALUES (50, '皇冠奶茶', 9, 13, '在售');
INSERT INTO `tb_drink` VALUES (60, '蛋糕奶茶', 9, 10, '在售');
INSERT INTO `tb_drink` VALUES (63, '抹茶一号', 12, 12, '移除');
INSERT INTO `tb_drink` VALUES (64, '抹茶一号', 13, 12, '移除');

-- ----------------------------
-- Table structure for tb_employe
-- ----------------------------
DROP TABLE IF EXISTS `tb_employe`;
CREATE TABLE `tb_employe`  (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passwd` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`e_id`) USING BTREE,
  UNIQUE INDEX `only`(`user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_employe
-- ----------------------------
INSERT INTO `tb_employe` VALUES (1, '张扬', '男', 'zy', '123456', '正常');
INSERT INTO `tb_employe` VALUES (2, '王兆鑫', '男', 'wzx', '456789', '正常');
INSERT INTO `tb_employe` VALUES (3, '于铁', '男', 'yt', '123456', '正常');
INSERT INTO `tb_employe` VALUES (4, '吴尚松', '男', 'wss', '456789', '正常');
INSERT INTO `tb_employe` VALUES (5, '韦景', '男', 'wj', '123456', '正常');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`  (
  `m_id` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `point` int(11) NOT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('13800000002', '吴', '男', 4);
INSERT INTO `tb_member` VALUES ('13800000004', '张', '男', 1);
INSERT INTO `tb_member` VALUES ('13800000006', '韦', '男', 1);
INSERT INTO `tb_member` VALUES ('13800000008', '于', '男', 5);
INSERT INTO `tb_member` VALUES ('13800000009', '王', '男', 1);

SET FOREIGN_KEY_CHECKS = 1;
