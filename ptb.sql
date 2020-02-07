/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.17 : Database - personal_technology_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`personal_technology_blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `personal_technology_blog`;

/*Table structure for table `ptb_role` */

DROP TABLE IF EXISTS `ptb_role`;

CREATE TABLE `ptb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0->启用，1->禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ptb_role` */

insert  into `ptb_role`(`id`,`name`,`description`,`status`) values (1,'ROLE_ADMIN','管理员',1);

/*Table structure for table `ptb_user` */

DROP TABLE IF EXISTS `ptb_user`;

CREATE TABLE `ptb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL COMMENT 'username',
  `password` varchar(100) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `ptb_user` */

insert  into `ptb_user`(`id`,`username`,`password`,`address`,`phone_number`) values (1,'admin','$2a$10$PAHEe4XeCW2N/xBvzSyv5uiNMEkloMgBI53vIKivkdT37iFJR0Tla',NULL,NULL),(2,'admin1','admin1',NULL,NULL),(3,'admin2','admin2',NULL,NULL),(4,'admin3','admin3',NULL,NULL),(5,'admin4','admin4',NULL,NULL),(6,'admin5','admin5',NULL,NULL),(7,'admin6','admin6',NULL,NULL),(8,'admin7','admin7',NULL,NULL),(9,'admin8','admin5',NULL,NULL);

/*Table structure for table `ptb_user_permission` */

DROP TABLE IF EXISTS `ptb_user_permission`;

CREATE TABLE `ptb_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `path` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `component` varchar(300) DEFAULT NULL,
  `hidden` int(11) DEFAULT NULL COMMENT '0 否  1 是',
  `redirect` varchar(100) DEFAULT NULL,
  `name_en` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';

/*Data for the table `ptb_user_permission` */

insert  into `ptb_user_permission`(`id`,`pid`,`name`,`value`,`icon`,`type`,`path`,`status`,`create_time`,`sort`,`component`,`hidden`,`redirect`,`name_en`) values (1,0,'主页','aaa','el-icon-location',0,'/home',1,'2019-12-13 09:44:51',1,'layout',0,'/home','home'),(2,0,'学生','aaa','el-icon-location',0,'/student',1,'2019-12-13 09:47:17',2,'layout',0,'/student/studentManage','student'),(3,0,'用户','aaa','el-icon-location',0,'/user',1,'2019-12-13 09:48:49',3,'layout',0,'/user/userManage','user'),(4,2,'学生管理','aaa','el-icon-location',1,'/studentManage',1,'2019-12-13 10:36:03',4,'student/studentManage',0,NULL,'Student Manage'),(5,3,'用户管理','aaa','el-icon-location',1,'/userManage',1,'2019-12-13 10:49:39',5,'user/userManage',0,NULL,'User Manage');

/*Table structure for table `ptb_user_role_permission_relation` */

DROP TABLE IF EXISTS `ptb_user_role_permission_relation`;

CREATE TABLE `ptb_user_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色和权限关系表';

/*Data for the table `ptb_user_role_permission_relation` */

insert  into `ptb_user_role_permission_relation`(`id`,`role_id`,`permission_id`) values (2,1,2),(3,1,3),(4,1,4),(5,1,5);

/*Table structure for table `ptb_user_role_relation` */

DROP TABLE IF EXISTS `ptb_user_role_relation`;

CREATE TABLE `ptb_user_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ptb_user_role_relation` */

insert  into `ptb_user_role_relation`(`id`,`user_id`,`role_id`) values (1,1,1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(64) NOT NULL,
  `stu_password` varchar(64) NOT NULL,
  `sex` int(1) DEFAULT NULL COMMENT '0-男生，1-女生',
  `email` varchar(100) DEFAULT NULL,
  `stu_address` varchar(250) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '帐号启用状态：0->禁用；1->启用',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/* Procedure structure for procedure `proc_initData` */

/*!50003 DROP PROCEDURE IF EXISTS  `proc_initData` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_initData`()
BEGIN
    DECLARE i INT DEFAULT 1;
    START TRANSACTION;
    WHILE i<=10000 DO
	INSERT INTO ptb_student(stu_name,stu_password,sex,email,stu_address,STATUS,last_login_time) VALUES(concat("student_",i),"123456",0,concat(CONCAT("student",i),"@qq.com"),"南京江宁",1,now());
        SET i = i+1;
    END WHILE;
    COMMIT;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
