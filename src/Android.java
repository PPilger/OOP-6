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

	public ValidationCode validateAndroid(Android other) {
		return new Valid();
	}

	public ValidationCode validAttribute(Servant other) {
		return new Valid();
	}

	public ValidationCode validAttribute(HeavyWorker other) {
		return new Valid();
	}

	public ValidationCode validAttribute(Guardian other) {
		return new Valid();
	}

	public ValidationCode validAttribute(TouchSensitiveSkin skin) {
		return new Valid();
	}

	public ValidationCode validAttribute(SolidSkin skin) {
		return new Valid();
	}

	public ValidationCode validAttribute(ArmoredSkin skin) {
		return new Valid();
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
