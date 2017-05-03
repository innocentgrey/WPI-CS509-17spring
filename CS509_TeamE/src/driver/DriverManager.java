package driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import airplane.Airplane;
import dao.ServerInterface;
import flight.Flight;
import flight.Flights;
import net.sf.json.JSONArray;

import ticket.Ticket;
import ticket.TicketController;
import ticket.Tickets;
import ticket.Ticketsort;
import utils.Saps;

public class DriverManager {

	public List<Flights> searchFlightsWithoutStop(Map<String, Airplane> airplanes, String departure, String time, String arrival,
			boolean isByDeparture) {
		List<Flights> flist = new ArrayList<Flights>();
		arrival = arrival.equals("") ? "RDU" : arrival;
		time = time.equals("") ? "2017_05_10" : time;
		departure = departure.equals("") ? "BOS" : departure;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT" + Saps.timeZoneMap.get(isByDeparture ? departure : arrival)));
		Date d0 = null, d1 = null;
		try {
			d0 = sdf.parse(time + " 00:00:00");
			d1 = sdf.parse(time + " 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServerInterface resSys = new ServerInterface();
		// Flights flights = resSys.getFlighs("TeamE","BOS","2017_05_10",true);
		Flights flights = new Flights();
		flights = resSys.getFlightsFor2Days(airplanes,"TeamE", isByDeparture ? departure : arrival, time, isByDeparture);
		if (isByDeparture) {

			flights = flights.filterByArrival(arrival, flights);
		} else {

			flights = flights.filterByDeparture(departure, flights);
		}
		// System.out.println(flights.size() + "drivermanager");

		for (Flight f : flights) {

			if (isByDeparture && (f.getDepartureTime().before(d0) || f.getDepartureTime().after(d1))) {
				continue;
			}
			if ((!isByDeparture) && (f.getArrivalTime().before(d0) || f.getArrivalTime().after(d1))) {
				continue;
			}
			Flights tmp = new Flights();
			tmp.add(f);
			flist.add(tmp);
		}
		System.out.println("0 stops res size:" + flist.size());
		return flist;

	}

	/*
	 * for the time being, it can only search flight within one day
	 */
	public List<Flights> searchFlightsWithOneStop(Map<String,Airplane> airplanes,String departure, String time, String arrival,
			boolean isByDeparture) {
		ServerInterface resSys = new ServerInterface();
		List<Flights> res = new ArrayList<Flights>();
		arrival = arrival.equals("") ? "RDU" : arrival;
		time = time.equals("") ? "2017_05_10" : time;
		departure = departure.equals("") ? "BOS" : departure;

		// if(isByDeparture){
		Flights flights1 = resSys.getFlightsFor3Days( airplanes,"TeamE", departure, time, true);// true
																						// means
																						// search
																						// by
																						// departure

		Flights flights2 = resSys.getFlightsFor2Days(airplanes,"TeamE", arrival, time, false);
		// flights2.sortByArrivalAirport();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT" + Saps.timeZoneMap.get(isByDeparture ? departure : arrival)));

		Date d0 = null, d1 = null;
		try {
			d0 = sdf.parse(time + " 00:00:00");
			d1 = sdf.parse(time + " 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Flight f1 : flights1) {
			if (isByDeparture && f1.getDepartureTime().before(d0) | f1.getDepartureTime().after(d1)) {
				continue;
			}

			for (Flight f2 : flights2) {
				// System.out.println(f2.getDeparture());
				if ((!isByDeparture) && (f2.getArrivalTime().before(d0) || f2.getArrivalTime().after(d1))) {
					continue;
				}
				if (f1.getArrival().equals(f2.getDeparture()) & f1.getArrivalTime().before(f2.getDepartureTime())) {
					long diff = f2.getDepartureTime().getTime() - f1.getArrivalTime().getTime();
					long minutes = diff / (1000 * 60);
					if (minutes > 240 | minutes < 30) {
						continue;
					}
					Flights flight = new Flights();
					flight.add(f1);
					flight.add(f2);
					res.add(flight);
				}
			}
		}
		System.out.println("one stop res size:" + res.size());
		// Flights flights2 =

		return res;

	}

	public List<Flights> searchFlightsWithTwoStop(Map<String,Airplane> airplanes,String departure, String time, String arrival,
			boolean isByDeparture) {
		ServerInterface resSys = new ServerInterface();
		List<Flights> res = new ArrayList<Flights>();
		HashMap<String, Flights> map = new HashMap<String, Flights>();
		arrival = arrival.equals("") ? "RDU" : arrival;
		time = time.equals("") ? "2017_05_10" : time;
		departure = departure.equals("") ? "BOS" : departure;

		// Flights flights1 =
		// resSys.getFlightsFor2Days("TeamE","PHL","2017_05_10",true);
		Flights flights1 = resSys.getFlightsFor3Days( airplanes,"TeamE", departure, time, true);// true
																						// means
																						// search
																						// by
																						// departure
		// flights1.sortByArrivalAirport();

		// Flights flights3 =
		// resSys.getFlightsFor2Days("TeamE","RDU","2017_05_10",false);
		Flights flights3 = resSys.getFlightsFor2Days( airplanes,"TeamE", arrival, time, false);
		flights3.sortByArrivalAirport();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT" + Saps.timeZoneMap.get(isByDeparture ? departure : arrival)));

		Date d0 = null, d1 = null;
		try {
			d0 = sdf.parse(time + " 00:00:00");
			d1 = sdf.parse(time + " 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Flight f1 : flights1) {
			if (isByDeparture && f1.getDepartureTime().before(d0) | f1.getDepartureTime().after(d1)) {
				continue;
			}

			if (!map.containsKey(f1.getArrival())) {
				map.put(f1.getArrival(), resSys.getFlightsFor2Days( airplanes,"TeamE", f1.getArrival(), time, true));
			}
			// System.out.println(map.get(f1.getArrival()).size()+"len");
			for (Flight f2 : map.get(f1.getArrival())) {
				if (f2.getDepartureTime().after(f1.getArrivalTime())) { // f2.departTime>f1.arrivalTime
					long diff12 = (f2.getDepartureTime().getTime() - f1.getArrivalTime().getTime()) / 60000; // 60000ms==1
																												// min
					if (diff12 > 240 | diff12 < 30) {
						continue;
					}

					for (Flight f3 : flights3) {
						if ((!isByDeparture) && (f3.getArrivalTime().before(d0) || f3.getArrivalTime().after(d1))) {
							continue;
						}
						if (f3.getDeparture().equals(f2.getArrival())
								& f3.getDepartureTime().after(f2.getDepartureTime())) {
							long diff23 = (f3.getDepartureTime().getTime() - f2.getArrivalTime().getTime()) / 60000; // 60000ms==1
																														// min

							if (diff23 > 240 | diff23 < 30) {
								continue;
							}
							Flights flight = new Flights();
							flight.add(f1);
							flight.add(f2);
							flight.add(f3);
							res.add(flight);

						}
					}
				}
			}

		}

		System.out.println("two stops res size:" + res.size());
		// Flights flights2 =

		return res;

	}
	
	public int buyTicket(String seatTypes, String flightNums) {
		ServerInterface resSys = new ServerInterface();
		String xmlFlights = flights2xml(flightNums, seatTypes);
		if(flightNums.length()==0)return 2;//2 nothing
		boolean isLocked;
		int buySuccess;
		
		do{
			isLocked = resSys.lock("TeamE"); // is locked DB
		}while(!isLocked); // if DB is locked by teamName, then go to reserve tickets.
		
		buySuccess = resSys.buyTickets("TeamE", xmlFlights)?1:0;//2 nothing; 1 success; 0 fail
		System.out.print(buySuccess);
		resSys.unlock("TeamE");
		return buySuccess;
		
	}
	
	
	public boolean buyTicket(Flights flist, String seatType, String teamName) {
		ServerInterface resSys = new ServerInterface();
		String xmlFlights = flights2xml(flist, seatType);
		boolean isLocked;
		boolean buySuccess;
		
		do{
			isLocked = resSys.lock(teamName); // is locked DB
		}while(!isLocked); // if DB is locked by teamName, then go to reserve tickets.
		
		buySuccess = resSys.buyTickets(teamName, xmlFlights);
		resSys.unlock(teamName);
		return buySuccess;
		
	}
	
	public boolean buyTicket(Tickets tlist, String teamName) {
		ServerInterface resSys = new ServerInterface();
		String xmlFlights = tickets2xml(tlist);
		boolean isLocked;
		boolean buySuccess;
		
		do{
			isLocked = resSys.lock(teamName); // is locked DB
		}while(!isLocked);
		
		buySuccess = resSys.buyTickets(teamName, xmlFlights);
		resSys.unlock(teamName);
		return buySuccess;
		
	}
	
	public String ArrayList2xml(ArrayList<String> flightNumber, ArrayList<String> seatingType){
		String xmlFlights = "<Flights>";
		int numFlights = flightNumber.size();
		if(flightNumber.size() == seatingType.size()){
			for(int i = 0; i < numFlights; i++){
				xmlFlights +="<Flight number=" + "\"" + flightNumber.get(i) + "\"" + " seating=" + "\"" + seatingType.get(i) + "\"" + "/>";
			}
		}else{
			return xmlFlights + "</Flights>";
		}
		return xmlFlights + "</Flights>";
	}
	
	public String str2xml(String flightNumber, String seatingType){
		String xmlFlights = "<Flights>";
		String[] fNumber = flightNumber.split(",");
		String[] sType = seatingType.split(",");
		int numFlights = fNumber.length;
		if(fNumber.length == sType.length){
			for(int i = 0; i < numFlights; i++){
				xmlFlights +="<Flight number=" + "\"" + fNumber[i] + "\"" + " seating=" + "\"" + sType[i] + "\"" + "/>";
			}
		}else{
			return xmlFlights + "</Flights>";
		}
		return xmlFlights + "</Flights>";
	}
	
	public boolean buyTicket(String xmlFlights){
		ServerInterface resSys = new ServerInterface();
		boolean isLocked;
		boolean buySuccess;
		do{
			isLocked = resSys.lock("TeamE");
		}while(!isLocked);
		buySuccess = resSys.buyTickets("TeamE", xmlFlights);
		resSys.unlock("TeamE");
		return buySuccess;
	}
	
	/**
	 * <Flights> <Flight number=DDDDD seating=SEAT_TYPE/> <Flight number=DDDDD
	 * seating=SEAT_TYPE/> </Flights>
	 * 
	 * @param flist
	 * @param seatType
	 * @return
	 */
	public String flights2xml(Flights flist, String seatType) {
		String res = "<Flights>";
		for (Flight f : flist) {
			res += "<Flight number=" + "\"" +f.getNumber()+"\"" + " seating=" + "\""+seatType+"\"" + "/>";
		}
		return res + "</Flights>";

	}
	
	public String flights2xml(String flightNums, String seatTypes) {
		String[] fs=flightNums.split(",");
		String[] ss=seatTypes.split(",");
		
		String res = "<Flights>";
		for (int i=0;i<fs.length;i++) {
			res += "<Flight number=" + "\"" +fs[i]+"\"" + " seating=" + "\""+ss[i]+"\"" + "/>";
		}
		return res + "</Flights>";

	}
	
	public String tickets2xml(Tickets tlist) {
		String res = "<Flights>";
		for (Ticket t : tlist.getTicketList()) {
			res += "<Flight number=" + "\"" +t.getNumber()+"\"" + " seating=" + "\""+t.getSeatType()+"\"" + "/>";
		}
		return res + "</Flights>";

	}

	public JSONArray search(String tripType, String seatType1, String seatType2, String departure, String date, String arrival,
			String timeType, String returndate,String returntimeType) {
		List<Flights> flightlist = new ArrayList<Flights>();
		List<Tickets> outboundlist = new ArrayList<Tickets>();
		List<List<Tickets>> result = new ArrayList<List<Tickets>>();
		JSONArray jsonArray = null;
		DriverManager driverManager = new DriverManager();
		Ticketsort sorter=new Ticketsort();
		
		boolean isByDeparture = timeType.equals("Departure") ? true : false;
		boolean isByDeparture2 = returntimeType.equals("Departure") ? true : false;
		arrival = arrival.equals("") | arrival.equals(null) | arrival.equals("null") | arrival == null ? "RDU"
				: arrival;
		date = date.equals("") | date.equals(null) | date.equals("null") | date == null ? "2017_05_10" : date;
		returndate = returndate.equals("") | returndate.equals(null) | returndate.equals("null") | returndate == null
				? "2017_05_11" : returndate;
		departure = departure.equals("") | departure.equals(null) | departure.equals("null") | departure == null ? "BOS"
				: departure;
		seatType1 = seatType1.equals("") | seatType1.equals(null) | seatType1.equals("null") | seatType1 == null ? "Coach"
				: seatType1;
		seatType2 = seatType2.equals("") | seatType2.equals(null) | seatType2.equals("null") | seatType2 == null ? "Coach"
				: seatType2;
		
		//create airplane map
		Map<String, Airplane> airplanes = new ServerInterface().getAirplanes("TeamE");
		
		//generate outbound trips
		flightlist.addAll(driverManager.searchFlightsWithoutStop(airplanes,departure, date, arrival, isByDeparture));

		flightlist.addAll(driverManager.searchFlightsWithOneStop(airplanes,departure, date, arrival, isByDeparture));

		flightlist.addAll(driverManager.searchFlightsWithTwoStop(airplanes,departure, date, arrival, isByDeparture));
		
		
		
		//or generate one-way tickets
		if(!seatType1.equals("Alternative")){
			for (Flights f : flightlist) {
				if (TicketController.validateFlights(f, seatType1)) {
					outboundlist.add(new Tickets(f, seatType1));
				}
			}
			System.out.println("outboundlist len:"+outboundlist.size());
		}
		else{
			for (Flights f : flightlist) {
				outboundlist.addAll(TicketController.noTicket(f));
			}
		}
//		sorter.sortbyDepartureTime(outboundlist);
			
		result.add(outboundlist);

		
		//generate return trips
		if(tripType.equals("RoundTrip")|tripType.equals("Roundtrip")|tripType.equals("Round_Trip")|tripType.equals("roundtrip")){
			List<Flights> returnflightlist = new ArrayList<Flights>();
			List<Tickets> returnlist=new ArrayList<Tickets>();
			
			returnflightlist.addAll(driverManager.searchFlightsWithoutStop(airplanes,arrival, returndate, departure, isByDeparture2));

			returnflightlist.addAll(driverManager.searchFlightsWithOneStop(airplanes,arrival, returndate, departure, isByDeparture2));

			returnflightlist.addAll(driverManager.searchFlightsWithTwoStop(airplanes,arrival, returndate, departure, isByDeparture2));
			
		//return should be later than outbound
		if(!seatType2.equals("Alternative")){
			for (Flights f2 : returnflightlist) {
				if (!TicketController.validateFlights(f2, seatType2)){
					continue;
				}
				returnlist.add(new Tickets(f2, seatType2));
			}
		}
		else{
			for (Flights f2 : returnflightlist) {
				returnlist.addAll(TicketController.noTicket(f2));
			}
		}
			
			
		result.add(returnlist);
		System.out.println("rlist len:"+returnlist.size());
		}
	
		
		jsonArray=JSONArray.fromObject(result);
		 System.out.println("json: "+jsonArray);
		return jsonArray;

	}

}
