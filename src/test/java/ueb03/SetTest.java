package ueb03;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
	@Test
	void testStringSet() {

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		Set impl = new SetImpl();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String d : str.split(" ")) {
			impl.add(d);
		}

		System.out.println(impl);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl.size());

		// Elemente testen
		assertTrue(impl.contains("In"));
		assertTrue(impl.contains("Ulm"));
		assertFalse(impl.contains(""));
		assertFalse(impl.contains("Hans"));

		// zwei herausnehmen
		impl.remove("Ulm");
		impl.remove("um");
		assertThrows(NoSuchElementException.class, () -> impl.remove("Hams"));

		assertEquals(3, impl.size());

		System.out.println(impl);

		// nochmal Elemente testen
		assertFalse(impl.contains("Ulm"));
		assertFalse(impl.contains("um"));
		assertFalse(impl.contains("Hans"));
	}

}