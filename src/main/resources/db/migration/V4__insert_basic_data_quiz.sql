-- Inserção dos temas na tabela tb_tema
INSERT INTO public.tb_tema (id, theme) VALUES
(1, 'Cinema'),
(2, 'Filme Terror'),
(3, 'Retro Games'),
(4, 'Games Atuais'),
(5, 'Carros de Corrida'),
(6, 'Simpsons'),
(7, 'Mickey'),
(8, 'Turma da Monica'),
(9, 'Chico Bento'),
(10, 'He Man'),
(11, 'She Ha'),
(12, 'Novela');

-- Inserção das perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(1, 'Qual é o filme mais premiado da história do Oscar?', 1),
(2, 'Qual filme venceu o Oscar de Melhor Filme em 2020?', 1),
(3, 'Qual filme foi dirigido por Quentin Tarantino?', 1),
(4, 'Quem ganhou o Oscar de Melhor Ator em 2021?', 1),
(5, 'Qual é o filme mais longo da história?', 1),
(6, 'Quem dirigiu o filme ''Interestelar''?', 1),
(7, 'Qual é o filme de animação mais bem avaliado no IMDb?', 1),
(8, 'Qual ator interpretou o papel principal em ''Clube da Luta''?', 1),
(9, 'Qual é o filme brasileiro mais premiado internacionalmente?', 1),
(10, 'Qual filme ganhou o Oscar de Melhor Animação em 2019?', 1),
(11, 'Quem interpretou o Coringa no filme de 2019?', 1),
(12, 'Qual é o filme mais lucrativo de todos os tempos?', 1),
(13, 'Qual é o nome do diretor de ''O Labirinto do Fauno''?', 1),
(14, 'Qual é o nome do personagem interpretado por Keanu Reeves na trilogia ''Matrix''?', 1),
(15, 'Qual filme ganhou o Oscar de Melhor Direção em 2021?', 1),
(16, 'Qual ator interpretou o personagem Hannibal Lecter em ''O Silêncio dos Inocentes''?', 1),
(17, 'Qual é o nome do robô em ''Ex-Machina''?', 1),
(18, 'Qual filme é conhecido por popularizar o formato found footage em filmes de terror?', 1),
(19, 'Qual é o primeiro filme da trilogia ''O Poderoso Chefão''?', 1),
(20, 'Qual filme ganhou o Oscar de Melhor Fotografia em 2018?', 1),
(21, 'Qual filme dirigido por Quentin Tarantino apresenta uma trama não linear?', 1),
(22, 'Qual ator interpretou James Bond no filme ''Skyfall''?', 1),
(23, 'Qual é o nome do robô em ''Blade Runner''?', 1),
(24, 'Qual filme recebeu o apelido ''Cavalo de Tróia'' durante as filmagens?', 1),
(25, 'Qual filme ganhou o Oscar de Melhor Direção em 2019?', 1),
(26, 'Quem dirigiu o filme ''Os Suspeitos''?', 1),
(27, 'Qual é o nome do personagem interpretado por Johnny Depp em ''Piratas do Caribe''?', 1),
(28, 'Quem interpretou a Rainha Elizabeth II em ''A Rainha''?', 1),
(29, 'Qual filme é conhecido por ter o diálogo ''You cant handle the truth!''?', 1);


-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(1, true, 1, 'O Senhor dos Anéis: O Retorno do Rei', 'A'),
(2, false, 1, 'Titanic', 'B'),
(3, false, 1, 'Ben-Hur', 'C'),
(4, false, 1, 'Gandhi', 'D'),

(5, false, 2, 'Os miseráveis', 'A'),
(6, false, 2, 'O Poderoso Chefão', 'B'),
(7, false, 2, '12 Anos de Escravidão', 'C'),
(8, true, 2, 'Parasita', 'D'),

(9, true, 3, 'Pulp Fiction', 'A'),
(10, false, 3, 'Titanic', 'B'),
(11, false, 3, 'Avatar', 'C'),
(12, false, 3, 'Forrest Gump', 'D'),

(13, false, 4, 'Brad Pitt', 'A'),
(14, false, 4, 'Leonardo DiCaprio', 'B'),
(15, false, 4, 'Joaquin Phoenix', 'C'),
(16, true, 4, 'Anthony Hopkins', 'D'),

(17, false, 5, 'O Senhor dos Anéis: O Retorno do Rei', 'A'),
(18, false, 5, 'Titanic', 'B'),
(19, false, 5, 'Gone with the Wind', 'C'),
(20, true, 5, 'Cleópatra', 'D'),

(21, true, 6, 'Christopher Nolan', 'A'),
(22, false, 6, 'Steven Spielberg', 'B'),
(23, false, 6, 'Quentin Tarantino', 'C'),
(24, false, 6, 'Martin Scorsese', 'D'),

(25, false, 7, 'Toy Story', 'A'),
(26, false, 7, 'O Rei Leão', 'B'),
(27, false, 7, 'Procurando Nemo', 'C'),
(28, true, 7, 'Soul', 'D'),

(29, false, 8, 'Brad Pitt', 'A'),
(30, false, 8, 'Edward Norton', 'B'),
(31, false, 8, 'Jared Leto', 'C'),
(32, true, 8, 'Edward Norton', 'D'),

(33, false, 9, 'Central do Brasil', 'A'),
(34, false, 9, 'Cidade de Deus', 'B'),
(35, false, 9, 'Tropa de Elite', 'C'),
(36, true, 9, 'O Pagador de Promessas', 'D'),

(37, true, 10, 'Homem-Aranha no Aranhaverso', 'A'),
(38, false, 10, 'Viva: A Vida é uma Festa', 'B'),
(39, false, 10, 'WiFi Ralph: Quebrando a Internet', 'C'),
(40, false, 10, 'OsIncíveis 2', 'D'),

(41, false, 11, 'Heath Ledger', 'A'),
(42, false, 11, 'Jack Nicholson', 'B'),
(43, false, 11, 'Jared Leto', 'C'),
(44, true, 11, 'Joaquin Phoenix', 'D'),

(45, true, 12, 'Avatar', 'A'),
(46, false, 12, 'Titanic', 'B'),
(47, false, 12, 'Vingadores: A Era de Ultron', 'C'),
(48, true, 12, 'Vingadores: Ultimato', 'D'),

(49, true, 13, 'Guillermo del Toro', 'A'),
(50, false, 13, 'Christopher Nolan', 'B'),
(51, false, 13, 'James Cameron', 'C'),
(52, false, 13, 'Quentin Tarantino', 'D'),

(53, true, 14, 'Neo', 'A'),
(54, false, 14, 'Morpheus', 'B'),
(55, false, 14, 'Trinity', 'C'),
(56, false, 14, 'Cypher', 'D'),

(57, true, 15, 'Nomadland', 'A'),
(58, false, 15, 'Minari', 'B'),
(59, false, 15, 'Promising Young Woman', 'C'),
(60, false, 15, 'Mank', 'D'),

(61, true, 16, 'Anthony Hopkins', 'A'),
(62, false, 16, 'Al Pacino', 'B'),
(63, false, 16, 'Jack Nicholson', 'C'),
(64, false, 16, 'Anthony Hopkins', 'D'),

(65, true, 17, 'Ava', 'A'),
(66, false, 17, 'HAL 9000', 'B'),
(67, false, 17, 'C-3PO', 'C'),
(68, false, 17, 'R2-D2', 'D'),

(69, false, 18, 'O Chamado', 'A'),
(70, false, 18, 'Atividade Paranormal', 'B'),
(71, false, 18, 'O Sexto Sentido', 'C'),
(72, true, 18, 'A Bruxa de Blair', 'D'),

(73, true, 19, 'O Poderoso Chefão', 'A'),
(74, false, 19, 'O Poderoso Chefão: Parte II', 'B'),
(75, false, 19, 'O Poderoso Chefão: Parte III', 'C'),
(76, false, 19, 'Scarface', 'D'),

(77, true, 20, 'Blade Runner 2049', 'A'),
(78, false, 20, 'La La Land', 'B'),
(79, false, 20, 'Moonlight: Sob a Luz do Luar', 'C'),
(80, false, 20, 'Dunkirk', 'E'),

(81, true, 21, 'Pulp Fiction', 'A'),
(82, false, 21, 'Kill Bill: Volume 1', 'B'),
(83, false, 21, 'Django Livre', 'C'),
(84, false, 21, 'Bastardos Inglórios', 'D'),
(85, false, 21, 'Cães de Aluguel', 'E'),

(86, true, 22, 'Javier Bardem', 'A'),
(87, false, 22, 'Pierce Brosnan', 'B'),
(88, false, 22, 'Roger Moore', 'C'),
(89, false, 22, 'Sean Connery', 'E'),

(90, true, 23, 'Roy Batty', 'A'),
(91, false, 23, 'C-3PO', 'B'),
(92, false, 23, 'R2-D2', 'C'),
(93, false, 23, 'HAL 9000', 'D'),
(94, false, 23, 'WALL-E', 'E'),

(95, false, 24, 'Cidadão Kane', 'A'),
(96, false, 24, 'E o Vento Levou', 'B'),
(97, false, 24, 'Apocalypse Now', 'C'),
(98, true, 24, 'Tubarão', 'D'),
(99, false, 24, 'O Poderoso Chefão', 'E'),

(100, true, 25, 'Guillermo del Toro', 'A'),
(101, false, 25, 'Damien Chazelle', 'B'),
(102, false, 25, 'La La Land', 'C'),
(103, false, 25, 'Moonlight: Sob a Luz do Luar', 'D'),

(104, false, 26, 'David Fincher', 'A'),
(105, true, 26, 'Denis Villeneuve', 'B'),
(106, false, 26, 'Christopher Nolan', 'C'),
(107, false, 26, 'Quentin Tarantino', 'D'),

(108, true, 27, 'Capitão Jack Sparrow', 'A'),
(109, false, 27, 'Jack Sparrow', 'B'),
(110, false, 27, 'Will Turner', 'C'),
(111, false, 27, 'Barbossa', 'D'),

(112, false, 28, 'Helen Mirren', 'A'),
(113, false, 28, 'Meryl Streep', 'B'),
(114, false, 28, 'Judi Dench', 'C'),
(115, true, 28, 'Claire Foy', 'D'),

(116, false, 29, 'Gladiador', 'A'),
(117, false, 29, 'A Lista de Schindler', 'B'),
(118, true, 29, 'Questão de Honra', 'C'),
(119, false, 29, 'Código de Conduta', 'D');

-- Criando configurações do jogo!
INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(1, 10000, 1000, 'Facil');

INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(2, 15000, 2500, 'Medio');

INSERT INTO public.tb_configuracao_jogo
(id, moeda_inicial, pontuacao_por_acerto, "level")
VALUES(3, 25000, 4500, 'Dificil');

-- Comecando carga de filmes de terror.
-- Insercao das perguntas na tabela tb_questao
-- Inserção das perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(30, 'Qual é o filme de terror mais icônico de todos os tempos?', 2),
(31, 'Em qual filme de terror uma família é aterrorizada por espíritos em sua casa?', 2),
(32, 'Quem é o diretor famoso por criar o universo dos monstros da Universal Pictures nos filmes de terror clássicos?', 2),
(33, 'Qual filme de terror popularizou o subgênero "slasher" na década de 70, apresentando um assassino mascarado?', 2),
(34, 'Qual é o nome do hotel assombrado no filme de terror baseado no livro de Stephen King?', 2),
(35, 'Quem dirigiu o clássico filme de terror "Psicose"?', 2),
(36, 'Qual filme de terror japonês de 1998 envolve uma fita de vídeo amaldiçoada que causa a morte de quem a assiste em sete dias?', 2),
(37, 'Qual é o título do filme de terror sobre um palhaço demoníaco que aterroriza uma pequena cidade?', 2),
(38, 'Qual filme de terror acompanha um grupo de amigos enfrentando atividades paranormais após brincar com uma tábua Ouija?', 2),
(39, 'Em qual filme de terror uma entidade demoníaca possuí uma boneca?', 2),
(40, 'Qual é o filme de terror que se passa em uma casa onde eventos paranormais são investigados por uma equipe de caça-fantasmas?', 2),
(41, 'Quem é o diretor de "O Iluminado", uma adaptação cinematográfica de uma obra de Stephen King?', 2),
(42, 'Em qual filme de terror uma família é atormentada por uma maldição relacionada a um tabuleiro de jogo?', 2),
(43, 'Qual é o filme de terror ambientado em uma floresta onde um grupo enfrenta entidades sobrenaturais?', 2),
(44, 'Quem dirigiu o filme de terror "A Bruxa" lançado em 2015?', 2);


-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(120, true, 30, 'O Exorcista', 'A'),
(121, false, 30, 'Psicose', 'B'),
(122, false, 30, 'O Bebê de Rosemary', 'C'),
(123, false, 30, 'O Chamado', 'D'),

(124, false, 31, 'Hereditário', 'A'),
(125, false, 31, 'Corra!', 'B'),
(126, false, 31, 'Nós', 'C'),
(127, true, 31, 'Invocação do Mal', 'D'),

(128, true, 32, 'Alfred Hitchcock', 'A'),
(129, false, 32, 'Wes Craven', 'B'),
(130, false, 32, 'John Carpenter', 'C'),
(131, false, 32, 'Tobe Hooper', 'D'),

(132, false, 33, 'Halloween', 'A'),
(133, false, 33, 'Sexta-Feira 13', 'B'),
(134, false, 33, 'O Massacre da Serra Elétrica', 'C'),
(135, true, 33, 'A Noite dos Mortos-Vivos', 'D'),

(136, false, 34, 'Hotel Overlook', 'A'),
(137, false, 34, 'Hotel Transilvânia', 'B'),
(138, false, 34, 'Hotel California', 'C'),
(139, true, 34, 'O Iluminado', 'D'),

(140, true, 35, 'Alfred Hitchcock', 'A'),
(141, false, 35, 'Wes Craven', 'B'),
(142, false, 35, 'John Carpenter', 'C'),
(143, false, 35, 'Tobe Hooper', 'D'),

(144, false, 36, 'Ringu', 'A'),
(145, false, 36, 'A Maldição', 'B'),
(146, false, 36, 'A Bruxa de Blair', 'C'),
(147, true, 36, 'O Chamado', 'D'),

(148, false, 37, 'It: A Coisa', 'A'),
(149, false, 37, 'Poltergeist', 'B'),
(150, false, 37, 'A Hora do Pesadelo', 'C'),
(151, true, 37, 'Ça', 'D'),

(152, false, 38, 'Atividade Paranormal', 'A'),
(153, false, 38, 'Invocação do Mal', 'B'),
(154, false, 38, 'Annabelle', 'C'),
(155, true, 38, 'Ouija: Origem do Mal', 'D'),

(156, true, 39, 'Annabelle', 'A'),
(157, false, 39, 'A Freira', 'B'),
(158, false, 39, 'Boneco do Mal', 'C'),
(159, false, 39, 'Atividade Paranormal', 'D'),

(160, false, 40, 'Invocação do Mal', 'A'),
(161, false, 40, 'A Maldição da Residência Hill', 'B'),
(162, false, 40, 'Sobrenatural', 'C'),
(163, true, 40, 'Os Caça-Fantasmas', 'D'),

(164, true, 41, 'Stanley Kubrick', 'A'),
(165, false, 41, 'John Carpenter', 'B'),
(166, false, 41, 'George A. Romero', 'C'),
(167, true, 41, 'Stephen King', 'D'),

(168, true, 42, 'Ouija: Origem do Mal', 'A'),
(169, false, 42, 'Ouija: Onde Tudo Começou', 'B'),
(170, false, 42, 'Ouija: A Ressurreição', 'C'),
(171, false, 42, 'Ouija: O Jogo dos Espíritos', 'D'),

(172, true, 43, 'A Bruxa de Blair', 'A'),
(173, false, 43, 'Atividade Paranormal', 'B'),
(174, false, 43, 'Floresta Maldita', 'C'),
(175, false, 43, 'A Bruxa', 'D'),

(176, true, 44, 'Robert Eggers', 'A'),
(177, false, 44, 'Jordan Peele', 'B'),
(178, false, 44, 'Ari Aster', 'C'),
(179, false, 44, 'James Wan', 'D');


-- Inserção de perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(45, 'Qual é o jogo de mundo aberto que se passa na cidade de Night City?', 4),
(46, 'Em qual jogo os jogadores lutam para ser o último sobrevivente em um campo de batalha?', 4),
(47, 'Quem é o protagonista do jogo "God of War" lançado em 2018?', 4),
(48, 'Qual jogo da franquia "The Legend of Zelda" foi lançado para o Nintendo Switch em 2017?', 4),
(49, 'Qual é o título do jogo que apresenta um caçador de monstros chamado Geralt de Rívia?', 4),
(50, 'Em qual jogo os jogadores controlam um grupo de sobreviventes em um mundo pós-apocalíptico?', 4),
(51, 'Qual é o nome do jogo em que os jogadores constroem e gerenciam sua própria cidade?', 4),
(52, 'Qual jogo de ação e aventura segue a jornada de um jovem chamado Aloy em um mundo pós-apocalíptico?', 4),
(53, 'Em qual jogo os jogadores exploram um vasto universo gerado proceduralmente?', 4),
(54, 'Qual é o título do jogo em que os jogadores assumem o papel de um assassino contratado?', 4),
(55, 'Quem é o protagonista de "The Witcher 3: Wild Hunt"?', 4),
(56, 'Em qual jogo os jogadores enfrentam inimigos em um cenário medieval?', 4),
(57, 'Qual é o título do jogo em que os jogadores controlam um grupo de aventureiros em busca de tesouros?', 4),
(58, 'Quem é o personagem principal da série de jogos "Assassin''s Creed"?', 4),
(59, 'Em qual jogo os jogadores constroem e gerenciam seu próprio parque temático?', 4);


-- Inserção de alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(180, true, 45, 'Cyberpunk 2077', 'A'),
(181, false, 45, 'Grand Theft Auto V', 'B'),
(182, false, 45, 'Red Dead Redemption 2', 'C'),
(183, false, 45, 'The Elder Scrolls V: Skyrim', 'D'),

(184, false, 46, 'Fortnite', 'A'),
(185, false, 46, 'Apex Legends', 'B'),
(186, true, 46, 'PlayerUnknown''s Battlegrounds (PUBG)', 'C'),
(187, false, 46, 'Call of Duty: Warzone', 'D'),

(188, true,  47, 'Kratos', 'A'),
(189, false, 47, 'Nathan Drake', 'B'),
(190, false, 47, 'Aloy', 'C'),
(191, false, 47, 'Joel', 'D'),

(192, false, 48, 'The Legend of Zelda: Ocarina of Time', 'A'),
(193, false, 48, 'The Legend of Zelda: A Link to the Past', 'B'),
(194, false, 48, 'The Legend of Zelda: Majora''s Mask', 'C'),
(195, true,  48, 'The Legend of Zelda: Breath of the Wild', 'D'),

(196, false, 49, 'Dark Souls', 'A'),
(197, true,  49, 'The Witcher 3: Wild Hunt', 'B'),
(198, false, 49, 'Bloodborne', 'C'),
(199, false, 49, 'Dragon Age: Inquisition', 'D'),

(200, false, 50, 'Fallout 4', 'A'),
(201, false, 50, 'The Last of Us Part II', 'B'),
(202, false, 50, 'Dying Light', 'C'),
(203, true,  50, 'State of Decay 2', 'D'),

(204, false, 51, 'Cities: Skylines', 'A'),
(205, false, 51, 'SimCity', 'B'),
(206, true,  51, 'Stellaris', 'C'),
(207, false, 51, 'Anno 1800', 'D'),

(208, false, 52, 'Horizon Zero Dawn', 'A'),
(209, false, 52, 'The Last of Us Part II', 'B'),
(210, false, 52, 'Days Gone', 'C'),
(211, true,  52, 'God of War', 'D'),

(212, false, 53, 'Fallout: New Vegas', 'A'),
(213, false, 53, 'No Man''s Sky', 'B'),
(214, false, 53, 'Elite Dangerous', 'C'),
(215, true,  53, 'Minecraft', 'D'),

(216, false, 54, 'Metal Gear Solid V: The Phantom Pain', 'A'),
(217, false, 54, 'Deus Ex: Human Revolution', 'B'),
(218, false, 54, 'Dishonored', 'C'),
(219, true,  54, 'Sonic Forces', 'D'),

(220, false, 55, 'Ezio Auditore', 'A'),
(221, true,  55, 'Geralt de Rívia', 'B'),
(222, false, 55, 'Aloy', 'C'),
(223, false, 55, 'Joel', 'D'),

(224, false, 56, 'Dark Souls III', 'A'),
(225, false, 56, 'Bloodborne', 'B'),
(226, false, 56, 'Nioh', 'C'),
(227, true,  56, 'Kingdom Come: Deliverance', 'D'),

(228, false, 57, 'Dungeons & Dragons', 'A'),
(229, true,  57, 'Divinity: Original Sin II', 'B'),
(230, false, 57, 'Baldur''s Gate III', 'C'),
(231, false, 57, 'Diablo III', 'D'),

(232, false, 58, 'Ezio Auditore', 'A'),
(233, false, 58, 'Edward Kenway', 'B'),
(234, false, 58, 'Aveline de Grandpré', 'C'),
(235, true,  58, 'Desmond Miles', 'D'),

(236, false, 59, 'RollerCoaster Tycoon', 'A'),
(237, false, 59, 'SimCity', 'B'),
(238, true,  59, 'Planet Zoo', 'C'),
(239, false, 59, 'Zoo Tycoon', 'D');

-- Inserção de perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(60, 'Qual é a categoria de carros de corrida conhecida por competições em circuitos ovais?', 5),
(61, 'Em qual ano ocorreu a primeira corrida de Fórmula 1?', 5),
(62, 'Qual é a corrida de resistência mais famosa e prestigiada do mundo?', 5),
(63, 'Quem é considerado o maior piloto de todos os tempos na Fórmula 1?', 5),
(64, 'Qual equipe de Fórmula 1 é conhecida como "Scuderia"?', 5),
(65, 'Em que país nasceu Ayrton Senna, um dos maiores pilotos de Fórmula 1?', 5),
(66, 'Qual pista de corrida é conhecida como "A Casa da Ferrari"?', 5),
(67, 'Quem é o piloto brasileiro de Fórmula 1 que ganhou três títulos mundiais?', 5),
(68, 'Qual é o nome do troféu concedido ao vencedor das 24 Horas de Le Mans?', 5),
(69, 'Qual é a categoria de carros de corrida com chassis tubular e rodas cobertas?', 5),
(70, 'Quem é conhecido como o "Rei de Nürburgring"?', 5),
(71, 'Qual equipe de Fórmula 1 é conhecida como "A Prata das Flechas de Prata"?', 5),
(72, 'Em que ano ocorreu o primeiro Grande Prêmio de Mônaco?', 5),
(73, 'Qual é o circuito de corrida conhecido como "A Pista da Catalunha"?', 5),
(74, 'Qual é o país de origem da equipe de Fórmula 1 Red Bull Racing?', 5);

-- Inserção de alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(240, true, 60, 'NASCAR', 'A'),
(241, false, 60, 'Fórmula 1', 'B'),
(242, false, 60, 'Rally', 'C'),
(243, false, 60, 'IndyCar', 'D'),

(244, false, 61, '1950', 'A'),
(245, true, 61, '1950', 'B'),
(246, false, 61, '1960', 'C'),
(247, false, 61, '1970', 'D'),

(248, false, 62, '24 Horas de Daytona', 'A'),
(249, false, 62, 'Rali de Monte Carlo', 'B'),
(250, true, 62, '24 Horas de Le Mans', 'C'),
(251, false, 62, 'Indianápolis 500', 'D'),

(252, false, 63, 'Sebastian Vettel', 'A'),
(253, true,  63, 'Ayrton Senna', 'B'),
(254, false, 63, 'Lewis Hamilton', 'C'),
(255, false, 63, 'Michael Schumacher', 'D'),

(256, false, 64, 'Mercedes', 'A'),
(257, true,  64, 'Ferrari', 'B'),
(258, false, 64, 'Red Bull Racing', 'C'),
(259, false, 64, 'McLaren', 'D'),

(260, false, 65, 'Argentina', 'A'),
(261, true,  65, 'Brasil', 'B'),
(262, false, 65, 'Itália', 'C'),
(263, false, 65, 'Alemanha', 'D'),

(264, false, 66, 'Circuito de Mônaco', 'A'),
(265, true,  66, 'Autódromo de Monza', 'B'),
(266, false, 66, 'Circuito das Américas', 'C'),
(267, false, 66, 'Silverstone', 'D'),

(268, false, 67, 'Felipe Massa', 'A'),
(269, true,  67, 'Nelson Piquet', 'B'),
(270, false, 67, 'Rubens Barrichello', 'C'),
(271, false, 67, 'Emerson Fittipaldi', 'D'),

(272, false, 68, 'Troféu de Ouro', 'A'),
(273, false, 68, 'Troféu de Platina', 'B'),
(274, true,  68, 'Troféu Le Mans', 'C'),
(275, false, 68, 'Troféu das 24 Horas', 'D'),

(276, false, 69, 'Fórmula 1', 'A'),
(277, false, 69, 'IndyCar', 'B'),
(278, true,  69, 'Protótipos LMP', 'C'),
(279, false, 69, 'Rally', 'D'),

(280, true,  70, 'Niki Lauda', 'A'),
(281, false, 70, 'Ayrton Senna', 'B'),
(282, false, 70, 'Alain Prost', 'C'),
(283, false, 70, 'Michael Schumacher', 'D'),

(284, false, 71, 'Mercedes', 'A'),
(285, false, 71, 'Red Bull Racing', 'B'),
(286, false, 71, 'McLaren', 'C'),
(287, true,  71, 'Mercedes', 'D'),

(288, true,  72, '1929', 'A'),
(289, false, 72, '1950', 'B'),
(290, false, 72, '1965', 'C'),
(291, false, 72, '1980', 'D'),

(292, false, 73, 'Circuito de Spa-Francorchamps', 'A'),
(293, true,  73, 'Circuit de Barcelona-Catalunya', 'B'),
(294, false, 73, 'Circuito de Suzuka', 'C'),
(295, false, 73, 'Circuito de Silverstone', 'D'),

(296, false, 74, 'Inglaterra', 'A'),
(297, false, 74, 'Alemanha', 'B'),
(298, false, 74, 'Itália', 'C'),
(299, true,  74, 'Áustria', 'D');

INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(75, 'Qual equipe de Fórmula 1 é conhecida como "Scuderia Ferrari"?', 6),
(76, 'Quem detém o recorde de maior número de campeonatos mundiais de Fórmula 1?', 6),
(77, 'Qual circuito sediou o primeiro Grande Prêmio de Fórmula 1?', 6),
(78, 'Quantas corridas compõem a temporada típica de Fórmula 1?', 6),
(79, 'Qual piloto de Fórmula 1 é conhecido como "The Flying Finn"?', 6),
(80, 'Qual piloto brasileiro de Fórmula 1 é tricampeão mundial?', 6),
(81, 'Em que ano Ayrton Senna conquistou seu primeiro campeonato mundial de Fórmula 1?', 6),
(82, 'Qual é a equipe de Fórmula 1 associada ao bilionário britânico Sir Frank Williams?', 6),
(83, 'Qual piloto de Fórmula 1 é conhecido como "The Professor"?', 6),
(84, 'Quantas equipes geralmente participam de uma corrida de Fórmula 1?', 6),
(85, 'Qual piloto alemão de Fórmula 1 é heptacampeão mundial?', 6),
(86, 'Em que ano Michael Schumacher conquistou seu primeiro título de Fórmula 1?', 6),
(87, 'Qual é o modelo de carro de Fórmula 1 da equipe Mercedes na temporada de 2022?', 6),
(88, 'Quem é o chefe da equipe de Fórmula 1 Red Bull Racing?', 6),
(89, 'Quantos pontos um piloto de Fórmula 1 ganha por uma vitória?', 6),
(90, 'Qual é o país de origem da equipe de Fórmula 1 McLaren?', 6),
(91, 'Qual é a última corrida do calendário da Fórmula 1 em uma temporada típica?', 6),
(92, 'Quem é conhecido como "The Iceman" na Fórmula 1?', 6),
(93, 'Em que ano a categoria de Fórmula 1 foi inaugurada?', 6),
(94, 'Qual equipe de Fórmula 1 é chamada de "Silver Arrows"?', 6);

INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(300, false, 75, 'Mercedes', 'A'),
(301, false, 75, 'Red Bull Racing', 'B'),
(302, false, 75, 'McLaren', 'C'),
(303, true,  75, 'Ferrari', 'D'),

(304, false, 76, 'Michael Schumacher', 'A'),
(305, false, 76, 'Ayrton Senna', 'B'),
(306, false, 76, 'Lewis Hamilton', 'C'),
(307, true,  76, 'Juan Manuel Fangio', 'D'),

(308, false, 77, 'Monza', 'A'),
(309, false, 77, 'Silverstone', 'B'),
(310, false, 77, 'Monte Carlo', 'C'),
(311, true,  77, 'Silverstone', 'D'),

(312, false, 78, '18', 'A'),
(313, false, 78, '20', 'B'),
(314, false, 78, '22', 'C'),
(315, true,  78, '23', 'D'),

(316, false, 79, 'Sebastian Vettel', 'A'),
(317, false, 79, 'Lewis Hamilton', 'B'),
(318, false, 79, 'Fernando Alonso', 'C'),
(319, true,  79, 'Kimi Räikkönen', 'D'),

(320, false, 80, 'Nelson Piquet', 'A'),
(321, false, 80, 'Rubens Barrichello', 'B'),
(322, false, 80, 'Felipe Massa', 'C'),
(323, true,  80, 'Ayrton Senna', 'D'),

(324, false, 81, '1986', 'A'),
(325, false, 81, '1987', 'B'),
(326, false, 81, '1988', 'C'),
(327, true,  81, '1988', 'D'),

(328, false, 82, 'McLaren', 'A'),
(329, false, 82, 'Red Bull Racing', 'B'),
(330, false, 82, 'Ferrari', 'C'),
(331, true,  82, 'Williams', 'D'),

(332, false, 83, 'Nelson Piquet', 'A'),
(333, false, 83, 'Alain Prost', 'B'),
(334, false, 83, 'Ayrton Senna', 'C'),
(335, true,  83, 'Alain Prost', 'C'),

(336, false, 84, '8', 'A'),
(337, false, 84, '10', 'B'),
(338, false, 84, '12', 'C'),
(339, true,  84, '10', 'D'),

(340, false, 85, 'Sebastian Vettel', 'A'),
(341, false, 85, 'Michael Schumacher', 'B'),
(342, false, 85, 'Fernando Alonso', 'C'),
(343, true,  85, 'Lewis Hamilton', 'D'),

(344, false, 86, '1992', 'A'),
(345, false, 86, '1993', 'B'),
(346, false, 86, '1994', 'C'),
(347, true,  86, '1994', 'D'),

(348, false, 87, 'W13', 'A'),
(349, false, 87, 'RB18', 'B'),
(350, false, 87, 'MCL36', 'C'),
(351, true,  87, 'W13', 'D'),

(352, false, 88, 'Christian Horner', 'A'),
(353, false, 88, 'Ross Brawn', 'B'),
(354, false, 88, 'Toto Wolff', 'C'),
(355, true,  88, 'Helmut Marko', 'D'),

(356, false, 89, '12', 'A'),
(357, false, 89, '15', 'B'),
(358, false, 89, '18', 'C'),
(359, true,  89, '25', 'D'),

(360, false, 90, 'Itália', 'A'),
(361, false, 90, 'Reino Unido', 'B'),
(362, false, 90, 'Alemanha', 'C'),
(363, true,  90, 'Reino Unido', 'D'),

(364, false, 91, 'Abu Dhabi Grand Prix', 'A'),
(365, false, 91, 'Brazilian Grand Prix', 'B'),
(366, false, 91, 'Monaco Grand Prix', 'C'),
(367, true,  91, 'Abu Dhabi Grand Prix', 'D'),

(368, false, 92, 'Sebastian Vettel', 'A'),
(369, false, 92, 'Fernando Alonso', 'B'),
(370, false, 92, 'Lewis Hamilton', 'C'),
(371, true,  92, 'Kimi Räikkönen', 'D'),

(372, false, 93, '1948', 'A'),
(373, false, 93, '1950', 'B'),
(374, false, 93, '1960', 'C'),
(375, true,  93, '1950', 'D'),

(376, false, 94, 'Red Bull Racing', 'A'),
(377, false, 94, 'Ferrari', 'B'),
(378, false, 94, 'McLaren', 'C'),
(379, true,  94, 'Mercedes', 'D');

INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(95, 'Qual é o nome do patriarca da família Simpson?', 6),
(96, 'Onde a família Simpson mora?', 6),
(97, 'Como se chama o melhor amigo de Homer Simpson?', 6),
(98, 'Qual é a bebida favorita de Homer?', 6),
(99, 'Qual é o nome da professora da escola primária de Springfield?', 6),
(100, 'Como se chama o dono da taverna frequentada por Homer?', 6),
(101, 'Qual é o nome do chefe de Homer na Usina Nuclear de Springfield?', 6),
(102, 'Como se chama a irmã mais nova de Marge Simpson?', 6),
(103, 'Qual é o nome do filho mais novo de Homer e Marge?', 6),
(104, 'Quem é o gato preto da família Simpson?', 6),
(105, 'Qual é o sobrenome da família de Homer?', 6),
(106, 'Quem é o palhaço da cidade de Springfield?', 6),
(107, 'Como se chama o diretor da escola de Springfield?', 6),
(108, 'Qual é a marca de cerveja preferida de Homer?', 6),
(109, 'Quem é o garçom que trabalha na taverna de Moe?', 6);

-- Inserção das alternativas sobre Simpsons
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(380, false, 95, 'Ned Flanders', 'A'),
(381, false, 95, 'Moe Szyslak', 'B'),
(382, false, 95, 'Barney Gumble', 'C'),
(383, true, 95, 'Homer Simpson', 'D'),

(384, false, 96, 'Quahog', 'A'),
(385, false, 96, 'Springfield', 'B'),
(386, false, 96, 'South Park', 'C'),
(387, true,  96, 'Evergreen Terrace', 'D'),

(388, false, 97, 'Ned Flanders', 'A'),
(389, false, 97, 'Apu Nahasapeemapetilon', 'B'),
(390, false, 97, 'Moe Szyslak', 'C'),
(391, true, 97, 'Barney Gumble', 'D'),

(392, false, 98, 'Refrigerante', 'A'),
(393, false, 98, 'Água', 'B'),
(394, false, 98, 'Café', 'C'),
(395, true, 98, 'Cerveja', 'D'),

(396, false, 99, 'Sra. Hoover', 'A'),
(397, false, 99, 'Sra. Krabappel', 'B'),
(398, false, 99, 'Sra. Wiggum', 'C'),
(399, true,  99, 'Sra. Krabappel', 'D'),

(400, false, 100, 'Apu Nahasapeemapetilon', 'A'),
(401, false, 100, 'Barney Gumble', 'B'),
(402, false, 100, 'Ned Flanders', 'C'),
(403, true,  100, 'Moe Szyslak', 'D'),

(404, false, 101, 'Sr. Burns', 'A'),
(405, false, 101, 'Ned Flanders', 'B'),
(406, false, 101, 'Apu Nahasapeemapetilon', 'C'),
(407, true,  101, 'Sr. Burns', 'D'),

(408, false, 102, 'Patty Bouvier', 'A'),
(409, false, 102, 'Selma Bouvier', 'B'),
(410, false, 102, 'Maggie Simpson', 'C'),
(411, true,  102, 'Selma Bouvier', 'D'),

(412, false, 103, 'Bart Simpson', 'A'),
(413, false, 103, 'Maggie Simpson', 'B'),
(414, false, 103, 'Lisa Simpson', 'C'),
(415, true,  103, 'Maggie Simpson', 'D'),

(416, false, 104, 'Snowball II', 'A'),
(417, false, 104, 'Santa''s Little Helper', 'B'),
(418, false, 104, 'Plopper', 'C'),
(419, true,  104, 'Santa''s Little Helper', 'D'),

(420, false, 105, 'Smith', 'A'),
(421, false, 105, 'Wiggum', 'B'),
(422, false, 105, 'Lovejoy', 'C'),
(423, true,  105, 'Simpson', 'D'),

(424, false, 106, 'Krusty o Palhaço', 'A'),
(425, false, 106, 'Sideshow Bob', 'B'),
(426, false, 106, 'Krusty Jr.', 'C'),
(427, true,  106, 'Krusty o Palhaço', 'D'),

(428, false, 107, 'Principal Skinner', 'A'),
(429, false, 107, 'Ned Flanders', 'B'),
(430, false, 107, 'Marge Simpson', 'C'),
(431, true,  107, 'Principal Skinner', 'D'),

(432, false, 108, 'Duff', 'A'),
(433, false, 108, 'Fudd', 'B'),
(434, false, 108, 'Pabst', 'C'),
(435, true,  108, 'Duff', 'D'),

(436, false, 109, 'Abe Simpson', 'A'),
(437, false, 109, 'Jasper Beardley', 'B'),
(438, false, 109, 'Gil Gunderson', 'C'),
(439, true,  109, 'Moe Szyslak', 'D');

-- Inserção de perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(110, 'Qual é o nome do cachorro de Mickey Mouse?', 7),
(111, 'Quem é o melhor amigo de Mickey Mouse?', 7),
(112, 'Qual é o nome da namorada de Mickey Mouse?', 7),
(113, 'Em que ano Mickey Mouse fez sua primeira aparição?', 7),
(114, 'Qual é a principal característica física de Mickey Mouse?', 7),
(115, 'Quem é o criador de Mickey Mouse?', 7),
(116, 'Qual é o filme de estreia de Mickey Mouse?', 7),
(117, 'Qual é a cor das calças de Mickey Mouse?', 7),
(118, 'Em que lugar Mickey Mouse vive?', 7),
(119, 'Qual é o nome do pato amigo de Mickey Mouse?', 7),
(120, 'Qual é o nome do gato que é inimigo de Mickey Mouse?', 7),
(121, 'Em qual data celebramos o aniversário de Mickey Mouse?', 7),
(122, 'Qual é a forma das orelhas de Mickey Mouse?', 7),
(123, 'Qual é a principal característica de Pluto, o cachorro de Mickey Mouse?', 7),
(124, 'Qual é o sobrenome de Mickey Mouse?', 7),
(125, 'Qual é a ocupação principal de Mickey Mouse?', 7);

-- Inserção de alternativas sobre Mickey
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(440, true, 110, 'Pluto', 'A'),
(441, false, 110, 'Goofy', 'B'),
(442, false, 110, 'Donald', 'C'),
(443, false, 110, 'Max', 'D'),

(444, false, 111, 'Donald Duck', 'A'),
(445, true, 111, 'Goofy', 'B'),
(446, false, 111, 'Pluto', 'C'),
(447, false, 111, 'Minnie Mouse', 'D'),

(448, false, 112, 'Daisy Duck', 'A'),
(449, false, 112, 'Minnie Mouse', 'B'),
(450, true, 112, 'Minnie Mouse', 'C'),
(451, false, 112, 'Clarabelle Cow', 'D'),

(452, false, 113, '1920', 'A'),
(453, true, 113, '1928', 'B'),
(454, false, 113, '1930', 'C'),
(455, false, 113, '1940', 'D'),

(456, false, 114, 'Rabo', 'A'),
(457, true, 114, 'Orelhas grandes', 'B'),
(458, false, 114, 'Olhos grandes', 'C'),
(459, false, 114, 'Calças vermelhas', 'D'),

(460, true, 115, 'Walt Disney', 'A'),
(461, false, 115, 'Ub Iwerks', 'B'),
(462, false, 115, 'Roy O. Disney', 'C'),
(463, false, 115, 'Charles Mintz', 'D'),

(464, false, 116, 'Mickey Mouse: The Movie', 'A'),
(465, false, 116, 'Steamboat Willie', 'B'),
(466, true, 116, 'Fantasia', 'C'),
(467, false, 116, 'Mickey''s Once Upon a Christmas', 'D'),

(468, false, 117, 'Vermelhas', 'A'),
(469, false, 117, 'Azuis', 'B'),
(470, true, 117, 'Amarelas', 'C'),
(471, false, 117, 'Verdes', 'D'),

(472, false, 118, 'Disneyland', 'A'),
(473, false, 118, 'Neverland', 'B'),
(474, true, 118, 'Mickey''s Toontown', 'C'),
(475, false, 118, 'Wonderland', 'D'),

(476, false, 119, 'Daffy Duck', 'A'),
(477, true, 119, 'Donald Duck', 'B'),
(478, false, 119, 'Daisy Duck', 'C'),
(479, false, 119, 'Scrooge McDuck', 'D'),

(480, false, 120, 'Tom', 'A'),
(481, true, 120, 'Pete', 'B'),
(482, false, 120, 'Sylvester', 'C'),
(483, false, 120, 'Jerry', 'D'),

(484, false, 121, '18 de novembro', 'A'),
(485, true, 121, '18 de novembro', 'B'),
(486, false, 121, '1 de abril', 'C'),
(487, false, 121, '25 de dezembro', 'D'),

(488, false, 122, 'Grandes e pontudas', 'A'),
(489, true, 122, 'Redondas', 'B'),
(490, false, 122, 'Triangulares', 'C'),
(491, false, 122, 'Quadradas', 'D'),

(492, false, 123, 'Fala', 'A'),
(493, true, 123, 'Latidos', 'B'),
(494, false, 123, 'Mia', 'C'),
(495, false, 123, 'Zurros', 'D'),

(496, false, 124, 'Mouse', 'A'),
(497, true, 124, 'Nenhum', 'B'),
(498, false, 124, 'Duck', 'C'),
(499, false, 124, 'Dog', 'D'),
(500, false, 125, 'Cantor', 'A'),
(501, false, 125, 'Detetive', 'B'),
(502, false, 125, 'Piloto', 'C'),
(503, true, 125, 'Piloto de avião', 'D');


-- Inserção das perguntas na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(126, 'Qual é o nome do cachorro da Turma da Mônica?', 8),
(127, 'Quem é o garoto mais forte da Turma da Mônica?', 8),
(128, 'Qual é o nome do pai do Cebolinha?', 8),
(129, 'Quem é a dentuça da Turma da Mônica?', 8),
(130, 'Qual é a comida preferida do Cascão?', 8),
(131, 'Quem é a personagem que adora coelhinhos de pelúcia?', 8),
(132, 'Qual é o nome do cachorro da Magali?', 8),
(133, 'Quem é o dono do Sansão?', 8),
(134, 'Qual é o nome da rua onde mora a Turma da Mônica?', 8),
(135, 'Quem é o personagem que sempre carrega um monstro de pelúcia?', 8);

-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(504, false, 126, 'Bidu', 'A'),
(505, true, 126, 'Floquinho', 'B'),
(506, false, 126, 'Bolacha', 'C'),
(507, false, 126, 'Fubá', 'D'),

(508, false, 127, 'Magali', 'A'),
(509, false, 127, 'Cascão', 'B'),
(510, true, 127, 'Chico Bento', 'C'),
(511, false, 127, 'Cebolinha', 'D'),

(512, false, 128, 'Seu Sousa', 'A'),
(513, true, 128, 'Seu Cebola', 'B'),
(514, false, 128, 'Seu Juca', 'C'),
(515, false, 128, 'Seu Mário', 'D'),

(516, false, 129, 'Magali', 'A'),
(517, false, 129, 'Mônica', 'B'),
(518, true, 129, 'Dona Luísa', 'C'),
(519, false, 129, 'Cascuda', 'D'),

(520, false, 130, 'Pizza', 'A'),
(521, false, 130, 'Hamburguer', 'B'),
(522, true, 130, 'Feijão com arroz', 'C'),
(523, false, 130, 'Macarrão', 'D'),

(524, false, 131, 'Mônica', 'A'),
(525, false, 131, 'Magali', 'B'),
(526, true, 131, 'Denise', 'C'),
(527, false, 131, 'Aninha', 'D'),

(528, true, 132, 'Mingau', 'A'),
(529, false, 132, 'Duque', 'B'),
(530, false, 132, 'Meu Querido', 'C'),
(531, false, 132, 'Pipoca', 'D'),

(532, false, 133, 'Jeremias', 'A'),
(533, false, 133, 'Anjinho', 'B'),
(534, true, 133, 'Mônica', 'C'),
(535, false, 133, 'Cebolinha', 'D'),

(536, false, 134, 'Rua das Flores', 'A'),
(537, true, 134, 'Rua do Limoeiro', 'B'),
(538, false, 134, 'Avenida Brasil', 'C'),
(539, false, 134, 'Travessa da Turma', 'D'),

(540, false, 135, 'Magali', 'A'),
(541, false, 135, 'Denise', 'B'),
(542, true, 135, 'Mônica', 'C'),
(543, false, 135, 'Cascão', 'D');


-- Inserção das questões na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(136, 'Qual é o nome da namorada do Chico Bento?', 9),
(137, 'O que Chico Bento mais gosta de fazer nas horas vagas?', 9),
(138, 'Qual é o nome do porco de estimação do Chico Bento?', 9),
(139, 'O que Chico Bento usa na cabeça?', 9),
(140, 'Qual é o nome do amigo inseparável do Chico Bento?', 9),
(141, 'Quem é o primo urbano do Chico Bento?', 9),
(142, 'O que Chico Bento cultiva em sua horta?', 9),
(143, 'Qual é a bebida preferida do Chico Bento?', 9),
(144, 'Qual é o nome do fiel cachorro do Chico Bento?', 9),
(145, 'O que Chico Bento faz para se locomover na roça?', 9);

-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(544, true, 136, 'Rosalinda', 'A'),
(545, false, 136, 'Romeu', 'B'),
(546, false, 136, 'Rosinha', 'C'),
(547, false, 136, 'Rita', 'D'),

(548, false, 137, 'Jogar futebol', 'A'),
(549, false, 137, 'Andar de bicicleta', 'B'),
(550, false, 137, 'Pescar', 'C'),
(551, true, 137, 'Descansar na rede', 'D'),

(552, true, 138, 'Torresmo', 'A'),
(553, false, 138, 'Bacon', 'B'),
(554, false, 138, 'Costelinha', 'C'),
(555, false, 138, 'Bisteca', 'D'),

(556, false, 139, 'Boné', 'A'),
(557, false, 139, 'Chapéu de palha', 'B'),
(558, false, 139, 'Boina', 'C'),
(559, true, 139, 'Pau de água', 'D'),

(560, false, 140, 'Cascão', 'A'),
(561, false, 140, 'Magali', 'B'),
(562, true, 140, 'Zé Lelé', 'C'),
(563, false, 140, 'Xaveco', 'D'),

(564, true, 141, 'Zé Lelé', 'A'),
(565, false, 141, 'Cascão', 'B'),
(566, false, 141, 'Xaveco', 'C'),
(567, false, 141, 'Magali', 'D'),

(568, true, 142, 'Milho', 'A'),
(569, false, 142, 'Tomate', 'B'),
(570, false, 142, 'Cenoura', 'C'),
(571, false, 142, 'Alface', 'D'),

(572, false, 143, 'Água', 'A'),
(573, false, 143, 'Suco de laranja', 'B'),
(574, false, 143, 'Refrigerante', 'C'),
(575, true, 143, 'Leite de cabra', 'D'),

(576, true, 144, 'Tito', 'A'),
(577, false, 144, 'Bidu', 'B'),
(578, false, 144, 'Pingo', 'C'),
(579, false, 144, 'Fubá', 'D'),

(580, true, 145, 'Burro', 'A'),
(581, false, 145, 'Bicicleta', 'B'),
(582, false, 145, 'Carro', 'C'),
(583, false, 145, 'Cavalo', 'D');


-- Inserção das questões na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(146, 'Qual é o nome do herói principal de He-Man?', 10),
(147, 'Quem é o principal vilão em He-Man?', 10),
(148, 'Como o Príncipe Adam se transforma em He-Man?', 10),
(149, 'Qual é o nome do tigre de estimação de He-Man?', 10),
(150, 'Qual é o castelo que serve como base para He-Man e seus aliados?', 10),
(151, 'Qual é a identidade secreta da Feiticeira em He-Man?', 10),
(152, 'Qual é o nome da irmã de He-Man?', 10),
(153, 'Quem é o aliado robótico de He-Man?', 10),
(154, 'Qual é o poderoso artefato que é a chave para o poder de He-Man?', 10),
(155, 'Qual é o nome do mago mentor de He-Man?', 10);


-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(584, true, 146, 'He-Man', 'A'),
(585, false, 146, 'Esqueleto', 'B'),
(586, false, 146, 'Man-At-Arms', 'C'),
(587, false, 146, 'Teela', 'D'),

(588, false, 147, 'Fera', 'A'),
(589, true, 147, 'Esqueleto', 'B'),
(590, false, 147, 'Trap Jaw', 'C'),
(591, false, 147, 'Mer-Man', 'D'),

(592, true, 148, 'Levantando a Espada do Poder', 'A'),
(593, false, 148, 'Usando o Bastão Mágico', 'B'),
(594, false, 148, 'Invocando o Poder do Castelo de Grayskull', 'C'),
(595, false, 148, 'Transformação Automática', 'D'),

(596, false, 149, 'Garra', 'A'),
(597, false, 149, 'Listrado', 'B'),
(598, true, 149, 'Cringer', 'C'),
(599, false, 149, 'Rugido', 'D'),

(600, false, 150, 'Castelo de Eternia', 'A'),
(601, false, 150, 'Castelo de Greyskull', 'B'),
(602, true, 150, 'Palácio de Cristal', 'C'),
(603, false, 150, 'Fortaleza de Serpente', 'D'),

(604, false, 151, 'Teela', 'A'),
(605, true, 151, 'Feiticeira', 'B'),
(606, false, 151, 'Rainha Marlena', 'C'),
(607, false, 151, 'Mestra do Universo', 'D'),

(608, false, 152, 'Teela', 'A'),
(609, false, 152, 'Sorceress', 'B'),
(610, false, 152, 'Rainha Marlena', 'C'),
(611, true, 152, 'She-Ra', 'D'),

(612, false, 153, 'Roboto', 'A'),
(613, false, 153, 'Mechaneck', 'B'),
(614, true, 153, 'Man-At-Arms', 'C'),
(615, false, 153, 'Ram-Man', 'D'),

(616, false, 154, 'Orbe da Verdade', 'A'),
(617, false, 154, 'Olho de Thundera', 'B'),
(618, true, 154, 'Espada do Poder', 'C'),
(619, false, 154, 'Cálice de Eternia', 'D'),

(620, false, 155, 'Orko', 'A'),
(621, true, 155, 'Mentor', 'B'),
(622, false, 155, 'Zodak', 'C'),
(623, false, 155, 'Keldor', 'D');


-- Inserção das questões na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(156, 'Qual é a identidade secreta da She-Ha?', 11),
(157, 'Como a Princesa Adora se transforma em She-Ha?', 11),
(158, 'Quem é a irmã gêmea de She-Ha?', 11),
(159, 'Qual é o nome da espada mágica de She-Ha?', 11),
(160, 'Quem é a principal vilã em She-Ha?', 11),
(161, 'Qual é o reino governado por She-Ha?', 11),
(162, 'Quem é o mentor de She-Ha?', 11),
(163, 'Qual é o nome do unicórnio mágico companheiro de She-Ha?', 11),
(164, 'Quais são os poderes de She-Ha?', 11),
(165, 'Qual é o nome da transformação de She-Ha?', 11);


-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(624, false, 156, 'Adora', 'A'),
(625, true, 156, 'Princesa Adora', 'B'),
(626, false, 156, 'Cintilante', 'C'),
(627, false, 156, 'She-Ra', 'D'),

(628, false, 157, 'Ao Erguer a Espada da Verdade', 'A'),
(629, false, 157, 'Ao Gritar "Pela Honra de Grayskull"', 'B'),
(630, true, 157, 'Ao Erguer a Espada do Poder', 'C'),
(631, false, 157, 'Ao Invocar o Poder de Etheria', 'D'),

(632, false, 158, 'Mentora', 'A'),
(633, false, 158, 'Atris', 'B'),
(634, true, 158, 'Cintilante', 'C'),
(635, false, 158, 'Princesa da Noite', 'D'),

(636, false, 159, 'Espada Mestra', 'A'),
(637, true, 159, 'Espada do Poder', 'B'),
(638, false, 159, 'Espada Cintilante', 'C'),
(639, false, 159, 'Espada da Verdade', 'D'),

(640, false, 160, 'Mentora', 'A'),
(641, true, 160, 'Horda', 'B'),
(642, false, 160, 'Maligna', 'C'),
(643, false, 160, 'Cintilante', 'D'),

(644, false, 161, 'Reino da Escuridão', 'A'),
(645, false, 161, 'Reino do Caos', 'B'),
(646, true, 161, 'Reino de Brightmoon', 'C'),
(647, false, 161, 'Reino de Etheria', 'D'),

(648, false, 162, 'Mentora', 'A'),
(649, false, 162, 'Sorceress', 'B'),
(650, true, 162, 'Lighthope', 'C'),
(651, false, 162, 'Cintilante', 'D'),

(652, false, 163, 'Flecha Mágica', 'A'),
(653, true, 163, 'Ventania', 'B'),
(654, false, 163, 'Rajada Estelar', 'C'),
(655, false, 163, 'Brilho Celestial', 'D'),

(656, false, 164, 'Super Força', 'A'),
(657, false, 164, 'Voo', 'B'),
(658, false, 164, 'Invisibilidade', 'C'),
(659, true, 164, 'Todos os Poderes', 'D'),

(660, false, 165, 'She-Ra', 'A'),
(661, true, 165, 'She-Ha', 'B'),
(662, false, 165, 'Adoração Mágica', 'C'),
(663, false, 165, 'Transformação Radiante', 'D');


-- Inserção das questões na tabela tb_questao
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(166, 'Qual novela foi a primeira a ser exibida pela TV Globo?', 12),
(167, 'Em qual novela o personagem Roque Santeiro é um mito urbano?', 12),
(168, 'Qual é a novela que se passa em uma fictícia cidade de pescadores chamada Maragogipe?', 12),
(169, 'Em qual novela a personagem Viúva Porcina é conhecida por ser viúva de três maridos?', 12),
(170, 'Qual novela de Gilberto Braga aborda temas como incesto e drogas?', 12),
(171, 'Quem foi o autor da novela "O Rei do Gado", exibida em 1996?', 12),
(172, 'Em qual novela o personagem Capitão Kirk se torna um ícone?', 12),
(173, 'Qual novela teve como protagonistas os personagens Pedro e Helena?', 12),
(174, 'Em qual novela o personagem Odorico Paraguaçu é um político?', 12),
(175, 'Qual novela se passa em uma cidade fictícia chamada Tubiacanga?', 12);

-- Inserção das alternativas na tabela tb_alternativa
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(664, true, 166, 'Ilusões Perdidas', 'A'),
(665, false, 166, '2-5499 Ocupado', 'B'),
(666, false, 166, 'Sua Vida Me Pertence', 'C'),
(667, false, 166, 'Alô, Doçura!', 'D'),

(668, false, 167, 'Roque Queiroz', 'A'),
(669, true, 167, 'Roque Santeiro', 'B'),
(670, false, 167, 'Roque Cidades', 'C'),
(671, false, 167, 'Roque Villas', 'D'),

(672, false, 168, 'Tieta do Agreste', 'A'),
(673, false, 168, 'Mulheres de Areia', 'B'),
(674, false, 168, 'O Clone', 'C'),
(675, true, 168, 'Cordel Encantado', 'D'),

(676, false, 169, 'Gabriela', 'A'),
(677, true, 169, 'Roque Santeiro', 'B'),
(678, false, 169, 'Tieta do Agreste', 'C'),
(679, false, 169, 'Senhora do Destino', 'D'),

(680, false, 170, 'O Dono do Mundo', 'A'),
(681, false, 170, 'Força de um Desejo', 'B'),
(682, true, 170, 'Babilônia', 'C'),
(683, false, 170, 'O Salvador da Pátria', 'D'),

(684, false, 171, 'Gilberto Gil', 'A'),
(685, false, 171, 'Gilberto Alves', 'B'),
(686, false, 171, 'Gilberto Braga', 'C'),
(687, true, 171, 'Benedito Ruy Barbosa', 'D'),

(688, false, 172, 'Viagem ao Fundo do Mar', 'A'),
(689, true, 172, 'O Rei do Gado', 'B'),
(690, false, 172, 'O Casarão', 'C'),
(691, false, 172, 'Saramandaia', 'D'),

(692, false, 173, 'A Sucessora', 'A'),
(693, false, 173, 'Roda de Fogo', 'B'),
(694, true, 173, 'Pedra sobre Pedra', 'C'),
(695, false, 173, 'Escrava Isaura', 'D'),

(696, false, 174, 'O Bem-Amado', 'A'),
(697, true, 174, 'O Bofe', 'B'),
(698, false, 174, 'O Santo e a Porca', 'C'),
(699, false, 174, 'Selva de Pedra', 'D'),

(700, false, 175, 'Caminho das Índias', 'A'),
(701, false, 175, 'Avenida Brasil', 'B'),
(702, false, 175, 'Fina Estampa', 'C'),
(703, true, 175, 'Cordel Encantado', 'D');


-- Inserção das perguntas sobre Retro Games
INSERT INTO public.tb_questao (id, pergunta, id_tema) VALUES
(176, 'Qual foi o primeiro console de videogame lançado pela Sega?', 3),
(177, 'Em qual ano foi lançado o Mega Drive, console de 16 bits da Sega?', 3),
(178, 'Quem é o mascote icônico da Sega, conhecido por ser o protagonista da série Sonic the Hedgehog?', 3),
(179, 'Qual é o jogo clássico de plataforma da Nintendo lançado para o Super Nintendo Entertainment System (SNES) em 1990?', 3),
(180, 'Em que ano foi lançado o Super Nintendo Entertainment System (SNES) no Japão?', 3),
(181, 'Qual é o jogo de RPG japonês (JRPG) lançado para o Super Nintendo que se tornou um clássico?', 3),
(182, 'Qual é o console de 8 bits da Sega lançado para competir com o Nintendo Entertainment System (NES)?', 3),
(183, 'Quem é o mascote principal da Nintendo, conhecido por ser o encanador italiano que estrela vários jogos?', 3),
(184, 'Qual é o jogo de aventura lançado para o Nintendo Entertainment System (NES) que apresenta Link como protagonista?', 3),
(185, 'Em qual ano foi lançado o Atari 2600, um dos primeiros consoles de videogame domésticos?', 3),
(186, 'Qual é o jogo de arcade clássico lançado pela Namco em 1980, conhecido por ser o primeiro jogo de Pac-Man?', 3),
(187, 'Quem é o criador do jogo "Donkey Kong" e "Super Mario Bros.", considerado uma lenda na indústria de videogames?', 3),
(188, 'Qual é o console de 8 bits da Nintendo lançado em 1983?', 3),
(189, 'Qual é o jogo de tiro em primeira pessoa lançado para o console Super Nintendo que se tornou um clássico?', 3),
(190, 'Em qual ano foi lançado o console Master System, fabricado pela Sega?', 3),
(191, 'Qual é o jogo de plataforma lançado para o Master System que apresenta o personagem Alex Kidd?', 3);

-- Inserção das alternativas sobre Retro Games
INSERT INTO public.tb_alternativa (id, correta, id_questao, alternativa, "letra-referencia") VALUES
(704, true, 176, 'Master System', 'A'),
(705, false, 176, 'Atari 2600', 'B'),
(706, false, 176, 'Super Nintendo', 'C'),
(707, false, 176, 'PlayStation', 'D'),

(708, true, 177, '1988', 'A'),
(709, false, 177, '1990', 'B'),
(710, false, 177, '1992', 'C'),
(711, false, 177, '1994', 'D'),

(712, true, 178, 'Sonic the Hedgehog', 'A'),
(713, false, 178, 'Alex Kidd', 'B'),
(714, false, 178, 'Tails', 'C'),
(715, false, 178, 'Knuckles', 'D'),

(716, true, 179, 'Super Mario World', 'A'),
(717, false, 179, 'The Legend of Zelda: A Link to the Past', 'B'),
(718, false, 179, 'Donkey Kong Country', 'C'),
(719, false, 179, 'Mega Man X', 'D'),

(720, true, 180, '1990', 'A'),
(721, false, 180, '1992', 'B'),
(722, false, 180, '1988', 'C'),
(723, false, 180, '1994', 'D'),

(724, true, 181, 'Chrono Trigger', 'A'),
(725, false, 181, 'Final Fantasy VI', 'B'),
(726, false, 181, 'Secret of Mana', 'C'),
(727, false, 181, 'EarthBound', 'D'),

(728, true, 182, 'Master System', 'A'),
(729, false, 182, 'Atari 2600', 'B'),
(730, false, 182, 'Super Nintendo', 'C'),
(731, false, 182, 'Sega Saturn', 'D'),

(732, true, 183, 'Mario', 'A'),
(733, false, 183, 'Luigi', 'B'),
(734, false, 183, 'Link', 'C'),
(735, false, 183, 'Donkey Kong', 'D'),

(736, true, 184, 'The Legend of Zelda', 'A'),
(737, false, 184, 'Super Mario Bros.', 'B'),
(738, false, 184, 'Metroid', 'C'),
(739, false, 184, 'Mega Man', 'D'),

(740, true, 185, '1977', 'A'),
(741, false, 185, '1980', 'B'),
(742, false, 185, '1983', 'C'),
(743, false, 185, '1986', 'D'),

(744, true, 186, 'Pac-Man', 'A'),
(745, false, 186, 'Space Invaders', 'B'),
(746, false, 186, 'Galaga', 'C'),
(747, false, 186, 'Donkey Kong', 'D'),

(748, true, 187, 'Shigeru Miyamoto', 'A'),
(749, false, 187, 'Hideo Kojima', 'B'),
(750, false, 187, 'Satoru Iwata', 'C'),
(751, false, 187, 'Yū Suzuki', 'D'),

(752, true, 188, 'Nintendo Entertainment System (NES)', 'A'),
(753, false, 188, 'Sega Genesis', 'B'),
(754, false, 188, 'Atari 7800', 'C'),
(755, false, 188, 'Commodore 64', 'D'),

(756, true, 189, 'Super Metroid', 'A'),
(757, false, 189, 'Contra III: The Alien Wars', 'B'),
(758, false, 189, 'Mega Man X', 'C'),
(759, false, 189, 'Super Castlevania IV', 'D'),

(760, true, 190, '1985', 'A'),
(761, false, 190, '1987', 'B'),
(762, false, 190, '1989', 'C'),
(763, false, 190, '1991', 'D'),

(764, true, 191, 'Alex Kidd in Miracle World', 'A'),
(765, false, 191, 'Sonic the Hedgehog', 'B'),
(766, false, 191, 'Wonder Boy in Monster Land', 'C'),
(767, false, 191, 'Fantasy Zone', 'D');


-- Criando usuários.
-- Samuel
INSERT INTO public.tb_usuario
(id, idade, apelido, email, nome, nome_completo, senha)
VALUES(1, 38, 'Samucation', 'samuel@email.com', 'Samuel', 'Samuel Ferreira Duarte', '123Mudar');

-- Marcia
INSERT INTO public.tb_usuario
(id, idade, apelido, email, nome, nome_completo, senha)
VALUES(2, 35, 'MarciaDoJava', 'marcia@email.com', 'Marcia', 'Marcia Oliveira', '123Mudar');

-- Marcos
INSERT INTO public.tb_usuario
(id, idade, apelido, email, nome, nome_completo, senha)
VALUES(3, 30, 'Maquinhos', 'marcos@email.com', 'Marcos', 'Marcos Mikio', '123Mudar');
