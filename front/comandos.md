CREATE TABLE programa(
	id_programa SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE estudiante(
	id_estudiante SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	numero_documento VARCHAR(50),
	email VARCHAR(120) NOT NULL UNIQUE,
	id_programa INT NOT NULL,

	CONSTRAINT fk_estudiante_programa
	FOREIGN KEY (id_programa) REFERENCES programa (id_programa) ON DELETE RESTRICT
)



INSERT INTO programa (nombre) VALUES
('Ingenieria de Sistemas'),
('Derecho');

INSERT INTO estudiante (nombre, email, numero_documento, id_programa) VALUES
('Juan', 'juan@gmail.com', 1075209558, 2);


 CREATE TABLE curso(
	id_curso SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO curso(nombre) VALUES 
('Inglés'),
('Habilidades de poder');


CREATE TABLE matricula(

fecha DATE NOT NULL DEFAULT CURRENT_DATE,
-- llaves foraneas
id_estudiante_fk INT NOT NULL,
id_curso_fk INT NOT NULL,

-- primary key compuesta
primary key(id_matricula,id_estudiante_fk),
-- fk
constraint fk_matricula_estudiante references estudiante(id_estudiante)
on delete cascade
);

