CREATE DATABASE `stc`;

# 01. Table Design
CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`full_name` VARCHAR(50) NOT NULL,
	`phone_number` VARCHAR(20) NOT NULL
);

CREATE TABLE `drivers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`age` INT NOT NULL,
	`rating` FLOAT NULL DEFAULT 5.5
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`make` VARCHAR(20) NOT NULL,
	`model` VARCHAR(20),
	`year` INT NOT NULL DEFAULT 0,
	`mileage` INT NULL DEFAULT 0,
	`condition` CHAR(1) NOT NULL,
	`category_id` INT NOT NULL,
	CONSTRAINT fk_cars_categories FOREIGN KEY (`category_id`)
		REFERENCES `categories` (`id`)
);

CREATE TABLE `courses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`from_address_id` INT NOT NULL,
	`start` DATETIME NOT NULL,
	`bill` DECIMAL(10 , 2 ) DEFAULT 10,
	`car_id` INT NOT NULL,
	`client_id` INT NOT NULL,
	CONSTRAINT fk_courses_addresses FOREIGN KEY (`from_address_id`)
		REFERENCES `addresses` (`id`),
	CONSTRAINT fk_courses_cars FOREIGN KEY (`car_id`)
		REFERENCES `cars` (`id`),
	CONSTRAINT fk_courses_clients FOREIGN KEY (`client_id`)
		REFERENCES `clients` (`id`)
);

CREATE TABLE `cars_drivers` (
	`car_id` INT NOT NULL,
	`driver_id` INT NOT NULL,
	CONSTRAINT pk__cars_drivers PRIMARY KEY (`car_id` , `driver_id`),
	CONSTRAINT fk__cars_drivers__cars FOREIGN KEY (`car_id`)
		REFERENCES `cars` (`id`),
	CONSTRAINT fk__cars_drivers__drivers FOREIGN KEY (`driver_id`)
		REFERENCES `drivers` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the clients table, based on the drivers table. 
For all drivers with an id between 10 and 20 (both inclusive), 
insert data in the clients table with the following values:
full_name – get first and last name of the driver separated by single space
phone_number – set it to start with (088) 9999 and the driver_id multiplied by 2
Example – the phone_number of the driver with id = 10 is (088) 999920
*/
INSERT INTO `clients` (`full_name`, `phone_number`)
	(SELECT CONCAT(`first_name`, ' ', `last_name`),
			CONCAT('(088) 9999', `id` * 2)
	FROM `drivers`
	WHERE `id` BETWEEN 10 AND 20);
    
# 03. Update
/*
Update all cars and set the condition to be 'C'. 
The cars  must have a mileage greater than 800000 (inclusive) 
or NULL and must be older than 2010(inclusive).
Skip the cars that contain a make value of Mercedes-Benz. 
They can work for many more years.
*/
UPDATE `cars`
SET `condition` = 'C'
WHERE (`mileage` >= 800000) OR (`mileage` IS NULl) 
AND (`year` <= 2010) 
AND `make` <> 'Mercedes-Benz';

# 04. Delete
/*
Delete all clients from clients table, that do not have any courses 
and the count of the characters in the full_name is more than 3 characters. 
*/
DELETE FROM `clients`
WHERE `id` NOT IN (SELECT `client_id` FROM `courses`) AND
CHAR_LENGTH(`full_name`) > 3;

# 05. Cars
/*
Extract the info about all the cars. 
Order the results by car’s id.
*/
SELECT `make`, `model`, `condition` 
FROM `cars`
ORDER BY `id`;

# 06. Drivers and Cars
/*
Select all drivers and cars that they drive. 
Extract the driver’s first and last name from the drivers table and the make, 
the model and the mileage from the cars table. 
Order the result by the mileage in descending order, then by the first name alphabetically. 
Skip all cars that have NULL as a value for the mileage.
*/
SELECT  d.`first_name`, 
		d.`last_name`,
		c.`make`,
		c.`model`,
		c.`mileage`
FROM `drivers` AS d
	JOIN `cars_drivers` AS cd
	ON d.`id` = cd.`driver_id`
	JOIN `cars` AS c 
	ON cd.`car_id` = c.`id`
WHERE c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name` ASC;

# 07. Number of courses
/*
Extract from the database all the cars and the count of their courses. 
Also display the average bill of each course by the car, rounded to the second digit.
Order the results descending by the count of courses, then by the car’s id. 
Skip the cars with exactly 2 courses.
*/
SELECT  c.`id` AS 'car_id',
		c.`make`,
		c.`mileage`,
		COUNT(co.`id`) AS 'count_of_courses',
		ROUND(AVG(co.`bill`), 2) AS 'avg_bill'
FROM `cars` AS c
	LEFT JOIN `courses` AS co
	ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` <> 2
ORDER BY `count_of_courses` DESC, c.`id`;

# 08. Regular clients
/*
Extract the regular clients, who have ridden in more than one car. 
The second letter of the customer's full name must be 'a'. 
Select the full name, the count of cars that he ridden and total sum of all courses.
Order clients by their full_name.
*/
SELECT  cl.`full_name`,
		COUNT(ca.`id`) AS 'count_of_cars',
		SUM(co.`bill`) AS 'total_sum'
FROM `clients` AS cl
	JOIN `courses` AS co
	ON cl.`id` = co.`client_id`
	JOIN `cars` AS ca
	ON co.`car_id` = ca.`id`
WHERE cl.`full_name` LIKE '_a%'
GROUP BY cl.`id`
HAVING `count_of_cars` > 1
ORDER BY cl.`full_name`;

# 09. Full info for courses
/*
The headquarters want us to make a query that shows the complete information about all courses 
in the database. The information that they need is the address, if the course is made in the Day 
(between 6 and 20(inclusive both)) or in the Night (between 21 and 5(inclusive both)), 
the bill of the course, the full name of the client, the car maker, 
the model and the name of the category.
Order the results by course id.
*/
SELECT  a.`name`,
		(CASE
		WHEN HOUR(co.`start`) BETWEEN '6' AND '20' THEN 'Day'
		ELSE 'Night'
		END) AS 'day_time',
		co.`bill`,
		cl.`full_name`,
		ca.`make`,
		ca.`model`,
		ct.`name`
FROM `addresses` AS a
	JOIN `courses` AS co 
	ON a.`id` = co.`from_address_id`
	JOIN `cars` AS ca
	ON co.`car_id` = ca.`id`
	JOIN `categories` AS ct
	ON ca.`category_id` = ct.`id`
	JOIN `clients` AS cl
	ON co.`client_id` = cl.`id`
ORDER BY co.`id`;

# 10. Find all courses by client’s phone number
/*
Create a user defined function with the name udf_courses_by_client (phone_num VARCHAR (20)) 
that receives a client’s phone number and returns the number of courses that clients have in database.
*/
DELIMITER $$
CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE count INT;
	SET count := (SELECT COUNT(co.`id`)
				  FROM `clients` AS cl
					JOIN `courses` AS co 
					ON cl.`id` = co.`client_id`
				  WHERE cl.`phone_number` = phone_num
			      GROUP BY cl.`id`);
	RETURN count;
END $$

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

# 11. Full info for address
/*
Create a stored procedure udp_courses_by_address which accepts the following parameters:
address_name (with max length 100)
Extract data about the addresses with the given address_name. The needed data is the name of the address, full name of the client, level of bill (depends of course bill – Low – lower than 20(inclusive), Medium – lower than 30(inclusive), and High), make and condition of the car and the name of the category.
 Order addresses by make, then by client’s full name.
*/
DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
	SELECT  a.`name`,
			cl.`full_name`,
			(CASE 
			WHEN co.`bill` <= 20 THEN 'Low'
			WHEN co.`bill` <= 30 THEN 'Medium'
			ELSE 'High'
			END) AS 'level_of_bill',
			ca.`make`,
			ca.`condition`,
			ct.`name`
	FROM `addresses` AS a
		JOIN `courses` AS co 
		ON a.`id` = co.`from_address_id`
		JOIN `cars` AS ca
		ON co.`car_id` = ca.`id`
		JOIN `categories` AS ct
		ON ca.`category_id` = ct.`id`
		JOIN `clients` AS cl
		ON co.`client_id` = cl.`id`
WHERE a.`name` = address_name
ORDER BY ca.`make`, cl.`full_name`;
END $$

CALL udp_courses_by_address('700 Monterey Avenue');