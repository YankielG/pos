-- /*Table structure for table `category` */
--
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
                            `id` bigint(20) NOT NULL,
                            `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
--
-- /*Table structure for table `employee` */
--
-- DROP TABLE IF EXISTS `employee`;
--
-- CREATE TABLE `employee` (
--                             `id` bigint(20) NOT NULL,
--                             `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                             `is_active` bit(1) NOT NULL,
--                             `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                             PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
--
-- /*Table structure for table `hibernate_sequence` */
--
-- -- DROP TABLE IF EXISTS `hibernate_sequence`;
-- --
-- -- CREATE TABLE `hibernate_sequence` (
-- --     `next_val` bigint(20) DEFAULT NULL
-- -- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
-- /*Table structure for table `roles` */
--
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
                         `role_id` int(11) NOT NULL,
                         `role` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
                         PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

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

--
-- /*Table structure for table `zgloszenie` */
--
-- DROP TABLE IF EXISTS `zgloszenie`;
--
-- CREATE TABLE `zgloszenie` (
--                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
--                               `archive` tinyint(1) DEFAULT '0',
--                               `c_data` date NOT NULL,
--                               `del` tinyint(1) DEFAULT '0',
--                               `description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `end_description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `is_end` tinyint(1) DEFAULT '0',
--                               `is_proceed` tinyint(1) DEFAULT '0',
--                               `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `phone` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `selected_user` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `serial_number` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               `type` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                               PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
--
-- /*Table structure for table `history` */
--
-- DROP TABLE IF EXISTS `history`;
--
-- CREATE TABLE `history` (
--                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
--                            `h_data` datetime DEFAULT NULL,
--                            `h_description` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                            `h_user` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
--                            `z_id` bigint(20) DEFAULT NULL,
--                            PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
--
-- /*Table structure for table `zgloszenie_histories` */
--
-- -- DROP TABLE IF EXISTS `zgloszenie_histories`;
-- --
-- -- CREATE TABLE `zgloszenie_histories` (
-- --                                          `zgloszenie_id` bigint(20) NOT NULL,
-- --                                          `histories_id` bigint(20) NOT NULL,
-- --                                          UNIQUE KEY `UK_4c2cupmrd61yefb6irukw0av4` (`histories_id`),
-- --                                          KEY `FK4a9kxh83d2167q4juh0n6u32i` (`zgloszenie_id`),
-- --                                          CONSTRAINT `FK4a9kxh83d2167q4juh0n6u32i` FOREIGN KEY (`zgloszenie_id`) REFERENCES `zgloszenie` (`id`),
-- --                                          CONSTRAINT `FKixomrkx8vdd94relothp6s7aq` FOREIGN KEY (`histories_id`) REFERENCES `history` (`id`)
-- --  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
