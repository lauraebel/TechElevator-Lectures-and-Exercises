DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS job_title;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS project;

CREATE TABLE job_title (
        job_title_id serial primary key,
        job_title_name varchar(60) not null
);

CREATE TABLE employee (
        employee_id serial primary key,
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        gender varchar(10), 
        date_of_birth date not null,
        job_title_id int not null,
        date_of_hire date not null,

	constraint fk_employee_job_title_id foreign key (job_title_id) references job_title(job_title_id)
);

CREATE TABLE department (
        department_id serial primary key,
        department_name varchar(40) not null       
);

CREATE TABLE project (
        project_id serial primary key,
        project_name varchar(60) not null,
        project_start_date date not null
);

CREATE TABLE employee_department (
        employee_id int,
        department_id int,
        
        constraint fk_ed_employee_id foreign key (employee_id) references employee(employee_id),
        constraint fk_ed_department_id foreign key (department_id) references department(department_id),
        PRIMARY KEY(employee_id, department_id)
);

CREATE TABLE employee_project (
        employee_id int,
        project_id int,
        
        constraint fk_ep_employee_id foreign key (employee_id) references employee(employee_id),
        constraint fk_ep_project_id foreign key (project_id) references project(project_id),
        PRIMARY KEY(employee_id, project_id)
);

INSERT INTO job_title VALUES (DEFAULT, 'Director of Human Resources');
INSERT INTO job_title VALUES (DEFAULT, 'Human Resources Assistant');
INSERT INTO job_title VALUES (DEFAULT, 'Head of IT');
INSERT INTO job_title VALUES (DEFAULT, 'IT Associate');
INSERT INTO job_title VALUES (DEFAULT, 'Director of Sales and Marketing');
INSERT INTO job_title VALUES (DEFAULT, 'Sales and Marketing Admin');
INSERT INTO job_title VALUES (DEFAULT, 'Customer Service Manager');
INSERT INTO job_title VALUES (DEFAULT, 'Dual Customer Service Associate');
INSERT INTO job_title VALUES (DEFAULT, 'Front Desk Associate');
INSERT INTO job_title VALUES (DEFAULT, 'Call Center Associate');

INSERT INTO employee VALUES (DEFAULT, 'Jim', 'Smith', 'Male', '1985-03-16', (SELECT job_title_id FROM job_title
        WHERE job_title_name = 'Director of Human Resources'), '2017-10-14');
INSERT INTO employee VALUES (DEFAULT, 'Trisha', 'Germain', 'Female', '1966-07-20', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Human Resources Assistant'), '1999-08-14');
INSERT INTO employee VALUES (DEFAULT, 'Alex', 'Kopper', null, '1991-01-01', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Head of IT'), '2019-05-29');
INSERT INTO employee VALUES (DEFAULT, 'Tony', 'Morris', 'Male', '1972-04-05', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Director of Sales and Marketing'), '2005-03-17');
INSERT INTO employee VALUES (DEFAULT, 'Joshua', 'Tree', 'Male', '1990-10-20', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Sales and Marketing Admin'), '2017-09-24');
INSERT INTO employee VALUES (DEFAULT, 'Sam', 'Thompson', null, '1989-07-24', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'IT Associate'), '2015-05-05');
INSERT INTO employee VALUES (DEFAULT, 'Tanya', 'Edwards', 'Female', '1959-03-23', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Sales and Marketing Admin'), '2003-11-07');
INSERT INTO employee VALUES (DEFAULT, 'Viktor', 'Krum', 'Male', '1985-08-25', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Customer Service Manager'), '2015-04-09');
INSERT INTO employee VALUES (DEFAULT, 'Dwight', 'Schrute', 'Male', '1975-09-17', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Front Desk Associate'), '2014-06-07');
INSERT INTO employee VALUES (DEFAULT, 'Jennifer', 'Pratt', 'Female', '1991-07-19', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Front Desk Associate'), '2017-03-19');
INSERT INTO employee VALUES (DEFAULT, 'Natasha', 'Denona', 'Female', '1959-09-14', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Dual Customer Service Associate'), '2014-09-08');
INSERT INTO employee VALUES (DEFAULT, 'Hayworth', 'Sillyface', null, '1989-04-24', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Dual Customer Service Associate'), '2018-02-18');
INSERT INTO employee VALUES (DEFAULT, 'Joffrey', 'Lannister', 'Male', '1995-07-08', (SELECT job_title_id FROM job_title
        WHERE job_title_name  = 'Dual Customer Service Associate'), '2020-01-18');
        
INSERT INTO department VALUES (DEFAULT, 'Human Resources');
INSERT INTO department VALUES (DEFAULT, 'IT');
INSERT INTO department VALUES (DEFAULT, 'Sales and Marketing');
INSERT INTO department VALUES (DEFAULT, 'Front Desk');
INSERT INTO department VALUES (DEFAULT, 'Call Center');
INSERT INTO department VALUES (DEFAULT, 'Management');

INSERT INTO project VALUES (DEFAULT, 'The Morrison Street Project', '2019-08-15');
INSERT INTO project VALUES (DEFAULT, 'The 5th and Elm Project', '2018-06-25');
INSERT INTO project VALUES (DEFAULT, 'The Chambers Road Project', '2020-02-05');
INSERT INTO project VALUES (DEFAULT, 'The Route 317 Project', '2017-03-09');
INSERT INTO project VALUES (DEFAULT, 'The Timothy Street Project', '2019-10-20');

INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Jim'), 
        (SELECT department_id FROM department WHERE department_name = 'Human Resources'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Jim'), 
        (SELECT department_id FROM department WHERE department_name = 'Management'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Trisha'), 
        (SELECT department_id FROM department WHERE department_name = 'Human Resources'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Alex'), 
        (SELECT department_id FROM department WHERE department_name = 'IT'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Alex'), 
        (SELECT department_id FROM department WHERE department_name = 'Management'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tony'), 
        (SELECT department_id FROM department WHERE department_name = 'Sales and Marketing'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tony'), 
        (SELECT department_id FROM department WHERE department_name = 'Management'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joshua'),
        (SELECT department_id FROM department WHERE department_name = 'Sales and Marketing'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Sam'), 
        (SELECT department_id FROM department WHERE department_name = 'IT'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tanya'), 
        (SELECT department_id FROM department WHERE department_name = 'Sales and Marketing'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT department_id FROM department WHERE department_name = 'Call Center'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT department_id FROM department WHERE department_name = 'Management'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Dwight'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Jennifer'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT department_id FROM department WHERE department_name = 'Call Center'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Hayworth'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Hayworth'), 
        (SELECT department_id FROM department WHERE department_name = 'Call Center'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joffrey'), 
        (SELECT department_id FROM department WHERE department_name = 'Front Desk'));
INSERT INTO employee_department VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joffrey'), 
        (SELECT department_id FROM department WHERE department_name = 'Call Center'));
        
 INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tony'), 
        (SELECT project_id FROM project WHERE project_name = 'The Morrison Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joshua'),
        (SELECT project_id FROM project WHERE project_name = 'The Morrison Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tanya'), 
        (SELECT project_id FROM project WHERE project_name = 'The Morrison Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT project_id FROM project WHERE project_name = 'The Morrison Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Jennifer'), 
        (SELECT project_id FROM project WHERE project_name = 'The Morrison Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tony'),      
        (SELECT project_id FROM project WHERE project_name = 'The 5th and Elm Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joshua'), 
        (SELECT project_id FROM project WHERE project_name = 'The 5th and Elm Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT project_id FROM project WHERE project_name = 'The 5th and Elm Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Jennifer'),      
        (SELECT project_id FROM project WHERE project_name = 'The 5th and Elm Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Hayworth'),      
        (SELECT project_id FROM project WHERE project_name = 'The 5th and Elm Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joshua'), 
        (SELECT project_id FROM project WHERE project_name = 'The Chambers Road Project'));      
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT project_id FROM project WHERE project_name = 'The Chambers Road Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT project_id FROM project WHERE project_name = 'The Chambers Road Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tony'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joshua'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Trisha'),
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Hayworth'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Joffrey'), 
        (SELECT project_id FROM project WHERE project_name = 'The Route 317 Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Tanya'), 
        (SELECT project_id FROM project WHERE project_name = 'The Timothy Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Viktor'), 
        (SELECT project_id FROM project WHERE project_name = 'The Timothy Street Project'));
INSERT INTO employee_project VALUES ((SELECT employee_id FROM employee WHERE first_name = 'Natasha'), 
        (SELECT project_id FROM project WHERE project_name = 'The Timothy Street Project'));
