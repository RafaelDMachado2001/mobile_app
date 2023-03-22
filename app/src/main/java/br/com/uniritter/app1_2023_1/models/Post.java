package br.com.uniritter.app1_2023_1.models;

import androidx.annotation.NonNull;

public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;

    public Post (int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: " + id +
                "UserID: " + userId +
                ", Título: " + title +
                ", Descrição: " + body +
                "; ";
    }
}
