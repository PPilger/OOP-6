/**
 * Invariante: Ein Android-Objekt ist unveraenderbar.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class Android {
	private int serialNum;
	private Kit kit; // Sensoren-Aktoren-Kit
	private Skin skin;
	private Software software;

	public Android(int serialNum, Kit kit, Skin skin, Software software) {
		this.serialNum = serialNum;
		this.kit = kit;
		this.skin = skin;
		this.software = software;
	}

	public int getSerialNum() {
		return this.serialNum;
	}

	/**
	 * Ueberprueft, ob der Android gueltig ist. Liefert Valid, wenn er gueltig
	 * ist und Error anderenfalls.
	 */
	public ValidationCode validate() {
		SerialNumberValidator num = new SerialNumberValidator(serialNum);
		ValidationCode result;
		ValidationCode code;

		// ueberpruefe die Seriennummer aller Komponenten
		result = kit.validSerialNum(num);

		code = skin.validSerialNum(num);
		result = result.merge(code);

		code = software.validSerialNum(num);
		result = result.merge(code);

		// ueberpruefe die Anforderungen der einzelnen Typen
		code = skin.visit(this);
		result = result.merge(code);

		code = software.visit(this);
		result = result.merge(code);

		code = software.getLevel().visit(this);
		result = result.merge(code);

		code = kit.getPowerClass().visit(this);
		result = result.merge(code);

		// die Sicherheitsstufe muss die Leistungsklasse ebenfalls akzeptieren
		code = kit.getPowerClass().visit(software.getLevel());
		result = result.merge(code);

		return result;
	}

	/**
	 * Ueberprueft, ob der Android gueltig ist und ob er den uebergebenen
	 * ersetzen kann. Liefert Valid, wenn es zutrifft und Error anderenfalls.
	 */
	public ValidationCode validate(Android replaced) {
		ValidationCode result;
		ValidationCode code;

		result = this.validate();
		
		// ueberpruefen, ob die Seriennummer nicht veraendert wurde
		SerialNumberValidator snVal = new SerialNumberValidator(serialNum);
		code = snVal.validate(replaced.serialNum);
		result = result.merge(code);

		// ueberpruefen, ob der Haupttyp nicht veraendert wurde
		code = this.visit(replaced);
		result = result.merge(code);

		// ueberpruefen, ob die Sicherheitsstufe nicht veraendert wurde
		code = software.getLevel().visit(replaced.software.getLevel());
		result = result.merge(code);

		return result;
	}

	/**
	 * Visitor-Pattern: besucht die passende validMainType-Methode von
	 * replacing.
	 */
	public abstract ValidationCode visit(Android replacing);

	// Visitor-Pattern Methoden um den Haupttyp zu ueberpruefen (dieser muss
	// gleich sein wie der eigene):

	public ValidationCode validMainType(Servant other) {
		return new Error("Invalid Type");
	}

	public ValidationCode validMainType(HeavyWorker other) {
		return new Error("Invalid Type");
	}

	public ValidationCode validMainType(Guard other) {
		return new Error("Invalid Type");
	}

	// Visitor-Pattern Methoden um den Skin zu ueberpruefen (Einschraenkungen je
	// nach Haupttyp):

	public ValidationCode validSkin(TouchSensitiveSkin skin) {
		return new Error("Invalid Skin");
	}

	public ValidationCode validSkin(SolidSkin skin) {
		return new Error("Invalid Skin");
	}

	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Error("Invalid Skin");
	}

	// Visitor-Pattern Methoden um die Software zu ueberpruefen (diese muss mit
	// der Klasse des Androiden zusammenpassen):

	public ValidationCode validSoftware(Assistant.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(Bodyguard.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(BuildingWorker.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(Fighter.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(ObjectGuard.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(Associate.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(ServiceTechnician.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	public ValidationCode validSoftware(TransportWorker.BaseSoftware s) {
		return new Error("Invalid Software");
	}

	// Visitor-Pattern Methoden um das Sicherheitslevel zu ueberpruefen
	// (Einschraenkungen je nach Typ):

	public ValidationCode validSecLevel(SecurityLevel1 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel2 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel3 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel4 s) {
		return new Error("Invalid Security Level");
	}

	public ValidationCode validSecLevel(SecurityLevel5 s) {
		return new Error("Invalid Security Level");
	}

	// Visitor-Pattern Methoden um die Leistungsklasse zu ueberpruefen
	// (Einschraenkungen je nach Typ):

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

	/**
	 * Liefert den Namen des Typs des Androids.
	 */
	public abstract String getType();

	/**
	 * Gibt den Typ des Android, das Sensor-Aktor-Kit, den Skin und die Software
	 * in Stringdarstellung zurueck.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getType());
		sb.append(": ");
		sb.append(serialNum);
		sb.append("\nKit: ");
		sb.append(kit);
		sb.append("\nSkin: ");
		sb.append(skin);
		sb.append("\nSoftware: ");
		sb.append(software);

		return sb.toString();
	}
}
