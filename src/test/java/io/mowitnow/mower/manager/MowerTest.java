package io.mowitnow.mower.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerTest {
	
	@Test
	public void testPivot() {
		Mower m = new Mower();
		Assertions.assertEquals(Orientation.E, m.pivot('D', Orientation.N));
		Assertions.assertEquals(Orientation.S, m.pivot('D', Orientation.E));
		Assertions.assertEquals(Orientation.W, m.pivot('D', Orientation.S));
		Assertions.assertEquals(Orientation.N, m.pivot('D', Orientation.W));
		
		Assertions.assertEquals(Orientation.W, m.pivot('G', Orientation.N));
		Assertions.assertEquals(Orientation.N, m.pivot('G', Orientation.E));
		Assertions.assertEquals(Orientation.E, m.pivot('G', Orientation.S));
		Assertions.assertEquals(Orientation.S, m.pivot('G', Orientation.W));
	}
	
	@Test
	public void testMove() {
		Mower m = new Mower();
		Position ps = new Position(1, 2);
		Assertions.assertEquals(3, m.move(ps, Orientation.N).getY());
		Assertions.assertEquals(2, m.move(ps, Orientation.E).getX());
		Assertions.assertEquals(1, m.move(ps, Orientation.S).getY());
		Assertions.assertEquals(0, m.move(ps, Orientation.W).getX());
	}
	
	@Test
	public void testControl() {
		Mower m = new Mower();
		m.setPosition(new Position(1, 2));
		m.setOrientation(Orientation.N);
		m.setInstructions("DGA");
		m.control(new Position(7, 7));
		Assertions.assertEquals(Orientation.N, m.getOrientation());
		Assertions.assertEquals(3, m.getPosition().getY());
	}

}
