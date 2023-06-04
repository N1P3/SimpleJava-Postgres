CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    email TEXT,
    phone_number TEXT,
    address TEXT,
    position_id INT REFERENCES positions(id),
    department_id INT REFERENCES departments(id)
);

CREATE TABLE positions (
    id SERIAL PRIMARY KEY,
    title TEXT
);

CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    name TEXT
);

insert into positions (id, title)
values (3, 'szef');

insert into departments(id, name)
values (3,'szefowie')
