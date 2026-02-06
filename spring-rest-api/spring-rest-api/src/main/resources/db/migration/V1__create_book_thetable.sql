CREATE TABLE book (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      author VARCHAR(100) NOT NULL,
                      price DOUBLE NOT NULL,
                      publisher VARCHAR(80) NOT NULL,
                      title VARCHAR(80) NOT NULL,
                      PRIMARY KEY (id)
);