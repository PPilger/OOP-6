
public abstract class SecurityLevel implements AndroidVisitor {
	
	// Visitor-Pattern Methoden um die Leistungsklasse zu ueberpruefen
	// (Einschraenkungen je nach Typ)


	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Error("Invalid Power Class");
	}

	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return validPowerClass((PowerClass.Unlimited)s);
	}

	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return validPowerClass((PowerClass.LE10)s);
	}

	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return validPowerClass((PowerClass.LE1)s);
	}
	
}
