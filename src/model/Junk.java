package model;

public class Junk extends Artifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Junk(int excavationTime) {
		super(excavationTime);
	}

	@Override
	public Category getCategory() {
		return Category.OTHER;
	}

}
