-- DataTypes in SQL can be Cast to other data types that can hold that value in a SQL Query
-- There are 2 Operators available for casting in PostgreSQL.   The CAST (expression AS target_type) is
-- the standard SQL operator and is available in most SQL (R)DBMSs.  The :: operator (expression::target_type) works
-- the same, but is PostgreSQL specific and not available in other SQL (R)DBMSs.

-- CAST (expression AS target_type)
SELECT CAST('10' AS Integer);
SELECT CAST(10 AS varchar(5)); 
SELECT CAST(10 AS decimal(5,2));
SELECT CAST('01-10-2015' AS DATE);
SELECT CAST('2019-06-15 14:30:20' AS timestamp);
SELECT CAST('true' AS BOOLEAN);
SELECT CAST(false AS varchar(10));

SELECT CAST('120' AS Integer) / CAST('10' AS Double Precision) + 10;

-- USING the Postgres cast operator ::  (PostgreSQL only)
SELECT '10'::Integer;
SELECT 10::varchar(5); 
SELECT 10::decimal(5,2);
SELECT '01-10-2015'::DATE;
SELECT '2019-06-15 14:30:20'::timestamp;
SELECT 'true'::BOOLEAN;
SELECT false::varchar(10);

SELECT '120'::Integer / '10'::Double Precision + 10;