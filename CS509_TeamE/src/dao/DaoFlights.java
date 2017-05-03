package dao;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import airplane.Airplane;
import flight.Flight;
import flight.Flights;
import flight.Seating;
import utils.Saps;



public class DaoFlights {
	
	public final static Map<String, String> monthMap = new HashMap<String, String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{    
		put("Jan","01");
		put("Feb","02");
		put("Mar","03");
		put("Apr","04");
		put("May","05");
		put("Jun","06");
		put("Jul","07");
		put("Aug","08");
		put("Sep","09");
		put("Oct","10");
		put("Nov","11");
		put("Dec","12");	}};  
	
	public static Flights addAll (Map<String,Airplane> airplanes,String xmlFlights) throws NullPointerException {
		Flights flights = new Flights();
		
		// Load the XML string into a DOM tree for ease of processing
		// then iterate over all nodes adding each flight to our collection
		Document docFlights = buildDomDoc (xmlFlights);
		NodeList nodesFlights = docFlights.getElementsByTagName("Flight");
//		System.out.println("len"+nodesFlights.getLength());
		for (int i = 0; i < nodesFlights.getLength(); i++) {
			Element elementFlight = (Element) nodesFlights.item(i);
			Flight flight = buildFlight(airplanes,elementFlight);
			
			flights.add(flight);
//			if (flight.isValid()) {
//				flights.add(flight);
//			}
		}
		
		return flights;
	}
		
	static private Flight buildFlight(Map<String,Airplane> airplanes,Node nodeFlight) {
			/**
			 * Instantiate an empty Flight object
			 */
//			Flight flight = new Flight();

			String Airplane;
			int FlightTime;
			String Number;
			
			String departureCode;
			String departureTime;
			
			String arrivalCode;
			String arrivalTime;

				 
			
			// The flight element has attributes of Name and 3 character flight code
			Element elementFlight = (Element) nodeFlight;
			Airplane = elementFlight.getAttributeNode("Airplane").getValue();
			FlightTime = Integer.parseInt(elementFlight.getAttributeNode("FlightTime").getValue());
			Number = elementFlight.getAttributeNode("Number").getValue();
			
			// The Departure, Arrival and Seating are child elements
			Element Departure ;
			Departure = (Element)elementFlight.getElementsByTagName("Departure").item(0);
			
			Element deCode = (Element)Departure.getElementsByTagName("Code").item(0);
			departureCode = getCharacterDataFromElement(deCode);
			Element deTime = (Element)Departure.getElementsByTagName("Time").item(0);
			departureTime = getCharacterDataFromElement(deTime);
			
			String[] dTime=departureTime.split(" ");
//			Time tDeTime=new Time(dTime[0],dTime[1],dTime[2],dTime[3],dTime[4]);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm");
			//sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(departureCode)));
			sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
			// DataBase return time as GMT so in this data we need GMT instead of offset. 
			Date deDate = null;
			try {
				deDate = sdf.parse(dTime[0]+" "+monthMap.get(dTime[1])+" "+dTime[2]+" "+dTime[3]+":"+dTime[4]);
//				deDate = sdf.parse(departureTime);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//elementLatLng = (Element)elementFlight.getElementsByTagName("Longitude").item(0);
			//longitude = Double.parseDouble(getCharacterDataFromElement(elementLatLng));
			
			Element Arrival;
			Arrival = (Element)elementFlight.getElementsByTagName("Arrival").item(0);
			Element arCode = (Element)Arrival.getElementsByTagName("Code").item(0);
			arrivalCode = getCharacterDataFromElement(arCode);
			Element arTime = (Element)Arrival.getElementsByTagName("Time").item(0);
			arrivalTime = getCharacterDataFromElement(arTime);
			String[] aTime=arrivalTime.split(" ");
//			Time tArTime=new Time(aTime[0],aTime[1],aTime[2],aTime[3],aTime[4]);
			
			//sdf.setTimeZone(TimeZone.getTimeZone("GMT"+Saps.timeZoneMap.get(arrivalCode)));
			sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
			// DataBase return GMT so we only need GMT here instead of offset
			
			Date ArDate = null;
			try {
				ArDate = sdf.parse(aTime[0]+" "+monthMap.get(aTime[1])+" "+aTime[2]+" "+aTime[3]+" "+aTime[4]);
//				System.out.println(ArDate+"  ;  TZ:"+sdf.getTimeZone());
				
//				ArDate = sdf.parse(arrivingTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int firstTotal = airplanes.get(Airplane).getFirstClassSeats();
			int coachTotal = airplanes.get(Airplane).getCoachSeats();
			
			Element flightSeating;
			flightSeating = (Element)elementFlight.getElementsByTagName("Seating").item(0);
			Element coachSeating = (Element)flightSeating.getElementsByTagName("Coach").item(0);
			String coachPrice = coachSeating.getAttributeNode("Price").getValue();
			int coachRemaining = coachTotal - Integer.parseInt(getCharacterDataFromElement(coachSeating));
				
			Element firstclassSeating = (Element)flightSeating.getElementsByTagName("FirstClass").item(0);
			String firstclassPrice = firstclassSeating.getAttributeNode("Price").getValue();
			int firstRemaining = firstTotal - Integer.parseInt(getCharacterDataFromElement(firstclassSeating));
			
			 
			
			Seating seats=new Seating(firstclassPrice, coachPrice, firstRemaining, coachRemaining);
			
			/**
			 * Update the Flight object with values from XML node
			 */
			
//			
			return new Flight( Airplane,  Number,  arrivalCode, departureCode,ArDate ,  deDate,
					  seats,FlightTime );
		}
		

	
	
	static private Document buildDomDoc (String xmlString) {
		/**
		 * load the xml string into a DOM document and return the Document
		 */
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xmlString));
			
			return docBuilder.parse(inputSource);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getCharacterDataFromElement (Element e) {
		Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	        CharacterData cd = (CharacterData) child;
	        return cd.getData();
	      }
	      return "";
	}
}

