public abstract class Android implements AndroidVisitor {
	private int serialNum;
	private Kit kit;
	private Skin skin;
	private Software software;

	public Android(int serialNum, Kit kit, Skin skin, Software software) {
		this.serialNum = serialNum;
		this.kit = kit;
		this.skin = skin;
		this.software = software;
	}

	public ValidationCode validate() {
		SerialNumber num = new SerialNumber(serialNum);
		ValidationCode result;
		ValidationCode code1;
		ValidationCode code2;

		// ueberpruefe die Seriennummer aller Komponenten
		result = kit.validSerialNum(num);

		code1 = skin.validSerialNum(num);
		result.mergeAnd(code1);

		code1 = software.validSerialNum(num);
		result.mergeAnd(code1);

		// ueberpruefe die Anforderungen der einzelnen Typen
		code1 = skin.visit(this);
		result.mergeAnd(code1);

		code1 = software.visit(this);
		result.mergeAnd(code1);

		code1 = software.getLevel().visit(this);
		result.mergeAnd(code1);

		// bei den Leistungsklassen muss der Typ des Androiden oder die
		// Sicherheitsstufe der Software festlegen, welche Leistungsklasse
		// zulaessig ist.
		code1 = kit.getPowerClass().visit(this);
		code2 = kit.getPowerClass().visit(software.getLevel());
		code1 = code1.mergeOr(code2);
		result.mergeAnd(code1);

		return result;
	}

	public ValidationCode validate(Android replaced) {
		ValidationCode code1 = validate();

		// ueberpruefen, ob der neue Android den alten ersetzen darf
		ValidationCode code2 = visit(replaced);

		// der neue Android muss gueltig sein und muss den alten Android
		// ersetzen duerfen
		code1 = code1.mergeAnd(code2);
		
		return code1;
	}

	public abstract ValidationCode visit(Android replacing);

	// Visitor-Pattern Methoden um den Haupttyp zu ueberpruefen (dieser muss
	// gleich sein wie der eigene)

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
	// nach Haupttyp)

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
	// der Klasse des Androiden zusammenpassen)

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
	// (Einschraenkungen je nach Typ)

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

	public int getSerialNum() {
		return this.serialNum;
	}

	public Kit getKit() {
		return kit;
	}

	public Skin getSkin() {
		return skin;
	}

	public Software getSoftware() {
		return software;
	}
	
	public abstract String getType();
	
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
