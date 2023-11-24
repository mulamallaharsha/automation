INSERT INTO `app_db`.`customer` (`ap_customer_name`, `ap_phone_number`, `ap_email`, `ap_password`) VALUES ('automation user 1', '9876543210', 'automationuser1@email.com', 'automation@123');
INSERT INTO `app_db`.`customer` (`ap_customer_name`, `ap_phone_number`, `ap_email`, `ap_password`) VALUES ('automation user 2', '9876543211', 'automationuser2@email.com', 'automation@123');



INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 1', '25');
INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 2', '43');
INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 3', '65');
INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 4', '4');
INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 5', '10');
INSERT INTO `app_db`.`product` (`product_name`, `price`) VALUES ('product 2', '43');




INSERT INTO `app_db`.`order` (`order_id`, `customer_id`, `product_id`) VALUES ('1', '2', '3');
INSERT INTO `app_db`.`order` (`order_id`, `customer_id`, `product_id`) VALUES ('1', '2', '4');
INSERT INTO `app_db`.`order` (`order_id`, `customer_id`, `product_id`) VALUES ('2', '1', '3');
INSERT INTO `app_db`.`order` (`order_id`, `customer_id`, `product_id`) VALUES ('3', '1', '5');
