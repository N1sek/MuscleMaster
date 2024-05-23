DROP DATABASE IF EXISTS muscle_master;
CREATE DATABASE muscle_master CHARACTER SET utf8mb4;
USE muscle_master;

CREATE TABLE usuarios(
                         ID INTEGER AUTO_INCREMENT PRIMARY KEY,
                         Username TEXT NOT NULL,
                         Password TEXT NOT NULL
);

CREATE TABLE PartidasGuardadas(
                                  IDUsuario INTEGER NOT NULL,
                                  ID INTEGER AUTO_INCREMENT PRIMARY KEY,
                                  Fecha datetime,
                                  NumClicks INTEGER NOT NULL,
                                  BarritaEnergetica int NOT NULL,
                                  BatidoProteico int NOT NULL,
                                  Creatina int NOT NULL,
                                  Testosterona int NOT NULL,
                                  Peso int NOT NULL,
                                  FOREIGN KEY (IDUsuario) REFERENCES usuarios(ID)
);

insert into usuarios values (null,"Manuel","password");

insert into PartidasGuardadas values (1,null,CURRENT_TIMESTAMP,13890,4,3,2,1,2);

select * from PartidasGuardadas;