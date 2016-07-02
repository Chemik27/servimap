-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-06-2016 a las 04:03:50
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dutymap`
--
CREATE DATABASE IF NOT EXISTS `dutymap` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dutymap`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address`
--

CREATE TABLE `address` (
  `id_address` bigint(20) NOT NULL,
  `street` varchar(35) NOT NULL,
  `number` int(11) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `latitude` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `id_district` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `address`
--

INSERT INTO `address` (`id_address`, `street`, `number`, `postal_code`, `latitude`, `length`, `id_district`) VALUES
(1, 'falsa', 123, 1234, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id_category` bigint(20) NOT NULL,
  `name` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id_category`, `name`) VALUES
(1, 'Carpintería');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `district`
--

CREATE TABLE `district` (
  `id_district` bigint(20) NOT NULL,
  `name` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `district`
--

INSERT INTO `district` (`id_district`, `name`) VALUES
(1, 'La Matanza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rating`
--

CREATE TABLE `rating` (
  `id_rating` bigint(20) NOT NULL,
  `reliability` int(11) NOT NULL,
  `performance` int(11) NOT NULL,
  `consideration` int(11) NOT NULL,
  `recommendation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rating`
--

INSERT INTO `rating` (`id_rating`, `reliability`, `performance`, `consideration`, `recommendation`) VALUES
(1, 12, 2, 33, 12),
(2, 22, 23, 33, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaction`
--

CREATE TABLE `transaction` (
  `id_transaction` varchar(36) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(140) DEFAULT NULL,
  `to_user` bigint(20) NOT NULL,
  `from_user` bigint(20) NOT NULL,
  `id_state` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `creation_date`, `comment`, `to_user`, `from_user`, `id_state`) VALUES
('70fb32af-6ab8-4f63-bb67-b3de79706e8a', '2016-05-12 22:11:57', NULL, 1, 2, 1),
('fbe058c5-18aa-11e6-9a78-001bb1516a26', '2016-05-12 22:35:33', NULL, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(35) NOT NULL,
  `surname` varchar(35) NOT NULL,
  `password` varchar(60) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(35) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `id_rating` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `name`, `surname`, `password`, `dni`, `email`, `phone`, `enabled`, `id_rating`, `creation_date`, `update_date`, `deleted_date`, `version`) VALUES
(1, 'Jose', 'Perez', '$2a$06$a68MhcwRoKXCQ7idkXxF8usm7MLrTB8/Z4Ih6c5bzNfC0L0nLQz5i', 33333333, 'admin@dutymap.com', '1511112222', 1, 1, '2016-05-08 15:09:32', NULL, NULL, 0),
(2, 'Prueba', 'Prueba', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 12345678, 'prueba@prueba.com', '1143214321', 1, 2, '2016-05-08 19:58:31', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_role`
--

CREATE TABLE `user_role` (
  `id_user_role` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user_role`
--

INSERT INTO `user_role` (`id_user_role`, `id_user`, `role`) VALUES
(1, 1, 'ROLE_WORKER'),
(2, 2, 'ROLE_WORKER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `work`
--

CREATE TABLE `work` (
  `id_work` bigint(20) NOT NULL,
  `name` varchar(35) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `id_category` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_address` bigint(20) NOT NULL,
  `id_feedback` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `work`
--

INSERT INTO `work` (`id_work`, `name`, `description`, `price`, `id_category`, `id_user`, `id_address`, `id_feedback`) VALUES
(1, 'Pintor', 'Pintar casas', 0, 1, 1, 1, 1),
(2, 'Kinesiologo', 'Stuff de kinesiologos', 0, 1, 2, 1, 1),
(3, 'Masajista', 'Stuff de masajistas', 0, 1, 2, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id_address`),
  ADD UNIQUE KEY `id_address` (`id_address`);

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`),
  ADD UNIQUE KEY `id_category` (`id_category`),
  ADD KEY `id_category_2` (`id_category`);

--
-- Indices de la tabla `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id_district`),
  ADD UNIQUE KEY `id_district` (`id_district`);

--
-- Indices de la tabla `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_rating`),
  ADD UNIQUE KEY `id_rating` (`id_rating`);

--
-- Indices de la tabla `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_transaction`),
  ADD UNIQUE KEY `id_transaction` (`id_transaction`),
  ADD KEY `id_transaction_2` (`id_transaction`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `id_user` (`id_user`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_user_2` (`id_user`);

--
-- Indices de la tabla `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id_user_role`),
  ADD UNIQUE KEY `id_user_role` (`id_user_role`);

--
-- Indices de la tabla `work`
--
ALTER TABLE `work`
  ADD PRIMARY KEY (`id_work`),
  ADD UNIQUE KEY `id_service` (`id_work`),
  ADD KEY `id_service_2` (`id_work`),
  ADD KEY `id_work` (`id_work`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `address`
--
ALTER TABLE `address`
  MODIFY `id_address` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id_category` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `district`
--
ALTER TABLE `district`
  MODIFY `id_district` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `rating`
--
ALTER TABLE `rating`
  MODIFY `id_rating` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id_user_role` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `work`
--
ALTER TABLE `work`
  MODIFY `id_work` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
