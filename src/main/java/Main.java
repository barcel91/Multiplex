package main.java;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // --- SYSTEM ---
        MultiplexSystem system = new MultiplexSystem();

        Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");
        Cinema cinema2 = new Cinema("Galaxy Cinema", "ul. Marszałkowska 10");

        system.addCinema(cinema1);
        system.addCinema(cinema2);

        // --- SALE ---
        Hall hall1 = new Hall(1, 10, 20);
        Hall hall2 = new Hall(2, 8, 15);

        cinema1.addHall(hall1);
        cinema1.addHall(hall2);

        // --- FILMY ---
        Movie movie1 = new Movie("James Bond", 120);
        Movie movie2 = new Movie("Interstellar", 169);

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
        Customer customer = new Customer("Jan Kowalski", "jan@email.com");

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
        System.out.println("Available seats:");
        for (Seat seat : screening1.getAvailableSeats()) {
            System.out.print(seat + " ");
        }
    }
}