
// Yonatan Rubin
// M21105076
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTestSelfMade {
	MorseCodeTree tree;

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@Test
	public void testFetch() {
		// test basic letters
		assertEquals("e", tree.fetch("."));
		assertEquals("t", tree.fetch("-"));
		// test complex paths
		assertEquals("j", tree.fetch(".---"));
		assertEquals("b", tree.fetch("-..."));
		// test for invalid paths

	}

	@Test
	public void testToArrayList() {
		ArrayList<String> list = tree.toArrayList();
		// tree should have 27 elements (26 letters + 1 empty root)
		assertEquals(27, list.size());
		assertEquals("h", list.get(0)); // leftmost
		assertEquals("o", list.get(26)); // rightmost
	}

	@Test
	public void testDeepCopy() {
		TreeNode<String> original = new TreeNode<>("A");
		original.setLeft(new TreeNode<>("B"));

		TreeNode<String> copy = new TreeNode<>(original);

		// is data the same
		assertEquals(original.getData(), copy.getData());
		assertEquals(original.getLeft().getData(), copy.getLeft().getData());

		// are they are different objects in memory (Deep Copy)
		assertNotSame(original, copy);
		assertNotSame(original.getLeft(), copy.getLeft());
	}

	@Test
	public void testConvertToEnglishString() {
		// test a single word
		assertEquals("hello", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. ---"));
		// test multiple words with the " / " delimiter
		assertEquals("sos help", MorseCodeConverter.convertToEnglish("... --- ... / .... . .-.. .--."));
	}

	@Test
	public void testPrintTree() {
		String printed = MorseCodeConverter.printTree();
		// Verify the "double space" between j and b is present
		assertTrue(printed.contains("j  b"));
	}

	@Test(expected = InvalidCodeException.class)
	public void testInvalidCharacter() {
		// This should trigger the exception in fetchNode method
		MorseCodeConverter.convertToEnglish("... ? ...");
	}

	@Test
	public void testUnsupportedOperations() {
		// assertThrows(tree.fetch(null));
		// assertThrows(tree.fetch("....."));

		// testing code length > 4 and null
		assertThrows(InvalidCodeException.class, () -> {
			tree.fetch("......");
		});

		assertThrows(InvalidCodeException.class, () -> {
			tree.fetch(null);
		});

		// testing blocked methods
		assertThrows(UnsupportedOperationException.class, () -> {
			tree.delete("a");
		});
		assertThrows(UnsupportedOperationException.class, () -> {
			tree.update();
		});
	}
}