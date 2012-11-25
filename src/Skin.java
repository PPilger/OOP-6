
public abstract class Skin extends Encoded {
	
	public Skin(int serialNum) {
		super(serialNum);
	}
	
	public abstract ValidationCode visit(Android android);
}