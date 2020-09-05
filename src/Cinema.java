import java.util.*;
import java.util.stream.Collectors;

public class Cinema {

    private Map<Days, Schedule> schedules = new TreeMap<>();
    private List<Movie> movies = new ArrayList<>();
    private Time timeOpen;
    private Time timeClose;

    public Cinema(Time timeOpen, Time timeClose) {
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
    }

    {
        for (Days day : Days.values()) {
            schedules.put(day, new Schedule());
        }
    }

    public void addMovie(Movie movie) {
        Optional<Movie> optionalMovie = movies.stream()
                .filter(movie1 -> movie1.getTitle().equalsIgnoreCase(movie.getTitle()))
                .findAny();
        if (optionalMovie.isPresent()){
            System.out.println("Such movie " + movie.toString() + " is already exists");
        } else {
            movies.add(movie);
            System.out.println(movie.toString() + " was successfully added to MovieLibrary");
        }
    }

    public void addSeance(Seance seance, String day) {
        schedules.get(Days.valueOf(day.toUpperCase())).
                addSeance(seance);
    }

    public void removeSeance(Seance seance, String day) {
        schedules.get(Days.valueOf(day.toUpperCase())).
                removeSeance(seance);
    }

    public void removeMovie(Movie movie) {
        movies.removeIf(movie1 ->
                movie1.getTitle().equalsIgnoreCase(movie.getTitle()));

        for (Map.Entry<Days, Schedule> next : schedules.entrySet()) {
            List<Seance> seances = next.getValue().getSeances()
                    .stream()
                    .filter(seance ->
                            seance.getMovie().getTitle().equalsIgnoreCase(movie.getTitle()))
                    .collect(Collectors.toList());

            for (Seance seance : seances) {
                next.getValue().removeSeance(seance);
            }
        }
        System.out.println(movie.toString() + " was successfully deleted from library and seances.");
    }

    public void showAllMovies(){
        movies.forEach(System.out::println);
    }

    public void showAllSeances(){
        schedules.forEach((Days, Schedule) -> System.out.println(Days + " " + Schedule.toString()));
    }

    public Map<Days, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Map<Days, Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Time getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Time timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Time getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Time timeClose) {
        this.timeClose = timeClose;
    }


}
