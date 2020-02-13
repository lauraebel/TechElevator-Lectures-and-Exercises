# INSERT, UPDATE, and DELETE

The purpose of this exercise is to practice using inserting, updating, and deleting rows in database tables using Structured Query Language (SQL).

## Learning Objectives

After completing this exercise, students will understand:

* How to insert data using the `INSERT` statement.
* How to update data using the `UPDATE` statement.
* How to delete data using the `DELETE` statement.

## Evaluation Criteria & Functional Requirements

To complete this exercise, you will need to write SQL queries in the `constraints-and-transactions.sql` file.

Below each commented out question, you will write the query necessary to answer the question being asked using the world database as the source.

* All of the DML statements run as expected.
* The number of rows affected matches the number of rows specified for each question.
* You have provided a response to all questions in the file.
* Code is clean, concise, and readable.

## Getting Started

* Open the `constraints-and-transactions.sql` file in DB Visualizer.
* If you have not done so already, create the dvdstore database. The script for this should be available in today's lecture code.
* In the "Database Connection" properties above the file, select the world database.
* You can run all of the database commands in the file at one time by pressing the command + enter key at the same time.
* You can run a single database command at a time by highlighting the command, and then pressing the command + enter key at the same time.

## Tips and Tricks

* The `INSERT` statement can be used to add rows of data (records) to a database table.
* The `UPDATE` statement can be used to update existing data in a table.
* The `DELETE` statement can be used to delete data from a table.
* **IMPORTANT!!! Be sure to include a `WHERE` clause when you are updating or deleting data from a table, unless you intend to update or delete ALL rows in the table.**
* Using transactions is a great way to quickly get a database back into the state it was in before you started running statements. Consider doing this as you work through the exercises in order to avoid the need to restore your database.
