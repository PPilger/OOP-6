import java.util.TreeMap;

/**
 * Repraesentiert eine Leistungsklasse, die eine Obergrenze fuer den
 * kW-Verbrauch angibt.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class PowerClass {
	// Eine Map mit allen Leistungsklassen. Der Schluessel ist die Obergrenze
	// der Leistungsklasse
	private static TreeMap<Double, PowerClass> powerClasses = new TreeMap<Double, PowerClass>();

	/**
	 * Visitor-Pattern: besucht die passende validPowerClass-Methode des
	 * uebergebenen Androids
	 */
	public abstract ValidationCode visit(Android android);

	/**
	 * Visitor-Pattern: besucht die passende validPowerClass-Methode des
	 * uebergebenen SecurityLevels
	 */
	public abstract ValidationCode visit(SecurityLevel level);

	static {
		// Fuelle die Map mit den Leistungsklassen
		powerClasses.put(Double.POSITIVE_INFINITY, new PowerClass.Unlimited());
		powerClasses.put(10., new PowerClass.LE10());
		powerClasses.put(5., new PowerClass.LE5());
		powerClasses.put(1., new PowerClass.LE1());
	}

	/**
	 * Liefert die kleinste Leistungsklasse, in der die uebergebene Leistung
	 * enthalten ist.
	 */
	public static PowerClass getPowerClass(double power) {
		// "Aufrunden" auf die naechste Leistungsklasse
		return powerClasses.ceilingEntry(power).getValue();
	}

	// Die einzelnen Leistungsklassen:

	/**
	 * Keine Leistungseinschraenkung
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static class Unlimited extends PowerClass {
		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	/**
	 * Die Leistung ist <= 10.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static class LE10 extends PowerClass {
		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	/**
	 * Die Leistung ist <= 5.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static class LE5 extends PowerClass {
		@Override
		public ValidationCode visit(Android android) {
			return android.validPowerClass(this);
		}

		@Override
		public ValidationCode visit(SecurityLevel level) {
			return level.validPowerClass(this);
		}
	}

	/**
	 * Die Leistung ist <= 1.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	public static class LE1 extends PowerClass {
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
