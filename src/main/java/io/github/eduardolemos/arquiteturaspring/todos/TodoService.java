package io.github.eduardolemos.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	private TodoValidator todoValidator;
	private MailSender mailSender;
	
	public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
		this.repository = todoRepository;
		this.todoValidator = todoValidator;
		this.mailSender = mailSender;
		
	}
	
	public TodoEntity salvar(TodoEntity novoTodo) {
		todoValidator.validar(novoTodo);
		return repository.save(novoTodo);
		
	}
	
	public void atualizarStatus(TodoEntity entity) {
		repository.save(entity);
		String status = entity.getConcluido() == Boolean.TRUE ? "Concluido" : "Nao concluido";
		mailSender.enviar("Todo de código " + entity.getDescricao() + "foi atualizado para" + status);
	}
	
	public TodoEntity buscar (Integer id) {
		return repository.findById(id).orElse(null);
	}
}
