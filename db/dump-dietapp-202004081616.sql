-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: dietapp
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.6-MariaDB

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
-- Table structure for table `categoria_ingrediente`
--

DROP TABLE IF EXISTS `categoria_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_ingrediente` (
  `id_categoria_ingrediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_categoria_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_ingrediente`
--

LOCK TABLES `categoria_ingrediente` WRITE;
/*!40000 ALTER TABLE `categoria_ingrediente` DISABLE KEYS */;
INSERT INTO `categoria_ingrediente` VALUES (2,'lacteos'),(3,'frutas'),(4,'especias'),(5,'proteinas'),(6,'panaderia'),(7,'verduras'),(8,'frutos secos'),(9,'abarrotes'),(10,'cereales');
/*!40000 ALTER TABLE `categoria_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combo_dieta_usuario`
--

DROP TABLE IF EXISTS `combo_dieta_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo_dieta_usuario` (
  `id_combo_dieta_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_dieta_usuario` int(11) DEFAULT NULL,
  `id_receta_periodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_combo_dieta_usuario`),
  KEY `fk_combo_id_dieta_usuario` (`id_dieta_usuario`),
  KEY `fk_combo_id_receta_periodo` (`id_receta_periodo`),
  CONSTRAINT `fk_combo_id_dieta_usuario` FOREIGN KEY (`id_dieta_usuario`) REFERENCES `dieta_usuario` (`id_dieta_usuario`),
  CONSTRAINT `fk_combo_id_receta_periodo` FOREIGN KEY (`id_receta_periodo`) REFERENCES `receta_periodo` (`id_receta_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo_dieta_usuario`
--

LOCK TABLES `combo_dieta_usuario` WRITE;
/*!40000 ALTER TABLE `combo_dieta_usuario` DISABLE KEYS */;
INSERT INTO `combo_dieta_usuario` VALUES (1,1,2),(2,1,3),(3,1,4),(4,2,2),(5,2,3),(6,2,4),(7,3,2),(8,3,3),(9,3,4),(10,4,2),(11,4,3),(12,4,4),(13,5,2),(14,5,3),(15,5,4),(16,6,12),(17,6,9),(18,6,5),(19,6,11),(20,6,4),(21,7,2),(22,7,9),(23,7,3),(24,7,10),(25,7,7),(26,8,1),(27,8,9),(28,8,6),(29,8,11),(30,8,8),(31,9,12),(32,9,9),(33,9,3),(34,9,10),(35,9,7),(36,10,1),(37,10,9),(38,10,6),(39,10,11),(40,10,8),(41,11,3),(42,11,11),(43,11,4),(44,12,5),(45,12,11),(46,12,7),(47,13,3),(48,13,10),(49,13,8),(50,14,5),(51,14,11),(52,14,4),(53,15,3),(54,15,11),(55,15,7),(56,16,5),(57,16,10),(58,16,8),(59,17,3),(60,17,11),(61,17,7);
/*!40000 ALTER TABLE `combo_dieta_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta_usuario`
--

DROP TABLE IF EXISTS `dieta_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dieta_usuario` (
  `id_dieta_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `dia_semana` varchar(30) NOT NULL,
  PRIMARY KEY (`id_dieta_usuario`),
  KEY `fk_dieta_usuario_id_usuario` (`id_usuario`),
  CONSTRAINT `fk_dieta_usuario_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta_usuario`
--

LOCK TABLES `dieta_usuario` WRITE;
/*!40000 ALTER TABLE `dieta_usuario` DISABLE KEYS */;
INSERT INTO `dieta_usuario` VALUES (1,2,'lunes'),(2,2,'martes'),(3,2,'miercoles'),(4,2,'jueves'),(5,2,'viernes'),(6,4,'lunes'),(7,4,'martes'),(8,4,'miercoles'),(9,4,'jueves'),(10,4,'viernes'),(11,5,'lunes'),(12,5,'martes'),(13,5,'miercoles'),(14,5,'jueves'),(15,5,'viernes'),(16,5,'sabado'),(17,5,'domingo');
/*!40000 ALTER TABLE `dieta_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `id_ingrediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_categoria_ingrediente` int(11) NOT NULL,
  PRIMARY KEY (`id_ingrediente`),
  KEY `fk_id_categoria_ingrediente` (`id_categoria_ingrediente`),
  CONSTRAINT `fk_id_categoria_ingrediente` FOREIGN KEY (`id_categoria_ingrediente`) REFERENCES `categoria_ingrediente` (`id_categoria_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'berries',3),(2,'leche de almendra',2),(3,'chia',4),(4,'fresas',3),(5,'pescado tilapia',5),(6,'aderezo chipotle',3),(7,'tortillas',6),(8,'tostadas',6),(9,'queso panela',2),(10,'champinones',7),(11,'pollo',5),(12,'pollo',5),(13,'pimiento',7),(14,'cebolla',7),(15,'apio',7),(16,'caldo de pollo',9),(17,'huevos',5),(18,'espinaca',7),(19,'pan',6),(20,'pechuga de pavo',5),(21,'nueces',8),(22,'gelatina',9),(23,'palomitas',9),(24,'avena',10),(25,'canela',4);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layout`
--

DROP TABLE IF EXISTS `layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layout` (
  `id_layout` int(11) NOT NULL AUTO_INCREMENT,
  `layout` varchar(50) NOT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_layout`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout`
--

LOCK TABLES `layout` WRITE;
/*!40000 ALTER TABLE `layout` DISABLE KEYS */;
INSERT INTO `layout` VALUES (1,'BLD',1),(2,'BALPD',1),(3,'LPD',1);
/*!40000 ALTER TABLE `layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layout_periodo`
--

DROP TABLE IF EXISTS `layout_periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layout_periodo` (
  `id_layout_periodo` int(11) NOT NULL AUTO_INCREMENT,
  `id_layout` int(11) DEFAULT NULL,
  `id_periodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_layout_periodo`),
  KEY `fk_id_layout` (`id_layout`),
  KEY `fk_id_periodo` (`id_periodo`),
  CONSTRAINT `fk_id_layout` FOREIGN KEY (`id_layout`) REFERENCES `layout` (`id_layout`),
  CONSTRAINT `fk_id_periodo` FOREIGN KEY (`id_periodo`) REFERENCES `periodo` (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout_periodo`
--

LOCK TABLES `layout_periodo` WRITE;
/*!40000 ALTER TABLE `layout_periodo` DISABLE KEYS */;
INSERT INTO `layout_periodo` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,2,4),(6,2,2),(7,2,5),(8,2,3),(9,3,2),(10,3,5),(11,3,3);
/*!40000 ALTER TABLE `layout_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medida`
--

DROP TABLE IF EXISTS `medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medida` (
  `id_medida` int(11) NOT NULL AUTO_INCREMENT,
  `medida` varchar(50) NOT NULL,
  PRIMARY KEY (`id_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medida`
--

LOCK TABLES `medida` WRITE;
/*!40000 ALTER TABLE `medida` DISABLE KEYS */;
INSERT INTO `medida` VALUES (1,'taza'),(2,'Tbsp'),(3,'pieza'),(4,'gramos'),(5,'rebanada'),(6,'pizca');
/*!40000 ALTER TABLE `medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `id_periodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'Desayuno'),(2,'Comida'),(3,'Cena'),(4,'Snack AM'),(5,'Snack PM');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta` (
  `id_receta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_receta`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (2,'Chia Puddin'),(3,'Licuado'),(4,'Tacos de tilapia'),(5,'Tostada de champinon'),(6,'Faitas de pollo'),(7,'sopa de apio'),(8,'huevo'),(9,'sandwich'),(10,'Nueces y fresas'),(11,'gelatina sin azucar'),(12,'palomitas'),(13,'Avena');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_ingrediente`
--

DROP TABLE IF EXISTS `receta_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta_ingrediente` (
  `id_receta_ingrediente` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `id_receta` int(11) DEFAULT NULL,
  `id_medida` int(11) DEFAULT NULL,
  `id_ingrediente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_receta_ingrediente`),
  KEY `fk_id_receta` (`id_receta`),
  KEY `fk_id_medida` (`id_medida`),
  KEY `fk_id_ingrediente` (`id_ingrediente`),
  CONSTRAINT `fk_id_ingrediente` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingrediente` (`id_ingrediente`),
  CONSTRAINT `fk_id_medida` FOREIGN KEY (`id_medida`) REFERENCES `medida` (`id_medida`),
  CONSTRAINT `fk_id_receta` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id_receta`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_ingrediente`
--

LOCK TABLES `receta_ingrediente` WRITE;
/*!40000 ALTER TABLE `receta_ingrediente` DISABLE KEYS */;
INSERT INTO `receta_ingrediente` VALUES (1,0.50,2,1,3),(2,1.00,2,1,2),(3,5.00,2,3,4),(4,1.00,3,1,1),(5,1.00,3,1,2),(6,1.00,3,2,3),(7,300.00,4,4,5),(8,1.00,4,2,6),(9,2.00,4,3,7),(10,2.00,5,3,8),(11,100.00,5,4,9),(12,1.00,5,1,10),(13,100.00,6,4,11),(14,1.00,6,3,13),(15,1.00,6,3,14),(16,2.00,6,3,8),(17,4.00,7,1,16),(18,8.00,7,3,15),(19,1.00,7,3,14),(20,2.00,8,3,17),(21,1.00,8,1,18),(22,2.00,9,5,19),(23,2.00,9,5,20),(24,30.00,9,4,9),(25,7.00,10,3,4),(26,7.00,10,3,21),(27,1.00,11,1,22),(28,1.00,12,1,23),(29,1.00,13,1,2),(30,1.00,13,1,24),(31,1.00,13,6,25);
/*!40000 ALTER TABLE `receta_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_periodo`
--

DROP TABLE IF EXISTS `receta_periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta_periodo` (
  `id_receta_periodo` int(11) NOT NULL AUTO_INCREMENT,
  `id_receta` int(11) DEFAULT NULL,
  `id_periodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_receta_periodo`),
  KEY `fk_receta_periodo_id_receta` (`id_receta`),
  KEY `fk_receta_periodo_id_periodo` (`id_periodo`),
  CONSTRAINT `fk_receta_periodo_id_periodo` FOREIGN KEY (`id_periodo`) REFERENCES `periodo` (`id_periodo`),
  CONSTRAINT `fk_receta_periodo_id_receta` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id_receta`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_periodo`
--

LOCK TABLES `receta_periodo` WRITE;
/*!40000 ALTER TABLE `receta_periodo` DISABLE KEYS */;
INSERT INTO `receta_periodo` VALUES (1,2,1),(2,3,1),(3,4,2),(4,5,3),(5,6,2),(6,7,2),(7,8,3),(8,9,3),(9,10,4),(10,11,5),(11,12,5),(12,13,1);
/*!40000 ALTER TABLE `receta_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Victor Herrera','vampy.mcr.23@gmail.com'),(4,'Georgina Merla','geormerla@gmail.com'),(5,'Stefani Patoni','stefani@email.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_layout`
--

DROP TABLE IF EXISTS `usuario_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_layout` (
  `id_usuario_layout` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `id_layout` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario_layout`),
  KEY `fk_usuario_layout_id_usuario` (`id_usuario`),
  KEY `fk_usuario_layout_id_layout` (`id_layout`),
  CONSTRAINT `fk_usuario_layout_id_layout` FOREIGN KEY (`id_layout`) REFERENCES `layout` (`id_layout`),
  CONSTRAINT `fk_usuario_layout_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_layout`
--

LOCK TABLES `usuario_layout` WRITE;
/*!40000 ALTER TABLE `usuario_layout` DISABLE KEYS */;
INSERT INTO `usuario_layout` VALUES (1,2,1,'2019-11-11'),(2,4,2,'2019-11-11'),(3,5,3,'2019-11-11');
/*!40000 ALTER TABLE `usuario_layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dietapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-08 16:16:11
