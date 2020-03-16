DROP TABLE IF EXISTS groceries;

CREATE TABLE groceries (
        id serial primary key,
        name varchar(255) not null,
        completed boolean default false
);

INSERT INTO groceries (name) VALUES ('Bread'), ('Ducklings'), ('Duct Tape'), ('Toothpaste'), ('Chicken Wire'), ('Tiara'), ('Normal Milk'), ('Apples'), ('Shovel'), ('Kitten');

