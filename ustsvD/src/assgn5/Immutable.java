package assgn5;

public class Immutable {
	public final class Bill {
		 
	    private final int amount;
	    private final DateTime dateTime;
	 
	    public Bill(int amount, DateTime dateTime) {
	        this.amount = amount;
	        this.dateTime = dateTime;
	    }
	 
	    public int getAmount() {
	        return amount;
	    }
	 
	    public DateTime getDateTime() {
	        return dateTime;
	    }
	}
}
