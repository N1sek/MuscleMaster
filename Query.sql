DROP DATABASE IF EXISTS muscle_master;
CREATE DATABASE MuscleMaster CHARACTER SET utf8mb4;
USE muscle_master;

CREATE TABLE usuarios(
	ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    Username TEXT NOT NULL,
    Password TEXT NOT NULL
);

CREATE TABLE PartidasGuardadas(
	ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    IDUsuario INTEGER NOT NULL,
    NumClics INTEGER NOT NULL,
    MejorasDesbloqueadas TEXT,
    FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID)
);

INSERT INTO PartidasGuardadas (IDUsuario, NumClics, MejorasDesbloqueadas) VALUES (1, 100, '');
