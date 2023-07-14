create table halls
(
    id    bigint auto_increment,
    place int,
    primary key (id)
);

create table t_users
(
    id        bigint auto_increment,
    email     VARCHAR(255),
    password  VARCHAR(255),
    full_name VARCHAR(255),
    img_link  VARCHAR(255),
    balance   INT,
    primary key (id)
);

create table permission
(
    id   bigint auto_increment,
    role varchar(255),
    primary key (id)
);

create table t_events
(
    id           bigint auto_increment,
    event_name   VARCHAR(255),
    event_date   VARCHAR(255),
    author       VARCHAR(255),
    picture_link VARCHAR(255),
    hall_id      bigint,
    price        INT,
    status     VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (hall_id) REFERENCES halls (id)
);


create table comment
(
    id       bigint auto_increment,
    comment  varchar(255),
    event_id BIGINT,
    user_id  BIGINT,
    FOREIGN KEY (event_id) REFERENCES t_events (id),
    FOREIGN KEY (user_id) REFERENCES t_users (id),
    primary key (id)
);

create table tickets
(
    id                bigint auto_increment,
    event_id          BIGINT,
    user_id           BIGINT,
    prime_code_ticket BIGINT,
    place             INT,
    FOREIGN KEY (event_id) REFERENCES t_events (id),
    FOREIGN KEY (user_id) REFERENCES t_users (id),
    primary key (id)
);

CREATE TABLE t_users_permissions
(
    user_id       BIGINT,
    permissions_id BIGINT
);

ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_permission
        FOREIGN KEY (permissions_id) REFERENCES permission (id);

ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_users
        FOREIGN KEY (user_id) REFERENCES t_users (id);

