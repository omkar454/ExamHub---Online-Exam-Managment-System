-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: examhub
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `student_result_cppl_level1`
--

DROP TABLE IF EXISTS `student_result_cppl_level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo1`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo2`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo3`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo4`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo5`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level1_lo6`
--

DROP TABLE IF EXISTS `student_result_cppl_level1_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level1_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2`
--

DROP TABLE IF EXISTS `student_result_cppl_level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo1`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo2`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo3`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo4`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo5`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level2_lo6`
--

DROP TABLE IF EXISTS `student_result_cppl_level2_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level2_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3`
--

DROP TABLE IF EXISTS `student_result_cppl_level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo1`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo2`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo3`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo4`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo5`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_cppl_level3_lo6`
--

DROP TABLE IF EXISTS `student_result_cppl_level3_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_cppl_level3_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1`
--

DROP TABLE IF EXISTS `student_result_dbms_level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo1`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo2`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo3`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo4`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo5`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level1_lo6`
--

DROP TABLE IF EXISTS `student_result_dbms_level1_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level1_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2`
--

DROP TABLE IF EXISTS `student_result_dbms_level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo1`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo2`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo3`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo4`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo5`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level2_lo6`
--

DROP TABLE IF EXISTS `student_result_dbms_level2_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level2_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3`
--

DROP TABLE IF EXISTS `student_result_dbms_level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo1`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo2`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo3`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo4`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo5`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dbms_level3_lo6`
--

DROP TABLE IF EXISTS `student_result_dbms_level3_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dbms_level3_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1`
--

DROP TABLE IF EXISTS `student_result_dsa_level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo1`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo2`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo3`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo4`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo5`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level1_lo6`
--

DROP TABLE IF EXISTS `student_result_dsa_level1_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level1_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2`
--

DROP TABLE IF EXISTS `student_result_dsa_level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo1`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo2`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo3`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo4`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo5`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level2_lo6`
--

DROP TABLE IF EXISTS `student_result_dsa_level2_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level2_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3`
--

DROP TABLE IF EXISTS `student_result_dsa_level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo1`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo2`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo3`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo4`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo5`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_dsa_level3_lo6`
--

DROP TABLE IF EXISTS `student_result_dsa_level3_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_dsa_level3_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1`
--

DROP TABLE IF EXISTS `student_result_java_level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo1`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo2`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo3`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo4`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo5`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level1_lo6`
--

DROP TABLE IF EXISTS `student_result_java_level1_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level1_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2`
--

DROP TABLE IF EXISTS `student_result_java_level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo1`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo2`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo3`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo4`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo5`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level2_lo6`
--

DROP TABLE IF EXISTS `student_result_java_level2_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level2_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3`
--

DROP TABLE IF EXISTS `student_result_java_level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo1`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo1` (
  `Roll_number` varchar(50) NOT NULL,
  `lo1_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo2`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo2` (
  `Roll_number` varchar(50) NOT NULL,
  `lo2_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo3`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo3` (
  `Roll_number` varchar(50) NOT NULL,
  `lo3_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo4`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo4` (
  `Roll_number` varchar(50) NOT NULL,
  `lo4_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo5`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo5` (
  `Roll_number` varchar(50) NOT NULL,
  `lo5_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_result_java_level3_lo6`
--

DROP TABLE IF EXISTS `student_result_java_level3_lo6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_result_java_level3_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `roll_number` varchar(3) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `profile_image` mediumblob,
  PRIMARY KEY (`roll_number`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `unique_profile_image` (`profile_image`(3072)),
  CONSTRAINT `chk_password_length` CHECK ((length(`password`) between 4 and 8))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-05 21:03:44
