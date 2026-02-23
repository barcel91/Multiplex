package main.java;

    public class Movie {

        private String title;
        private int duration; // w minutach

        public Movie(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }

        // --- GETTERY ---

        public String getTitle() {
            return title;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return title + " (" + duration + " min)";
        }
    }
