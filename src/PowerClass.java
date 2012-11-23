import java.util.TreeMap;

public abstract class PowerClass implements AndroidVisitor,
		SecurityLevelVisitor {
	private static TreeMap<Double, PowerClass> powerClasses = new TreeMap<Double, PowerClass>();

	public static PowerClass getPowerClass(double power) {
		return powerClasses.ceilingEntry(power).getValue();
	}

	public static class Unlimited extends PowerClass {
		static {
			powerClasses.put(Double.POSITIVE_INFINITY, new Unlimited());
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	public static class LE10 extends PowerClass {
		static {
			powerClasses.put(10.0, new LE10());
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	public static class LE5 extends PowerClass {
		static {
			powerClasses.put(5.0, new LE5());
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	public static class LE1 extends PowerClass {
		static {
			powerClasses.put(1.0, new LE1());
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}
}
