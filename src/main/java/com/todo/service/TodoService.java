package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}


	public Todo findById(Long id) {
		if (todoRepository.findById(id).isPresent()) {
			return todoRepository.findById(id).get();
		}
		return null;
	}
	
	public String delete(Long id) {
		todoRepository.deleteById(id);
		return "Record Deleted";
	}

}
