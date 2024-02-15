## Execução do Sistema e Configuração da Base de Dados

### Antes de iniciar o sistema, execute os seguintes comandos:

instale as dependências:
```
mvn clean install -DskipTests
```

### Criação da Base de Dados

1° No banco de dados PostgreSQL, crie uma base de dados vazia com o nome (quiz_db).
2° Em seguida, abra o prompt de comando (CMD) na raiz do projeto e execute:

```
mvn flyway:migrate
```


Se a senha do banco for diferente da especificada em flyway.conf, forneça a senha usando:
```
mvn flyway:migrate -Dflyway.password=<SUA_SENHA>
```
Substitua <SUA_SENHA> pela senha do banco PostgreSQL. 
Exemplo:

```
mvn flyway:migrate -Dflyway.password=123Mudar
```

Este comando cria questões, alternativas e configurações do sistema, além de três usuários válidos com IDs 1, 2 e 3.



## Testando a API (Iniciando uma Partida)

### Acessando a Documentação Padrão do Projeto
Se o sistema estiver na porta padrão e localhost, acesse a URL padrão do Swagger para obter a documentação da API:

```
http://localhost:8080/swagger-ui/index.html#/
```

Se os comandos mvn clean install e mvn flyway:migrate foram executados com sucesso, não é necessário cadastrar um usuário, configurações do sistema ou carregar dados para questões e temas. Nesse caso, vá para a seção Swagger chamada (gameplay-controller).

No controlador de gameplay, inicie o jogo acessando a requisição:
```(gameplay-controoler)```

```
http://localhost:8080/gameplay/start
```

A requisição é do tipo POST e requer um objeto JSON no corpo com os parâmetros:

````
{
  "userId": 1,
  "theme": "Cinema",
  "level": "Facil"
}
````

Para rodar este passo via CMD com o comando CURL, use o script abaixo:

````
curl -X 'POST' \
  'http://localhost:8080/gameplay/start' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "userId": 1,
  "theme": "Cinema",
  "level": "Facil"
}'
````

Atenção:
Se a carga de dados do sistema não foi bem-sucedida, será necessário cadastrar um usuário, pelo menos um tema (theme) com dados de questões e alternativas, e uma configuração. Se necessário, navegue entre as outras requisições do controlador e cadastre os dados manualmente.

Você receberá um objeto JSON com os parâmetros da sessão de gameplay recém-iniciada. Se a resposta tiver status 200, receberá algo semelhante a:

````
{
  "gameplaySessionId": 49,
  "responseMessage": "Existe uma sessão carregada para o usuário, você precisa primeoro terminar a sessão atual para começar outra."
}
````

Importante:
O campo gameplaySessionId sempre terá um valor diferente para cada sessão criada. Cada sessão de jogador é única. O campo responseMessage orienta sobre os próximos passos. Neste manual, já havia uma sessão na base de dados, resultando na mensagem para terminar a sessão ativa antes de iniciar outra.

Agora que temos uma sessão de gameplay ativa e sabemos como ela funciona, vamos de fato jogar o jogo!
vá até requisição:

````
http://localhost:8080/gameplay/find-question-in-session/{userId}/{gameplaySessionId}
````

Se estiver usando o Swagger, insira o mesmo userId e gameplaySessionId usado no start gameplay (primeira requisição).

Você também pode rodar essa parte do projeto usando o comando CURL executando o comando abaixo:

````
curl -X 'GET' \
  'http://localhost:8080/gameplay/find-question-in-session/1/49' \
  -H 'accept: */*'
  
````

Atenção! Atente-se que o comando acima usa um id de exemplo de usuário (1) e um id se sessão de
usuário de exemplo (49) mas no seu caso você precisará passar valores válidos recuperados da
request gameplay/start

Ao fazer a chamada com campos válidos é retornada uma resposta de um objeto JSON no corpo da sua 
requisição contendo uma pergunta e alternativas dessa pergunta, algo muito próximo ao apresentado
a seguir:

````
{
  "question": "Qual é o filme brasileiro mais premiado internacionalmente?",
  "questionId": 9,
  "inGameAlternativeDTO": [
    {
      "id": 33,
      "alternative": "Central do Brasil",
      "referenceLetter": "A"
    },
    {
      "id": 34,
      "alternative": "Cidade de Deus",
      "referenceLetter": "B"
    },
    {
      "id": 35,
      "alternative": "Tropa de Elite",
      "referenceLetter": "C"
    },
    {
      "id": 36,
      "alternative": "O Pagador de Promessas",
      "referenceLetter": "D"
    }
  ],
  "userMessage": "Muito bem meu caro jogador responda a pergunta para continuar o jogo!",
  "unplayedQuestions": 29
}

````

Muito bem temos uma sesão ativa e uma questão a ser respondida, o que nos falta agora é responder
a pergunta para sabermos se ganhamos a primeira rodada do jogo ou não, não é mesmo? Então para isso
precisamos ir na nossa terceira e ultima request que fecha o ciclo da primeira rodada da gameplay,
para isso vamos ir até a request:

````
http://localhost:8080/gameplay/validate-selected-question-alternative
````

E iremos passar os seguintes parâmetros em um objeto JSON para validar a nossa alternativa!

````
{
  "userId": 1,
  "gameplaySessionId": 49,
  "selectedAlternative": "A"
}
````

Você também pode user o comando CURL via CMD para fazer esse passo, mas precisará editar os parametros 
do exemplo abaixo:

````
curl -X 'GET' \
  'http://localhost:8080/gameplay/validate-selected-question-alternative?userId=1&gameplaySessionId=49&selectedAlternative=A' \
  -H 'accept: */*'
````

Note que precisei passar o id válido do usuário que usei por todos os outros processos do jogo
e também a gameplaySessionId para o sistema saber que usuário e sessão estamos jogando, e claro
nesse ultimo passo precisamos também de passar a alternativa que achamos ser a correta para a 
pergunta anterior, pois bem! Agora iremos executar o sistema e ter o nosso resultado da primeira
partida:

Ao receber uma resposta bem sucedida da requisição alterior nos iremos obter uma response com status
200 e um objeto JSON com as devidas informações da primeira rodada da gameplay:

````
{
  "playerMessage": "O jogador perdeu! e não recebeu pontos na sessão até o momento!",
  "playerPunctuation": 0,
  "selectedAlternative": "A",
  "correctAlternative": "D - O Pagador de Promessas",
  "currentSessionScore": null,
  "isSessionOver": false,
  "sessionOverMessage": null
}
````

Os campos de retorno por si só já são alto explicativos em suas finalidades.

#### playerMessage:
Apresenta uma mensagem ao jogador explicando o que ocorreu na validação da sua alternativa, podendo variar
entre uma mensagem informando que você ganhou ou perdeu a partida.

#### playerPunctuation:
    Pontuação obtida na rodada que acabou de responder. os pontos podem variar dependendo
    do seu level, sendo possível ganhar mais ou menos pontos, o level é especificado no inicio na primeira
    requisição em gameplay/start quanto maior o level mais pontos por rodada.

#### selectedAlternative:
    Alternativa selecionada anteriormente pelo jogador.

#### correctAlternative:
    Retorna a resposta com a alternativa correta concatenando com a descrição da alternativa correta.

#### currentSessionScore:
    Total de pontos de toda a sessão que está ativa até o momento, é a soma de todos os pontos (Questões que o usuário acertou) até 
    o momento atual da sessão.

#### isSessionOver:
    Sempre retornará false por toda a gameplay, apenas na na ultima rodada da sessão ele retornará true para indicar ao consumidor do serviço que 
    ao chamar em uma proxima request será necessário reiniciar o ciclo inteiro, ou seja chamar novamente gameplay/start e recuperar um novo id de sessão
    pois a sessão atual chegou ao fim quando esse boolean retornar true.

### sessionOverMessage:
    Caso isSessionOver retornar true que condiz com uma sessão que acabou de terminar, o campo sessionOverMessage
    retornará também uma mensagem informativa explicando que a sessão do usuário terminou.

