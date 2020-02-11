-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT population FROM country
ORDER BY population DESC;

--Names of countries and continents in ascending order
SELECT name, continent
FROM country 
ORDER BY continent, name;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;

-- The 10 largest countries in the world
SELECT *
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

-- DISTINCT
-- Show only the specific continent names
SELECT DISTINCT continent FROM country;


SELECT 2+2;
SELECT 6/2;
SELECT 6%2;
SELECT round(gnp/population, 4) FROM country WHERE gnp > 0;

-- CONCATENATING OUTPUTS
SELECT 'test'|| ' '||' concatenate';

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT (name || ' ,'||district) AS nameandstate
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG (lifeexpectancy)
FROM country;

-- Total population in Ohio
SELECT SUM(population)
FROM city
WHERE district = 'Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea)
FROM country;

-- The number of countries who declared independence in 1991
SELECT COUNT(*)
FROM country
WHERE indepyear = 1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) AS countries
FROM countrylanguage
GROUP BY language
ORDER BY countries DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) AS avglife
FROM country
GROUP BY continent
ORDER BY avglife DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) AS avglife
FROM country
WHERE continent != 'Antarctica'
GROUP BY continent
ORDER BY avglife DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district;

-- The average population of cities in each state in the USA ordered by state name
SELECT district, AVG(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- SUBQUERIES
-- Find the names of cities in Europe with gnp > 1 mil
SELECT code
FROM country
WHERE continent = 'Europe' AND gnp > 1000000;

SELECT *
FROM city
WHERE countrycode IN('GBR', 'ITA', 'FRA', 'DEU');

SELECT *
FROM city
WHERE countrycode IN(SELECT code FROM country WHERE continent = 'Europe' AND gnp > 1000000);

-- Find the names of cities under a given government leader
SELECT code
FROM country
WHERE headofstate = 'Elisabeth II';

SELECT *
FROM city
WHERE countrycode IN(SELECT code FROM country WHERE headofstate = 'Elisabeth II');

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT code
FROM country
WHERE indepyear IS NULL;

SELECT name
FROM city
WHERE countrycode IN(SELECT code FROM country WHERE indepyear IS NULL);

-- *HARDER* Find the names of cities with a population > 1.5 mil in countries with a gnp > 1 mil and a population of > 80 mil
SELECT code
FROM country
WHERE gnp > 1000000 AND population > 80000000;

SELECT *
FROM city
WHERE population > 1500000 AND countrycode IN(SELECT code FROM country WHERE gnp > 1000000 AND population > 80000000);

-- Additional samples
-- You may alias column and table names to be more descriptive
SELECT name AS cityname
FROM city AS cities;

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.
SELECT c.name AS cityname, co.name AS countryname
FROM city AS c, country AS co;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name ASC, population DESC;

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip
SELECT name, population
FROM city
LIMIT 10 OFFSET 10;

-- Most database platforms provide string functions that can be useful for working with string data. 
-- In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT (name || ' is in the state of ' || district) AS cityandstate
FROM city
WHERE countrycode = 'USA';

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. 
-- Only returns a single row of value(s) unless used with GROUP BY.
-- Counts the number of rows in the city table
SELECT COUNT(name) FROM city;

-- Also counts the number of rows in the city table
SELECT COUNT(population) FROM city;
-- OR
SELECT COUNT(*) FROM city;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population), COUNT(*), AVG(population)
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) AS smallest, MAX(population) AS largest
FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. 
-- For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode, MIN(population), MAX(population)
FROM city
GROUP BY countrycode;

-- Cast to round - value::datatype casts the value as datatype
SELECT continent, round(AVG(lifeexpectancy)::decimal, 2) AS avglife
FROM country
WHERE continent != 'Antarctica'
GROUP BY continent
ORDER BY avglife DESC;

