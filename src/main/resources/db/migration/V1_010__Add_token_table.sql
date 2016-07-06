CREATE TABLE IF NOT EXISTS `token` (
  `id` INT NOT NULL,
  `token` VARCHAR(255) NOT NULL,
  `user_agent` VARCHAR(255),
  `expiry_date` DATETIME NOT NULL,
  `created_on` DATETIME NOT NULL,
  `active` TINYINT(1) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `fk_token_account1_idx` (`account_id` ASC),
  CONSTRAINT `fk_token_account1`
  FOREIGN KEY (`account_id`)
  REFERENCES `account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);