CREATE TABLE halls (
    id SERIAL PRIMARY KEY ,
    place INT
);
CREATE TABLE t_permissions (
    id SERIAL PRIMARY KEY ,
    role VARCHAR(255)
);

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    event_name VARCHAR(255),
    event_date VARCHAR(255),
    author VARCHAR(255),
    picture_link VARCHAR(255),
    hall_id INT,
    price INT,
    status VARCHAR(255),
    FOREIGN KEY (hall_id) REFERENCES halls (id)
);

CREATE TABLE t_users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    full_name VARCHAR(255),
    img_link VARCHAR(255),
    balance INT
);

CREATE TABLE comment (
                         id SERIAL PRIMARY KEY,
                         comment VARCHAR(255),
                         event_id BIGINT,
                         user_id BIGINT,
                         FOREIGN KEY (event_id) REFERENCES events (id),
                         FOREIGN KEY (user_id) REFERENCES t_users (id)
);

CREATE TABLE tickets (
    id SERIAL PRIMARY KEY ,
    event_id BIGINT,
    user_id BIGINT,
    prime_code_ticket BIGINT,
    place INT,
    FOREIGN KEY (event_id) REFERENCES events (id),
    FOREIGN KEY (user_id) REFERENCES t_users (id)
);

CREATE TABLE t_users_permissions(
                         userId BIGINT,
                         permissionId BIGINT,
                         FOREIGN KEY (userId) REFERENCES t_users (id),
                         FOREIGN KEY (permissionId) REFERENCES t_permissions (id)
  );