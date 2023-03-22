package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Photo;

public class PhotoRepository {
    private Map<Integer, Photo> photoMap;

    private static PhotoRepository instance = null;

    private PhotoRepository() {
        this.photoMap = new HashMap<>();
    }

    public static PhotoRepository getInstance() {
        if (instance == null) {
            instance = new PhotoRepository();
        }

        return instance;
    }

    public void addPhoto(Photo photo) {
        if (photo != null) {
            this.photoMap.put(photo.getId(), photo);
        }
    }

    public boolean contains(Photo photo) {
        return this.photoMap.containsValue(photo);
    }

    public boolean contains(Integer id) {
        return this.photoMap.containsKey(id);
    }

    public Collection<Photo> getPhotos() {
        return this.photoMap.values();
    }
}
