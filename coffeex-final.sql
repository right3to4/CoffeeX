CREATE DATABASE  IF NOT EXISTS `coffeex` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coffeex`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: coffeex
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addcart`
--

DROP TABLE IF EXISTS `addcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addcart` (
  `mmanegeid` varchar(45) NOT NULL,
  `custid` varchar(45) NOT NULL,
  `addcartdate` datetime DEFAULT NULL,
  `addcartquantity` int DEFAULT NULL,
  `addcartoption` varchar(45) NOT NULL,
  PRIMARY KEY (`mmanegeid`,`custid`,`addcartoption`),
  KEY `fk_addcart_customer1_idx` (`custid`),
  CONSTRAINT `fk_addcart_customer1` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`),
  CONSTRAINT `fk_addcart_menumanage1` FOREIGN KEY (`mmanegeid`) REFERENCES `menumanage` (`mmanageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addcart`
--

LOCK TABLES `addcart` WRITE;
/*!40000 ALTER TABLE `addcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `addcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `belong`
--

DROP TABLE IF EXISTS `belong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `belong` (
  `belongstaffid` int NOT NULL,
  `belongshopid` varchar(45) NOT NULL,
  `belongdate` datetime DEFAULT NULL,
  PRIMARY KEY (`belongstaffid`,`belongshopid`),
  KEY `fk_belong_shop1_idx` (`belongshopid`),
  CONSTRAINT `fk_belong_shop1` FOREIGN KEY (`belongshopid`) REFERENCES `shop` (`shopid`),
  CONSTRAINT `fk_belong_staff1` FOREIGN KEY (`belongstaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `belong`
--

LOCK TABLES `belong` WRITE;
/*!40000 ALTER TABLE `belong` DISABLE KEYS */;
INSERT INTO `belong` VALUES (1111,'강남점','2022-10-13 20:11:14'),(2222,'송파점','2022-10-13 19:22:26'),(3333,'강남점','2022-10-13 19:22:41'),(2022091204,'강남점','2022-07-01 00:00:00'),(2022091302,'송파점','2022-07-03 00:00:00'),(2022100104,'신림점','2022-07-03 00:00:00'),(2022100905,'송파점','2022-07-01 00:00:00'),(2022101003,'강남점','2022-07-01 00:00:00'),(2022101206,'신림점','2022-07-02 00:00:00');
/*!40000 ALTER TABLE `belong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custid` varchar(45) NOT NULL,
  `custname` varchar(45) DEFAULT NULL,
  `custphone` varchar(45) DEFAULT NULL,
  `custpw` varchar(45) DEFAULT NULL,
  `custpoint` int DEFAULT NULL,
  `custsignindate` datetime DEFAULT NULL,
  `custupdatedate` datetime DEFAULT NULL,
  `custdeletedate` datetime DEFAULT NULL,
  PRIMARY KEY (`custid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('kiosk','매장 구매',NULL,NULL,NULL,'2022-10-13 00:00:00',NULL,NULL),('mirrorspring','손유승','0107151432',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `managermenumanage`
--

DROP TABLE IF EXISTS `managermenumanage`;
/*!50001 DROP VIEW IF EXISTS `managermenumanage`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `managermenumanage` AS SELECT 
 1 AS `menuid`,
 1 AS `category`,
 1 AS `menuname`,
 1 AS `price`,
 1 AS `photo`,
 1 AS `info`,
 1 AS `createdate`,
 1 AS `updatedate`,
 1 AS `shopname`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menuid` int NOT NULL,
  `mcategory` varchar(45) DEFAULT NULL,
  `menuname` varchar(45) DEFAULT NULL,
  `mprice` int DEFAULT NULL,
  `menuphoto` longblob,
  `menuinfo` varchar(500) DEFAULT NULL,
  `mcreatedate` datetime DEFAULT NULL,
  `mupdatedate` datetime DEFAULT NULL,
  `mdeletedate` datetime DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'커피','아메리카노',2800,NULL,'깔끔한 아메리카노','2022-10-13 00:00:00',NULL,NULL),(2,'커피','카페라떼',3500,NULL,'부드러운 카페라떼','2022-10-13 16:37:33',NULL,NULL),(3,'에이드','레몬에이드',3500,NULL,'새콤한 레몬에이드','2022-10-13 16:37:36',NULL,NULL),(4,'티','그린티',3200,NULL,'기본적인 그린티','2022-10-13 16:37:38',NULL,NULL),(5,'사이드','치즈케이크',9500,NULL,'달콤한 치즈케이크','2022-10-13 16:42:18',NULL,NULL),(6,'스무디','블루베리스무디',4300,NULL,'시원한 블루베리스무디','2022-10-13 16:42:56',NULL,NULL),(7,'커피','콜드브루',4000,NULL,'깊은 맛의 콜드브루','2022-10-13 18:32:49',NULL,NULL),(8,'스무디','청도홍시스무디',4400,NULL,'청도의 명물 홍시로 만든 스무디','2022-10-13 18:34:12',NULL,NULL),(9,'사이드','허니버터피자',5500,NULL,'단짠단짠 허니버터피자','2022-10-13 18:34:55',NULL,NULL),(10,'커피','카푸치노',4500,NULL,'거품 가득 카푸치노','2022-10-13 18:35:54',NULL,NULL),(11,'티','밀크티',5500,NULL,'담백한 밀크티','2022-10-13 18:37:35',NULL,NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menumanage`
--

DROP TABLE IF EXISTS `menumanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menumanage` (
  `mmanageid` varchar(45) NOT NULL,
  `mmanagestaffid` int NOT NULL,
  `mmanageshopid` varchar(45) NOT NULL,
  `mmanagemenuid` int NOT NULL,
  `mmanagecreatedate` datetime DEFAULT NULL,
  `mmanageupdatedate` datetime DEFAULT NULL,
  `mmanagedeletedate` datetime DEFAULT NULL,
  `menumanagecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mmanageid`,`mmanagestaffid`,`mmanageshopid`,`mmanagemenuid`),
  KEY `fk_menumanage_staff1_idx` (`mmanagestaffid`),
  KEY `fk_menumanage_shop1_idx` (`mmanageshopid`),
  KEY `fk_menumanage_menu1_idx` (`mmanagemenuid`),
  CONSTRAINT `fk_menumanage_menu1` FOREIGN KEY (`mmanagemenuid`) REFERENCES `menu` (`menuid`),
  CONSTRAINT `fk_menumanage_shop1` FOREIGN KEY (`mmanageshopid`) REFERENCES `shop` (`shopid`),
  CONSTRAINT `fk_menumanage_staff1` FOREIGN KEY (`mmanagestaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menumanage`
--

LOCK TABLES `menumanage` WRITE;
/*!40000 ALTER TABLE `menumanage` DISABLE KEYS */;
INSERT INTO `menumanage` VALUES ('1',2222,'강남점',1,'2022-10-13 00:00:00',NULL,NULL,NULL),('1',2022091302,'송파점',1,'2022-10-13 00:00:00',NULL,NULL,NULL),('1',2022101206,'신림점',1,'2022-10-13 00:00:00',NULL,NULL,NULL),('11',2022101206,'신림점',11,'2022-10-13 00:00:00',NULL,NULL,NULL),('3',2222,'강남점',3,'2022-10-13 00:00:00',NULL,NULL,NULL),('3',2022091302,'송파점',3,'2022-10-13 00:00:00',NULL,NULL,NULL),('4',2222,'강남점',4,'2022-10-13 00:00:00',NULL,NULL,NULL),('4',2022091302,'송파점',4,'2022-10-13 00:00:00',NULL,NULL,NULL),('5',2222,'강남점',5,'2022-10-13 00:00:00',NULL,NULL,NULL),('6',2022101206,'신림점',6,'2022-10-13 00:00:00',NULL,NULL,NULL),('7',2022091302,'송파점',7,'2022-10-13 00:00:00',NULL,NULL,NULL),('9',2022101206,'신림점',9,'2022-10-13 00:00:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `menumanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `mmanage`
--

DROP TABLE IF EXISTS `mmanage`;
/*!50001 DROP VIEW IF EXISTS `mmanage`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mmanage` AS SELECT 
 1 AS `category`,
 1 AS `menuname`,
 1 AS `price`,
 1 AS `photo`,
 1 AS `info`,
 1 AS `createdate`,
 1 AS `updatedate`,
 1 AS `deletedate`,
 1 AS `shopname`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `noticeid` int NOT NULL AUTO_INCREMENT,
  `noticestaffid` int NOT NULL,
  `noticetitle` varchar(45) DEFAULT NULL,
  `noticetext` varchar(500) DEFAULT NULL,
  `noticeinsertdate` datetime DEFAULT NULL,
  `noticeupdatedate` datetime DEFAULT NULL,
  `noticedeletedate` datetime DEFAULT NULL,
  PRIMARY KEY (`noticeid`),
  KEY `fk_table1_staff_idx` (`noticestaffid`),
  CONSTRAINT `fk_table1_staff` FOREIGN KEY (`noticestaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (11,2022090303,'원두 변경','커피에 사용되는 원두가 케냐 AA에서 콜롬비아 수프리모로 변경되었습니다. 참고 바랍니다.','2022-06-15 18:00:00',NULL,NULL),(12,2022090303,'키오스크 도입','금일부로 전 매장에 키오스크를 도입했습니다. 키오스크가 도착하는 대로 설정 후, 고객들에게 키오스크 사용을 안내 바랍니다','2022-07-20 10:00:00',NULL,NULL),(13,2022090303,'CoffeeX 인스타그램 계정 개설','CoffeeX의 인스타그램 계정을 개설했습니다. 홍보 자료를 첨부하니 출력하여 사용하시기 바랍니다.','2022-08-15 15:00:05',NULL,NULL),(14,2022090303,'매장 위생 관련','정부 감사 결과 매장 위생이 미흡하다는 지적이 나왔습니다. 위생에 더 신경써 주시기 바랍니다.','2022-08-17 13:05:15',NULL,NULL);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `ordersstaffid` int NOT NULL,
  `ordersshopid` varchar(45) NOT NULL,
  `orderscustomerid` varchar(45) NOT NULL,
  `ordersmmanageid` varchar(45) NOT NULL,
  `ordersstatus` varchar(45) DEFAULT NULL,
  `ordersquantity` int DEFAULT NULL,
  `ordersoption` varchar(45) NOT NULL,
  `orderspaymentoptions` varchar(45) DEFAULT NULL,
  `orderssaleprice` int DEFAULT NULL,
  `ordersplaceselect` varchar(45) DEFAULT NULL,
  `ordersdate` datetime DEFAULT NULL,
  `ordersreservationtime` int DEFAULT NULL,
  PRIMARY KEY (`orderid`,`ordersstaffid`,`ordersshopid`,`orderscustomerid`,`ordersmmanageid`,`ordersoption`),
  KEY `fk_orders_staff1_idx` (`ordersstaffid`),
  KEY `fk_orders_shop1_idx` (`ordersshopid`),
  KEY `fk_orders_customer1_idx` (`orderscustomerid`),
  KEY `fk_orders_menumanage1_idx` (`ordersmmanageid`),
  CONSTRAINT `fk_orders_customer1` FOREIGN KEY (`orderscustomerid`) REFERENCES `customer` (`custid`),
  CONSTRAINT `fk_orders_menumanage1` FOREIGN KEY (`ordersmmanageid`) REFERENCES `menumanage` (`mmanageid`),
  CONSTRAINT `fk_orders_shop1` FOREIGN KEY (`ordersshopid`) REFERENCES `shop` (`shopid`),
  CONSTRAINT `fk_orders_staff1` FOREIGN KEY (`ordersstaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (62,2022091204,'강남점','kiosk','5','제조완료',1,'HOT',NULL,9500,'매장 식사','2022-10-13 00:00:00',NULL),(63,2022101003,'강남점','kiosk','1','제조완료',3,'ICE, 바닐라시럽',NULL,8400,'매장 식사','2022-10-13 00:00:00',NULL),(64,2022100104,'신림점','kiosk','1','제조완료',2,'HOT, 휘핑추가, 바닐라시럽',NULL,5600,'포장','2022-10-13 00:00:00',NULL),(65,2022100104,'신림점','kiosk','9','제조완료',3,'HOT',NULL,16500,'매장 식사','2022-10-13 00:00:00',NULL),(66,2022101206,'신림점','kiosk','1','제조완료',1,'ICE',NULL,2800,'포장','2022-10-13 00:00:00',NULL),(67,2222,'송파점','kiosk','9','제조완료',2,'HOT',NULL,11000,'포장','2022-10-13 00:00:00',NULL),(68,2022100905,'송파점','kiosk','3','제조완료',3,'HOT',NULL,10500,'포장','2022-10-13 00:00:00',NULL),(69,2222,'송파점','kiosk','4','제조완료',1,'HOT',NULL,3200,'포장','2022-10-13 00:00:00',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `orderview`
--

DROP TABLE IF EXISTS `orderview`;
/*!50001 DROP VIEW IF EXISTS `orderview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `orderview` AS SELECT 
 1 AS `orderid`,
 1 AS `staff`,
 1 AS `menu`,
 1 AS `ordersstatus`,
 1 AS `quantity`,
 1 AS `price`,
 1 AS `ordersoption`,
 1 AS `dates`,
 1 AS `shop`,
 1 AS `place`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pay`
--

DROP TABLE IF EXISTS `pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay` (
  `paystaffid` int NOT NULL,
  `paydate` datetime NOT NULL,
  `payamount` int DEFAULT NULL,
  `payincentive` int DEFAULT NULL,
  PRIMARY KEY (`paystaffid`,`paydate`),
  CONSTRAINT `fk_pay_staff2` FOREIGN KEY (`paystaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay`
--

LOCK TABLES `pay` WRITE;
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
INSERT INTO `pay` VALUES (1111,'2022-05-10 00:00:00',500000,NULL),(1111,'2022-06-10 00:00:00',500000,NULL),(1111,'2022-07-10 00:00:00',500000,NULL),(1111,'2022-08-10 00:00:00',500000,50000),(1111,'2022-09-10 00:00:00',500000,NULL),(1111,'2022-10-10 00:00:00',500000,NULL),(2222,'2022-05-10 00:00:00',1500000,NULL),(2222,'2022-06-10 00:00:00',1500000,150000),(2222,'2022-07-10 00:00:00',1500000,NULL),(2222,'2022-08-10 00:00:00',1500000,150000),(2222,'2022-09-10 00:00:00',1500000,NULL),(2222,'2022-10-10 00:00:00',1500000,NULL),(3333,'2022-05-10 00:00:00',2500000,NULL),(3333,'2022-06-10 00:00:00',2500000,NULL),(3333,'2022-07-10 00:00:00',2500000,150000),(3333,'2022-08-10 00:00:00',2500000,NULL),(3333,'2022-09-10 00:00:00',2500000,NULL),(3333,'2022-10-10 00:00:00',2500000,NULL),(2022090303,'2022-05-10 00:00:00',3000000,NULL),(2022090303,'2022-06-10 00:00:00',2500000,NULL),(2022090303,'2022-07-10 00:00:00',2500000,NULL),(2022090303,'2022-08-10 00:00:00',2500000,NULL),(2022090303,'2022-09-10 00:00:00',2500000,NULL),(2022090303,'2022-10-10 00:00:00',2500000,NULL),(2022091204,'2022-06-10 00:00:00',2500000,NULL),(2022091204,'2022-07-10 00:00:00',1500000,NULL),(2022091204,'2022-08-10 00:00:00',1500000,NULL),(2022091204,'2022-09-10 00:00:00',1500000,NULL),(2022091204,'2022-10-10 00:00:00',1500000,NULL),(2022091302,'2022-06-10 00:00:00',1500000,NULL),(2022091302,'2022-07-10 00:00:00',1500000,NULL),(2022091302,'2022-08-10 00:00:00',1500000,150000),(2022091302,'2022-09-10 00:00:00',1500000,NULL),(2022091302,'2022-10-10 00:00:00',1500000,NULL),(2022100104,'2022-07-10 00:00:00',500000,NULL),(2022100104,'2022-08-10 00:00:00',500000,NULL),(2022100104,'2022-09-10 00:00:00',500000,200000),(2022100104,'2022-10-10 00:00:00',500000,NULL),(2022100905,'2022-06-10 00:00:00',800000,NULL),(2022100905,'2022-07-10 00:00:00',500000,NULL),(2022100905,'2022-08-10 00:00:00',500000,NULL),(2022100905,'2022-09-10 00:00:00',500000,50000),(2022100905,'2022-10-10 00:00:00',500000,NULL),(2022101003,'2022-06-10 00:00:00',500000,NULL),(2022101003,'2022-07-10 00:00:00',500000,NULL),(2022101003,'2022-08-10 00:00:00',500000,NULL),(2022101003,'2022-09-10 00:00:00',500000,NULL),(2022101003,'2022-10-10 00:00:00',500000,100000),(2022101206,'2022-06-10 00:00:00',1800000,NULL),(2022101206,'2022-07-10 00:00:00',1500000,NULL),(2022101206,'2022-08-10 00:00:00',1500000,NULL),(2022101206,'2022-09-10 00:00:00',1500000,NULL),(2022101206,'2022-10-10 00:00:00',1500000,NULL);
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promote`
--

DROP TABLE IF EXISTS `promote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promote` (
  `promotestaffid` int NOT NULL,
  `position` varchar(45) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  PRIMARY KEY (`promotestaffid`),
  CONSTRAINT `fk_promote_staff1` FOREIGN KEY (`promotestaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promote`
--

LOCK TABLES `promote` WRITE;
/*!40000 ALTER TABLE `promote` DISABLE KEYS */;
INSERT INTO `promote` VALUES (1111,'직원','2022-10-13 19:23:04'),(2222,'점장','2022-10-13 19:23:19'),(3333,'관리자','2022-10-13 19:23:33'),(2022090303,'관리자','2022-05-01 00:00:00'),(2022091204,'점장','2022-07-10 00:00:00'),(2022091302,'점장','2022-07-11 00:00:00'),(2022100104,'직원','2022-07-10 00:00:00'),(2022100905,'직원','2022-07-11 00:00:00'),(2022101003,'직원','2022-07-08 00:00:00'),(2022101206,'점장','2022-07-09 00:00:00');
/*!40000 ALTER TABLE `promote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punchinout`
--

DROP TABLE IF EXISTS `punchinout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punchinout` (
  `punchshopid` varchar(45) NOT NULL,
  `punchstaffid` int NOT NULL,
  `punchintime` datetime DEFAULT NULL,
  `punchouttime` datetime DEFAULT NULL,
  PRIMARY KEY (`punchshopid`,`punchstaffid`),
  KEY `fk_table1_staff1_idx` (`punchstaffid`),
  CONSTRAINT `fk_table1_shop1` FOREIGN KEY (`punchshopid`) REFERENCES `shop` (`shopid`),
  CONSTRAINT `fk_table1_staff1` FOREIGN KEY (`punchstaffid`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punchinout`
--

LOCK TABLES `punchinout` WRITE;
/*!40000 ALTER TABLE `punchinout` DISABLE KEYS */;
/*!40000 ALTER TABLE `punchinout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `shopid` varchar(45) NOT NULL,
  `shopaddress` varchar(45) DEFAULT NULL,
  `shopphone` varchar(45) DEFAULT NULL,
  `shopphoto` longblob,
  `openinghours` varchar(45) DEFAULT NULL,
  `openingdate` datetime DEFAULT NULL,
  `closingdate` datetime DEFAULT NULL,
  `shopphotoname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES ('강남점','강남구 테헤란로','024358625',NULL,'09시부터 22시까지','2022-10-13 16:45:37',NULL,'1'),('송파점','송파구 송파대로','026751573',NULL,'10시부터 23시까지','2022-10-13 16:46:07',NULL,'1'),('신림점','관악구 문성로','027249525',NULL,'07시부터 16시까지','2022-10-13 16:47:57',NULL,'1');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staffid` int NOT NULL,
  `staffname` varchar(45) DEFAULT NULL,
  `staffpw` varchar(45) DEFAULT NULL,
  `staffphone` varchar(45) DEFAULT NULL,
  `staffhourlywage` int DEFAULT NULL,
  `staffinitdate` datetime DEFAULT NULL,
  `staffdeletedate` datetime DEFAULT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1111,'test','1234','01011112222',10000,'2022-10-13 19:19:57',NULL),(2222,'test2','1234','01011112222',20000,'2022-10-13 19:20:27',NULL),(3333,'test3','1234','01011112222',30000,'2022-10-13 19:20:49',NULL),(2022090303,'손유승','1234','01057151432',30000,'2022-05-01 00:00:00',NULL),(2022091204,'신오수','1234','01084352495',20000,'2022-04-29 00:00:00',NULL),(2022091302,'이준혁','1234','01084325956',20000,'2022-05-15 00:00:00',NULL),(2022100104,'이상혁','1234','01057620243',10000,'2022-06-10 00:00:00',NULL),(2022100905,'안수빈','1234','01081543825',10000,'2022-04-30 00:00:00',NULL),(2022101003,'김진형','1234','01084324685',10000,'2022-05-15 00:00:00',NULL),(2022101206,'황요한','1234','01072684552',20000,'2022-05-05 00:00:00',NULL);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `viewcart`
--

DROP TABLE IF EXISTS `viewcart`;
/*!50001 DROP VIEW IF EXISTS `viewcart`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewcart` AS SELECT 
 1 AS `custid`,
 1 AS `menu`,
 1 AS `price`,
 1 AS `quantity`,
 1 AS `addoption`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `managermenumanage`
--

/*!50001 DROP VIEW IF EXISTS `managermenumanage`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `managermenumanage` AS select `menu`.`menuid` AS `menuid`,`menu`.`mcategory` AS `category`,`menu`.`menuname` AS `menuname`,`menu`.`mprice` AS `price`,`menu`.`menuphoto` AS `photo`,`menu`.`menuinfo` AS `info`,cast(`menumanage`.`mmanagecreatedate` as date) AS `createdate`,`menu`.`mupdatedate` AS `updatedate`,`shop`.`shopid` AS `shopname` from ((`menu` join `shop`) join `menumanage`) where ((`menumanage`.`mmanagemenuid` = `menu`.`menuid`) and (`menumanage`.`mmanageshopid` = `shop`.`shopid`) and (`menu`.`mdeletedate` is null)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mmanage`
--

/*!50001 DROP VIEW IF EXISTS `mmanage`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mmanage` AS select `menu`.`mcategory` AS `category`,`menu`.`menuname` AS `menuname`,`menu`.`mprice` AS `price`,`menu`.`menuphoto` AS `photo`,`menu`.`menuinfo` AS `info`,`menumanage`.`mmanagecreatedate` AS `createdate`,`menu`.`mupdatedate` AS `updatedate`,`menu`.`mdeletedate` AS `deletedate`,`shop`.`shopid` AS `shopname` from ((`menu` join `shop`) join `menumanage`) where ((`menumanage`.`mmanagemenuid` = `menu`.`menuid`) and (`menumanage`.`mmanageshopid` = `shop`.`shopid`) and (`menu`.`mdeletedate` is null)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `orderview`
--

/*!50001 DROP VIEW IF EXISTS `orderview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orderview` AS select `orders`.`orderid` AS `orderid`,`staff`.`staffname` AS `staff`,`menu`.`menuname` AS `menu`,`orders`.`ordersstatus` AS `ordersstatus`,`orders`.`ordersquantity` AS `quantity`,`orders`.`orderssaleprice` AS `price`,`orders`.`ordersoption` AS `ordersoption`,`orders`.`ordersdate` AS `dates`,`shop`.`shopid` AS `shop`,`orders`.`ordersplaceselect` AS `place` from (((`orders` join `menu`) join `staff`) join `shop`) where ((`staff`.`staffid` = `orders`.`ordersstaffid`) and (`menu`.`menuid` = `orders`.`ordersmmanageid`) and (`shop`.`shopid` = `orders`.`ordersshopid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewcart`
--

/*!50001 DROP VIEW IF EXISTS `viewcart`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewcart` AS select `customer`.`custid` AS `custid`,`menu`.`menuname` AS `menu`,`menu`.`mprice` AS `price`,`addcart`.`addcartquantity` AS `quantity`,`addcart`.`addcartoption` AS `addoption` from ((`customer` join `menu`) join `addcart`) where ((`customer`.`custid` = `addcart`.`custid`) and (`menu`.`menuid` = `addcart`.`mmanegeid`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-14  1:42:09
