 -- MySQL Workbench Forward Engineering

 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

 -- -----------------------------------------------------
 -- Schema task_db
 -- -----------------------------------------------------

 -- -----------------------------------------------------
 -- Schema task_db
 -- -----------------------------------------------------
 CREATE SCHEMA IF NOT EXISTS `task_db` DEFAULT CHARACTER SET utf8 ;
 -- -----------------------------------------------------
 -- Schema task_db
 -- -----------------------------------------------------
 USE `task_db` ;

 -- -----------------------------------------------------
 -- Table `task_db`.`user`
 -- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `task_db`.`user` (
   `user_name` VARCHAR(45) NOT NULL,
   `encoded_password` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`user_name`),
   UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC))
 ENGINE = InnoDB;


 -- -----------------------------------------------------
 -- Table `task_db`.`customer`
 -- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `task_db`.`customer` (
   `id` INT NOT NULL,
   `last_name` VARCHAR(45) NOT NULL,
   `first_name` VARCHAR(45) NOT NULL,
   `user_name` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
   CONSTRAINT `user_customer_fk`
     FOREIGN KEY (`user_name`)
     REFERENCES `task_db`.`user` (`user_name`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION)
 ENGINE = InnoDB;


 SET SQL_MODE=@OLD_SQL_MODE;
 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
