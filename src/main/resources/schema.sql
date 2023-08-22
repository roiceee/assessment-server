CREATE DATABASE assessment
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE public.user_info
(
    id serial,
    about text,
    phone_number text,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.user_info
    ADD COLUMN user_id text;

ALTER TABLE IF EXISTS public.user_info
    ADD CONSTRAINT user_info UNIQUE (user_id);