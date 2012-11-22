public abstract class Android implements Validable {
	private int serialNum;
	private Kit kit;
	private Skin skin;
	private Software software;

	public Android(int serialNum) {
		this.serialNum = serialNum;
	}

	public ValidationCode validate() {
		ValidationCode code = new Valid();

		code = code.validate(this, skin);
		code = code.validate(this, software);
		code = code.validate(this, software.getLevel());

		return code;
	}

	public ValidationCode validate(Android replaced) {
		ValidationCode code = validate();
		return code.validate(this, replaced);
	}

	public abstract ValidationCode validateAndroid(Android replacing);

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

	public ValidationCode validSoftware(Partner.BaseSoftware s) {
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
		return validPowerClass((PowerClass.Unlimited)s);
	}

	public ValidationCode validPowerClass(PowerClass.LE5 s) {
		return validPowerClass((PowerClass.LE10)s);
	}

	public ValidationCode validPowerClass(PowerClass.LE1 s) {
		return validPowerClass((PowerClass.LE1)s);
	}
	

	public int getSerialNum() {
		return serialNum;
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}
}
