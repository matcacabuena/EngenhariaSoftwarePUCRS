package genericos.comparacoes;

import java.util.Comparator;

public class PaisComparadorArea implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Pais p1, p2;
        p1 = (Pais) o1;
        p2 = (Pais) o2;
        if (p1.getArea() < p2.getArea())
            return -1;
        else if (p1.getArea() > p2.getArea())
            return +1;
        return 0;
    }
}
