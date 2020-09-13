package cz.aura.interview.spring.zoo;

import cz.aura.interview.spring.zoo.animal.Elephant;
import cz.aura.interview.spring.zoo.animal.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-spring-zoo.xml")
public class ZooTest {
	
	private Zoo zoo;
	private Zoo zoo1Again;

	private Lion lion1;
	private Lion lion1Again;

	private List<Elephant> elephants;
	private List<Lion> lions;

	private Lion lion2;
	private Lion lion3;
	private Lion lion4;

	private Elephant elephant1;
	private Elephant elephant2;
	private Elephant elephant3;
	private Elephant elephant4;

	@Test
	public void testLionsChildrens() {
		assertEquals("Počet dětí lva " + lion1.getName() + " je jiný než očekávaný", 2, lion1.getChildren().size());
		assertEquals("Počet dětí lva " + lion2.getName() + " je jiný než očekávaný", 0, lion2.getChildren().size());
		assertEquals("Počet dětí lva " + lion3.getName() + " je jiný než očekávaný", 2, lion3.getChildren().size());
		assertEquals("Počet dětí lva " + lion4.getName() + " je jiný než očekávaný", 0, lion4.getChildren().size());

		assertTrue("Mezi dětmi lva " + lion1.getName() + " není očekávaný " + lion2.getName(), lion1.getChildren().contains(lion2));
		assertTrue("Mezi dětmi lva " + lion1.getName() + " není očekávaný " + lion4.getName(), lion1.getChildren().contains(lion4));
		assertFalse("Mezi dětmi lva " + lion1.getName() + " je neočekávaný " + lion3.getName(), lion1.getChildren().contains(lion3));
		assertFalse("Mezi dětmi lva " + lion1.getName() + " je neočekávaný " + lion1.getName(), lion1.getChildren().contains(lion1));

		assertTrue("Mezi dětmi lva " + lion3.getName() + " není očekávaný " + lion2.getName(), lion3.getChildren().contains(lion2));
		assertTrue("Mezi dětmi lva " + lion3.getName() + " není očekávaný " + lion4.getName(), lion3.getChildren().contains(lion4));
		assertFalse("Mezi dětmi lva " + lion3.getName() + " je neočekávaný " + lion3.getName(), lion3.getChildren().contains(lion3));
		assertFalse("Mezi dětmi lva " + lion3.getName() + " je neočekávaný " + lion1.getName(), lion3.getChildren().contains(lion1));
	}

	@Test
	public void testElephantsParents() {
		assertNull("Otec slona: " + elephant1.getName() + " je zadán", elephant1.getFather());
		assertNotNull("Otec slona: " + elephant2.getName() + " není zadán", elephant2.getFather());
		assertEquals("Otec slona: " + elephant2.getName() + " není podle očekávání", elephant3, elephant2.getFather());
		assertNotNull("Otec slona: " + elephant3.getName() + " není zadán", elephant3.getFather());
		assertEquals("Otec slona: " + elephant3.getName() + " není podle očekávání", elephant4, elephant3.getFather());
		assertNull("Otec slona: " + elephant4.getName() + " je zadán", elephant4.getFather());

		assertNull("Matka slona: " + elephant1.getName() + " je zadán", elephant1.getFather());
		assertNotNull("Matka slona: " + elephant2.getName() + " není zadán", elephant2.getFather());
		assertEquals("Matka slona: " + elephant2.getName() + " není podle očekávání", elephant1, elephant2.getMother());
		assertNotNull("Matka slona: " + elephant3.getName() + " není zadán", elephant3.getFather());
		assertEquals("Matka slona: " + elephant3.getName() + " není podle očekávání", elephant1, elephant3.getMother());
		assertNull("Matka slona: " + elephant4.getName() + " je zadán", elephant4.getFather());
	}

	@Test
	public void testNotSameInstance() {
		assertFalse("Instance zoo je stejná jako instance zoo1Again", zoo.equals(zoo1Again));
	}

	@Test
	public void testTheSameInstance() {
		assertTrue("Instance lion1 je jiná než instance lion1Again", lion1.equals(lion1Again));
	}

	@Test
	public void testAutowiredAllLions() {
		assertEquals("Po načtení springem je počet beanů se lvama jiný než očekávaný", 4, lions.size());
	}

	@Test
	public void testAutowiredAllElephants() {
		assertEquals("Po načtení springem je počet beanů se slony jiný než očekávaný", 4, elephants.size());
	}

	@Test
	public void testAnimalsCount() {
		assertEquals("Po načtení springem je počet zvířat v zoo jiný než očekávaný", 8, zoo.getAnimals().size());
	}

	@Test
	public void testLionsCount() {
		assertEquals("Po načtení springem je počet lvů v zoo jiný než očekávaný", 4, zoo.getLions().size());
	}

	@Test
	public void testElephantsCount() {
		assertEquals("Po načtení springem je počet slonů v zoo jiný než očekávaný", 4, zoo.getElephants().size());
	}

	@Test
	public void testLionsContent() {
		final List<Lion> zooLions = zoo.getLions();
		for (Lion lion : lions) {
			assertTrue("Po načtení springem není mezi lvi lev: " + lion.getName(), zooLions.contains(lion));
		}
	}

	@Test
	public void testElephantsContent() {
		final List<Elephant> zooElephants = zoo.getElephants();
		for (Elephant elephant : elephants) {
			assertTrue("Po načtení springem není mezi slony slon: " + elephant.getName(), zooElephants.contains(elephant));
		}
	}
}
