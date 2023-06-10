-- LAB:

# 01. Find Book Titles:
/*
Write a SQL query to find books which titles start with "The". 
Order the result by id. 
*/
SELECT  `title`
FROM `books`
WHERE LOWER(SUBSTRING(`title`, 1, 3) = 'the')
ORDER BY `id`;

# 02. Replace Titles:
/*
Write a SQL query to find books which titles start with "The" 
and replace the substring with 3 asterisks. 
*/
SELECT REPLACE(`title`, 'The', '***') AS 'title'
FROM  `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

# 03. Sum Cost of All Books:
/*
Write a SQL query to sum prices of all books. 
Format the output to 2 digits after decimal point. 
*/
SELECT ROUND(SUM(`cost`), 2) AS 'Sum'
FROM `books`;

# 04. Days Lived:
/*
Write a SQL query to calculate the days that an author lived. Your query should return: 
- Full Name – the full name of the author. 
- Days Lived – days that he/she lived. NULL values mean that the author is still alive. 
*/
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS 'Full Name',
	   TIMESTAMPDIFF(DAY, `born`, `died`) AS 'Days Lived'
FROM  `authors`;

# 05. Harry Potter Books:
/*
Write a SQL query to retrieve titles of all the Harry Potter books. 
Order the information by id. 
*/
SELECT  `title`
FROM `books`
WHERE `title` LIKE 'Harry Potter%'
ORDER BY `id`;

-- EXERCISE:

-- Part I – Queries for SoftUni Database:
# 01. Find Names of All Employees by First Name:
/*
Find first and last names of all employees whose first name starts with "Sa" (case insensitively).
 Order the information by id. 
*/
-- 1
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE LOWER(LEFT(`first_name`,2)) = 'sa'
ORDER BY `employee_id`;

-- 2
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

# 02. Find Names of All Employees by Last Name:
/*
Find first and last names of all employees whose last name contains "ei" (case insensitively).
 Order the information by id. 
*/
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

# 03. Find First Names of All Employess:
/*
Find the first names of all employees in the departments with ID 3 or 10 
and whose hire year is between 1995 and 2005 inclusively. 
Order the information by id. 
*/
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3,10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005 
ORDER BY `employee_id`;

# 04. Find All Employees Except Engineers:
/*
Find the first and last names of all employees whose job titles does not contain "engineer". 
Order the information by id. 
*/
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

# 05. Find Towns with Name Length:
/*
Find town names that are 5 or 6 symbols long and order them alphabetically by town name. 
*/
SELECT  `name`
FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5 , 6)
ORDER BY `name`;

# 06. Find Towns Starting With:
/*
Find all towns that start with letters M, K, B or E (case insensitively). 
Order them alphabetically by town name. 
*/
SELECT  `town_id`, `name`
FROM `towns`
WHERE `name` LIKE 'M%' OR `name` LIKE 'K%' OR `name` LIKE 'B%' OR `name` LIKE 'E%'
ORDER BY `name`;


# 07. Find Towns Not Starting With:
/*
Find all towns that do not start with letters R, B or D (case insensitively). 
Order them alphabetically by name. 
*/
SELECT  `town_id`, `name`
FROM `towns`
WHERE `name` NOT LIKE 'R%' AND `name` NOT LIKE 'B%' AND `name` NOT LIKE 'D%'
ORDER BY `name`;

# 08. Create View Employees Hired After:
/*
Create view v_employees_hired_after_2000 with the first 
and the last name of all employees hired after 2000 year. 
Select all from the created view. 
*/
CREATE VIEW `v_employees_hired_after_2000` AS
	SELECT 
		`first_name`, `last_name`
	FROM
		`employees`
	WHERE
		YEAR(`hire_date`) > 2000;
        
SELECT * FROM `v_employees_hired_after_2000`;

# 09. Length of Last Name:
/*
Find the first and last names of all employees whose last name is exactly 5 characters long. 
*/
SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5; 

-- Part II – Queries for Geography Database:
# 10. Countries Holding ‘A’:
/*
Find all countries that hold the letter 'A' in their name at least 3 times (case insensitively), sorted by ISO code. 
Display the country name and the ISO code. 
*/
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

# 11. Mix of Peak and River Names:
/*
Combine all peak names with all river names, so that the last letter of each peak name is the same as the first letter of its corresponding river name. 
Display the peak name, the river name, and the obtained mix(converted to lower case). 
Sort the results by the obtained mix alphabetically. 
*/
SELECT  `peak_name`, # взимаме колони от различни таблици
	    `river_name`, 
        CONCAT(LOWER(`peak_name`), LOWER(SUBSTRING(`river_name`, 2))) AS 'mix'
FROM `peaks`, `rivers` -- cartesian product
WHERE LEFT(`river_name`, 1) = RIGHT(`peak_name`, 1)
ORDER BY `mix`;

-- Part III – Queries for Diablo Database:
# 12. Games From 2011 and 2012 Year:
/*
Find the top 50 games ordered by start date, then by name.
 Display only the games from the years 2011 and 2012. 
Display the start date in the format "YYYY-MM-DD". 
*/
SELECT  `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS 'start'
FROM `games`
WHERE YEAR(`start`) IN (2011 , 2012)
ORDER BY `start` , `name`
LIMIT 50;

# 13. User Email Providers:
/*
Find information about the email providers of all users. 
Display the user_name and the email provider. 
Sort the results by email provider alphabetically, then by username. 
*/
SELECT `user_name`, SUBSTRING(`email`, LOCATE('@',`email`) + 1) AS 'email provider'
FROM `users`
ORDER BY `email provider`, `user_name`;

# 14. Get Users with IP Address Like Pattern:
/*
Find the user_name and the ip_address for each user, sorted by user_name alphabetically. 
Display only the rows, where the ip_address matches the pattern: "___.1%.%.___". 
*/
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

# 15. Show All Games with Duration:
/*
Find all games with their corresponding part of the day and duration. 
Parts of the day should be Morning (start time is >= 0 and < 12), 
Afternoon (start time is >= 12 and < 18), 
Evening (start time is >= 18 and < 24). 
Duration should be Extra Short (smaller or equal to 3), 
Short (between 3 and 6 including), 
Long (between 6 and 10 including) 
and Extra Long in any other cases or without duration. 
*/
SELECT `name` AS 'game', 
CASE 
WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
WHEN HOUR(`start`) >= 18 AND HOUR(`start`) < 24 THEN 'Evening'
END
AS `Part of the Day`,

CASE
WHEN `duration` <= 3 THEN 'Extra Short'
WHEN `duration` > 3 AND `duration` <= 6 THEN 'Short'
WHEN `duration` > 6 AND `duration` <= 10 THEN 'Long'
ELSE 'Extra Long'
END
AS 'Duration'

FROM `games`;

-- Part IV – Date Functions Queries:
# 16. Orders Table:
/*
You are given a table orders (id, product_name, order_date) filled with data. 
Consider that the payment for an order must be accomplished within 3 days after the order date. 
Also the delivery date is up to 1 month. 
Write a query to show each product's name, order date, pay and deliver due dates. 
*/
SELECT `product_name`, `order_date`,
DATE_ADD(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM `orders`;