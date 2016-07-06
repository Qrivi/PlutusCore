CREATE TABLE IF NOT EXISTS `institution` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `slur` VARCHAR(10) NOT NULL,
  `hint` VARCHAR(80) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `slur_UNIQUE` (`slur` ASC))
);