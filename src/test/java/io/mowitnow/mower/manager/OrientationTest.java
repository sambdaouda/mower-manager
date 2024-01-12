package io.mowitnow.mower.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrientationTest {
	
	@Test
	public void testNextElement() {
		Assertions.assertEquals(Orientation.E, Orientation.N.nextElement());
		Assertions.assertEquals(Orientation.S, Orientation.E.nextElement());
		Assertions.assertEquals(Orientation.W, Orientation.S.nextElement());
		Assertions.assertEquals(Orientation.N, Orientation.W.nextElement());
		
	}
	
	@Test
	public void testPreviousElement() {
		Assertions.assertEquals(Orientation.W, Orientation.N.previousElement());
		Assertions.assertEquals(Orientation.N, Orientation.E.previousElement());
		Assertions.assertEquals(Orientation.E, Orientation.S.previousElement());
		Assertions.assertEquals(Orientation.S, Orientation.W.previousElement());
		
	}

}
