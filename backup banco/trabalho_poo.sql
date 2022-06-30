-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 23-Jun-2022 às 14:17
-- Versão do servidor: 8.0.21
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `trabalho_poo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ata_reunioes`
--

DROP TABLE IF EXISTS `ata_reunioes`;
CREATE TABLE IF NOT EXISTS `ata_reunioes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` int DEFAULT NULL,
  `data_reuniao` date DEFAULT NULL,
  `conteudo_ata` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `servidor_secretario` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ata_reunioes_presentes`
--

DROP TABLE IF EXISTS `ata_reunioes_presentes`;
CREATE TABLE IF NOT EXISTS `ata_reunioes_presentes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` int DEFAULT NULL,
  `ata_reuniao` int DEFAULT NULL,
  `servidor` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_atareuniaopresentes_comissao` (`comissao`),
  KEY `FK_atareuniaopresentes_ata_reuniao` (`ata_reuniao`),
  KEY `FK_atareuniaopresentes_servidor` (`servidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividades`
--

DROP TABLE IF EXISTS `atividades`;
CREATE TABLE IF NOT EXISTS `atividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campus`
--

DROP TABLE IF EXISTS `campus`;
CREATE TABLE IF NOT EXISTS `campus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `abreviacao` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `duracao_aulas` int DEFAULT NULL,
  `data_criacao_campus` date DEFAULT NULL,
  `cidade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bairro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `endereco` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cep` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comissoes`
--

DROP TABLE IF EXISTS `comissoes`;
CREATE TABLE IF NOT EXISTS `comissoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comissao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `ano_inicio` date DEFAULT NULL,
  `ano_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
CREATE TABLE IF NOT EXISTS `disciplinas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `carga_horaria` double DEFAULT NULL,
  `periodicidade` int DEFAULT NULL,
  `curso` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_disciplina_curso` (`curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `oferta_disciplina_curso`
--

DROP TABLE IF EXISTS `oferta_disciplina_curso`;
CREATE TABLE IF NOT EXISTS `oferta_disciplina_curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `curso` int DEFAULT NULL,
  `disciplina` int DEFAULT NULL,
  `professor` int DEFAULT NULL,
  `ano` date DEFAULT NULL,
  `semestre` int DEFAULT NULL,
  `aulas_semanais` int DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_oferta_curso` (`curso`),
  KEY `Fk_oferta_disciplina` (`disciplina`),
  KEY `FK_oferta_professor` (`professor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `orientacoes`
--

DROP TABLE IF EXISTS `orientacoes`;
CREATE TABLE IF NOT EXISTS `orientacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo_orientacao` int DEFAULT NULL,
  `nome_aluno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `horas_semanais` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servidores`
--

DROP TABLE IF EXISTS `servidores`;
CREATE TABLE IF NOT EXISTS `servidores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `campus` int DEFAULT NULL,
  `cargo` int DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `senha` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `modificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_servidor_campus` (`campus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servidor_comissao`
--

DROP TABLE IF EXISTS `servidor_comissao`;
CREATE TABLE IF NOT EXISTS `servidor_comissao` (
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
  KEY `FK_servidorcomissao_servidor` (`servidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `ata_reunioes_presentes`
--
ALTER TABLE `ata_reunioes_presentes`
  ADD CONSTRAINT `FK_atareuniaopresentes_ata_reuniao` FOREIGN KEY (`ata_reuniao`) REFERENCES `ata_reunioes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_atareuniaopresentes_comissao` FOREIGN KEY (`comissao`) REFERENCES `comissoes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_atareuniaopresentes_servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD CONSTRAINT `Fk_disciplina_curso` FOREIGN KEY (`curso`) REFERENCES `cursos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `oferta_disciplina_curso`
--
ALTER TABLE `oferta_disciplina_curso`
  ADD CONSTRAINT `Fk_oferta_curso` FOREIGN KEY (`curso`) REFERENCES `cursos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `Fk_oferta_disciplina` FOREIGN KEY (`disciplina`) REFERENCES `disciplinas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_oferta_professor` FOREIGN KEY (`professor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `servidores`
--
ALTER TABLE `servidores`
  ADD CONSTRAINT `Fk_servidor_campus` FOREIGN KEY (`campus`) REFERENCES `campus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `servidor_comissao`
--
ALTER TABLE `servidor_comissao`
  ADD CONSTRAINT `FK_servidorcomissao_comissao` FOREIGN KEY (`comissao`) REFERENCES `comissoes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_servidorcomissao_servidor` FOREIGN KEY (`servidor`) REFERENCES `servidores` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
