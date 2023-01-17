package genericos.comparacoes;

import java.util.Comparator;

public class PaisComparadorNome implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Pais p1, p2;
        p1 = (Pais) o1;
        p2 = (Pais) o2;
        return p1.getNome().compareTo(p2.getNome());
    }
}
