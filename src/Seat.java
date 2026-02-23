import java.util.Objects;

    public class Seat {

        private String row;
        private int number;
        private boolean vip;

        public Seat(String row, int number, boolean vip) {
            this.row = row;
            this.number = number;
            this.vip = vip;
        }

        // --- GETTERY ---

        public String getRow() {
            return row;
        }

        public int getNumber() {
            return number;
        }

        public boolean isVip() {
            return vip;
        }

        // --- METODY POMOCNICZE ---

        public String getSeatCode() {
            return row + number;
        }

        @Override
        public String toString() {
            return getSeatCode() + (vip ? " (VIP)" : "");
        }

        // --- KLUCZOWE DLA MAPY ---

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Seat)) return false;
            Seat seat = (Seat) o;
            return number == seat.number &&
                    Objects.equals(row, seat.row);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, number);
        }
    }
