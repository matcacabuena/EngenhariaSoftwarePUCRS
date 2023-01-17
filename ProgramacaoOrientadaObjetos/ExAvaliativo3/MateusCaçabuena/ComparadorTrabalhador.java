import java.util.Comparator;

public class ComparadorTrabalhador implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Trabalhador t1, t2;
        t1 = (Trabalhador) o1;
        t2 = (Trabalhador) o2;
        return t1.getNome().compareTo(t2.getNome());
    }
}