-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           5.7.19 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour devexpert
CREATE DATABASE IF NOT EXISTS `devexpert` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `devexpert`;

-- Export de la structure de la table devexpert. category
CREATE TABLE IF NOT EXISTS `category` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.category : ~0 rows (environ)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Export de la structure de la table devexpert. client
CREATE TABLE IF NOT EXISTS `client` (
  `id_cli` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_cli`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id_cli`) REFERENCES `mission` (`id_cli`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.client : ~0 rows (environ)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Export de la structure de la table devexpert. collaborateur
CREATE TABLE IF NOT EXISTS `collaborateur` (
  `id_col` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `salaire` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_col`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.collaborateur : ~4 rows (environ)
/*!40000 ALTER TABLE `collaborateur` DISABLE KEYS */;
INSERT INTO `collaborateur` (`id_col`, `name`, `firstname`, `login`, `password`, `department`, `salaire`) VALUES
	(1, 'BENNE', 'Loup', 'Akilatex', 'tLRSvp0ZtbT2A6mvQkHtZ/N3HA93QQ85OSK0zGebxE/dModEaqpX/w==', 'Développement web', NULL),
	(2, 'VENZO', 'Terence', 'Tropfor', 'cJpPc4b86kq0dawdIsE7T2yNwkbzsmW96Qyp9AXQEahp7g/wg+sTtw==', 'Sécurité réseau', NULL),
	(3, 'MOUROT', 'Damien', 'Damso972', '5f0QHFMB3Q6S1kJZZwFJBQRzSFRurAWYtNBrX4uUQ5YyA0LXB1nVGQ==', 'Chomdu department', NULL),
	(4, 'venzo', 'terence', 'terence', '+YvHliI99jTlR9FLkoX5zeZYbmz0fuyG+1ziRg9Bj5leHHeOwJgiZw==', 'test', NULL);
/*!40000 ALTER TABLE `collaborateur` ENABLE KEYS */;

-- Export de la structure de la table devexpert. langage
CREATE TABLE IF NOT EXISTS `langage` (
  `id_lang` int(11) NOT NULL AUTO_INCREMENT,
  `langage` varchar(255) NOT NULL,
  PRIMARY KEY (`id_lang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.langage : ~0 rows (environ)
/*!40000 ALTER TABLE `langage` DISABLE KEYS */;
/*!40000 ALTER TABLE `langage` ENABLE KEYS */;

-- Export de la structure de la table devexpert. mission
CREATE TABLE IF NOT EXISTS `mission` (
  `id_mis` int(11) NOT NULL AUTO_INCREMENT,
  `id_cli` int(11) NOT NULL,
  `date_demand` date NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_mis`),
  UNIQUE KEY `id_cli` (`id_cli`),
  CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`id_mis`) REFERENCES `work` (`id_mis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.mission : ~0 rows (environ)
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;
/*!40000 ALTER TABLE `mission` ENABLE KEYS */;

-- Export de la structure de la table devexpert. poste
CREATE TABLE IF NOT EXISTS `poste` (
  `id_post` int(11) NOT NULL AUTO_INCREMENT,
  `id_col` int(11) NOT NULL,
  `id_cat` int(11) NOT NULL,
  `xp_poste` int(11) NOT NULL,
  PRIMARY KEY (`id_post`),
  UNIQUE KEY `id_col` (`id_col`),
  UNIQUE KEY `id_cat` (`id_cat`),
  CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `poste_ibfk_2` FOREIGN KEY (`id_cat`) REFERENCES `category` (`id_cat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.poste : ~0 rows (environ)
/*!40000 ALTER TABLE `poste` DISABLE KEYS */;
/*!40000 ALTER TABLE `poste` ENABLE KEYS */;

-- Export de la structure de la table devexpert. speak
CREATE TABLE IF NOT EXISTS `speak` (
  `id_speak` int(11) NOT NULL AUTO_INCREMENT,
  `id_col` int(11) NOT NULL,
  `id_lang` int(11) NOT NULL,
  `xp_lang` int(11) NOT NULL,
  PRIMARY KEY (`id_speak`),
  UNIQUE KEY `id_lang` (`id_lang`),
  UNIQUE KEY `id_col` (`id_col`),
  CONSTRAINT `speak_ibfk_1` FOREIGN KEY (`id_lang`) REFERENCES `langage` (`id_lang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `speak_ibfk_2` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.speak : ~0 rows (environ)
/*!40000 ALTER TABLE `speak` DISABLE KEYS */;
/*!40000 ALTER TABLE `speak` ENABLE KEYS */;

-- Export de la structure de la table devexpert. work
CREATE TABLE IF NOT EXISTS `work` (
  `id_work` int(11) NOT NULL AUTO_INCREMENT,
  `id_mis` int(11) NOT NULL,
  `id_col` int(11) NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `nb_hours` date NOT NULL,
  PRIMARY KEY (`id_work`),
  UNIQUE KEY `id_mis` (`id_mis`),
  UNIQUE KEY `id_col` (`id_col`),
  CONSTRAINT `work_ibfk_1` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table devexpert.work : ~0 rows (environ)
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
/*!40000 ALTER TABLE `work` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
