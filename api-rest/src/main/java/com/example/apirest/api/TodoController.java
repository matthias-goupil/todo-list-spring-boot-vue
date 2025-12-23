package com.example.apirest.api;

import com.example.apirest.domain.Todo;
import com.example.apirest.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo create(@RequestBody String title) {
        return todoService.create(title);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo updatedTodo) { return todoService.update(id,updatedTodo);}

    @PatchMapping("/{id}")
    @Operation(summary = "Met à jour partiellement un todo")
    public Todo patchTodo(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return todoService.patch(id, updates);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
