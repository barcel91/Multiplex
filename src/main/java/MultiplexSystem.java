package main.java;

import java.util.ArrayList;
import java.util.List;

public class MultiplexSystem {

    private List<Cinema> cinemas;

    public MultiplexSystem() {
        this.cinemas = new ArrayList<>();
    }

    // --- DODAWANIE KINA ---

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    // --- GETTERY ---

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    // --- WYSZUKIWANIE KINA ---

    public Cinema findCinema(String name) {

        for (Cinema cinema : cinemas) {
            if (cinema.getName().equalsIgnoreCase(name)) {
                return cinema;
            }
        }

        return null;
    }

    // --- WYŚWIETLANIE ---

    public void printCinemas() {
        System.out.println("Cinemas in system:");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema);
        }
    }
}
