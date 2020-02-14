-- Create a new User with a Password
CREATE USER carson PASSWORD '123';

-- Grant SELECT ON a table to a user
GRANT SELECT ON person TO carson;

-- Grant INSERT ON a table to a user
GRANT INSERT ON person TO carson;

-- Grant SELECT ON a sequence to a user
GRANT USAGE, SELECT ON SEQUENCE person_person_id_seq TO carson;

-- Revoke SELECT ON a table from a user
REVOKE SELECT ON person FROM carson;