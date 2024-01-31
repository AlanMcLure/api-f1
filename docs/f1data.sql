-- Crear la base de datos "sportscore"
CREATE DATABASE f1data;

-- Seleccionar la base de datos "sportscore"
USE f1data;

-- Tabla Piloto
CREATE TABLE piloto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fecha_nac DATE,
    nacionalidad VARCHAR(50),
    img VARCHAR(255)
    -- Otros campos relevantes
);

-- Tabla Equipo
CREATE TABLE equipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fecha_inic DATE,
    nacionalidad VARCHAR(50),
    img VARCHAR(255)
    -- Otros campos relevantes
);

-- Tabla Circuito
CREATE TABLE circuito (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    region VARCHAR(50)
    -- Otros campos relevantes
);

-- Tabla Gran Premio
CREATE TABLE gran_premio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fecha_inic DATE UNIQUE,
    fecha_fin DATE UNIQUE,
    img_flag VARCHAR(255),
    img VARCHAR(255),
    circuito_id INT,
    -- Otros campos relevantes
    FOREIGN KEY (circuito_id) REFERENCES circuito(id)
);

-- Tabla PilotoEquipo
CREATE TABLE piloto_equipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    piloto_id INT,
    equipo_id INT,
    fecha_inic DATE,
    fecha_fin DATE,
    UNIQUE (piloto_id, equipo_id, fecha_inic, fecha_fin),
    FOREIGN KEY (piloto_id) REFERENCES piloto(id),
    FOREIGN KEY (equipo_id) REFERENCES equipo(id)
);

-- Tabla Trazado
CREATE TABLE trazado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    num_metros INT,
    img VARCHAR(255),
    circuito_id INT,
    fecha_inic DATE,
    fecha_fin DATE,
    UNIQUE (circuito_id, fecha_inic, fecha_fin),
    FOREIGN KEY (circuito_id) REFERENCES circuito(id)
);

-- Tabla Carrera
CREATE TABLE carrera (
    id INT PRIMARY KEY AUTO_INCREMENT,
    num_vueltas INT,
    fecha_inic DATETIME UNIQUE,
    safety BOOLEAN,
    gran_premio_id INT,
    FOREIGN KEY (gran_premio_id) REFERENCES gran_premio(id)
);

-- Tabla Clasificacion
CREATE TABLE clasificacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_inic DATETIME UNIQUE,
    gran_premio_id INT,
    FOREIGN KEY (gran_premio_id) REFERENCES gran_premio(id)
);

-- Tabla ResultadoCarrera
CREATE TABLE resultado_carrera (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vuelta_rapida BOOLEAN,
    num_vueltas_completadas INT,
    tiempo_final DECIMAL(10,3),
    posicion INT,
    dnf BOOLEAN,
    piloto_id INT,
    carrera_id INT,
    FOREIGN KEY (piloto_id) REFERENCES piloto(id),
    FOREIGN KEY (carrera_id) REFERENCES carrera(id)
);

-- Tabla ResultadoClasificacion
CREATE TABLE Resultado_clasificacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vuelta_q1 DECIMAL(10,3),
    vuelta_q2 DECIMAL(10,3),
    vuelta_q3 DECIMAL(10,3),
    posicion INT,
    penalizacion BOOLEAN,
    piloto_id INT,
    clasificacion_id INT,
    FOREIGN KEY (piloto_id) REFERENCES piloto(id),
    FOREIGN KEY (clasificacion_id) REFERENCES clasificacion(id)
);

-- Insertar 20 pilotos ficticios
INSERT INTO piloto (nombre, fecha_nac, nacionalidad, img)
VALUES
  ('Lewis Hamilton', '1985-01-07', 'Reino Unido', '/ruta/inventada/hamilton.png'),
  ('Max Verstappen', '1997-09-30', 'Países Bajos', '/ruta/inventada/verstappen.png'),
  ('Charles Leclerc', '1997-10-16', 'Mónaco', '/ruta/inventada/leclerc.png'),
  ('Sebastian Vettel', '1987-07-03', 'Alemania', '/ruta/inventada/vettel.png'),
  ('Valtteri Bottas', '1989-08-28', 'Finlandia', '/ruta/inventada/bottas.png'),
  ('Carlos Sainz', '1994-09-01', 'España', '/ruta/inventada/sainz.png'),
  ('Daniel Ricciardo', '1989-07-01', 'Australia', '/ruta/inventada/ricciardo.png'),
  ('Fernando Alonso', '1981-07-29', 'España', '/ruta/inventada/alonso.png'),
  ('Lando Norris', '1999-11-13', 'Reino Unido', '/ruta/inventada/norris.png'),
  ('Esteban Ocon', '1996-09-17', 'Francia', '/ruta/inventada/ocon.png'),
  ('Pierre Gasly', '1996-02-07', 'Francia', '/ruta/inventada/gasly.png'),
  ('Kimi Räikkönen', '1979-10-17', 'Finlandia', '/ruta/inventada/raikkonen.png'),
  ('Sergio Pérez', '1990-01-26', 'México', '/ruta/inventada/perez.pTRUEng'),
  ('Nicholas Latifi', '1995-06-29', 'Canadá', '/ruta/inventada/latifi.png'),
  ('Yuki Tsunoda', '2000-05-11', 'Japón', '/ruta/inventada/tsunoda.png'),
  ('Lance Stroll', '1998-10-29', 'Canadá', '/ruta/inventada/stroll.png'),
  ('Antonio Giovinazzi', '1993-12-14', 'Italia', '/ruta/inventada/giovinazzi.png'),
  ('George Russell', '1998-02-15', 'Reino Unido', '/ruta/inventada/russell.png'),
  ('Mick Schumacher', '1999-03-22', 'Alemania', '/ruta/inventada/schumacher.png'),
  ('Nikita Mazepin', '1999-03-02', 'Rusia', '/ruta/inventada/mazepin.png'),
  ('Robert Kubica', '1984-12-07', 'Polonia', '/ruta/inventada/kubica.png');

-- Insertar 10 equipos ficticios
INSERT INTO equipo (nombre, fecha_inic, nacionalidad, img)
VALUES
  ('Mercedes-AMG Petronas Formula One Team', '2010-01-01', 'Reino Unido', '/ruta/inventada/mercedes.png'),
  ('Red Bull Racing', '2005-01-01', 'Austria', '/ruta/inventada/redbull.png'),
  ('Scuderia Ferrari', '1950-01-01', 'Italia', '/ruta/inventada/ferrari.png'),
  ('McLaren F1 Team', '1966-01-01', 'Reino Unido', '/ruta/inventada/mclaren.png'),
  ('Alpine F1 Team', '1977-01-01', 'Francia', '/ruta/inventada/alpine.png'),
  ('Scuderia AlphaTauri', '2006-01-01', 'Italia', '/ruta/inventada/alphatauri.png'),
  ('Aston Martin Cognizant Formula One Team', '2021-01-01', 'Reino Unido', '/ruta/inventada/astonmartin.png'),
  ('Alfa Romeo Racing Orlen', '1950-01-01', 'Suiza', '/ruta/inventada/alfaromeo.png'),
  ('Haas F1 Team', '2016-01-01', 'Estados Unidos', '/ruta/inventada/haas.png'),
  ('Williams Racing', '1977-01-01', 'Reino Unido', '/ruta/inventada/williams.png');

-- Insertar datos aproximados en piloto_equipo (basado en información histórica hasta 2022)
INSERT INTO piloto_equipo (piloto_id, equipo_id, fecha_inic, fecha_fin)
VALUES
  -- Lewis Hamilton
  (1, 4, '2007-01-01', '2012-12-31'),
  (1, 1, '2013-01-01', '2022-12-31'),

  -- Max Verstappen
  (2, 2, '2016-01-01', '2022-12-31'),

  -- Charles Leclerc
  (3, 8, '2016-01-01', '2018-12-31'),
  (3, 3, '2019-01-01', '2022-12-31'),

  -- Sebastian Vettel
  (4, 2, '2007-01-01', '2014-12-31'),
  (4, 3, '2015-01-01', '2020-12-31'),
  (4, 7, '2021-01-01', '2022-12-31'),

  -- Valtteri Bottas
  (5, 1, '2017-01-01', '2021-12-31'),
  (5, 7, '2022-01-01', '2022-12-31'),

  -- Carlos Sainz
  (6, 6, '2015-01-01', '2017-12-31'),
  (6, 4, '2018-01-01', '2020-12-31'),
  (6, 3, '2021-01-01', '2022-12-31'),

  -- Daniel Ricciardo
  (7, 8, '2011-01-01', '2018-12-31'),
  (7, 2, '2019-01-01', '2020-12-31'),
  (7, 9, '2021-01-01', '2022-12-31'),

  -- Fernando Alonso
  (8, 5, '2003-01-01', '2006-12-31'),
  (8, 2, '2007-01-01', '2014-12-31'),
  (8, 4, '2015-01-01', '2018-12-31'),
  (8, 5, '2021-01-01', '2022-12-31'),

  -- Lando Norris
  (9, 4, '2019-01-01', '2022-12-31'),

  -- Esteban Ocon
  (10, 5, '2019-01-01', '2020-12-31'),
  (10, 9, '2021-01-01', '2022-12-31');


-- Insertar datos ficticios en Circuito
INSERT INTO circuito (nombre, ciudad, pais, region)
VALUES
  ('Circuito Internacional de Baréin', 'Sakhir', 'Baréin', 'Capital'),
  ('Autódromo Enzo e Dino Ferrari', 'Imola', 'Italia', 'Emilia-Romaña'),
  ('Autódromo Internacional do Algarve', 'Portimão', 'Portugal', 'Algarve'),
  ('Circuito de Barcelona-Cataluña', 'Montmeló', 'España', 'Cataluña'),
  ('Circuito de Mónaco', 'Montecarlo', 'Mónaco', 'Montecarlo'),
  ('Circuito Urbano de Bakú', 'Bakú', 'Azerbaiyán', 'Bakú'),
  ('Circuito Paul Ricard', 'Le Castellet', 'Francia', 'Provenza-Alpes-Costa Azul'),
  ('Red Bull Ring', 'Spielberg', 'Austria', 'Estiria'),
  ('Silverstone Circuit', 'Silverstone', 'Reino Unido', 'Inglaterra');

-- Continuar insertando según sea necesario para otros circuitos


-- Insertar datos ficticios en gran_premio para la temporada 2021
INSERT INTO gran_premio (nombre, fecha_inic, fecha_fin, img_flag, img, circuito_id)
VALUES
  ('Gran Premio de Bahréin', '2021-03-28', '2021-03-28', '/ruta/inventada/bahrain.png', '/ruta/inventada/bahrain_circuito.png', 1),
  ('Gran Premio de Emilia Romaña', '2021-04-18', '2021-04-18', '/ruta/inventada/imola.png', '/ruta/inventada/imola_circuito.png', 2),
  ('Gran Premio de Portugal', '2021-05-02', '2021-05-02', '/ruta/inventada/portugal.png', '/ruta/inventada/portugal_circuito.png', 3),
  ('Gran Premio de España', '2021-05-09', '2021-05-09', '/ruta/inventada/spain.png', '/ruta/inventada/spain_circuito.png', 4),
  ('Gran Premio de Mónaco', '2021-05-23', '2021-05-23', '/ruta/inventada/monaco.png', '/ruta/inventada/monaco_circuito.png', 5),
  ('Gran Premio de Azerbaiyán', '2021-06-06', '2021-06-06', '/ruta/inventada/azerbaijan.png', '/ruta/inventada/azerbaijan_circuito.png', 6),
  ('Gran Premio de Francia', '2021-06-20', '2021-06-20', '/ruta/inventada/france.png', '/ruta/inventada/france_circuito.png', 7),
  ('Gran Premio de Estiria', '2021-06-27', '2021-06-27', '/ruta/inventada/austria.png', '/ruta/inventada/austria_circuito.png', 8),
  ('Gran Premio de Austria', '2021-07-04', '2021-07-04', '/ruta/inventada/austria.png', '/ruta/inventada/austria_circuito.png', 8),
  ('Gran Premio de Gran Bretaña', '2021-07-18', '2021-07-18', '/ruta/inventada/great_britain.png', '/ruta/inventada/great_britain_circuito.png', 9);

-- Continuar insertando según sea necesario para otros Grandes Premios de la temporada 2021

-- Insertar datos ficticios en Carrera para algunos Grandes Premios de la temporada 2021
INSERT INTO carrera (num_vueltas, fecha_inic, safety, gran_premio_id)
VALUES
  (57, '2021-03-28 15:00:00', FALSE, 1),  -- Gran Premio de Bahréin
  (63, '2021-04-18 14:00:00', TRUE, 2),   -- Gran Premio de Emilia Romaña
  (66, '2021-05-02 13:00:00', FALSE, 3),  -- Gran Premio de Portugal
  (66, '2021-05-09 14:00:00', FALSE, 4),  -- Gran Premio de España
  (78, '2021-05-23 14:00:00', FALSE, 5),  -- Gran Premio de Mónaco
  (51, '2021-06-06 14:00:00', FALSE, 6),  -- Gran Premio de Azerbaiyán
  (53, '2021-06-20 14:00:00', FALSE, 7),  -- Gran Premio de Francia
  (71, '2021-06-27 14:00:00', FALSE, 8),  -- Gran Premio de Estiria
  (71, '2021-07-04 14:00:00', FALSE, 9),  -- Gran Premio de Austria
  (52, '2021-07-18 15:00:00', FALSE, 10); -- Gran Premio de Gran Bretaña

-- Continuar insertando según sea necesario para otras carreras

-- Insertar datos ficticios en Clasificacion para algunos Grandes Premios de la temporada 2021
INSERT INTO clasificacion (fecha_inic, gran_premio_id)
VALUES
  ('2021-03-27 15:00:00', 1),  -- Clasificación del Gran Premio de Bahréin
  ('2021-04-17 15:00:00', 2),  -- Clasificación del Gran Premio de Emilia Romaña
  ('2021-05-01 15:00:00', 3),  -- Clasificación del Gran Premio de Portugal
  ('2021-05-08 15:00:00', 4),  -- Clasificación del Gran Premio de España
  ('2021-05-22 15:00:00', 5),  -- Clasificación del Gran Premio de Mónaco
  ('2021-06-05 15:00:00', 6),  -- Clasificación del Gran Premio de Azerbaiyán
  ('2021-06-19 15:00:00', 7),  -- Clasificación del Gran Premio de Francia
  ('2021-06-26 15:00:00', 8),  -- Clasificación del Gran Premio de Estiria
  ('2021-07-03 15:00:00', 9),  -- Clasificación del Gran Premio de Austria
  ('2021-07-17 15:00:00', 10); -- Clasificación del Gran Premio de Gran Bretaña

-- Continuar insertando según sea necesario para otras sesiones de clasificación

-- Insertar datos ficticios en resultado_carrera para algunos Grandes Premios de la temporada 2021
INSERT INTO resultado_carrera (vuelta_rapida, num_vueltas_completadas, posicion, dnf, piloto_id, carrera_id)
VALUES
    (TRUE, 56, 1, FALSE, 1, 1),
    (FALSE, 56, 2, FALSE, 2, 1),
    (FALSE, 56, 3, FALSE, 5, 1),
    (FALSE, 56, 4, FALSE, 9, 1),
    (FALSE, 56, 5, FALSE, 13, 1),
    (FALSE, 56, 6, FALSE, 3, 1),
    (FALSE, 56, 7, FALSE, 7, 1),
    (FALSE, 56, 8, FALSE, 6, 1),
    (FALSE, 56, 9, FALSE, 15, 1),
    (FALSE, 56, 10, FALSE, 16, 1),
    (FALSE, 56, 11, FALSE, 12, 1),
    (FALSE, 55, 12, FALSE, 17, 1),
    (FALSE, 55, 13, FALSE, 10, 1),
    (FALSE, 55, 14, FALSE, 18, 1),
    (FALSE, 55, 15, FALSE, 4, 1),
    (FALSE, 55, 16, FALSE, 19, 1),
    (FALSE, 52, 17, TRUE, 11, 1),
    (FALSE, 51, 18, TRUE, 14, 1),
    (FALSE, 32, 19, TRUE, 8, 1),
    (FALSE, 0, 20, TRUE, 20, 1);