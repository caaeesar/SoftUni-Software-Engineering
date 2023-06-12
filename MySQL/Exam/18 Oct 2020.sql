CREATE DATABASE `softuni_stores_system`;

# 01. Table Design

CREATE TABLE `pictures` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`url` VARCHAR(100) NOT NULL,
	`added_on` DATETIME NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE,
	`best_before` DATE,
	`price` DECIMAL(10 , 2 ) NOT NULL,
	`description` TEXT,
	`category_id` INT NOT NULL,
	`picture_id` INT NOT NULL,
	CONSTRAINT fk_products_categories FOREIGN KEY (`category_id`)
		REFERENCES `categories` (`id`),
	CONSTRAINT fk_products_pictures FOREIGN KEY (`picture_id`)
		REFERENCES `pictures` (`id`)
);

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL UNIQUE,
	`town_id` INT NOT NULL,
	CONSTRAINT fk_addresses_towns FOREIGN KEY (`town_id`)
		REFERENCES `towns` (`id`)
);

CREATE TABLE `stores` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL UNIQUE,
	`rating` FLOAT NOT NULL,
	`has_parking` TINYINT(1) DEFAULT FALSE,
	`address_id` INT NOT NULL,
	CONSTRAINT fk_stores_addresses FOREIGN KEY (`address_id`)
		REFERENCES `addresses` (`id`)
);

CREATE TABLE `products_stores` (
	`product_id` INT NOT NULL,
	`store_id` INT NOT NULL,
	CONSTRAINT pk__products_stores PRIMARY KEY (`product_id` , `store_id`),
	CONSTRAINT fk__products_stores__products FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`),
	CONSTRAINT fk__products_stores__stores FOREIGN KEY (`store_id`)
		REFERENCES `stores` (`id`)
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(15) NOT NULL,
	`middle_name` CHAR(1),
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(19 , 2 ) DEFAULT 0,
	`hire_date` DATE NOT NULL,
	`manager_id` INT,
	`store_id` INT NOT NULL,
	CONSTRAINT fk__employees__manager_id__employees__id FOREIGN KEY (`manager_id`)
		REFERENCES `employees` (`id`),
	CONSTRAINT fk_employees_stores FOREIGN KEY (`store_id`)
		REFERENCES `stores` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the products_stores table, based on the products table. 
Find all products that are not offered in any stores (don’t have a relation with stores) and insert data in the 
products_stores. For every product saved -> product_id and 1(one) as a store_id.
*/
INSERT INTO `products_stores`
	(SELECT `id`, 1
	FROM `products`
	WHERE `id` NOT IN (SELECT `product_id` FROM `products_stores`));
    
# 03. Update
/*
Update all employees that hire after 2003(exclusive) year and not work in store Cardguard and Veribet. 
Set their manager to be Carolyn Q Dyett (with id 3) and decrease salary with 500.
*/
SET SQL_SAFE_UPDATES = 0;
UPDATE `employees` AS e
	JOIN `stores` AS s 
	ON e.`store_id` = s.`id`
SET `manager_id` = 3, `salary` = `salary` - 500
WHERE YEAR(`hire_date`) >= 2003 AND 
s.`name` NOT IN ('Cardguard', 'Veribet');

# 04. Delete 0/10
/*
It is time for the stores to start working. 
All good employees already are in their stores. 
But some of the employers are too expensive and we need to cut them, because of finances restrictions.
Be careful not to delete managers they are also employees.
Delete only those employees that have managers and a salary is more than 6000(inclusive)
*/
DELETE FROM `employees`
WHERE `manager_id` IS NOT NULL AND
`id` NOT IN (SELECT `manager_id` FROM (SELECT * FROM `employees`) AS m)
AND `salary` >= 6000;

# 05. Employees
/*
Extract from the SoftUni Stores System database, info about all of the employees. 
Order the results by employees hire date in descending order.
*/
SELECT  `first_name`, 
		`middle_name`,
		`last_name`,
		`salary`,
		`hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;

# 06. Products with old pictures
/*
A photographer wants to take pictures of products that have old pictures.
 You must select all of the products that have a description more than 100 characters long description, 
 and a picture that is made before 2019 (exclusive) and the product price being more than 20. 
 Select a short description column that consists of first 10 characters of the picture's description plus '…'. 
 Order the results by product price in descending order.
*/
SELECT  pr.`name` AS 'product_name',
		pr.`price`,
		pr.`best_before`,
		CONCAT(LEFT(pr.`description`, 10), '...') AS 'short_description',
		p.`url`
FROM `products` AS pr
	JOIN `pictures` AS p 
	ON pr.`picture_id` = p.`id`
WHERE CHAR_LENGTH(pr.`description`) > 100 AND
YEAR(p.`added_on`) < 2019 AND
pr.`price` > 20
ORDER BY pr.`price` DESC;

# 07. Counts of products in stores
/*
Extract from the database all of the stores (with or without products) 
and the count of the products that they have. Also you can show the average price of 
all products (rounded to the second digit after decimal point) that sells in store.
Order the results descending by count of products in store, 
then by average price in descending order and finally by store id.
*/
SELECT  s.`name`,
		COUNT(p.`id`) AS 'product_count',
		ROUND(AVG(p.`price`), 2) AS 'avg'
FROM `stores` AS s
	LEFT JOIN `products_stores` AS ps
	ON s.`id` = ps.`store_id`
	LEFT JOIN `products` AS p
	ON ps.`product_id` = p.`id`
GROUP BY s.`id`
ORDER BY `product_count` DESC, `avg` DESC, s.`id`;

# 08. Specific employee
/*
Extract from the database, the full name of employee, name of store that he works, 
address of store, and salary. The employee's salary must be lower than 4000, 
the address of the store must contain '5' somewhere, 
the length of the store name needs to be more than 8 characters and the employee’s 
last name must end with an 'n'.
*/
SELECT  CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'Full_name',
		s.`name` AS 'Store_name',
		a.`name` AS 'address',
		e.`salary`
FROM `employees` AS e
	JOIN `stores` AS s 
	ON e.`store_id` = s.`id`
	JOIN `addresses` AS a 
	ON s.`address_id` = a.`id`
WHERE (e.`salary` < 4000) AND 
(a.`name` LIKE '%5%') AND 
(CHAR_LENGTH(s.`name`) > 8) AND
(e.`last_name` LIKE '%n');

# 09. Find all information of stores
/*
Select the name of stores (in reverse order). 
After that, the full_address in format: {town name in upper case}-{address name}.
The next info is the count of employees, that work in the store.
Filter only the stores that have a one or more employees.
Order the results by the full_address in ascending order.
*/
SELECT  REVERSE(s.`name`) AS 'reversed_name',
		CONCAT(UPPER(t.`name`), '-', a.`name`) AS 'full_address',
		COUNT(e.`id`) AS 'employees_count'
FROM `employees` AS e
	JOIN `stores` AS s 
	ON e.`store_id` = s.`id`
	JOIN `addresses` AS a
	ON s.`address_id` = a.`id`
	JOIN `towns` AS t
	ON a.`town_id` = t.`id`
GROUP BY s.`id`
HAVING `employees_count` >= 1
ORDER BY `full_address`;

# 10. Find name of top paid employee by store name
/*
Create a user defined function with the name udf_top_paid_employee_by_store(store_name VARCHAR(50))
that receives a store name and returns the full name of top paid employee. 
Full info must be in format:  	{first_name} {middle_name}. 
{last_name} works in store for {years of experience} years
The years of experience is the difference when they were hired and 2020-10-18
*/
DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	DECLARE top_employee_id_in_store INT;
	DECLARE experience INT;
	DECLARE info VARCHAR(50);

	SET top_employee_id_in_store := (SELECT `id` FROM `employees`
										WHERE `salary` = (SELECT MAX(`salary`) 
														  FROM `employees` AS e
																JOIN `stores` AS s 
																ON e.`store_id` = s.`id`
															WHERE s.`name` = store_name));

	SET experience :=  (SELECT TIMESTAMPDIFF(YEAR,`hire_date`,'2020-10-18')
						FROM `employees`
						WHERE `id` = top_employee_id_in_store);

	SET info := (SELECT CONCAT(`first_name`, ' ', `middle_name`, '. ', `last_name`, ' works in store for ', experience, ' years')
				FROM `employees`
				WHERE `id` = top_employee_id_in_store);
	RETURN info;
END $$

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';

# 11. Update product price by address 5/15
/*
CREATE user define procedure udp_update_product_price (address_name VARCHAR (50)), 
that receives as parameter an address name.
Increase the product's price with 100 if the address starts with 0 (zero) otherwise increase 
the price with 200.
*/
DELIMITER $$
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR(50))
BEGIN 
	DECLARE sum INT;
	SET sum := IF(address_name LIKE '0%', 100, 200);
	UPDATE `products`
	SET `price` = `price` + sum;
END $$

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;
 
CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;