-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-07-2016 a las 00:19:55
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dutymap`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id_address` bigint(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(35) NOT NULL,
  `number` int(11) NOT NULL,
  `latitude` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `id_district` bigint(20) NOT NULL,
  PRIMARY KEY (`id_address`),
  UNIQUE KEY `id_address` (`id_address`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `address`
--

INSERT INTO `address` (`id_address`, `street`, `number`, `latitude`, `length`, `id_district`) VALUES
(1, 'Arieta', 123, NULL, NULL, 1),
(2, 'Rivadavia', 2014, NULL, NULL, 2),
(3, 'French', 3254, NULL, NULL, 3),
(4, 'Moreno', 1205, NULL, NULL, 4),
(5, 'Colombia', 758, NULL, NULL, 5),
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
(20, 'Illia', 123, NULL, NULL, 4),
(21, 'refactor', 1234, NULL, NULL, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id_category` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE KEY `id_category` (`id_category`),
  KEY `id_category_2` (`id_category`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id_category`, `name`) VALUES
(1, 'Hogar'),
(2, 'EducaciÃ³n'),
(3, 'Salud'),
(4, 'EstÃ©tica'),
(5, 'Entretenimiento'),
(6, 'Profesional'),
(7, 'TÃ©cnico'),
(8, 'Automotriz'),
(9, 'Otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `district`
--

CREATE TABLE IF NOT EXISTS `district` (
  `id_district` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  PRIMARY KEY (`id_district`),
  UNIQUE KEY `id_district` (`id_district`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `district`
--

INSERT INTO `district` (`id_district`, `name`) VALUES
(1, '20 de Junio'),
(2, 'Aldo Bonzi'),
(3, 'Ciudad Evita'),
(4, 'GonzÃ¡lez CatÃ¡n'),
(5, 'Gregorio de Laferrere'),
(6, 'Isidro Casanova'),
(7, 'La Tablada'),
(8, 'Lomas del Mirador'),
(9, 'Rafael Castillo'),
(10, 'Ramos MejÃ­a'),
(11, 'San Justo'),
(12, 'Tapiales'),
(13, 'Villa Luzuriaga'),
(14, 'Villa Madero'),
(15, 'Virrey del Pino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `id_rating` bigint(20) NOT NULL AUTO_INCREMENT,
  `reliability` int(11) NOT NULL,
  `performance` int(11) NOT NULL,
  `consideration` int(11) NOT NULL,
  `recommendation` int(11) NOT NULL,
  `id_provider` bigint(11) NOT NULL,
  `review_text` varchar(45) DEFAULT NULL,
  `general_average` varchar(45) NOT NULL,
  `id_user` bigint(11) NOT NULL,
  PRIMARY KEY (`id_rating`),
  UNIQUE KEY `id_rating` (`id_rating`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `rating`
--

INSERT INTO `rating` (`id_rating`, `reliability`, `performance`, `consideration`, `recommendation`, `id_provider`, `review_text`, `general_average`, `id_user`) VALUES
(1, 3, 2, 5, 2, 0, NULL, '', 0),
(2, 4, 3, 2, 5, 0, NULL, '', 0),
(3, 2, 3, 2, 3, 0, NULL, '', 0),
(4, 1, 1, 1, 1, 0, NULL, '', 0),
(5, 5, 5, 5, 5, 0, NULL, '', 0),
(6, 3, 3, 3, 3, 0, NULL, '', 0),
(7, 4, 3, 4, 3, 0, NULL, '', 0),
(8, 3, 5, 4, 5, 0, NULL, '', 0),
(9, 2, 2, 3, 4, 0, NULL, '', 0),
(10, 5, 3, 3, 3, 0, NULL, '', 0),
(11, 3, 4, 2, 2, 0, NULL, '', 0),
(12, 4, 3, 4, 2, 0, NULL, '', 0),
(13, 4, 4, 3, 2, 0, NULL, '', 0),
(14, 2, 3, 2, 1, 0, NULL, '', 0),
(15, 3, 4, 2, 1, 0, NULL, '', 0),
(16, 4, 3, 2, 4, 0, NULL, '', 0),
(17, 2, 1, 2, 3, 0, NULL, '', 0),
(18, 4, 4, 3, 5, 0, NULL, '', 0),
(19, 3, 2, 4, 3, 0, NULL, '', 0),
(20, 4, 5, 5, 5, 0, NULL, '', 0),
(21, 1, 1, 5, 5, 1, 'mensaje de prueba', '', 0),
(22, 5, 5, 1, 1, 1, 'proueba 22', '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `id_transaction` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_user` bigint(20) NOT NULL,
  `from_user` bigint(20) NOT NULL,
  `agreed_date` datetime NOT NULL,
  `done` bit(1) NOT NULL,
  PRIMARY KEY (`id_transaction`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `creation_date`, `to_user`, `from_user`, `agreed_date`, `done`) VALUES
(1, '2016-06-08 19:02:07', 2, 3, '2016-07-01 00:00:00', b'0'),
(2, '2016-05-08 19:02:07', 2, 3, '2016-09-02 00:00:00', b'0'),
(3, '2016-04-08 19:02:07', 2, 3, '2016-06-03 00:00:00', b'0'),
(4, '2016-03-08 19:02:07', 2, 3, '2016-02-04 00:00:00', b'0'),
(5, '2016-02-08 19:02:07', 2, 3, '2016-15-05 00:00:00', b'0'),
(6, '2016-02-07 19:02:07', 2, 3, '2016-15-06 00:00:00', b'0'),
(7, '2016-02-06 19:02:07', 2, 3, '2016-15-07 00:00:00', b'0'),
(8, '2016-02-06 19:02:07', 2, 3, '2016-15-07 00:00:00', b'1'),
(9, '2016-02-05 19:02:07', 2, 3, '2016-15-08 00:00:00', b'0');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  `surname` varchar(35) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(35) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `type` varchar(35) NOT NULL,
  `id_address` bigint(20) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user` (`id_user`),
  UNIQUE KEY `email` (`email`),
  KEY `id_user_2` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `name`, `surname`, `password`, `email`, `phone`, `enabled`, `type`, `id_address`, `creation_date`, `update_date`, `deleted_date`, `version`) VALUES
(1, 'Jose', 'Perez', '$2a$06$a68MhcwRoKXCQ7idkXxF8usm7MLrTB8/Z4Ih6c5bzNfC0L0nLQz5i', 'admin@dutymap.com', '1511112222', 1, 'proveedor', NULL, '2016-05-08 15:09:32', NULL, NULL, 0),
(2, 'MatÃ­as', 'Lopez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba@prueba.com', '1143214321', 1, 'proveedor', NULL, '2016-05-08 19:58:31', NULL, NULL, 0),
(3, 'Karina', 'Rodriguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba2@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-05-04 20:58:31', NULL, NULL, 0),
(4, 'Jonathan', 'Armuren', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba3@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-02-08 21:58:31', NULL, NULL, 0),
(5, 'Maxi', 'Citrinsky', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba4@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-04-10 22:58:31', NULL, NULL, 0),
(6, 'NicolÃ¡s', 'Lopez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba5@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-06-03 18:30:31', NULL, NULL, 0),
(7, 'Laura', 'Sanchez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba6@gmail.com', '1143214321', 1, 'proveedor', NULL, '2015-02-08 20:15:31', NULL, NULL, 0),
(8, 'Romina', 'Raso', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba7@gmail.com', '1143214321', 1, 'proveedor', NULL, '2015-09-01 15:58:31', NULL, NULL, 0),
(9, 'Paula', 'Cinti', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba8@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-09-05 18:52:31', NULL, NULL, 0),
(10, 'Facundo', 'Fernandez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba9@gmail.com', '1143214321', 1, 'proveedor', NULL, '2015-09-01 14:18:12', NULL, NULL, 0),
(11, 'Franco', 'Campos', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba10@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-03-06 19:58:31', NULL, NULL, 0),
(12, 'Julieta', 'Medici', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba11@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-04-02 16:58:31', NULL, NULL, 0),
(13, 'Ivana', 'Salinas', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba12@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-09-09 21:58:31', NULL, NULL, 0),
(14, 'Lucio', 'Barraza', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba13@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-02-01 17:58:31', NULL, NULL, 0),
(15, 'Catalina', 'Dominguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba14@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-02-04 19:58:31', NULL, NULL, 0),
(16, 'Santiago', 'Rodriguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba15@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-05-06 19:58:31', NULL, NULL, 0),
(17, 'Romina', 'Laureano', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba16@gmail.com', '1143214321', 1, 'proveedor', NULL, '2016-05-06 19:58:31', NULL, NULL, 0),
(18, 'Laura', 'Gamberini', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba17@gmail.com', '1143214321', 1, 'comprador', NULL, '2016-05-06 19:58:31', NULL, NULL, 0),
(19, 'Matias', 'Dominguez', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba18@gmail.com', '1143214321', 1, 'comprador', NULL, '2016-05-06 19:58:31', NULL, NULL, 0),
(20, 'Lucio', 'Santillan', '$2a$06$M/8n8KxO5vlGSGuMZKyZHOVZCLymDpDJfMbxuRC07tSL30.LR78dS', 'prueba19@gmail.com', '1143214321', 1, 'comprador', NULL, '2016-05-06 19:58:31', NULL, NULL, 0),
(21, 'normal', 'normal', '$2a$10$WPTLrRM3KDqmOpHi.oeneeNM0XHIDrzYQyPrEQeI14iumbkle1xIm', 'normal@normal.com', '1144444444', 1, 'comprador', NULL, '2016-07-07 20:56:41', NULL, NULL, 0),
(22, 'proveedor', 'proveedor', '$2a$10$/iUg8Ko/i6RAWNzyUwAL2ebtTqz/jF8mmP8NsoHNCJ1Ra.M2I01cG', 'proveedor@proveedor.com', '1144444444', 1, 'proveedor', NULL, '2016-07-07 20:57:52', NULL, NULL, 0),
(23, 'Refactor', 'registro', '$2a$10$qQKhA4k1Vp.Gqo7MD/PjduUKiMKSNw7pXvvbngOq904aQtY1RFCzu', 'refactor@refactor.com', '1144444444', 1, 'comprador', 21, '2016-07-08 17:45:53', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `id_user_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id_user_role`),
  UNIQUE KEY `id_user_role` (`id_user_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

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
(10, 10, 'ROLE_WORKER'),
(11, 11, 'ROLE_WORKER'),
(12, 12, 'ROLE_WORKER'),
(13, 13, 'ROLE_WORKER'),
(14, 14, 'ROLE_WORKER'),
(15, 15, 'ROLE_WORKER'),
(16, 16, 'ROLE_WORKER'),
(17, 16, 'ROLE_WORKER'),
(18, 16, 'ROLE_USER'),
(19, 16, 'ROLE_USER'),
(20, 16, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `work`
--

CREATE TABLE IF NOT EXISTS `work` (
  `id_work` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `id_category` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_address` bigint(20) NOT NULL,
  `id_feedback` bigint(20) NOT NULL,
  PRIMARY KEY (`id_work`),
  UNIQUE KEY `id_service` (`id_work`),
  KEY `id_service_2` (`id_work`),
  KEY `id_work` (`id_work`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `work`
--

INSERT INTO `work` (`id_work`, `name`, `description`, `price`, `id_category`, `id_user`, `id_address`, `id_feedback`) VALUES
(1, 'Pintor', 'Pintar casas', 0, 1, 1, 1, 1),
(2, 'Profesor particular', 'MatemÃ¡tica primaria y secundaria', 200, 2, 2, 2, 2),
(3, 'Masajista', '5 aÃ±os de experiencia', 45, 1, 3, 3, 3),
(4, 'CosmetÃ³logo', 'Limpiezas', 400, 4, 4, 4, 4),
(5, 'Musicalizador', 'MÃºsica de todo tipo', 300, 5, 5, 5, 5),
(6, 'Contador', 'Balances y cierres a Pymes', 500, 6, 6, 6, 6),
(7, 'TÃ©cnico electrodomÃ©stico', 'ReparaciÃ³n de heladeras, estufas, microondas y mÃ¡s', 300, 7, 7, 7, 7),
(8, 'MecÃ¡nico', '5 aÃ±os de experiencia en el rubro', 300, 8, 8, 8, 8),
(9, 'Flete', 'Fletes a cualquier parte de La Matanza', 100, 9, 9, 9, 9),
(10, 'Gasista', 'Gasista con 15 aÃ±os de experiencia', 205, 1, 10, 10, 10),
(11, 'Profesor particular', 'BiologÃ­a y fÃ­sica.3 aÃ±os de experiencia', 150, 2, 11, 11, 11),
(12, 'KinesiÃ³logo', 'Rehabilitaciones', 350, 3, 12, 12, 12),
(13, 'Abogado', '10 aÃ±os de experiencia. UNLAM', 0, 6, 13, 13, 13),
(14, 'Arquitecto', '10 aÃ±os de experiencia. UBA', 0, 6, 14, 14, 14),
(15, 'Gestor automotor', '10 aÃ±os de experiencia', 0, 6, 15, 1, 15),
(16, 'Tasador', '10 aÃ±os de experiencia. UBA', 0, 6, 16, 1, 16),
(17, 'TÃ©cnico en informatica', '6 aÃ±os de experiencia.ReparaciÃ³n, formateos, backups.', 350, 7, 17, 1, 17);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
