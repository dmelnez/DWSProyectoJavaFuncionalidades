-- Database: MoterosRedSocial

-- DROP DATABASE IF EXISTS "MoterosRedSocial";

CREATE DATABASE "MoterosRedSocial"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- SCHEMA: sch_moteros

-- DROP SCHEMA IF EXISTS sch_moteros ;

CREATE SCHEMA IF NOT EXISTS sch_moteros
    AUTHORIZATION postgres;



-- Table: sch_moteros.Clubs

-- DROP TABLE IF EXISTS sch_moteros."Clubs";

CREATE TABLE IF NOT EXISTS sch_moteros."Clubs"
(
    id_club bigint NOT NULL,
    nombre_club character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    miembros_club bigint DEFAULT 999999999,
    alias_club character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    codigo_identificativo character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    CONSTRAINT "Clubs_pkey" PRIMARY KEY (id_club)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Clubs"
    OWNER to postgres;





-- Table: sch_moteros.Eventos

-- DROP TABLE IF EXISTS sch_moteros."Eventos";

CREATE TABLE IF NOT EXISTS sch_moteros."Eventos"
(
    id_evento bigint NOT NULL,
    nombre_evento character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    url character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    fecha_inicio time without time zone,
    fecha_fin time without time zone,
    "esPublico" boolean DEFAULT false,
    tiempo_evento bigint DEFAULT 999999999,
    descripcion_evento character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    "esPago" boolean DEFAULT false,
    precio_entrada bigint DEFAULT 999999999,
    CONSTRAINT "Eventos_pkey" PRIMARY KEY (id_evento)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Eventos"
    OWNER to postgres;





-- Table: sch_moteros.Motos

-- DROP TABLE IF EXISTS sch_moteros."Motos";

CREATE TABLE IF NOT EXISTS sch_moteros."Motos"
(
    id_moto bigint NOT NULL,
    alias_moto character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    modelo_moto character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    km_moto bigint DEFAULT 999999999,
    matricula_moto character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    tipo_combustible_moto character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    usuario_motos bigint DEFAULT 999999999,
    CONSTRAINT "Motos_pkey" PRIMARY KEY (id_moto),
    CONSTRAINT fk_motos_usuarios FOREIGN KEY (usuario_motos)
        REFERENCES sch_moteros."Usuarios" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Motos"
    OWNER to postgres;




-- Table: sch_moteros.Rutas

-- DROP TABLE IF EXISTS sch_moteros."Rutas";

CREATE TABLE IF NOT EXISTS sch_moteros."Rutas"
(
    id_ruta bigint NOT NULL,
    nombre_ruta character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    url_ruta character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    fecha_inicio time without time zone,
    fecha_fin time without time zone,
    "esPublico" boolean DEFAULT false,
    tiempo_ruta character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    descripcion_ruta character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    difultad_ruta character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    CONSTRAINT "Rutas_pkey" PRIMARY KEY (id_ruta)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Rutas"
    OWNER to postgres;





-- Table: sch_moteros.Sedes

-- DROP TABLE IF EXISTS sch_moteros."Sedes";

CREATE TABLE IF NOT EXISTS sch_moteros."Sedes"
(
    id_sede bigint NOT NULL,
    nombre_sede character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    direccion_sede character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    codigo_postal_sede bigint DEFAULT 999999999,
    telefono_sede character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    pais_sede character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    CONSTRAINT "Sedes_pkey" PRIMARY KEY (id_sede)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Sedes"
    OWNER to postgres;





-- Table: sch_moteros.Solicitudes

-- DROP TABLE IF EXISTS sch_moteros."Solicitudes";

CREATE TABLE IF NOT EXISTS sch_moteros."Solicitudes"
(
    id_solicitud bigint NOT NULL,
    usuario_id_fk bigint,
    club_id_fk bigint,
    estado_solicitud character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    CONSTRAINT "Solicitudes_pkey" PRIMARY KEY (id_solicitud),
    CONSTRAINT fk_solicitud_club FOREIGN KEY (club_id_fk)
        REFERENCES sch_moteros."Clubs" (id_club) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_solicitud_usuarios FOREIGN KEY (usuario_id_fk)
        REFERENCES sch_moteros."Usuarios" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Solicitudes"
    OWNER to postgres;





-- Table: sch_moteros.Usuarios

-- DROP TABLE IF EXISTS sch_moteros."Usuarios";

CREATE TABLE IF NOT EXISTS sch_moteros."Usuarios"
(
    id bigint NOT NULL,
    nombre_usuario character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    apellidos_usuarioo character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    dni_usuario character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    email_usuario character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    direccion_usuario character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    telefono_usuario character varying COLLATE pg_catalog."default" DEFAULT 'aaaaa'::character varying,
    CONSTRAINT "Usuarios_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS sch_moteros."Usuarios"
    OWNER to postgres;