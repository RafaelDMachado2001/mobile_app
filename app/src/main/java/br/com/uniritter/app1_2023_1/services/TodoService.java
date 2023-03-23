package br.com.uniritter.app1_2023_1.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uniritter.app1_2023_1.models.Todo;
import br.com.uniritter.app1_2023_1.repositories.TodoRepository;

public class TodoService {
    public static Todo todoFromJson (JSONObject json) {
        Todo todo = null;

        try {
            todo = new Todo(
                json.getInt("id"),
                json.getInt("userId"),
                json.getString("title"),
                json.getBoolean("completed")
            );
        } catch (JSONException e) {
            System.out.println("Erro no JSON." + e.getMessage());
        }

        return todo;
    }

    public static void getAllTodos(Context contexto, ServiceDone callback) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos", null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            TodoRepository.getInstance().addTodo( todoFromJson(json) );
                        } catch (JSONException e) {
                            System.out.println("Erro no JSON.! " + e.getMessage());
                        }
                    }
                    if (callback != null) {
                        callback.onServiceDone();
                    }
                },
                error -> {
                    Toast.makeText(contexto, "Falha na requisição!" + error.getMessage(), Toast.LENGTH_SHORT).show();
                });
        RequestQueue queue = Volley.newRequestQueue(contexto);
        queue.add(request);
    }

}