CREATE DATABASE IF NOT EXISTS patitas_care
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE patitas_care;

CREATE TABLE usuario (
    id_usuario  INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    correo      VARCHAR(100) NOT NULL UNIQUE,
    contrasena  VARCHAR(255) NOT NULL,
    rol         VARCHAR(20)  NOT NULL,
    activo      BOOL         NOT NULL DEFAULT 1,
    CONSTRAINT chk_usuario_rol CHECK (rol IN ('Secretario', 'Veterinario', 'Propietario', 'Administrador'))
);


CREATE TABLE propietario (
    id_propietario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario     INT          NOT NULL UNIQUE,
    telefono       VARCHAR(15)  NOT NULL,
    direccion      VARCHAR(200) NOT NULL,
    foto_url       VARCHAR(255) NULL,
    CONSTRAINT fk_propietario_usuario
        FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE veterinario (
    id_veterinario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario     INT         NOT NULL UNIQUE,
    cedula         VARCHAR(20) NOT NULL UNIQUE,
    especialidad   VARCHAR(80) NULL,
    CONSTRAINT fk_veterinario_usuario
        FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE mascota (
    id_mascota        INT AUTO_INCREMENT PRIMARY KEY,
    id_propietario    INT         NOT NULL,
    id_registrado_por INT         NOT NULL,
    nombre            VARCHAR(60) NOT NULL,
    especie           VARCHAR(40) NOT NULL,
    raza              VARCHAR(60) NOT NULL,
    edad              INT         NOT NULL,
    peso              FLOAT       NOT NULL,
    sexo              VARCHAR(10) NOT NULL,
    estado            VARCHAR(10) NOT NULL DEFAULT 'Activo',
    fecha_registro    DATE        NOT NULL,
    CONSTRAINT chk_mascota_sexo   CHECK (sexo IN ('Macho', 'Hembra')),
    CONSTRAINT chk_mascota_estado CHECK (estado IN ('Activo', 'Inactivo')),
    CONSTRAINT chk_mascota_edad   CHECK (edad >= 0),
    CONSTRAINT chk_mascota_peso   CHECK (peso > 0),
    CONSTRAINT fk_mascota_propietario
        FOREIGN KEY (id_propietario) REFERENCES propietario (id_propietario)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_mascota_registrado_por
        FOREIGN KEY (id_registrado_por) REFERENCES usuario (id_usuario)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE alergia (
    id_alergia  INT AUTO_INCREMENT PRIMARY KEY,
    id_mascota  INT          NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT fk_alergia_mascota
        FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE vacuna (
    id_vacuna        INT AUTO_INCREMENT PRIMARY KEY,
    id_mascota       INT         NOT NULL,
    nombre           VARCHAR(80) NOT NULL,
    fecha_aplicacion DATE        NOT NULL,
    proxima_dosis    DATE        NULL,
    CONSTRAINT fk_vacuna_mascota
        FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE cita (
    id_cita        INT AUTO_INCREMENT PRIMARY KEY,
    id_mascota     INT          NOT NULL,
    id_veterinario INT          NOT NULL,
    id_secretario  INT          NOT NULL,
    fecha          DATE         NOT NULL,
    horario        TIME         NOT NULL,
    motivo         VARCHAR(150) NOT NULL,
    descripcion    VARCHAR(500) NULL,
    es_cirugia     BOOL         NOT NULL DEFAULT 0,
    estado         VARCHAR(15)  NOT NULL DEFAULT 'Programada',
    CONSTRAINT chk_cita_estado CHECK (estado IN ('Programada', 'Completada', 'Cancelada')),
    CONSTRAINT fk_cita_mascota
        FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_cita_veterinario
        FOREIGN KEY (id_veterinario) REFERENCES veterinario (id_veterinario)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_cita_secretario
        FOREIGN KEY (id_secretario) REFERENCES usuario (id_usuario)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE reporte_cita (
    id_reporte       INT AUTO_INCREMENT PRIMARY KEY,
    id_cita          INT  NOT NULL UNIQUE,
    id_propietario   INT  NOT NULL,
    total_citas      INT  NOT NULL DEFAULT 0,
    total_cirugias   INT  NOT NULL DEFAULT 0,
    fecha_generacion DATE NOT NULL,
    CONSTRAINT fk_reporte_cita
        FOREIGN KEY (id_cita) REFERENCES cita (id_cita)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_reporte_propietario
        FOREIGN KEY (id_propietario) REFERENCES propietario (id_propietario)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE consulta (
    id_consulta     INT AUTO_INCREMENT PRIMARY KEY,
    id_cita         INT          NOT NULL UNIQUE,
    id_mascota      INT          NOT NULL,
    id_veterinario  INT          NOT NULL,
    medicamento     VARCHAR(100) NULL,
    analisis        VARCHAR(500) NULL,
    dosis           VARCHAR(60)  NULL,
    fecha           DATE         NOT NULL,
    motivo_consulta VARCHAR(200) NOT NULL,
    CONSTRAINT fk_consulta_cita
        FOREIGN KEY (id_cita) REFERENCES cita (id_cita)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_consulta_mascota
        FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_consulta_veterinario
        FOREIGN KEY (id_veterinario) REFERENCES veterinario (id_veterinario)
        ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE receta (
    id_receta          INT AUTO_INCREMENT PRIMARY KEY,
    id_consulta        INT          NOT NULL,
    motivo             VARCHAR(200) NOT NULL,
    medicamento        VARCHAR(100) NOT NULL,
    dosis              VARCHAR(60)  NOT NULL,
    frecuencia         VARCHAR(60)  NOT NULL,
    via_administracion VARCHAR(40)  NOT NULL,
    duracion           VARCHAR(60)  NOT NULL,
    correo_destino     VARCHAR(100) NOT NULL,
    fecha_envio        DATE         NULL,
    CONSTRAINT fk_receta_consulta
        FOREIGN KEY (id_consulta) REFERENCES consulta (id_consulta)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE archivo (
    id_archivo     INT AUTO_INCREMENT PRIMARY KEY,
    id_propietario INT          NOT NULL,
    id_mascota     INT          NULL,
    nombre_archivo VARCHAR(150) NOT NULL,
    tipo           VARCHAR(50)  NOT NULL,
    ruta           VARCHAR(255) NOT NULL,
    fecha_subida   DATE         NOT NULL,
    CONSTRAINT fk_archivo_propietario
        FOREIGN KEY (id_propietario) REFERENCES propietario (id_propietario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_archivo_mascota
        FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
        ON UPDATE CASCADE ON DELETE SET NULL
);

