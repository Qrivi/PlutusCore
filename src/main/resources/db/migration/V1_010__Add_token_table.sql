CREATE TABLE IF NOT EXISTS `token` (
  `id` INT NOT NULL,
  `token` VARCHAR(255) NOT NULL,
  `application_name` VARCHAR(45) NOT NULL,
  `device_name` VARCHAR(45) NOT NULL,
  `request_ip` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `expiry_date` DATETIME NOT NULL,
  `active` TINYINT(1) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Token_account1_idx` (`account_id` ASC),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  CONSTRAINT `fk_Token_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
);