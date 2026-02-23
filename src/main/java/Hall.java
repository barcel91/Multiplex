package main.java;


import java.util.ArrayList;
import java.util.List;


public class Hall {

    private int number;
    private List<Seat> seats;

    public Hall(int number, int rows, int seatsPerRow) {
        this.number = number;
        this.seats = new ArrayList<>();
        generateSeats(rows, seatsPerRow);
    }

    // --- GENEROWANIE MIEJSC ---

    private void generateSeats(int rows, int seatsPerRow) {
        for (int i = 0; i < rows; i++) {
            String rowLetter = String.valueOf((char) ('A' + i));

            for (int j = 1; j <= seatsPerRow; j++) {

                // przykładowo: pierwsze 2 rzędy VIP
                boolean vip = i < 2;

                seats.add(new Seat(rowLetter, j, vip));
            }
        }
    }

    // --- GETTERY ---

    public int getNumber() {
        return number;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // --- LOGIKA ---

    public Seat findSeat(String seatCode) {
        for (Seat seat : seats) {
            if (seat.getSeatCode().equalsIgnoreCase(seatCode)) {
                return seat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hall " + number;
    }
}