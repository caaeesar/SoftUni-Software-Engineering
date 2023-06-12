CREATE DATABASE `online_store`;

# 01. Table Design
CREATE TABLE `brands` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `reviews` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`content` TEXT,
	`rating` DECIMAL(10 , 2 ) NOT NULL,
	`picture_url` VARCHAR(80) NOT NULL,
	`published_at` DATETIME NOT NULL
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
	`price` DECIMAL(19 , 2 ) NOT NULL,
	`quantity_in_stock` INT,
	`description` TEXT,
	`brand_id` INT NOT NULL,
	`category_id` INT NOT NULL,
	`review_id` INT,
	CONSTRAINT fk_products_brands FOREIGN KEY (`brand_id`)
		REFERENCES `brands` (`id`),
	CONSTRAINT fk_products_categories FOREIGN KEY (`category_id`)
		REFERENCES `categories` (`id`),
	CONSTRAINT fk_products_reviews FOREIGN KEY (`review_id`)
		REFERENCES `reviews` (`id`)
);

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`phone` VARCHAR(30) NOT NULL UNIQUE,
	`address` VARCHAR(60) NOT NULL,
	`discount_card` BIT(1) NOT NULL DEFAULT FALSE
);

CREATE TABLE `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`order_datetime` DATETIME NOT NULL,
	`customer_id` INT NOT NULL,
	CONSTRAINT fk_orders_customers FOREIGN KEY (`customer_id`)
		REFERENCES `customers` (`id`)
);

CREATE TABLE `orders_products` (
	`order_id` INT,
	`product_id` INT,
	CONSTRAINT fk__orders_products__orders FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
	CONSTRAINT fk__orders_products__products FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the reviews table, based on the products table.
For products with id equal or greater than 5, insert data in the reviews table with the following values:
•content – set it to the first 15 characters from the description of the product.
•picture_url – set it to the product's name but reversed.
•published_at – set it to 10-10-2010.
•rating – set it to the price of the product divided by 8.
*/
INSERT INTO `reviews` (`content`, `picture_url`, `published_at`, `rating`)
	(SELECT LEFT(`description`, 15),
			REVERSE(`name`),
			'2010-10-10',
			`price` / 8
	FROM `products`
	WHERE `id` >= 5);
    
# 03. Update
/*
Reduce all products quantity by 5 for products with quantity greater than 60 
and less than 70 (inclusive).
*/
SET SQL_SAFE_UPDATES = 0;
UPDATE `products`
SET `quantity_in_stock` = `quantity_in_stock` - 5
WHERE `quantity_in_stock` BETWEEN 60 AND 70;

# 04. Delete
/* REMOVE all customers, who didn't order anything. */
DELETE FROM `customers`
WHERE `id` NOT IN (SELECT `customer_id` FROM `orders`);

# 05. Categories
/*Extract from the online_store system database, info about the name of categories.
Order the results by category_name in descending order;
Required Column: category_name
*/
SELECT * FROM `categories`
ORDER BY `name` DESC;

# 06. Quantity
/*
Write a query that returns: product_id, brand_id, name, quantity
from table products. Filter products which price is higher than
1000 and their quantity is lower thant 30.
*/
SELECT `id`, `brand_id`, `name`, `quantity_in_stock`
FROM `products`
WHERE `price` > 1000 AND `quantity_in_stock` < 30
ORDER BY `quantity_in_stock` ASC, `id` ASC;

# 07. Review
/*
Write a query that returns: content, picture_url, published_at, rating
for all reviews which content starts with ‘My’ and the characters of the content are more than 61 symbols.
Sort by rating in ascending order.
*/
SELECT * FROM `reviews`
WHERE (`content` LIKE 'My%') AND (CHAR_LENGTH(`content`) > 61)
ORDER BY `rating` DESC;

# 08. First customers
/*
There are many customers in our shop system, but we need to find only those who are clients 
from the beginning of the online store creation.
Extract from the database, the full name of employee, the address, and the date of order. 
The year must be lower or equal to 2018.
*/
SELECT  CONCAT(c.`first_name`, ' ', c.`last_name`) AS 'full_name',
		`address`,
		o.`order_datetime`
FROM `customers` AS c
	JOIN `orders` AS o 
	ON c.`id` = o.`customer_id`
WHERE YEAR(o.`order_datetime`) <= '2018'
ORDER BY `full_name` DESC;

# 09. Best categories
/*
Extract from the database, the top 5 categories.
ORDER the results descending by items count, then by total_quantity in ascending.
Required Columns: 'items_count' (number of items in this category), category_name,
'total_quantity' (sum of all items in this category)
*/
SELECT  COUNT(p.`id`) AS 'items_count',
		c.`name`,
		SUM(p.`quantity_in_stock`) AS 'total_quantity'
FROM `categories` AS c
	JOIN `products` AS p
	ON c.`id` = p.`category_id`
GROUP BY c.`name`
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;

# 10. Extract client cards count
/* Extract total count of items ordered */
DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `total_products` INT;
	SET `total_products` := (SELECT COUNT(p.`id`)
							 FROM `products` AS p
								JOIN `orders_products` AS op 
								ON p.`id` = op.`product_id`
								JOIN `orders` AS o 
								ON op.`order_id` = o.`id`
								JOIN `customers` AS c 
								ON o.`customer_id` = c.`id`
							WHERE c.`first_name` = name
							GROUP BY c.`id`);
	RETURN `total_products`;
END $$

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';

# 11. Reduce price
/*
Reduce the price by 30% of all items which have reviews with rating less than 4 
and are from the given category.
*/
DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
		UPDATE `products` AS p
			JOIN `categories` AS c
			ON p.`category_id` = c.`id`
			JOIN `reviews` AS r
			ON p.`review_id` = r.`id`
		SET `price` = `price` - (`price` * 0.3)
		WHERE (c.`name` = category_name) AND (r.`rating` < 4);
END $$

CALL udp_reduce_price ('Phones and tablets');