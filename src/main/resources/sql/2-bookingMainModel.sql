DROP TABLE IF EXISTS `booking_main_model`;

CREATE TABLE `booking_main_model` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `unique_item_id`  VARCHAR(40) NOT NULL UNIQUE,
  `name`            VARCHAR(50) DEFAULT NULL,
  `date`            DATE NOT NULL,
  `type`            VARCHAR(20) DEFAULT NULL,
  `discont_price`   DOUBLE(10,2) DEFAULT NULL,
  `real_price`      DOUBLE(10,2) DEFAULT NULL,
  `coordinates`     VARCHAR(50) DEFAULT NULL,
  `booking_rating_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_RATING_idx` (`booking_rating_id`),
  CONSTRAINT `FK_RATING` FOREIGN KEY (`booking_rating_id`)
    REFERENCES `booking_rating_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=cp1251;

INSERT INTO `booking_main_model` VALUES
  (3, 'f5e40b37-0e97-4018-a564-9c5902a29141', 'Apart Hotel Orbi Sea Towers', '2018-02-17', 'Апартаменты', 852.30, 979.03, '41.6094920039177,41.637013674796', 1);

SELECT * FROM booking_main_model;