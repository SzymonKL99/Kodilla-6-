package com.kodilla.exception.test;


import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public Boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airPorts = new HashMap<>();
        airPorts.put("Warszawa", true);
        airPorts.put("Wrocław", true);
        airPorts.put("Lublin", false);
        airPorts.put("Kraków", false);


        Boolean arrivalAirportExists = airPorts.get(flight.getArrivalAirport());


        if (arrivalAirportExists == null) {
            throw new RouteNotFoundException("Route not found");
        }

        return arrivalAirportExists;
    }

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warszawa", "Wrocław");

        try {
            flightSearch.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Route not found");
        }
    }
}

