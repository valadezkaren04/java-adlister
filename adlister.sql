CREATE DATABASE adlister_db;
# CREATE USER 'chimmy'@'localhost' IDENTIFIED BY 'chimmy123';
#
# GRANT ALL ON adlister_db.* TO 'chimmy'@'localhost';
USE adlister_db;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(200),
    email VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR (30) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

INSERT INTO users (username, email, password) VALUES (1, 'koya', 'koya@email.com', 'koya123');



