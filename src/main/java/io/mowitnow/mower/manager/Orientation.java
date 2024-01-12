package io.mowitnow.mower.manager;

public enum Orientation {
	N, E, S, W;
	
	private static Orientation[] allValues = Orientation.values();
	public Orientation nextElement() {
		return allValues[(this.ordinal() + 1) % allValues.length];
	}
	
	public Orientation previousElement() {
		if (this.ordinal() == 0)
			return allValues[allValues.length - 1];
		else
			return allValues[this.ordinal() - 1];
	}

}
