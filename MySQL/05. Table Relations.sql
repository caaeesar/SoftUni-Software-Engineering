-- LAB:

# 01. Mountains and Peaks:
USE `camp`;
# One-to-Many
CREATE TABLE `mountains` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE `peaks` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`mountain_id` INT,
CONSTRAINT `fk_peaks_mountains`
FOREIGN KEY (`mountain_id`) REFERENCES `mountains`(`id`) ON DELETE CASCADE #when deleted parent entry, should be deleted related child rows
);

INSERT INTO `mountains` (`name`)
VALUES ('Rila'),
	   ('Vitosha'),
	   ('Pirin');
       
INSERT INTO `peaks` (`name`, `mountain_id`)
VALUES ('Musala', 1),
	   ('Malka Musala', 1),
	   ('Cherni vruh', 2),
	   ('Vihren', 3);

SET SQL_SAFE_UPDATES = 0;
DELETE FROM `mountains` WHERE `name` = 'Rila';

SELECT m.`name` AS 'mountain', p.`name` AS `peak` FROM `mountains` AS m
JOIN `peaks` AS p ON m.`id` = p.`mountain_id`;

# 02. Trip Organization:
SELECT  `driver_id`,
		`vehicle_type`,
		CONCAT(`first_name`, ' ', `last_name`)
FROM `vehicles` AS v
JOIN `campers` AS c 
ON v.`driver_id` = c.`id`;

# 03. SoftUni Hiking:
SELECT  `starting_point` AS 'route_starting_point',
		`end_point` AS 'route_ending_point',
		`leader_id`,
		CONCAT(`first_name`, ' ', `last_name`)
FROM `routes` AS r
JOIN `campers` AS c 
ON r.`leader_id` = c.`id`;

# 05. Project Management DB* :
USE `project_management`;

CREATE TABLE `clients` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`client_name` VARCHAR(100)
);

CREATE TABLE `projects` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`client_id` INT,
`project_lead_id` INT,
CONSTRAINT `fk_projects_clients`
FOREIGN KEY (`client_id`) REFERENCES `clients`(`id`)
);

CREATE TABLE `employees` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT,
CONSTRAINT `fk_employees_projects`
FOREIGN KEY (`project_id`) REFERENCES `projects`(`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT `fk_projects_employees`
FOREIGN KEY (`project_lead_id`) REFERENCES `employees`(`id`);


-- EXERCISE:

# 01. One-To-One Relationship:
CREATE TABLE `passports` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`passport_number` VARCHAR(50) UNIQUE
) AUTO_INCREMENT=101; # set the initial value

INSERT INTO `passports` (`passport_number`)
VALUES ('N34FG21B'),
	   ('K65LO4R7'),
	   ('ZE657QP2');

CREATE TABLE `people` (
	`person_id` INT AUTO_INCREMENT PRIMARY KEY,
	`first_name` VARCHAR(50),
	`salary` DECIMAL(7 , 2 ),
	`passport_id` INT UNIQUE,
	CONSTRAINT `fk_people_passports` FOREIGN KEY (`passport_id`)
		REFERENCES `passports` (`id`)
);

INSERT INTO `people` (`first_name`, `salary`, `passport_id`)
VALUES ('Roberto',  43300.00, 102),
       ('Tom',  56100.00, 103),
       ('Yana',  60200.00, 101);

-- get name and passport number
SELECT `first_name`, `passport_number` 
FROM `people` 
JOIN `passports` ON `people`.`passport_id` = `passports`.`id`;

# 02. One-To-Many Relationship:
CREATE TABLE `manufacturers` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`established_on` DATE
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES ('BMW', '1916-03-01'),
	   ('Tesla', '2003-01-01'),
	   ('Lada', '1966-05-01');

CREATE TABLE `models` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`manufacturer_id` INT NOT NULL,
CONSTRAINT `fk_models_manufacturers`
FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers`(`id`)
) AUTO_INCREMENT=101;

INSERT INTO `models` (`name`, `manufacturer_id`)
VALUES ('X1', 1),
	   ('i6', 1),
	   ('Model S', 2),
	   ('Model X', 2),
	   ('Model 3', 2),
	   ('Nova', 3);

# 03. Many-To-Many Relationship:
CREATE TABLE `students` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50)
);

INSERT INTO `students` (`name`)
VALUES ('Mila'), ('Toni'), ('Ron');

CREATE TABLE `exams` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50)
)AUTO_INCREMENT=101;

INSERT INTO `exams` (`name`)
VALUES ('Spring MVC'), ('Neo4j'), ('Oracle 11g');

CREATE TABLE `students_exams` (
	`student_id` INT,
	`exam_id` INT,
	CONSTRAINT `pk_students_exams` PRIMARY KEY (`student_id` , `exam_id`), # composite PK -> unique pairs of combinations
	CONSTRAINT `fk__students_exams__students` FOREIGN KEY (`student_id`)
		REFERENCES `students` (`id`),
	CONSTRAINT `fk__students_exams__exams` FOREIGN KEY (`exam_id`)
		REFERENCES `exams` (`id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES (1, 101),
	   (1, 102),
	   (2, 101),
	   (3, 103),
	   (2, 102),
       (2, 103);

# 04. Self-Referencing:
CREATE TABLE `teachers` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`manager_id` INT
) AUTO_INCREMENT=101;

INSERT INTO `teachers` (`name`, `manager_id`) 
VALUES ('John', NULL),
	   ('Maya', 106),
       ('Silvia', 106),
       ('Ted', 105),
       ('Mark', 101),
       ('Greta', 101); 

ALTER TABLE `teachers`
ADD CONSTRAINT `fk__manager_id__id`
FOREIGN KEY (`manager_id`) REFERENCES `teachers`(`id`);

# 05. Online Store Database:
CREATE DATABASE `online_store`;

# cities - customers: One to many relationship type
# customers - orders: One to many relationship type
# orders - items: Many to many relationship type
# item_types - items: One to many relationship type

CREATE TABLE `cities` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50)
);

CREATE TABLE `customers` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50),
	`birthday` DATE,
	`city_id` INT,
	CONSTRAINT `fk_customers_cities` FOREIGN KEY (`city_id`)
		REFERENCES `cities` (`id`)
);

CREATE TABLE `orders` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`customer_id` INT,
	CONSTRAINT `fk_orders_customers` FOREIGN KEY (`customer_id`)
		REFERENCES `customers` (`id`)
);

CREATE TABLE `item_types` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50)
);

CREATE TABLE `items` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50),
	`item_type_id` INT,
	CONSTRAINT `fk__items__item_types` FOREIGN KEY (`item_type_id`)
		REFERENCES `item_types` (`id`)
);

CREATE TABLE `orders_items` (
	`order_id` INT,
	`item_id` INT,
	CONSTRAINT `pk_orders_items` PRIMARY KEY (`order_id` , `item_id`),
	CONSTRAINT `fk__order_id__orders` FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
	CONSTRAINT `fk__item_id__items` FOREIGN KEY (`item_id`)
		REFERENCES `items` (`id`)
);

# 06. University Database:

# majors - students: One to many 
# students - payments: One to many 
# students - subjects: Many to many -> agenda - mapping table

CREATE DATABASE `university`;

CREATE TABLE `majors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50)
);

CREATE TABLE `students` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`number` VARCHAR(12),
	`name` VARCHAR(50),
	`major_id` INT,
	CONSTRAINT `fk_students_majors` FOREIGN KEY (`major_id`)
		REFERENCES `majors` (`id`)
);

CREATE TABLE `payments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`date` DATE,
	`amount` DECIMAL(8 , 2 ),
	`student_id` INT,
	CONSTRAINT `fk_payments_students` FOREIGN KEY (`student_id`)
		REFERENCES `students` (`id`)
);

CREATE TABLE `subjects` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50)
);

CREATE TABLE `agenda` (
    `student_id` INT,
    `subject_id` INT,
    CONSTRAINT `pk_students_subjects` PRIMARY KEY (`student_id` , `subject_id`),
    CONSTRAINT `fk_agenda_students` FOREIGN KEY (`student_id`)
        REFERENCES `students` (`id`),
    CONSTRAINT `fk_agenda_subjects` FOREIGN KEY (`subject_id`)
        REFERENCES `subjects` (`id`)
);

# 09. Peaks in Rila:
/*
Display all peaks for "Rila" mountain_range. 
Include: mountain_range, peak_name, peak_elevation
Peaks should be sorted by peak_elevation descending. 
*/
SELECT  `mountain_range`,
		`peak_name`,
		`elevation` AS 'peak_elevation'
FROM `mountains` AS m
JOIN `peaks` AS p ON m.`id` = p.`mountain_id`
WHERE `mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;