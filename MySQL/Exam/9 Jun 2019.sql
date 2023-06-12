CREATE DATABASE `ruk_database`;

# 01. Table Design
CREATE TABLE `branches` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(10 , 2 ) NOT NULL,
	`started_on` DATE NOT NULL,
	`branch_id` INT NOT NULL,
	CONSTRAINT fk_employees_branches FOREIGN KEY (`branch_id`)
		REFERENCES `branches` (`id`)
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`full_name` VARCHAR(50) NOT NULL,
	`age` INT NOT NULL
);

CREATE TABLE `employees_clients` (
	`employee_id` INT,
	`client_id` INT,
	CONSTRAINT fk__employees_clients__employees FOREIGN KEY (`employee_id`)
		REFERENCES `employees` (`id`),
	CONSTRAINT fk__employees_clients__clients FOREIGN KEY (`client_id`)
		REFERENCES `clients` (`id`)
);

CREATE TABLE `bank_accounts` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`account_number` VARCHAR(10) NOT NULL,
	`balance` DECIMAL(10 , 2 ) NOT NULL,
	`client_id` INT NOT NULL UNIQUE,
	CONSTRAINT fk__bank_accounts__clients FOREIGN KEY (`client_id`)
		REFERENCES `clients` (`id`)
);

CREATE TABLE `cards` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`card_number` VARCHAR(19) NOT NULL,
	`card_status` VARCHAR(7) NOT NULL,
	`bank_account_id` INT NOT NULL,
	CONSTRAINT fk__cards__bank_accounts FOREIGN KEY (`bank_account_id`)
		REFERENCES `bank_accounts` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the cards table, based on the clients table. 
For clients with id between 191 and 200 (inclusive), insert data in the cards table with the following values:
card_number – set it to full name of the client, but reversed!
card_status – set it to "Active".
bank_account_id –set it to client's id value.
*/
INSERT INTO `cards` (`card_number`, `card_status`, `bank_account_id`)
	(SELECT REVERSE(`full_name`),
			'Active',
			`id`
	FROM `clients`
	WHERE `id` BETWEEN 191 AND 200);

# 03. Update
/*
Update all clients which have the same id as the employee they are appointed to. 
Set their employee_id with the employee with the lowest count of clients.
If there are 2 such employees with equal count of clients, take the one with the lowest id.
*/
/*UPDATE `clients` AS c
    JOIN `employees_clients` AS ec
    ON c.`id` = ec.`client_id`
    JOIN `employees` AS e
    ON ec.`employee_id` = e.`id`
SET 
WHERE c.`id` = e.`id`; */

# 04. Delete
/* Delete all employees which do not have any clients. */
DELETE FROM `employees`
WHERE `id` NOT IN (SELECT `employee_id` FROM `employees_clients`);

# 05. Clients
/*
Extract from the database, all of the clients. 
Order the results ascending by client id.
*/
SELECT `id`, `full_name` FROM `clients` ORDER BY `id` ASC;

# 06. Newbies
/*
Extract from the database, all of the employees, 
which have salary greater than or equal to 100000 and have started later than 
or equal to the 1st of January - 2018. 
The salary should have a "$" as a prefix.
Order the results descending by salary, then by id.
*/
SELECT `id`,
		CONCAT(`first_name`, ' ', `last_name`) AS 'full_name',
		CONCAT('$', `salary`) AS 'salary',
		`started_on`
FROM `employees`
WHERE (`salary` >= 100000) AND (`started_on` > '2018-01-01')
ORDER BY `salary` DESC, `id`;

# 07. Cards against Humanity
/*
Extract from the database, all of the cards, and the clients that own them, 
so that they end up in the following format:
{card_number} : {full_name}
Order the results descending by card id.
*/
SELECT  c.`id`,
		CONCAT(c.`card_number`, ' : ', `full_name`) AS 'card_token'
FROM `cards` AS c
	JOIN `bank_accounts` AS ba
	ON c.`bank_account_id` = ba.`id`
	JOIN `clients` AS cl
	ON ba.`client_id` = cl.`id`
ORDER BY c.`id` DESC;

# 08. Top 5 Employees
/*
Extract from the database, the top 5 employees, in terms of clients assigned to them.
Order the results descending by count of clients, and ascending by employee id.
*/
SELECT  CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'name',
		`started_on`,
		COUNT(ec.`client_id`) AS 'count_of_clients'
FROM `employees` AS e
	JOIN `employees_clients` AS ec
	ON e.`id` = ec.`employee_id`
GROUP BY ec.`employee_id`
ORDER BY `count_of_clients` DESC, e.`id`
LIMIT 5;

# 09. Branch cards
/*
Extract from the database, all branches with the count of their issued cards. 
Order the results by the count of cards, then by branch name.
*/
SELECT  b.`name`,
		COUNT(c.`id`) AS 'count_of_cards'
FROM `branches` AS b
		LEFT JOIN `employees` AS e
		ON b.`id` = e.`branch_id`
		LEFT JOIN `employees_clients` AS ec
		ON e.`id` = ec.`employee_id`
		LEFT JOIN `clients` AS cl
		ON ec.`client_id` = cl.`id`
		LEFT JOIN `bank_accounts` AS ba
		ON cl.`id` = ba.`client_id`
		LEFT JOIN `cards` AS c
		ON ba.`id` = c.`bank_account_id`
GROUP BY b.`id`
ORDER BY `count_of_cards` DESC, b.`name`;

# 10. Extract card's count
/*
Create a user defined function with the name udf_client_cards_count(name VARCHAR(30)) 
that receives a client's full name and returns the number of cards he has.
*/
DELIMITER $$
CREATE FUNCTION udf_client_cards_count(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(c.`id`) 
			FROM `clients` AS cl
				JOIN `bank_accounts` AS ba 
				ON cl.`id` = ba.`client_id`
				JOIN `cards` AS c
				ON ba.`id` = c.`bank_account_id`
			WHERE cl.`full_name` = name);
END $$

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';

# 11. Client Info
/*
Create a stored procedure udp_clientinfo which accepts the following parameters: full_name
And extracts data about the client with the given full name.
Aside from the full_name, the procedure should extract the client's age, bank account number and balance.
The account’s salary should have "$" prefix.
*/
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(50))
BEGIN
	SELECT  cl.`full_name`,
			cl.`age`,
			ba.`account_number`,
			CONCAT('$', ba.`balance`) AS 'balance'
	FROM `clients` AS cl
		JOIN `bank_accounts` AS ba
		ON cl.`id` = ba.`client_id`
	WHERE cl.`full_name` = full_name;
END $$

CALL udp_clientinfo('Hunter Wesgate');