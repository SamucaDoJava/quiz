## Para executar o sistema antes de tudo rode os comandos:


### Criando base de dados

vá até o banco de dados postgresSQL e crie uma base de dados de nome quiz_db vazia
em sequida abra o prompt comando DOS/CMD na raiz do projeto e execute o comando:

```
mvn flyway:migrate
```
O comando acima irá criar questões e alternativas e as configurações do sistema, também 
irá criar 3 usuários válidos para o Sistema com ids 1, 2 e 3

Após isso rode o comando:

```
mvn clean install
```

para instalar as dependencias.

E não esqueça de subir o sistema com a configuração colocada como provided nas confiurações
em edit configurations no Intellij.

