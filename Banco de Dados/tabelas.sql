begin;
	create table cliente(
		cpf varchar(14),
		email varchar(150) unique,
		nome varchar (150),
		senha varchar(20),
		rua varchar(100),
		num integer,
		bairro varchar(100),
		cidade varchar(300),
		estado varchar(50),
		is_admin boolean,
		primary key (cpf)
	);

	create table categoria(
		id integer,
		nome varchar(25),
		primary key(id)
	);

	create table produto(
		cod serial,
		nome varchar(100),
		valor float,
		descricao varchar(1000),
		imagem bytea,
		modificacao date,
		quant_estoque integer,
		categoria integer,
		primary key (cod),
		foreign key (categoria) references categoria(id)
	);

	create table compra(
		id serial,
		data date,
		quant_compra integer,
		valor_total float,
		cpf varchar(14),
		cod integer,
		primary key (id),
		foreign key (cpf) references cliente,
		foreign key (cod) references produto
	);
	
commit;