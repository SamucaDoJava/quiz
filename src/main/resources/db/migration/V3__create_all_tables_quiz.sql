-- public.tb_tema definition
-- Drop table
-- DROP TABLE public.tb_tema;

CREATE TABLE public.tb_tema (
	id int8 NOT NULL,
	theme varchar(255) NULL,
	CONSTRAINT tb_tema_pkey PRIMARY KEY (id)
);
-- public.tb_questao definition
-- Drop table
-- DROP TABLE public.tb_questao;

CREATE TABLE public.tb_questao (
	id int8 NOT NULL,
	id_tema int8 NULL,
	pergunta varchar(255) NULL,
	CONSTRAINT tb_questao_pkey PRIMARY KEY (id)
);
-- public.tb_questao foreign keys
ALTER TABLE public.tb_questao ADD CONSTRAINT fkjjcc644508coaado9ggcgaj45 FOREIGN KEY (id_tema) REFERENCES public.tb_tema(id);

-- public.tb_alternativa definition
-- Drop table
-- DROP TABLE public.tb_alternativa;

CREATE TABLE public.tb_alternativa (
	correta bool NULL,
	id int8 NOT NULL,
	id_questao int8 NULL,
	alternativa varchar(255) NULL,
	"letra-referencia" varchar(255) NULL,
	CONSTRAINT tb_alternativa_pkey PRIMARY KEY (id)
);
-- public.tb_alternativa foreign keys
ALTER TABLE public.tb_alternativa ADD CONSTRAINT fker2l73jpye38ljoxoj8eejeaa FOREIGN KEY (id_questao) REFERENCES public.tb_questao(id);

-- public.tb_configuracao_jogo definition
-- Drop table
-- DROP TABLE public.tb_configuracao_jogo;

CREATE TABLE public.tb_configuracao_jogo (
	id int8 NOT NULL,
	moeda_inicial int8 NULL,
	pontuacao_por_acerto int8 NULL,
	"level" varchar(255) NULL,
	CONSTRAINT tb_configuracao_jogo_pkey PRIMARY KEY (id)
);

-- public.tb_usuario definition
-- Drop table
-- DROP TABLE public.tb_usuario;

CREATE TABLE public.tb_usuario (
	idade int4 NULL,
	id int8 NOT NULL,
	apelido varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	nome_completo varchar(255) NULL,
	senha varchar(255) NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (id)
);

-- public.tb_sessao_jogador definition
-- Drop table
-- DROP TABLE public.tb_sessao_jogador;

CREATE TABLE public.tb_sessao_jogador (
	sessao_ativada bool NULL,
	id int8 NOT NULL,
	pontuacao int8 NULL,
	usuario_id int8 NULL,
	"level" varchar(255) NULL,
	CONSTRAINT tb_sessao_jogador_pkey PRIMARY KEY (id)
);

-- public.tb_sessao_questao definition
-- Drop table
-- DROP TABLE public.tb_sessao_questao;

CREATE TABLE public.tb_sessao_questao (
	foi_jogado bool NULL,
	jogador_venceu bool NULL,
	questao_ativa bool NULL,
	id int8 NOT NULL,
	questao_id int8 NULL,
	sessao_jogador_id int8 NULL,
	CONSTRAINT tb_sessao_questao_pkey PRIMARY KEY (id)
);

-- public.tb_sessao_questao foreign keys
ALTER TABLE public.tb_sessao_questao ADD CONSTRAINT fkf5wpmx1ui8oscs2k3wyidjtgi FOREIGN KEY (sessao_jogador_id) REFERENCES public.tb_sessao_jogador(id);
ALTER TABLE public.tb_sessao_questao ADD CONSTRAINT fkfey7x3t2cjrt3hwx49bs78p4m FOREIGN KEY (questao_id) REFERENCES public.tb_questao(id);




