package ticket;

import java.util.ArrayList;
import java.util.List;

import flight.Flight;
import flight.Flights;

public class Tickets  {
	private List<Ticket> ticketList;
	private Double totalPrice;
	private String totalFlightTime;
	private int totalFlightMinute;
	private String SeatType;
	private String deTimeString;
	private String arTimeString;
	private String flightNumbers="";
	private String seatTypes="";
	

	
	
	
	/**
	 * @param ticketList
	 * @param totalPrice
	 * @param totalFlightTime
	 * @param totalFlightMinute
	 * @param seatType
	 * @param deTimeString
	 * @param arTimeString
	 * @param flightNumbers
	 * @param seatTypes
	 */
	public Tickets(List<Ticket> ticketList, Double totalPrice, String totalFlightTime, int totalFlightMinute,
			String seatType, String deTimeString, String arTimeString, String flightNumbers, String seatTypes) {
		super();
		this.ticketList = ticketList;
		this.totalPrice = totalPrice;
		this.totalFlightTime = totalFlightTime;
		this.totalFlightMinute = totalFlightMinute;
		SeatType = seatType;
		this.deTimeString = deTimeString;
		this.arTimeString = arTimeString;
		this.flightNumbers = flightNumbers;
		this.seatTypes = seatTypes;
	}

	
	public Tickets(List<Ticket> ticketList, String totalFlightTime , int totalFlightMinute) {
	
		this.ticketList = ticketList;
		this.totalPrice=0.0;
//		long diff = (ticketList.get(ticketList.size()-1).getArrivalTime().getTime() - ticketList.get(0).getDepartureTime().getTime()) / 60000;
		
//		this.totalPrice = totalPrice;
//		this.totalFlightTime = totalFlightTime;
		for(Ticket t:ticketList){
			this.totalPrice+=Double.parseDouble(t.getPrice());
			this.flightNumbers+=t.getNumber()+",";
			this.seatTypes+=t.getSeatType()+",";
		}
		
		SeatType = "";
		this.totalFlightTime=totalFlightTime;
		this.totalFlightMinute=totalFlightMinute;
		this.setDeTimeString(ticketList.get(0).getDeTimeString());
		this.setArTimeString(ticketList.get(ticketList.size()-1).getArTimeString());
	}
	
	/**
	 * @param t
	 * @param totalPrice
	 * @param totalFlightTime
	 * @param seatType
	 */
	public Tickets(Flights flist, String seatType) {
		Double price=0.0;
		List<Ticket> t=new ArrayList<Ticket>();
		if(seatType.equals("Coach")){
			for(Flight f:flist){
				String tprice=f.getSeating().getCoachPrice().replace(",", "");
				price+=Double.valueOf(tprice.substring(1, tprice.length()));
				t.add(new Ticket(f.getAirplane(), f.getNumber(), f.getArrival(), f.getDeparture(), "Coach", tprice, f.getFlightTime(), f.getDeTimeString(), f.getArTimeString()));
				this.seatTypes+=seatType+",";
				this.flightNumbers+=f.getNumber()+",";
			}
			
		}
		else if(seatType.equals("FirstClass")){
			for(Flight f:flist){
				String tprice=f.getSeating().getFirstClassPrice().replace(",", "");
				price+=Double.valueOf(tprice.substring(1, tprice.length()));
				t.add(new Ticket(f.getAirplane(), f.getNumber(), f.getArrival(), f.getDeparture(), "FirstClass", tprice, f.getFlightTime(), f.getDeTimeString(), f.getArTimeString()));				
				this.seatTypes+=seatType+",";
				this.flightNumbers+=f.getNumber()+",";
			}
		}
		else{
			
		}
		long diff = (flist.get(flist.size()-1).getArrivalTime().getTime() - flist.get(0).getDepartureTime().getTime()) / 60000;
		
		this.SeatType=seatType;
		this.ticketList=t;
		this.totalPrice = price;
		this.totalFlightMinute=(int) diff;
		this.totalFlightTime = (diff/60)+"h " +(diff%60)+"m";
		this.setDeTimeString(flist.get(0).getDeTimeString());
		this.setArTimeString(flist.get(flist.size()-1).getArTimeString());
	}
	
	


	
	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the totalFlightTime
	 */
	public String getTotalFlightTime() {
		return totalFlightTime;
	}
	/**
	 * @param totalFlightTime the totalFlightTime to set
	 */
	public void setTotalFlightTime(String totalFlightTime) {
		this.totalFlightTime = totalFlightTime;
	}
	/**
	 * @return the seatType
	 */
	public String getSeatType() {
		return SeatType;
	}
	/**
	 * @param seatType the seatType to set
	 */
	public void setSeatType(String seatType) {
		SeatType = seatType;
	}

	/**
	 * @return the ticketList
	 */
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	/**
	 * @param ticketList the ticketList to set
	 */
	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
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

	/**
	 * @return the totalFlightMinute
	 */
	public int getTotalFlightMinute() {
		return totalFlightMinute;
	}

	/**
	 * @param totalFlightMinute the totalFlightMinute to set
	 */
	public void setTotalFlightMinute(int totalFlightMinute) {
		this.totalFlightMinute = totalFlightMinute;
	}


	/**
	 * @return the flightNumbers
	 */
	public String getFlightNumbers() {
		return flightNumbers;
	}


	/**
	 * @param flightNumbers the flightNumbers to set
	 */
	public void setFlightNumbers(String flightNumbers) {
		this.flightNumbers = flightNumbers;
	}


	/**
	 * @return the seatTypes
	 */
	public String getSeatTypes() {
		return seatTypes;
	}


	/**
	 * @param seatTypes the seatTypes to set
	 */
	public void setSeatTypes(String seatTypes) {
		this.seatTypes = seatTypes;
	}
	
	
	
	
}
