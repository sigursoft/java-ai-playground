package org.vaadin.marcus.langchain4j;

import org.vaadin.marcus.service.BookingDetails;
import org.vaadin.marcus.service.FlightService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class Lang4jTools {

    private final FlightService flightService;

    public Lang4jTools(FlightService flightService) {
        this.flightService = flightService;
    }

    @Tool
    public BookingDetails getBookingDetails(String bookingNumber, String firstName, String lastName) {
        return flightService.getBookingDetails(bookingNumber, firstName, lastName);
    }

    @Tool
    public void changeBooking(String bookingNumber, String firstName, String lastName, String date, String from, String to) {
        flightService.changeBooking(bookingNumber, firstName, lastName, date, from, to);
    }

    @Tool
    public void cancelBooking(String bookingNumber, String firstName, String lastName) {
        flightService.cancelBooking(bookingNumber, firstName, lastName);
    }
}
