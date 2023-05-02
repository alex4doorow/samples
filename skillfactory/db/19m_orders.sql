-- public.aircrafts definition

-- Drop table

-- DROP TABLE public.aircrafts;

CREATE TABLE public.aircrafts (
	id serial4 NOT NULL,
	"name" varchar(100) NULL,
	CONSTRAINT aircrafts_pkey PRIMARY KEY (id)
);


-- public.clients definition

-- Drop table

-- DROP TABLE public.clients;

CREATE TABLE public.clients (
	id serial4 NOT NULL,
	"name" varchar(200) NOT NULL,
	phone varchar(30) NOT NULL,
	email varchar(200) NOT NULL,
	CONSTRAINT clients_pkey PRIMARY KEY (id),
	CONSTRAINT unique_phone UNIQUE (phone)
);


-- public.films definition

-- Drop table

-- DROP TABLE public.films;

CREATE TABLE public.films (
	id serial4 NOT NULL,
	title varchar(40) NOT NULL,
	produced int4 NOT NULL,
	date_prod date NULL,
	kind varchar(10) NULL,
	len_min int4 NULL,
	CONSTRAINT constr_example CHECK (((len_min > 100) AND ((title)::text <> ''::text))),
	CONSTRAINT films_pk PRIMARY KEY (id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id serial4 NOT NULL,
	"name" varchar(200) NOT NULL,
	price numeric NOT NULL,
	category varchar(100) NULL,
	in_stock int4 NULL DEFAULT 0,
	CONSTRAINT products_pkey PRIMARY KEY (id)
);


-- public.products_count definition

-- Drop table

-- DROP TABLE public.products_count;

CREATE TABLE public.products_count (
	"name" varchar(100) NOT NULL,
	full_count int4 NULL
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id serial4 NOT NULL,
	"name" varchar(40) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.favorite_films definition

-- Drop table

-- DROP TABLE public.favorite_films;

CREATE TABLE public.favorite_films (
	id serial4 NOT NULL,
	user_id int4 NULL,
	film_id int4 NULL,
	CONSTRAINT favorite_films_pkey PRIMARY KEY (id),
	CONSTRAINT favorite_films_film_id_fkey FOREIGN KEY (film_id) REFERENCES public.films(id),
	CONSTRAINT favorite_films_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id)
);


-- public.old_orders definition

-- Drop table

-- DROP TABLE public.old_orders;

CREATE TABLE public.old_orders (
	id int4 NOT NULL,
	client_id int4 NOT NULL,
	"date" date NOT NULL,
	status varchar(100) NOT NULL,
	address varchar(100) NOT NULL,
	CONSTRAINT old_orders_pkey PRIMARY KEY (id),
	CONSTRAINT old_orders_status_check CHECK (((status)::text = ANY ((ARRAY['done'::character varying, 'in progress'::character varying, 'delivery'::character varying])::text[]))),
	CONSTRAINT old_orders_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.clients(id)
);


-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	id serial4 NOT NULL,
	client_id int4 NOT NULL,
	"date" date NOT NULL,
	status varchar(100) NOT NULL,
	address varchar(100) NULL,
	date_changed timestamp NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id),
	CONSTRAINT orders_status_check CHECK (((status)::text = ANY ((ARRAY['done'::character varying, 'in progress'::character varying, 'delivery'::character varying])::text[]))),
	CONSTRAINT orders_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.clients(id)
);

-- Table Triggers

create trigger update_date_changed_triger before
update
    on
    public.orders for each row execute function update_date_changed();


-- public.positions definition

-- Drop table

-- DROP TABLE public.positions;

CREATE TABLE public.positions (
	id serial4 NOT NULL,
	order_id int4 NOT NULL,
	product_id int4 NOT NULL,
	amount int4 NOT NULL,
	CONSTRAINT positions_pk PRIMARY KEY (id),
	CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES public.orders(id),
	CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.products(id)
);


-- public.routes definition

-- Drop table

-- DROP TABLE public.routes;

CREATE TABLE public.routes (
	id serial4 NOT NULL,
	aircraft_id int4 NULL,
	"_from" varchar(100) NULL,
	"_to" varchar(100) NULL,
	CONSTRAINT routes_pkey PRIMARY KEY (id),
	CONSTRAINT routes_fk FOREIGN KEY (aircraft_id) REFERENCES public.aircrafts(id) ON UPDATE CASCADE
);