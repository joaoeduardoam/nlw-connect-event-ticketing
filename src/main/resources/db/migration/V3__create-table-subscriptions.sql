

CREATE TABLE subscriptions (
  `subscription_number` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `subscribed_user_id` INT UNSIGNED NOT NULL,
  `indication_user_id` INT UNSIGNED NULL DEFAULT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`subscription_number`),
  INDEX `fk_tbl_subscription_tbl_user_idx` (`subscribed_user_id` ASC) VISIBLE,
  INDEX `fk_tbl_subscription_tbl_user1_idx` (`indication_user_id` ASC) VISIBLE,
  INDEX `fk_tbl_subscription_tbl_event1_idx` (`event_id` ASC) VISIBLE,
  CONSTRAINT `subscriptions_event_id_fkey`
    FOREIGN KEY (`event_id`)
    REFERENCES events (`event_id`),
  CONSTRAINT `subscriptions_user_id_fkey`
    FOREIGN KEY (`subscribed_user_id`)
    REFERENCES users (`user_id`),
  CONSTRAINT `subscriptions_indication_user_id_fkey`
    FOREIGN KEY (`indication_user_id`)
    REFERENCES users (`user_id`)
)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

