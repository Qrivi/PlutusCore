/*
  CREATE TABLES
*/

CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) default NULL,
  `sequence_next_hi_value` int(11) default NULL
);

CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `default_currency` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
);

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(80) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `fetch_date` DATETIME,
  `institution_id` INT NOT NULL,
  `credit_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `transaction` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `amount` INT NOT NULL,
  `currency` VARCHAR(3) NOT NULL,
  `type` VARCHAR(7) NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `credit` (
  `id` INT NOT NULL,
  `amount` FLOAT NOT NULL,
  `currency` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `institution` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `slur` VARCHAR(10) NOT NULL,
  `hint` VARCHAR(80) NULL,
  `username_pattern` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `slur_UNIQUE` (`slur` ASC)
);

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lat` FLOAT,
  `lng` FLOAT,
  `campus_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `campus` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lat` FLOAT NOT NULL,
  `lng` FLOAT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `zip` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `institution_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

CREATE TABLE IF NOT EXISTS `preferences` (
  `id` INT NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `preferences_map` (
  `name` VARCHAR(255) NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  `preferences_id` INT NOT NULL
);

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
  UNIQUE INDEX `token_UNIQUE` (`token` ASC)
);

CREATE TABLE IF NOT EXISTS `request` (
  `id` INT NOT NULL,
  `method` VARCHAR(6) NOT NULL,
  `endpoint` VARCHAR(45) NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `token_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

/*
  CONSTRAINTS
*/

ALTER TABLE `user`
  ADD INDEX `fk_user_credit1_idx` (`credit_id` ASC),
  ADD INDEX `fk_user_institution1_idx` (`institution_id` ASC),
  ADD INDEX `fk_user_account1_idx` (`account_id` ASC),
  ADD CONSTRAINT `fk_user_credit1`
FOREIGN KEY (`credit_id`)
REFERENCES `credit` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_institution1`
FOREIGN KEY (`institution_id`)
REFERENCES `institution` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_account1`
FOREIGN KEY (`account_id`)
REFERENCES `account` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `transaction`
  ADD INDEX `fk_transaction_user1_idx` (`user_id` ASC),
  ADD INDEX `fk_transaction_location1_idx` (`location_id` ASC),
  ADD CONSTRAINT `fk_transaction_user1`
FOREIGN KEY (`user_id`)
REFERENCES `user` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_transaction_location1`
FOREIGN KEY (`location_id`)
REFERENCES `location` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `location`
  ADD INDEX `fk_location_campus1_idx` (`campus_id` ASC),
  ADD CONSTRAINT `fk_location_campus1`
FOREIGN KEY (`campus_id`)
REFERENCES `campus` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `campus`
  ADD INDEX `fk_campus_institution1_idx` (`institution_id` ASC),
  ADD CONSTRAINT `fk_campus_institution1`
FOREIGN KEY (`institution_id`)
REFERENCES `institution` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `preferences`
  ADD INDEX `fk_preferences_account1_idx` (`account_id` ASC),
  ADD CONSTRAINT `fk_preferences_account1`
FOREIGN KEY (`account_id`)
REFERENCES `account` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `preferences_map`
  ADD INDEX `fk_preferences_map_preferences1_idx` (`preferences_id` ASC),
  ADD CONSTRAINT `fk_preferences_map_preferences1`
FOREIGN KEY (`preferences_id`)
REFERENCES `preferences` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `token`
  ADD INDEX `fk_Token_account1_idx` (`account_id` ASC),
  ADD CONSTRAINT `fk_Token_account1`
FOREIGN KEY (`account_id`)
REFERENCES `account` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `request`
  ADD INDEX `fk_request_token1_idx` (`token_id` ASC),
  ADD CONSTRAINT `fk_request_token1`
FOREIGN KEY (`token_id`)
REFERENCES `token` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

/*
  INSERTS
*/

INSERT INTO `account` (`id`,`email`,`password`,`status`,`creation_date`,`default_currency`)
  VALUES (1,'davidopdebeeck@hotmail.com','$2a$12$aAU3j2T6edWrDKkDg2WYAuoiV9IsGTY6ezQjn5KZk/mFvFGUxm7kK','ACTIVE','2016-07-07 11:45:34','EUR');
INSERT INTO `preferences` (`id`,`account_id`)
  VALUES (1, 1);
INSERT INTO `institution` (`id`,`name`,`slur`,`hint`,`username_pattern`)
  VALUES (1,'UC Leuven-Limburg','UCLL','Log in using your student ID and password','^([m|r|s][0-9]{7})$');
INSERT INTO `campus` (`id`,`name`,`lat`,`lng`,`address`,`zip`,`city`,`country`,`institution_id`)
  VALUES (1,'Proximus',50.84,4.72,'Geldenaaksebaan 335','3001','Haasrode','Belgium',1);

INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`)
  VALUES ('preferences', 2);
INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`)
  VALUES ('account', 2);
INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`)
  VALUES ('institution', 2);
INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`)
  VALUES ('campus', 2);




