CREATE DATABASE `softuni_imdb`;

# 01. Table Design
CREATE TABLE `countries` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE,
	`continent` VARCHAR(30) NOT NULL,
	`currency` VARCHAR(5) NOT NULL
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE `actors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`birthdate` DATE NOT NULL,
	`height` INT,
	`awards` INT,
	`country_id` INT NOT NULL,
	CONSTRAINT fk_actors_countries FOREIGN KEY (`country_id`)
		REFERENCES `countries` (`id`)
);

CREATE TABLE `movies_additional_info` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`rating` DECIMAL(10 , 2 ) NOT NULL,
	`runtime` INT NOT NULL,
	`picture_url` VARCHAR(80) NOT NULL,
	`budget` DECIMAL(10 , 2 ),
	`release_date` DATE NOT NULL,
	`has_subtitles` TINYINT(1),
	`description` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(70) NOT NULL UNIQUE,
	`country_id` INT NOT NULL,
	`movie_info_id` INT NOT NULL UNIQUE,
	CONSTRAINT fk_movies_countries FOREIGN KEY (`country_id`)
		REFERENCES `countries` (`id`),
	CONSTRAINT fk__movies__movies_additional_info FOREIGN KEY (`movie_info_id`)
		REFERENCES `movies_additional_info` (`id`)
);

CREATE TABLE `movies_actors` (
	`movie_id` INT,
	`actor_id` INT,
	CONSTRAINT fk__movies_actors__movies FOREIGN KEY (`movie_id`)
		REFERENCES `movies` (`id`),
	CONSTRAINT fk__movies_actors__actors FOREIGN KEY (`actor_id`)
		REFERENCES `actors` (`id`)
);

CREATE TABLE `genres_movies` (
	`genre_id` INT,
	`movie_id` INT,
	CONSTRAINT fk__genres_movies__genres FOREIGN KEY (`genre_id`)
		REFERENCES `genres` (`id`),
	CONSTRAINT fk__genres_movies__movies FOREIGN KEY (`movie_id`)
		REFERENCES `movies` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the actors table.
The new data will be based on actors with id equal or less than 10. 
Insert data in the actors table with the following values:
•	first_name – set it to the first name of the actor but reversed.
•	last_name – set it to the last name of the actor but reversed.
•	birthdate – set it to the birthdate of the actor but 2 days earlier.
•	height – set it to the height of the actor plus 10.
•	awards – set them to the country_id.
•	country_id – set it to the id of Armenia
*/
INSERT INTO `actors` (`first_name`, `last_name`, `birthdate`, `height`, `awards`, `country_id`)
	(SELECT REVERSE(`first_name`),
            REVERSE(`last_name`),
			DATE_SUB(`birthdate`, INTERVAL 2 DAY),
			`height` + 10,
			`country_id`,
			3 -- id of Armenia
	FROM `actors`
	WHERE `id` <= 10);
    
# 03. Update
/*
Reduce all movies runtime by 10 minutes for movies with movies_additional_info id equal to 
or greater than 15 and less than 25 (inclusive).
*/
UPDATE `movies_additional_info` 
SET `runtime` = `runtime` - 10
WHERE `id` BETWEEN 15 AND 25;

# 04. Delete
/* Delete all countries that don’t have movies. */
DELETE FROM `countries`
WHERE `id` NOT IN (SELECT `country_id` FROM `movies`);

# 05. Countries
/*
Extract from the softuni_imdb system database, info about the name of countries.
Order the results by currency in descending order and then by id.
*/
SELECT * FROM `countries`
ORDER BY `currency` DESC, `id`;

# 06. Old movies
/*
Write a query that returns: title, runtime, budget and release_date from table movies_additional_info. 
Filter movies which have been released from 1996 to 1999 year (inclusive).
Order the results ascending by runtime then by id and show only the first 20 results.
*/
SELECT mm.`id`, m.`title`, mm.`runtime`, mm.`budget`, mm.`release_date`
FROM `movies_additional_info` AS mm
		JOIN `movies` AS m 
		ON m.`movie_info_id` = mm.`id`
WHERE YEAR(`release_date`) BETWEEN '1996' AND '1999'
ORDER BY mm.`runtime` ASC, mm.`id` ASC
LIMIT 20;

# 07. Movie casting
/*
Write a query that returns:  full name, email, age and height for all actors that are not participating in a movie.
To find their email you must take their last name reversed 
followed by the number of characters of their last name and then the casting email “@cast.com”
Order by height in ascending order.
*/
SELECT  CONCAT(a.`first_name`, ' ', a.`last_name`) AS 'full_name',
		CONCAT(REVERSE(a.`last_name`), CHAR_LENGTH(a.`last_name`), '@cast.com') AS 'email',
		(/*YEAR(NOW())*/ 2022 - YEAR(a.`birthdate`)) AS 'age',
		a.`height`
FROM `actors` AS a
WHERE `id` NOT IN (SELECT `actor_id` FROM `movies_actors`)
ORDER BY a.`height` ASC;

# 08. International festival
/*
Extract from the database, the name the country and the number of movies created in this country. 
The number of movies must be higher or equal to 7.
Order the results descending by name.
*/
SELECT  c.`name`, 
		COUNT(m.`id`) AS 'movies_count'
FROM `countries` AS c
	JOIN `movies` AS m 
	ON c.`id` = m.`country_id`
GROUP BY c.`name`
HAVING `movies_count` >= 7
ORDER BY c.`name` DESC;

# 09. Rating system
/*
From the database extract the title, rating, subtitles, and the budget of movies. 
If the rating is equal or less than 4 the user must see “poor”, above 4 and less or equal to 7 “good” and above that it should display “excellent”. 
If the movie has subtitles the user should see “english”, otherwise “-“.
Order the results descending by budget.
*/
SELECT m.`title`,
		(CASE
		WHEN m2.`rating` <= 4 THEN 'poor'
		WHEN m2.`rating` > 4 AND m2.`rating` <= 7 THEN 'good'
		WHEN m2.`rating` > 7 THEN 'excellent'
		END ) AS 'rating',
		IF(m2.`has_subtitles` IS TRUE, 'english', '-') AS 'subtitles',
		m2.`budget`
FROM `movies` AS m
	JOIN `movies_additional_info` AS m2 
	ON m.`movie_info_id` = m2.`id`
ORDER BY m2.`budget` DESC;

# 10. History movies
/*
Create a user defined function with the name udf_actor_history_movies_count(full_name VARCHAR(50)) 
that receives an actor’s full name and returns the total number of history movies in which the actor has a role.
*/
DELIMITER $$
CREATE FUNCTION `udf_actor_history_movies_count`(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
		DECLARE `movies_count` INT;
		SET `movies_count` :=  (SELECT COUNT(m.`id`)
								FROM `actors` AS a
									JOIN `movies_actors` AS ma 
									ON a.`id` = ma.`actor_id` 
									JOIN `movies` AS m
									ON ma.`movie_id` = m.`id`
									JOIN `genres_movies` AS gm
									ON m.`id` = gm.`movie_id`
									JOIN `genres` AS g 
									ON gm.`genre_id` = g.`id`
								WHERE (g.`name` = 'History') AND (CONCAT(a.`first_name`,' ',a.`last_name`) = full_name)
								GROUP BY a.`id`);

	RETURN `movies_count`;
END$$

SELECT udf_actor_history_movies_count('Stephan Lundberg') AS 'history_movies';
SELECT udf_actor_history_movies_count('Jared Di Batista') AS 'history_movies';

# 11. Movie awards
/*
Create a stored procedure udp_award_movie which accepts the following parameters: movie_title(VARCHAR(50))
Extracts data about the movie with the given title and find all actors that play in it and increase their awards with 1.
*/

DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
		UPDATE `actors`
		SET `awards` = `awards` + 1
		WHERE `id` IN (SELECT ma.`actor_id` 
							FROM `movies_actors` AS ma
								JOIN `movies` AS m 
								ON ma.`movie_id` = m.`id`
							WHERE m.`title` = movie_title);
END$$

CALL udp_award_movie('Tea For Two');