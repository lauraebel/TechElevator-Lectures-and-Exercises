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