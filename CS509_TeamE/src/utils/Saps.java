/**
 * 
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author blake
 * 
 * System Adaptive Parameters (SAPS)
 * 
 * Constants and values for limits, bounds and configuration of system
 *
 */
public class Saps {
	/**
	 * Constant values used for latitude and longitude range validation
	 */
	public static final double MAX_LATITUDE = 90.0;
	public static final double MIN_LATITUDE = -90.0;
	public static final double MAX_LONGITUDE = 180.0;
	public static final double MIN_LONGITUDE = -180.0;
	
	

	
	public final static Map<String, String> timeZoneMap = new HashMap<String, String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{    
		put("ATL","-5:00");
		put("ANC","-9:00");
		put("AUS","-6:00");
		put("BWI","-5:00");
		put("BOS","-4:00");
		put("CLT","-5:00");
		put("MDW","-5:00");
		put("ORD","-5:00");
		put("CVG","-5:00");
		put("CLE","-5:00");
		put("CMH","-5:00");
		put("DFW","-6:00");
		put("DEN","-6:00");
		put("DTW","-5:00");
		put("FLL","-5:00");
		put("RSW","-5:00");
		put("BDL","-4:00");
		put("HNL","-10:00");
		put("IAH","-6:00");
		put("HOU","-6:00");
		put("IND","-5:00");
		put("MCI","-6:00");
		put("LAS","-7:00");
		put("LAX","-7:00");
		put("MEM","-5:00");
		put("MIA","-5:00");
		put("MSP","-6:00");
		put("BNA","-5:00");
		put("MSY","-6:00");
		put("JFK","-4:00");
		put("LGA","-4:00");
		put("EWR","-4:00");
		put("OAK","-8:00");
		put("ONT","-7:00");
		put("MCO","-5:00");
		put("PHL","-5:00");
		put("PHX","-7:00");
		put("PIT","-5:00");
		put("PDX","-8:00");
		put("RDU","-5:00");
		put("SMF","-8:00");
		put("SLC","-7:00");
		put("SAT","-6:00");
		put("SAN","-7:00");
		put("SFO","-8:00");
		put("SJC","-8:00");
		put("SNA","-7:00");
		put("SEA","-8:00");
		put("STL","-6:00");
		put("TPA","-5:00");
		put("IAD","-5:00");
		put("DCA","-5:00");	}}; 
}
