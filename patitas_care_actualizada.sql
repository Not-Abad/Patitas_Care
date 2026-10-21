-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: patitas_care
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bit_movimientos`
--

DROP TABLE IF EXISTS `bit_movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bit_movimientos` (
  `id_bitacora` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_accion` int(11) NOT NULL,
  `tabla_afectada` varchar(50) NOT NULL,
  `id_registro_afectado` int(11) DEFAULT NULL,
  `valor_anterior` text DEFAULT NULL,
  `valor_nuevo` text DEFAULT NULL,
  `fecha_movimiento` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_bitacora`),
  KEY `fk_bitacora_empleado` (`id_empleado`),
  KEY `fk_bitacora_accion` (`id_accion`),
  CONSTRAINT `fk_bitacora_accion` FOREIGN KEY (`id_accion`) REFERENCES `cat_accion_bitacora` (`id_accion`),
  CONSTRAINT `fk_bitacora_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `mts_empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bit_movimientos`
--

LOCK TABLES `bit_movimientos` WRITE;
/*!40000 ALTER TABLE `bit_movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `bit_movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_accion_bitacora`
--

DROP TABLE IF EXISTS `cat_accion_bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_accion_bitacora` (
  `id_accion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_accion` varchar(20) NOT NULL,
  PRIMARY KEY (`id_accion`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_accion_bitacora`
--

LOCK TABLES `cat_accion_bitacora` WRITE;
/*!40000 ALTER TABLE `cat_accion_bitacora` DISABLE KEYS */;
INSERT INTO `cat_accion_bitacora` VALUES (1,'Sin especificar'),(2,'Agregó'),(3,'Modificó'),(4,'Borró'),(5,'Consultó'),(6,'Inició Sesión'),(7,'Cerró Sesión');
/*!40000 ALTER TABLE `cat_accion_bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_especie`
--

DROP TABLE IF EXISTS `cat_especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_especie` (
  `id_especie` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_especie` varchar(50) NOT NULL,
  PRIMARY KEY (`id_especie`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_especie`
--

LOCK TABLES `cat_especie` WRITE;
/*!40000 ALTER TABLE `cat_especie` DISABLE KEYS */;
INSERT INTO `cat_especie` VALUES (1,'Canino'),(2,'Felino'),(3,'Ave'),(4,'Lagomorfo'),(5,'Roedor'),(6,'Reptil'),(7,'Mustélido'),(8,'Pez'),(9,'Anfibio'),(10,'Arácnido');
/*!40000 ALTER TABLE `cat_especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_estatus_cita`
--

DROP TABLE IF EXISTS `cat_estatus_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_estatus_cita` (
  `id_estatus_cita` int(11) NOT NULL AUTO_INCREMENT,
  `nom_estatus_cita` varchar(20) NOT NULL,
  PRIMARY KEY (`id_estatus_cita`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_estatus_cita`
--

LOCK TABLES `cat_estatus_cita` WRITE;
/*!40000 ALTER TABLE `cat_estatus_cita` DISABLE KEYS */;
INSERT INTO `cat_estatus_cita` VALUES (1,'Pendiente'),(2,'Cancelada'),(3,'Atendida');
/*!40000 ALTER TABLE `cat_estatus_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_estatus_cliente`
--

DROP TABLE IF EXISTS `cat_estatus_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_estatus_cliente` (
  `id_estatus` int(11) NOT NULL AUTO_INCREMENT,
  `nom_estatus_cliente` varchar(15) NOT NULL,
  PRIMARY KEY (`id_estatus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_estatus_cliente`
--

LOCK TABLES `cat_estatus_cliente` WRITE;
/*!40000 ALTER TABLE `cat_estatus_cliente` DISABLE KEYS */;
INSERT INTO `cat_estatus_cliente` VALUES (1,'Sin Especificar'),(2,'Activo'),(3,'Suspendido');
/*!40000 ALTER TABLE `cat_estatus_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_puesto`
--

DROP TABLE IF EXISTS `cat_puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_puesto` (
  `id_puesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_puesto` varchar(15) NOT NULL,
  PRIMARY KEY (`id_puesto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_puesto`
--

LOCK TABLES `cat_puesto` WRITE;
/*!40000 ALTER TABLE `cat_puesto` DISABLE KEYS */;
INSERT INTO `cat_puesto` VALUES (1,'Sin Especificar'),(2,'Administrador'),(3,'Veterinario'),(4,'Recepcionista'),(5,'Cajero');
/*!40000 ALTER TABLE `cat_puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_raza`
--

DROP TABLE IF EXISTS `cat_raza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_raza` (
  `id_raza` int(11) NOT NULL AUTO_INCREMENT,
  `id_especie` int(11) NOT NULL,
  `nombre_raza` varchar(50) NOT NULL,
  PRIMARY KEY (`id_raza`),
  KEY `fk_raza_especie` (`id_especie`),
  CONSTRAINT `fk_raza_especie` FOREIGN KEY (`id_especie`) REFERENCES `cat_especie` (`id_especie`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_raza`
--

LOCK TABLES `cat_raza` WRITE;
/*!40000 ALTER TABLE `cat_raza` DISABLE KEYS */;
INSERT INTO `cat_raza` VALUES (1,1,'Sin especificar'),(2,1,'Pastor Alemán'),(3,1,'Golden Retriever'),(4,1,'Labrador'),(5,1,'Chihuahua'),(6,1,'Pug'),(7,1,'Poodle'),(8,1,'Bulldog Inglés'),(9,1,'Beagle'),(10,1,'Boxer'),(11,1,'Rottweiler'),(12,1,'Dachshund'),(13,1,'Siberian Husky'),(14,1,'Doberman'),(15,1,'Schnauzer'),(16,1,'Shih Tzu'),(17,1,'Border Collie'),(18,1,'Gran Danés'),(19,1,'Pitbull'),(20,1,'Cocker Spaniel'),(21,1,'Mestizo'),(22,2,'Sin especificar'),(23,2,'Siamés'),(24,2,'Persa'),(25,2,'Maine Coon'),(26,2,'Bengala'),(27,2,'Ragdoll'),(28,2,'Esfinge'),(29,2,'Abisinio'),(30,2,'British Shorthair'),(31,2,'Azul Ruso'),(32,2,'Angora'),(33,2,'Himalayo'),(34,2,'Bombay'),(35,2,'Birmano'),(36,2,'Scottish Fold'),(37,2,'Burmés'),(38,2,'Mau Egipcio'),(39,2,'Savannah'),(40,2,'Bosque de Noruega'),(41,2,'Criollo'),(42,3,'Sin especificar'),(43,3,'Canario'),(44,3,'Perico Australiano'),(45,3,'Ninfa/Carolina'),(46,3,'Agapornis'),(47,3,'Loro Huasteco'),(48,3,'Cacatúa'),(49,3,'Guacamaya Roja'),(50,3,'Cacatúa Albina'),(51,3,'Finche'),(52,3,'Gorrión'),(53,3,'Pavo Real'),(54,3,'Gallo/Gallina'),(55,3,'Pato Pekín'),(56,3,'Codorniz'),(57,3,'Diamante de Gould'),(58,3,'Paloma Mensajera'),(59,3,'Calandria'),(60,3,'Ganso'),(61,3,'Pájaro del Amor'),(62,4,'Sin especificar'),(63,4,'Holandés Enano'),(64,4,'Belier/Lop'),(65,4,'Cabeza de León'),(66,4,'Angora Inglés'),(67,4,'Rex'),(68,4,'Gigante de Flandes'),(69,4,'Californiano'),(70,4,'Nueva Zelanda'),(71,4,'Hotot'),(72,4,'Chinchilla'),(73,4,'Mariposa'),(74,4,'Azul de Viena'),(75,4,'Himalayo'),(76,4,'Arlequín'),(77,4,'Tan'),(78,4,'Plateado de Champaña'),(79,4,'Liebre Belga'),(80,4,'Beveren'),(81,4,'Alaska'),(82,5,'Sin especificar'),(83,5,'Cuyo/Cobaya'),(84,5,'Hámster Sirio'),(85,5,'Hámster Ruso'),(86,5,'Chinchilla'),(87,5,'Rata Egipcia'),(88,5,'Ratón Doméstico'),(89,5,'Gerbo'),(90,5,'Degu'),(91,5,'Cuyo de Pelo Largo'),(92,5,'Ardilla Listada'),(93,5,'Lirón'),(94,5,'Hámster Roborovski'),(95,5,'Cuyo Rex'),(96,5,'Rata Dumbo'),(97,5,'Rata Calva'),(98,5,'Cuyo Abisinio'),(99,5,'Hámster de Campbell'),(100,5,'Ratón Espinoso'),(101,5,'Cuyo Coronet'),(102,6,'Sin especificar'),(103,6,'Iguana Verde'),(104,6,'Tortuga Japonesa'),(105,6,'Dragón Barbudo'),(106,6,'Gecko Leopardo'),(107,6,'Pitón Bola'),(108,6,'Tortuga de Desierto'),(109,6,'Camaleón de Velo'),(110,6,'Falsa Coral'),(111,6,'Boa Constrictor'),(112,6,'Tortuga Pavorreal'),(113,6,'Anolis Verde'),(114,6,'Eslizón de Lengua Azul'),(115,6,'Monitor de Sabana'),(116,6,'Gecko de Cresta'),(117,6,'Tortuga Rusa'),(118,6,'Serpiente del Maíz'),(119,6,'Tortuga de Orejas Amarillas'),(120,6,'Basilisco'),(121,6,'Uromastyx'),(122,7,'Sin especificar'),(123,7,'Hurón Sable'),(124,7,'Hurón Albino'),(125,7,'Hurón Plata'),(126,7,'Hurón Chocolate'),(127,7,'Hurón Panda'),(128,7,'Hurón Champagne'),(129,7,'Hurón Canela'),(130,7,'Hurón Angora'),(131,7,'Hurón de Pies Negros'),(132,7,'Hurón de Pelo Corto'),(133,7,'Hurón de Pelo Largo'),(134,7,'Hurón Marcado'),(135,7,'Hurón Blanco Ojos Oscuros'),(136,7,'Hurón Mitones'),(137,7,'Hurón Babero'),(138,7,'Hurón Sólido'),(139,7,'Hurón Estándar'),(140,7,'Visón'),(141,7,'Comadreja'),(142,8,'Sin especificar'),(143,8,'Betta Splendens'),(144,8,'Goldfish'),(145,8,'Guppy'),(146,8,'Molly'),(147,8,'Neon Tetra'),(148,8,'Pez Ángel'),(149,8,'Disco'),(150,8,'Cebra Danio'),(151,8,'Platy'),(152,8,'Gourami'),(153,8,'Corydora'),(154,8,'Pez Oscar'),(155,8,'Ramirezi'),(156,8,'Barbo'),(157,8,'Pez Payaso'),(158,8,'Cirujano Azul'),(159,8,'Tetra Borrachito'),(160,8,'Kuhli Loach'),(161,8,'Pez Gato'),(162,9,'Sin especificar'),(163,9,'Ajalote Mexicano'),(164,9,'Rana Pacman'),(165,9,'Sapo de Vientre de Fuego'),(166,9,'Rana de Ojos Rojos'),(167,9,'Dendrobates'),(168,9,'Salamandra Tigre'),(169,9,'Rana Toro'),(170,9,'Tritón de Vientre de Fuego'),(171,9,'Sapo Común'),(172,9,'Rana Arborícola Verde'),(173,9,'Gallipato'),(174,9,'Sapo de Espuelas'),(175,9,'Rana Mono'),(176,9,'Tritón Jaspeado'),(177,9,'Ajalote Albino'),(178,9,'Rana de Uñas Africana'),(179,9,'Sapo Gigante'),(180,9,'Rana Dardo Dorado'),(181,9,'Tritón Crestado'),(182,10,'Sin especificar'),(183,10,'Tarántula Rodillas Rojas'),(184,10,'Tarántula de Dedos Rosas'),(185,10,'Tarántula Cebra'),(186,10,'Tarántula de Pelo Rosa'),(187,10,'Tarántula Goliat'),(188,10,'Tarántula de Cobalto'),(189,10,'Escorpión Emperador'),(190,10,'Escorpión de Cola Gorda'),(191,10,'Araña Pavo Real'),(192,10,'Tarántula Terciopelo'),(193,10,'Tarántula Babuino'),(194,10,'Araña de Seda de Oro'),(195,10,'Tarántula de Desierto'),(196,10,'Escorpión Amarillo'),(197,10,'Tarántula Esqueleto'),(198,10,'Araña Trampilla'),(199,10,'Tarántula Sunburst'),(200,10,'Tarántula de Rodillas Blancas'),(201,10,'Araña Lobo');
/*!40000 ALTER TABLE `cat_raza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mts_cliente`
--

DROP TABLE IF EXISTS `mts_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mts_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_estatus` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_persona` (`id_persona`),
  KEY `fk_cliente_estatus` (`id_estatus`),
  CONSTRAINT `fk_cliente_estatus` FOREIGN KEY (`id_estatus`) REFERENCES `cat_estatus_cliente` (`id_estatus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cliente_persona` FOREIGN KEY (`id_persona`) REFERENCES `mts_persona` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mts_cliente`
--

LOCK TABLES `mts_cliente` WRITE;
/*!40000 ALTER TABLE `mts_cliente` DISABLE KEYS */;
INSERT INTO `mts_cliente` VALUES (1,1,2),(2,2,3),(3,3,2),(4,6,2),(5,8,2);
/*!40000 ALTER TABLE `mts_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mts_documentos`
--

DROP TABLE IF EXISTS `mts_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mts_documentos` (
  `id_documento` int(11) NOT NULL AUTO_INCREMENT,
  `id_mascota` int(11) NOT NULL,
  `nombre_documento` varchar(150) NOT NULL,
  PRIMARY KEY (`id_documento`),
  KEY `fk_documentos_mascota` (`id_mascota`),
  CONSTRAINT `fk_documentos_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mts_mascota` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mts_documentos`
--

LOCK TABLES `mts_documentos` WRITE;
/*!40000 ALTER TABLE `mts_documentos` DISABLE KEYS */;
INSERT INTO `mts_documentos` VALUES (1,1,'radiografia.pdf');
/*!40000 ALTER TABLE `mts_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mts_empleado`
--

DROP TABLE IF EXISTS `mts_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mts_empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_puesto` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `foto_perfil` varchar(100) DEFAULT 'default_emp.png',
  `sueldo_base` decimal(10,2) NOT NULL,
  `fecha_contratacion` date NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `fk_empleado_persona` (`id_persona`),
  KEY `fk_empleado_puesto` (`id_puesto`),
  CONSTRAINT `fk_empleado_persona` FOREIGN KEY (`id_persona`) REFERENCES `mts_persona` (`id_persona`),
  CONSTRAINT `fk_empleado_puesto` FOREIGN KEY (`id_puesto`) REFERENCES `cat_puesto` (`id_puesto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mts_empleado`
--

LOCK TABLES `mts_empleado` WRITE;
/*!40000 ALTER TABLE `mts_empleado` DISABLE KEYS */;
INSERT INTO `mts_empleado` VALUES (1,1,3,'jabad','123456','',12000.00,'2026-05-26'),(2,2,2,'ncruz','Agua','default_emp.png',15000.00,'2026-05-26'),(3,4,3,'msanchez','patitas123','default_emp.png',12000.00,'2026-05-26'),(4,5,4,'avidal','patitas123','default_emp.png',15000.00,'2026-05-26'),(5,7,3,'aguzman','2110','default_emp.png',12000.00,'2026-05-26');
/*!40000 ALTER TABLE `mts_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mts_mascota`
--

DROP TABLE IF EXISTS `mts_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mts_mascota` (
  `id_mascota` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_raza` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `fk_mascota_cliente` (`id_cliente`),
  KEY `fk_mascota_raza` (`id_raza`),
  CONSTRAINT `fk_mascota_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `mts_cliente` (`id_cliente`),
  CONSTRAINT `fk_mascota_raza` FOREIGN KEY (`id_raza`) REFERENCES `cat_raza` (`id_raza`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mts_mascota`
--

LOCK TABLES `mts_mascota` WRITE;
/*!40000 ALTER TABLE `mts_mascota` DISABLE KEYS */;
INSERT INTO `mts_mascota` VALUES (1,1,2,'Firulais','2023-05-15','Macho'),(2,3,13,'Boby','2024-01-10','Hembra'),(3,3,23,'Luna','2025-05-20','Macho'),(4,3,187,'Rex','2023-11-05','Hembra'),(5,4,46,'Kira','2025-03-15','Macho'),(6,4,65,'Max','2024-08-22','Hembra'),(7,4,106,'Nala','2023-12-30','Macho'),(8,5,123,'Rocky','2024-07-14','Hembra'),(9,5,163,'Mia','2025-09-09','Macho'),(10,5,6,'Zeus','2023-10-01','Hembra');
/*!40000 ALTER TABLE `mts_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mts_persona`
--

DROP TABLE IF EXISTS `mts_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mts_persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `fecha_registro_sistema` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `chk_telefono_numerico` CHECK (`telefono` regexp '^[0-9]+$')
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mts_persona`
--

LOCK TABLES `mts_persona` WRITE;
/*!40000 ALTER TABLE `mts_persona` DISABLE KEYS */;
INSERT INTO `mts_persona` VALUES (1,'Miguel','Abad','Roa','2261065705','0905chucho@gmail.com','2026-05-05 23:37:40'),(2,'Natalia','Cruz','Chiu','2281788834','natacrch12@gmail.com','2026-05-22 15:10:14'),(3,'Rafael','Viveros','Vazquez','2791076927','rafaelviveros583@gmail.com','2026-05-22 15:12:06'),(4,'Mayela Isabel','Sanchez','Juárez','2284995747','mayelasanchezzz@outlook.com','2026-05-26 20:29:31'),(5,'Anuar Gabriel','Vidal','Sanchez','2261192027','anuargestudia@gmail.com','2026-05-26 20:29:31'),(6,'Axel Gerardo','Ramirez','Bautista','2288609052','ramirezaxelgerardo@gmail.com','2026-05-26 20:29:31'),(7,'Angelica Maria','Guzman','Villa','2284087102','anguvi2110@gmail.com','2026-05-26 20:32:49'),(8,'Manuel Eduardo','Morales','Morales','2284454452','mmoralesmorales540@gmail.com','2026-05-26 20:46:04');
/*!40000 ALTER TABLE `mts_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_cita`
--

DROP TABLE IF EXISTS `trn_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trn_cita` (
  `id_cita` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_mascota` int(11) DEFAULT NULL,
  `id_estatus_cita` int(11) NOT NULL,
  `fecha_programada` datetime NOT NULL,
  `motivo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `fk_cita_cliente` (`id_cliente`),
  KEY `fk_cita_mascota` (`id_mascota`),
  KEY `fk_cita_estatus` (`id_estatus_cita`),
  CONSTRAINT `fk_cita_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `mts_cliente` (`id_cliente`),
  CONSTRAINT `fk_cita_estatus` FOREIGN KEY (`id_estatus_cita`) REFERENCES `cat_estatus_cita` (`id_estatus_cita`),
  CONSTRAINT `fk_cita_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mts_mascota` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_cita`
--

LOCK TABLES `trn_cita` WRITE;
/*!40000 ALTER TABLE `trn_cita` DISABLE KEYS */;
INSERT INTO `trn_cita` VALUES (1,3,3,1,'2026-05-28 10:00:00','Vacunación anual para felino (Luna)'),(2,4,7,3,'2026-05-25 16:30:00','Revisión por falta de apetito (Nala)'),(3,5,NULL,1,'2026-05-30 12:00:00','Asesoría sobre dieta para hurones (Viene sin mascota)');
/*!40000 ALTER TABLE `trn_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_consulta`
--

DROP TABLE IF EXISTS `trn_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trn_consulta` (
  `id_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `id_mascota` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `fecha_consulta` datetime NOT NULL,
  `peso_actual` float NOT NULL,
  `diagnostico` text NOT NULL,
  `tratamiento` text NOT NULL,
  PRIMARY KEY (`id_consulta`),
  KEY `fk_consulta_mascota` (`id_mascota`),
  KEY `fk_consulta_empleado` (`id_empleado`),
  CONSTRAINT `fk_consulta_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `mts_empleado` (`id_empleado`),
  CONSTRAINT `fk_consulta_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mts_mascota` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_consulta`
--

LOCK TABLES `trn_consulta` WRITE;
/*!40000 ALTER TABLE `trn_consulta` DISABLE KEYS */;
INSERT INTO `trn_consulta` VALUES (1,7,1,'2026-05-25 16:30:00',0.06,'Paciente presenta letargo y anorexia temporal secundaria a un proceso de ecdisis (muda de piel) retenida por baja humedad en su terrario. Signos de deshidratación leve.','1. Baños de agua tibia (30°C) por 15 minutos diarios durante 3 días para facilitar la muda.\n2. Ajustar la humedad del terrario al 60%.\n3. Administrar suero oral pediátrico (2 gotas al día).\n4. Cita de revaloración si no recupera el apetito en 48 horas.');
/*!40000 ALTER TABLE `trn_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_detalle_bitacora`
--

DROP TABLE IF EXISTS `vw_detalle_bitacora`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_bitacora`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_bitacora` AS SELECT
 1 AS `id_bitacora`,
  1 AS `usuario`,
  1 AS `accion`,
  1 AS `tabla_afectada`,
  1 AS `id_registro_afectado`,
  1 AS `valor_anterior`,
  1 AS `valor_nuevo`,
  1 AS `fecha_movimiento` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_cita`
--

DROP TABLE IF EXISTS `vw_detalle_cita`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_cita`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_cita` AS SELECT
 1 AS `id_cita`,
  1 AS `nombre_dueno`,
  1 AS `nombre_mascota`,
  1 AS `estatus_cita`,
  1 AS `fecha_programada`,
  1 AS `motivo` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_cliente`
--

DROP TABLE IF EXISTS `vw_detalle_cliente`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_cliente` AS SELECT
 1 AS `id_cliente`,
  1 AS `id_persona`,
  1 AS `nombre`,
  1 AS `apellido_paterno`,
  1 AS `apellido_materno`,
  1 AS `telefono`,
  1 AS `email`,
  1 AS `fecha_registro_sistema`,
  1 AS `nom_estatus_cliente` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_consulta`
--

DROP TABLE IF EXISTS `vw_detalle_consulta`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_consulta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_consulta` AS SELECT
 1 AS `id_consulta`,
  1 AS `nombre_mascota`,
  1 AS `nombre_veterinario`,
  1 AS `fecha_consulta`,
  1 AS `peso_actual`,
  1 AS `diagnostico`,
  1 AS `tratamiento` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_empleado`
--

DROP TABLE IF EXISTS `vw_detalle_empleado`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_empleado`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_empleado` AS SELECT
 1 AS `id_empleado`,
  1 AS `id_persona`,
  1 AS `nombre`,
  1 AS `apellido_paterno`,
  1 AS `apellido_materno`,
  1 AS `telefono`,
  1 AS `email`,
  1 AS `usuario`,
  1 AS `foto_perfil`,
  1 AS `sueldo_base`,
  1 AS `fecha_contratacion`,
  1 AS `fecha_registro_sistema`,
  1 AS `puesto` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_mascota`
--

DROP TABLE IF EXISTS `vw_detalle_mascota`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_mascota`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_mascota` AS SELECT
 1 AS `id_mascota`,
  1 AS `id_cliente`,
  1 AS `nombre_raza`,
  1 AS `nombre`,
  1 AS `fecha_nacimiento`,
  1 AS `sexo` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detalle_raza`
--

DROP TABLE IF EXISTS `vw_detalle_raza`;
/*!50001 DROP VIEW IF EXISTS `vw_detalle_raza`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_detalle_raza` AS SELECT
 1 AS `id_raza`,
  1 AS `nombre_raza`,
  1 AS `especie` */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_detalle_bitacora`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_bitacora`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_bitacora` AS select `B`.`id_bitacora` AS `id_bitacora`,`E`.`usuario` AS `usuario`,`A`.`nombre_accion` AS `accion`,`B`.`tabla_afectada` AS `tabla_afectada`,`B`.`id_registro_afectado` AS `id_registro_afectado`,`B`.`valor_anterior` AS `valor_anterior`,`B`.`valor_nuevo` AS `valor_nuevo`,`B`.`fecha_movimiento` AS `fecha_movimiento` from ((`bit_movimientos` `B` join `cat_accion_bitacora` `A` on(`B`.`id_accion` = `A`.`id_accion`)) join `mts_empleado` `E` on(`B`.`id_empleado` = `E`.`id_empleado`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_cita`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_cita`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_cita` AS select `C`.`id_cita` AS `id_cita`,concat(`P`.`nombre`,' ',`P`.`apellido_paterno`,' ',`P`.`apellido_materno`) AS `nombre_dueno`,ifnull(`M`.`nombre`,'Sin mascota asignada') AS `nombre_mascota`,`EC`.`nom_estatus_cita` AS `estatus_cita`,`C`.`fecha_programada` AS `fecha_programada`,`C`.`motivo` AS `motivo` from ((((`trn_cita` `C` join `mts_cliente` `CL` on(`C`.`id_cliente` = `CL`.`id_cliente`)) join `mts_persona` `P` on(`CL`.`id_persona` = `P`.`id_persona`)) join `cat_estatus_cita` `EC` on(`C`.`id_estatus_cita` = `EC`.`id_estatus_cita`)) left join `mts_mascota` `M` on(`C`.`id_mascota` = `M`.`id_mascota`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_cliente`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_cliente` AS select `c`.`id_cliente` AS `id_cliente`,`p`.`id_persona` AS `id_persona`,`p`.`nombre` AS `nombre`,`p`.`apellido_paterno` AS `apellido_paterno`,`p`.`apellido_materno` AS `apellido_materno`,`p`.`telefono` AS `telefono`,`p`.`email` AS `email`,`p`.`fecha_registro_sistema` AS `fecha_registro_sistema`,`e`.`nom_estatus_cliente` AS `nom_estatus_cliente` from ((`mts_cliente` `c` join `mts_persona` `p` on(`c`.`id_persona` = `p`.`id_persona`)) join `cat_estatus_cliente` `e` on(`c`.`id_estatus` = `e`.`id_estatus`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_consulta`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_consulta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_consulta` AS select `C`.`id_consulta` AS `id_consulta`,`M`.`nombre` AS `nombre_mascota`,concat(`P`.`nombre`,' ',`P`.`apellido_paterno`,' ',`P`.`apellido_materno`) AS `nombre_veterinario`,`C`.`fecha_consulta` AS `fecha_consulta`,`C`.`peso_actual` AS `peso_actual`,`C`.`diagnostico` AS `diagnostico`,`C`.`tratamiento` AS `tratamiento` from (((`trn_consulta` `C` join `mts_mascota` `M` on(`C`.`id_mascota` = `M`.`id_mascota`)) join `mts_empleado` `E` on(`C`.`id_empleado` = `E`.`id_empleado`)) join `mts_persona` `P` on(`E`.`id_persona` = `P`.`id_persona`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_empleado`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_empleado`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_empleado` AS select `E`.`id_empleado` AS `id_empleado`,`P`.`id_persona` AS `id_persona`,`P`.`nombre` AS `nombre`,`P`.`apellido_paterno` AS `apellido_paterno`,`P`.`apellido_materno` AS `apellido_materno`,`P`.`telefono` AS `telefono`,`P`.`email` AS `email`,`E`.`usuario` AS `usuario`,`E`.`foto_perfil` AS `foto_perfil`,`E`.`sueldo_base` AS `sueldo_base`,`E`.`fecha_contratacion` AS `fecha_contratacion`,`P`.`fecha_registro_sistema` AS `fecha_registro_sistema`,`PU`.`nombre_puesto` AS `puesto` from ((`mts_empleado` `E` join `mts_persona` `P` on(`E`.`id_persona` = `P`.`id_persona`)) join `cat_puesto` `PU` on(`E`.`id_puesto` = `PU`.`id_puesto`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_mascota`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_mascota`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_mascota` AS select `m`.`id_mascota` AS `id_mascota`,`c`.`id_cliente` AS `id_cliente`,`r`.`nombre_raza` AS `nombre_raza`,`m`.`nombre` AS `nombre`,`m`.`fecha_nacimiento` AS `fecha_nacimiento`,`m`.`sexo` AS `sexo` from ((`mts_mascota` `m` join `cat_raza` `r` on(`m`.`id_raza` = `r`.`id_raza`)) join `mts_cliente` `c` on(`m`.`id_cliente` = `c`.`id_cliente`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detalle_raza`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalle_raza`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalle_raza` AS select `r`.`id_raza` AS `id_raza`,`r`.`nombre_raza` AS `nombre_raza`,`e`.`nombre_especie` AS `especie` from (`cat_raza` `r` join `cat_especie` `e` on(`e`.`id_especie` = `r`.`id_especie`)) */;
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

-- Dump completed on 2026-06-01 22:17:17
