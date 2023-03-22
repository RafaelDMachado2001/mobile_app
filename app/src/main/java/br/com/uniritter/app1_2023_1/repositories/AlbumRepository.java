package br.com.uniritter.app1_2023_1.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Album;

public class AlbumRepository {
    private Map<Integer, Album> albumMap;

    private static AlbumRepository instance = null;

    private AlbumRepository() {
        this.albumMap = new HashMap<>();
    }

    public static AlbumRepository getInstance() {
        if (instance == null) {
            instance = new AlbumRepository();
        }

        return instance;
    }

    public void addAlbum(Album album) {
        if (album != null) {
            this.albumMap.put(album.getId(), album);
        }
    }

    public boolean contains(Album album) {
        return this.albumMap.containsValue(album);
    }

    public boolean contains(Integer id) {
        return this.albumMap.containsKey(id);
    }

    public Collection<Album> getAlbums() {
        return this.albumMap.values();
    }

}
