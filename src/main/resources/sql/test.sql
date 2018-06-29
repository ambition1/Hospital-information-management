/*
Navicat MySQL Data Transfer

Source Server         : Local instance MySQL57
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-28 21:36:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `bedid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `isempty` varchar(5) NOT NULL DEFAULT '空',
  PRIMARY KEY (`bedid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('1', '123', '占');
INSERT INTO `bed` VALUES ('2', '12', '占');
INSERT INTO `bed` VALUES ('3', null, '空');
INSERT INTO `bed` VALUES ('4', null, '空');
INSERT INTO `bed` VALUES ('5', null, '空');
INSERT INTO `bed` VALUES ('6', null, '空');
INSERT INTO `bed` VALUES ('7', null, '空');
INSERT INTO `bed` VALUES ('8', null, '空');
INSERT INTO `bed` VALUES ('9', null, '空');
INSERT INTO `bed` VALUES ('10', null, '空');
INSERT INTO `bed` VALUES ('11', null, '空');
INSERT INTO `bed` VALUES ('12', null, '空');
INSERT INTO `bed` VALUES ('13', null, '空');
INSERT INTO `bed` VALUES ('14', null, '空');
INSERT INTO `bed` VALUES ('15', null, '空');
INSERT INTO `bed` VALUES ('16', null, '空');
INSERT INTO `bed` VALUES ('17', null, '空');
INSERT INTO `bed` VALUES ('18', null, '空');
INSERT INTO `bed` VALUES ('19', null, '空');
INSERT INTO `bed` VALUES ('20', null, '空');

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `recipeid` int(10) unsigned DEFAULT NULL,
  `checkid` int(10) unsigned DEFAULT NULL,
  `money` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`billid`),
  KEY `userid` (`userid`),
  KEY `recipeid` (`recipeid`),
  KEY `checkid` (`checkid`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `person` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`recipeid`) REFERENCES `recipe` (`recipeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bill_ibfk_3` FOREIGN KEY (`checkid`) REFERENCES `inspect` (`checkid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('6', '7', '8', '1', '260.00');
INSERT INTO `bill` VALUES ('7', '8', null, null, '10.00');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctorname` varchar(20) NOT NULL,
  `doctorsex` varchar(5) NOT NULL COMMENT '''男''',
  `doctorphone` varchar(20) NOT NULL,
  PRIMARY KEY (`doctorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '张三', '男', '15035161311');
INSERT INTO `doctor` VALUES ('2', '李四', '男', '15035161312');
INSERT INTO `doctor` VALUES ('3', '王五', '男', '15035161313');

-- ----------------------------
-- Table structure for inspect
-- ----------------------------
DROP TABLE IF EXISTS `inspect`;
CREATE TABLE `inspect` (
  `checkid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `checkname` varchar(20) NOT NULL,
  `money` double(10,2) NOT NULL,
  PRIMARY KEY (`checkid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inspect
-- ----------------------------
INSERT INTO `inspect` VALUES ('0', '', '0.00');
INSERT INTO `inspect` VALUES ('1', '血常规', '200.00');
INSERT INTO `inspect` VALUES ('2', '透视', '150.00');
INSERT INTO `inspect` VALUES ('3', 'CT', '100.00');
INSERT INTO `inspect` VALUES ('4', 'B超', '150.00');
INSERT INTO `inspect` VALUES ('5', '心电图', '200.00');

-- ----------------------------
-- Table structure for intime
-- ----------------------------
DROP TABLE IF EXISTS `intime`;
CREATE TABLE `intime` (
  `inhospital` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `bedid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`inhospital`),
  KEY `userid` (`username`),
  KEY `bedid` (`bedid`),
  CONSTRAINT `intime_ibfk_2` FOREIGN KEY (`bedid`) REFERENCES `bed` (`bedid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of intime
-- ----------------------------
INSERT INTO `intime` VALUES ('2018-06-22', '123', '1');
INSERT INTO `intime` VALUES ('2018-06-25', '12', '2');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '123', '123');
INSERT INTO `login` VALUES ('2', '123123', '6b0be2bd2666adc4f393bc1e06d78298');

-- ----------------------------
-- Table structure for outtime
-- ----------------------------
DROP TABLE IF EXISTS `outtime`;
CREATE TABLE `outtime` (
  `outhospital` varchar(20) NOT NULL,
  `userid` int(10) unsigned NOT NULL,
  `recipeid` int(10) unsigned NOT NULL,
  `billid` int(10) unsigned NOT NULL,
  `doctorid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`outhospital`),
  KEY `userid` (`userid`),
  KEY `recipeid` (`recipeid`),
  KEY `billid` (`billid`),
  KEY `doctorid` (`doctorid`),
  CONSTRAINT `outtime_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `person` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outtime_ibfk_2` FOREIGN KEY (`recipeid`) REFERENCES `recipe` (`recipeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outtime_ibfk_3` FOREIGN KEY (`billid`) REFERENCES `bill` (`billid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outtime_ibfk_4` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outtime
-- ----------------------------
INSERT INTO `outtime` VALUES ('2018-06-22', '7', '8', '6', '1');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `usersex` varchar(5) NOT NULL DEFAULT '男',
  `userage` int(10) NOT NULL,
  `useraddress` varchar(20) NOT NULL,
  `userphone` varchar(15) NOT NULL,
  `bedid` int(10) unsigned DEFAULT NULL,
  `doctorid` int(10) unsigned DEFAULT NULL,
  `checkid` int(10) unsigned DEFAULT NULL,
  `money` double(10,2) unsigned DEFAULT NULL,
  `inhospital` varchar(20) DEFAULT NULL,
  `outhospital` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `bedid` (`bedid`),
  KEY `doctorid` (`doctorid`),
  KEY `checkid` (`checkid`),
  KEY `inhospital` (`inhospital`),
  KEY `outhospital` (`outhospital`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`bedid`) REFERENCES `bed` (`bedid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_2` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_3` FOREIGN KEY (`checkid`) REFERENCES `inspect` (`checkid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_4` FOREIGN KEY (`inhospital`) REFERENCES `intime` (`inhospital`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_5` FOREIGN KEY (`outhospital`) REFERENCES `outtime` (`outhospital`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('7', '123', '男', '12', 'gwgrewgwe', '15012341235', '1', '1', '1', '260.00', '2018-06-22', null);
INSERT INTO `person` VALUES ('8', '12', '男', '12', '123561515311', '15014781478', '2', '2', '0', null, '2018-06-25', null);

-- ----------------------------
-- Table structure for recipe
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `recipeid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `recipecontext` varchar(50) DEFAULT NULL,
  `doctorid` int(10) unsigned DEFAULT NULL,
  `userid` int(10) NOT NULL,
  `checkid` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`recipeid`),
  KEY `doctorid` (`doctorid`),
  KEY `checkid` (`checkid`),
  CONSTRAINT `recipe_ibfk_1` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recipe_ibfk_3` FOREIGN KEY (`checkid`) REFERENCES `inspect` (`checkid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe
-- ----------------------------
INSERT INTO `recipe` VALUES ('8', '血稠', '1', '7', '1');
INSERT INTO `recipe` VALUES ('9', null, '2', '8', null);

-- ----------------------------
-- View structure for personbill
-- ----------------------------
DROP VIEW IF EXISTS `personbill`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `personbill` AS select `person`.`userid` AS `userid`,`person`.`username` AS `username`,`person`.`usersex` AS `usersex`,`person`.`userage` AS `userage`,`person`.`userphone` AS `userphone`,`bill`.`money` AS `money` from (`person` join `bill`) where (`bill`.`userid` = `person`.`userid`) ;

-- ----------------------------
-- View structure for personcheck
-- ----------------------------
DROP VIEW IF EXISTS `personcheck`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `personcheck` AS select distinct `person`.`userid` AS `userid`,`person`.`username` AS `username`,`person`.`usersex` AS `usersex`,`person`.`userage` AS `userage`,`person`.`useraddress` AS `useraddress`,`person`.`userphone` AS `userphone`,`person`.`bedid` AS `bedid`,`person`.`doctorid` AS `doctorid`,`person`.`checkid` AS `checkid`,`person`.`money` AS `money`,`person`.`inhospital` AS `inhospital`,`person`.`outhospital` AS `outhospital`,`inspect`.`checkname` AS `checkname` from (`person` join `inspect`) where (`inspect`.`checkid` = `person`.`checkid`) ;

-- ----------------------------
-- View structure for personrecipe
-- ----------------------------
DROP VIEW IF EXISTS `personrecipe`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `personrecipe` AS select `person`.`userid` AS `userid`,`person`.`username` AS `username`,`person`.`usersex` AS `usersex`,`person`.`userage` AS `userage`,`person`.`useraddress` AS `useraddress`,`person`.`userphone` AS `userphone`,`person`.`bedid` AS `bedid`,`person`.`doctorid` AS `doctorid`,`person`.`checkid` AS `checkid`,`person`.`money` AS `money`,`person`.`inhospital` AS `inhospital`,`person`.`outhospital` AS `outhospital`,`recipe`.`recipecontext` AS `recipecontext` from (`person` join `recipe`) where (`recipe`.`userid` = `person`.`userid`) ;
