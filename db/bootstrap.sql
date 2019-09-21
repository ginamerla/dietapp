create database dietapp;

use dietapp;

create table categoria_ingrediente (
	id_categoria_ingrediente int auto_increment primary key,
	nombre varchar (30) not null
) engine = innodb;

create table ingrediente (
	id_ingrediente int auto_increment primary key,
	nombre varchar(50) not null,
	id_categoria_ingrediente int not null,
	constraint fk_id_categoria_ingrediente
		foreign key (id_categoria_ingrediente) references categoria_ingrediente(id_categoria_ingrediente)
) engine = innodb;

create table medida(
	id_medida int auto_increment primary key,
	medida varchar(50) not null
)engine=innodb;

create table receta(
	id_receta int auto_increment primary key,
	nombre varchar(100) not null
)engine=innodb;

create table receta_ingrediente(
	id_receta_ingrediente int auto_increment primary key,
	cantidad decimal not null,
	id_receta int,
	id_medida int,
	id_ingrediente int,
	constraint fk_id_receta foreign key (id_receta) references receta(id_receta),
	constraint fk_id_medida foreign key (id_medida) references medida(id_medida),
	constraint fk_id_ingrediente foreign key (id_ingrediente) references ingrediente(id_ingrediente)
)engine=innodb;

create table periodo(
	id_periodo int auto_increment not null primary key,
	periodo varchar(50) not null
)engine=innodb;

create table layout(
	id_layout int auto_increment not null primary key,
	layout varchar(50) not null,
	activo tinyint
)engine=innodb;

create table layout_periodo(
	id_layout_periodo int auto_increment primary key,
	id_layout int,
	id_periodo int,
	constraint fk_id_layout foreign key (id_layout)references layout(id_layout),
	constraint fk_id_periodo foreign key (id_periodo)references periodo(id_periodo)
)engine=innodb;

create table receta_periodo(
	id_receta_periodo int auto_increment primary key,
	id_receta int,
	id_periodo int,
	constraint fk_receta_periodo_id_receta foreign key (id_receta) references receta(id_receta),
	constraint fk_receta_periodo_id_periodo foreign key (id_periodo)references periodo(id_periodo)
)engine=innodb;

create table usuario(
	id_usuario int auto_increment primary key,
	nombre varchar(100) not null,
	email varchar(200) not null
)engine=innodb;

create table usuario_layout(
	id_usuario_layout int primary key auto_increment,
	id_usuario int,
	id_layout int,
	fecha date,
	constraint fk_usuario_layout_id_usuario foreign key (id_usuario) references usuario(id_usuario),
	constraint fk_usuario_layout_id_layout foreign key (id_layout) references layout (id_layout)
)engine=innodb;

create table dieta_usuario(
	id_dieta_usuario int primary key auto_increment,
	id_usuario int,
	dia_semana varchar(30) not null,
	constraint fk_dieta_usuario_id_usuario foreign key (id_usuario) references usuario(id_usuario)
)engine=innodb;

create table combo_dieta_usuario(
	id_combo_dieta_usuario int primary key auto_increment,
	id_dieta_usuario int,
	id_receta_periodo int,
	constraint fk_combo_id_dieta_usuario foreign key (id_dieta_usuario) references dietapp.dieta_usuario(id_dieta_usuario),
	constraint fk_combo_id_receta_periodo foreign key (id_receta_periodo) references dietapp.receta_periodo(id_receta_periodo)
)engine=innodb;








