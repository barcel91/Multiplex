public class Ticket {

        private Seat seat;
        private Screening screening;
        private Customer customer; // może być null (zakup bez konta)
        private boolean reserved;
        private boolean purchased;

        public Ticket(Seat seat, Screening screening, Customer customer) {
            this.seat = seat;
            this.screening = screening;
            this.customer = customer;
            this.reserved = true;
            this.purchased = false;
        }

        // --- GETTERY ---

        public Seat getSeat() {
            return seat;
        }

        public Screening getScreening() {
            return screening;
        }

        public Customer getCustomer() {
            return customer;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean isPurchased() {
            return purchased;
        }

        // --- LOGIKA BIZNESOWA ---

        public void purchase() {
            if (!reserved) {
                System.out.println("Bilet musi być najpierw zarezerwowany.");
                return;
            }

            this.purchased = true;
            this.reserved = false;
        }

        @Override
        public String toString() {
            return "Bilet{" +
                    "film=" + screening.getMovie().getTitle() +
                    ", data=" + screening.getDate() +
                    ", siedzenie=" + seat +
                    ", zakupiono=" + purchased +
                    '}';
        }
    }