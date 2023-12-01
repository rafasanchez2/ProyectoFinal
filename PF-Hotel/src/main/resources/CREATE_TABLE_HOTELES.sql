CREATE TABLE `bdviajes`.`hoteles` (
  `id_hotel` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NULL,
  `categoria` INT NULL,
  `precio` DOUBLE NULL,
  `disponible` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id_hotel`));