package week08.zachary.id.ac.umn;

public class Cash extends Payment2 {
	public Cash(Item item) {
		super();
	}
	
	public int pay() {
		if(isPaidOff) {
			return 0;
		}
		isPaidOff = true;
		return this.item.getPrice();
	}
	
	public String getClassName() {
		return "CASH";
	}
}
