package flight;

import java.util.Date;
import java.text.SimpleDateFormat;
import utils.Saps;
import java.util.TimeZone;

/**
 * This class holds values pertaining to a single Airport. Class member attributes
 * are the same as defined by the CS509 server API and store values after conversion from
 * XML received from the server to Java primitives. Attributes are accessed via getter and 
 * setter methods.
 * 
 * @author blake
 * @version 1.2
 * @since 2016-02-24
 * 
 * 
 *
 */


public class Flight {


	
	
	/**
	 * Airport attributes as defined by the CS509 server interface XML
	 */
	private String airplane;			// Airplane type as an attribute
	private String number;
	private String arrival;              // Three character code of the Arrival airport
	private String departure;              // Three character code of the Departure airport
	private Date arrivalTime;
	private Date departureTime;

	private Seating seating;
	private int flightTime;
	
	private String deTimeString;
	private String arTimeString;
	
	
	
	

	/**
	 * @param airplane
	 * @param number
	 * @param arrival
	 * @param departure
	 * @param departureTime
	 * @param arrivalTime
	 * @param arrivalTime2
	 * @param seats
	 */
	public Flight(String airplane, String number, String arrival, String departure, 
			Date arrivalTime, Date departureTime, Seating seats, int flightTime) {
		super();
		if (!isValidCode(departure)) 
			throw new IllegalArgumentException(departure);
		if (!isValidCode(arrival)) 
			throw new IllegalArgumentException(arrival);
		this.airplane = airplane;
		this.number = number;
		this.arrival = arrival;
		this.departure = departure;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seating = seats;
		this.flightTime = flightTime;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(departure)));
		String dTime = sdf.format(departureTime);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(arrival)));
		String aTime = sdf.format(arrivalTime);
		
		this.deTimeString = dTime;
		this.arTimeString = aTime;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(departure)));
//		String dTime = sdf.format(departureTime);
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(arrival)));
//		String aTime = sdf.format(arrivalTime);
		return "Flight [airplane=" + airplane + ", number=" + number + ", arrival=" + arrival + ", departure="
				+ departure + ", arrivalTime=" + arTimeString + ", departureTime=" + deTimeString + ", seating="
				+ seating.toString() + ", flightTime=" + flightTime + "]";
	}



	public Flight() {
		// TODO Auto-generated constructor stub
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
	 * @return the flightTime
	 */
	public int getFlightTime() {
		return flightTime;
	}
	
	public String getDeTimeString() {
		return deTimeString;
	}



	public void setDeTimeString(String deTimeString) {
		this.deTimeString = deTimeString;
	}



	public String getArTimeString() {
		return arTimeString;
	}



	public void setArTimeString(String arTimeString) {
		this.arTimeString = arTimeString;
	}



	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
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
	 * @return the departureTime
	 */
	public Date getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the seating
	 */
	public Seating getSeating() {
		return seating;
	}
	/**
	 * @param seating the seating to set
	 */
	public void setSeating(Seating seating) {
		this.seating = seating;
	}
	
	public boolean isValidCode (String code) {
		// If we don't have a 3 character code it can't be valid valid
		if ((code == null) || (code.length() != 3))
			return false;
		return true;
	}


}
