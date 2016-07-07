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

INSERT INTO `address` (`id_address`, `street`, `number`, `latitude`, `length`, `id_district`) VALUES
(1, 'Arieta', 123, NULL, NULL, 1),
(2, 'Rivadavia', 2014, NULL, NULL, 2),
(3, 'French', 3254, NULL, NULL, 3),
(4, 'Moreno', 1205, NULL, NULL, 4),
(5, 'Colombia', 758, NULL, NULL,5),
(6, 'Sarmiento', 546, NULL, NULL, 6),
(7, '9 de julio', 200, NULL, NULL, 7),
(8, 'Machado', 1354, NULL, NULL, 8),
(9, 'Larrea', 354, NULL, NULL, 9),
(10, 'Balbin', 789, NULL, NULL, 10),
(11, 'Barcelona', 468, NULL, NULL, 11),
(12, 'Castelli', 648, NULL, NULL, 12),
(13, 'Cisneros', 1002, NULL, NULL, 13),
(14, 'Rojas', 1548, NULL, NULL, 14),
(15, 'Italia', 1987, NULL, NULL, 15),
(16, 'Rosas', 2145, NULL, NULL, 16),
(17, 'Salcedo', 1254, NULL, NULL, 1),
(18, 'Uruguay', 2546, NULL, NULL, 2),
(19, 'Peron', 3245, NULL, NULL, 3),
(20, 'Illia', 123, NULL, NULL, 4);


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
(1, 'Hogar'),
(2, 'Educación'),
(3, 'Salud'),
(4, 'Estética'),
(5, 'Entretenimiento'),
(6, 'Profesional'),
(7, 'Técnico'),
(8, 'Automotriz'),
(9, 'Otros');

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
(1, 'La Matanza'),
(2, '20 de Junio'),
(3, 'Aldo Bonzi'),
(4, 'Ciudad Evita'),
(5, 'González Catán'),
(6, 'Gregorio de Laferrere'),
(7, 'Isidro Casanova'),
(8, 'La Tablada'),
(9, 'Lomas del Mirador'),
(10, 'Rafael Castillo'),
(11, 'Ramos Mejía'),
(12, 'San Justo'),
(13, 'Tapiales'),
(14, 'Villa Luzuriaga'),
(15, 'Villa Madero'),
(16, 'Virrey del Pino');

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
(1, 3, 2, 5, 2),
(2, 4, 3, 2, 5),
(3, 2, 3, 2, 3),
(4, 1, 1, 1, 1),
(5, 5, 5, 5, 5),
(6, 3, 3, 3, 3),
(7, 4, 3, 4, 3),
(8, 3, 5, 4, 5),
(9, 2, 2, 3, 4),
(10, 5, 3, 3, 3),
(11, 3, 4, 2, 2),
(12, 4, 3, 4, 2),
(13, 4, 4, 3, 2),
(14, 2, 3, 2, 1),
(15, 3, 4, 2, 1),
(16, 4, 3, 2, 4),
(17, 2, 1, 2, 3),
(18, 4, 4, 3, 5),
(19, 3, 2, 4, 3),
(20, 4, 5, 5, 5);



-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `transaction`
CREATE TABLE `transaction` (
  `id_transaction` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(140) NULL,
  `to_user` bigint(20) NOT NULL,
  `from_user` bigint(20) NOT NULL,
  `agreed_date` datetime NOT NULL,
  `done` BIT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--

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

(2, 'Matías', 'Lopez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 12345678, 'prueba@prueba.com', '1143214321', 1, 2, '2016-05-08 19:58:31', NULL, NULL, 0),

(3, 'Karina', 'Rodriguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 38215487, 'prueba2@gmail.com', '1143214321', 1, 3, '2016-05-04 20:58:31', NULL, NULL, 0),

(4, 'Jonathan', 'Armuren', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 38798785, 'prueba3@gmail.com', '1143214321', 1, 4, '2016-02-08 21:58:31', NULL, NULL, 0),

(5, 'Maxi', 'Citrinsky', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 36487965, 'prueba4@gmail.com', '1143214321', 1, 5, '2016-04-10 22:58:31', NULL, NULL, 0),

(6, 'Nicolás', 'Lopez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 37897548, 'prueba5@gmail.com', '1143214321', 1, 6, '2016-06-03 18:30:31', NULL, NULL, 0),

(7, 'Laura', 'Sanchez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 38795236, 'prueba6@gmail.com', '1143214321', 1, 7, '2015-02-08 20:15:31', NULL, NULL, 0),

(8, 'Romina', 'Raso', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 15478965, 'prueba7@gmail.com', '1143214321', 1, 8, '2015-09-01 15:58:31', NULL, NULL, 0),

(9, 'Paula', 'Cinti', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 20354879, 'prueba8@gmail.com', '1143214321', 1, 9, '2016-09-05 18:52:31', NULL, NULL, 0),

(10, 'Facundo', 'Fernandez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 17987564, 'prueba9@gmail.com', '1143214321', 1, 10, '2015-09-01 14:18:12', NULL, NULL, 0),

(11, 'Franco', 'Campos', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 30215654, 'prueba10@gmail.com', '1143214321', 1, 11, '2016-03-06 19:58:31', NULL, NULL, 0),

(12, 'Julieta', 'Medici', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 35487123, 'prueba11@gmail.com', '1143214321', 1, 12, '2016-04-02 16:58:31', NULL, NULL, 0),

(13, 'Ivana', 'Salinas', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 35458654, 'prueba12@gmail.com', '1143214321', 1, 13, '2016-09-09 21:58:31', NULL, NULL, 0),

(14, 'Lucio', 'Barraza', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 35487456, 'prueba13@gmail.com', '1143214321', 1, 14, '2016-02-01 17:58:31', NULL, NULL, 0),

(15, 'Catalina', 'Dominguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 36487528, 'prueba14@gmail.com', '1143214321', 1, 15, '2016-02-04 19:58:31', NULL, NULL, 0),

(16, 'Santiago', 'Rodriguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 36987456, 'prueba15@gmail.com', '1143214321', 1, 16, '2016-05-06 19:58:31', NULL, NULL, 0),

(17, 'Romina', 'Laureano', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 34879548, 'prueba16@gmail.com', '1143214321', 1, 17, '2016-05-06 19:58:31', NULL, NULL, 0),

(18, 'Laura', 'Gamberini', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 37987546, 'prueba17@gmail.com', '1143214321', 1, 18, '2016-05-06 19:58:31', NULL, NULL, 0),

(19, 'Matias', 'Dominguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 38987546, 'prueba18@gmail.com', '1143214321', 1, 19, '2016-05-06 19:58:31', NULL, NULL, 0),

(20, 'Lucio', 'Santillan', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 34879523, 'prueba19@gmail.com', '1143214321', 1, 20, '2016-05-06 19:58:31', NULL, NULL, 0);

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
(2, 2, 'ROLE_WORKER'),
(3, 3, 'ROLE_WORKER'),
(4, 4, 'ROLE_WORKER'),
(5, 5, 'ROLE_WORKER'),
(6, 6, 'ROLE_WORKER'),
(7, 7, 'ROLE_WORKER'),
(8, 8, 'ROLE_WORKER'),
(9, 9, 'ROLE_WORKER'),
(10, 10,'ROLE_WORKER'),
(11, 11,'ROLE_WORKER'),
(12, 12,'ROLE_WORKER'),
(13, 13,'ROLE_WORKER'),
(14, 14,'ROLE_WORKER'),
(15, 15,'ROLE_WORKER'),
(16, 16,'ROLE_WORKER'),
(17, 16,'ROLE_WORKER'),
(18, 16,'ROLE_USER'),
(19, 16,'ROLE_USER'),
(20, 16,'ROLE_USER');

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
(2, 'Profesor particular', 'Matemática primaria y secundaria', 200, 2, 2, 2, 2),
(3, 'Masajista', '5 años de experiencia', 45, 1, 3, 3, 3),
(4, 'Cosmetólogo', 'Limpiezas', 400, 4, 4, 4, 4),
(5, 'Musicalizador', 'Música de todo tipo', 300, 5, 5, 5, 5),
(6, 'Contador', 'Balances y cierres a Pymes', 500, 6, 6, 6, 6),
(7, 'Técnico electrodoméstico', 'Reparación de heladeras, estufas, microondas y más', 300, 7, 7, 7, 7),
(8, 'Mecánico', '5 años de experiencia en el rubro', 300, 8, 8, 8, 8),
(9, 'Flete', 'Fletes a cualquier parte de La Matanza', 100, 9, 9, 9, 9),
(10, 'Gasista', 'Gasista con 15 años de experiencia', 205, 1, 10, 10, 10),
(11, 'Profesor particular', 'Biología y física.3 años de experiencia', 150, 2, 11, 11, 11),
(12, 'Kinesiólogo', 'Rehabilitaciones', 350, 3, 12, 12, 12),
(13, 'Abogado', '10 años de experiencia. UNLAM', 0, 6, 13, 13, 13),
(14, 'Arquitecto', '10 años de experiencia. UBA', 0, 6, 14, 14, 14),
(15, 'Gestor automotor', '10 años de experiencia', 0, 6, 15, 1, 15),
(16, 'Tasador', '10 años de experiencia. UBA', 0, 6, 16, 1, 16),
(17, 'Técnico en informatica', '6 años de experiencia.Reparación, formateos, backups.', 350, 7, 17, 1, 17);


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
  ADD PRIMARY KEY (`id_transaction`);
 
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

-- AUTO_INCREMENT de la tabla `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id_transaction` bigint(20) NOT NULL AUTO_INCREMENT;

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
