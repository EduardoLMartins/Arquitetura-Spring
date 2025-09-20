package io.github.eduardolemos.arquiteturaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.eduardolemos.arquiteturaspring.todos.MailSender;

@Configuration
public class ConfiguracaoAcessoEmail {

	@Autowired
	private AppProperties appProperties;
	
	@Bean
	public MailSender mailSender() {
		return null;
	}
}
