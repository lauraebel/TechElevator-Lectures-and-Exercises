DROP TABLE IF EXISTS trips;

CREATE TABLE trips (
        id serial primary key,
        name varchar(255) not null,
        description varchar(255),
        start_date Date,
        end_date Date,
        miles int,
        type varchar(10)
 );
        