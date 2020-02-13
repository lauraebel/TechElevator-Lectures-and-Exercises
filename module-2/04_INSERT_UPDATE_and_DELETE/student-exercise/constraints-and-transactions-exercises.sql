-- Write queries to return the following: (applied to the "dvdstore" database)

-- 1. Add actors Hampton Avenue and Lisa Byway to the actor table.
INSERT INTO actor VALUES (201, 'HAMPTON', 'AVENUE');
INSERT INTO actor VALUES (202, 'LISA', 'BYWAY');

SELECT * FROM actor;

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in ancient Greece", to the film table. 
-- The movie was released in 2008 in English. Since it's an epic, the run length is 3hrs and 18mins. There are no 
-- special features, the film speaks for itself and doesn't need any gimmicks.
INSERT INTO film (title, description, release_year, language_id, length) VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece',
2008, 1, 198); 

SELECT * FROM film WHERE title = 'EUCLIDEAN PI';

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly overprotective mother, in the film, 
-- "Euclidean PI". Add them to the film.
INSERT INTO film_actor VALUES (201, 1001);
INSERT INTO film_actor VALUES (202, 1001);

SELECT * FROM film_actor WHERE film_id = 1001;

-- 4. Add Mathmagical to the category table.
INSERT INTO category (name) VALUES ('Mathmagical');

SELECT * FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", "EGG IGBY", "KARATE MOON", 
-- "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO film_category VALUES (274, 17); 
INSERT INTO film_category VALUES (494, 17); 
INSERT INTO film_category VALUES (714, 17); 
INSERT INTO film_category VALUES (996, 17); 
INSERT INTO film_category VALUES (1001, 17); 


SELECT * FROM film_category WHERE category_id = 17;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films accordingly.
-- (5 rows affected)
START TRANSACTION;
COMMIT;
UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = 17);

-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory (film_id, store_id) VALUES (1001, 1);
INSERT INTO inventory (film_id, store_id) VALUES (1001, 2);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, "Euclidean PI". The film has been 
-- seized from all stores, and needs to be deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
DELETE FROM film
WHERE title = 'EUCLIDEAN PI';
--FAILED- violates foreign key constraint because its film_id is used on film_actor

-- 9. Delete Mathmagical from the category table. (Did it succeed? Why?)
DELETE FROM category
WHERE name = 'Mathmagical';
--FAILED- violates foreign key constraint because its category_id is used on film_category

-- 10. Delete all links to Mathmagical in the film_category table. (Did it succeed? Why?)
DELETE FROM film_category
WHERE category_id = 17;
-- SUCCEEDED- the category_id still exists but is not currently assigned to any film_id

-- 11. Retry deleting Mathmagical from the category table, followed by retrying to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
DELETE FROM category
WHERE name = 'Mathmagical';
--SUCCEEDED- the category_id for Mathmagical is not assigned to anything else so can be deleted without causing orphan data

DELETE FROM film
WHERE title = 'EUCLIDEAN PI';
--FAILED- violates foreign key constraint because its film_id is still used on film_actor





