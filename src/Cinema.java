import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cinema {

    private Map<Days, Schedule> schedules = new TreeMap<>();
    private List<Movie> movies = new ArrayList<>();
    private Time timeOpen;
    private Time timeClose;

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
