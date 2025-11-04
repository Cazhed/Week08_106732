package week08.zachary.id.ac.umn;

public class CreditCardPayment extends Payment {
	private String cardNumber;
	
	public CreditCardPayment(double amount, String cardNumber) {
		super(amount);
		this.cardNumber = cardNumber;
	}
	
	void processPayment() {
		System.out.println("Processing credit card payment of $" + amount + " for card number " + cardNumber);
	}
}
