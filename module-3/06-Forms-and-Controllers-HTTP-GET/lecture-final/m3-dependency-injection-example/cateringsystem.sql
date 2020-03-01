DROP TABLE IF EXISTS inventory;

CREATE TABLE inventory (
        code char(2) primary key,
        name varchar(32) not null,
        price decimal not null,
        type char(1) not null 

);

INSERT INTO inventory (code, name, price, type) VALUES
        ('B1', 'SQL Soda', 3.50, 'B'),
        ('B2', 'Postgres Brew', 5.00, 'B'),
        ('A1', 'Database Fruit', 6.75, 'A'),
        ('A2', 'Table Bites', .85, 'A'),
        ('E1', 'Yummy Varchar', 8.45, 'E'),
        ('E2', 'Decimal Delicacy', 45.76, 'E'),
        ('D1', 'Chocolate Row', 2.80, 'D')
        ;