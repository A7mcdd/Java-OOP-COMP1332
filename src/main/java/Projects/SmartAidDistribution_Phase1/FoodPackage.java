package Projects.SmartAidDistribution_Phase1;

public class FoodPackage extends AidItem {
	private static final long serialVersionUID = 1L;
	public FoodPackage(String code, String description) {
		super(code, description);
	}
	@Override
	public String getCategory() {
		return "Food Package";
	}
}
