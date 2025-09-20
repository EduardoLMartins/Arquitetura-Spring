package io.github.eduardolemos.arquiteturaspring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import io.github.eduardolemos.arquiteturaspring.todos.MailSender;
import io.github.eduardolemos.arquiteturaspring.todos.TodoEntity;
import io.github.eduardolemos.arquiteturaspring.todos.TodoRepository;
import io.github.eduardolemos.arquiteturaspring.todos.TodoService;
import io.github.eduardolemos.arquiteturaspring.todos.TodoValidator;
import jakarta.persistence.EntityManager;

public class ExemploInjecaoDependencia {

	public static void main(String[] args) throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("url");
		dataSource.setUsername("user");
		dataSource.setPassword("password");
	
		Connection connection = dataSource.getConnection();
		
		EntityManager entityManager = null;
		
		
		TodoRepository repository = null;// new SimpleJpaRepository<TodoEntity, Integer>(null, null);
		TodoValidator todoValidator = new TodoValidator(repository);
		MailSender mailSender = new MailSender();
	
//		BeanGerenciado beanGerenciado = new BeanGerenciado(null);
//		beanGerenciado.setValidator(todoValidator);
//		if ()
		
	}
}
