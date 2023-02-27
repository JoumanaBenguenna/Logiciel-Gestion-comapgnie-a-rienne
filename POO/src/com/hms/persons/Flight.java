package com.hms.persons;


public class Flight {
	  private String flightNumber;
	  private String destination;
	  private String departure;
	  private String departureTime;
	  private String arrivalTime;
	  private int capacity;
	  private int numberOfSeatsLeft;
	  
	  public Flight(String flightNumber, String destination, String departure, String departureTime, String arrivalTime, int capacity) {
	    this.flightNumber = flightNumber;
	    this.destination = destination;
	    this.departure = departure;
	    this.departureTime = departureTime;
	    this.arrivalTime = arrivalTime;
	    this.capacity = capacity;
	    this.numberOfSeatsLeft = capacity;
	   
	  }

	  public String getFlightNumber() {
	    return flightNumber;
	  }

	  public String getDestination() {
	    return destination;
	  }

	  public String getDeparture() {
	    return departure;
	  }

	  public String getDepartureTime() {
	    return departureTime;
	  }

	  public String getArrivalTime() {
	    return arrivalTime;
	  }

	  public int getCapacity() {
	    return capacity;
	  }

	  public int getNumberOfSeatsLeft() {
	    return numberOfSeatsLeft;
	  }

	  public void bookASeat() {
	    if (numberOfSeatsLeft > 0) {
	      numberOfSeatsLeft--;
	      System.out.println("success");
	    } else {
	      System.out.println("No seats left on this flight");
	    }
	    }
	  public void unbookASeat() {
		  numberOfSeatsLeft++;
		  System.out.println("success");
	  }
	  // if the flight will be late 
	  public void setDepartureTime(String time) {
		  this.departureTime=time;
	  }
	  
	  public void setArrivalTime(String time) {
		  this.arrivalTime=time;
	  }
}
	

