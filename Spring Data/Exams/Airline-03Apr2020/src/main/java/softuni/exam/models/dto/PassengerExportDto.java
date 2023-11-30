package softuni.exam.models.dto;

import softuni.exam.models.entities.Ticket;

import java.util.HashSet;
import java.util.Set;

public class PassengerExportDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Set<TicketExportDto> tickets = new HashSet<>();

    public Set<TicketExportDto> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketExportDto> tickets) {
        this.tickets = tickets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public String toString() {
        String format = "Passenger %s  %s\n" +
                "\tEmail - %s\n" +
                "Phone - %s\n" +
                "\tNumber of tickets - %d";
        return String.format(format, getFirstName(), getLastName(),getEmail(),getPhoneNumber(), getTickets().size());
    }
}
