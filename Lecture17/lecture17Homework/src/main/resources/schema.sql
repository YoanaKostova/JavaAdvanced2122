CREATE TABLE IF NOT EXISTS firm (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    employees INT,
    city varchar(255)
);