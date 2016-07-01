CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `preferences_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_account_preferences_idx` (`preferences_id` ASC),
  CONSTRAINT `fk_account_preferences`
  FOREIGN KEY (`preferences_id`)
  REFERENCES `preferences` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);