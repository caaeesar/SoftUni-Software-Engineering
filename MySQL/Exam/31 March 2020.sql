CREATE DATABASE `instd`;

# 01. Table Design
CREATE TABLE `users` (
	`id` INT PRIMARY KEY,
	`username` VARCHAR(30) NOT NULL UNIQUE,
	`password` VARCHAR(30) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`gender` CHAR(1) NOT NULL,
	`age` INT NOT NULL,
	`job_title` VARCHAR(40) NOT NULL,
	`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`address` VARCHAR(30) NOT NULL,
	`town` VARCHAR(30) NOT NULL,
	`country` VARCHAR(30) NOT NULL,
	`user_id` INT NOT NULL,
	CONSTRAINT fk_addresses_users FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
);

CREATE TABLE `photos` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`description` TEXT NOT NULL,
	`date` DATETIME NOT NULL,
	`views` INT NOT NULL DEFAULT 0
);

CREATE TABLE `comments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`comment` VARCHAR(255) NOT NULL,
	`date` DATETIME NOT NULL,
	`photo_id` INT NOT NULL,
	CONSTRAINT fk_comments_photos FOREIGN KEY (`photo_id`)
		REFERENCES `photos` (`id`)
);

CREATE TABLE `users_photos` (
	`user_id` INT NOT NULL,
	`photo_id` INT NOT NULL,
	CONSTRAINT fk__users_photos__users FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`),
	CONSTRAINT fk__users_photos__photos FOREIGN KEY (`photo_id`)
		REFERENCES `photos` (`id`)
);

CREATE TABLE `likes` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`photo_id` INT,
	`user_id` INT,
	CONSTRAINT fk_likes_photos FOREIGN KEY (`photo_id`)
		REFERENCES `photos` (`id`),
	CONSTRAINT fk_likes_users FOREIGN KEY (`user_id`)
		REFERENCES `users` (`id`)
);

# 02. Insert
/*
You will have to insert records of data into the addresses table, based on the users table. 
For users with male gender, insert data in the addresses table with the following values:
address – set it to username of the user.
town – set it to password of the user.
country – set it to ip of the user. 
user_id – set it to age of the user. 
*/

INSERT INTO `addresses` (`address`, `town`, `country`, `user_id`)
	(SELECT `username`,
			`password`,
			`ip`,
			`age`
	FROM `users`
	WHERE `gender` = 'M');

# 03. Update
/*
Rename those countries, which meet the following conditions:
If the country name starts with 'B' – change it to 'Blocked'.
If the country name starts with 'T' – change it to 'Test'.
If the country name starts with 'P' – change it to 'In Progress'.
*/
UPDATE `addresses`
SET `country` = (CASE 
					WHEN `country` LIKE 'B%' THEN 'Blocked'
					WHEN `country` LIKE 'T%' THEN 'Test'
					WHEN `country` LIKE 'P%' THEN 'In Progress'
					ELSE ''	
				END);

# 04. Delete
/*
As you remember at the beginning of our work, we inserted and updated some data. 
Now you need to remove some addresses.	
Delete all addresses from table addresses, which id is divisible by 3.
*/
DELETE FROM `addresses`
WHERE `id` % 3 = 0;

# 05. Users
/*
Extract from the Insta Database (instd), info about all the users. 
Order the results by age descending then by username ascending.
*/
SELECT  `username`,
		`gender`,
		`age`
FROM `users`
ORDER BY `age` DESC, `username` ASC;

# 06. Extract 5 most commented photos
/*
Extract from the database, 5 most commented photos with their count of comments.
Sort the results by commentsCount, descending, then by id in ascending order.
*/
SELECT  p.`id`,
		p.`date`,
		p.`description`,
		COUNT(c.`id`) AS 'commentsCount'
FROM `photos` AS p
	JOIN `comments` AS c
	ON p.`id` = c.`photo_id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, p.`id` ASC
LIMIT 5;

# 07. Lucky users
/*
When the user has the same id as its photo, it is considered Lucky User. 
Extract from the database all lucky users. 
Extract id_username (concat id + " " + username) and email of all lucky users. 
Order the results ascending by user id.
*/
SELECT  CONCAT(u.`id`, ' ', u.`username`) AS 'id_username',
		u.`email`
FROM `users` AS u
	JOIN `users_photos` AS up 
	ON u.`id` = up.`user_id`
WHERE u.`id` = up.`photo_id`
ORDER BY u.`id`;

# 08. Count likes and comments 0/10
/*
Extract from the database, photos id with their likes and comments.
Order them by count of likes descending, then by comments count descending 
and lastly by photo id ascending.
*/
SELECT  ph.`id` AS 'photo_id',
		COUNT(l.`id`) AS 'likes_count',
		COUNT(c.`id`) AS 'comments_count'
FROM `comments` AS c
	JOIN `photos` AS ph
	ON ph.`id` = c.`photo_id`
	JOIN `likes` AS l
	ON ph.`id` = l.`photo_id`
GROUP BY ph.`id`
ORDER BY `likes_count` DESC, `comments_count` DESC, ph.`id` ASC ;

# 09. The photo on the tenth day of the month
/*
Extract from the database those photos that their upload day is 10 and summarize their description.
 The summary must be 30 symbols long plus "..." at the end.
 Order the results by date descending order.
*/
SELECT  CONCAT(LEFT(`description`, 30), '...') AS 'summary',
		`date`
FROM `photos`
WHERE DAY(`date`) = 10
ORDER BY `date` DESC;

# 10. Get user’s photos count
/*
Create a user defined function with the name udf_users_photos_count(username VARCHAR(30)) 
that receives a username and returns the number of photos this user has upload.
*/
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(up.`photo_id`) 
			FROM `users` AS u
				JOIN `users_photos` AS up
				ON u.`id` = up.`user_id`
			WHERE u.`username` = username
			GROUP BY up.`user_id`);
END $$

SELECT udf_users_photos_count('ssantryd') AS photosCount;

# 11. Increase user age
/*
Create a stored procedure udp_modify_user which accepts the following parameters: address, town 
udp_modify_user (address VARCHAR(30), town VARCHAR(30)) that receives an address and town 
and increase the age of the user by 10 years only if the given user exists.
*/
DELIMITER $$
CREATE PROCEDURE udp_modify_user(address VARCHAR(30), town VARCHAR(30))
BEGIN 
	UPDATE `users` AS u
		JOIN `addresses` AS a
		ON u.`id` = a.`user_id`
	SET `age` = `age` + 10
	WHERE a.`address` = address AND a.`town` = town;
END $$

CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';