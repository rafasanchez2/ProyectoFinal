CREATE TABLE `bdviajes`.`vuelos` (
  `id_vuelo` INT NOT NULL AUTO_INCREMENT,
  `compania` VARCHAR(100) NULL,
  `fecha_vuelo` DATE NULL,
  `precio` DOUBLE NULL,
  `plazas_disponibles` INT NULL,
  PRIMARY KEY (`id_vuelo`));
