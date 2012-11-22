
public class SecurityLevel4 implements SecurityLevel{

	@Override
	public ValidationCode validateAndroid(Android android) {
		return android.validSecLevel(this);
	}

}
