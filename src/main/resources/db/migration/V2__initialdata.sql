DROP TABLE IF EXISTS public.tb_alternativa_b;

CREATE TABLE public.tb_alternativa_b (
	correta bool NULL,
	id int8 NOT NULL,
	id_questao int8 NULL,
	alternativa varchar(255) NULL
);