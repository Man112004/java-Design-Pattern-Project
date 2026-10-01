CREATE DATABASE songdb;

USE songdb;

CREATE TABLE uploaded_songs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    original_filename VARCHAR(255),
    file_path VARCHAR(500)
);