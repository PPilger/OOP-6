/**
 * Invariante: Software-Objekte sind unveraenderbar.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class Software extends Encoded {
	private SecurityLevel level;

	public Software(int serialNum, SecurityLevel level) {
		super(serialNum);
		this.level = level;
	}

	public SecurityLevel getLevel() {
		return level;
	}

	/**
	 * Visitor-Pattern: besucht die passende validSoftware-Methode des
	 * uebergebenen Androids
	 */
	public abstract ValidationCode visit(Android android);
}
