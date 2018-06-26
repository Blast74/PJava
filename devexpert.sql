-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 26 Juin 2018 à 20:58
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `devexpert`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id_cat` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_cli` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `id_col` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `collaborateur`
--

INSERT INTO `collaborateur` (`id_col`, `name`, `firstname`, `login`, `password`, `department`) VALUES
(1, 'BENNE', 'Loup', 'Akilatex', 'tLRSvp0ZtbT2A6mvQkHtZ/N3HA93QQ85OSK0zGebxE/dModEaqpX/w==', 'Développement web'),
(2, 'VENZO', 'Terence', 'Tropfor', 'cJpPc4b86kq0dawdIsE7T2yNwkbzsmW96Qyp9AXQEahp7g/wg+sTtw==', 'Sécurité réseau'),
(3, 'MOUROT', 'Damien', 'Damso972', '5f0QHFMB3Q6S1kJZZwFJBQRzSFRurAWYtNBrX4uUQ5YyA0LXB1nVGQ==', 'Chomdu department');

-- --------------------------------------------------------

--
-- Structure de la table `langage`
--

CREATE TABLE `langage` (
  `id_lang` int(11) NOT NULL,
  `langage` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `id_mis` int(11) NOT NULL,
  `id_cli` int(11) NOT NULL,
  `date_demand` date NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE `poste` (
  `id_post` int(11) NOT NULL,
  `id_col` int(11) NOT NULL,
  `id_cat` int(11) NOT NULL,
  `xp_poste` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `speak`
--

CREATE TABLE `speak` (
  `id_speak` int(11) NOT NULL,
  `id_col` int(11) NOT NULL,
  `id_lang` int(11) NOT NULL,
  `xp_lang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `work`
--

CREATE TABLE `work` (
  `id_work` int(11) NOT NULL,
  `id_mis` int(11) NOT NULL,
  `id_col` int(11) NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `nb_hours` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_cat`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_cli`);

--
-- Index pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`id_col`);

--
-- Index pour la table `langage`
--
ALTER TABLE `langage`
  ADD PRIMARY KEY (`id_lang`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`id_mis`),
  ADD UNIQUE KEY `id_cli` (`id_cli`);

--
-- Index pour la table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`id_post`),
  ADD UNIQUE KEY `id_col` (`id_col`),
  ADD UNIQUE KEY `id_cat` (`id_cat`);

--
-- Index pour la table `speak`
--
ALTER TABLE `speak`
  ADD PRIMARY KEY (`id_speak`),
  ADD UNIQUE KEY `id_lang` (`id_lang`),
  ADD UNIQUE KEY `id_col` (`id_col`);

--
-- Index pour la table `work`
--
ALTER TABLE `work`
  ADD PRIMARY KEY (`id_work`),
  ADD UNIQUE KEY `id_mis` (`id_mis`),
  ADD UNIQUE KEY `id_col` (`id_col`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id_cat` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_cli` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  MODIFY `id_col` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `langage`
--
ALTER TABLE `langage`
  MODIFY `id_lang` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `id_mis` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `poste`
--
ALTER TABLE `poste`
  MODIFY `id_post` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `speak`
--
ALTER TABLE `speak`
  MODIFY `id_speak` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `work`
--
ALTER TABLE `work`
  MODIFY `id_work` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id_cli`) REFERENCES `mission` (`id_cli`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`id_mis`) REFERENCES `work` (`id_mis`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `poste_ibfk_2` FOREIGN KEY (`id_cat`) REFERENCES `category` (`id_cat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `speak`
--
ALTER TABLE `speak`
  ADD CONSTRAINT `speak_ibfk_1` FOREIGN KEY (`id_lang`) REFERENCES `langage` (`id_lang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `speak_ibfk_2` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `work`
--
ALTER TABLE `work`
  ADD CONSTRAINT `work_ibfk_1` FOREIGN KEY (`id_col`) REFERENCES `collaborateur` (`id_col`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
