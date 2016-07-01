CREATE TABLE IF NOT EXISTS `campus` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lat` FLOAT NOT NULL,
  `lng` FLOAT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `institution_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_campus_institution1_idx` (`institution_id` ASC),
  CONSTRAINT `fk_campus_institution1`
  FOREIGN KEY (`institution_id`)
  REFERENCES `institution` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);