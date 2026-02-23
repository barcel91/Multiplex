import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // --- SYSTEM ---
        MultiplexSystem system = new MultiplexSystem();

        Cinema cinema1 = new Cinema("Kino pierwsze", "ul. Wolności 5");
        Cinema cinema2 = new Cinema("Kino drugie", "ul. Jana III Sobieskiego 10");

        system.addCinema(cinema1);
        system.addCinema(cinema2);

        // --- SALE ---
        Hall hall1 = new Hall(1, 10, 20);
        Hall hall2 = new Hall(2, 8, 15);

        cinema1.addHall(hall1);
        cinema1.addHall(hall2);

        // --- FILMY ---
        Movie movie1 = new Movie("Hobbit", 120);
        Movie movie2 = new Movie("Harry Potter", 169);

        // --- SEANSE ---
        Screening screening1 = new Screening(
                movie1,
                hall1,
                LocalDateTime.now().plusDays(1),
                ScreeningType.NORMAL
        );

        Screening screening2 = new Screening(
                movie2,
                hall2,
                LocalDateTime.now().plusDays(2),
                ScreeningType.VIP
        );

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);

        // --- WYŚWIETLENIE REPERTUARU ---
        cinema1.printProgramme();
        System.out.println();

        cinema1.printProgrammeForNextWeek();
        System.out.println();

        // --- REZERWACJA BEZ KONTA ---
        screening1.reservePlaces("A1", "A2");
        System.out.println();

        // --- KLIENT ---
        Customer customer = new Customer("Łukasz Kowalski", "luko@email.com");

        // --- REZERWACJA DLA KLIENTA ---
        screening1.reservePlaces(customer, "B5", "B6");
        System.out.println();

        // --- ZAKUP BILETU ---
        screening1.buyTicket("B5");
        System.out.println();

        // --- SPRAWDZENIE BILETÓW KLIENTA ---
        customer.printTickets();
        System.out.println();

        // --- DOSTĘPNE MIEJSCA ---
        System.out.println("Dostępne siedzenia:");
        for (Seat seat : screening1.getAvailableSeats()) {
            System.out.print(seat + " ");
        }

    }

}