CREATE  TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    autor VARCHAR(200) NOT NULL,
    titulo  VARCHAR(300) NOT NULL UNIQUE,
    mensaje VARCHAR(300) NOT NULL UNIQUE,
    curso VARCHAR(200) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,

    PRIMARY KEY(id)
    
);