-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalho_poo
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `ata_reunioes`
--

DROP TABLE IF EXISTS `ata_reunioes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ata_reunioes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` int DEFAULT NULL,
  `data_reuniao` date DEFAULT NULL,
  `conteudo_ata` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `servidor_secretario` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ataReunioes_comissoes_idx` (`comissao`),
  CONSTRAINT `fk_ataReunioes_comissoes` FOREIGN KEY (`comissao`) REFERENCES `comissoes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ata_reunioes`
--

LOCK TABLES `ata_reunioes` WRITE;
/*!40000 ALTER TABLE `ata_reunioes` DISABLE KEYS */;
INSERT INTO `ata_reunioes` VALUES (8,3,'2022-06-27','conteudo alterado',18,'2022-06-26 21:56:18','2022-06-27 19:02:27'),(9,3,'2022-06-27','conteudo 2',18,'2022-06-27 19:01:12','2022-06-27 19:01:12');
/*!40000 ALTER TABLE `ata_reunioes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ata_reunioes_presentes`
--

DROP TABLE IF EXISTS `ata_reunioes_presentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ata_reunioes_presentes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` int DEFAULT NULL,
  `ata_reuniao` int DEFAULT NULL,
  `servidor` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_atareuniaopresentes_comissao` (`comissao`),
  KEY `FK_atareuniaopresentes_ata_reuniao` (`ata_reuniao`),
  KEY `FK_atareuniaopresentes_servidor` (`servidor`),
  CONSTRAINT `FK_atareuniaopresentes_ata_reuniao` FOREIGN KEY (`ata_reuniao`) REFERENCES `ata_reunioes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_atareuniaopresentes_comissao` FOREIGN KEY (`comissao`) REFERENCES `comissoes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_atareuniaopresentes_servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ata_reunioes_presentes`
--

LOCK TABLES `ata_reunioes_presentes` WRITE;
/*!40000 ALTER TABLE `ata_reunioes_presentes` DISABLE KEYS */;
INSERT INTO `ata_reunioes_presentes` VALUES (2,3,9,21,'2022-06-30 03:37:21','2022-06-30 03:37:44');
/*!40000 ALTER TABLE `ata_reunioes_presentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades`
--

DROP TABLE IF EXISTS `atividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `servidor` int DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_atividades_servidor_idx` (`servidor`),
  CONSTRAINT `fk_atividades_servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades`
--

LOCK TABLES `atividades` WRITE;
/*!40000 ALTER TABLE `atividades` DISABLE KEYS */;
INSERT INTO `atividades` VALUES (2,'oxi',2,18,'2022-06-26','2022-06-26','2022-06-26 19:07:01','2022-06-26 20:05:46'),(3,'pistola carai',2,18,'2022-06-26','2022-06-26','2022-06-26 19:44:37','2022-06-26 19:44:37');
/*!40000 ALTER TABLE `atividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campus`
--

DROP TABLE IF EXISTS `campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `abreviacao` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `duracao_aulas` int DEFAULT NULL,
  `data_criacao_campus` date DEFAULT NULL,
  `cidade` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `bairro` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `endereco` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `cep` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campus`
--

LOCK TABLES `campus` WRITE;
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
INSERT INTO `campus` VALUES (2,'escolinha mod','mod',55,'2022-06-19','ura','ura','ura','65561','2022-06-25 21:55:07','2022-06-30 03:59:15');
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comissoes`
--

DROP TABLE IF EXISTS `comissoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comissoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comissoes`
--

LOCK TABLES `comissoes` WRITE;
/*!40000 ALTER TABLE `comissoes` DISABLE KEYS */;
INSERT INTO `comissoes` VALUES (3,'Comissao Modificada',2.22,'2022-06-26','2022-06-26',1,'2022-06-26 20:55:12','2022-06-26 20:55:12'),(6,'comissao',22,'2022-06-30','2022-07-20',1,'2022-06-30 04:39:25','2022-06-30 04:39:25');
/*!40000 ALTER TABLE `comissoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `campus` int DEFAULT NULL,
  `ano_inicio` date DEFAULT NULL,
  `ano_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cursos_campus_idx` (`campus`),
  CONSTRAINT `fk_cursos_campus` FOREIGN KEY (`campus`) REFERENCES `campus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Data cience',1,2,'2022-06-26','2022-06-26','2022-06-26 03:21:04','2022-06-25 03:29:28'),(2,'Ciencia de dados',1,NULL,'2022-06-26','2022-06-26','2022-06-26 03:24:26','2022-06-26 03:24:26'),(5,'curso',0,2,'2022-02-20','2022-05-22','2022-06-29 19:09:57','2022-06-29 19:09:57');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplinas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `carga_horaria` double DEFAULT NULL,
  `periodicidade` int DEFAULT NULL,
  `curso` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_disciplina_curso` (`curso`),
  CONSTRAINT `Fk_disciplina_curso` FOREIGN KEY (`curso`) REFERENCES `cursos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinas`
--

LOCK TABLES `disciplinas` WRITE;
/*!40000 ALTER TABLE `disciplinas` DISABLE KEYS */;
INSERT INTO `disciplinas` VALUES (2,'Analise',2.5,1,1,'2022-06-26 04:07:19','2022-06-26 04:07:19'),(3,'Analise de dados',2.5,1,1,'2022-06-26 04:07:28','2022-06-26 04:07:28');
/*!40000 ALTER TABLE `disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta_disciplina_curso`
--

DROP TABLE IF EXISTS `oferta_disciplina_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta_disciplina_curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `curso` int DEFAULT NULL,
  `disciplina` int DEFAULT NULL,
  `professor` int DEFAULT NULL,
  `ano` int DEFAULT NULL,
  `semestre` int DEFAULT NULL,
  `aulas_semanais` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_oferta_curso` (`curso`),
  KEY `Fk_oferta_disciplina` (`disciplina`),
  KEY `FK_oferta_professor` (`professor`),
  CONSTRAINT `Fk_oferta_curso` FOREIGN KEY (`curso`) REFERENCES `cursos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Fk_oferta_disciplina` FOREIGN KEY (`disciplina`) REFERENCES `disciplinas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_oferta_professor` FOREIGN KEY (`professor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta_disciplina_curso`
--

LOCK TABLES `oferta_disciplina_curso` WRITE;
/*!40000 ALTER TABLE `oferta_disciplina_curso` DISABLE KEYS */;
INSERT INTO `oferta_disciplina_curso` VALUES (2,2,2,19,2022,2,0,'2022-06-30 00:39:27','2022-06-30 04:26:39'),(5,1,3,21,2026,2,22,'2022-06-30 04:31:39','2022-06-30 04:31:39');
/*!40000 ALTER TABLE `oferta_disciplina_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orientacoes`
--

DROP TABLE IF EXISTS `orientacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orientacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo_orientacao` int DEFAULT NULL,
  `nome_aluno` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `servidor` int DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orientcacoes-servidor_idx` (`servidor`),
  CONSTRAINT `fk_orientcacoes-servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orientacoes`
--

LOCK TABLES `orientacoes` WRITE;
/*!40000 ALTER TABLE `orientacoes` DISABLE KEYS */;
INSERT INTO `orientacoes` VALUES (5,1,'Lindovaldo',19,20,'2022-06-26','2022-06-26','2022-06-26 18:38:35','2022-06-26 18:39:05'),(7,7,'lucas',19,25,'2022-02-20','2023-05-20','2022-06-30 01:03:42','2022-06-30 01:04:10');
/*!40000 ALTER TABLE `orientacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servidor_comissao`
--

DROP TABLE IF EXISTS `servidor_comissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servidor_comissao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` int DEFAULT NULL,
  `servidor` int DEFAULT NULL,
  `papel` int DEFAULT NULL,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_servidorcomissao_comissao` (`comissao`),
  KEY `FK_servidorcomissao_servidor` (`servidor`),
  CONSTRAINT `FK_servidorcomissao_comissao` FOREIGN KEY (`comissao`) REFERENCES `comissoes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_servidorcomissao_servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servidor_comissao`
--

LOCK TABLES `servidor_comissao` WRITE;
/*!40000 ALTER TABLE `servidor_comissao` DISABLE KEYS */;
INSERT INTO `servidor_comissao` VALUES (1,3,18,2,'2022-02-20','2023-05-20','2022-06-30 02:55:38','2022-06-30 02:55:38'),(2,3,21,3,'2022-02-20','2023-05-20','2022-06-30 02:57:03','2022-06-30 02:57:03');
/*!40000 ALTER TABLE `servidor_comissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servidores`
--

DROP TABLE IF EXISTS `servidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servidores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `campus` int DEFAULT NULL,
  `cargo` int DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `senha` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `tipo_usuario` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_servidor_campus` (`campus`),
  CONSTRAINT `Fk_servidor_campus` FOREIGN KEY (`campus`) REFERENCES `campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servidores`
--

LOCK TABLES `servidores` WRITE;
/*!40000 ALTER TABLE `servidores` DISABLE KEYS */;
INSERT INTO `servidores` VALUES (18,'Eduardo Silvestre','eduardo.silvestre@iftm.br',2,1,'eduardoIftm','jao',1,'2022-06-24 01:56:30','2022-06-24 02:40:37'),(19,'Rogerio Costa','rogeriocosta@iftm.br',2,1,'rogerioIftm','Rogerinho',1,'2022-06-24 01:59:28','2022-06-24 01:59:28'),(21,'zezeze','email',2,1,'login','senha',2,'2022-06-24 03:15:59','2022-06-26 03:06:07'),(28,'Administrador','Administrador@administrador.br',2,1,'admin','admin',1,'2022-06-27 20:29:10','2022-06-27 20:29:10'),(29,'Usuario Comum','comum@comum.br',2,1,'user','user',2,'2022-06-27 20:30:41','2022-06-27 20:30:41'),(32,'apaga ze','apaga ze',2,1,'login ','senha',2,'2022-06-30 05:13:07','2022-06-30 05:13:36');
/*!40000 ALTER TABLE `servidores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-30  2:15:57
