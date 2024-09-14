package com.game.maker;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class QuizApplication {

	private static final Logger LOGGER = LogManager.getLogger(QuizApplication.class);


	public static void main(String[] args) {
		loadEnvironmentsConfigurations();
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200", "http://localhost:8080/swagger-ui/index.html")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
//						.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
//						.allowCredentials(true);
			}
		};
	}

	private static void loadEnvironmentsConfigurations(){
		// Verifica o tipo de ambiente: "local" para desenvolvimento local ou "remote" para produção ou ambiente remoto
		String environmentType = System.getenv("APPLICATION_ENVIRONMENT");

		if ("local".equalsIgnoreCase(environmentType)) {
			LOGGER.info("Carregando variáveis de ambiente do arquivo .env para ambiente local.");

			String envPath = System.getenv("ENV_PATH"); // Valor esperado: ./env
			String envFile = System.getenv("ENV_FILE"); // Valor esperado: windows-local

			// Carrega o arquivo .env apenas em ambiente local
			Dotenv dotenv = Dotenv.configure()
					.directory(envPath) // Usa o valor da variável ENV_PATH
					.filename(envFile + ".env") // Usa o valor da variável ENV_FILE e adiciona .env
					.load();

			System.setProperty("server.port", dotenv.get("SERVER_PORT"));

			// Define as variáveis de ambiente da base de dados.
			System.setProperty("spring.datasource.url", dotenv.get("JDBC_DATABASE_URL"));
			System.setProperty("spring.datasource.username", dotenv.get("JDBC_DATABASE_USERNAME"));
			System.setProperty("spring.datasource.password", dotenv.get("JDBC_DATABASE_PASSWORD"));
			System.setProperty("spring.jpa.hibernate.ddl-auto", dotenv.get("HIBERNATE_DDL_AUTO"));

			LOGGER.info("Variáveis de ambiente carregadas do .env: JDBC_DATABASE_URL: [{}], JDBC_DATABASE_USERNAME: [{}], JDBC_DATABASE_PASSWORD: [{}], HIBERNATE_DDL_AUTO: [{}]",
					dotenv.get("JDBC_DATABASE_URL"),
					dotenv.get("JDBC_DATABASE_USERNAME"),
					dotenv.get("JDBC_DATABASE_PASSWORD"),
					dotenv.get("HIBERNATE_DDL_AUTO"));

		} else {
			LOGGER.info("Ambiente remoto detectado. Usando variáveis de ambiente configuradas no sistema.");

			// As variáveis de ambiente são definidas diretamente no ambiente de execução (ex: no Azure, AWS, etc.)
			System.setProperty("spring.datasource.url", System.getenv("JDBC_DATABASE_URL"));
			System.setProperty("spring.datasource.username", System.getenv("JDBC_DATABASE_USERNAME"));
			System.setProperty("spring.datasource.password", System.getenv("JDBC_DATABASE_PASSWORD"));
			System.setProperty("spring.jpa.hibernate.ddl-auto", System.getenv("HIBERNATE_DDL_AUTO"));

			LOGGER.info("Variáveis de ambiente do sistema configuradas: JDBC_DATABASE_URL: [{}], JDBC_DATABASE_USERNAME: [{}], JDBC_DATABASE_PASSWORD: [{}], HIBERNATE_DDL_AUTO: [{}]",
					System.getenv("JDBC_DATABASE_URL"),
					System.getenv("JDBC_DATABASE_USERNAME"),
					System.getenv("JDBC_DATABASE_PASSWORD"),
					System.getenv("HIBERNATE_DDL_AUTO"));
		}
	}

}
