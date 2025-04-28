create table recipe(name varchar PRIMARY KEY ,description varchar);

alter table recipe add column id numeric;

alter table recipe drop constraint recipe_pkey;

alter table recipe add constraint primary key(id);

ALTER TABLE public.recipe ALTER COLUMN id TYPE bigint USING id::bigint;

