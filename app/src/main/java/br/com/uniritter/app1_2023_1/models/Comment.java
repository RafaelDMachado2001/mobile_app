package br.com.uniritter.app1_2023_1.models;

import androidx.annotation.NonNull;

public class Comment {
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;

    public Comment (int id, int postId, String name, String email, String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: " + id +
                "PostID: " + postId +
                ", Nome: " + name +
                ", Email: " + email +
                ", Descrição: " + body +
                "; ";
    }
}
