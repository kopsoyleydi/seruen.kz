-- Вставка данных в таблицу t_permission
INSERT INTO halls (place)
VALUES (30),
       (30);
INSERT INTO t_permission (role)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
INSERT INTO t_users (balance, email, full_name, img_link, password)
VALUES (2500, 'beksultan004@bk.ru', 'Bexultan Kuralbay',
        'https://yt3.ggpht.com/a/AGF-l78RCnBXwItPz7NOMEmGVDdZ6Qaoss63865a8Q=s900-c-k-c0xffffffff-no-rj-mo',
        '$2a$10$AsRbNptKvBm3O/CataL/e.Q3BfmG21ftyk57GvzHMz/O5asbgc8I6'),
       (0, 'omyrzakovbeksultan1@gmail.com', 'beks beks',
        'https://yt3.ggpht.com/a/AGF-l78RCnBXwItPz7NOMEmGVDdZ6Qaoss63865a8Q=s900-c-k-c0xffffffff-no-rj-mo',
        '$2a$10$s/NlhDEwWVArROg1.9YOLu/B2pp3EUkyhMaH9S3C/OzHUzplwhsMO');

INSERT INTO t_users_permissions(user_id, permissions_id)
VALUES (1, 2),
       (1, 1),
       (2, 1);
INSERT INTO events (event_name, author, event_date, picture_link, price, status, hall_id)
VALUES ('Meloman', 'Cinema', '2023-07-06',
        'https://cdn.kino.kz/movies/Indiana_Jones_and_the_Dial_of_Destiny/p168x242.jpg', 2500, true, 2);




