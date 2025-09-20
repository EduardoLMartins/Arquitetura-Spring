package io.github.eduardolemos.arquiteturaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.github.eduardolemos.arquiteturaspring.todos.TodoEntity;
import io.github.eduardolemos.arquiteturaspring.todos.TodoValidator;

//Diz pro Spring: "só cria esse objeto quando alguém realmente pedir"
@Lazy
//escopo singleton
@Component

//Cria só um objeto para toda a aplicação inteira (sempre o mesmo)
//@Scope("singleton")
//@Scope(BeanDefinition.SCOPE_SINGLETON)

//Cria um novo objeto a cada requisição HTTP
//@Scope("request")

//Cria um objeto por sessão de usuário (cada usuário tem o seu)
//@Scope("session")

//Cria um objeto para toda a aplicação web (compartilhado entre todos)
//@Scope("application")
public class BeanGerenciado {

	//o bean de scope de seção ajuda a pegar
	private String idUsuarioLogado;
	
	
	@Autowired
	private AppProperties appProperties;
	
	
	@Autowired
	private TodoValidator validator;
	
	@Autowired
	public BeanGerenciado (TodoValidator todoValidator) {
		this.validator = todoValidator;
	}
	
	public void utilizar() {
		var todo = new TodoEntity();
		validator.validar(todo);
	}
	
	@Autowired
	public void setValidator(TodoValidator todoValidator) {
		this.validator = todoValidator;
	}
}
