package cz.aura.interview.jpa.mediaLibrary.domain;

import java.io.Serializable;

/**
 * Název skladby v hudebním albu (Music)
 *
 * @author krpata
 */
public class Song implements Serializable {

    private static final long serialVersionUID = -1844577701519142499L;

    private Integer versionid;

    private Integer id;

    private String name;

    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(final Music music) {
        this.music = music;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }

}
