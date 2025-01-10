CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    user VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,

    primary key(id)
);