import java.time.LocalDateTime;
import java.util.*;

public class Screening {

    private Movie movie;
    private Hall hall;
    private LocalDateTime date;
    private ScreeningType type;
    private Map<Seat, Ticket> tickets;

    public Screening(Movie movie, Hall hall, LocalDateTime date, ScreeningType type) {
        this.movie = movie;
        this.hall = hall;
        this.date = date;
        this.type = type;
        this.tickets = new HashMap<>();
    }

    // --- GETTERY ---

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ScreeningType getType() {
        return type;
    }

    // --- REZERWACJA ---

    public void reservePlaces(String... seatCodes) {

        for (String code : seatCodes) {

            Seat seat = hall.findSeat(code);

            if (seat == null) {
                System.out.println("Siedznie " + code + " nie istnieje.");
                continue;
            }

            if (tickets.containsKey(seat)) {
                System.out.println("Siedzenie " + code + " jest już zajęte.");
                continue;
            }

            Ticket ticket = new Ticket(seat, this, null);
            tickets.put(seat, ticket);

            System.out.println("siedzenie " + code + " zarezerwowane.");
        }
    }

    // --- REZERWACJA DLA KLIENTA ---

    public void reservePlaces(Customer customer, String... seatCodes) {

        for (String code : seatCodes) {

            Seat seat = hall.findSeat(code);

            if (seat == null) {
                System.out.println("Siedzenie " + code + " nie istnieje.");
                continue;
            }

            if (tickets.containsKey(seat)) {
                System.out.println("Siedzenie " + code + " jest już zajęte.");
                continue;
            }

            Ticket ticket = new Ticket(seat, this, customer);
            tickets.put(seat, ticket);

            customer.addTicket(ticket);

            System.out.println("Siedznie " + code + " zarezerwowane dla  " + customer.getName());
        }
    }

    // --- ZAKUP BILETU ---

    public void buyTicket(String seatCode) {

        Seat seat = hall.findSeat(seatCode);

        if (seat == null) {
            System.out.println("Siedzenie nie istnieje.");
            return;
        }

        Ticket ticket = tickets.get(seat);

        if (ticket == null) {
            System.out.println("Siedzenie musi zostać najpierw zarezerwowane.");
            return;
        }

        ticket.purchase();
        System.out.println("Zakupiono bilet dla siedzenia nr: " + seatCode);
    }

    // --- DOSTĘPNE MIEJSCA ---

    public List<Seat> getAvailableSeats() {

        List<Seat> available = new ArrayList<>();

        for (Seat seat : hall.getSeats()) {
            if (!tickets.containsKey(seat)) {
                available.add(seat);
            }
        }

        return available;
    }

    // --- INFO ---

//    public void printInfo() {
//        System.out.println("Film: " + movie.getTitle());
//        System.out.println("Data: " + date);
//        System.out.println("Sala: " + hall.getNumber());
//        System.out.println("Gatunek: " + type);
//    }

    @Override
    public String toString() {
        return movie.getTitle() + " | " + date + " | Sala " + hall.getNumber() + " | " + type;
    }
}