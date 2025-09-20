package io.github.eduardolemos.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

	private TodoRepository todoRepository;
	
	public TodoValidator(TodoRepository repository) {
		this.todoRepository = repository;
	}
	
	public void validar(TodoEntity todo) {
		if(existeTodocomDescicao(todo.getDescricao())) {
			throw new IllegalArgumentException("Ja existe um Todo com essa descricao");
		}
	}
	
	private boolean existeTodocomDescicao(String descricao) {
		return todoRepository.existsByDescricao(descricao);
		
	}
}
