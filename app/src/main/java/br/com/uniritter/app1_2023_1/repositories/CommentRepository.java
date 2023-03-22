package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Comment;
import br.com.uniritter.app1_2023_1.models.User;

public class CommentRepository {
    private Map<Integer, Comment> commentMap;

    private static CommentRepository instance = null;

    private CommentRepository() {
        this.commentMap = new HashMap<>();
    }

    public static CommentRepository getInstance() {
        if (instance == null) {
            instance = new CommentRepository();
        }
        return instance;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            this.commentMap.put(comment.getId(), comment);
        }
    }

    public boolean contains(Comment comment) {
        return this.commentMap.containsValue(comment);
    }

    public boolean contains(Integer id) {
        return this.commentMap.containsKey(id);
    }

    public Collection<Comment> getComments() {
        return this.commentMap.values();
    }
}
