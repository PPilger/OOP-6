/**
 * 
 * @author Christian Kletzander
 * 
 */
public class BuildingWorker extends HeavyWorker {

	public BuildingWorker(int serialNum, Kit kit, Skin skin, Software software) {
		super(serialNum, kit, skin, software);
	}

	@Override
	public ValidationCode validSoftware(BuildingWorker.BaseSoftware s) {
		return new Valid();
	}

	@Override
	public String getType() {
		return "BuildingWorker";
	}

	public static class BaseSoftware extends Software {

		public BaseSoftware(int serialNum, SecurityLevel level) {
			super(serialNum, level);
		}

		@Override
		public ValidationCode visit(Android android) {
			return android.validSoftware(this);
		}

	}

}
