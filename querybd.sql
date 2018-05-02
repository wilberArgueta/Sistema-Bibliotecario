CREATE TABLE libros(
    cod_libro INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(25) NOT NULL,
    l_isbm CHAR(13) NOT NULL,
    CONSTRAINT pk_cod_libro PRIMARY KEY(cod_libro),
    CONSTRAINT pk_l_isbm PRIMARY KEY(l_isbm)
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
)

