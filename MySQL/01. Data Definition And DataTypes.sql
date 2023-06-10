-- LAB:

CREATE DATABASE `gamebar`;

USE `gamebar`;

# 01. Create Tables:
CREATE TABLE `employees` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `categories` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INT,
    PRIMARY KEY (`id`)
    -- FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

# 02. Insert Data in Tables:
INSERT INTO `employees` (`first_name`, `last_name`)
VALUES  ('Petar','Petrov'),
        ('Melisa','Rudeva'),
        ('Test','Testov');
       
# 03. Alter Table:
ALTER TABLE `employees`
ADD `middle_name` VARCHAR(50) NOT NULL AFTER `first_name`;
       
# 04. Adding Constraints:
ALTER TABLE `products`
ADD FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`);
       
# 05. Modifying Columns:
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100); 
     
     
-- EXERCISE:
# 0. Create Database:
CREATE DATABASE `minions`;
     
# 01. Create Tables:
USE `minions`;

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`age` INT
);

CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

# 02. Alter Minions Table:
ALTER TABLE `towns`
RENAME COLUMN `town_id` TO `id`;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns` 
-- fk_(таблицата, към която е този ключ)_(таблицата към която реферира); 
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);

# 03. Insert Records in Both Tables:
INSERT INTO `towns` (`name`)
VALUES ('Sofia'),
	   ('Plovdiv'),
       ('Varna');

INSERT INTO `minions` (`name`, `age`, `town_id`)
VALUES ('Kevin', 22, 1),
       ('Bob', 15, 3),
       ('Steward', null, 2);

# 04. Truncate Table Minions:
TRUNCATE TABLE `minions`;

# 05. Drop All Tables:
DROP TABLE `minions`;
DROP TABLE `towns`;

# 06. Create Table People:
CREATE TABLE `people` (
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(4,2),
`weight` DOUBLE(4,2),
`gender`CHAR(1) NOT NULL CHECK (`gender`= 'm' OR `gender`= 'F'),
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES ('Melissa', 'f', '2001-01-01'),
	   ('Petar', 'm', '2002-02-02'),
       ('Maria', 'f', '2003-03-03'),
       ('Ivan', 'm', '2004-04-04'),
       ('Aleksandar', 'm', ‘2005-05-05’);

# 07. Create Table Users:
CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (`username`, `password`)
VALUES ('caesar', '1234'),
	   ('test', '1234'),
       ('raw', '1234'),
       ('cae', '1234'),
       ('pesho', '1234');
       
# 08. Change Primary Key:
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY (`id`,`username`); -- композитен ключ
       
# 9. Set Default Value of a Field:
ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();
       
# 10. Set Unique Field:
ALTER TABLE `users`
DROP PRIMARY KEY, -- remove composite key
ADD CONSTRAINT `pk_users` PRIMARY KEY (`id`),
MODIFY COLUMN `username` VARCHAR(30) UNIQUE;
       
# 11. Movies Database:
CREATE DATABASE `Movies`;
USE `Movies`;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` YEAR,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT
);

INSERT INTO `directors` (`director_name`)
VALUES ('Allen'),
	   ('Adams'),
       ('Dan'),
       ('Harry'),
       ('Jack');

INSERT INTO `genres` (`genre_name`)
VALUES ('action'),
       ('adventure'),
       ('animated'),
	   ('comedy'),
       ('drama');
       
INSERT INTO `categories` (`category_name`)
VALUES ('fantasy'),
	   ('horror'),
	   ('mystery'),
       ('romance'),
	   ('thriller');

INSERT INTO `movies` (`title`)
VALUES ('Prison break'),
	   ('Breaking bad'),
	   ('Top Gun'),
	   ('The hustle'),
	   ('Schindlers list');

# 12. Car Rental Database:
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(50) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(50) NOT NULL,
`make` VARCHAR(50),
`model` VARCHAR(50) NOT NULL,
`car_year` YEAR,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(50),
`available` BOOLEAN
-- FOREIGN KEY(`category_id`) REFERENCES `categories`(`id`)
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`title` VARCHAR(50),
`notes` TEXT
);

CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` INT NOT NULL,
`full_name` VARCHAR(50) NOT NULL,
`address` VARCHAR(50),
`city` VARCHAR(50),
`zip_code` INT,
`notes` TEXT
);

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition`VARCHAR(50),
`tank_level` VARCHAR(50),
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` DOUBLE,
`tax_rate` DOUBLE,
`order_status` VARCHAR(50),
`notes` TEXT
-- FOREIGN KEY (`employee_id`) REFERENCES `employees`(`id`),
-- FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
-- FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`)
);

INSERT INTO `categories` (`category`)
VALUES ('Sports'),
	   ('Coupe'),
	   ('Sedan');

INSERT INTO `cars` (`plate_number`, `model`)
VALUES ('CA 7321 BH', 'Audi'),
	   ('NBC 1234','BMW'),
	   ('A 2569 KX', 'Mercedes');

INSERT INTO `customers` (`driver_licence_number`, `full_name`)
VALUES ('12345678', 'Petur Petrov'),
	   ('76543222', 'Georgi Georgiev'),
	   ('98765432', 'Ivan Ivanov');

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES ('Stoqn', 'Stoqnov'),
	   ('Dimitur', 'Dimitrov'),
	   ('Martin', 'Ivanov');

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`)
VALUES (1, 2, 3),
	   (3, 2, 1),
	   (2, 3, 1);

# 13. Basic Insert:
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` TEXT,
`town_id` INT, 
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` TEXT
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50),
`middle_name` VARCHAR(50),
`last_name` VARCHAR(50),
`job_title` VARCHAR(50),
`department_id` INT,
`hire_date` DATE,
`salary` DOUBLE,
`address_id` INT,
FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
);

INSERT INTO `towns` (`name`)
VALUES ('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO `departments` (`name`)
VALUES ('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

# 14. Basic Select All Fields:
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

# 15. Basic Select All Fields and Order Them:
SELECT * FROM `towns` ORDER BY `name` ASC;
SELECT * FROM `departments` ORDER BY `name` ASC;
SELECT * FROM `employees` ORDER BY `salary` DESC;

# 16. Basic Select Some Fields:
SELECT `name` FROM `towns`
ORDER BY `name` ASC;

SELECT `name` FROM `departments`
ORDER BY `name` ASC;

SELECT `first_name`, `last_name`, `job_title`, `salary`
FROM `employees`
ORDER BY `salary` DESC;

# 17. Increase Employees Salary:
SET SQL_SAFE_UPDATES = 0;
UPDATE `employees`
SET `salary` = `salary` * 1.10;
SELECT `salary` FROM `employees`;


