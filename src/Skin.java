public abstract class Skin extends Encoded {

	public Skin(int serialNum) {
		super(serialNum);
	}

	/**
	 * Visitor-Pattern: besucht die passende validSkin-Methode des uebergebenen
	 * Androids
	 */
	public abstract ValidationCode visit(Android android);
}