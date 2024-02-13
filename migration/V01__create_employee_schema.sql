DROP TABLE IF EXISTS public.tb_alternativa_a;

CREATE TABLE public.tb_alternativa_a (
	correta bool NULL,
	id int8 NOT NULL,
	id_questao int8 NULL,
	alternativa varchar(255) NULL
);