package com.example.apirest.service;

import com.example.apirest.domain.Status;
import com.example.apirest.domain.Todo;
import com.example.apirest.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(String title) {
        return todoRepository.save(new Todo(title));
    }

    public Todo update(Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo non trouvé"));

        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setStatus(updatedTodo.getStatus());

        return todoRepository.save(todo);
    }

    public Todo patch(Long id, Map<String, Object> updates) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo non trouvé"));

        if (updates.containsKey("title")) {
            todo.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("description")) {
            todo.setDescription((String) updates.get("description"));
        }
        if (updates.containsKey("status")) {
            todo.setStatus(Status.valueOf((String) updates.get("status")));
        }

        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
