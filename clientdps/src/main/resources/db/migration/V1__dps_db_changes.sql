create sequence type_penalty_table_sequence START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS type_penalty_table
(
    id         INT8 PRIMARY KEY DEFAULT nextval('type_penalty_table_sequence'),
    type_penalty       VARCHAR(30),
    punishment_penalty INT4
);

INSERT INTO type_penalty_table(type_penalty, punishment_penalty)
VALUES ('Over_speed', 500),
       ('Exit_into_the_opposite_lane', 1000),
       ('Driving_without_license', 1000),
       ('Drunk_driving', 3000),
       ('Driving_on_red', 2000),
       ('Driving_without_insurance', 500),
       ('Safety_belt', 500);

create sequence hijacking_table_sequence START 1 INCREMENT 1;

CREATE TABLE hijacking_table
(
    hijacking_id   INT8 PRIMARY KEY DEFAULT nextval('hijacking_table_sequence'),
    vin_number     VARCHAR(30),
    date_hijacking DATE             NOT NULL,
    date_find      DATE
);

INSERT INTO hijacking_table(vin_number, date_hijacking, date_find)
VALUES ('53YVB562UGX', '2018-04-30', NULL),
       ('92TNX026QPB', '2020-09-13', '2022-01-29'),
       ('27YWB551LAQ', '2021-02-11', '2021-07-25'),
       ('65YHG872TGR', '2019-07-13', '2020-11-01'),
       ('45UQT682OQC', '2021-04-10', NULL);

create sequence penalty_table_sequence START 1 INCREMENT 1;

CREATE TABLE penalty_table
(
    car_id       INT8 PRIMARY KEY DEFAULT nextval('penalty_table_sequence'),
    number_car   VARCHAR(30),
    date_penalty DATE,
    penalty_id   INT8             NOT NULL REFERENCES type_penalty_table (id)
);

INSERT INTO penalty_table(number_car, date_penalty, penalty_id)
VALUES ('N266PQ', '2021-06-27', 2),
       ('J050AS', '2022-02-13', 5),
       ('D053VX', '2021-08-21', 4),
       ('N266PQ', '2022-08-05', 1),
       ('G102OL', '2020-06-29', 7),
       ('B027HQ', '2022-02-19', 3),
       ('J050AS', '2021-10-15', 5),
       ('G102OL', '2022-01-30', 6);