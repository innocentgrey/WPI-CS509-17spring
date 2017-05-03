/**
 * 
 */
package utils;

import flight.Flights;

/**
 * @author blake
 * @version 1.2
 *
 */
public class QueryFactory {
	
	/**
	 * Return a query string that can be passed to HTTP URL to request list of airports
	 * 
	 * @param teamName is the name of the team to specify the data copy on server
	 * @return the query String which can be appended to URL to form HTTP GET request
	 */
	public static String getAirports(String teamName) {
		return "?team=" + teamName + "&action=list&list_type=airports";
	}
	
	public static String getAirplanes(String teamName) {
		return "?team=" + teamName + "&action=list&list_type=airplanes";
	}
	
	public static String searchAirports(String teamName, String code) {
		return "?team=" + teamName + "&action=list&list_type=airports&code="+code;
	}
	
	public static String getDepartingAirplanes(String teamName, String airportCode,  String Date){
		return "?team=" + teamName + "&action=list&list_type=departing&airport=" + airportCode + "&day=" + Date;
	}
	
	
	public static String getArrivingAirplanes( String teamName, String airportCode, String Date){
		return "?team=" + teamName + "&action=list&list_type=arriving&airport=" + airportCode + "&day=" + Date;
	}
	
	
	public static String reserveSeats(String teamName, String xmlFlights){
		return "team=" + teamName + "&action=buyTickets&flightData=" +xmlFlights ;
	}
	
	/**
	 * Lock the server database so updates can be written
	 * 
	 * @param teamName is the name of the team to acquire the lock
	 * @return the String written to HTTP POST to lock server database 
	 */
	public static String lock (String teamName) {
		return "team=" + teamName + "&action=lockDB";
	}
	
	/**
	 * Unlock the server database after updates are written
	 * 
	 * @param teamName is the name of the team holding the lock
	 * @return the String written to the HTTP POST to unlock server database
	 */
	public static String unlock (String teamName) {
		return "team=" + teamName + "&action=unlockDB";
	}
	

}
