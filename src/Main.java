import Exceptions.IllegalTimeFormatException;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Cinema cinema;

    public static void main(String[] args) throws IllegalTimeFormatException {
        enterWorkingTime();
        showMenu();
        System.out.println("Enter a number:");
        int choice = scanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    addSeance();
                    break;
                case 3:
                    removeSeance();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:
                    showAllMovies();
                    break;
                case 6:
                    showAllSeances();
                    break;
                case 7:
                    showWorkingTime();
                    break;
            }
            showMenu();
            System.out.println("Enter a number:");
            choice = scanner.nextInt();
        }
    }

    public static void addMovie() throws IllegalTimeFormatException {
        Movie movie = inputMovie();
        cinema.addMovie(movie);
    }

    public static void addSeance() throws IllegalTimeFormatException {
        System.out.println("\tSelect day for this seance: ");
        String day = scanner.next();
        Seance seance = inputSeance();

        if (checkIfClose(seance)) {
            System.out.println("In this period cinema is closed. Choose another time. ");
        } else if (checkIfTimeIsFree(seance, day)) {
            System.out.println("This time is busy. Choose another time.");
        } else {
            cinema.addSeance(seance, day);
        }
    }

    public static boolean checkIfClose(Seance seance) {
        boolean flag = false;
        int hourStart = seance.getStartTime().getHour();
        int hourEnd = seance.getEndTime().getHour();
        int hourOpen = cinema.getTimeOpen().getHour();
        int hourClose = cinema.getTimeClose().getHour();

        if ((hourStart < hourOpen) || (hourEnd > hourClose)) {
            flag = true;
        }
        return flag;
    }

    public static boolean checkIfTimeIsFree(Seance seance, String day) {
        Schedule schedule = cinema.getSchedules().get(Days.valueOf(day.toUpperCase(Locale.ENGLISH)));
        Set<Seance> seancesPerDay = schedule.getSeances();
        boolean flag = false;

        int hourStart = seance.getStartTime().getHour();
        int hourEnd = seance.getEndTime().getHour();

        for (Seance oneSeance : seancesPerDay) {
            int hourStartExist = oneSeance.getStartTime().getHour();
            int hourEndExist = oneSeance.getEndTime().getHour();

            if ((hourStart < hourStartExist && hourEnd < hourStartExist) ||
                    (hourStart > hourEndExist && hourEnd > hourEndExist)) {
                flag = false;
            }

            if ((hourStart <= hourEndExist && hourStart >= hourStartExist) ||
                    (hourEnd <= hourEndExist && hourEnd >= hourStartExist)) {
                flag = true;
            }
        }
        return flag;
    }

    public static void removeSeance() throws IllegalTimeFormatException {
        System.out.println("\tSelect day for this seance: ");
        String day = scanner.next();
        Seance seance = inputSeance();
        cinema.removeSeance(seance, day);
    }

    public static void removeMovie() throws IllegalTimeFormatException {
        Movie movie = inputMovie();
        cinema.removeMovie(movie);
    }

    public static Seance inputSeance() throws IllegalTimeFormatException {
        System.out.println("\tWhich movie would you like to add/remove to seance?");
        showAllMovies();
        System.out.println("\tSelect:");
        Movie movie = inputMovie();
        System.out.println("\tEnter start time for/of this seance: ");
        Time time = inputTime();

        return new Seance(movie, time);
    }

    public static Movie inputMovie() throws IllegalTimeFormatException {
        System.out.println("\tEnter a title of movie:");
        String title = scanner.next();
        System.out.println("\tEnter movie duration:");
        Time duration = inputTime();

        return new Movie(title, duration);
    }

    public static void showAllMovies() {
        cinema.showAllMovies();
    }

    public static void showAllSeances() {
        cinema.showAllSeances();
    }

    public static void showWorkingTime() {
        System.out.println("Working time: ");
        Time timeOpen = cinema.getTimeOpen();
        Time timeClose = cinema.getTimeClose();
        System.out.println(timeOpen.getHour() + ":" + timeOpen.getMin() + " - "
                + timeClose.getHour() + ":" + timeClose.getMin());
    }

    public static void enterWorkingTime() throws IllegalTimeFormatException {
//        System.out.println("\tEnter the opening time for Cinema");
//        Time timeOpen = inputTime();
//        System.out.println("\tEnter the closing time for Cinema");
//        Time timeClose = inputTime();
//        cinema = new Cinema(timeOpen, timeClose);
//        System.out.println("Working time: " + timeOpen + " - " + timeClose);
        cinema = new Cinema(new Time(0, 9), new Time(30, 22));
    }


    private static Time inputTime() throws IllegalTimeFormatException {
        System.out.println("\tEnter hours:");
        int hour = scanner.nextInt();

        System.out.println("\tEnter minutes:");
        int min = scanner.nextInt();

        return new Time(min, hour);
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("\t 1.Add movie to MovieLibrary");
        System.out.println("\t 2.Add seance to schedule");
        System.out.println("\t 3.Remove seance from schedule");
        System.out.println("\t 4.Remove movie from schedule and seances");
        System.out.println("\t 5.Show all movies");
        System.out.println("\t 6.Show all seances");
        System.out.println("\t 7.Cinema working time");
        System.out.println("0.Exit");
    }
}
