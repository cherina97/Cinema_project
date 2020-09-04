import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

    private Set<Seance> seances = new TreeSet<>();

    public void addSeance(Seance seance){
        seances.add(seance);
    }

    public void  removeSeance(Seance seance){
        seances.remove(seance);
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(seances, schedule.seances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seances);
    }

    @Override
    public String toString() {
        return Arrays.toString(seances.toArray());
    }
}
