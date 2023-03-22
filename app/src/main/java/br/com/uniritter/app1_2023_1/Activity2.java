package br.com.uniritter.app1_2023_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.uniritter.app1_2023_1.models.Album;
import br.com.uniritter.app1_2023_1.models.Comment;
import br.com.uniritter.app1_2023_1.models.Photo;
import br.com.uniritter.app1_2023_1.models.Post;
import br.com.uniritter.app1_2023_1.models.Todo;
import br.com.uniritter.app1_2023_1.models.User;
import br.com.uniritter.app1_2023_1.repositories.AlbumRepository;
import br.com.uniritter.app1_2023_1.repositories.CommentRepository;
import br.com.uniritter.app1_2023_1.repositories.PhotoRepository;
import br.com.uniritter.app1_2023_1.repositories.PostRepository;
import br.com.uniritter.app1_2023_1.repositories.TodoRepository;
import br.com.uniritter.app1_2023_1.repositories.UserRepository;
import br.com.uniritter.app1_2023_1.services.AlbumService;
import br.com.uniritter.app1_2023_1.services.CommentService;
import br.com.uniritter.app1_2023_1.services.PhotoService;
import br.com.uniritter.app1_2023_1.services.PostService;
import br.com.uniritter.app1_2023_1.services.ServiceDone;
import br.com.uniritter.app1_2023_1.services.TodoService;
import br.com.uniritter.app1_2023_1.services.UserService;

public class Activity2 extends AppCompatActivity  {
    private EditText edit;
    private List<User> users = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();
    private List<Photo> photos = new ArrayList<>();
    private List<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Button btn2_1 = findViewById(R.id.button2_1);
        btn2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.btBuscaTodos);
        btn.setOnClickListener(view->{
            getAllUsers();
        });

        Button postBtn = findViewById(R.id.btBuscaPosts);
        postBtn.setOnClickListener(view -> {
            getAllPosts();
        });

        Button commentBtn = findViewById(R.id.btBuscaComments);
        commentBtn.setOnClickListener(view -> {
            getAllComments();
        });

        Button albumBtn = findViewById(R.id.btBuscaAlbums);
        albumBtn.setOnClickListener(view -> {
            getAllAlbums();
        });

        Button photoBtn = findViewById(R.id.btBuscaPhotos);
        photoBtn.setOnClickListener(view -> {
            getAllPhotos();
        });

        Button todoBtn = findViewById(R.id.btBuscaTodo);
        todoBtn.setOnClickListener(view -> {
            getAllTodos();
        });

    }
    private void getAllUsers() {
        System.out.println("Antes -> "+UserRepository.getInstance().getUsers());
        UserService.getAllUsers(this, ()->System.out.println("Depois -> "+ UserRepository.getInstance().getUsers()));
    }

    private void getAllPosts() {
        System.out.println("Antes -> " + PostRepository.getInstance().getPosts());
        PostService.getAllPosts(this, ()->System.out.println("Depois -> " + PostRepository.getInstance().getPosts()));
    }

    private void getAllComments() {
        System.out.println("Antes -> " + CommentRepository.getInstance().getComments());
        CommentService.getAllComments(this, ()->System.out.println("Depois -> " + CommentRepository.getInstance().getComments()));
    }

    private void getAllAlbums() {
        System.out.println("Antes -> " + AlbumRepository.getInstance().getAlbums());
        AlbumService.getAllAlbums(this, ()->System.out.println("Depois -> " + AlbumRepository.getInstance().getAlbums()));
    }

    private void getAllPhotos() {
        System.out.println("Antes -> " + PhotoRepository.getInstance().getPhotos());
        PhotoService.getAllPhotos(this, ()->System.out.println("Depois -> " + PhotoRepository.getInstance().getPhotos()));
    }

    private void getAllTodos() {
        System.out.println("Antes -> " + TodoRepository.getInstance().getTodos());
        TodoService.getAllTodos(this, ()->System.out.println("Depois -> " + TodoRepository.getInstance().getTodos()));
    }


}