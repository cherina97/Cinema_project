import java.util.Arrays;
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
    public String toString() {
        return "Schedule{" +
                "seances=" + Arrays.toString(seances.toArray()) +
                '}';
    }
}
