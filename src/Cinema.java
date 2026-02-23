import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String name;
    private String address;
    private List<Hall> halls;
    private List<Screening> screenings;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    // --- GETTERY ---

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    // --- DODAWANIE ---

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    // --- REPERTUAR ---

    public void printProgramme() {
        System.out.println("Program dla kina: " + name);
        for (Screening screening : screenings) {
            System.out.println(screening);
        }
    }

    public void printProgrammeForNextWeek() {
        System.out.println("Program na następne 7 dni dla kina: " + name);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);

        for (Screening screening : screenings) {
            if (screening.getDate().isAfter(now) &&
                    screening.getDate().isBefore(nextWeek)) {

                System.out.println(screening);
            }
        }
    }

    // --- WYSZUKIWANIE FILMU ---

    public Movie findMovie(String title) {

        for (Screening screening : screenings) {
            if (screening.getMovie().getTitle()
                    .equalsIgnoreCase(title)) {

                return screening.getMovie();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return name + " | " + address;
    }
}