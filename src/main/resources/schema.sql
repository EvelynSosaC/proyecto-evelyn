DROP TABLE IF EXISTS public.cliente;
DROP SEQUENCE IF EXISTS public.cliente_id_seq;

CREATE SEQUENCE public.cliente_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.cliente_id_seq
    OWNER TO postgres;
  

CREATE TABLE public.cliente (
    cliente_id integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
    nombre character varying ,
    apellido character varying ,
    edad integer,
    fecha_nacimiento character varying,
    fecha_muerte character varying,
    CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id)
)
with (
  OIDS=FALSE
  );