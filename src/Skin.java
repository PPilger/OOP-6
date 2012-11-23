
public abstract class Skin implements AndroidVisitor {
	
	private int serialNum;
	
	public Skin(int serialNum) {
		this.serialNum = serialNum;
	}
	
	public int getSerialNum() {
		return this.serialNum;
	}
	
}