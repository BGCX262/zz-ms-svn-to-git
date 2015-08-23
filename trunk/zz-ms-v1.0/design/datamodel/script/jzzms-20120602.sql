SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
SET NAMES 'utf8';
CREATE  TABLE IF NOT EXISTS `urss_app` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `code` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_company` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `com_name` VARCHAR(45) NULL DEFAULT NULL ,
  `address` VARCHAR(45) NULL DEFAULT NULL ,
  `contact_name` VARCHAR(45) NULL DEFAULT NULL ,
  `fax` VARCHAR(45) NULL DEFAULT NULL ,
  `zip` VARCHAR(45) NULL DEFAULT NULL ,
  `allow_user` VARCHAR(45) NULL DEFAULT NULL ,
  `start_time` DATE NULL DEFAULT NULL ,
  `end_time` DATE NULL DEFAULT NULL ,
  `reg_time` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_employee_org` (
  `org_id` INT(11) NOT NULL ,
  `employee_id` INT(11) NOT NULL ,
  PRIMARY KEY (`org_id`, `employee_id`) ,
  INDEX `urss_employee_org_org` (`org_id` ASC) ,
  INDEX `urss_employee_org_employee` (`employee_id` ASC) ,
  CONSTRAINT `urss_employee_org_org`
    FOREIGN KEY (`org_id` )
    REFERENCES `urss_org_tree` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `urss_employee_org_employee`
    FOREIGN KEY (`employee_id` )
    REFERENCES `urss_employee` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_employee` (
  `id` INT(11) NOT NULL ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `code` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  `mobile` VARCHAR(45) NULL DEFAULT NULL ,
  `telephone` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_function` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `url` VARCHAR(45) NULL ,
  `small_img` VARCHAR(45) NULL ,
  `big_img` VARCHAR(45) NULL ,
  `fun_code` VARCHAR(45) NULL ,
  `order_index` INT NULL ,
  `app_id` INT NULL ,
  `parent_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `urss_function_app` (`app_id` ASC) ,
  CONSTRAINT `urss_function_app`
    FOREIGN KEY (`app_id` )
    REFERENCES `urss_app` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_org_detail` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `org_id` INT(11) NULL DEFAULT NULL ,
  `path` VARCHAR(45) NULL DEFAULT NULL ,
  `value` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `urss_org_detail_org` (`org_id` ASC) ,
  CONSTRAINT `urss_org_detail_org`
    FOREIGN KEY (`org_id` )
    REFERENCES `urss_org_tree` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_org_tree` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `parent_id` INT(11) NULL DEFAULT NULL ,
  `org_type_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `urss_org_tree_type` (`org_type_id` ASC) ,
  CONSTRAINT `urss_org_tree_type`
    FOREIGN KEY (`org_type_id` )
    REFERENCES `urss_org_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_org_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NULL DEFAULT NULL ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `res_id` VARCHAR(45) NULL DEFAULT NULL ,
  `fun_id` VARCHAR(45) NULL DEFAULT NULL ,
  `app_id` VARCHAR(45) NULL DEFAULT NULL ,
  `member_id` INT(11) NULL DEFAULT NULL ,
  `member_type` ENUM('user','role') NULL DEFAULT 'role' ,
  `org_ids` VARCHAR(45) NULL DEFAULT NULL ,
  `org_type` ENUM('current','custom') NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_resource` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `fun_id` INT(11) NULL DEFAULT NULL ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `code` VARCHAR(45) NULL DEFAULT NULL ,
  `is_button` TINYINT(4) NULL DEFAULT NULL ,
  `button_id` VARCHAR(45) NULL DEFAULT NULL ,
  `impl_js` VARCHAR(45) NULL DEFAULT NULL ,
  `impl_url` VARCHAR(45) NULL DEFAULT NULL ,
  `group_name` VARCHAR(45) NULL DEFAULT NULL ,
  `is_org` TINYINT(4) NULL DEFAULT NULL ,
  `is_link_assign` VARCHAR(45) NULL DEFAULT NULL ,
  `link_assign_value` VARCHAR(100) NULL DEFAULT NULL ,
  `button_style` VARCHAR(45) NULL DEFAULT NULL ,
  `order_index` INT(11) NULL DEFAULT NULL ,
  `app_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `urss_resource_function` (`fun_id` ASC) ,
  INDEX `urss_resource_app` (`app_id` ASC) ,
  CONSTRAINT `urss_resource_function`
    FOREIGN KEY (`fun_id` )
    REFERENCES `urss_function` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `urss_resource_app`
    FOREIGN KEY (`app_id` )
    REFERENCES `urss_app` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `app_id` INT(11) NOT NULL ,
  `code` VARCHAR(45) NULL DEFAULT NULL ,
  `name` VARCHAR(45) NULL DEFAULT NULL ,
  `com_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `urss_role_company` (`com_id` ASC) ,
  CONSTRAINT `urss_role_company`
    FOREIGN KEY (`com_id` )
    REFERENCES `urss_company` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_user_role` (
  `user_id` INT(11) NOT NULL ,
  `role_id` INT(11) NOT NULL ,
  PRIMARY KEY (`user_id`, `role_id`) ,
  INDEX `urss_user_role_user` (`user_id` ASC) ,
  INDEX `urss_user_role_role` (`role_id` ASC) ,
  CONSTRAINT `urss_user_role_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `urss_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `urss_user_role_role`
    FOREIGN KEY (`role_id` )
    REFERENCES `urss_role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `urss_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(45) NULL DEFAULT NULL ,
  `password` VARCHAR(32) NOT NULL ,
  `com_id` INT(11) NULL DEFAULT NULL ,
  `employee_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`, `password`) ,
  INDEX `urss_user_company` (`com_id` ASC) ,
  INDEX `urss_user_employee` (`employee_id` ASC) ,
  CONSTRAINT `urss_user_company`
    FOREIGN KEY (`com_id` )
    REFERENCES `urss_company` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `urss_user_employee`
    FOREIGN KEY (`employee_id` )
    REFERENCES `urss_employee` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

DROP TABLE IF EXISTS `bsp_operator` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
