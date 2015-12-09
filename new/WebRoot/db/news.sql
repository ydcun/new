/*
Navicat MySQL Data Transfer

Source Server         : loc
Source Server Version : 50510
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50510
File Encoding         : 65001

Date: 2015-12-08 03:36:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` bigint(19) DEFAULT NULL,
  `channel` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `brief` varchar(100) DEFAULT NULL,
  `abstracts` varchar(500) DEFAULT NULL,
  `content` text,
  `image` text,
  `keywords` varchar(100) DEFAULT NULL,
  `istop` int(1) DEFAULT NULL,
  `original` int(1) DEFAULT NULL,
  `sharable` int(1) DEFAULT NULL,
  `reading` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `hate` int(11) DEFAULT NULL,
  `comments` int(11) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `copyfrom` varchar(50) DEFAULT NULL,
  `author_name` varchar(50) DEFAULT NULL,
  `author` bigint(19) DEFAULT NULL,
  `editor` bigint(19) DEFAULT NULL,
  `checker` bigint(19) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_339jxf7l5s244wr8hd8iu23df` (`channel`),
  CONSTRAINT `FK_339jxf7l5s244wr8hd8iu23df` FOREIGN KEY (`channel`) REFERENCES `channel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `channel`
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `brief` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `content` text,
  `state` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `userid` bigint(19) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `lonlat` varchar(50) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `hate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i4gfabcdddfcsr8rqvwh87hny` (`article_id`),
  CONSTRAINT `FK_i4gfabcdddfcsr8rqvwh87hny` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
