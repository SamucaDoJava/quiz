-- Inserção das perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, tema) VALUES
(1, 'Qual é o filme mais premiado da história do Oscar?', 'Cinema'),
(2, 'Qual filme venceu o Oscar de Melhor Filme em 2020?', 'Cinema'),
(3, 'Qual filme foi dirigido por Quentin Tarantino?', 'Cinema'),
(4, 'Quem ganhou o Oscar de Melhor Ator em 2021?', 'Cinema'),
(5, 'Qual é o filme mais longo da história?', 'Cinema'),
(6, 'Quem dirigiu o filme ''Interestelar''?', 'Cinema'),
(7, 'Qual é o filme de animação mais bem avaliado no IMDb?', 'Cinema'),
(8, 'Qual ator interpretou o papel principal em ''Clube da Luta''?', 'Cinema'),
(9, 'Qual é o filme brasileiro mais premiado internacionalmente?', 'Cinema'),
(10, 'Qual filme ganhou o Oscar de Melhor Animação em 2019?', 'Cinema'),
(11, 'Quem interpretou o Coringa no filme de 2019?', 'Cinema'),
(12, 'Qual é o filme mais lucrativo de todos os tempos?', 'Cinema'),
(13, 'Qual é o nome do diretor de ''O Labirinto do Fauno''?', 'Cinema'),
(14, 'Qual é o nome do personagem interpretado por Keanu Reeves na trilogia ''Matrix''?', 'Cinema'),
(15, 'Qual filme ganhou o Oscar de Melhor Direção em 2021?', 'Cinema'),
(16, 'Qual ator interpretou o personagem Hannibal Lecter em ''O Silêncio dos Inocentes''?', 'Cinema'),
(17, 'Qual é o nome do robô em ''Ex-Machina''?', 'Cinema'),
(18, 'Qual filme é conhecido por popularizar o formato found footage em filmes de terror?', 'Cinema'),
(19, 'Qual é o primeiro filme da trilogia ''O Poderoso Chefão''?', 'Cinema'),
(20, 'Qual filme ganhou o Oscar de Melhor Fotografia em 2018?', 'Cinema'),
(21, 'Qual filme dirigido por Quentin Tarantino apresenta uma trama não linear?', 'Cinema'),
(22, 'Qual ator interpretou James Bond no filme ''Skyfall''?', 'Cinema'),
(23, 'Qual é o nome do robô em ''Blade Runner''?', 'Cinema'),
(24, 'Qual filme recebeu o apelido ''Cavalo de Tróia'' durante as filmagens?', 'Cinema'),
(25, 'Qual filme ganhou o Oscar de Melhor Direção em 2019?', 'Cinema'),
(26, 'Quem dirigiu o filme ''Os Suspeitos''?', 'Cinema'),
(27, 'Qual é o nome do personagem interpretado por Johnny Depp em ''Piratas do Caribe''?', 'Cinema'),
(28, 'Quem interpretou a Rainha Elizabeth II em ''A Rainha''?', 'Cinema'),
(29, 'Qual filme é conhecido por ter o diálogo ''You cant handle the truth!''?', 'Cinema' );

-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (correta, id, id_questao, alternativa, "letra-referencia") VALUES
(true, 1, 1, 'O Senhor dos Anéis: O Retorno do Rei', 'A'),
(false, 2, 1, 'Titanic', 'B'),
(false, 3, 1, 'Ben-Hur', 'C'),
(false, 4, 1, 'Gandhi', 'D'),

(false, 5, 2, 'Os miseráveis', 'A'),
(false, 6, 2, 'O Poderoso Chefão', 'B'),
(false, 7, 2, '12 Anos de Escravidão', 'C'),
(true, 8, 2, 'Parasita', 'D'),

(true, 9, 3, 'Pulp Fiction', 'A'),
(false, 10, 3, 'Titanic', 'B'),
(false, 11, 3, 'Avatar', 'C'),
(false, 12, 3, 'Forrest Gump', 'D'),

(false, 13, 4, 'Brad Pitt', 'A'),
(false, 14, 4, 'Leonardo DiCaprio', 'B'),
(false, 15, 4, 'Joaquin Phoenix', 'C'),
(true, 16, 4, 'Anthony Hopkins', 'D'),

(false, 17, 5, 'O Senhor dos Anéis: O Retorno do Rei', 'A'),
(false, 18, 5, 'Titanic', 'B'),
(false, 19, 5, 'Gone with the Wind', 'C'),
(true, 20, 5, 'Cleópatra', 'D'),

(true, 21, 6, 'Christopher Nolan', 'A'),
(false, 22, 6, 'Steven Spielberg', 'B'),
(false, 23, 6, 'Quentin Tarantino', 'C'),
(false, 24, 6, 'Martin Scorsese', 'D'),

(false, 25, 7, 'Toy Story', 'A'),
(false, 26, 7, 'O Rei Leão', 'B'),
(false, 27, 7, 'Procurando Nemo', 'C'),
(true, 28, 7, 'Soul', 'D'),

(false, 29, 8, 'Brad Pitt', 'A'),
(false, 30, 8, 'Edward Norton', 'B'),
(false, 31, 8, 'Jared Leto', 'C'),
(true, 32, 8, 'Edward Norton', 'D'),

(false, 33, 9, 'Central do Brasil', 'A'),
(false, 34, 9, 'Cidade de Deus', 'B'),
(false, 35, 9, 'Tropa de Elite', 'C'),
(true, 36, 9, 'O Pagador de Promessas', 'D'),

(true, 37, 10, 'Homem-Aranha no Aranhaverso', 'A'),
(false, 38, 10, 'Viva: A Vida é uma Festa', 'B'),
(false, 39, 10, 'WiFi Ralph: Quebrando a Internet', 'C'),
(false, 40, 10, 'OsIncíveis 2', 'D'),

(false, 41, 11, 'Heath Ledger', 'A'),
(false, 42, 11, 'Jack Nicholson', 'B'),
(false, 43, 11, 'Jared Leto', 'C'),
(true, 44, 11, 'Joaquin Phoenix', 'D'),

(true, 45, 12, 'Avatar', 'A'),
(false, 46, 12, 'Titanic', 'B'),
(false, 47, 12, 'Vingadores: A Era de Ultron', 'C'),
(true, 48, 12, 'Vingadores: Ultimato', 'D'),

(true, 49, 13, 'Guillermo del Toro', 'A'),
(false, 50, 13, 'Christopher Nolan', 'B'),
(false, 51, 13, 'James Cameron', 'C'),
(false, 52, 13, 'Quentin Tarantino', 'D'),

(true, 53, 14, 'Neo', 'A'),
(false, 54, 14, 'Morpheus', 'B'),
(false, 55, 14, 'Trinity', 'C'),
(false, 56, 14, 'Cypher', 'D'),

(true, 57, 15, 'Nomadland', 'A'),
(false, 58, 15, 'Minari', 'B'),
(false, 59, 15, 'Promising Young Woman', 'C'),
(false, 60, 15, 'Mank', 'D'),

(true, 61, 16, 'Anthony Hopkins', 'A'),
(false, 62, 16, 'Al Pacino', 'B'),
(false, 63, 16, 'Jack Nicholson', 'C'),
(false, 64, 16, 'Anthony Hopkins', 'D'),

(true, 65, 17, 'Ava', 'A'),
(false, 66, 17, 'HAL 9000', 'B'),
(false, 67, 17, 'C-3PO', 'C'),
(false, 68, 17, 'R2-D2', 'D'),

(false, 69, 18, 'O Chamado', 'A'),
(false, 70, 18, 'Atividade Paranormal', 'B'),
(false, 71, 18, 'O Sexto Sentido', 'C'),
(true, 72, 18, 'A Bruxa de Blair', 'D'),

(true, 73, 19, 'O Poderoso Chefão', 'A'),
(false, 74, 19, 'O Poderoso Chefão: Parte II', 'B'),
(false, 75, 19, 'O Poderoso Chefão: Parte III', 'C'),
(false, 76, 19, 'Scarface', 'D'),

(true, 77, 20, 'Blade Runner 2049', 'A'),
(false, 78, 20, 'La La Land', 'B'),
(false, 79, 20, 'Moonlight: Sob a Luz do Luar', 'C'),
(false, 80, 20, 'Dunkirk', 'E'),

(true, 81, 21, 'Pulp Fiction', 'A'),
(false, 82, 21, 'Kill Bill: Volume 1', 'B'),
(false, 83, 21, 'Django Livre', 'C'),
(false, 84, 21, 'Bastardos Inglórios', 'D'),
(false, 85, 21, 'Cães de Aluguel', 'E'),

(true, 86, 22, 'Javier Bardem', 'A'),
(false, 87, 22, 'Pierce Brosnan', 'B'),
(false, 88, 22, 'Roger Moore', 'C'),
(false, 89, 22, 'Sean Connery', 'E'),

(true, 90, 23, 'Roy Batty', 'A'),
(false, 91, 23, 'C-3PO', 'B'),
(false, 92, 23, 'R2-D2', 'C'),
(false, 93, 23, 'HAL 9000', 'D'),
(false, 94, 23, 'WALL-E', 'E'),

(false, 95, 24, 'Cidadão Kane', 'A'),
(false, 96, 24, 'E o Vento Levou', 'B'),
(false, 97, 24, 'Apocalypse Now', 'C'),
(true, 98, 24, 'Tubarão', 'D'),
(false, 99, 24, 'O Poderoso Chefão', 'E'),

(true, 100, 25, 'Guillermo del Toro', 'A'),
(false, 101, 25, 'Damien Chazelle', 'B'),
(false, 102, 25, 'La La Land', 'C'),
(false, 103, 25, 'Moonlight: Sob a Luz do Luar', 'D'),

(false, 104, 26, 'David Fincher', 'A'),
(true, 105, 26, 'Denis Villeneuve', 'B'),
(false, 106, 26, 'Christopher Nolan', 'C'),
(false, 107, 26, 'Quentin Tarantino', 'D'),

(true, 108, 27, 'Capitão Jack Sparrow', 'A'),
(false, 109, 27, 'Jack Sparrow', 'B'),
(false, 110, 27, 'Will Turner', 'C'),
(false, 111, 27, 'Barbossa', 'D'),

(false, 112, 28, 'Helen Mirren', 'A'),
(false, 113, 28, 'Meryl Streep', 'B'),
(false, 114, 28, 'Judi Dench', 'C'),
(true, 115, 28, 'Claire Foy', 'D'),

(false, 116, 29, 'Gladiador', 'A'),
(false, 117, 29, 'A Lista de Schindler', 'B'),
(true, 118, 29, 'Questão de Honra', 'C'),
(false, 119, 29, 'Código de Conduta', 'D');

-- Criando configurações do jogo!
INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(1, 10000, 1000, 'Fácil');

INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(2, 15000, 2500, 'Médio');

INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(3, 25000, 4500, 'Difícil');

-- Comecando carga de filmes de terror.
-- Insercao das perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, tema) VALUES
(30, 'Qual é o filme de terror mais icônico de todos os tempos?', 'Filmes Terror'),
(31, 'Em qual filme de terror uma família é aterrorizada por espíritos em sua casa?', 'Filmes Terror'),
(32, 'Quem é o diretor famoso por criar o universo dos monstros da Universal Pictures nos filmes de terror clássicos?', 'Filmes Terror'),
(33, 'Qual filme de terror popularizou o subgênero "slasher" na década de 70, apresentando um assassino mascarado?', 'Filmes Terror'),
(34, 'Qual é o nome do hotel assombrado no filme de terror baseado no livro de Stephen King?', 'Filmes Terror'),
(35, 'Quem dirigiu o clássico filme de terror "Psicose"?', 'Filmes Terror'),
(36, 'Qual filme de terror japonês de 1998 envolve uma fita de vídeo amaldiçoada que causa a morte de quem a assiste em sete dias?', 'Filmes Terror'),
(37, 'Qual é o título do filme de terror sobre um palhaço demoníaco que aterroriza uma pequena cidade?', 'Filmes Terror'),
(38, 'Qual filme de terror acompanha um grupo de amigos enfrentando atividades paranormais após brincar com uma tábua Ouija?', 'Filmes Terror'),
(39, 'Em qual filme de terror uma entidade demoníaca possuí uma boneca?', 'Filmes Terror'),
(40, 'Qual é o filme de terror que se passa em uma casa onde eventos paranormais são investigados por uma equipe de caça-fantasmas?', 'Filmes Terror'),
(41, 'Quem é o diretor de "O Iluminado", uma adaptação cinematográfica de uma obra de Stephen King?', 'Filmes Terror'),
(42, 'Em qual filme de terror uma família é atormentada por uma maldição relacionada a um tabuleiro de jogo?', 'Filmes Terror'),
(43, 'Qual é o filme de terror ambientado em uma floresta onde um grupo enfrenta entidades sobrenaturais?', 'Filmes Terror'),
(44, 'Quem dirigiu o filme de terror "A Bruxa" lançado em 2015?', 'Filmes Terror');


-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (correta, id, id_questao, alternativa, "letra-referencia") VALUES
(true, 120, 30, 'O Exorcista', 'A'),
(false, 121, 30, 'Psicose', 'B'),
(false, 122, 30, 'O Bebê de Rosemary', 'C'),
(false, 123, 30, 'O Chamado', 'D'),

(false, 124, 31, 'Hereditário', 'A'),
(false, 125, 31, 'Corra!', 'B'),
(false, 126, 31, 'Nós', 'C'),
(true, 127, 31, 'Invocação do Mal', 'D'),

(true, 128, 32, 'Alfred Hitchcock', 'A'),
(false, 129, 32, 'Wes Craven', 'B'),
(false, 130, 32, 'John Carpenter', 'C'),
(false, 131, 32, 'Tobe Hooper', 'D'),

(false, 132, 33, 'Halloween', 'A'),
(false, 133, 33, 'Sexta-Feira 13', 'B'),
(false, 134, 33, 'O Massacre da Serra Elétrica', 'C'),
(true, 135, 33, 'A Noite dos Mortos-Vivos', 'D'),

(false, 136, 34, 'Hotel Overlook', 'A'),
(false, 137, 34, 'Hotel Transilvânia', 'B'),
(false, 138, 34, 'Hotel California', 'C'),
(true, 139, 34, 'O Iluminado', 'D'),

(true, 140, 35, 'Alfred Hitchcock', 'A'),
(false, 141, 35, 'Wes Craven', 'B'),
(false, 142, 35, 'John Carpenter', 'C'),
(false, 143, 35, 'Tobe Hooper', 'D'),

(false, 144, 36, 'Ringu', 'A'),
(false, 145, 36, 'A Maldição', 'B'),
(false, 146, 36, 'A Bruxa de Blair', 'C'),
(true, 147, 36, 'O Chamado', 'D'),

(false, 148, 37, 'It: A Coisa', 'A'),
(false, 149, 37, 'Poltergeist', 'B'),
(false, 150, 37, 'A Hora do Pesadelo', 'C'),
(true, 151, 37, 'Ça', 'D'),

(false, 152, 38, 'Atividade Paranormal', 'A'),
(false, 153, 38, 'Invocação do Mal', 'B'),
(false, 154, 38, 'Annabelle', 'C'),
(true, 155, 38, 'Ouija: Origem do Mal', 'D'),

(true, 156, 39, 'Annabelle', 'A'),
(false, 157, 39, 'A Freira', 'B'),
(false, 158, 39, 'Boneco do Mal', 'C'),
(false, 159, 39, 'Atividade Paranormal', 'D'),

(false, 160, 40, 'Invocação do Mal', 'A'),
(false, 161, 40, 'A Maldição da Residência Hill', 'B'),
(false, 162, 40, 'Sobrenatural', 'C'),
(true, 163, 40, 'Os Caça-Fantasmas', 'D'),

(true, 164, 41, 'Stanley Kubrick', 'A'),
(false, 165, 41, 'John Carpenter', 'B'),
(false, 166, 41, 'George A. Romero', 'C'),
(true, 167, 41, 'Stephen King', 'D'),

(true, 168, 42, 'Ouija: Origem do Mal', 'A'),
(false, 169, 42, 'Ouija: Onde Tudo Começou', 'B'),
(false, 170, 42, 'Ouija: A Ressurreição', 'C'),
(false, 171, 42, 'Ouija: O Jogo dos Espíritos', 'D'),

(true, 172, 43, 'A Bruxa de Blair', 'A'),
(false, 173, 43, 'Atividade Paranormal', 'B'),
(false, 174, 43, 'Floresta Maldita', 'C'),
(false, 175, 43, 'A Bruxa', 'D'),

(true, 176, 44, 'Robert Eggers', 'A'),
(false, 177, 44, 'Jordan Peele', 'B'),
(false, 178, 44, 'Ari Aster', 'C'),
(false, 179, 44, 'James Wan', 'D');

-- Criando usuários.

-- Samuel
INSERT INTO public.tb_usuario
(idade, id, apelido, email, nome, nome_completo, senha)
VALUES(38, 1, 'Samucation', 'samuel@email.com', 'Samuel', 'Samuel Ferreira Duarte', '123Mudar');

-- Marcia
INSERT INTO public.tb_usuario
(idade, id, apelido, email, nome, nome_completo, senha)
VALUES(35, 2, 'MarciaDoJava', 'marcia@email.com', 'Marcia', 'Marcia Oliveira', '123Mudar');

-- Marcos
INSERT INTO public.tb_usuario
(idade, id, apelido, email, nome, nome_completo, senha)
VALUES(30, 3, 'Maquinhos', 'marcos@email.com', 'Marcos', 'Marcos Mikio', '123Mudar');
