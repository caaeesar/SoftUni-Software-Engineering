CREATE DATABASE `restaurant_db`;

-- Section 1: Data Definition Language (DDL)
# 01. Table Design
CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE,
	`type` VARCHAR(30) NOT NULL,
	`price` DECIMAL(10 , 2 ) NOT NULL
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`birthdate` DATE NOT NULL,
	`card` VARCHAR(50),
	`review` TEXT
);

CREATE TABLE `tables` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`floor` INT NOT NULL,
	`reserved` TINYINT(1),
	`capacity` INT NOT NULL
);

CREATE TABLE `waiters` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50),
	`salary` DECIMAL(10 , 2 )
);

CREATE TABLE `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`table_id` INT NOT NULL,
	`waiter_id` INT NOT NULL,
	`order_time` TIME NOT NULL,
	`payed_status` TINYINT(1),
	CONSTRAINT fk_orders_tables FOREIGN KEY (`table_id`)
		REFERENCES `tables` (`id`),
	CONSTRAINT fk_orders_waiters FOREIGN KEY (`waiter_id`)
		REFERENCES `waiters` (`id`)
);

CREATE TABLE `orders_clients` (
	`order_id` INT,
	`client_id` INT,
	CONSTRAINT fk__orders_clients__orders FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
	CONSTRAINT fk__orders_clients__clients FOREIGN KEY (`client_id`)
	REFERENCES `clients` (`id`)
);

CREATE TABLE `orders_products` (
	`order_id` INT,
	`product_id` INT,
	CONSTRAINT fk__orders_products__orders FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
	CONSTRAINT fk__orders_products__products FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
);

-- Section 2: Data Manipulation Language

# 02. Insert
/*
You will have to insert records of data into the products table, based on the waiters table.
For waiters with id greater than 6, insert data in the products table with the following values:
•	name – set it to the last name of the waiter followed by white space and then "specialty". 
(last_name + " " + "specialty")
•	type – set it to the "Cocktail".
•	price – set it to 1% of the waiter salary and round the DECIMAL always to the next largest number.
(HINT: FLOOR will round the decimal to the previous whole number, but we need the opposite of FLOOR)
*/
INSERT INTO `products` (`name`, `type`, `price`)
	(SELECT 	CONCAT(`last_name`,' specialty'), -- name
			'Cocktail', -- type
			CEILING(`salary` * 0.01) -- price
	FROM `waiters`
	WHERE `id` > 6);

# 03. Update
/*
Somebody made a mistake with the orders and you should correct it. 
Find the orders with id from 12(inclusive) to 23(inclusive) 
and lower their tables id with 1.
*/
UPDATE `orders` 
SET `table_id` = `table_id` - 1
WHERE `id` BETWEEN 12 AND 23;

# 04. Delete
/* Delete all waiters, who don't have any orders. */
SET SQL_SAFE_UPDATES = 0;
DELETE FROM `waiters` 
WHERE `id` NOT IN (SELECT `waiter_id` FROM `orders`);

-- Section 3: Querying
# 05. Clients
/*
Extract from the restaurant_db system database, info about the clients.
Order the results by birthdate in descending order and id in descending;
*/
SELECT * FROM `clients`
ORDER BY `birthdate` DESC , `id` DESC;

# 06. Birthdate
/*
Write a query that returns: first_name, last_name, birthdate and review from clients. 
Filter clients which don’t have card and their birthdate is between 1978 and  1993 inclusive.
Show only the first 5 results and order them descending by last_name, then by id ascending.
*/
SELECT  `first_name`, 
		`last_name`, 
		`birthdate`, 
        `review`
FROM `clients`
WHERE (`card` IS NULL) AND (YEAR(`birthdate`) BETWEEN '1978' AND '1993')
ORDER BY `last_name` DESC , `id` ASC
LIMIT 5;

# 07. Accounts
/*
Write a query that returns: username and password for all waiters which are not fired 
(fired waiter is a waiter without salary). 
The username is generated by their last name immediately followed by 
their first name followed by the number of characters from first name and at the end "Restaurant". 
The password is their email starting from the 2nd character to the 13th character and then reversed.
Order by password in descending order.
*/
SELECT 	CONCAT(`last_name`,
			   `first_name`,
			   CHAR_LENGTH(`first_name`),
			   'Restaurant') AS 'username',
		REVERSE(SUBSTRING(`email`, 2, 12)) AS 'password'
FROM `waiters`
WHERE `salary` IS NOT NULL
ORDER BY `password` DESC;

# 08. Top from menu
/*
Extract from the database the id(product), the name and the count of products 
from all orders with this name where the count is greater or equal to 5.
Order the results descending by count and then by name in ascending.
*/
SELECT  p.`id`, 
		p.`name`, 
		COUNT(op.`product_id`) 'count'
FROM `products` AS p
		JOIN `orders_products` AS op 
        ON p.`id` = op.`product_id`
GROUP BY p.`name`
HAVING `count` >= 5
ORDER BY `count` DESC , `name` ASC;

# 09. Availability
/*
Write a query that returns the table_id, capacity, count_clients  and availability of all tables from the 1st floor. 
Count_clients is the number of people from all orders that are sitting on that table. 
Availability is based on how many people are sitting and the capacity of the table. 
If the capacity is greater than count_clients than it should be "Free seats", 
if the capacity is equal to the count_clients it should be "Full", 
and if the capacity is lower than the count_clients it should be "Extra seats".
Order the results descending by table_id. 
*/
SELECT  t.`id` AS 'table_id',
		t.`capacity`,
		COUNT(oc.`client_id`) AS 'count_clients',
		(CASE
		WHEN `capacity` > COUNT(oc.`client_id`) THEN 'Free seats'
		WHEN `capacity` = COUNT(oc.`client_id`) THEN 'Full'
		WHEN `capacity` < COUNT(oc.`client_id`) THEN 'Extra seats'
		END) AS 'availability'
FROM `tables` AS t
		JOIN `orders` AS o 
        ON t.`id` = o.`table_id`
		JOIN `orders_clients` AS oc 
        ON o.`id` = oc.`order_id`
WHERE t.`floor` = 1
GROUP BY t.`id`
ORDER BY t.`id` DESC;

-- Section 4: Programmability

# 10. Extract bill
/*
Create a user defined function with the name udf_client_bill(full_name VARCHAR(50)) 
that receives a customer’s full name and returns the total price of products he ordered;
*/
DELIMITER $$
CREATE FUNCTION `udf_client_bill`(`full_name` VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
	DECLARE `bill` DECIMAL(19,2);
	SET `bill` := 	(SELECT SUM(p.`price`) 
					FROM `clients` AS c
						JOIN `orders_clients` AS oc ON c.`id` = oc.`client_id`
						JOIN `orders` AS o ON oc.`order_id` = o.`id`
						JOIN `orders_products` AS op ON o.`id` = op.`order_id`
						JOIN `products` AS p ON op.`product_id` = p.`id`
					WHERE CONCAT_WS(' ', c.`first_name`, c.`last_name`) = `full_name`
					GROUP BY c.`id`);
RETURN `bill`;
END $$

SELECT c.first_name, c.last_name, udf_client_bill('Silvio Blyth') as 'bill' 
FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

# 11. Happy hour
/*
Create a stored procedure udp_happy_hour which accepts the following parameters:
type (VARCHAR(50))
Extracts data about the products from the given type and reduces the prices by 20% of all products 
which have price higher or equal to 10.00 and are from the given type.
*/
DELIMITER $$
CREATE PROCEDURE `udp_happy_hour`(`type` VARCHAR(50))
BEGIN
		UPDATE `products` AS p
		SET `price` = `price` - (`price` * 0.2)
		WHERE (p.`type` = `type`) AND (`price` >= 10.00);
END $$

CALL udp_happy_hour ('Cognac');