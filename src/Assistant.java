/**
 * 
 * @author Koegler Alexander
 *
 */
public class Assistant extends Servant{

	public Assistant(int serialNum) {
		super(serialNum);
	}
	
	@Override
	public ValidationCode validSkin(TouchSensitiveSkin skin) {
		// TODO Auto-generated method stub
		return super.validSkin(skin);
	}
	
	@Override
	public ValidationCode validSkin(ArmoredSkin skin) {
		// TODO Auto-generated method stub
		return super.validSkin(skin);
	}
	
	@Override
	public ValidationCode validSkin(SolidSkin skin) {
		// TODO Auto-generated method stub
		return super.validSkin(skin);
	}
	
	@Override
	public ValidationCode validMainType(Servant other) {
		// TODO Auto-generated method stub
		return super.validMainType(other);
	}
	
	@Override
	public ValidationCode validMainType(Guardian other) {
		// TODO Auto-generated method stub
		return super.validMainType(other);
	}
	
	@Override
	public ValidationCode validMainType(HeavyWorker other) {
		// TODO Auto-generated method stub
		return super.validMainType(other);
	}
	
	

}
