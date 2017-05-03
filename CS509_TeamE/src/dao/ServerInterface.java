/**
 * 
 */
package dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import airplane.Airplane;
import airport.Airports;
import flight.Flights;
import utils.QueryFactory;


/**
 * This class provides an interface to the CS509 server. It provides sample methods to perform
 * HTTP GET and HTTP POSTS
 *   
 * @author blake
 * @version 1.1
 * @since 2016-02-24
 *
 */
/**
 * @author blinw
 *
 */
public class ServerInterface {
	private final String mUrlBase = "http://cs509.cs.wpi.edu:8181/CS509.server/ReservationSystem";

	
	
//	public Flights getFlights(name, startAirport, startDate){
//		
//	}
	/**
	 * Return a collection of all the airports from server
	 * 
	 * Retrieve the list of airports available to the specified ticketAgency via HTTPGet of the server
	 * 
	 * @param teamName identifies the name of the team requesting the collection of airports
	 * @return collection of Airports from server
	 */
	public Airports getAirports (String teamName) {

		URL url;
		HttpURLConnection connection;
		BufferedReader reader;
		String line;
		StringBuffer result = new StringBuffer();
		
		String xmlAirports;
		Airports airports;

		try {
			/**
			 * Create an HTTP connection to the server for a GET 
			 */
			url = new URL(mUrlBase + QueryFactory.getAirports(teamName));
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", teamName);

			/**
			 * If response code of SUCCESS read the XML string returned
			 * line by line to build the full return string
			 */
			int responseCode = connection.getResponseCode();
			if (responseCode >= HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				String encoding = connection.getContentEncoding();
				encoding = (encoding == null ? "UTF-8" : encoding);

				reader = new BufferedReader(new InputStreamReader(inputStream));
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		xmlAirports = result.toString();
		System.out.println("xmlAirports"+xmlAirports);
		airports = DaoAirport.addAll(xmlAirports);
		//daoflights
		return airports;
		
	}
	
	public Map<String,Airplane> getAirplanes (String teamName) {

		URL url;
		HttpURLConnection connection;
		BufferedReader reader;
		String line;
		StringBuffer result = new StringBuffer();
		
		String xmlAirplanes;
		Map<String,Airplane> airplanes;

		try {
			/**
			 * Create an HTTP connection to the server for a GET 
			 */
			url = new URL(mUrlBase + QueryFactory.getAirplanes(teamName));
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", teamName);

			/**
			 * If response code of SUCCESS read the XML string returned
			 * line by line to build the full return string
			 */
			int responseCode = connection.getResponseCode();
			if (responseCode >= HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				String encoding = connection.getContentEncoding();
				encoding = (encoding == null ? "UTF-8" : encoding);

				reader = new BufferedReader(new InputStreamReader(inputStream));
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		xmlAirplanes = result.toString();
		System.out.println("xmlAirplanes"+xmlAirplanes);
		airplanes = DaoAirplane.addAll(xmlAirplanes);
		//daoflights
		return airplanes;
		
	}
	
	public Flights getFlightsFor2Days(Map<String, Airplane> airplanes, String teamName, String airportCode, String Date, boolean isByDeparture) throws NullPointerException {
		//add 1 day and search tomorrow's flights
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		Date deDate=null;
		try {
			 deDate = sdf.parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(deDate);
		cal.add(Calendar.DATE, 1);
		Flights flights=this.getFlights( airplanes,teamName, airportCode, Date, isByDeparture);//first and second day
		flights.addAll(this.getFlights( airplanes,teamName, airportCode,sdf.format( cal.getTime()), isByDeparture));
	
		return flights;
		
	}
	
	public Flights getFlightsFor3Days(Map<String,Airplane> airplanes,String teamName, String airportCode, String Date, boolean isByDeparture) throws NullPointerException {
		//add 1 day and search tomorrow's flights
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		Date deDate=null;
		try {
			 deDate = sdf.parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(deDate);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
		
		Flights flights=this.getFlights(airplanes, teamName, airportCode, Date, isByDeparture);//first and second day
		flights.addAll(this.getFlights(airplanes,teamName, airportCode,sdf.format( cal.getTime()), isByDeparture));
		
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);
		flights.addAll(this.getFlights(airplanes,teamName, airportCode,sdf.format( cal.getTime()), isByDeparture));
		
		return flights;
		
	}
	
	/**
	 * get Flights, false: by arrival; true: by departure
	 * @throws ParseException 
	 * @throws NullPointerException 
	 */
	public Flights getFlights (Map<String,Airplane> airplanes,String teamName, String airportCode, String Date, boolean isByDeparture) throws NullPointerException {

		URL url;
		HttpURLConnection connection;
		BufferedReader reader;
		String line;
		StringBuffer result = new StringBuffer();
		
		String xmlFlights;
		Flights flights;

		try {
			/**
			 * Create an HTTP connection to the server for a GET 
			 */
			if(isByDeparture)url = new URL(mUrlBase + QueryFactory.getDepartingAirplanes(teamName,airportCode,Date));
			else url = new URL(mUrlBase + QueryFactory.getArrivingAirplanes(teamName,airportCode,Date));
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", teamName);

			/**
			 * If response code of SUCCESS read the XML string returned
			 * line by line to build the full return string
			 */
			int responseCode = connection.getResponseCode();
			if (responseCode >= HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				String encoding = connection.getContentEncoding();
				encoding = (encoding == null ? "UTF-8" : encoding);

				reader = new BufferedReader(new InputStreamReader(inputStream));
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		xmlFlights = result.toString();

		flights = DaoFlights.addAll(airplanes,xmlFlights);
		
		return flights;
		
	}
	
	
	/**
	 * Lock the database for updating by the specified team. The operation will fail if the lock is held by another team.
	 * 
	 * @param teamName is the name of team requesting server lock
	 * @return true if the server was locked successfully, else false
	 */
	public boolean lock (String teamName) {
		URL url;
		HttpURLConnection connection;

		try {
			url = new URL(mUrlBase);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", teamName);
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			String params = QueryFactory.lock(teamName);
			
			connection.setDoOutput(true);
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(params);
			writer.flush();
			writer.close();
			
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'POST' to lock database");
			System.out.println(("\nResponse Code : " + responseCode));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();
			
			while ((line = in.readLine()) != null) {
				response.append(line);
			}
			in.close();
			
			System.out.println(response.toString());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Unlock the database previous locked by specified team. The operation will succeed if the server lock is held by the specified
	 * team or if the server is not currently locked. If the lock is held be another team, the operation will fail.
	 * 
	 * The server interface to unlock the server interface uses HTTP POST protocol
	 * 
	 * @param teamName is the name of the team holding the lock
	 * @return true if the server was successfully unlocked.
	 */
	public boolean unlock (String teamName) {
		URL url;
		HttpURLConnection connection;
		
		try {
			url = new URL(mUrlBase);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			
			String params = QueryFactory.unlock(teamName);
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(params);
			writer.flush();
			writer.close();
		    
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'POST' to unlock database");
			System.out.println(("\nResponse Code : " + responseCode));

			if (responseCode >= HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				StringBuffer response = new StringBuffer();

				while ((line = in.readLine()) != null) {
					response.append(line);
				}
				in.close();

				System.out.println(response.toString());
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean buyTickets (String teamName, String xmlFlights) {
		URL url;
		HttpURLConnection connection;
		try{
			url = new URL(mUrlBase);
			connection = (HttpURLConnection) url.openConnection();
			
			// header
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", teamName);
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			// write bytes
			connection.setDoOutput(true);
			connection.setDoInput(true);
			String params = QueryFactory.reserveSeats(teamName, xmlFlights);
			System.out.println("\nSending " + params);
			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(params);
			writer.flush();
			writer.close();
			
			//get response code
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'POST' to reserve seats");
			System.out.println(("\nResponse Code : " + responseCode));
			
			if(responseCode >= 200 && responseCode <= 299){
				return true;
			}else{
				return false;
			}
				
		}
		catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
}
