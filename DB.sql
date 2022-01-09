CREATE TABLE `usuario` (
  `idUsuario` int(11) UNSIGNED NOT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `alumno` (
  `idAlumno` int(11) UNSIGNED NOT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `curso` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `curso` (
  `idCurso` int(11) UNSIGNED NOT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `materia` (
  `idMateria` int(11) UNSIGNED NOT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `curso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `notas` (
  `idNotas` int(11) UNSIGNED NOT NULL,
  `alumno` varchar(10) DEFAULT NULL,
  `curso` int(11) DEFAULT NULL,
  `materia` varchar(255) DEFAULT NULL,
  `nota1` double DEFAULT NULL,
  `nota2` double DEFAULT NULL,
  `nota3` double DEFAULT NULL,
  `promedio` double DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);
  
  ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`);
  
    ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`);
  
  ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);
  
  ALTER TABLE `notas`
  ADD PRIMARY KEY (`idNotas`);
  
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
  
  ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
  
  ALTER TABLE `curso`
  MODIFY `idCurso` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
  
  ALTER TABLE `materia`
  MODIFY `idMateria` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
  
  ALTER TABLE `notas`
  MODIFY `idNotas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;