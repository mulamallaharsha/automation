CREATE TABLE `app_db`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ap_customer_name` VARCHAR(45) NULL,
  `ap_phone_number` VARCHAR(45) NULL,
  `ap_email` VARCHAR(45) NULL,
  `ap_password` VARCHAR(45) NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  PRIMARY KEY (`id`));

  
  
  
CREATE TABLE `app_db`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`));

  
  CREATE TABLE `app_db`.`order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` INT NULL,
  `customer_id` INT NULL,
  `product_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_customer_id_idx` (`customer_id` ASC),
  INDEX `order_product_id_idx` (`product_id` ASC),
  CONSTRAINT `order_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `app_db`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `app_db`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
