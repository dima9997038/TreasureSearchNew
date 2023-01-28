package model;

import java.io.Serializable;

public abstract class Artifact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int excavationTime; // milliseconds

	public Artifact(int excavationTime) {
		this.excavationTime = excavationTime;
	}

	public int getExcavationTime() {
		return excavationTime;
	}

	public abstract Category getCategory();
}
