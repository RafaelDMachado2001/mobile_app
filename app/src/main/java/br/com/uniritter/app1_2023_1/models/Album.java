package br.com.uniritter.app1_2023_1.models;

import androidx.annotation.NonNull;

public class Album {
    private int id;
    private int userId;
    private String title;

    public Album (int id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: " + id +
                "UserID: " + userId +
                ", Título: " + title +
                "; ";
    }
}
