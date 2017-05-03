/**
 * 
 */
package dao;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

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



public class DaoAirplane {
	
	
	
	
	public static Map<String,Airplane> addAll (String xmlAirplanes) throws NullPointerException {
		Map<String,Airplane> map=new HashMap<String,Airplane>(); 
		
		// Load the XML string into a DOM tree for ease of processing
		// then iterate over all nodes adding each airplane to our collection
		Document docAirplanes = buildDomDoc (xmlAirplanes);
		NodeList nodesAirplanes = docAirplanes.getElementsByTagName("Airplane");
		
		for (int i = 0; i < nodesAirplanes.getLength(); i++) {
			Element elementAirplane = (Element) nodesAirplanes.item(i);
			Airplane airplane = buildAirplane (elementAirplane);
			
			if(map.put(airplane.getModel(),airplane)!=null)
				System.out.println("warning: duplicate plane model in daoplane:"+airplane.getModel());;
		}
		
		return map;
	}

	/**
	 * Creates an Airplane object from a DOM node
	 * 
	 * Processes a DOM Node that describes an Airplane and creates an Airplane object from the information
	 * @param nodeAirplane is a DOM Node describing an Airplane
	 * @return Airplane object created from the DOM Node representation of the Airplane
	 * 
	 * @pre nodeAirplane is of format specified by CS509 server API
	 */
	static private Airplane buildAirplane (Node nodeAirplane) {
		/**
		 * Instantiate an empty Airplane object
		 */
		Airplane airplane = new Airplane();

		String Manufacturer;
		String Model;
		int FirstClassSeats;
		int CoachSeats;
		
		// The airplane element has attributes of Name and 3 character airplane code
		Element elementAirplane = (Element) nodeAirplane;
		Manufacturer = elementAirplane.getAttributeNode("Manufacturer").getValue();
		Model = elementAirplane.getAttributeNode("Model").getValue();
		
		// The latitude and longitude are child elements
		Element elementLatLng;
		elementLatLng = (Element)elementAirplane.getElementsByTagName("FirstClassSeats").item(0);
		FirstClassSeats = Integer.parseInt(getCharacterDataFromElement(elementLatLng));
		
		elementLatLng = (Element)elementAirplane.getElementsByTagName("CoachSeats").item(0);
		CoachSeats = Integer.parseInt(getCharacterDataFromElement(elementLatLng));

		/**
		 * Update the Airplane object with values from XML node
		 */
		airplane.setManufacturer(Manufacturer);
		airplane.setModel(Model);
		airplane.setFirstClassSeats(FirstClassSeats);
		airplane.setCoachSeats(CoachSeats);
		
		return airplane;
	}

	/**
	 * Builds a DOM tree form an XML string
	 * 
	 * Parses the XML file and returns a DOM tree that can be processed
	 * 
	 * @param xmlString XML String containing set of objects
	 * @return DOM tree from parsed XML or null if exception is caught
	 */
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
	
	/**
	 * Retrieve character data from an element if it exists
	 * 
	 * @param e is the DOM Element to retrieve character data from
	 * @return the character data as String [possibly empty String]
	 */
	private static String getCharacterDataFromElement (Element e) {
		Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	        CharacterData cd = (CharacterData) child;
	        return cd.getData();
	      }
	      return "";
	}
}
