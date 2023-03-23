package br.com.uniritter.app1_2023_1.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uniritter.app1_2023_1.models.Comment;
import br.com.uniritter.app1_2023_1.repositories.CommentRepository;

public class CommentService {
    public static Comment commentFromJson(JSONObject json) {
        Comment comment = null;

        try {
            comment = new Comment(
                    json.getInt("id"),
                    json.getInt("postId"),
                    json.getString("name"),
                    json.getString("email"),
                    json.getString("body")
            );
        } catch (JSONException e) {
            System.out.println("Erro no JSON." + e.getMessage());
        }

        return comment;
    }

    public static void getAllComments(Context contexto, ServiceDone callback) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments", null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            CommentRepository.getInstance().addComment(commentFromJson(json));
                        } catch (JSONException e) {
                            System.out.println("Erro no JSON. Fogo no parquinho! " + e.getMessage());

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