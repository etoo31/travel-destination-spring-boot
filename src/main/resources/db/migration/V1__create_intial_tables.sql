CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    type ENUM('user', 'admin') NOT NULL DEFAULT 'user',
    PRIMARY KEY (id)
);

CREATE TABLE approved_destination (
    country VARCHAR(255) NOT NULL,
    capital VARCHAR(255),
    region VARCHAR(255),
    population BIGINT,
    currency VARCHAR(100),
    flag VARCHAR(255),
    PRIMARY KEY (country)
);

CREATE TABLE favorite_destinations (
    user_id BIGINT NOT NULL,
    country VARCHAR(255) NOT NULL,
    capital VARCHAR(255),
    region VARCHAR(255),
    population BIGINT,
    currency VARCHAR(100),
    flag VARCHAR(255),
    PRIMARY KEY (user_id, country),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

