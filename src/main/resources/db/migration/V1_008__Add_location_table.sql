CREATE TABLE IF NOT EXISTS `location` (
  `int` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lat` FLOAT,
  `lng` FLOAT,
  `campus_id` INT NOT NULL,
  PRIMARY KEY (`int`),
  INDEX `fk_location_campus1_idx` (`campus_id` ASC),
  CONSTRAINT `fk_location_campus1`
  FOREIGN KEY (`campus_id`)
  REFERENCES `campus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);