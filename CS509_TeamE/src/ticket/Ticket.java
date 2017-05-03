package ticket;

import java.util.Date;

public class Ticket {
	private String airplane;			// Airplane type as an attribute
	private String number;
	private String arrival;              // Three character code of the Arrival airport
	private String departure;              // Three character code of the Departure airport


	private String seatType;
	private String price;
	
	private int flightTime;
	
	private String deTimeString;
	private String arTimeString;
	

	
	/**
	 * @param airplane
	 * @param number
	 * @param arrival
	 * @param departure
	 * @param seatType
	 * @param price
	 * @param flightTime
	 * @param deTimeString
	 * @param arTimeString
	 */
	public Ticket(String airplane, String number, String arrival, String departure, String seatType, String price,
			int flightTime, String deTimeString, String arTimeString) {
		super();
		this.airplane = airplane;
		this.number = number;
		this.arrival = arrival;
		this.departure = departure;
		this.seatType = seatType;
		this.price = price;
		this.flightTime = flightTime;
		this.deTimeString = deTimeString;
		this.arTimeString = arTimeString;
	}
	/**
	 * @return the airplane
	 */
	public String getAirplane() {
		return airplane;
	}
	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the seatType
	 */
	public String getSeatType() {
		return seatType;
	}
	/**
	 * @param seatType the seatType to set
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the flightTime
	 */
	public int getFlightTime() {
		return flightTime;
	}
	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}
	/**
	 * @return the deTimeString
	 */
	public String getDeTimeString() {
		return deTimeString;
	}
	/**
	 * @param deTimeString the deTimeString to set
	 */
	public void setDeTimeString(String deTimeString) {
		this.deTimeString = deTimeString;
	}
	/**
	 * @return the arTimeString
	 */
	public String getArTimeString() {
		return arTimeString;
	}
	/**
	 * @param arTimeString the arTimeString to set
	 */
	public void setArTimeString(String arTimeString) {
		this.arTimeString = arTimeString;
	}
	
	
	
	
}


