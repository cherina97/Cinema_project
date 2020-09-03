import Exceptions.IllegalTimeFormatException;

public class Seance {

    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(Movie movie, Time startTime) throws IllegalTimeFormatException {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = Time.endTime(startTime, movie.getDuration());
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
