-- LAB

# 1.Count Employees by Town:
/*
Write a function ufn_count_employees_by_town(town_name) that accepts town_name as parameter 
and returns the count of employees who live in that town. 
*/
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(`town_name` VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE count INT;
SET count := (SELECT COUNT(e.`employee_id`) 
				FROM `employees` AS e
				JOIN `addresses` AS a 
				ON e.`address_id` = a.`address_id`
				JOIN `towns` AS t
				ON a.`town_id` = t.`town_id`
				WHERE t.`name` = `town_name`);
RETURN count;

END $$
 
DELIMITER ;
SELECT ufn_count_employees_by_town('Sofia') AS 'count';

# 2. Employees Promotion:
/*
Write a stored procedure usp_raise_salaries(department_name) 
to raise the salary of all employees in given department as parameter by 5%. 
*/
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries_by_department(`department_name` VARCHAR(50))
BEGIN
		UPDATE `employees`
		SET `salary` = `salary` * 1.05 # 5% -> (1 + (5/100)) = (1 + 0.05) = 1.05
		WHERE `department_id` = (SELECT `department_id` FROM `departments`
								WHERE `name` = `department_name`);
END $$
 
DELIMITER ;

CALL usp_raise_salaries_by_department('Finance');

SELECT e.`first_name`, e.`salary` 
FROM `employees` AS e
		JOIN `departments` AS d
		ON e.`department_id` = d.`department_id` #USING(`department_id`)
WHERE d.`name` = 'Finance'
ORDER BY e.`first_name`, e.`salary`;

# 3. Employees Promotion By ID:
/*
Write a stored procedure usp_raise_salary_by_id(id) 
that raises a given employee's salary (by id as parameter) by 5%.
*/
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(`id` INT)
BEGIN
	UPDATE `employees` 
	SET `salary` = `salary` * 1.05
	WHERE `employee_id` = `id`;
END $$
 
DELIMITER ;

SET @id := 17;
CALL usp_raise_salary_by_id(@id);

SELECT `salary`
FROM `employees`
WHERE `employee_id` = @id;

# 4. Triggered:
/*
Create a table deleted_employees(employee_id PK, 
first_name,last_name,middle_name,job_title,deparment_id,salary) 
that will hold information about fired(deleted) employees from the employees table. 
Add a trigger to employees table that inserts the corresponding information in deleted_employees. 
*/
CREATE TABLE `deleted_employees` (
`employee_id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50),
`last_name` VARCHAR(50),
`middle_name` VARCHAR(50),
`job_title` VARCHAR(50),
`department_id` INT,
`salary` DECIMAL(19,4)
);
 
DELIMITER $$
CREATE TRIGGER tr_after_delete_employees
AFTER DELETE
ON `employees`
FOR EACH ROW

BEGIN
		INSERT INTO `deleted_employees` (`first_name`,`last_name`, `middle_name`,
					                     `job_title`, `department_id`,`salary`)
		VALUES (OLD.`first_name`,
				OLD.`last_name`,
				OLD.`middle_name`,
				OLD.`job_title`,
				OLD.`department_id`,
				OLD.`salary`);
END $$


-- EXERCISE:

# 01. Employees with Salary Above 35000:
/*
Create stored procedure usp_get_employees_salary_above_35000 
that returns all employees' first and last names for whose salary is above 35000. 
The result should be sorted by first_name then by last_name alphabetically, and id ascending. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above_35000`()
BEGIN
		SELECT `first_name`, `last_name` 
		FROM `employees`
		WHERE `salary` > '35000'
		ORDER BY `first_name`, `last_name`, `employee_id`;
END $$

CALL `usp_get_employees_salary_above_35000`();

# 02. Employees with Salary Above Number:
/*
Create stored procedure usp_get_employees_salary_above that accept a decimal number 
(with precision, 4 digits after the decimal point) as parameter 
and return all employee's first and last names whose salary is above or equal to the given number. 
The result should be sorted by first_name then by last_name alphabetically and id ascending. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above`(`min_salary` DECIMAL(19,4))
BEGIN
		SELECT `first_name`, `last_name` 
		FROM `employees`
		WHERE `salary` >= `min_salary`
		ORDER BY `first_name`, `last_name`, `employee_id`;
END $$

CALL `usp_get_employees_salary_above`(45000);

# 03. Town Names Starting With:
/*
Write a stored procedure usp_get_towns_starting_with that accept string as parameter 
and returns all town names starting with that string. 
The result should be sorted by town_name alphabetically. 
*/
DELIMITER $$ 
CREATE PROCEDURE usp_get_towns_starting_with (start_with VARCHAR(50))
BEGIN
	SELECT `name` 
	FROM `towns`
	WHERE `name` like CONCAT(start_with,'%')
	ORDER BY `name`;
END $$

# 04. Employees from Town:
/*
Write a stored procedure usp_get_employees_from_town that accepts town_name as parameter 
and return the employees' first and last name that live in the given town. 
The result should be sorted by first_name then by last_name alphabetically and id ascending. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_from_town`(`town_name` VARCHAR(50))
BEGIN 
		SELECT e.`first_name`, e.`last_name`
		FROM `employees` AS e
			JOIN `addresses` AS a ON e.`address_id` = a.`address_id`
			JOIN `towns` AS t ON a.`town_id` = t.`town_id`
		WHERE t.`name` = `town_name`
		ORDER BY `first_name`, `last_name`, `employee_id`; 
END $$

CALL `usp_get_employees_from_town`('Sofia');

# 05. Salary Level Function:
/*
Write a function ufn_get_salary_level that receives salary of an employee and returns the level of the salary. 
If salary is < 30000 return "Low" 
If salary is between 30000 and 50000 (inclusive) return "Average" 
If salary is > 50000 return "High" 
*/
DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(`salary` DECIMAL(19,4))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	DECLARE `salary_level` VARCHAR(50);

	CASE
		WHEN (`salary` < 30000) THEN  SET `salary_level` := 'Low';
		WHEN (`salary` >= 30000) AND (`salary` <= 50000) THEN SET `salary_level` := 'Average';
		WHEN (`salary` > 50000) THEN SET `salary_level` := 'High';
	END CASE;
    
RETURN `salary_level`;
END $$

SELECT `salary`, ufn_get_salary_level(`salary`)
FROM `employees`;

# 06. Employees by Salary Level:
/*
Write a stored procedure usp_get_employees_by_salary_level that receive as parameter level of salary (low, average or high) 
and print the names of all employees that have given level of salary. 
The result should be sorted by first_name then by last_name both in descending order. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(50))
BEGIN
		SELECT `first_name`, `last_name`
		FROM `employees`
		WHERE ufn_get_salary_level(`salary`) = `salary_level`
		ORDER BY `first_name` DESC, `last_name` DESC;
END $$

CALL usp_get_employees_by_salary_level('High');

# 07. Define Function:
/*
Define a function ufn_is_word_comprised(set_of_letters varchar(50), 
word varchar(50)) that returns 1 or 0 depending on 
that if the word is a comprised of the given set of letters. 
*/
DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN 
		RETURN IF(`word` REGEXP CONCAT('^[',`set_of_letters`,']+$'), 1, 0);
END $$

SELECT ufn_is_word_comprised('oistmiahf', 'halves');

# 08. Find Full Name:
/*
You are given a database schema with tables: 
• account_holders(id (PK), first_name, last_name, ssn) and 
• accounts(id (PK), account_holder_id (FK), balance). 
Write a stored procedure usp_get_holders_full_name that selects the full names of all people. 
The result should be sorted by full_name alphabetically and id ascending.
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_full_name`()
BEGIN
		SELECT CONCAT_WS(' ',`first_name`, `last_name`) AS 'full_name'
		FROM `account_holders`
		ORDER BY `full_name`, `id`;
END$$

CALL `usp_get_holders_full_name`;

# 9. People with Balance Higher Than:
/*
Your task is to create a stored procedure usp_get_holders_with_balance_higher_than that accepts a number as a parameter 
and returns all people who have more money in total of all their accounts than the supplied number. 
The result should be sorted by account_holders.id ascending. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(`min_total_money` DECIMAL(19,4))
BEGIN 
	SELECT  ah.`first_name`,
			ah.`last_name`
FROM `account_holders` AS ah
		JOIN `accounts` AS a 
		ON ah.`id` = a.`account_holder_id`
GROUP BY a.`account_holder_id`
HAVING SUM(a.`balance`) > `min_total_money`
ORDER BY a.`account_holder_id`;

END $$

CALL `usp_get_holders_with_balance_higher_than`(7000);

# 10. Future Value Function:
/*
Your task is to create a function ufn_calculate_future_value that accepts as parameters – sum (with precision, 4 digits after the decimal point), 
yearly interest rate (double) and number of years(int). 
It should calculate and return the future value of the initial sum. 
The result from the function must be decimal, with percision 4. 
*/
DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value`(`sum` DECIMAL(19,4), `yearly_interest_rate` DECIMAL(19,4), `number_of_years` INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
		RETURN `sum` * POW((1 + `yearly_interest_rate`), `number_of_years`);
END $$

SELECT ufn_calculate_future_value(1000, 0.5,5);

# 11. Calculating Interest:
/*
Your task is to create a stored procedure usp_calculate_future_value_for_account that accepts as parameters
–id of account and interest rate.The procedure uses the function from the previous problem to give an interest to a person's account for 5 years,
 along with information about his/her account id, first name, last name and current balance as it is shown in the example below. 
 It should take the account_id and the interest_rate as parameters. 
 Interest rate should have precision up to 0.0001, same as the calculated balance after 5 years. 
*/
CREATE PROCEDURE `usp_calculate_future_value_for_account`(`given_id` INT, `interest_rate` DOUBLE)
BEGIN
        SELECT a.`id` AS 'account_id',
               ah.`first_name`,
               ah.`last_name`,
               a.`balance` AS 'current_balance',
               ufn_calculate_future_value(`balance`,`interest_rate`, 5) AS 'balance_in_5_years'
       FROM `account_holders` AS ah
            JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id`
       WHERE a.`id` = `given_id`;
END;

# 12. Deposit Money:
/*
Add stored procedure usp_deposit_money(account_id, money_amount) that operate in transactions. 
Make sure to guarantee valid positive money_amount with precision up to fourth sign after decimal point. 
The procedure should produce exact results working with the specified precision. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_deposit_money`(`account_id` INT, `money_amount` DECIMAL(19,4))
BEGIN
	START TRANSACTION;
		IF(`money_amount` <= 0) THEN ROLLBACK;
		ELSE 
			UPDATE `accounts` 
			SET `balance` = `balance` + `money_amount`
			WHERE `id` = `account_id`;
		COMMIT;
		END IF;
END $$

CALL `usp_deposit_money`(1,10);
 
SELECT * FROM `accounts` WHERE `id` = 1;

# 13. Withdraw Money:
/*
Add stored procedures usp_withdraw_money(account_id, money_amount) that operate in transactions. 
Make sure to guarantee withdraw is done only when balance is enough and money_amount is valid positive number. 
Work with precision up to fourth sign after decimal point. 
The procedure should produce exact results working with the specified precision. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_withdraw_money`(`account_id` INT, `money_amount` DECIMAL(19,4))
BEGIN
DECLARE `current_balance` DECIMAL(19,4);
SET `current_balance` := (SELECT `balance` FROM `accounts` WHERE `id` = `account_id`);

		START TRANSACTION;
		IF(`money_amount` <= 0 OR `current_balance` < `money_amount`) THEN ROLLBACK;
		ELSE 
			UPDATE `accounts`
			SET `balance` = `balance` - `money_amount`
			WHERE `id` = `account_id`;
		COMMIT;
		END IF;
END $$

CALL usp_withdraw_money(1, 10);
 
SELECT `balance` FROM `accounts` WHERE `id` = 1;

# 14. Money Transfer:
/*
Write stored procedure usp_transfer_money(from_account_id, to_account_id, amount) that transfers money from one account to another. 
Consider cases when one of the account_ids is not valid, the amount of money is negative number,
outgoing balance is enough or transferring from/to one and the same account. 
*/
DELIMITER $$
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL(19,4))
BEGIN
DECLARE `current_balance` DECIMAL(19,4);
SET `current_balance` := (SELECT `balance` FROM `accounts` WHERE `id` = `from_account_id`);
		START TRANSACTION;
			IF(
				`from_account_id` NOT IN (SELECT `id` FROM `accounts`)
				OR
				`to_account_id` NOT IN (SELECT `id` FROM `accounts`)
				OR `amount` <= 0
				OR `current_balance` < `amount`
				OR `from_account_id` = `to_account_id`) THEN ROLLBACK;
			ELSE
			UPDATE `accounts`
			SET `balance` = `balance` - `amount`
			WHERE `id` = `from_account_id`;

			UPDATE `accounts`
			SET `balance` = `balance` + `amount`
			WHERE `id` = `to_account_id`;
		COMMIT;
		END IF;

END $$

CALL usp_transfer_money(1, 2, 10);
 
SELECT `id`, `account_holder_id`, `balance`
FROM `accounts`
LIMIT 2;

# 15. Log Accounts Trigger:
/*
Create another table – logs(log_id, account_id, old_sum, new_sum). 
Add a trigger to the accounts table that enters a new entry into the logs table every time the sum on an account changes. 
*/
CREATE TABLE `logs` (
    `log_id` INT PRIMARY KEY AUTO_INCREMENT,
    `account_id` INT,
    `old_sum` DECIMAL(19,4),
    `new_sum` DECIMAL(19,4)
);
 
DELIMITER $$
CREATE TRIGGER `tr_change_balance`
AFTER UPDATE ON `accounts` FOR EACH ROW
BEGIN
		INSERT INTO `logs`(`account_id`, `old_sum`, `new_sum`)
		VALUES (OLD.`id`, OLD.`balance`, NEW.`balance`);
END $$

UPDATE `accounts`
SET `balance` = `balance` + 10
WHERE `id` = 1;
 
SELECT * FROM `logs`;

# 16. Emails Trigger:
/*
Create another table – notification_emails(id, recipient, subject, body). Add a trigger to logs table to create new email whenever new record is inserted in logs table. 
The following data is required to be filled for each email: 
*/
DELIMITER $$
CREATE TRIGGER `tr_email_log_changes`
AFTER INSERT ON `logs` FOR EACH ROW
BEGIN
		INSERT INTO `notification_emails` (`recipient`, `subject`, `body`)
		VALUES (NEW.`account_id`, 
				CONCAT('Balance change for account:', NEW.`account_id`),
				CONCAT_WS(' ', 'On', Now(), 'your balance was changed from', NEW.`old_sum`, 'to', NEW.`new_sum`, '.'));
END $$