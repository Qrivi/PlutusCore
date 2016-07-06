CREATE TABLE IF NOT EXISTS `credit` (
  `id` INT NOT NULL,
  `amount` FLOAT NOT NULL,
  `currency` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`)
);