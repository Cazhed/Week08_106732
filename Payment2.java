package week08.zachary.id.ac.umn;

public abstract class Payment2 {
	protected boolean isPaidOff;
	protected Item item;
	
	public abstract int pay();
	
	public Payment2() {
		this.isPaidOff = false;
		this.item = null;
	}
	
	public boolean isPaidOff() {
		return isPaidOff;
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getItemName() {
		return item.getName();
	}
	
	public String getStatus() {
		if(isPaidOff) {
			return "FINISHED";
		}
		return "ON PROGRESS";
	}
	
	public int getRemainingAmount() {
		if(isPaidOff) {
			return 0;
		}
		return item.getPrice();
	}
}
