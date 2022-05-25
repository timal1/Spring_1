create table if not exists products (
    id bigserial primary key,
    title varchar(255),
    price double precision
);

create table if not exists users (
    id bigserial primary key,
    username varchar(50) not null ,
    password varchar(255),
    email varchar(50) unique
);

create table if not exists roles (
    id serial primary key,
    name varchar(50) not null
);

create table if not exists authorities (
    id serial primary key,
    name varchar(50) not null
);

create table if not exists users_roles (
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table if not exists roles_authorities (
    role_id int not null,
    authority_id int not null,
    primary key (role_id, authority_id),
    foreign key (role_id) references roles (id),
    foreign key (authority_id) references authorities (id)
);

insert into products (title, price) values ('пальто', 200), ('брюки', 50),
                                           ('ботинки', 100), ('куртка', 150),
                                           ('рубашка', 40), ('платье', 75),
                                           ('туфли', 80), ('носки', 5),
                                           ('кофта', 35), ('шарф', 10),
                                           ('футболка', 20), ('шапка', 25),
                                           ('плащ', 170), ('майка', 10),
                                           ('перчатки', 15), ('шорты', 20),
                                           ('галстук', 10), ('сапоги', 60),
                                           ('юбка', 55), ('блузка', 45);

insert into users (username, password, email) values ('Макс', '$2a$12$bxsUv8diiUMbh6v9kteb4eU5wHDwfiZCinje0/lsumm3opjEzLqNO', 'max@gmail.com'),
--                                                              password 100
                                                     ('Иван', '$2a$12$D09ANPAG9LHiY.Wz98ExLem.UV4a4CShTsjgMuKGLJE68cT36VKFK', 'ivan@gmail.com'),
--                                                              password 200
                                                     ('Анна', '$2a$12$2vd4Q0KOzW00offp1l/pueV2A1x5Q2FPqG3sn4kOx4pxrjKpOs9Pe', 'anna@gmail.com'),
--                                                              password 300
                                                     ('Егор', '$2a$12$8E2Ol6kZEtarGmx1.LXQ1ubb.uQ5/B7vtcmIJa8UsIA8.I/oZI/Ma', 'egor@gmail.com');
--                                                              password 400

insert into roles (name) values ('ROLE_SUPERADMIN'), ('ROLE_ADMIN'), ('ROLE_MANAGER'), ('ROLE_USER');

insert into authorities (name) values ('READ'), ('READ_WRITE');

insert into users_roles (user_id, role_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (2, 2), (2, 4), (3, 3), (3, 4), (4, 4);

insert into roles_authorities (role_id, authority_id) VALUES (1, 2), (2, 2), (3, 2), (4, 1);




