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

		return code;
	}

	public ValidationCode validate(Android replaced) {
		ValidationCode code = validate();
		return code.validate(this, replaced);
	}

	public abstract ValidationCode validateAndroid(Android replacing);

	public ValidationCode validMainType(Servant other) {
		return new Error("Falscher Typ");
	}

	public ValidationCode validMainType(HeavyWorker other) {
		return new Error("Falscher Typ");
	}

	public ValidationCode validMainType(Guard other) {
		return new Error("Falscher Typ");
	}

	public ValidationCode validSkin(TouchSensitiveSkin skin) {
		return new Valid();
	}

	public ValidationCode validSkin(SolidSkin skin) {
		return new Valid();
	}

	public ValidationCode validSkin(ArmoredSkin skin) {
		return new Valid();
	}
	
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
