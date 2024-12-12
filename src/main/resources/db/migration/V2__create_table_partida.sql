CREATE TABLE partida (
    id bigint not null auto_increment,
    local_partida varchar(150),
    inicio DATETIME,
    fim DATETIME,
    duracao INT,
    PRIMARY KEY (id)
);