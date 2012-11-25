
public abstract class SecurityLevel {
	
	public abstract ValidationCode visit(Android android);
	
	public abstract ValidationCode visit(SecurityLevel level);

	// Visitor-Pattern Methoden um das SecurityLevel auf Gleichheit
	// zu ueberpruefen

	public ValidationCode validSecurityLevel(SecurityLevel1 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecurityLevel(SecurityLevel2 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecurityLevel(SecurityLevel3 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecurityLevel(SecurityLevel4 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecurityLevel(SecurityLevel5 s) {
		return new Error("Invalid Security Level");
	}
	
	// Visitor-Pattern Methoden um die Leistungsklasse zu ueberpruefen
	// (Einschraenkungen je nach Typ)


	public ValidationCode validPowerClass(PowerClass.Unlimited s) {
		return new Error("Invalid Power Class");
	}

	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Error("Invalid Power Class");
	}

	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return new Error("Invalid Power Class");
	}

	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return new Error("Invalid Power Class");
	}
	
	public ValidationCode validSecLevel(SecurityLevel level) {
		return new Error("Invalid Security Level");		
	}
	
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
}
