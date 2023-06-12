CREATE DATABASE `sgd`;

# 01. Table Design
CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `offices` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`workspace_capacity` INT NOT NULL,
	`website` VARCHAR(50),
	`address_id` INT NOT NULL,
	CONSTRAINT fk_offices_addresses FOREIGN KEY (`address_id`)
		REFERENCES `addresses` (`id`)
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`age` INT NOT NULL,
	`salary` DECIMAL(10 , 2 ) NOT NULL,
	`job_title` VARCHAR(20) NOT NULL,
	`happiness_level` CHAR(1) NOT NULL
);

CREATE TABLE `teams` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
	`office_id` INT NOT NULL,
	`leader_id` INT NOT NULL UNIQUE,
	CONSTRAINT fk_teams_offices FOREIGN KEY (`office_id`)
		REFERENCES `offices` (`id`),
	CONSTRAINT fk_teams_employees FOREIGN KEY (`leader_id`)
		REFERENCES `employees` (`id`)
);

CREATE TABLE `games` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL UNIQUE,
	`description` TEXT,
	`rating` FLOAT NOT NULL DEFAULT 5.5,
	`budget` DECIMAL(10 , 2 ) NOT NULL,
	`release_date` DATE,
	`team_id` INT NOT NULL,
	CONSTRAINT fk_games_teams FOREIGN KEY (`team_id`)
		REFERENCES `teams` (`id`)
);

CREATE TABLE `games_categories` (
	`game_id` INT NOT NULL,
	`category_id` INT NOT NULL,
	CONSTRAINT pk__games_categories PRIMARY KEY (`game_id` , `category_id`),
	CONSTRAINT fk__games_categories__games FOREIGN KEY (`game_id`)
		REFERENCES `games` (`id`),
	CONSTRAINT fk__games_categories__categories FOREIGN KEY (`category_id`)
		REFERENCES `categories` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the games table, based on the teams table. 
For all teams with id between 1 and 9 (both inclusive), insert data in the games table with the following values:
name: the name of the team but reversed all letters must be lower case omit the starting character of 
the team's name Example: Team name – Thiel -> leih
rating – set it to be equal to the team's id
budget – set it to be equal to the leader's id multiplied by 1000
team_id – set it to be equal to the team's id
*/
INSERT INTO `games` (`name`, `rating`, `budget`, `team_id`)
	(SELECT REVERSE(LOWER(SUBSTRING(`name`, 2))),
			`id`,
			`leader_id` * 1000,
			`id`
	FROM `teams`
	WHERE `id` BETWEEN 1 AND 9);
    
# 03. Update
/*
Update all young employees (only team leaders) with age under 40(exclusive) 
and increase their salary with 1000. 
Skip the employees with salary over 5000(inclusive). 
Their salaries are already high.
*/
SET SQL_SAFE_UPDATES = 0;
UPDATE `employees` AS e
	JOIN `teams` AS t 
	ON e.`id` = t.`leader_id`
SET `salary` = `salary` + 1000
WHERE `age` < 40 AND `salary` < 5000;

# 04. Delete
/* Delete all games from table games, which do not have a category and release date. */
DELETE FROM `games`
WHERE (`release_date` IS NULL) AND 
(`id` NOT IN (SELECT `game_id` FROM `games_categories`));

# 05. Employees
/*
Extract from the SoftUni Game Dev Branch (sgd) database, info about all the employees. 
Order the results by the employee's salary, then by their id.
*/
SELECT `first_name`,
		`last_name`,
		`age`,
		`salary`,
		`happiness_level`
FROM `employees`
ORDER BY `salary` , `id`;

# 06. Addresses of the teams
/*
Extract from the database all the team names and their addresses. 
Also display the count of the characters of the address names.
Skip those teams whose office does not have a website. 
Order the results by team names, then by the address names.
*/
SELECT  t.`name` AS 'team_name',
		a.`name` AS 'address_name',
		CHAR_LENGTH(a.`name`) AS 'count_of_characters'
FROM `teams` AS t
	JOIN `offices` AS o
	ON t.`office_id` = o.`id`
	JOIN `addresses` AS a 
	ON o.`address_id` = a.`id`
WHERE o.`website` IS NOT NULL
ORDER BY t.`name`, a.`name`;

# 07. Categories Info
/*
Select all categories names, count of the games from each category, 
the average budget (rounded to the second digit after the decimal point) of all games from the current category 
and the max rating of games from a category.
Order the result by count of games in descending order, then by the name of the category alphabetically. 
Skip categories with max r	ating lower than 9.5(exclusive).
*/
SELECT  c.`name`,
		COUNT(g.`id`) AS 'games_count',
		ROUND(AVG(g.`budget`), 2) AS 'avg_budget',
		MAX(g.`rating`) AS 'max_rating'
FROM `games` AS g
	JOIN `games_categories` AS gc
	ON g.`id` = gc.`game_id`
	JOIN `categories` AS c
	ON gc.`category_id` = c.`id` 
GROUP BY c.`id`
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC, c.`name` ASC;

# 08. Games of 2022
/*
Extract from the database all games that are being released in the year 2022. 
Also, the month must be even. We need only the first game sequel (ends with '…2'). 
We need the information of the game name, the game release date, 
a short summary (only the first 10 characters + '…') and the name of the team.
At last, a column ‘Quarters’ depends on the month of the release date:
January, February, and March (Q1)
April, May, and June (Q2)
July, August, and September (Q3)
October, November, and December (Q4)
Order by Quarters.
*/
SELECT  g.`name`,
		g.`release_date`,
		CONCAT(LEFT(g.`description`, 10), '...') AS 'summary',
		(CASE
		WHEN MONTH(g.`release_date`) = 1 OR 
		MONTH(g.`release_date`) = 2 OR 
		MONTH(g.`release_date`) = 3 
		THEN 'Q1'

		WHEN MONTH(g.`release_date`) = 4 OR 
		MONTH(g.`release_date`) = 5 OR 
		MONTH(g.`release_date`) = 6 
		THEN 'Q2'

		WHEN MONTH(g.`release_date`) = 7 OR 
		MONTH(g.`release_date`) = 8 OR 
		MONTH(g.`release_date`) = 9 
		THEN 'Q3'

		WHEN MONTH(g.`release_date`) = 10 OR 
		MONTH(g.`release_date`) = 11 OR 
		MONTH(g.`release_date`) = 12 
		THEN 'Q4'
		END) AS 'quarter',
       t.`name` AS 'team_name'
FROM `games` AS g
    JOIN `teams` AS t
    ON g.`team_id` = t.`id`
WHERE (YEAR(g.`release_date`) = '2022') AND (MONTH(g.`release_date`) % 2 = 0)
    AND g.`name` LIKE '%2'
 ORDER BY `quarter`;

# 09. Full info for games
/*
Our managers want to monitor all games that don’t have a release date nor a category. 
They want us to create a query, which shows the main information about the games. 
The information that they need is the name of the game, the name of the team, 
the name of the address and if the budget is less than 50000. 
If it is, we need to display 'Normal budget'. If it doesn’t - 'Insufficient budget'. 
Finally, we should order the result by the name of the game.
*/
SELECT  g.`name`,
		IF(g.`budget` < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
		t.`name` AS 'team_name',
		a.`name` AS 'address_name'
FROM `games` AS g
	JOIN `teams` AS t
	ON g.`team_id` = t.`id`
	JOIN `offices` AS o
	ON t.`office_id` = o.`id`
	JOIN `addresses` AS a
	ON o.`address_id` = a.`id`
WHERE (g.`release_date` IS NULL) AND 
(g.`id` NOT IN (SELECT `game_id` FROM `games_categories`))
ORDER BY g.`name`;

# 10. Find all basic information for a game
/*
Create a user defined function with the name udf_game_info_by_name (game_name VARCHAR (20)) 
that receives a game's name and returns the basic information as a text sentence.
Example: The "game_name" is developed by a "team_name" in an office 
with an address "address_text"
*/
DELIMITER $$
CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
RETURNS TEXT
DETERMINISTIC
BEGIN 
		DECLARE game_info TEXT;
		SET game_info :=   (SELECT CONCAT_WS(' ', 'The', g.`name`,'is developed by a', t.`name`, 'in an office with an address', a.`name`)
							FROM `games` AS g
								JOIN `teams` AS t ON g.`team_id` = t.`id`
								JOIN `offices` AS o ON t.`office_id` = o.`id`
								JOIN `addresses` AS a ON  o.`address_id` = a.`id`
							WHERE g.`name` = game_name);
	RETURN game_info;
END $$

SELECT udf_game_info_by_name('Bitwolf') AS info;

# 11. Update Budget of the Games
DELIMITER $$
CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN
	UPDATE `games`
	SET `budget` = `budget` + 100000,
		`release_date` = DATE_ADD(`release_date`, INTERVAL 1 YEAR)
	WHERE (`rating` > min_game_rating) 
	AND (`release_date` IS NOT NULL) 
	AND `id` NOT IN (SELECT `game_id` FROM `games_categories`);
END $$

CALL udp_update_budget (8);