CREATE TABLE IF NOT EXISTS `request` (
  `id` INT NOT NULL,
  `endpoint` VARCHAR(45) NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `token_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_request_token1_idx` (`token_id` ASC),
  CONSTRAINT `fk_request_token1`
  FOREIGN KEY (`token_id`)
  REFERENCES `token` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);