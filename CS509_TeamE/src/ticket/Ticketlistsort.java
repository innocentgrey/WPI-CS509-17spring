package ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import flight.Flight;
import flight.Flights;


public class Ticketlistsort extends ArrayList<Tickets>{
	private List<Tickets> ticketsList;
	public  Ticketlistsort(){
	}
	
	
	public void sortByDepartureAirport(Tickets ticket){
//List<Ticket> ticket1 = new ArrayList<Ticket>();

	Comparator<Tickets> comparator = new Comparator<Tickets>(){
			 public int compare(Tickets o1, Tickets o2) {
		 return o1.getTotalPrice().compareTo(o2.getTotalPrice());
			 }
	 };
    Collections.sort(ticketsList, comparator);
	}
	
	
	public void sortbyTotalPrice(Tickets ticket){
		 Comparator<Tickets> comparator = new Comparator<Tickets>(){
			     public int compare(Tickets o1, Tickets o2) {
		 double str1 = o1.getTotalPrice();
		 double str2 = o2.getTotalPrice();
//		 if(str1 == str2)
//		 {
//		 return 0;
//		 } 
//		 else if(str1 < str2)
//		 {
//		 return -1;
//		 }
//		 else
//		 {
//		 return 1;
//		 }			    
         return str1 < str2? -1 : str1 == str2? 0 : 1;	
	     }
		 }; 
		 Collections.sort(this, comparator);
	}

	public void sortbyTotalFlightTime(Tickets ticket){
		 Comparator<Tickets> comparator = new Comparator<Tickets>(){
			     public int compare(Tickets o1, Tickets o2) {
		 int int1 = o1.getTotalFlightMinute();
		 int int2 = o2.getTotalFlightMinute();
		 return int1 < int2? -1 : int1 == int2? 0 : 1;	
			     }
				 }; 
				 Collections.sort(this, comparator);
			}	     
	
	
	public void sortbyDepartureTime(Tickets ticket){
		 Comparator<Tickets> comparator = new Comparator<Tickets>(){
			     public int compare(Tickets o1, Tickets o2) {
		 String str1 = o1.getDeTimeString().substring(5, 6);
		 String str2 = o2.getDeTimeString().substring(5, 6);
         int int1 = Integer.parseInt(str1);
         int int2 = Integer.parseInt(str2);
         if (int1 == int2)
         {
        	 str1 = o1.getDeTimeString().substring(8, 9);
    		 str2 = o2.getDeTimeString().substring(8, 9);
             int1 = Integer.parseInt(str1);
             int2 = Integer.parseInt(str2);
             if (int1 == int2)
             {
            	 str1 = o1.getDeTimeString().substring(11, 12);
        		 str2 = o2.getDeTimeString().substring(11, 12);
            	 String str3 = o1.getDeTimeString().substring(14, 16);
        		 String str4 = o2.getDeTimeString().substring(14, 16);
                 int1 = Integer.parseInt(str1);
                 int2 = Integer.parseInt(str2);
                 int int3 = Integer.parseInt(str3);
                 int int4 = Integer.parseInt(str4);
                 int int5 = int1*60 + int3;
                 int int6 = int2*60 + int4;
        		 return int1 < int2? 1 : int1 == int2? 0 : -1;	
             }
             else if (int1 > int2)
             {
            	 return -1;
             }
             else
             {
            	 return 1;
             }            
         }        
         else if (int1 > int2)
         {
        	return -1;
         }        
         else
         {
        	 return 1;
         }
		 
			     }
				 }; 
				 Collections.sort(this, comparator);
			}	     

	public void sortbyArrivalTime(Tickets ticket){
		 Comparator<Tickets> comparator = new Comparator<Tickets>(){
			     public int compare(Tickets o1, Tickets o2) {
		 String str1 = o1.getArTimeString().substring(5, 6);
		 String str2 = o2.getArTimeString().substring(5, 6);
        int int1 = Integer.parseInt(str1);
        int int2 = Integer.parseInt(str2);
        if (int1 == int2)
        {
       	 str1 = o1.getArTimeString().substring(8, 9);
   		 str2 = o2.getArTimeString().substring(8, 9);
            int1 = Integer.parseInt(str1);
            int2 = Integer.parseInt(str2);
            if (int1 == int2)
            {
           	 str1 = o1.getArTimeString().substring(11, 12);
       		 str2 = o2.getArTimeString().substring(11, 12);
           	 String str3 = o1.getArTimeString().substring(14, 16);
       		 String str4 = o2.getArTimeString().substring(14, 16);
                int1 = Integer.parseInt(str1);
                int2 = Integer.parseInt(str2);
                int int3 = Integer.parseInt(str3);
                int int4 = Integer.parseInt(str4);
                int int5 = int1*60 + int3;
                int int6 = int2*60 + int4;
       		 return int1 < int2? 1 : int1 == int2? 0 : -1;	
            }
            else if (int1 > int2)
            {
           	 return -1;
            }
            else
            {
           	 return 1;
            }           
        }        
        else if (int1 > int2)
        {
       	return -1;
        }
        
        else
        {
       	 return 1;
        }
		 
			     }
				 }; 
				 Collections.sort(this, comparator);
			}	
	
	

}
