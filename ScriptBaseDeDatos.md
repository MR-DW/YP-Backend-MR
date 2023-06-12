-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: baojqu29cy78mdy9znd4-mysql.services.clever-cloud.com:3306
-- Generation Time: Jun 12, 2023 at 05:03 PM
-- Server version: 8.0.15-5
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baojqu29cy78mdy9znd4`
--

-- --------------------------------------------------------

--
-- Table structure for table `educacion`
--

CREATE TABLE `educacion` (
  `id` int(11) NOT NULL,
  `descripcion_ed` varchar(255) DEFAULT NULL,
  `nombre_edu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `educacion`
--

INSERT INTO `educacion` (`id`, `descripcion_ed`, `nombre_edu`) VALUES
(1, 'Instituto Superior Politécnico de Córdoba. Desde: 05/05/2022 - Hasta: 15/12/2022', 'Full Stack Python / React'),
(2, 'Say Quality. Desde: 7/03/2022 - Hasta: 24/06/2022', 'Testing QA'),
(3, 'borrar', 'editar');

-- --------------------------------------------------------

--
-- Table structure for table `experiencia`
--

CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL,
  `descripcion_exp` varchar(255) DEFAULT NULL,
  `nombre_exp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `experiencia`
--

INSERT INTO `experiencia` (`id`, `descripcion_exp`, `nombre_exp`) VALUES
(1, 'Desarrollador Frontend. Desde: 10/07/2022 - Hasta: Actualidad.', 'RMCuantica'),
(2, 'Desarrollador Front-End. Programa Desarrollando Futuros. Inicio: 05/03/2022 Fin:23/08/2022', 'UNC'),
(3, 'borrar', 'editar');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `edad` varchar(100) DEFAULT NULL,
  `img` varchar(255) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `profesion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `apellido`, `descripcion`, `edad`, `img`, `nombre`, `profesion`) VALUES
(1, 'Ruiz', 'Bienvenidos! Te cuento sobre mí: Soy Full Stack Developer Jr y tengo 27 años. Actualmente trabajo como desarrollador en frontend para una prestigiosa empresa de Córdoba. Incursione en la Programación desde hace 2 años y encontré mi profesión.', '27', '', 'Matias Ignacio', '');

-- --------------------------------------------------------

--
-- Table structure for table `proyectos`
--

CREATE TABLE `proyectos` (
  `id` int(11) NOT NULL,
  `descripcion_proyectos` varchar(255) DEFAULT NULL,
  `nombre_proyectos` varchar(255) DEFAULT NULL,
  `url_proyectos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proyectos`
--

INSERT INTO `proyectos` (`id`, `descripcion_proyectos`, `nombre_proyectos`, `url_proyectos`) VALUES
(1, 'Desarrollo de una botonera con la finalidad de unificar en un solo lugar, los distintos link de redes sociales e e-commerce que maneja la empresa.', 'Conexion', 'https://mr-dw.github.io/corralon-san-miguel/'),
(3, 'borrar', 'editar', 'borrar');

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol_nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id`, `rol_nombre`) VALUES
(1, 'ROLE_ADMI'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `skills`
--

CREATE TABLE `skills` (
  `id` int(11) NOT NULL,
  `nombre_skills` varchar(255) DEFAULT NULL,
  `porcentaje_skills` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skills`
--

INSERT INTO `skills` (`id`, `nombre_skills`, `porcentaje_skills`) VALUES
(1, 'Python', 70),
(2, 'React', 70),
(3, 'SQL / MySQL ', 70),
(4, 'Comunicación Asertiva', 100),
(5, 'Angular', 80),
(6, 'Java', 80),
(7, 'Valores', 100);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `nombre`, `nombre_usuario`, `password`) VALUES
(1, 'admin@administrador.com', 'adminmatias', 'adminmatias123', 'AM123');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skills`
--
ALTER TABLE `skills`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  ADD UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`);

--
-- Indexes for table `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FK610kvhkwcqk2pxeewur4l7bd1` (`rol_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `skills`
--
ALTER TABLE `skills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK610kvhkwcqk2pxeewur4l7bd1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  ADD CONSTRAINT `FKbyfgloj439r9wr9smrms9u33r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
