CREATE TABLE IF NOT EXISTS `preferences_map` (
  `name` VARCHAR(255) NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  `preferences_id` INT NOT NULL,
  INDEX `fk_preferences_map_preferences1_idx` (`preferences_id` ASC),
  CONSTRAINT `fk_preferences_map_preferences1`
  FOREIGN KEY (`preferences_id`)
  REFERENCES `preferences` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);