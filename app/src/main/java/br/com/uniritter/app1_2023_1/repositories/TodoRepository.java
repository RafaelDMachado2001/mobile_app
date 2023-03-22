package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Todo;

public class TodoRepository {
    private Map<Integer, Todo> todoMap;

    private static TodoRepository instance = null;

    private TodoRepository() {
        this.todoMap = new HashMap<>();
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }

        return instance;
    }

    public void addTodo(Todo todo) {
        if (todo != null) {
            this.todoMap.put(todo.getId(), todo);
        }
    }

    public boolean contains(Todo todo) {
        return this.todoMap.containsValue(todo);
    }

    public boolean contains(Integer id) {
        return this.todoMap.containsKey(id);
    }

    public Collection<Todo> getTodos() {
        return this.todoMap.values();
    }
}
