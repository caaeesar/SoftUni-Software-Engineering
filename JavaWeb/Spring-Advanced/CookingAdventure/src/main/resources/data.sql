INSERT INTO `users` (`email`, `username`, `password`, `first_name`, `last_name`, `age`)
VALUES ('admin@example.com', 'admin', 'ad3d4bad59ab44454dc1ae55c46683090f295413aa0c7a33ad2566f339ec71ab4e49a2a0cc43d6742e735d033522c3a4', 'Admin', 'Adminov', 40),
       ('user2@example.com', 'user2', 'password2', 'Bob', 'Smith', 22),
       ('user3@example.com', 'user3', 'password3', 'Bob', 'Smith', 22),
       ('user4@example.com', 'user4', 'password4', 'Alice', 'Johnson', 28),
       ('user5@example.com', 'user5', 'password5', 'Charlie', 'Brown', 35),
       ('user6@example.com', 'user6', 'password6', 'David', 'Williams', 31),
       ('user7@example.com', 'user7', 'password7', 'Eva', 'Davis', 27),
       ('user8@example.com', 'user8', 'password8', 'Frank', 'Miller', 29),
       ('user9@example.com', 'user9', 'password9', 'Grace', 'Taylor', 33),
       ('user10@example.com', 'user10', 'password10', 'Henry', 'Clark', 26),
       ('user11@example.com', 'user11', 'password11', 'Ivy', 'Moore', 30),
       ('user12@example.com', 'user12', 'password12', 'Jack', 'Allen', 32),
       ('user13@example.com', 'user13', 'password13', 'Karen', 'Young', 28),
       ('user14@example.com', 'user14', 'password14', 'Leo', 'Jones', 29),
       ('user15@example.com', 'user15', 'password15', 'Mia', 'Turner', 31),
       ('user16@example.com', 'user16', 'password16', 'Nick', 'Parker', 34),
       ('user17@example.com', 'user17', 'password17', 'Olivia', 'White', 27),
       ('user18@example.com', 'user18', 'password18', 'Paul', 'Smith', 30),
       ('user19@example.com', 'user19', 'password19', 'Quinn', 'Lee', 29),
       ('user20@example.com', 'user20', 'password20', 'Rose', 'Hall', 25),
       ('user21@example.com', 'user21', 'password21', 'Sam', 'Ward', 32),
       ('user22@example.com', 'user22', 'password22', 'Tina', 'Baker', 31),
       ('user23@example.com', 'user23', 'password23', 'Ursula', 'Lopez', 28),
       ('user24@example.com', 'user24', 'password24', 'Victor', 'Fisher', 30),
       ('user25@example.com', 'user25', 'password25', 'Wendy', 'Cooper', 29),
       ('user26@example.com', 'user26', 'password26', 'Xavier', 'Hill', 33),
       ('user27@example.com', 'user27', 'password27', 'Yvonne', 'Morgan', 26),
       ('user28@example.com', 'user28', 'password28', 'Zack', 'Barnes', 28),
       ('user29@example.com', 'user29', 'password29', 'Ava', 'Wright', 30),
       ('user30@example.com', 'user30', 'password30', 'Ben', 'Garcia', 29);

INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (1,1);


INSERT INTO `recipes` (`title`, `description`, `image_url`, `preparation_time`, `category_id`, `author_id`)
VALUES ('Simple Spaghetti Fra Diavolo', 'Simple Spaghetti Fra Diavolo is a classic pasta dish you can make with just a handful of simple ingredients! You can make the spicy tomato sauce in about the time is takes to bring a large pot of water to boil. Then juice mix together the al dente pasta, pasta sauce, and fresh herbs.',
        'https://i.pinimg.com/564x/06/bc/a6/06bca6e31f180dd37f41a23502ec069e.jpg',
        '01:30:00',
        2,
        1),
       ('Kale Pesto Pizza', 'We’re continuing our weekly pizza tradition throughout the holidays.I feel like the holidays and pizza actually kind of go hand-in-hand? I remember staying up late, playing board games with my family, and ordering carryout pizza during the holiday season.Maybe it’s a nostalgic thing? Do you have any holiday pizza traditions? This pesto one looks tasty, and it’s red and green… which feels festive.',
        'https://i.pinimg.com/564x/a2/60/66/a26066cd2ba16c8e4d66ebee92e22510.jpg',
        '01:30:00',
        2,
        2),
       ('Fresh Apple Cake Recipe', 'This fresh apple cake recipe is perfectly spiced with chunks of real apple in each layer.Frosted with brown butter cream cheese frosting and a rich salted caramel drip. The perfect cake for fall. ',
        'https://i.pinimg.com/564x/7f/cf/ed/7fcfed29aa27442ef051fb712597643f.jpg',
        '01:30:00',
        3,
        3),
       ('Garlic Mushroom Chicken with Bacon', 'Garlic mushroom chicken with bacon. Imagine juicy chicken fillets simmered in a mouthwatering parmesan cream sauce, studded with earthy mushrooms and jazzed up with crispy bacon. ',
        'https://i.pinimg.com/564x/af/c7/bf/afc7bf20a434f1a36da05859f5e75c05.jpg',
        '01:30:00',
        2,
        4),
       ('Potatoes Gratin', 'Potatoes are one of my guilty pleasures… whether it’s a plate of crispy fries, or a huge serving of mashed potatoes,there is just something that is so irresistible about them!',
        'https://i.pinimg.com/564x/3d/27/f0/3d27f0cc1513bc7686e82690955c9929.jpg',
        '01:30:00',
        2,
        5),
       ('Strawberry Spinach Salad Recipe', 'Fresh salads are one of my favorite things about Spring and Summer. All the great produce options make epic salads possible.',
        'https://i.pinimg.com/564x/9a/6b/10/9a6b1019bf7fd4d4a9fb232bb40ff7cf.jpg',
        '01:30:00',
        5,
        6),
       ('Bacon Stuffed Pork', 'An impressive and equally delicious dinner recipe for special occasions and holidays! My Apple and Bacon Stuffed Pork Loin with pan-drippings gravy will be a hit with everyone at your next dinner party!',
        'https://i.pinimg.com/564x/e4/6b/a8/e46ba8f0d6f9236cf6a14dff8cf2dbe7.jpg',
        '01:30:00',
        2,
        7),
       ('Pesto Eggs', 'An impressive and equally delicious dinner recipe for special occasions and holidays! My Apple and Bacon Stuffed Pork Loin with pan-drippings gravy will be a hit with everyone at your next dinner party!',
        'https://i.pinimg.com/564x/60/68/55/60685526849e89b56c155794bf5ae9c5.jpg',
        '01:30:00',
        1,
        8),
       ('Creamy potato and pumpkin soup', 'An impressive and equally delicious dinner recipe for special occasions and holidays! My Apple and Bacon Stuffed Pork Loin with pan-drippings gravy will be a hit with everyone at your next dinner party!',
        'https://i.pinimg.com/564x/f8/59/50/f859500ebb00f4672778ff7c175afc1a.jpg',
        '01:30:00',
        1,
        9),
       ('Bacon Green Bean Bundles', 'Your guests will be so impressed when you serve them these beautiful and delicious bacon wrapped green beans.Skip the green bean casserole this year for Thanksgiving and serve green bean bundles instead!',
        'https://i.pinimg.com/564x/7b/ef/67/7bef675f841fc4fe66be229ab7872e63.jpg',
        '01:30:00',
        1,
        10);
