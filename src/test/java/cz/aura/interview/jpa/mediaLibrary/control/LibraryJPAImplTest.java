package cz.aura.interview.jpa.mediaLibrary.control;

import cz.aura.interview.jpa.mediaLibrary.domain.Music;
import cz.aura.interview.jpa.mediaLibrary.domain.Song;
import cz.aura.interview.jpa.mediaLibrary.domain.genre.MusicGenre;
import cz.aura.interview.jpa.mediaLibrary.testSupport.BaseDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-jpa.xml")
public class LibraryJPAImplTest {

	@Autowired
	private Library library;
	@Autowired
	private BaseDAO jpaBaseDAOImpl;

	private Music music;

	@Before
	public void setUp() {
		clearLibrary();
		setUpMusic();
	}

	@Test
	public void testAdd() {
		final int sizeBeforeAdding = actualLibrarySize();

		addToLibrary(music);

		assertEquals("Po přidání nového média se nezvýšil počet médií v knihovně", sizeBeforeAdding + 1, actualLibrarySize());
		Assert.assertEquals("Po přidání nového média se toto médium v knihovně nenašlo", music, library.findByIdentification(music.getId()));
	}

	@Test
	public void testRemove() {
		addToLibrary(music);
		final int sizeBeforeRemoving = actualLibrarySize();

		library.remove(music);

		assertEquals("Počet médií v knihovně se po odebrání média nezmenšil o 1", sizeBeforeRemoving - 1, actualLibrarySize());
		assertNull("Po odebrání média z knihovny se toto médium v knihovně nachází", library.findByIdentification(music.getId()));
	}

	@Test
	public void testAllMusics() {
		addToLibrary(music);

		final List<Music> allMusics = library.allMusics();

		assertEquals("Neodpovídá správný počet vrácených médií z knihovny", 1, allMusics.size());
		assertTrue("Přidané hudební album není zahrnuto mezi vrácenými médii", allMusics.contains(music));
		Assert.assertEquals("V knihovně se nachází jiné médium než to, které tam bylo přidané", music, library.findByIdentification(music.getId()));
	}

	@Test
	public void testFindByIdentificationWhereMediumNotInLibrary() {
		addToLibrary(music);

		final Music medium = library.findByIdentification(555);

		assertNull("Médium, které není v knihovně bylo najito pomocí identifikace", medium);
	}

	@Test
	public void testFindByIdentification() {
		addToLibrary(music);

		final Music medium = library.findByIdentification(music.getId());

		assertEquals("Médium, které bylo do knihovny přidáno nebylo najito pomocí identifikace", music, medium);
	}

	@Test
	public void testFindBySongName() {
		addToLibrary(music);
		final String songName = music.getSongs().get(0).getName();

		final List<Music> findBySongName = library.findBySongName(songName);

		assertTrue("Nepodařilo se najít hudební album podle názvu písničky", findBySongName.contains(music));
	}

	@Test
	public void testNotFindBySongName() {
		addToLibrary(music);

		final List<Music> findBySongName = library.findBySongName("Takový název písničky určitě neexsituje");

		assertTrue("Podařilo se najít hudební album podle názvu písničky, kterou žádné album neobsahuje", findBySongName.isEmpty());
	}

	@Test
	public void testFindByGenre() {
		addToLibrary(music);

		final List<Music> findByGenre = library.findByGenre(music.getMusicGenre());

		assertTrue("Nepodařilo se najít hudební album podle žánru", findByGenre.contains(music));
	}

	@Test
	public void testNotFindByGenre() {
		addToLibrary(music);

		final List<Music> findByGenre = library.findByGenre(MusicGenre.POP);

		assertTrue("Podařilo se najít hudební album podle žánru, které neexistuje", findByGenre.isEmpty());
	}

	@Test
	public void testFindByName() {
		addToLibrary(music);

		final List<Music> findByName = library.findByName(music.getTitle());

		assertEquals("Nedpovídá správný počet vrácených médií z knihovny", 1, findByName.size());
		assertTrue("Přidané hudební album není zahrnuto mezi vrácenými médii", findByName.contains(music));
	}

	private void addToLibrary(final Music... mediums) {
		for (final Music music : mediums) {
			library.add(music);
		}
	}

	private int actualLibrarySize() {
		return library.allMusics().size();
	}

	private void setUpMusic() {
		music = new Music();
		music.setTitle("Název alba");
		music.setArtist("Název autora");
		music.setMusicGenre(MusicGenre.BLUES);
		music.setSongs(new ArrayList<Song>());

		addSong("1. skladba", music);
		addSong("2. skladba", music);
	}

	private void addSong(String name, Music music) {
		Song song = new Song();
		song.setName(name);
		song.setMusic(music);
		music.getSongs().add(song);
	}

	private void clearLibrary() {
		deleteAllTables();
	}

	private void deleteAllTables() {
		deleteTables(Song.class, Music.class);
	}

	private void deleteTables(final Class<?>... entityClasses) {
		for (final Class<?> entityClass : entityClasses) {
			jpaBaseDAOImpl.executeUpdate("DELETE FROM " + entityClass.getSimpleName());
		}
	}

}
