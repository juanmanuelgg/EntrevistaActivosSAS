/*
Copyright 2021 Juan Manuel González Garzón

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

-- 1. Creación de la base de datos.
-- Crea la base de datos.
CREATE DATABASE activos; 

-- Para crear el usuario de la aplicación
CREATE USER 'backend_user'@'localhost' IDENTIFIED BY 'Lewis_Bernstein_Kifer_2006';

-- Dar todos los privilegios sobre la base de datos al usuario que se creó.
USE activos;
GRANT ALL PRIVILEGES ON activos.* TO 'backend_user'@'localhost';
FLUSH PRIVILEGES;

--2. Creación de un modelos de tablas.
CREATE TABLE chapter (
    id INTEGER PRIMARY KEY,
    text VARCHAR(300) NOT NULL
);

CREATE TABLE subchapter (
    id INTEGER PRIMARY KEY,
    chapter INTEGER,
    text VARCHAR(300) NOT NULL,
    FOREIGN KEY (chapter) REFERENCES chapter (id)
);

CREATE TABLE topic (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    subchapter INTEGER,
    text VARCHAR(300) NOT NULL,
    FOREIGN KEY (subchapter) REFERENCES subchapter (id)
);
-- Despues de insertar la data, ya van a existir 166 topics precargados.
ALTER TABLE topic AUTO_INCREMENT=167;

CREATE TABLE exercise (
    id INTEGER PRIMARY KEY,
    topic INTEGER,
    text VARCHAR(300) NOT NULL,
    FOREIGN KEY (topic) REFERENCES topic (id)
);

-- -------------------- Sin completar --------------------
--3. Creación de un procedimiento almacenado.
--4. Creación de una función.