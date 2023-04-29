create table movies(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    genero varchar(100) not null,
    ano bigint not null,

    primary key(id)
);