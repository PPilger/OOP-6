import java.util.TreeMap;

public abstract class PowerClass {
	private static TreeMap<Double, PowerClass> powerClasses = new TreeMap<Double, PowerClass>();

	public static PowerClass getPowerClass(double power) {
		return powerClasses.ceilingEntry(power).getValue();
	}

	public static class Unlimited extends PowerClass {
		static {
			powerClasses.put(Double.POSITIVE_INFINITY, new Unlimited());
		}
	}
	
	public static class LE10 extends Unlimited {
		static {
			powerClasses.put(10.0, new LE10());
		}
	}
	
	public static class LE5 extends LE10 {
		static {
			powerClasses.put(5.0, new LE5());
		}
	}
	
	public static class LE1 extends LE5 {
		static {
			powerClasses.put(1.0, new LE1());
		}
	}
}
