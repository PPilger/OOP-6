public abstract class SecurityLevel {

	/**
	 * Visitor-Pattern: besucht die passende validSecLevel-Methode des
	 * uebergebenen Androids
	 */
	public abstract ValidationCode visit(Android android);

	/**
	 * Visitor-Pattern: besucht die passende validSecLevel-Methode des
	 * uebergebenen SecurityLevels
	 */
	public abstract ValidationCode visit(SecurityLevel level);

	// Methoden um das SecurityLevel auf Gleichheit zu ueberpruefen:

	public ValidationCode validSecLevel(SecurityLevel1 level) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel2 level) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel3 level) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel4 level) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel5 level) {
		return new Error("Invalid Security Level");
	}

	// Methoden um die Leistungsklasse zu ueberpruefen (Einschraenkungen je nach
	// Typ):

	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Valid();
	}

	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Valid();
	}

	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return new Valid();
	}

	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return new Valid();
	}
}
