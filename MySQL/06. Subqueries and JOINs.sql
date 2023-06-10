-- LAB

# 01.Managers:
/*
Write a query to retrieve information about the managers – id, full_name, deparment_id and department_name. 
Select the first 5 departments ordered by employee_id. 
*/
# get first 5 employees who are manager in department
SELECT  e.`employee_id`,
		CONCAT_WS(' ',`first_name`,`last_name`) AS 'full_name',
		d.`department_id`,
		d.`name` AS 'department_name'
FROM `employees` AS e
		JOIN `departments` AS d ON e.`employee_id` = d.`manager_id`
ORDER BY e.`employee_id`
LIMIT 5; 

# 02. Towns and Addresses:
/*
Write a query to get information about the addresses in the database, which are in San Francisco, Sofia or Carnation. 
Retrieve town_id, town_name, address_text. 
Order the result by town_id, then by address_id. 
*/
SELECT  t.`town_id`,
		t.`name` AS 'town_name', 
		a.`address_text`
FROM `addresses` AS a 
JOIN `towns` AS t ON t.`town_id` = a.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.`town_id`, a.`address_id`;

# 03. Employees Without Managers:
/*
Write a query to get information about employee_id, first_name, last_name, department_name 
and salary for all employees who don't have a manager. 
*/
SELECT  `employee_id`,
		`first_name`,
		`last_name`,
		d.`name`,
		`salary`
FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NULL;

# 04. High Salary:
/*
Write a query to count the number of employees who receive salary higher than the average. 
*/
SELECT COUNT(`employee_id`) AS 'count'
FROM `employees`
WHERE salary > (
	SELECT AVG(`salary`) FROM `employees`
);

# 05. JOIN with same table
# get information about the names of the employees' managers
SELECT  e.`employee_id`,
		CONCAT(e.`first_name`,' ', e.`last_name`) AS 'employee name',
		m.`employee_id`,
		CONCAT(m.`first_name`,' ', m.`last_name`) AS 'manager name'
FROM `employees` AS e
	JOIN `employees` AS m ON e.`manager_id` = m.`employee_id`;
    
# 06. Multiple JOIN (mapping table)
# get information about the number of employees working on projects
SELECT  p.`name` AS 'project name',
		COUNT(ep.`employee_id`) AS 'count'
FROM `employees` AS e
	JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id` -- резултът от първия join се join-ва със следващия
	JOIN `projects` AS p ON p.`project_id` = ep.`project_id`
GROUP BY ep.`project_id`;

-- EXERCISE:

# 01. Employee Address:
/*
Write a query that selects:  employee_id , job_title, address_id, address_text 
Return the first 5 rows sorted by address_id in ascending order. 
*/
SELECT  e.`employee_id`,
		e.`job_title`,
		a.`address_id`,
		a.`address_text`
FROM `employees` AS e
		JOIN `addresses` AS a 
		ON e.`address_id` = a.`address_id`
ORDER BY a.`address_id`
LIMIT 5;

# 02. Addresses with Towns:
/*
Write a query that selects: first_name, last_name, town, address_text 
Sort the result by first_name in ascending order then by last_name. 
Select first 5 employees. 
*/
SELECT  e.`first_name`, 
		e.`last_name`, 
		t.`name` AS 'town', 
        a.`address_text`
FROM `employees` AS e
		JOIN `addresses` AS a
		ON e.`address_id` = a.`address_id`
		JOIN `towns` AS t 
		ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name`, e.`last_name`
LIMIT 5;

# 03. Sales Employee:
/*
Write a query that selects: employee_id, first_name, last_name, department_name 
Sort the result by employee_id in descending order. 
Select only employees from the "Sales" department. 
*/
SELECT  e.`employee_id`,
		e.`first_name`,
		e.`last_name`,
		d.`name` AS 'department_name'
FROM `employees` AS e
		JOIN `departments` AS d
		ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;

# 04. Employee Departments:
/*
Write a query that selects: employee_id, first_name, salary, department_name 
Filter only employees with salary higher than 15000. 
Return the first 5 rows sorted by department_id in descending order. 
*/
SELECT  e.`employee_id`,
		e.`first_name`,
		e.`salary`,
		d.`name` AS 'departmnet_name'
FROM `employees` AS e
		JOIN `departments` AS d
		ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

# 05. Employees Without Project:
/*
Write a query that selects: employee_id, first_name
Filter only employees without a project. 
Return the first 3 rows sorted by employee_id in descending order. 
*/
SELECT  `employee_id`,
		`first_name`
FROM `employees`
WHERE `employee_id` NOT IN (
# get all employee ids with the project
		SELECT e.`employee_id` 
		FROM `employees` AS e
		JOIN `employees_projects` AS ep
		ON e.`employee_id` = ep.`employee_id`
)
ORDER BY `employee_id` DESC
LIMIT 3;

# 06. Employees Hired After:
/*
Write a query that selects: first_name, last_name, hire_date,  dept_name 
Filter only employees hired after 1/1/1999 and from either the "Sales" or the "Finance" departments.
Sort the result by hire_date (ascending). 
*/
SELECT  e.`first_name`,
		e.`last_name`,
		e.`hire_date`,
		d.`name` AS 'dept_name'
FROM `employees` AS e
		JOIN `departments` AS d 
		ON e.`department_id` = d.`department_id`
WHERE (DATE(e.`hire_date`) > '1999-01-01') AND (d.`name` IN ('Sales', 'Finance'))
ORDER BY e.`hire_date` ASC;

# 07. Employees with Project:
/*
Write a query that selects:  employee_id, first_name, project_name 
Filter only employees with a project, which has started after 13.08.2002 and it is still ongoing (no end date). 
Return the first 5 rows sorted by first_name then by project_name both in ascending order. 
*/
SELECT  e.`employee_id`,
		e.`first_name`,
		p.`name` AS 'project_name'
FROM `employees` AS e
		JOIN `employees_projects` AS ep
        ON e.`employee_id` = ep.`employee_id`
		JOIN `projects` AS p
		ON p.`project_id` = ep.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13' AND (p.`end_date` IS NULL)
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

# 08. Employee 24:
/*
Write a query that selects:  employee_id, first_name, project_name 
Filter all the projects of employees with id 24. 
If the project has started after 2005 inclusively the return value should be NULL. 
Sort the result by project_name alphabetically. 
*/
SELECT  e.`employee_id`,
		e.`first_name`,
		IF(YEAR(p.`start_date`) >= 2005, NULL, p.`name`) AS 'project_name'
FROM `employees` AS e
		JOIN `employees_projects` AS ep 
		ON e.`employee_id` = ep.`employee_id`
		JOIN `projects` AS p 
		ON ep.`project_id` = p.`project_id`
WHERE ep.`employee_id` = 24
ORDER BY p.`name`;

# 09. Employee Manager:
/*
Write a query that selects: employee_id,  first_name, manager_id, manager_name 
Filter all employees with a manager who has id equal to 3 or 7. 
Return all rows sorted by employee first_name in ascending order. 
*/
SELECT  e.`employee_id`,
		e.`first_name`,
		e.`manager_id`,
		m.`first_name`
FROM `employees` AS e
# get all employees with managers
		JOIN `employees` AS m 
		ON e.`manager_id` = m.`employee_id`
WHERE e.`manager_id` IN (3, 7)
ORDER BY e.`first_name` ASC;

# 10. Employee Summary:
/*
Write a query that selects: employee_id, employee_name, manager_name, department_name 
Show the first 5 employees (only for employees who have a manager) with their managers 
and the departments they are in (show the departments of the employees). 
Order by employee_id. 
*/
SELECT  e.`employee_id`,
		CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'employee_name',
		CONCAT(m.`first_name`, ' ', m.`last_name`) AS 'manager_name',
		d.`name` AS 'department_name'
FROM `employees` AS e
		JOIN `employees` AS m
		ON e.`manager_id` = m.`employee_id`
		JOIN `departments` AS d 
		ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

# 11. Min Average Salary:
/*
Write a query that returns the value of the lowest average salary of all departments. 
*/
SELECT AVG(`salary`) AS 'min_average_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary` ASC
LIMIT 1;

SELECT AVG(`salary`) AS 'min_average_salary',
      d.`name` AS 'department_name'
FROM `employees` AS e
		JOIN `departments` AS d
		ON e.`department_id` = d.`department_id`
GROUP BY d.`department_id`
ORDER BY `min_average_salary` ASC
LIMIT 1;

# 12. Highest Peaks in Bulgaria:
/*
Write a query that selects: country_code, mountain_range, peak_name, elevation 
Filter all peaks in Bulgaria with elevation over 2835. 
Return all rows sorted by elevation in descending order. 
*/
SELECT  c.`country_code`,
		m.`mountain_range`,
		p.`peak_name`,
		p.`elevation`
FROM `countries` AS c
		JOIN `mountains_countries` AS mc 
		ON c.`country_code` = mc.`country_code`
		JOIN `mountains` AS m 
		ON mc.`mountain_id` = m.`id`
		JOIN `peaks` AS p 
		ON m.`id` = p.`mountain_id`
WHERE (c.`country_code` = 'BG') AND (p.`elevation` > '2835')
ORDER BY p.`elevation` DESC;

# 13. Count Mountain Ranges:
/*
Write a query that selects: country_code, mountain_range
Filter the count of the mountain ranges in the United States, Russia and Bulgaria. 
Sort result by mountain_range count in decreasing order. 
*/
SELECT  c.`country_code`,
		COUNT(mc.`mountain_id`) AS 'mountain_range'
FROM `countries` AS c
		JOIN `mountains_countries` AS mc
		ON c.`country_code` = mc.`country_code`
WHERE c.`country_name` IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.`country_code`
ORDER BY `mountain_range` DESC;

# 14. Countries with Rivers:
/*
Write a query that selects: country_name, river_name
Find the first 5 countries with or without rivers in Africa. 
Sort them by country_name in ascending order. 
*/
SELECT  c.`country_name`,
		r.`river_name`
FROM `countries` AS c
		JOIN `continents` AS con
		ON c.`continent_code` = con.`continent_code`
		LEFT JOIN `countries_rivers` AS cr
		ON c.`country_code` = cr.`country_code`
		LEFT JOIN `rivers` AS r
		ON cr.`river_id` = r.`id`
WHERE con.`continent_name` = 'Africa'
ORDER BY c.`country_name`
LIMIT 5;

# 15. *Continents and Currencies:
/*
Write a query that selects: continent_code, currency_code ,  currency_usage 
Find all continents and their most used currency. 
Filter any currency that is used in only one country. 
Sort the result by continent_code and currency_code.
*/
SELECT  `continent_code`, 
		`currency_code`,
		COUNT(`country_name`) AS 'currency_usage'
FROM `countries` AS c
GROUP BY `continent_code`,`currency_code`
HAVING `currency_usage` = (
		SELECT COUNT(`country_code`) AS 'coun'
		FROM `countries` AS c1
		WHERE c1.`continent_code` = c.`continent_code`
		GROUP BY `currency_code`
		ORDER BY `coun` DESC
		LIMIT 1
) AND `currency_usage` > 1
ORDER BY `country_code`, `currency_code`;

# 16. Countries without any Mountains:
/* Find the count of all countries which don't have a mountain. */
SELECT COUNT(`country_code`) AS 'country_code'
FROM `countries` 
WHERE `country_code` NOT IN (SELECT mc.`country_code` FROM mountains_countries AS mc);

# 17. Highest Peak and Longest River by Country:
/*
For each country, find the elevation of the highest peak and the length of the longest river, 
sorted by the highest peak_elevation (from highest to lowest), 
then by the longest river_length (from longest to smallest), 
then by country_name (alphabetically). 
Display NULL when no data is available in some of the columns. 
Limit only the first 5 rows. 
*/
SELECT  `country_name`,
		MAX(p.`elevation`) AS 'highest_peak_elevation',
		MAX(r.`length`) AS 'longest_river_length'
FROM `countries` AS c
		JOIN `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
		JOIN `peaks` AS p ON mc.`mountain_id` = p.`mountain_id`
		JOIN `countries_rivers` AS cr ON c.`country_code` = cr.`country_code`
		JOIN `rivers` AS r ON cr.`river_id` = r.`id`
GROUP BY c.`country_name`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC, `country_name` ASC
LIMIT 5;