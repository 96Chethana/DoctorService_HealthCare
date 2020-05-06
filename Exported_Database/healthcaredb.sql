-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: healthcaredb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(45) DEFAULT NULL,
  `l_name` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phoneNo` int DEFAULT NULL,
  `nic` varchar(10) DEFAULT NULL,
  `hospital_name` varchar(45) DEFAULT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (3,'Nimal','Silva',44,'nimal2@gmail.com',771635698,'723834506V','Asiri Hospital | Lanka Hospital','Dentist'),(4,'Kavidu','Tharaka',28,'kavi2@gmail.com',760635698,'901834506V','Lanka Hospital | Nawaloka Hospital','Child Dentist'),(5,'Nirasha ','Silva',34,'nirasha34@gmai.com',774534567,'848245783v','Lanka Hospital | Nevil Fernando Hospital','Child physicologist'),(6,'Amaya','de Silva',30,'amaya30@gmai.com',773434567,'878245783v','Lanka Hospital | Nevil Fernando Hospital','Dentist');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctorfeedback`
--

DROP TABLE IF EXISTS `doctorfeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctorfeedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(20) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=446 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorfeedback`
--

LOCK TABLES `doctorfeedback` WRITE;
/*!40000 ALTER TABLE `doctorfeedback` DISABLE KEYS */;
INSERT INTO `doctorfeedback` VALUES (1,'Kavidu','2020-Jan-28','very good process'),(2,'Amal Perera','2020-Apr-09','Good process'),(3,'Kamak Silva','2020-MAY-09','Good process'),(111,'Kavidu Tharaka','2020-Jan-20','User Friendly system'),(222,'Amal Perera','2020-Feb-22','very good system'),(445,'Nirasha','2020-Apr-17','user friendly system');
/*!40000 ALTER TABLE `doctorfeedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctorprescription`
--

DROP TABLE IF EXISTS `doctorprescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctorprescription` (
  `prescription_id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(30) NOT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `medicine` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorprescription`
--

LOCK TABLES `doctorprescription` WRITE;
/*!40000 ALTER TABLE `doctorprescription` DISABLE KEYS */;
INSERT INTO `doctorprescription` VALUES (1,'Saman Perera','Kavidu Tharaka','paracetamo|	Insulin','get the insulin dose : 120 lbs'),(2,'Amila Perera','Nimal Silva','paracetamo|	Insulin | Vitamin B12 ','get the insulin dose : 120 lbs'),(3,'Oshani Anjana','Kavidu Tharaka','Apeo','get the Apeo dose : 160 lbs'),(4,'Supipi Uththama','Amal Perera','Apeo | insulin','get 2 paracetamol moring for per day');
/*!40000 ALTER TABLE `doctorprescription` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2020-05-06 18:27:01
