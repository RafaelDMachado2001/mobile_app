package br.com.uniritter.app1_2023_1.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uniritter.app1_2023_1.models.Post;
import br.com.uniritter.app1_2023_1.repositories.PostRepository;

public class PostService {
    public static Post postFromJson (JSONObject json) {
        Post post = null;

        try {
            post = new Post(
                    json.getInt("id"),
                    json.getInt("userId"),
                    json.getString("title"),
                    json.getString("body")
            );
        } catch (JSONException e) {
            System.out.println("Erro no JSON." + e.getMessage());
        }

        return post;
    }

    public static void getAllPosts(Context contexto, ServiceDone callback) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            PostRepository.getInstance().addPost( postFromJson(json) );
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
        System.out.println("Antes de ir para a queue");
        queue.add(request);
        System.out.println("Depois de ir para a queue");
    }

}