

CREATE TABLE events (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `pretty_name` VARCHAR(50) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `start_time` TIME NULL DEFAULT NULL,
  `end_time` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE INDEX `pretty_name_UNIQUE` (`pretty_name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;

