@echo off
setlocal enabledelayedexpansion



:: Definir variáveis de ambiente a partir do arquivo localizado na pasta 'env'
for /f "tokens=1,2 delims==" %%a in (env\flyway-migrations-localhost-environments.env) do (
  set "%%a=%%b"
)

echo ("Iniciando o carregamento das variáveis de ambiente do flyway.")
:: Debugging - exibir as variáveis carregadas
echo FLYWAY_URL=%FLYWAY_URL%
echo FLYWAY_USER=%FLYWAY_USER%
echo FLYWAY_PASSWORD=%FLYWAY_PASSWORD%
echo FLYWAY_SCHEMAS=%FLYWAY_SCHEMAS%
echo FLYWAY_BASELINE_ON_MIGRATE=%FLYWAY_BASELINE_ON_MIGRATE%
echo FLYWAY_VALIDATE_ON_MIGRATE=%FLYWAY_VALIDATE_ON_MIGRATE%
echo FLYWAY_VALIDATE_MIGRATION_NAMING=%FLYWAY_VALIDATE_MIGRATION_NAMING%

echo("Iniciando a migração da base de dados via migrations flyway.")
:: Rodar o comando Flyway com Maven
mvn flyway:migrate -X
