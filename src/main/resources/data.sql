insert into usuario (
	account_expired, 
	account_locked, 
	active, 
	credentials_expired, 
	email, 
	password, 
	roles, 
	username,
	nome,
	peso,
	altura,
	nivel_atividade_fisica
) VALUES (
	false,
	false,
	true,
	false,
	'user@admin.com',
	'$2a$12$yrp1A9bCUvgGjOjY.sf4GeSmFIRUR3B.7naToAD5OuBpG/VKgG2EW',
	'ADMIN',
	'user_admin',
	'Administrador',
	110,
	175,
	'leve'
);

INSERT INTO nivel_atividade_fisica (descricao) VALUES ('Leve');
INSERT INTO nivel_atividade_fisica (descricao) VALUES ('Moderado');
INSERT INTO nivel_atividade_fisica (descricao) VALUES ('Intenso');