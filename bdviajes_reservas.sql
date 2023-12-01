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
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(100) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `id_hotel` int NOT NULL,
  `id_vuelo` int NOT NULL,
  `numero_personas` int DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_vuelo_idx` (`id_vuelo`),
  KEY `id_hotel_idx` (`id_hotel`),
  CONSTRAINT `id_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hoteles` (`id_hotel`),
  CONSTRAINT `id_vuelo` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos` (`id_vuelo`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,'Rafa Sanchez','77845259L',3,3,5),(2,'Carmen Cumplido','28459814B',3,3,1),(3,'Paco Lopez','44859962A',1,1,5),(4,'Maria Garcia','77841598P',2,2,1),(5,'Marco Gonzalez','28468828A',2,2,1),(6,'Juan Perez','12345678A',1,3,2),(7,'Ana Rodriguez','98765432B',2,7,1),(8,'Carlos Lopez','45678901C',4,12,3),(9,'Maria Sanchez','78901234D',3,5,2),(10,'Pedro Gomez','23456789E',1,10,4),(11,'Laura Torres','56789012F',2,15,1),(12,'Luis Martinez','89012345G',4,19,2),(13,'Elena Ramirez','34567890H',3,2,3),(14,'Roberto Fernandez','01234567J',1,6,1),(15,'Carmen Herrera','67890123K',19,11,4),(16,'Javier Diaz','90123456L',4,16,2),(17,'Sofia Castro','34567890M',3,20,3),(18,'Miguel Ruiz','67890123N',22,4,1),(19,'Isabel Flores','12345678P',2,9,2),(20,'Antonio Gonzalez','23456789Q',4,14,1),(21,'Raquel Vargas','56789012R',20,18,3),(22,'Francisco Jimenez','89012345S',1,1,2),(23,'Eva Molina','01234567T',2,8,1),(24,'Daniel Soto','34567890U',11,13,4),(25,'Silvia Ortega','67890123V',11,17,2),(45,'Paco Gonzalez','28468828A',15,5,3);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01  9:42:13
