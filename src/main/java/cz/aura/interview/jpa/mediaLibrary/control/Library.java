package cz.aura.interview.jpa.mediaLibrary.control;

import cz.aura.interview.jpa.mediaLibrary.domain.Music;
import cz.aura.interview.jpa.mediaLibrary.domain.genre.MusicGenre;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Rozhraní umožňující pracovat s knihovnou médií
 *
 * @author krpata
 */
public interface Library {

    /**
     * Přidá do knihovny nové médium.
     *
     * @param music - přidávané médium
     */
    @Transactional
    void add(Music music);

    /**
     * Odstraní z knihovny médium.
     *
     * @param music - odebírané médium
     */
    @Transactional
    void remove(Music music);

    /**
     * vrátí všechny hudební alba
     *
     * @return seznam všech hudebních alb
     */
    List<Music> allMusics();

    /**
     * vrátí všechny média, které se nazývají name
     *
     * @param name
     * @return média s názvem obsahujícím name
     */
    List<Music> findByName(String name);

    /**
     * vrátí médium s konkrétním identifikátorem nebo null, pokud takové médium v knihovně není
     *
     * @param identification
     * @return
     */
    Music findByIdentification(int identification);

    /**
     * vrátí všechny hudební alba, které obsahují skladbu, která v názvu obsahuje songName
     *
     * @param songName
     * @return hudební alba se skladbou nazvanou songName
     */
    List<Music> findBySongName(String songName);

    /**
     * vrátí všechna hudební alba daného žánru
     *
     * @param musicGenre
     * @return všechna hudební alba žánru musicGenre
     */
    List<Music> findByGenre(MusicGenre musicGenre);

}
