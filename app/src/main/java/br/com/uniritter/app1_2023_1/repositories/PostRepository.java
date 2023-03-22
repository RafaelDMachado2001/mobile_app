package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Post;

public class PostRepository {
    private Map<Integer, Post> postMap;

    private static PostRepository instance = null;

    private PostRepository() {
        this.postMap = new HashMap<>();
    }

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }

        return instance;
    }

    public void addPost(Post post) {
        if (post != null) {
            this.postMap.put(post.getId(), post);
        }
    }

    public boolean contains(Post post) {
        return this.postMap.containsValue(post);
    }

    public boolean contains(Integer id) {
        return this.postMap.containsKey(id);
    }

    public Collection<Post> getPosts() {
        return this.postMap.values();
    }
}
