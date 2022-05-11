create table if not exists products
(id bigint primary key, title varchar(255), coast double precision);

create table if not exists customers
(id bigint primary key, name varchar(255));

create table if not exists orders
(id bigint primary key, customer_id bigint, product_id bigint, order_amount double precision, order_date date);

insert into customers (id, name) values (1, 'Максим'), (2, 'Егор'), (3, 'Светлана');

insert into orders (id, customer_id, product_id, order_amount) values
(1, 1, 2, 50), (2, 1, 1, 200), (3, 3, 6, 75), (4, 2, 7, 80);

insert into products (id, title, coast) values (1, 'пальто', 200), (2, 'брюки', 50),
                                           (3, 'ботинки', 100), (4, 'куртка', 150),
                                           (5, 'рубашка', 40), (6, 'платье', 75),
                                           (7, 'туфли', 80), (8, 'носки', 5),
                                           (9, 'кофта', 35), (10, 'шарф', 10),
                                           (11, 'футболка', 20), (12, 'шапка', 25),
                                           (13, 'плащ', 170), (14, 'майка', 10),
                                           (15, 'перчатки', 15), (16, 'шорты', 20),
                                           (17, 'галстук', 10), (18, 'сапоги', 60),
                                           (19, 'юбка', 55), (20, 'блузка', 45);





