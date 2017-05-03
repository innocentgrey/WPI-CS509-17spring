/**
 * 
 */
package driver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airplane.Airplane;
import airport.Airport;
import airport.Airports;
import dao.ServerInterface;
import flight.Flight;
import flight.Flights;
import net.sf.json.JSONArray;


public class Driver extends HttpServlet  {
	
	static DriverManager driverManager=new DriverManager();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String teamName = "TeamE";
//		if (args.length != 1) {
//			System.err.println("usage: CS509.sample teamName");
//			System.exit(-1);
//			return;
//		}
		
//			// Try to get a list of airports
//		ServerInterface resSys=new ServerInterface();
//		Airports airports = resSys.getAirports(teamName);
//		for (Airport airport : airports) {
////			System.out.println(airport.toString());
//			System.out.println("put(\""+airport.code()+"\","+(int)airport.longitude()/15+");");
//		}

		
//		JSONArray jsonArray=new DriverManager().search("Roundtrip", "Coach", "SFO", "2017_05_12", "ORD",  "Departure", "2017_05_14", "Arrival");
		
//		 Try to get a list of airplanes
	ServerInterface resSys=new ServerInterface();
	Map<String, Airplane> airplanes = resSys.getAirplanes(teamName);
	for (String model : airplanes.keySet()) {
//		System.out.println(airport.toString());
		System.out.println(airplanes.get(model).toString());
	}
//		
//
//		
//		System.out.println("departAirportCode:");	
//	    String departure = s.nextLine();
//		System.out.println("departTime (YYYY_MM_DD) e.g. 2017_05_10 :");
//		String time = s.nextLine();
//		System.out.println("arrivalAiportCode e.g. RDU :");
//		String arrival = s.nextLine();
////		driverManager.search("", "", "", "", "");
////		driverManager.search("", "", departure, arrival, time);
//		     
//		System.out.println("finished");
//		
//		List<Flights> flightlis=new ArrayList<Flights>();
//		
//		
//		flightlis.addAll(driverManager.searchFlightsWithoutStop(airplanes,departure, time, arrival, false ));

		
//		List<Flights> 
//		flightlis.addAll( driverManager.searchFlightsWithOneStop(airplanes,departure, time,arrival, false ));

		
//		List<Flights> 
//		flightlis.addAll(driverManager.searchFlightsWithTwoStop(airplanes,departure, time, arrival, false));

		//output
//		for(Flights flight  :flightlis){
//		System.out.println(flight.toString());
////		System.out.println(driverManager.flights2xml(flight, "coach"));
//	}
//		
//
//        JSONArray jsonArray = JSONArray.fromObject( flightlis );  
//        System.out.println( jsonArray );  
//        
		System.out.println("finished");
//		System.out.println("result size:"+flightlis.size());
		
		
//		//----test buy tickets--------
//		boolean isLocked = resSys.lock(teamName);
//		System.out.println("Server is locked: " + isLocked);
//		
//		String xmlFlights = "<Flights><Flight number=\"34316\" seating=\"Coach\"/></Flights>";
//		boolean isBought = resSys.buyTickets(teamName, xmlFlights);
//		System.out.println("IS Bought Tickets: " + isBought);
//		
//		//----end test buy tickets--------
		
	}
}
