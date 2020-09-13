package cz.aura.interview.jpa.mediaLibrary.domain.genre;

/**
 * Výčtový typ hudebních žánrů
 *
 * @author krpata
 */
public enum MusicGenre {
    BLUES("blues"), COUNTRY("country"), FOLK("folk"), POP("pop"), ROCK("rock");

    private String name;

    MusicGenre(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
