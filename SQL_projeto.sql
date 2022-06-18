DROP DATABASE IF EXISTS projeto;
CREATE DATABASE projeto;
USE projeto;

DROP TABLE IF EXISTS player;
CREATE TABLE player(
id INT NOT NULL,
nome VARCHAR(50) NOT NULL,
vida INT NOT NULL,
danoTotal INT NOT NULL,
danoBase INT NOT NULL,

vitalidade INT NOT NULL,
forca INT NOT NULL,
sabedoria INT NOT NULL,
inteligencia INT NOT NULL,
destreza INT NOT NULL,

PRIMARY KEY (id)
);

DROP TABLE IF EXISTS arma;
CREATE TABLE arma(
id INT NOT NULL,
nome VARCHAR(50) NOT NULL,
dano INT NOT NULL,
is_equipado BINARY NOT NULL,
player_id INT NOT NULL,

PRIMARY KEY (id),
CONSTRAINT player_id_fk_arma FOREIGN KEY(player_id)
	REFERENCES player(id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS area;
CREATE TABLE area(
id INT,
nome VARCHAR(50) NOT NULL,

PRIMARY KEY (id)
);

DROP TABLE IF EXISTS inimigo;
CREATE TABLE inimigo(
id INT,
nome VARCHAR(50) NOT NULL,
dano INT NOT NULL,
vida INT NOT NULL,

PRIMARY KEY (id)
);

DROP TABLE IF EXISTS inimigo_esta_area;
CREATE TABLE inimigo_esta_area(
area_id INT,
inimigo_id INT,

PRIMARY KEY(area_id,inimigo_id),
CONSTRAINT area_id_fk_tabela FOREIGN KEY(area_id)
	REFERENCES area(id)
    ON DELETE NO ACTION ON UPDATE CASCADE,
CONSTRAINT inimigo_id_fk_tabela FOREIGN KEY(inimigo_id)
	REFERENCES inimigo(id)
    ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP VIEW IF EXISTS player_arma;
CREATE VIEW player_arma AS SELECT P.*, A.id 'id_arma', A.nome 'nome_arma', A.dano, A.is_equipado FROM player AS P, arma AS A WHERE P.id = A.player_id AND A.is_equipado = TRUE;