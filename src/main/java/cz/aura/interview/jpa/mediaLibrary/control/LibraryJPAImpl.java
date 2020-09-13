package cz.aura.interview.jpa.mediaLibrary.control;

import cz.aura.interview.jpa.mediaLibrary.domain.Music;
import cz.aura.interview.jpa.mediaLibrary.domain.genre.MusicGenre;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * JPA implementace rozhraní Library
 */
public class LibraryJPAImpl implements Library {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Music music) {
        throw new NotImplementedException();
    }

    @Override
    public void remove(Music music) {
        throw new NotImplementedException();
    }

    @Override
    public List<Music> allMusics() {
        throw new NotImplementedException();
    }

    @Override
    public List<Music> findByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public Music findByIdentification(int identification) {
        throw new NotImplementedException();
    }

    @Override
    public List<Music> findBySongName(String songName) {
        throw new NotImplementedException();
    }

    @Override
    public List<Music> findByGenre(MusicGenre musicGenre) {
        throw new NotImplementedException();
    }
}
