CREATE TABLE `bdviajes`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(100) NULL,
  `dni` VARCHAR(9) NULL,
  `id_hotel` INT NOT NULL,
  `id_vuelo` INT NOT NULL,
  `numero_personas` INT NULL,
  PRIMARY KEY (`id_reserva`),
  INDEX `id_vuelo_idx` (`id_vuelo` ASC) VISIBLE,
  INDEX `id_hotel_idx` (`id_hotel` ASC) VISIBLE,
  CONSTRAINT `id_vuelo`
    FOREIGN KEY (`id_vuelo`)
    REFERENCES `bdviajes`.`vuelos` (`id_vuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_hotel`
    FOREIGN KEY (`id_hotel`)
    REFERENCES `bdviajes`.`hoteles` (`id_hotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
