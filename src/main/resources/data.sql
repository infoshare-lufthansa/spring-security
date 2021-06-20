insert into order_user(id, age, email, role, password)
values (1, 25, 'user@example.com', 'ROLE_USER', '{bcrypt}$2a$10$PUKDkwqFaEfk/TXSJrJgj.PpeWT1635CVFDRuQt6BaMBAmr.nODCO'),
       (2, 28, 'admin@example.com', 'ROLE_ADMIN','{bcrypt}$2a$10$U2dvbLiWlq7.CEi6cfd3EuOc/QgrxkD9PNpIn4TYF/fa/ZMjue1Xq');

insert into orders(id, type, size, comment)
values (3, 'Prowansalska', 'medium', ''),
       (4, 'Margharita', 'small', 'z pieczarkami'),
       (5, 'Wegeteriańska', 'large', ''),
       (6, 'Truflowa', 'medium', 'Nie kroić');