-- LAB:

CREATE DATABASE IF NOT EXISTS `hotel`; 
USE `hotel`;

CREATE TABLE departments (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

INSERT INTO departments(name) VALUES('Front Office'), ('Support'), ('Kitchen'), ('Other');

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    department_id INT NOT NULL,
    salary DOUBLE NOT NULL,
    CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`)
        REFERENCES `departments` (`id`)
);

INSERT INTO `employees` (`first_name`,`last_name`, `job_title`,`department_id`,`salary`) VALUES
	('John', 'Smith', 'Manager',1, 900.00),
	('John', 'Johnson', 'Customer Service',2, 880.00),
	('Smith', 'Johnson', 'Porter', 4, 1100.00),
	('Peter', 'Petrov', 'Front Desk Clerk', 1, 1100.00),
	('Peter', 'Ivanov', 'Sales', 2, 1500.23),
	('Ivan' ,'Petrov', 'Waiter', 3, 990.00),
	('Jack', 'Jackson', 'Executive Chef', 3, 1800.00),
	('Pedro', 'Petrov', 'Front Desk Supervisor', 1, 2100.00),
	('Nikolay', 'Ivanov', 'Housekeeping', 4, 1600.00);

CREATE TABLE rooms (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type VARCHAR(30)
);
	
INSERT INTO rooms(`type`) VALUES('apartment'), ('single room');

CREATE TABLE clients (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	room_id INT NOT NULL,
	CONSTRAINT fk_clients_rooms
	FOREIGN KEY (room_id)
	REFERENCES rooms(id)
);

INSERT INTO clients(`first_name`,`last_name`,`room_id`) 
VALUES('Pesho','Petrov', 1),('Gosho','Georgiev', 2),
('Mariya','Marieva', 2), ('Katya','Katerinova', 1), ('Nikolay','Nikolaev', 2);

# 01. Select Employee Information:
SELECT `id`, `first_name`, `last_name`, `job_title`
FROM `employees`
ORDER BY `id` ASC;

# 02. Select Employees with Filter:
SELECT 
`id`, 
CONCAT(`first_name`,' ',`last_name`) AS 'full_name',
`job_title`,
`salary`
FROM `employees`
WHERE `salary` > 1000.00
ORDER BY `id`;

# 03. Update Salary and Select:
UPDATE `employees`
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

SELECT `salary` FROM `employees`;

# 04. Top Paid Employee:
CREATE VIEW `top_paid_employee` AS
SELECT * FROM `employees`
ORDER BY `salary` DESC
LIMIT 1;

SELECT * FROM `top_paid_employee`;

# 05. Select Employees by Multiple Filters:
SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id` ASC; 

# 06. Delete from Table:
SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id` ASC;

-- EXERCISE:
-- Part I – Queries for SoftUni Database:
# 01. Find All Information About Departments:
SELECT * FROM `departments`
ORDER BY `department_id` ASC;

# 02. Find all Department Names:
SELECT `name` FROM `departments`
ORDER BY `department_id`;

# 03. Find Salary of Each Employee:
SELECT `first_name`, `last_name`, `salary` 
FROM `employees`
ORDER BY `employee_id`;

# 04. Find Full Name of Each Employee:
SELECT `first_name`,`middle_name`, `last_name`
FROM `employees`
ORDER BY `employee_id`;

# 05. Find Email Address of Each Employee:
SELECT CONCAT(`first_name`,'.',`last_name`,'@softuni.bg') 
AS `full_email_address` 
FROM `employees`;

# 06. Find All Different Employee’s Salaries:
SELECT CONCAT(`first_name`,'.',`last_name`,'@softuni.bg') 
AS `full_email_address` 
FROM `employees`;

# 07. Find all Information About Employees:
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

# 08. Find Names of All Employees by Salary in Range:
SELECT `first_name`, `last_name`, `job_title`
FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

# 09. Find Names of All Employees:
SELECT CONCAT_WS(' ',`first_name`,`middle_name`,`last_name`) AS `Full Name` 
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

# 10. Find All Employees Without Manager:
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `manager_id` IS NULL;

# 11. Find All Employees with Salary More Than:
SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

# 12. Find 5 Best Paid Employees:
SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC 
LIMIT 5;

# 13. Find All Employees Except Marketing:
SELECT `first_name`, `last_name`
FROM `employees`
WHERE NOT `department_id` = 4;

# 14. Sort Employees Table:
SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name` ASC, `last_name` DESC, `middle_name` ASC;

# 15. Create View Employees with Salaries:
CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary`
FROM `employees`;

SELECT * FROM `v_employees_salaries`;

# 16. Create View Employees with Job Titles:
CREATE VIEW `v_employees_job_titles` AS
	SELECT 
		CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) AS `full_name`,
		`job_title`
	FROM
		`employees`;

SELECT * FROM `v_employees_job_titles`;

# 17. Distinct Job Titles:
SELECT DISTINCT `job_title` FROM `employees`
ORDER BY `job_title` ASC;

# 18. Find First 10 Started Projects:
SELECT * FROM `projects`
ORDER BY `start_date` ASC , `name` ASC, `project_id` ASC
LIMIT 10;

# 19. Last 7 Hired Employees:
SELECT  `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

# 20. Increase Salaries:
UPDATE `employees` 
SET  `salary` = `salary` * 1.12
WHERE `department_id` IN (1 , 2, 4, 11);

SELECT `salary` FROM `employees`;

-- Part II – Queries for Geography Database:
# 21. All Mountain Peaks:
SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name` ASC;

# 22. Biggest Countries by Population:
SELECT `country_name`, `population` FROM `countries`
WHERE `continent_code` = "EU"
ORDER BY `population` DESC, `country_name` ASC 
LIMIT 30;

# 23. Countries and Currency (Euro / Not Euro):
SELECT `country_name`, `country_code`,
IF (`currency_code` = 'EUR', 'Euro', 'Not Euro') AS `currency` 
-- ако първото условие е вярно връщаме втората стойност, в противен случай третата
FROM `countries`
ORDER BY `country_name` ASC;

-- Part III – Queries for Diablo Database:
# 24. All Diablo Characters:
SELECT `name` FROM `characters`
ORDER BY `name`;