
public class SecurityLevel5 implements SecurityLevel{

	@Override
	public ValidationCode validateAndroid(Android android) {
		return android.validSecLevel(this);
	}

}
