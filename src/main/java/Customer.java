package main.java;

import java.util.ArrayList;
import java.util.List;

    public class Customer {

        private String name;
        private String email;
        private List<Ticket> tickets;

        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
            this.tickets = new ArrayList<>();
        }

        // --- GETTERY ---

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public List<Ticket> getTickets() {
            return tickets;
        }

        // --- LOGIKA BIZNESOWA ---

        public void addTicket(Ticket ticket) {
            tickets.add(ticket);
        }

        public void printTickets() {
            if (tickets.isEmpty()) {
                System.out.println("No tickets found.");
                return;
            }

            System.out.println("Tickets for " + name + ":");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }

        @Override
        public String toString() {
            return "Customer{name='" + name + "', email='" + email + "'}";
        }
    }
}
