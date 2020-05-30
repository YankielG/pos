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
insert  into `employee`(`id`,`email`,`is_active`,`name`) values (1,'pomocna.kasia89@jakis.mail','','Katarzyna Pomocna');
insert  into `employee`(`id`,`email`,`is_active`,`name`) values (2,'kkowal@qmail.com','','Krzysztof Kowalski');
insert  into `employee`(`id`,`email`,`is_active`,`name`) values (3,'wolny@jakis.mail','','Sebastian Wolny');
insert  into `employee`(`id`,`email`,`is_active`,`name`) values (4,'jakrozpetalem@wojne','','Tadeusz BrzÄ™czyszczykiewicz');
insert  into `employee`(`id`,`email`,`is_active`,`name`) values (5,'aacheen@onet.pl','','Joachim Malutki');
insert  into `employee`(`id`,`email`,`is_active`,`name`) values(6,'sylaa@interia.pl','','Sylwia JakaĹ›');


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
