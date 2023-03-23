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

import br.com.uniritter.app1_2023_1.models.Album;
import br.com.uniritter.app1_2023_1.repositories.AlbumRepository;
import br.com.uniritter.app1_2023_1.repositories.UserRepository;

public class AlbumService {
    public static Album albumFromJson (JSONObject json) {
        Album album = null;

        try {
            album = new Album(
                    json.getInt("id"),
                    json.getInt("userId"),
                    json.getString("title")
            );
        } catch (JSONException e) {
            System.out.println("Erro no JSON." + e.getMessage());
        }

        return album;
    }

    public static void getAllAlbums(Context contexto, ServiceDone callback) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/albums", null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            AlbumRepository.getInstance().addAlbum( albumFromJson(json) );
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