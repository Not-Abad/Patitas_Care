DROP DATABASE IF EXISTS patitas_final;
CREATE DATABASE patitas_final CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE patitas_final;

CREATE TABLE catalogo_especies (
  id_especie INT          NOT NULL AUTO_INCREMENT,
  nombre     VARCHAR(50)  NOT NULL,
  PRIMARY KEY (id_especie),
  UNIQUE KEY uk_especies_nombre (nombre)
) ENGINE=InnoDB;

CREATE TABLE catalogo_razas (
  id_raza    INT          NOT NULL AUTO_INCREMENT,
  id_especie INT          NOT NULL,
  nombre     VARCHAR(80)  NOT NULL,
  PRIMARY KEY (id_raza),
  CONSTRAINT fk_razas_especie FOREIGN KEY (id_especie)
    REFERENCES catalogo_especies (id_especie)
) ENGINE=InnoDB;

CREATE TABLE roles (
  id_rol INT         NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_rol),
  UNIQUE KEY uk_roles_nombre (nombre)
) ENGINE=InnoDB;

CREATE TABLE usuarios (
  id_usuario    INT          NOT NULL AUTO_INCREMENT,
  id_rol        INT          NOT NULL,
  username      VARCHAR(50)  NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  is_active     TINYINT(1)   NOT NULL DEFAULT 1,
  ultimo_acceso DATETIME     NULL,
  created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY uk_usuarios_username (username),
  CONSTRAINT fk_usuarios_rol FOREIGN KEY (id_rol)
    REFERENCES roles (id_rol)
) ENGINE=InnoDB;

CREATE TABLE bitacora_movimientos (
  id_bitacora          BIGINT       NOT NULL AUTO_INCREMENT,
  id_usuario           INT          NOT NULL,
  tabla_afectada       VARCHAR(64)  NOT NULL,
  id_registro_afectado INT          NOT NULL,
  accion               VARCHAR(30)  NOT NULL,
  valor_anterior       TEXT         NULL,
  valor_nuevo          TEXT         NULL,
  descripcion          TEXT         NULL,
  fecha_hora           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_bitacora),
  CONSTRAINT fk_bitacora_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuarios (id_usuario)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- PROPIETARIOS, MASCOTAS Y PERSONAL
-- ---------------------------------------------------------------------

CREATE TABLE propietarios (
  id_propietario INT          NOT NULL AUTO_INCREMENT,
  nombre         VARCHAR(120) NOT NULL,
  telefono       VARCHAR(20)  NULL,
  correo         VARCHAR(120) NULL,
  direccion      VARCHAR(255) NULL,
  is_active      TINYINT(1)   NOT NULL DEFAULT 1,
  created_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_propietario),
  UNIQUE KEY uk_propietarios_correo (correo)
) ENGINE=InnoDB;

CREATE TABLE mascotas (
  id_mascota         INT           NOT NULL AUTO_INCREMENT,
  id_propietario     INT           NOT NULL,
  id_raza            INT           NOT NULL,
  nombre             VARCHAR(80)   NOT NULL,
  sexo               ENUM('Macho','Hembra') NOT NULL,
  fecha_nacimiento   DATE          NULL,
  peso_actual_kg     DECIMAL(6,2)  NULL,
  antecedentes_medicos TEXT        NULL,
  estatus            ENUM('Activo','Inactivo','Fallecido') NOT NULL DEFAULT 'Activo',
  created_at         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_mascota),
  CONSTRAINT fk_mascotas_propietario FOREIGN KEY (id_propietario)
    REFERENCES propietarios (id_propietario),
  CONSTRAINT fk_mascotas_raza FOREIGN KEY (id_raza)
    REFERENCES catalogo_razas (id_raza)
) ENGINE=InnoDB;

CREATE TABLE personal (
  id_personal       INT          NOT NULL AUTO_INCREMENT,
  id_usuario        INT          NOT NULL,
  nombre            VARCHAR(120) NOT NULL,
  telefono          VARCHAR(20)  NULL,
  correo            VARCHAR(120) NULL,
  especialidad      VARCHAR(100) NULL,
  cedula_profesional VARCHAR(30) NULL,
  fecha_contratacion DATE        NULL,
  is_active         TINYINT(1)   NOT NULL DEFAULT 1,
  PRIMARY KEY (id_personal),
  UNIQUE KEY uk_personal_correo (correo),
  UNIQUE KEY uk_personal_cedula (cedula_profesional),
  CONSTRAINT fk_personal_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuarios (id_usuario)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- CITAS Y CONSULTAS
-- ---------------------------------------------------------------------

CREATE TABLE citas (
  id_cita              INT          NOT NULL AUTO_INCREMENT,
  id_mascota           INT          NOT NULL,
  id_veterinario       INT          NOT NULL,   -- referencia a personal
  id_usuario_registro  INT          NOT NULL,   -- referencia a usuarios
  fecha_hora_inicio    DATETIME     NOT NULL,
  fecha_hora_fin       DATETIME     NOT NULL,
  motivo               VARCHAR(255) NULL,
  estado               ENUM('Programada','Confirmada','Completada','Cancelada','No asistio')
                       NOT NULL DEFAULT 'Programada',
  recordatorio_enviado TINYINT(1)   NOT NULL DEFAULT 0,
  created_at           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_cita),
  CONSTRAINT fk_citas_mascota FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id_mascota),
  CONSTRAINT fk_citas_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal),
  CONSTRAINT fk_citas_usuario_registro FOREIGN KEY (id_usuario_registro)
    REFERENCES usuarios (id_usuario)
) ENGINE=InnoDB;

CREATE TABLE consultas (
  id_consulta        INT           NOT NULL AUTO_INCREMENT,
  id_cita            INT           NOT NULL,
  id_mascota         INT           NOT NULL,
  id_veterinario     INT           NOT NULL,
  fecha_consulta     DATETIME      NOT NULL,
  peso_registrado_kg DECIMAL(6,2)  NULL,
  temperatura_c      DECIMAL(4,1)  NULL,
  frecuencia_cardiaca SMALLINT     NULL,
  motivo_consulta    TEXT          NULL,
  exploracion_fisica TEXT          NULL,
  observaciones      TEXT          NULL,
  PRIMARY KEY (id_consulta),
  UNIQUE KEY uk_consultas_cita (id_cita),   -- relación 1:1 con citas
  CONSTRAINT fk_consultas_cita FOREIGN KEY (id_cita)
    REFERENCES citas (id_cita),
  CONSTRAINT fk_consultas_mascota FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id_mascota),
  CONSTRAINT fk_consultas_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- VACUNACIÓN
-- ---------------------------------------------------------------------

CREATE TABLE catalogo_vacunas (
  id_vacuna              INT          NOT NULL AUTO_INCREMENT,
  nombre                 VARCHAR(100) NOT NULL,
  descripcion            VARCHAR(255) NULL,
  intervalo_refuerzo_dias SMALLINT    NULL,
  is_active              TINYINT(1)   NOT NULL DEFAULT 1,
  PRIMARY KEY (id_vacuna),
  UNIQUE KEY uk_vacunas_nombre (nombre)
) ENGINE=InnoDB;

CREATE TABLE esquema_vacunacion (
  id_aplicacion      INT          NOT NULL AUTO_INCREMENT,
  id_mascota         INT          NOT NULL,
  id_vacuna          INT          NOT NULL,
  id_veterinario     INT          NOT NULL,
  id_consulta        INT          NULL,
  fecha_aplicacion   DATE         NOT NULL,
  fecha_proxima_dosis DATE        NULL,
  lote               VARCHAR(50)  NULL,
  observaciones      VARCHAR(255) NULL,
  PRIMARY KEY (id_aplicacion),
  CONSTRAINT fk_esquema_mascota FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id_mascota),
  CONSTRAINT fk_esquema_vacuna FOREIGN KEY (id_vacuna)
    REFERENCES catalogo_vacunas (id_vacuna),
  CONSTRAINT fk_esquema_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal),
  CONSTRAINT fk_esquema_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas (id_consulta)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- DIAGNÓSTICOS, ANÁLISIS, RECETAS Y ADJUNTOS
-- ---------------------------------------------------------------------

CREATE TABLE diagnosticos (
  id_diagnostico   INT       NOT NULL AUTO_INCREMENT,
  id_consulta      INT       NOT NULL,
  id_veterinario   INT       NOT NULL,
  descripcion      TEXT      NOT NULL,
  tipo_diagnostico ENUM('Presuntivo','Definitivo') NOT NULL DEFAULT 'Presuntivo',
  estado           ENUM('Activo','Resuelto','Cronico') NOT NULL DEFAULT 'Activo',
  fecha_registro   DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at       DATETIME  NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_diagnostico),
  CONSTRAINT fk_diagnosticos_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas (id_consulta),
  CONSTRAINT fk_diagnosticos_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal)
) ENGINE=InnoDB;

CREATE TABLE analisis_clinicos (
  id_analisis     INT          NOT NULL AUTO_INCREMENT,
  id_mascota      INT          NOT NULL,
  id_consulta     INT          NULL,
  id_diagnostico  INT          NULL,
  id_veterinario  INT          NOT NULL,
  tipo_analisis   VARCHAR(100) NOT NULL,
  resultados      TEXT         NULL,
  observaciones   TEXT         NULL,
  fecha_solicitud DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_resultado DATETIME     NULL,
  estado          ENUM('Solicitado','En proceso','Completado','Cancelado')
                  NOT NULL DEFAULT 'Solicitado',
  PRIMARY KEY (id_analisis),
  CONSTRAINT fk_analisis_mascota FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id_mascota),
  CONSTRAINT fk_analisis_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas (id_consulta),
  CONSTRAINT fk_analisis_diagnostico FOREIGN KEY (id_diagnostico)
    REFERENCES diagnosticos (id_diagnostico),
  CONSTRAINT fk_analisis_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal)
) ENGINE=InnoDB;

CREATE TABLE adjuntos_clinicos (
  id_adjunto     INT          NOT NULL AUTO_INCREMENT,
  id_diagnostico INT          NULL,
  id_analisis    INT          NULL,
  tipo_archivo   VARCHAR(50)  NOT NULL,
  ruta_archivo   VARCHAR(255) NOT NULL,
  descripcion    VARCHAR(255) NULL,
  fecha_subida   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_adjunto),
  CONSTRAINT fk_adjuntos_diagnostico FOREIGN KEY (id_diagnostico)
    REFERENCES diagnosticos (id_diagnostico),
  CONSTRAINT fk_adjuntos_analisis FOREIGN KEY (id_analisis)
    REFERENCES analisis_clinicos (id_analisis)
) ENGINE=InnoDB;

CREATE TABLE recetas (
  id_receta              INT      NOT NULL AUTO_INCREMENT,
  id_diagnostico         INT      NOT NULL,
  id_veterinario         INT      NOT NULL,
  fecha_emision          DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  indicaciones_generales TEXT     NULL,
  PRIMARY KEY (id_receta),
  CONSTRAINT fk_recetas_diagnostico FOREIGN KEY (id_diagnostico)
    REFERENCES diagnosticos (id_diagnostico),
  CONSTRAINT fk_recetas_veterinario FOREIGN KEY (id_veterinario)
    REFERENCES personal (id_personal)
) ENGINE=InnoDB;

CREATE TABLE detalle_tratamiento (
  id_detalle    INT          NOT NULL AUTO_INCREMENT,
  id_receta     INT          NOT NULL,
  medicamento   VARCHAR(120) NOT NULL,
  dosis         VARCHAR(80)  NOT NULL,
  frecuencia    VARCHAR(80)  NOT NULL,
  duracion_dias SMALLINT     NULL,
  fecha_inicio  DATE         NULL,
  fecha_fin     DATE         NULL,
  estado        ENUM('Activo','Completado','Suspendido') NOT NULL DEFAULT 'Activo',
  observaciones VARCHAR(255) NULL,
  PRIMARY KEY (id_detalle),
  CONSTRAINT fk_detalle_receta FOREIGN KEY (id_receta)
    REFERENCES recetas (id_receta)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- COBROS Y SERVICIOS
-- ---------------------------------------------------------------------

CREATE TABLE catalogo_servicios (
  id_servicio INT           NOT NULL AUTO_INCREMENT,
  nombre      VARCHAR(100)  NOT NULL,
  categoria   ENUM('Consulta','Vacunacion','Cirugia','Laboratorio','Estetica','Otro')
              NOT NULL DEFAULT 'Otro',
  costo_base  DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  activo      TINYINT(1)    NOT NULL DEFAULT 1,
  PRIMARY KEY (id_servicio),
  UNIQUE KEY uk_servicios_nombre (nombre)
) ENGINE=InnoDB;

CREATE TABLE cobros_servicios (
  id_cobro            INT           NOT NULL AUTO_INCREMENT,
  id_propietario      INT           NOT NULL,
  id_mascota          INT           NOT NULL,
  id_consulta         INT           NULL,
  id_usuario_registro INT           NOT NULL,
  fecha_cobro         DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  subtotal            DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  total               DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  metodo_pago         ENUM('Efectivo','Tarjeta','Transferencia') NOT NULL,
  estado              ENUM('Pendiente','Pagado','Cancelado') NOT NULL DEFAULT 'Pendiente',
  motivo_cancelacion  VARCHAR(255)  NULL,
  PRIMARY KEY (id_cobro),
  CONSTRAINT fk_cobros_propietario FOREIGN KEY (id_propietario)
    REFERENCES propietarios (id_propietario),
  CONSTRAINT fk_cobros_mascota FOREIGN KEY (id_mascota)
    REFERENCES mascotas (id_mascota),
  CONSTRAINT fk_cobros_consulta FOREIGN KEY (id_consulta)
    REFERENCES consultas (id_consulta),
  CONSTRAINT fk_cobros_usuario_registro FOREIGN KEY (id_usuario_registro)
    REFERENCES usuarios (id_usuario)
) ENGINE=InnoDB;

CREATE TABLE detalle_cobro_servicio (
  id_detalle_cobro INT           NOT NULL AUTO_INCREMENT,
  id_cobro         INT           NOT NULL,
  id_servicio      INT           NOT NULL,
  cantidad         SMALLINT      NOT NULL DEFAULT 1,
  precio_unitario  DECIMAL(10,2) NOT NULL,
  subtotal         DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_detalle_cobro),
  CONSTRAINT fk_detcobro_cobro FOREIGN KEY (id_cobro)
    REFERENCES cobros_servicios (id_cobro),
  CONSTRAINT fk_detcobro_servicio FOREIGN KEY (id_servicio)
    REFERENCES catalogo_servicios (id_servicio)
) ENGINE=InnoDB;

-- ---------------------------------------------------------------------
-- ÍNDICES ADICIONALES PARA CONSULTAS FRECUENTES
-- ---------------------------------------------------------------------
CREATE INDEX idx_citas_fecha        ON citas (fecha_hora_inicio);
CREATE INDEX idx_citas_veterinario  ON citas (id_veterinario, fecha_hora_inicio);
CREATE INDEX idx_mascotas_prop      ON mascotas (id_propietario);
CREATE INDEX idx_bitacora_tabla     ON bitacora_movimientos (tabla_afectada, id_registro_afectado);
CREATE INDEX idx_esquema_proxima    ON esquema_vacunacion (fecha_proxima_dosis);

