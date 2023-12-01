-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdviajes
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos` (
  `id_vuelo` int NOT NULL AUTO_INCREMENT,
  `compania` varchar(100) DEFAULT NULL,
  `fecha_vuelo` date DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `plazas_disponibles` int DEFAULT NULL,
  PRIMARY KEY (`id_vuelo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos`
--

LOCK TABLES `vuelos` WRITE;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` VALUES (1,'Ryanair','2023-11-30',74,50),(2,'Iberia','2024-01-02',44.86,33),(3,'Qatar Airways','2024-05-15',55,50),(4,'Airline A','2023-12-01',200,100),(5,'Flight Express','2023-12-05',150.5,117),(6,'Skyways Airlines','2023-12-10',300,200),(7,'JetStream Airways','2023-12-15',120,80),(8,'Wings of Freedom','2023-12-20',250,180),(9,'AeroTravel','2023-12-25',180.5,130),(10,'Cloud Nine Airlines','2023-12-30',350.5,190),(11,'FlyHigh Airways','2024-01-03',160.5,90),(12,'StarFlyer','2024-01-08',220,170),(13,'Global Jets','2024-01-13',110,110),(14,'SkyRiders','2024-01-18',280,190),(15,'AeroJet','2024-01-23',130.5,81),(16,'Swift Wings','2024-01-28',240,160),(17,'Blue Skies Airlines','2024-02-02',170.5,140),(18,'Silver Arrow Airways','2024-02-07',320,200),(19,'JetSetters','2024-02-12',140,87),(20,'Golden Wings','2024-02-17',200.5,131),(21,'Airline A','2024-02-22',190,135),(22,'Eagle Airlines','2024-02-27',280.5,180),(23,'Sunrise Aviation','2024-03-03',150,20),(30,'Fly Solo','2024-11-11',46.5,150);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01  9:42:12
