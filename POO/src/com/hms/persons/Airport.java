package com.hms.persons;
import java.util.ArrayList;

public class Airport  {
	
	private String city;
	private ArrayList<Flight> ArrivingFlights ;
	private ArrayList<Flight> DepartingFlights ;
	
	public Airport(String city, ArrayList<Flight> flights) {
		
		this.city=city;
		this.ArrivingFlights = new ArrayList<Flight>();
		this.DepartingFlights = new ArrayList<Flight>();
		for (Flight flight : flights) {
			if (city.equals(flight.getDeparture())) {
				this.DepartingFlights.add(flight);
				
			}
			else if (city.equals(flight.getDestination())) {
				this.ArrivingFlights.add(flight);
				
				}
		}
	}
	
	
	
	 public String getCity() {
		 return city;
	 }
	 public ArrayList<Flight> getArrivingFlights() {
		    return ArrivingFlights;
		  }
	 public ArrayList<Flight> DepartingFlights() {
		    return DepartingFlights;
		  }
	 
	 
	 public void cancelFlight(Flight flight) {
		   
		    this.DepartingFlights.remove(flight);
		    this.ArrivingFlights.remove(flight);}
	 public void showDepartingFlights() {
		 for (Flight flight : this.DepartingFlights) {
			 System.out.println("------------------------------------>");
		      System.out.println("Flight number: " + flight.getFlightNumber());
		      System.out.println("Airport: " + flight.getDeparture());
		      System.out.println("Departure time: " + flight.getDepartureTime());
		      System.out.println("Arrival time: " + flight.getArrivalTime());
		      System.out.println("------------------------------------>");
		 }
	 }
	 
	 public void showArrivingFlightss() {
		 for (Flight flight : this.ArrivingFlights) {
			 System.out.println("<------------------------------------");
		      System.out.println("Flight number: " + flight.getFlightNumber());
		      System.out.println("Airport: " + flight.getDestination());
		      System.out.println("Departure time: " + flight.getDepartureTime());
		      System.out.println("Arrival time: " + flight.getArrivalTime());
		      System.out.println("<------------------------------------");
		 }
	 }
}
