-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_evhome
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `chargingpointproviders`
--

DROP TABLE IF EXISTS `chargingpointproviders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chargingpointproviders` (
  `providerDOB` datetime(6) NOT NULL,
  `providerUsername` varchar(15) NOT NULL,
  `providerPassword` varchar(16) NOT NULL,
  `providerFName` varchar(40) NOT NULL,
  `providerLName` varchar(40) NOT NULL,
  `providerType` varchar(50) NOT NULL,
  `providerEmail` varchar(100) NOT NULL,
  `approveDate` varchar(255) NOT NULL,
  `providerGender` varchar(255) NOT NULL,
  `providerIdCard` varchar(255) NOT NULL,
  `providerImg` varchar(255) DEFAULT NULL,
  `providerStatus` varchar(255) NOT NULL,
  `providerTel` varchar(255) NOT NULL,
  PRIMARY KEY (`providerUsername`),
  UNIQUE KEY `UKj786xtljtciwdhnajvah6bbj5` (`providerIdCard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chargingpointproviders`
--

LOCK TABLES `chargingpointproviders` WRITE;
/*!40000 ALTER TABLE `chargingpointproviders` DISABLE KEYS */;
/*!40000 ALTER TABLE `chargingpointproviders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chargingpoints`
--

DROP TABLE IF EXISTS `chargingpoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chargingpoints` (
  `chargingPointID` int(11) NOT NULL,
  `chargingPointStatus` int(11) NOT NULL,
  `chargingTypeID` int(11) DEFAULT NULL,
  `reserveDuration` int(11) NOT NULL,
  `serviceFee` double NOT NULL,
  `stationId` varchar(6) DEFAULT NULL,
  `chargingPointName` varchar(100) NOT NULL,
  PRIMARY KEY (`chargingPointID`),
  KEY `FKocdukqwr8wepvmq4mbmw8jt1f` (`chargingTypeID`),
  KEY `FK5ek00k6yebhk01jqnfw1u7fd6` (`stationId`),
  CONSTRAINT `FK5ek00k6yebhk01jqnfw1u7fd6` FOREIGN KEY (`stationId`) REFERENCES `stations` (`stationId`),
  CONSTRAINT `FKocdukqwr8wepvmq4mbmw8jt1f` FOREIGN KEY (`chargingTypeID`) REFERENCES `chargingtypes` (`chargingTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chargingpoints`
--

LOCK TABLES `chargingpoints` WRITE;
/*!40000 ALTER TABLE `chargingpoints` DISABLE KEYS */;
/*!40000 ALTER TABLE `chargingpoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chargingpoints_seq`
--

DROP TABLE IF EXISTS `chargingpoints_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chargingpoints_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chargingpoints_seq`
--

LOCK TABLES `chargingpoints_seq` WRITE;
/*!40000 ALTER TABLE `chargingpoints_seq` DISABLE KEYS */;
INSERT INTO `chargingpoints_seq` VALUES (1);
/*!40000 ALTER TABLE `chargingpoints_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chargingtypes`
--

DROP TABLE IF EXISTS `chargingtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chargingtypes` (
  `chargingTypeID` int(11) NOT NULL,
  `chargingTypeName` varchar(30) NOT NULL,
  PRIMARY KEY (`chargingTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chargingtypes`
--

LOCK TABLES `chargingtypes` WRITE;
/*!40000 ALTER TABLE `chargingtypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `chargingtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `memberID` int(11) NOT NULL,
  `memberGender` varchar(10) NOT NULL,
  `memberIdCard` varchar(13) NOT NULL,
  `memberTel` varchar(15) NOT NULL,
  `memberUsername` varchar(15) NOT NULL,
  `memberPassword` varchar(16) NOT NULL,
  `memberFName` varchar(40) NOT NULL,
  `memberLName` varchar(40) NOT NULL,
  `memberEmail` varchar(100) NOT NULL,
  `memberDOB` varchar(255) NOT NULL,
  `memberImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`memberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'Male','1529902166354','09473149999','Boo1','123456','Passakorn','Thamthong','b@gmail.com','01-05-2003','b.png');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members_seq`
--

DROP TABLE IF EXISTS `members_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members_seq`
--

LOCK TABLES `members_seq` WRITE;
/*!40000 ALTER TABLE `members_seq` DISABLE KEYS */;
INSERT INTO `members_seq` VALUES (51);
/*!40000 ALTER TABLE `members_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserves`
--

DROP TABLE IF EXISTS `reserves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserves` (
  `chargingPointID` int(11) DEFAULT NULL,
  `memberID` int(11) DEFAULT NULL,
  `reserveAmount` int(11) NOT NULL,
  `reserveId` int(11) NOT NULL,
  `reserveStatus` int(11) NOT NULL,
  `reserveDate` datetime(6) NOT NULL,
  `reserveEndTime` datetime(6) NOT NULL,
  `reserveStartTime` datetime(6) NOT NULL,
  PRIMARY KEY (`reserveId`),
  KEY `FKcnxlsqq9qg52anjxhcklft9u5` (`chargingPointID`),
  KEY `FKpul3xla0xvgsv1aj4mqt9ut9h` (`memberID`),
  CONSTRAINT `FKcnxlsqq9qg52anjxhcklft9u5` FOREIGN KEY (`chargingPointID`) REFERENCES `chargingpoints` (`chargingPointID`),
  CONSTRAINT `FKpul3xla0xvgsv1aj4mqt9ut9h` FOREIGN KEY (`memberID`) REFERENCES `members` (`memberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserves`
--

LOCK TABLES `reserves` WRITE;
/*!40000 ALTER TABLE `reserves` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserves_seq`
--

DROP TABLE IF EXISTS `reserves_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserves_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserves_seq`
--

LOCK TABLES `reserves_seq` WRITE;
/*!40000 ALTER TABLE `reserves_seq` DISABLE KEYS */;
INSERT INTO `reserves_seq` VALUES (1);
/*!40000 ALTER TABLE `reserves_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `reserveId` int(11) DEFAULT NULL,
  `reviewId` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  `reviewDate` datetime(6) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  UNIQUE KEY `UKks6wsgh6pn9j3n88o2vd744yc` (`reserveId`),
  CONSTRAINT `FK4tg99ykek7e5yq8bw6ypjbti2` FOREIGN KEY (`reserveId`) REFERENCES `reserves` (`reserveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews_seq`
--

DROP TABLE IF EXISTS `reviews_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews_seq`
--

LOCK TABLES `reviews_seq` WRITE;
/*!40000 ALTER TABLE `reviews_seq` DISABLE KEYS */;
INSERT INTO `reviews_seq` VALUES (1);
/*!40000 ALTER TABLE `reviews_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stations` (
  `chargingPointAmount` int(11) NOT NULL,
  `stationTypeID` int(11) DEFAULT NULL,
  `stationId` varchar(6) NOT NULL,
  `providerUsername` varchar(15) DEFAULT NULL,
  `stationName` varchar(100) NOT NULL,
  `address` varchar(150) NOT NULL,
  `contactInfomation` varchar(255) NOT NULL,
  `latitude` varchar(255) NOT NULL,
  `longtitude` varchar(255) NOT NULL,
  `serviceEndTime` varchar(255) NOT NULL,
  `serviceStartTime` varchar(255) NOT NULL,
  PRIMARY KEY (`stationId`),
  KEY `FK3ug43frrl8iaysudx50a468qb` (`providerUsername`),
  KEY `FKeer5dpthpftu51lf8jb0gv0ox` (`stationTypeID`),
  CONSTRAINT `FK3ug43frrl8iaysudx50a468qb` FOREIGN KEY (`providerUsername`) REFERENCES `chargingpointproviders` (`providerUsername`),
  CONSTRAINT `FKeer5dpthpftu51lf8jb0gv0ox` FOREIGN KEY (`stationTypeID`) REFERENCES `stationtypes` (`stationTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stationtypes`
--

DROP TABLE IF EXISTS `stationtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stationtypes` (
  `stationTypeID` int(11) NOT NULL,
  `stationTypeName` varchar(100) NOT NULL,
  PRIMARY KEY (`stationTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stationtypes`
--

LOCK TABLES `stationtypes` WRITE;
/*!40000 ALTER TABLE `stationtypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `stationtypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-21 15:30:20
