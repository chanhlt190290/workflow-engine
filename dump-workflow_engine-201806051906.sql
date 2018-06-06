-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: workflow_engine
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
  `name` varchar(255) NOT NULL,
  `action_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_action_action_type1_idx` (`action_type_id`),
  KEY `fk_action_process1_idx` (`process_id`),
  CONSTRAINT `fk_action_action_type1` FOREIGN KEY (`action_type_id`) REFERENCES `action_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_action_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'Apply',0,1,NULL,'2018-06-05 14:28:06',1,'2018-06-05 14:28:06',1),(2,'Supervisor approve',1,1,NULL,'2018-06-05 14:29:22',1,'2018-06-05 14:29:22',1),(3,'Supervisor reject',2,1,NULL,'2018-06-05 14:29:33',1,'2018-06-05 14:29:33',1),(4,'Lead approve',1,1,NULL,'2018-06-05 14:30:09',1,'2018-06-05 14:30:09',1),(5,'Lead reject',2,1,NULL,'2018-06-05 14:30:16',1,'2018-06-05 14:30:16',1),(6,'Coordinator approve',1,1,NULL,'2018-06-05 14:30:38',1,'2018-06-05 14:30:38',1),(7,'Coordinator reject',2,1,NULL,'2018-06-05 14:30:43',1,'2018-06-05 14:30:43',1),(8,'Lead approve to start development',1,1,NULL,'2018-06-05 14:31:37',1,'2018-06-05 14:31:37',1),(9,'QA team approve',1,1,NULL,'2018-06-05 14:32:13',1,'2018-06-05 14:32:13',1),(10,'QA team reject',2,1,NULL,'2018-06-05 14:32:18',1,'2018-06-05 14:32:18',1),(11,'Applier confirm YES',1,1,NULL,'2018-06-05 14:32:49',1,'2018-06-05 14:32:49',1),(12,'Applier confirm NO',2,1,NULL,'2018-06-05 14:32:53',1,'2018-06-05 14:32:53',1),(13,'Coordinator confirm YES',1,1,NULL,'2018-06-05 14:32:53',1,'2018-06-05 14:32:53',1),(14,'Coordinator confirm NO',2,1,NULL,'2018-06-05 14:32:53',1,'2018-06-05 14:32:53',1);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_target`
--

DROP TABLE IF EXISTS `action_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_target` (
  `action_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  PRIMARY KEY (`action_id`,`target_id`),
  KEY `fk_action_target_action1_idx` (`action_id`),
  KEY `fk_action_target_target1_idx` (`target_id`),
  CONSTRAINT `fk_action_target_action1` FOREIGN KEY (`action_id`) REFERENCES `action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_action_target_target1` FOREIGN KEY (`target_id`) REFERENCES `target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_target`
--

LOCK TABLES `action_target` WRITE;
/*!40000 ALTER TABLE `action_target` DISABLE KEYS */;
INSERT INTO `action_target` VALUES (1,1),(2,2),(3,2),(4,3),(5,3),(6,2),(7,4),(8,4),(9,5),(10,5),(11,1),(12,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_type`
--

LOCK TABLES `action_type` WRITE;
/*!40000 ALTER TABLE `action_type` DISABLE KEYS */;
INSERT INTO `action_type` VALUES (0,'Apply'),(1,'Approve'),(2,'Reject'),(3,'Cancel'),(4,'Restart'),(5,'Resolve');
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
  `activity_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  `description` text,
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_activity_activity_type1_idx` (`activity_type_id`),
  KEY `fk_activity_process1_idx` (`process_id`),
  CONSTRAINT `fk_activity_activity_type1` FOREIGN KEY (`activity_type_id`) REFERENCES `activity_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'Notify Applier when Supervisor reject',1,1,NULL,'2018-06-05 16:50:29',1,'2018-06-05 16:50:29',1),(2,'Notify Applier and Supervisor when Lead reject',1,1,NULL,'2018-06-05 16:52:48',1,'2018-06-05 16:52:48',1),(3,'Notify Coordinator when Lead approve',1,1,NULL,'2018-06-05 16:53:50',1,'2018-06-05 16:53:50',1),(4,'Notify Applier, Supervisor and Lead when Coordinator reject',1,1,NULL,'2018-06-05 16:54:28',1,'2018-06-05 16:54:28',1),(5,'Notify Developers when QA team reject',1,1,NULL,'2018-06-05 16:54:46',1,'2018-06-05 16:54:46',1),(6,'Notify Applier, QA team and Developers when QA team approve',1,1,NULL,'2018-06-05 16:55:22',1,'2018-06-05 16:55:22',1),(7,'Notify Applier, QA team and Developers when Applier confirm NO',1,1,NULL,'2018-06-05 16:55:56',1,'2018-06-05 16:55:56',1),(8,'Notify Applier, Coordinator and Lead when Applier confirm YES',1,1,NULL,'2018-06-05 16:56:20',1,'2018-06-05 16:56:20',1);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_target`
--

DROP TABLE IF EXISTS `activity_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_target` (
  `activity_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`target_id`),
  KEY `fk_activity_target_activity1_idx` (`activity_id`),
  KEY `fk_activity_target_target1_idx` (`target_id`),
  CONSTRAINT `fk_activity_target_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_target_target1` FOREIGN KEY (`target_id`) REFERENCES `target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_target`
--

LOCK TABLES `activity_target` WRITE;
/*!40000 ALTER TABLE `activity_target` DISABLE KEYS */;
INSERT INTO `activity_target` VALUES (1,1),(2,1),(2,2),(3,4),(4,1),(4,2),(4,3),(5,6),(6,1),(6,5),(6,6),(7,1),(7,5),(7,6),(8,1),(8,3),(8,4);
/*!40000 ALTER TABLE `activity_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_type`
--

DROP TABLE IF EXISTS `activity_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_type`
--

LOCK TABLES `activity_type` WRITE;
/*!40000 ALTER TABLE `activity_type` DISABLE KEYS */;
INSERT INTO `activity_type` VALUES (1,'Send Mail');
/*!40000 ALTER TABLE `activity_type` ENABLE KEYS */;
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
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process`
--

LOCK TABLES `process` WRITE;
/*!40000 ALTER TABLE `process` DISABLE KEYS */;
INSERT INTO `process` VALUES (1,'Request to start a project','2018-06-05 13:28:59',1,'2018-06-05 13:28:59',1);
/*!40000 ALTER TABLE `process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `state_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_request_process1_idx` (`process_id`),
  KEY `fk_request_state1_idx` (`state_id`),
  CONSTRAINT `fk_request_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_state1` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
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
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `is_complete` tinyint(1) NOT NULL DEFAULT '0',
  `request_id` int(11) NOT NULL,
  `transition_id` int(11) NOT NULL,
  `action_id` int(11) NOT NULL,
  `completed_at` datetime DEFAULT NULL,
  `completed_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_request_action_request1_idx` (`request_id`),
  KEY `fk_request_action_transition1_idx` (`transition_id`),
  KEY `fk_request_action_action1_idx` (`action_id`),
  CONSTRAINT `fk_request_action_action1` FOREIGN KEY (`action_id`) REFERENCES `action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_action_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_action_transition1` FOREIGN KEY (`transition_id`) REFERENCES `transition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_action`
--

LOCK TABLES `request_action` WRITE;
/*!40000 ALTER TABLE `request_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_action` ENABLE KEYS */;
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
  `state_type_id` int(11) NOT NULL,
  `process_id` int(11) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_state_state_type1_idx` (`state_type_id`),
  KEY `fk_state_process1_idx` (`process_id`),
  CONSTRAINT `fk_state_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_state_type1` FOREIGN KEY (`state_type_id`) REFERENCES `state_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Waiting for applier to aplly',1,1,NULL,'2018-06-05 13:31:50',1,'2018-06-05 13:31:50',1),(2,'Waiting for supervisor to approve',2,1,NULL,'2018-06-05 13:33:28',1,'2018-06-05 13:33:28',1),(3,'Waiting for Lead to approve',2,1,NULL,'2018-06-05 13:35:13',1,'2018-06-05 13:35:13',1),(4,'Waiting for Coordinator to approve',2,1,NULL,'2018-06-05 13:37:24',1,'2018-06-05 13:37:24',1),(5,'Waiting for approving to start development',2,1,NULL,'2018-06-05 13:38:26',1,'2018-06-05 13:38:26',1),(6,'Waiting for QA team to approve',2,1,NULL,'2018-06-05 13:39:19',1,'2018-06-05 13:39:19',1),(7,'Waiting for applier and coordinator to approve',2,1,NULL,'2018-06-05 13:40:33',1,'2018-06-05 13:40:33',1),(8,'project completed',3,1,NULL,'2018-06-05 13:41:17',1,'2018-06-05 13:41:17',1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_activity`
--

LOCK TABLES `state_activity` WRITE;
/*!40000 ALTER TABLE `state_activity` DISABLE KEYS */;
INSERT INTO `state_activity` VALUES (4,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_type`
--

LOCK TABLES `state_type` WRITE;
/*!40000 ALTER TABLE `state_type` DISABLE KEYS */;
INSERT INTO `state_type` VALUES (1,'Start'),(2,'Normal'),(3,'Completed'),(4,'Cancelled');
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
  `target_type_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_group_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `section_role_id` int(11) DEFAULT NULL,
  `role_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `target`
--

LOCK TABLES `target` WRITE;
/*!40000 ALTER TABLE `target` DISABLE KEYS */;
INSERT INTO `target` VALUES (1,'Applier',NULL,1,1,NULL,NULL,NULL,NULL),(2,'Supervisor',NULL,1,2,NULL,NULL,NULL,NULL),(3,'Lead',NULL,1,3,NULL,NULL,NULL,NULL),(4,'Coordinator',NULL,2,NULL,1,NULL,NULL,NULL),(5,'QA team',NULL,2,NULL,2,NULL,NULL,NULL),(6,'Developers',NULL,2,NULL,3,NULL,NULL,NULL);
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
  `created_at` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_transition_process1_idx` (`process_id`),
  KEY `fk_transition_state1_idx` (`current_state_id`),
  KEY `fk_transition_state2_idx` (`next_state_id`),
  CONSTRAINT `fk_transition_process1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_state1` FOREIGN KEY (`current_state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_state2` FOREIGN KEY (`next_state_id`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition`
--

LOCK TABLES `transition` WRITE;
/*!40000 ALTER TABLE `transition` DISABLE KEYS */;
INSERT INTO `transition` VALUES (1,1,1,2,'2018-06-05 14:15:15',1,'2018-06-05 14:15:15',1),(2,1,2,1,'2018-06-05 14:16:55',1,'2018-06-05 14:16:55',1),(3,1,2,3,'2018-06-05 14:17:05',1,'2018-06-05 14:17:05',1),(4,1,3,1,'2018-06-05 14:17:25',1,'2018-06-05 14:17:25',1),(5,1,3,4,'2018-06-05 14:17:32',1,'2018-06-05 14:17:32',1),(6,1,4,1,'2018-06-05 14:19:27',1,'2018-06-05 14:19:27',1),(7,1,4,5,'2018-06-05 14:19:31',1,'2018-06-05 14:19:31',1),(8,1,5,6,'2018-06-05 14:22:00',1,'2018-06-05 14:22:00',1),(9,1,6,5,'2018-06-05 14:22:24',1,'2018-06-05 14:22:24',1),(10,1,6,7,'2018-06-05 14:22:28',1,'2018-06-05 14:22:28',1),(11,1,7,5,'2018-06-05 14:23:01',1,'2018-06-05 14:23:01',1),(12,1,7,8,'2018-06-05 14:23:05',1,'2018-06-05 14:23:05',1);
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
  PRIMARY KEY (`transition_id`,`action_id`),
  KEY `fk_transition_action_transition1_idx` (`transition_id`),
  KEY `fk_transition_action_action1_idx` (`action_id`),
  CONSTRAINT `fk_transition_action_action1` FOREIGN KEY (`action_id`) REFERENCES `action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transition_action_transition1` FOREIGN KEY (`transition_id`) REFERENCES `transition` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition_action`
--

LOCK TABLES `transition_action` WRITE;
/*!40000 ALTER TABLE `transition_action` DISABLE KEYS */;
INSERT INTO `transition_action` VALUES (1,1),(2,3),(3,2),(4,5),(5,4),(6,7),(7,6),(8,8),(9,10),(10,9),(11,12),(12,11);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transition_activity`
--

LOCK TABLES `transition_activity` WRITE;
/*!40000 ALTER TABLE `transition_activity` DISABLE KEYS */;
INSERT INTO `transition_activity` VALUES (1,2),(2,4),(4,6),(5,9),(6,10),(7,11),(8,12);
/*!40000 ALTER TABLE `transition_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'workflow_engine'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-05 19:06:23
