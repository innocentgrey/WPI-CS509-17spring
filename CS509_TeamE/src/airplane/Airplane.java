package airplane;

public class Airplane {
	String Manufacturer;
	String Model;
	int FirstClassSeats;
	int CoachSeats;
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Airplane [Manufacturer=" + Manufacturer + ", Model=" + Model + ", FirstClassSeats=" + FirstClassSeats
				+ ", CoachSeats=" + CoachSeats + "]";
	}
	/**
	 * @param manufacturer
	 * @param model
	 * @param firstClassSeats
	 * @param coachSeats
	 */
	public Airplane(String manufacturer, String model, int firstClassSeats, int coachSeats) {
		super();
		Manufacturer = manufacturer;
		Model = model;
		FirstClassSeats = firstClassSeats;
		CoachSeats = coachSeats;
	}
	public Airplane() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return Manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return Model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		Model = model;
	}
	/**
	 * @return the firstClassSeats
	 */
	public int getFirstClassSeats() {
		return FirstClassSeats;
	}
	/**
	 * @param firstClassSeats the firstClassSeats to set
	 */
	public void setFirstClassSeats(int firstClassSeats) {
		FirstClassSeats = firstClassSeats;
	}
	/**
	 * @return the coachSeats
	 */
	public int getCoachSeats() {
		return CoachSeats;
	}
	/**
	 * @param coachSeats the coachSeats to set
	 */
	public void setCoachSeats(int coachSeats) {
		CoachSeats = coachSeats;
	}
	
	
	
}
