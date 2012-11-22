
public class SecurityLevel3 implements SecurityLevel{

	@Override
	public ValidationCode validateAndroid(Android android) {
		return android.validSecLevel(this);
	}

}
