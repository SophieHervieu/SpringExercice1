DROP TABLE IF EXISTS livre;

CREATE TABLE livre (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
date_publication DATE NOT NULL
);

INSERT INTO livre (title, description, date_publication) VALUES
('Les Misérables', 'Saga de Victor Hugo', '1862-03-29');