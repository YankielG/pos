/*
SQLyog Community v12.03 (64 bit)
MySQL - 10.1.32-MariaDB : Database - pos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;

USE `pos`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'KOMPUTER STACJONARNY'),(2,'LAPTOP'),(3,'DRUKARKA ATRAMENTOWA'),(4,'DRUKARKA LASEROWA'),(5,'MONITOR'),(6,'URZĄDZENIE SIECIOWE'),(7,'OPROGRAMOWANIE');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `employee` */

insert  into `employee`(`id`,`email`,`is_active`,`name`) values (1,'k.kowal@onet.pl','','Krzysztof Kowalski'),(2,'grzegorz.kowalewski@gmial.com','','Grzegorz Kowaleski'),(3,'jakisp@onet.pl','','Patryk Jakiś'),(4,'adam.mikuszewski@pos.pl','','Adam Mikuszewski'),(5,'klaudyna88@wp.pl','','Klaudia Pomocna'),(6,'serwis@pos.pl','','Grzegorz Serwisant');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (7),(7),(7),(7);

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `h_data` datetime DEFAULT NULL,
  `h_description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `h_user` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `z_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `history` */

insert  into `history`(`id`,`h_data`,`h_description`,`h_user`,`z_id`) values (1,'2020-05-29 15:42:12','Przyjęcie zgłoszenia','admin',1),(2,'2020-05-29 15:43:01','Przyjęcie zgłoszenia','admin',2),(3,'2020-05-29 15:46:12','Dodano pracownika','admin',2),(4,'2020-05-30 07:23:14','Przyjęcie zgłoszenia','admin',3),(5,'2020-05-30 07:23:25','Dodano pracownika','admin',3),(6,'2020-05-30 07:23:49','Zakończenie zgłoszenia','admin',3),(7,'2020-05-30 07:25:18','Przyjęcie zgłoszenia','admin',4);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `roles` */

insert  into `roles`(`role_id`,`role`) values (1,'ADMIN'),(2,'MANAGER'),(3,'USER');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1),(2,2),(3,3);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `users` */

insert  into `users`(`user_id`,`active`,`email`,`phone`,`name`,`password`,`user_name`) values (1,'','admin@jakis.mail','admin','admin','$2a$10$E5IdyCTDQkaZNRYeA205xOrU7dyp77mh3pDNRhhBOuaW1gBDo00mi','admin'),(2,'','manager@jakis.inny','manager','manager','$2a$10$kfSwgdgXhL5NNpM/2UivRO9cq37mTbcQrs4igAhvwoIoKumLg0Lp2','manager'),(3,'','user@jeszcze.inny','user','user','$2a$10$JLrNeTTsJBmKefynnjrypu6mCYfYVWupFheoScyGSZmsauP/5o7Ci','user1');

/*Table structure for table `zgloszenie` */

DROP TABLE IF EXISTS `zgloszenie`;

CREATE TABLE `zgloszenie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `archive` tinyint(1) DEFAULT '0',
  `c_data` date NOT NULL,
  `del` tinyint(1) DEFAULT '0',
  `description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `end_description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `is_end` tinyint(1) DEFAULT '0',
  `is_proceed` tinyint(1) DEFAULT '0',
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `selected_user` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `serial_number` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `zgloszenie` */

insert  into `zgloszenie`(`id`,`archive`,`c_data`,`del`,`description`,`email`,`end_description`,`is_end`,`is_proceed`,`name`,`phone`,`selected_user`,`serial_number`,`type`) values (1,0,'2020-05-29',0,'pęknięta matryca, brak obrazu, dane zostały zabezpieczone przez klienta','maj.beata@wp.pl',NULL,0,0,'Beata Maj','543765266',NULL,'7666M3453','LAPTOP'),(2,0,'2020-05-29',0,'Windows 10 po aktualizacji nie działa','mus.krzysztof@gmail.com',NULL,0,1,'Krzysztof Mus','','Klaudia Pomocna','','OPROGRAMOWANIE'),(3,1,'2020-05-30',0,'komputer wolno chodzi','skazada@poczta.fm','reinstalacja oprogramowania',1,0,'Adam Skaźnik','537906485',NULL,'brak','KOMPUTER STACJONARNY'),(4,0,'2020-05-30',0,'drukarka nie drukuje','jakis@emial.tu',NULL,0,0,'Waldemar Wolny','554-554-256',NULL,'brak','DRUKARKA ATRAMENTOWA');

/*Table structure for table `zgloszenie_histories` */

DROP TABLE IF EXISTS `zgloszenie_histories`;

CREATE TABLE `zgloszenie_histories` (
  `zgloszenie_id` bigint(20) NOT NULL,
  `histories_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_4c2cupmrd61yefb6irukw0av4` (`histories_id`),
  KEY `FK4a9kxh83d2167q4juh0n6u32i` (`zgloszenie_id`),
  CONSTRAINT `FK4a9kxh83d2167q4juh0n6u32i` FOREIGN KEY (`zgloszenie_id`) REFERENCES `zgloszenie` (`id`),
  CONSTRAINT `FKixomrkx8vdd94relothp6s7aq` FOREIGN KEY (`histories_id`) REFERENCES `history` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*Data for the table `zgloszenie_histories` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
