package com.game.maker;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class QuizApplication {

	private static final Logger LOGGER = LogManager.getLogger(QuizApplication.class);

	@Value("${allowed.cors.origins}")
	private String allowedCorsOrigins;

	public static void main(String[] args) {
		loadEnvironmentsConfigurations();
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		String[] allowedOriginsPermitted = allowedCorsOrigins.split(",");

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(allowedOriginsPermitted)
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
						.allowCredentials(true);
			}
		};
	}

	@PostConstruct
	public void init() {
		loadEnvironmentsConfigurations();
	}

	private static void loadEnvironmentsConfigurations(){
		String isLoadLocalEnvironments = System.getenv("USE_ENV_FOLDER_PROFILE_ENVIRONMENTS");

		if (isLoadLocalEnvironments.equalsIgnoreCase("TRUE")) {
			LOGGER.info("Ambiente LOCAL detectado. Usando variáveis de ambiente configuradas no sistema.");


			String envPath = System.getenv("ENV_PATH");
			String envFile = System.getenv("ENV_FILE");

			Dotenv dotenv = Dotenv.configure()
					.directory(envPath)
					.filename(envFile + ".env")
					.load();

			// defini as variáveis de ambiente do sistema e permissões.
			System.setProperty("server.port", dotenv.get("SERVER_PORT"));
			System.setProperty("allowed.cors.origins", dotenv.get("ALLOWED_CORS_ORIGINS"));

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
			LOGGER.info("Ambiente REMOTO detectado. Usando variáveis de ambiente configuradas no sistema.");

			// As variáveis de ambiente são definidas diretamente no ambiente de execução (ex: no Azure, AWS, etc.)
			System.setProperty("spring.datasource.url", System.getenv("JDBC_DATABASE_URL"));
			System.setProperty("spring.datasource.username", System.getenv("JDBC_DATABASE_USERNAME"));
			System.setProperty("spring.datasource.password", System.getenv("JDBC_DATABASE_PASSWORD"));
			System.setProperty("spring.jpa.hibernate.ddl-auto", System.getenv("HIBERNATE_DDL_AUTO"));

			System.setProperty("server.port", System.getenv("SERVER_PORT"));
			System.setProperty("allowed.cors.origins", System.getenv("ALLOWED_CORS_ORIGINS"));

			LOGGER.info("Variáveis de ambiente do sistema configuradas: JDBC_DATABASE_URL: [{}], JDBC_DATABASE_USERNAME: [{}], JDBC_DATABASE_PASSWORD: [{}], HIBERNATE_DDL_AUTO: [{}]",
					System.getenv("JDBC_DATABASE_URL"),
					System.getenv("JDBC_DATABASE_USERNAME"),
					System.getenv("JDBC_DATABASE_PASSWORD"),
					System.getenv("HIBERNATE_DDL_AUTO"));
		}
	}

}
