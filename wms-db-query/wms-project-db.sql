DROP DATABASE IF EXISTS `wms_project`;
CREATE DATABASE `wms_project`;
USE `wms_project`;

-- create user table
CREATE TABLE `user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `no` VARCHAR(20) DEFAULT NULL COMMENT 'user account',
    `name` VARCHAR(100) DEFAULT NULL COMMENT 'user name',
    `password` VARCHAR(20) NOT NULL COMMENT 'user password',
    `age` INT(11) DEFAULT NULL,
    `sex` INT(11) DEFAULT NULL COMMENT 'user sexual 0=female, 1=male',
    `phone` VARCHAR(20) DEFAULT NULL COMMENT 'user phone number',
    `role_id` INT(11) DEFAULT NULL COMMENT '0=Superadmin 1=admin 2=normal',
    `isValid` VARCHAR(4) DEFAULT NULL COMMENT 'Y=valid <others>=notValid',
    PRIMARY KEY (`id`)
) CHARSET=utf8mb4;

-- insert superadmin (hardcode)
INSERT INTO `wms_project`.`user` (`id`, `no`, `name`, `password`, `age`, `sex`, `phone`, `role_id`, `isValid`) VALUES (1, 'sa', 'Superadmin', '123', 123, 1, '123', 0, 'Y');

