USE adlister_db;


DROP TABLE IF EXISTS users;

CREATE TABLE users (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        username VARCHAR(50) NOT NULL,
                        name VARCHAR (50) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        PRIMARY KEY (id)
);
