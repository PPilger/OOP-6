public abstract class Android {
	private int serialNum;
	private Kit kit;
	private Skin skin;
	private Software software;

	public int getSerialNum() {
		return serialNum;
	}

	public Kit getKit() {
		return kit;
	}

	public ErrorCode setKit(Kit kit) {
		//TODO:
		return null;
	}

	public Skin getSkin() {
		return skin;
	}
	
	public ErrorCode setSkin(TouchSensitiveSkin skin) {
		this.skin = skin;
		return null;
	}

	public ErrorCode setSkin(SolidSkin skin) {
		this.skin = skin;
		return null;
	}

	public ErrorCode setSkin(ArmoredSkin skin) {
		this.skin = skin;
		return null;
	}

	public Software getSoftware() {
		return software;
	}

	public ErrorCode setSoftware(Software software) {
		this.software = software;
		return null;
	}
}
