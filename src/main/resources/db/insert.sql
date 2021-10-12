SET FOREIGN_KEY_CHECKS=0;

TRUNCATE TABLE product;
TRUNCATE TABLE feed_back;

INSERT INTO product(`id`, `name`, `price`, `details`, `currency`)
VALUES (110, "Luxury chair", 4500, "Ipsum", "SGD"),
(111, "Luxury cabinet", 4000, "Ipsum", "USD"),
(112, "Luxury table", 6000, "Ipsum", "NGN"),
(113, "Luxury sofa", 8500, "Ipsum", "NGN"),
(114, "Luxury bench", 9000, "Ipsum", "GBP");

SET FOREIGN_KEY_CHECKS=1;