package com.hms.persons;


import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
	private static Scanner user;
	private String name;
	private ArrayList<Flight> flights;
	private ArrayList<Airport> airports;

  public Airline(String name) {
    this.name = name;
    this.flights = new ArrayList<>();
    this.airports = new ArrayList<>();
  }

   public void addFlight(Flight flight) {
    flights.add(flight);
    Airport airport1 = new Airport(flight.getDestination(),flights);
    Airport airport2 = new Airport(flight.getDeparture(),flights);
    addAirport( airport1);
    addAirport( airport2);
  }
  public void addAirport(Airport airport) {
	  if (!airports.contains(airport))
	  	airports.add(airport);
  }

  public ArrayList<Flight> getFlights() {
    return flights;
  }
  public ArrayList<Airport> getAirports(){
	  return airports;
  }
  public void cancelFlight(Flight flight) {
	   this.flights.remove(flight);
  }

  public String getName() {
    return name;
  }
  
  
  public void showFlitghts() {
	  for (Flight flight : this.getFlights()) {
		  System.out.println("_____________________________________");
	      System.out.println("Flight number: " + flight.getFlightNumber());
	      System.out.println("Destination: " + flight.getDestination());
	      System.out.println("Departure: " + flight.getDeparture());
	      System.out.println("Departure time: " + flight.getDepartureTime());
	      System.out.println("Arrival time: " + flight.getArrivalTime());
	      System.out.println("_____________________________________");
	  }
}
}

