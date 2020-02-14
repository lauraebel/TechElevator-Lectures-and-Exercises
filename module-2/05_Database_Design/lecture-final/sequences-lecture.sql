-- RUN in sequences Database:  createdb -U postgres sequences

-- DROP THE TABLE IF IT EXISTS
DROP TABLE IF EXISTS ourtable;

-- Create a Table with a sequence as the primary key
CREATE TABLE ourtable (
        id serial primary key,
        name varchar(10)
        );

 SELECT * FROM ourtable;
  
-- Get the next value of the sequence
SELECT nextval('ourtable_id_seq');

-- Create a sequence that starts at 101 instead of 1
CREATE SEQUENCE our_custom_sequence START 101;

-- Get the next value from the new sequence
SELECT nextval('our_custom_sequence')

-- Alter the Sequence to restart at 1000 and increment by 2
ALTER SEQUENCE our_custom_sequence RESTART 1000 INCREMENT BY 2;

-- Drop the custom Sequence
DROP SEQUENCE our_custom_sequence;

-- Insert into the table with a sequence using nextval() in a subquery
INSERT INTO ourtable (id, name) VALUES ((SELECT nextval('ourtable_id_seq')), 'Steve');

-- Insert into the table with a sequence using DEFAULT to populate the sequence
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Andrew');

-- Insert into the table with a sequence by omitting the column in the Insert
 INSERT INTO ourtable (name) VALUES ('John');

-- Insert into the table with a sequence with a manual value  (CHANGE XX to the next correct value)
INSERT INTO ourtable (id, name) VALUES (XX, 'Stephanie');

-- Try to insert another value using DEFAULT or a SubQuery or by Omitting the column in the insert
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Rachelle');

-- inserting into a table in a Transaction with a ROLLBACK
START TRANSACTION;
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Carson');
ROLLBACK;

-- Insert another value into the table and check the sequence
INSERT INTO ourtable (id, name) VALUES (DEFAULT, 'Carson');

-- Drop the table, what happens to the sequence that was automatically created for it?
DROP TABLE ourtable;
