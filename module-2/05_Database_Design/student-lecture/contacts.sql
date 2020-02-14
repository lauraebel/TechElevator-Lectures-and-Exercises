DROP TABLE IF EXISTS person_contact_info;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS contact_info;
DROP TABLE IF EXISTS address;


CREATE TABLE person (
        person_id serial primary key,
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        date_of_birth date
);

CREATE TABLE contact_info (
        contact_id serial primary key,
        contact_type varchar(10),
        contact_method varchar(20) not null,
        contact varchar(255) not null,
        contact_method_other varchar(64), 
        
        constraint chk_contact_type check (contact_type IN ('Home', 'Work', 'Mobile', 'Other')),
        constraint chk_contact_method check (contact_method IN ('Email', 'Phone', 'Other')),
        constraint chk_contact_method_other check 
          ((contact_method = 'Other' AND contact_method_other IS NOT NULL)
        OR (contact_method <> 'Other' AND contact_method_other IS NULL))
);

CREATE TABLE person_contact_info (
        person_id int,
        contact_id int,
        
        constraint fk_person_person_id foreign key (person_id) references person(person_id),
        constraint fk_contact_info_id foreign key (contact_id) references contact_info(contact_id),
        PRIMARY KEY (person_id, contact_id)
);

CREATE TABLE address (
        address_id serial primary key,
        street_line_one varchar(64) not null,
        street_line_two varchar(64) not null,
        city varchar(128) not null,
        district varchar(30) not null,
        postalcode varchar(20) not null,
        country char(3) DEFAULT 'USA' not null,
        type varchar(15) not null
        
        constraint chk_type check (type IN('Billing', 'Shipping', 'Work', 'Home', 'Other'))
);

CREATE TABLE person_address (
        person_id int,
        address_id int,
        
        PRIMARY KEY(person_id, address_id),
        constraint fk_address_person_id foreign key (person_id) references person(person_id),
        constraint fk_address_id foreign key (address_id) references address(address_id)
);















