CREATE TABLE IF NOT EXISTS `transaction` (
  `int` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `amount` INT NOT NULL,
  `currency` VARCHAR(3) NOT NULL,
  `type` VARCHAR(7) NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `location_int` INT NOT NULL,
  PRIMARY KEY (`int`),
  INDEX `fk_transaction_user1_idx` (`user_id` ASC),
  INDEX `fk_transaction_location1_idx` (`location_int` ASC),
  CONSTRAINT `fk_transaction_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_location1`
  FOREIGN KEY (`location_int`)
  REFERENCES `location` (`int`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);