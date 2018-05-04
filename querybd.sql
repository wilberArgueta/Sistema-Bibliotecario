CREATE TABLE libros(
    cod_libro INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(25) NOT NULL,
    l_isbm CHAR(13) NOT NULL,
    CONSTRAINT pk_cod_libro PRIMARY KEY(cod_libro)
); 

CREATE TABLE autores(
    cod_autor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    f_nacimiento DATE NOT NULL,
    nacionalidad VARCHAR(25) NOT NULL,
    email VARCHAR(25),
    CONSTRAINT pk_cod_autor PRIMARY KEY(cod_autor)
);

CREATE TABLE editoriales(
    cod_editorial INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    direccion VARCHAR(35) NOT NULL,
    telefono CHAR(13) NOT NULL,
    email VARCHAR(25) NOT NULL,
    CONSTRAINT pk_cod_editorial  PRIMARY KEY(cod_editorial)
    
);

CREATE TABLE usuarios(
    cod_usuario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    f_nacimiento DATE NOT NULL,
     direccion VARCHAR(35) NOT NULL,
    telefono CHAR(13) NOT NULL,
    email VARCHAR(25),
    CONSTRAINT pk_cod_usuario   PRIMARY KEY(cod_usuario)
);

CREATE TABLE tb_libro_autores(
	id_libro_autor INT NOT NULL AUTO_INCREMENT,
    cod_libro INT NOT NULL,
    cod_autor INT NOT NULL,
    CONSTRAINT PK_libro_autores PRIMARY KEY(id_libro_autor),
	CONSTRAINT fk_LA_libro FOREIGN KEY(cod_libro) REFERENCES libros(cod_libro),
    CONSTRAINT fk_LA_autor FOREIGN KEY(cod_autor) REFERENCES autores(cod_autor)
);
CREATE TABLE tb_libro_publicacion(
    id_libro_publicacion INT NOT NULL AUTO_INCREMENT,
    f_publicacion DATE NOT NULL,
    cod_libro INT NOT NULL,
    cod_editorial INT NOT NULL,
    CONSTRAINT pk_libro_publicacion PRIMARY KEY(id_libro_publicacion),
    CONSTRAINT fk_lp_libro FOREIGN KEY(cod_libro) REFERENCES libros(cod_libro),
    CONSTRAINT fk_lp_editorial FOREIGN KEY(cod_editorial) REFERENCES editoriales(cod_editorial)

);

CREATE TABLE tb_alquiler(
    id_alquiler  INT NOT NULL AUTO_INCREMENT,
    f_adquirido DATE NOT NULL,
    f_devolucion DATE NOT NULL,
    cod_libro INT NOT NULL,
    cod_usuario INT NOT NULL,
    CONSTRAINT pk_alquiler PRIMARY KEY(id_alquiler),
    CONSTRAINT fk_a_libro FOREIGN KEY(cod_libro) REFERENCES libros(cod_libro),
    CONSTRAINT fk_a_usuario FOREIGN KEY(cod_usuario) REFERENCES usuarios(cod_usuario)

)
--------------------query sql libros ------
SELECT libros.titulo, autores.nombre,tb_libro_publicacion.f_publicacion,editoriales.nombre FROM `libros`
INNER JOIN tb_libro_autores on tb_libro_autores.cod_libro = libros.cod_libro
INNER JOIN autores on autores.cod_autor = tb_libro_autores.cod_autor
INNER JOIN tb_libro_publicacion ON tb_libro_publicacion.cod_libro = libros.cod_libro
INNER JOIN editoriales on editoriales.cod_editorial = tb_libro_publicacion.cod_editorial

