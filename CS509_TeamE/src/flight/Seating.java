package flight;



public class Seating {

	
	
	private String firstClassPrice;
	private String coachPrice;
	private int firstClassRemaining;
	private int coachRemaining;
	/**
	 * @param firstclassPrice
	 * @param coachPrice
	 * @param firstclassRemaining
	 * @param coachRemaining
	 */
	public Seating(String firstclassPrice, String coachPrice, int firstclassRemaining, int coachRemaining) {
		
		this.firstClassPrice = firstclassPrice;
		this.coachPrice = coachPrice;
		this.firstClassRemaining = firstclassRemaining;
		this.coachRemaining = coachRemaining;
	}
	
	public Seating(){
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Seating [firstclassPrice=" + firstClassPrice + ", coachPrice=" + coachPrice + ", firstclassRemaining="
				+ firstClassRemaining + ", coachRemaining=" + coachRemaining + "]";
	}





	public String getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(String firstclassPrice) {
		this.firstClassPrice = firstclassPrice;
	}
	public String getCoachPrice() {
		return coachPrice;
	}
	public void setCoachPrice(String coachPrice) {
		this.coachPrice = coachPrice;
	}
	public int getFirstClassRemaining() {
		return firstClassRemaining;
	}
	public void setFirstClassRemaining(int firstclassRemaining) {
		this.firstClassRemaining = firstclassRemaining;
	}
	public int getCoachRemaining() {
		return coachRemaining;
	}
	public void setCoachRemaining(int coachRemaining) {
		this.coachRemaining = coachRemaining;
	}

	
	
}
