package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.service.TodoService;

@CrossOrigin("*")
@RestController
public class TodoController { 
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> get() {
		List<Todo> todo = todoService.findAll();
		return new ResponseEntity<List<Todo>>(todo, HttpStatus.OK);
	}

	@PostMapping("/todo")
	public ResponseEntity<Todo> save(@RequestBody Todo todo) {
		Todo todoOne = todoService.save(todo);
		return new ResponseEntity<Todo>(todoOne, HttpStatus.CREATED);
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> get(@PathVariable("id") Long id) {
		Todo todo = todoService.findById(id);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		todoService.delete(id);
		return new ResponseEntity<String>("Deleted successfully.!", HttpStatus.OK);
	}
}
