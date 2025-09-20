package io.github.eduardolemos.arquiteturaspring;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
	
		builder.bannerMode(Mode.OFF);
		builder.profiles("producao");
		//todos os bean sao lazy ou seja sao iniciados so quando for chamado
		builder.lazyInitialization(true);
		builder.run(args);
		
		// Contexto da aplicação iniciada
		ConfigurableApplicationContext applicationContext = builder.context();
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicaçao: " + applicationName);
		
		ExemploValue value =
		applicationContext.getBean(ExemploValue.class);
		value.imprimirVariavel();
		
		AppProperties app = applicationContext.getBean(AppProperties.class);
		System.out.println(app.getVariavel());
		System.out.println(app.getValor1());
	}

}