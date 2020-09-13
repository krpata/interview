package cz.aura.interview.jpa.mediaLibrary.domain;

import cz.aura.interview.jpa.mediaLibrary.domain.genre.MusicGenre;

import java.io.Serializable;
import java.util.List;

/**
 * Hudební album
 *
 * @author krpata
 */
public class Music implements Serializable {

    private static final long serialVersionUID = 8874641512082050322L;

    private Integer versionid;

    private Integer id;

    private String title;

    private String artist;

    private MusicGenre musicGenre;

    private List<Song> songs;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(final MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(final List<Song> songs) {
        this.songs = songs;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
