-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: wfe
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_action_action_type1_idx` (`action_type_id`),
  KEY `fk_action_process1_idx` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,1,1,'Approve Project Start ',NULL),(2,1,1,'Approve Analysis',NULL),(3,2,1,'Reject Analysis',NULL),(4,1,1,'Approve Projection',NULL),(5,2,1,'Reject Projection',NULL),(6,3,1,'Cancel Project',NULL),(7,1,1,'Approve Projection 2',NULL),(8,1,1,'Test action',NULL),(9,1,1,'Test action',NULL),(10,1,1,'Test action',NULL),(11,1,1,'Test action',NULL),(12,1,1,'Test action',NULL),(13,1,1,'Test action',NULL),(14,1,1,'Test action',NULL),(15,1,1,'Test action',NULL),(16,1,1,'Test action',NULL),(17,1,1,'Test action',NULL),(18,1,1,'Test action',NULL),(19,1,1,'Test action',NULL),(20,1,1,'Test action',NULL),(21,1,1,'Test action',NULL),(22,1,1,'Test action',NULL),(23,1,1,'Test action',NULL),(24,1,1,'Test action',NULL),(25,1,1,'Test action',NULL),(26,1,1,'Test action',NULL),(27,1,1,'Test action',NULL),(28,1,1,'Test action',NULL),(29,1,1,'Test action',NULL),(30,1,1,'Test action',NULL),(31,1,1,'Test action',NULL),(32,1,1,'Test action',NULL),(33,1,1,'Test action',NULL),(34,1,1,'Test action',NULL),(35,1,1,'Test action',NULL),(36,1,1,'Test action',NULL),(37,1,1,'Test action',NULL),(38,1,1,'Test action',NULL),(39,1,1,'Test action',NULL),(40,1,1,'Test action',NULL),(41,1,1,'Test action',NULL),(42,1,1,'Test action',NULL),(43,1,1,'Test action',NULL),(44,1,1,'Test action',NULL),(45,1,1,'Test action',NULL),(46,1,1,'Test action',NULL),(47,1,1,'Test action',NULL),(48,1,1,'Test action',NULL),(49,1,1,'Test action',NULL),(50,1,1,'Test action',NULL),(51,1,1,'Test action',NULL),(52,1,1,'Test action',NULL),(53,1,1,'Test action',NULL),(54,1,1,'Test action',NULL),(55,1,1,'Test action',NULL),(56,1,1,'Test action',NULL),(57,1,1,'Test action',NULL),(58,1,1,'Test action',NULL),(59,1,1,'Test action',NULL),(60,1,1,'Test action',NULL),(61,1,1,'Test action',NULL),(62,1,1,'Test action',NULL),(63,1,1,'Test action',NULL);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_target`
--

DROP TABLE IF EXISTS `action_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_action_target_action1_idx` (`action_id`),
  KEY `fk_action_target_target1_idx` (`target_id`),
  KEY `fk_action_target_group1_idx` (`group_id`),
  CONSTRAINT `fk_action_target_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_action_target_target1` FOREIGN KEY (`target_id`) REFERENCES `target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_target`
--

LOCK TABLES `action_target` WRITE;
/*!40000 ALTER TABLE `action_target` DISABLE KEYS */;
/*!40000 ALTER TABLE `action_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_type`
--

DROP TABLE IF EXISTS `action_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_type`
--

LOCK TABLES `action_type` WRITE;
/*!40000 ALTER TABLE `action_type` DISABLE KEYS */;
INSERT INTO `action_type` VALUES (1,'Approve'),(2,'Deny'),(3,'Cancel');
/*!40000 ALTER TABLE `action_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `activity_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_activity_activity_type1_idx` (`activity_type_id`),
  KEY `fk_activity_process1_idx` (`process_id`),
  CONSTRAINT `fk_activity_activity_type1` FOREIGN KEY (`activity_type_id`) REFERENCES `activity_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'Notify Project Coordinator',NULL,1,1),(2,'Notify Project Manager',NULL,1,1);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_target`
--

DROP TABLE IF EXISTS `activity_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_activity_target_activity1_idx` (`activity_id`),
  KEY `fk_activity_target_target1_idx` (`target_id`),
  KEY `fk_activity_target_group1_idx` (`group_id`),
  CONSTRAINT `fk_activity_target_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_target_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_target_target1` FOREIGN KEY (`target_id`) REFERENCES `target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_target`
--

LOCK TABLES `activity_target` WRITE;
/*!40000 ALTER TABLE `activity_target` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_type`
--

DROP TABLE IF EXISTS `activity_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_type` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_type`
--

LOCK TABLES `activity_type` WRITE;
/*!40000 ALTER TABLE `activity_type` DISABLE KEYS */;
INSERT INTO `activity_type` VALUES (1,'Send Email');
/*!40000 ALTER TABLE `activity_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_member`
--

DROP TABLE IF EXISTS `group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_member` (
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`,`user_id`),
  KEY `fk_group_member_group1_idx` (`group_id`),
  KEY `fk_group_member_user1_idx` (`user_id`),
  CONSTRAINT `fk_group_member_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_member_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member`
--

LOCK TABLES `group_member` WRITE;
/*!40000 ALTER TABLE `group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `process`
--

DROP TABLE IF EXISTS `process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process`
--

LOCK TABLES `process` WRITE;
/*!40000 ALTER TABLE `process` DISABLE KEYS */;
INSERT INTO `process` VALUES (1,'Request Project');
/*!40000 ALTER TABLE `process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `process_admin`
--

DROP TABLE IF EXISTS `process_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `process_admin` (
  `process_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`process_id`,`user_id`),
  KEY `fk_process_admin_user1_idx` (`user_id`),
  CONSTRAINT `fk_pa_process` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`),
  CONSTRAINT `fk_process_admin_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process_admin`
--

LOCK TABLES `process_admin` WRITE;
/*!40000 ALTER TABLE `process_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `process_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `current_state_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `date_requested` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_request_process1_idx` (`process_id`),
  KEY `fk_request_state1_idx` (`current_state_id`),
  KEY `fk_request_user1_idx` (`user_id`),
  CONSTRAINT `fk_request_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_state1` FOREIGN KEY (`current_state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (3,1,1,1,'Test request','ChanhLT','2018-05-30 00:00:00'),(4,1,1,1,'Test request','ChanhLT','2018-05-30 11:49:24'),(5,1,1,1,'Test request','ChanhLT','2018-05-30 11:50:34'),(6,1,1,1,'Test request','ChanhLT','2018-05-30 11:51:06'),(7,1,1,1,'Test request','ChanhLT','2018-05-30 11:52:07'),(8,1,1,1,'Test request','ChanhLT','2018-05-30 11:55:01'),(9,1,1,1,'Test request','ChanhLT','2018-05-30 11:55:04'),(10,1,1,1,'Test request','ChanhLT','2018-05-30 11:55:08'),(11,1,1,1,'Test request','ChanhLT','2018-05-30 11:59:42'),(12,1,1,1,'Test request','ChanhLT','2018-05-30 11:59:55'),(13,1,1,1,'Test request','ChanhLT','2018-05-30 12:00:14'),(14,1,1,1,'Test request','ChanhLT','2018-05-30 12:00:38'),(15,1,1,1,'Test request','ChanhLT','2018-05-30 12:04:16'),(16,1,1,1,'Test request','ChanhLT','2018-05-30 12:04:39'),(17,1,1,1,'Test request','ChanhLT','2018-05-30 12:19:35'),(18,1,1,1,'Test request','ChanhLT','2018-05-30 12:20:15'),(19,1,1,1,'Test request','ChanhLT','2018-05-30 12:20:35'),(20,1,1,1,'Test request','ChanhLT','2018-05-30 12:21:28'),(21,1,1,1,'Test request','ChanhLT','2018-05-30 12:21:31'),(22,1,1,1,'Test request','ChanhLT','2018-05-30 12:22:03'),(23,1,1,1,'Test request','ChanhLT','2018-05-30 12:47:43'),(24,1,1,1,'Test request','ChanhLT','2018-05-30 12:48:10'),(25,1,1,1,'Test request','ChanhLT','2018-05-30 12:49:04'),(26,1,1,1,'Test request','ChanhLT','2018-05-30 12:49:35'),(27,1,1,1,'Test request','ChanhLT','2018-05-30 12:49:41'),(28,1,1,1,'Test request','ChanhLT','2018-05-30 12:50:33'),(29,1,1,1,'Test request','ChanhLT','2018-05-30 12:50:40'),(30,1,1,1,'Test request','ChanhLT','2018-05-30 12:51:21'),(31,1,1,1,'Test request','ChanhLT','2018-05-30 12:52:34'),(32,1,1,1,'Test request','ChanhLT','2018-05-30 12:59:03'),(33,1,1,1,'Test request','ChanhLT','2018-05-30 12:59:07'),(34,1,1,1,'Test request','ChanhLT','2018-05-30 13:03:55'),(35,1,1,1,'Test request','ChanhLT','2018-05-30 13:04:31'),(36,1,1,1,'Test request','ChanhLT','2018-05-30 13:04:39'),(37,1,1,1,'Test request','ChanhLT','2018-05-30 13:06:06'),(38,1,1,1,'Test request','ChanhLT','2018-05-30 13:06:52'),(39,1,1,1,'Test request','ChanhLT','2018-05-30 13:07:51'),(40,1,1,1,'Test request','ChanhLT','2018-05-30 13:08:43'),(41,1,1,1,'Test request','ChanhLT','2018-05-30 13:10:25'),(43,1,1,4,'Test request','ChanhLT','2018-05-30 13:12:27'),(44,1,1,1,'Test request','ChanhLT','2018-05-30 13:14:39'),(45,1,1,1,'Test request','ChanhLT','2018-05-30 13:15:36'),(46,1,1,1,'Test request 2','ChanhLT','2018-05-30 17:34:00'),(47,1,1,5,'Test request 3','ChanhLT 2','2018-05-30 17:38:30'),(48,1,1,2,'Request Start project','Chanh','2018-05-30 18:28:06'),(49,1,1,1,'Request Start project','Chanh','2018-05-30 18:31:11');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_action`
--

DROP TABLE IF EXISTS `request_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_id` int(11) NOT NULL,
  `transition_id` int(11) NOT NULL,
  `action_id` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `is_complete` tinyint(1) NOT NULL DEFAULT '0',
  `completed_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_request_action_request1_idx` (`request_id`),
  KEY `fk_request_action_transition1_idx` (`transition_id`),
  KEY `fk_request_action_action1_idx` (`action_id`),
  KEY `fk_request_action_user1_idx` (`completed_by`),
  CONSTRAINT `fk_request_action_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_action_transition1` FOREIGN KEY (`transition_id`) REFERENCES `transition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_action_user1` FOREIGN KEY (`completed_by`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_action`
--

LOCK TABLES `request_action` WRITE;
/*!40000 ALTER TABLE `request_action` DISABLE KEYS */;
INSERT INTO `request_action` VALUES (1,43,1,1,0,1,1),(2,44,1,1,1,0,NULL),(3,45,1,1,1,0,NULL),(23,43,2,2,0,1,1),(24,43,3,3,0,0,NULL),(28,43,4,4,0,1,1),(29,43,4,7,0,1,1),(30,43,5,5,0,0,NULL),(31,43,6,6,0,0,NULL),(32,46,1,1,1,0,1),(33,46,2,2,0,0,NULL),(34,46,3,3,0,1,1),(36,47,1,1,0,1,1),(37,47,2,2,0,0,NULL),(38,47,3,3,0,1,1),(39,47,1,1,0,1,1),(40,47,2,2,0,1,1),(41,47,3,3,0,0,NULL),(42,47,4,7,0,0,NULL),(43,47,4,4,0,0,NULL),(44,47,5,5,0,1,1),(45,47,6,6,0,0,NULL),(46,47,2,2,0,1,1),(47,47,3,3,0,0,NULL),(48,47,4,7,0,0,NULL),(49,47,4,4,0,0,NULL),(50,47,5,5,0,0,NULL),(51,47,6,6,0,1,1),(52,48,1,1,0,1,1),(53,48,2,2,1,0,NULL),(54,48,3,3,1,0,NULL),(55,49,1,1,1,0,NULL);
/*!40000 ALTER TABLE `request_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_stakeholder`
--

DROP TABLE IF EXISTS `request_stakeholder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_stakeholder` (
  `request_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`request_id`,`user_id`),
  KEY `fk_request_stakeholder_user1_idx` (`user_id`),
  CONSTRAINT `fk_request_stakeholder_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_stakeholder_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_stakeholder`
--

LOCK TABLES `request_stakeholder` WRITE;
/*!40000 ALTER TABLE `request_stakeholder` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_stakeholder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `state_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_state_state_type1_idx` (`state_type_id`),
  KEY `fk_state_process1_idx` (`process_id`),
  CONSTRAINT `fk_state_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_state_type1` FOREIGN KEY (`state_type_id`) REFERENCES `state_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Begin Project','Start',1,1),(2,'Run Analysis',NULL,2,1),(3,'Make Projection ',NULL,2,1),(4,'Project Complete',NULL,3,1),(5,'Cancelled ',NULL,4,1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_activity`
--

DROP TABLE IF EXISTS `state_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_activity` (
  `state_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  PRIMARY KEY (`state_id`,`activity_id`),
  KEY `fk_state_activity_activity1_idx` (`activity_id`),
  CONSTRAINT `fk_state_activity_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_activity_state1` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_activity`
--

LOCK TABLES `state_activity` WRITE;
/*!40000 ALTER TABLE `state_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_type`
--

DROP TABLE IF EXISTS `state_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_type`
--

LOCK TABLES `state_type` WRITE;
/*!40000 ALTER TABLE `state_type` DISABLE KEYS */;
INSERT INTO `state_type` VALUES (1,'Start'),(2,'Normal'),(3,'Complete'),(4,'Cancelled');
/*!40000 ALTER TABLE `state_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `target`
--

DROP TABLE IF EXISTS `target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `target`
--

LOCK TABLES `target` WRITE;
/*!40000 ALTER TABLE `target` DISABLE KEYS */;
/*!40000 ALTER TABLE `target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transition`
--

DROP TABLE IF EXISTS `transition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_id` int(11) NOT NULL,
  `current_state_id` int(11) NOT NULL,
  `next_state_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `current_state` int(11) DEFAULT NULL,
  `next_state` int(11) DEFAULT NULL,
  `process` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_transition_process1_idx` (`process_id`),
  KEY `fk_transition_state1_idx` (`current_state_id`),
  KEY `fk_transition_state2_idx` (`next_state_id`),
  CONSTRAINT `fk_transition_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_state1` FOREIGN KEY (`current_state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_state2` FOREIGN KEY (`next_state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition`
--

LOCK TABLES `transition` WRITE;
/*!40000 ALTER TABLE `transition` DISABLE KEYS */;
INSERT INTO `transition` VALUES (1,1,1,2,'Begin Project -> Run Analysis (Action: Approve Project Start, Activity: Notify Project Coordinator)',NULL,NULL,NULL),(2,1,2,3,'Run Analysis -> Make Projection (Action: Approve Analysis, Activity: Notify Project Manager)',NULL,NULL,NULL),(3,1,2,1,'Run Analysis -> Begin Project (Action: Reject Analysis)',NULL,NULL,NULL),(4,1,3,4,'Make Projection -> Project Complete (Action: Approve Projection, Activity: Notify Project Coordinator, Notify Project Manager)',NULL,NULL,NULL),(5,1,3,2,'Make Projection -> Run Analysis (Action: Reject Projection, Activity: Notify Project Coordinator)',NULL,NULL,NULL),(6,1,3,5,'Make Projection -> Cancelled (Action: Cancel Project)',NULL,NULL,NULL);
/*!40000 ALTER TABLE `transition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transition_action`
--

DROP TABLE IF EXISTS `transition_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transition_action` (
  `transition_id` int(11) NOT NULL,
  `action_id` int(11) NOT NULL,
  PRIMARY KEY (`action_id`),
  KEY `fk_transition_action_transition1_idx` (`transition_id`),
  CONSTRAINT `FKe3gnfe9hyewx90qa9tdvog6hs` FOREIGN KEY (`action_id`) REFERENCES `action` (`id`),
  CONSTRAINT `fk_transition_action_transition1` FOREIGN KEY (`transition_id`) REFERENCES `transition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition_action`
--

LOCK TABLES `transition_action` WRITE;
/*!40000 ALTER TABLE `transition_action` DISABLE KEYS */;
INSERT INTO `transition_action` VALUES (1,1),(2,2),(3,3),(4,4),(4,7),(5,5),(6,6);
/*!40000 ALTER TABLE `transition_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transition_activity`
--

DROP TABLE IF EXISTS `transition_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transition_activity` (
  `activity_id` int(11) NOT NULL,
  `transition_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`transition_id`),
  KEY `fk_transition_activity_activity1_idx` (`activity_id`),
  KEY `fk_transition_activity_transition1_idx` (`transition_id`),
  CONSTRAINT `fk_transition_activity_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_activity_transition1` FOREIGN KEY (`transition_id`) REFERENCES `transition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition_activity`
--

LOCK TABLES `transition_activity` WRITE;
/*!40000 ALTER TABLE `transition_activity` DISABLE KEYS */;
INSERT INTO `transition_activity` VALUES (1,1),(1,4),(1,5),(2,2),(2,4);
/*!40000 ALTER TABLE `transition_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Chanh'),(2,'Vinh');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'wfe'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-30 19:06:35
