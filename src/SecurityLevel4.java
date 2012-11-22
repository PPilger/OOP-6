
public class SecurityLevel4 extends SecurityLevel{

	@Override
	public ValidationCode validateAndroid(Android android) {
		return android.validSecLevel(this);
	}
	
	@Override
	public ValidationCode validPowerClass(PowerClass.LE10 s) {
		return new Valid();
	}

}
