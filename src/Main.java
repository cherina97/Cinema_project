import Exceptions.IllegalTimeFormatException;

import java.util.Scanner;

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
                case 5:
                    showAllMovies();
                    break;
                case 6:
                    showAllSeances();
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
        System.out.println("\tWhich movie would you like to add to seance?");
        showAllMovies();
        System.out.println("\tSelect:");
        Movie movie = inputMovie();
        System.out.println("\tEnter start time for this seance: ");
        Time time = inputTime();
        Seance seance = new Seance(movie, time);
        cinema.addSeance(seance, day);
    }

    public static Movie inputMovie() throws IllegalTimeFormatException {
        System.out.println("\tEnter a title of movie:");
        String title = scanner.next();
        System.out.println("\tEnter movie duration:");
        Time duration = inputTime();

        return new Movie(title, duration);
    }

    public static void showAllMovies(){
        cinema.showAllMovies();
    }

    public static void showAllSeances(){
        cinema.showAllSeances();
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
        System.out.println("0.Exit");
    }
}
