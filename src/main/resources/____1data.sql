-- /*Data for the table `category` */
--
insert  into `category`(`id`,`name`) values (1,'KOMPUTER STACJONARNY');
insert  into `category`(`id`,`name`) values (2,'LAPTOP');
insert  into `category`(`id`,`name`) values (3,'DRUKARKA ATRAMENTOWA');
insert  into `category`(`id`,`name`) values (4,'DRUKARKA LASEROWA');
insert  into `category`(`id`,`name`) values (5,'MONITOR');
insert  into `category`(`id`,`name`) values (6,'URZĄDZENIE SIECIOWE');
insert  into `category`(`id`,`name`) values (7,'OPROGRAMOWANIE');
--
--
-- /*Data for the table `employee` */
--
-- -- insert  into `employee`(`id`,`email`,`is_active`,`name`) values (1,'jakis@emial','','Adam SkaĹşnik'),(2,'jakis2@emil','','Jakub JakiĹ›'),(4,'adam.bielecki@onet.pl','','Adam Bielecki');
--
-- /*Data for the table `hibernate_sequence` */
--
-- -- insert  into `hibernate_sequence`(`next_val`) values (5),(5),(5),(5);
--
-- /*Data for the table `history` */
--
-- -- insert  into `history`(`id`,`h_data`,`h_description`,`h_user`,`z_id`) values (1,'2020-05-21 07:15:24','Test','test',1),(2,'2020-05-22 08:03:29','Dodano pracownika : ',NULL,2),(3,'2020-05-23 06:29:56','Dodano pracownika : ',NULL,3),(4,'2020-05-23 06:32:19','Dodano pracownika : ',NULL,4),(5,'2020-05-23 06:34:58','Dodano pracownika : ',NULL,5),(6,'2020-05-23 06:36:37','Dodano pracownika : ',NULL,6),(7,'2020-05-22 08:03:23','Edit','edit',2),(8,'2020-05-24 05:17:08','Dodano pracownika : ',NULL,8),(9,'2020-05-23 07:14:16','Dodano pracownika : ',NULL,9),(10,'2020-05-23 06:34:54','Test','test',5),(11,'2020-05-23 06:36:31','Test','test',6),(12,'2020-05-23 07:00:58','Test','test',7),(13,'2020-05-23 07:08:01','Test','test',8),(14,'2020-05-23 07:14:12','Test','test',9),(15,'2020-05-23 07:14:23','UsuniÄ™to z bazy','usuwanie',9),(16,'2020-05-23 13:01:28','Edit','edit',8),(17,'2020-05-23 13:03:23','Edit','edit',8),(18,'2020-05-23 13:10:42','Edit','edit',8),(19,'2020-05-23 13:14:16','Edit','edit',8),(20,'2020-05-24 05:12:03','Edit','edit',8),(21,'2020-05-24 05:14:53','Edit','edit',8),(22,'2020-05-24 05:17:04','Edit','edit',8),(23,'2020-05-24 05:19:16','Edit','edit',8),(24,'2020-05-24 05:19:21','Dodano pracownika : ',NULL,8),(25,'2020-05-24 05:21:29','Edit','edit',8),(26,'2020-05-24 05:21:34','Dodano pracownika : ',NULL,8),(27,'2020-05-24 05:23:20','Test','test',10),(28,'2020-05-24 05:23:26','Dodano pracownika : ',NULL,10),(29,'2020-05-24 05:56:02','Test','test',11),(30,'2020-05-24 05:56:07','Dodano pracownika : ',NULL,11),(31,'2020-05-24 06:00:16','Test','test',12),(32,'2020-05-24 06:02:02','Dodano pracownika : ',NULL,12),(33,'2020-05-24 08:15:13','Edit','edit',12),(34,'2020-05-24 08:17:04','Dodano pracownika : ',NULL,12),(35,'2020-05-24 08:18:35','Dodano pracownika : ',NULL,12),(36,'2020-05-24 08:25:16','Edit','edit',12),(37,'2020-05-24 08:45:35','Edit','edit',12),(38,'2020-05-24 08:46:40','Test','test',13),(39,'2020-05-24 08:46:55','Dodadno pracownika','manager',13),(40,'2020-05-24 08:51:49','Dodano pracownika','manager',13),(41,'2020-05-24 08:53:27','Dodano pracownika','manager',13),(42,'2020-05-24 08:53:39','Edit','edit',13),(43,'2020-05-24 08:53:47','Dodano pracownika','manager',13),(44,'2020-05-24 08:56:26','Dodano pracownika','manager',13),(45,'2020-05-24 08:56:50','Test','test',14),(46,'2020-05-24 09:07:01','Dodano pracownika','manager',13),(47,'2020-05-24 09:08:57','Edit','edit',13),(48,'2020-05-24 09:38:00','Test','admin',15),(49,'2020-05-24 09:41:46','Test','admin',16),(50,'2020-05-24 09:42:31','Edycja zgĹ‚oszenia nr : 16','admin',16),(51,'2020-05-24 09:45:59','PrzyjÄ™cie zgĹ‚oszenia','admin',17),(52,'2020-05-24 09:46:11','Dodano pracownika','admin',17),(53,'2020-05-24 09:46:41','ZakoĹ„czenie zgĹ‚oszenia','admin',17),(54,'2020-05-24 09:53:23','PrzyjÄ™cie zgĹ‚oszenia','admin',18),(55,'2020-05-24 09:53:40','ZakoĹ„czenie zgĹ‚oszenia','admin',18),(56,'2020-05-24 14:13:04','Dodano pracownika','manager',11);
--
--
/*Data for the table `roles` */

insert  into `roles`(`role_id`,`role`) values (1,'ADMIN');
insert  into `roles`(`role_id`,`role`) values (2,'MANAGER');
insert  into `roles`(`role_id`,`role`) values (3,'USER');

/*Data for the table `users` */

insert  into `users`(`user_id`,`active`,`email`,`phone`,`name`,`password`,`user_name`) values (1,'','admin@jakis.mail','admin','admin','$2a$10$E5IdyCTDQkaZNRYeA205xOrU7dyp77mh3pDNRhhBOuaW1gBDo00mi','admin');
insert  into `users`(`user_id`,`active`,`email`,`phone`,`name`,`password`,`user_name`) values (2,'','manager@jakis.inny','manager','manager','$2a$10$kfSwgdgXhL5NNpM/2UivRO9cq37mTbcQrs4igAhvwoIoKumLg0Lp2','manager');
insert  into `users`(`user_id`,`active`,`email`,`phone`,`name`,`password`,`user_name`) values (3,'','user@jeszcze.inny','user','user','$2a$10$JLrNeTTsJBmKefynnjrypu6mCYfYVWupFheoScyGSZmsauP/5o7Ci','user1');


/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1);
insert  into `user_role`(`user_id`,`role_id`) values (2,2);
insert  into `user_role`(`user_id`,`role_id`) values (3,3);
--
--
--
-- /*Data for the table `zgloszenie` */
--
-- -- insert  into `zgloszenie`(`id`,`archive`,`c_data`,`del`,`description`,`email`,`end_description`,`is_end`,`is_proceed`,`name`,`phone`,`selected_user`,`serial_number`,`type`) values (8,0,'2020-05-23',0,NULL,NULL,NULL,0,1,NULL,NULL,'Jakub JakiĹ›',NULL,NULL),(9,0,'2020-05-23',1,'','',NULL,0,0,'','',NULL,'',''),(10,0,'2020-05-24',0,NULL,NULL,NULL,0,1,NULL,NULL,'Jakub JakiĹ›',NULL,NULL),(11,0,'2020-05-24',0,'','',NULL,0,1,'','','Adam SkaĹşnik','',''),(12,0,'2020-05-24',0,'','',NULL,0,0,'','',NULL,'',NULL),(13,0,'2020-05-24',0,'fdghdfhgdf','dfghdfgh',NULL,0,0,'fghfdghfd','dfghdfgh',NULL,'fdghfdgh',NULL),(14,0,'2020-05-24',0,'fgjhfgjhf','hdfhgfdghdf@ghjgfj',NULL,0,0,'fghfdghdf','fdhdfh',NULL,'gfjhfgjf','KOMPUTER STACJONARNY'),(15,0,'2020-05-24',0,'dsfgdsgsd','dsfgsd@dfghfdghd',NULL,0,0,'fgdsfgdsg','hfdghdfh',NULL,'dfgdsfg','KOMPUTER STACJONARNY'),(16,0,'2020-05-24',0,'zzzxdcvcccccccccc','fgjgf@rtrhrdfhg',NULL,0,0,'fhjgfhfgjh','hfdghgf',NULL,'dgfghjfgjhffgjfg',NULL),(17,1,'2020-05-24',0,'Komputer nie dziaĹ‚a','skazada@poczta.fm','Wymiana zasilacza - sprzÄ™t sprawny, przetestowany',1,0,'Adam SkaĹşnik','46464654',NULL,'sn/1127W','KOMPUTER STACJONARNY'),(18,1,'2020-05-24',0,'PÄ™kniÄ™ta matryca','skazada@poczta.fm','Wymiana matrycy na nowÄ…',1,0,'Adam SkaĹşnik','dfgsd',NULL,'brak','LAPTOP');
--
