import java.util.*;
import java.util.stream.Collectors;

public class Cinema {

    private Map<Days, Schedule> schedules = new TreeMap<>();
    private List<Movie> movies = new ArrayList<>();
    private Time timeOpen;
    private Time timeClose;

    {
        for (Days day : Days.values()) {
            schedules.put(day, new Schedule());
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
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
        for (Map.Entry<Days, Schedule> next : schedules.entrySet()) {
            List<Seance> seances = next.getValue().getSeances().
                    stream().
                    filter(seance -> seance.getMovie().equals(movie)).
                    collect(Collectors.toList());

            for (Seance seance : seances) {
                next.getValue().removeSeance(seance);
            }
        }

        movies.remove(movie);
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
