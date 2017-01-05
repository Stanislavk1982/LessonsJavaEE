CREATE TABLE company
(
    id INT(11) PRIMARY KEY NOT NULL,
    description VARCHAR(35)
);
CREATE TABLE users
(
    id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(25),
    surname VARCHAR(35),
    company_id INT(11) NOT NULL,
    CONSTRAINT users_ibfk_1 FOREIGN KEY (company_id) REFERENCES company (id)
);
CREATE INDEX company_id ON users (company_id);