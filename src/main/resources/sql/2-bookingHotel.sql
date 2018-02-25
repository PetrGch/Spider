# BOOKING HOTELS

DROP TABLE IF EXISTS `booking_hotel`;

CREATE TABLE `booking_hotel` (
  `id`                   INT(11)     NOT NULL AUTO_INCREMENT,
  `unique_item_id`       VARCHAR(40) NOT NULL UNIQUE,
  `name`                 VARCHAR(50) NOT NULL,
  `type`                 VARCHAR(20)          DEFAULT NULL,
  `coordinates`          VARCHAR(50)          DEFAULT NULL,
  `distance_from_center` DOUBLE(5, 3)         DEFAULT NULL,
  `amount_of_people`     INT(11)              DEFAULT NULL,
  `space`                INT(11)              DEFAULT NULL,
  `booking_detail_id`    INT(11)              DEFAULT NULL,
  `some`                 INT(11)              DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`booking_detail_id`),
#   KEY `FK_SOMME_idx` (`some`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`booking_detail_id`)
  REFERENCES `booking_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
#   CONSTRAINT `FK_SOME` FOREIGN KEY (`some`)
#   REFERENCES `some` (`id`)
#   ON DELETE NO ACTION
#   ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8;

INSERT INTO `booking_hotel` VALUES
  (0, 'e890a831-d1c6-4e77-a370-d743c47e06a0', 'ывафыва', '', '41.6454054413864,41.6402908220785',
   '0.75', '2', 0, 1, 1);

SELECT * FROM booking_hotel;

# BOOKING DETAIL

DROP TABLE IF EXISTS `booking_detail`;

CREATE TABLE `booking_detail` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `raiting`         DOUBLE(3, 2)     DEFAULT NULL,
  `location_score`  INT(4)           DEFAULT NULL,
  `cleanness_score` INT(4)           DEFAULT NULL,
  `price_quality`   INT(4)           DEFAULT NULL,
  `comfort_score`   INT(4)           DEFAULT NULL,
  `staff_score`     INT(4)           DEFAULT NULL,
  `comments`        INT(4)           DEFAULT NULL,
  `reputation`      VARCHAR(100)     DEFAULT NULL,
  `date`            DATE             DEFAULT NULL,
  `hotel_id`        INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8;

INSERT INTO `booking_detail` VALUES
  (1, 9.9, 10, 10, 10, 10, 95, 5, 'Великолепно Месторасположение', '2018-02-21', 1);

SELECT * FROM booking_detail;

DROP TABLE IF EXISTS `some`;

CREATE TABLE `some` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `someField`         DOUBLE(3, 2)     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8;


INSERT INTO `some` VALUES
  (1, 9.9);

SELECT * FROM some;


# HOTELS RATING

DROP TABLE IF EXISTS `booking_rating`;

CREATE TABLE `booking_rating` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `raiting`         DOUBLE(3, 2)     DEFAULT NULL,
  `location_score`  INT(4)           DEFAULT NULL,
  `cleanness_score` INT(4)           DEFAULT NULL,
  `price_quality`   INT(4)           DEFAULT NULL,
  `comfort_score`   INT(4)           DEFAULT NULL,
  `staff_score`     INT(4)           DEFAULT NULL,
  `comments`        INT(4)           DEFAULT NULL,
  `reputation`      VARCHAR(100)     DEFAULT NULL,
  `date`            DATE             DEFAULT NULL,
  `hotel_id`        INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_HOTEL_idx` (`hotel_id`),
  CONSTRAINT `FK_HOTEL` FOREIGN KEY (`hotel_id`)
  REFERENCES `booking_hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8;

INSERT INTO `booking_rating` VALUES
  (1, 9.9, 10, 10, 10, 10, 95, 5, 'Великолепно Месторасположение', '2018-02-21', 1);

SELECT * FROM booking_rating;

SELECT booking_hotel.id, booking_hotel.name, booking_detail.cleanness_score, some.someField
FROM booking_hotel
  JOIN booking_detail on booking_hotel.id = booking_detail.hotel_id
  JOIN some on booking_hotel.id = some.id;