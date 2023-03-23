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
        System.out.println("Visualizando todos os USERS \n");
        System.out.println("*************************** \n");
        UserService.getAllUsers(this, ()->System.out.println(UserRepository.getInstance().getUsers()));
    }

    private void getAllPosts() {
        System.out.println("Visualizando todos os POSTS \n");
        System.out.println("*************************** \n");
        PostService.getAllPosts(this, ()->System.out.println(PostRepository.getInstance().getPosts()));
    }

    private void getAllComments() {
        System.out.println("Visualizando todos os COMMENTS \n");
        System.out.println("*************************** \n");
        CommentService.getAllComments(this, ()->System.out.println(CommentRepository.getInstance().getComments()));
    }

    private void getAllAlbums() {
        System.out.println("Visualizando todos os ALBUMS \n");
        System.out.println("*************************** \n");
        AlbumService.getAllAlbums(this, ()->System.out.println(AlbumRepository.getInstance().getAlbums()));
    }

    private void getAllPhotos() {
        System.out.println("Visualizando todos as PHOTOS \n");
        System.out.println("*************************** \n");
        PhotoService.getAllPhotos(this, ()->System.out.println(PhotoRepository.getInstance().getPhotos()));
    }

    private void getAllTodos() {
        System.out.println("Visualizando todos os TODOS \n");
        System.out.println("*************************** \n");
        TodoService.getAllTodos(this, ()->System.out.println(TodoRepository.getInstance().getTodos()));
    }


}