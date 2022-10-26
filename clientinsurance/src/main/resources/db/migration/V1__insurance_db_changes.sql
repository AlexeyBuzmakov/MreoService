create sequence insurance_table_sequence START 1 INCREMENT 1;

CREATE TABLE insurance_table
(
    client_id  INT8 PRIMARY KEY DEFAULT nextval('insurance_table_sequence'),
    number_insurance     VARCHAR(30),
    date_start DATE,
    date_end DATE,
    number_car VARCHAR(30)
);

INSERT INTO insurance_table(number_insurance, date_start, date_end, number_car)
VALUES ('HGYQH87301UHY', '2021-05-12', '2024-05-12', 'T791OH'),
       ('PQOBG70271NQT', '2018-01-17', '2021-01-17', 'H052UB'),
       ('OTVQP90628MWX', '2020-09-15', '2023-09-15', 'N266PQ'),
       ('VDTSW90290XWW', '2019-05-21', '2022-05-21', 'B027HQ'),
       ('HBVFW71105OPH', '2020-08-04', '2023-08-04', 'G102OL'),
       ('OOGZX00251BWF', '2018-08-25', '2021-08-25', 'Z775HD'),
       ('BGWQP87044VCF', '2019-04-17', '2022-04-17', 'J050AS'),
       ('BHFYW78134OIU', '2020-02-27', '2023-02-27', 'M913CQ'),
       ('HYGTF90521GTT', '2017-09-07', '2020-09-07', 'B780PS'),
       ('POIZX81055UTW', '2020-09-19', '2023-09-19', 'D053VX');