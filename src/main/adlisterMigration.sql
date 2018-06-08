USE adlister_db;

CREATE TABLE users (
  id INT unsigned NOT NULL AUTO_INCREMENT,
  username VARCHAR (50),
  email VARCHAR(50),
  password VARCHAR (100),
  PRIMARY KEY (id)
)