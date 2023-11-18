create table items (
    id serial primary key,
    name text,
    created timestamp
);
SELECT * FROM items;
TRUNCATE TABLE items RESTART IDENTITY;