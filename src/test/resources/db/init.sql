CREATE SCHEMA IF NOT EXISTS examTest
DEFAULT CHARACTER SET utf8
COLLATE utf8_hungarian_ci;
CREATE USER webshop_User@localhost
IDENTIFIED BY 'training';
GRANT ALL ON examTest.* TO webshop_User@localhost;
USE examTest;