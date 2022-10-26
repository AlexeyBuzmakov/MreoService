create sequence owner_table_sequence START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS owner_table
(
    owner_id       INT8 PRIMARY KEY DEFAULT nextval('owner_table_sequence'),
    owner_name           VARCHAR(30),
    owner_patronymic     VARCHAR(30),
    owner_surname        VARCHAR(30),
    driver_license VARCHAR(30)
);

INSERT INTO owner_table (owner_name, owner_patronymic, owner_surname, driver_license)
VALUES ('Alexey', 'Mihaylovich', 'Dulov', 'YH543UVF'),
       ('Mihail', 'Petrovich', 'Zabolotnyi', 'BS710JJQ'),
       ('Ivan', 'Nikolaevich', 'Topolev', 'GQ901HTQ'),
       ('Sergey', 'Alexeevich', 'Laptev', 'BG052LQA'),
       ('Nikita', 'Ivanovich', 'Rebrov', 'OQ110NAR'),
       ('Petr', 'Milaylovich', 'Kisov', 'LQ051BAR'),
       ('Lubov', 'Viktorovna', 'Mamonova', 'NS660LZV'),
       ('Alena', 'Nikolaevna', 'Ponikarova', 'NN667MWE');

create sequence car_table_sequence START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS car_table
(
    car_id     INT8 PRIMARY KEY DEFAULT nextval('car_table_sequence'),
    brand      VARCHAR(30),
    model      VARCHAR(30),
    year_issue INT,
    vin_number VARCHAR(30),
    number_car     VARCHAR(30),
    owner_id   INT8             NOT NULL REFERENCES owner_table (owner_id)
);

INSERT INTO car_table (brand, model, year_issue, vin_number, number_car, owner_id)
VALUES ('Toyota', 'Crown', 1978, '65YHG872TGR', 'T791OH', 1),
       ('BWM', 'X5', 2016, '29KUH713UOC', 'H052UB', 5),
       ('Honda', 'CR-V', 2019, '92TNX026QPB', 'N266PQ', 8),
       ('Lexus', 'IS200', 2020, '45UQT682OQC', 'B027HQ', 3),
       ('Vaz', '2114', 1998, '90YFG116OPT', 'G102OL', 1),
       ('Porsche', '911', 2018, '53YVB562UGX', 'Z775HD', 5),
       ('Mercedes', 'CLS', 2021, '87VSP055ZYS', 'J050AS', 4),
       ('Renault', 'Logan', 2007, '27YWB551LAQ', 'M913CQ', 6),
       ('Skoda', 'Rapid', 2011, '02HAM820ZQP', 'HB780PS', 7),
       ('Chevrolet', 'Cruze', 2012, '75UTG077VQA', 'D053VX', 3);