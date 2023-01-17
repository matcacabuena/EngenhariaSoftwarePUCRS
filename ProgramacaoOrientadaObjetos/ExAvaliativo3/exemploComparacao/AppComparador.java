package genericos.comparacoes;

import java.util.ArrayList;
import java.util.Collections;

public class AppComparador {

    public static void main(String[] args) {
        ArrayList<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais("Brasil"   ,8515767));
        paises.add(new Pais("Argentina",2780400));
        paises.add(new Pais("Chile"    , 756950));
        System.out.println("Paises conforme ordem de insercao: ");
        imprime(paises);
        Collections.sort(paises,new PaisComparadorNome());
        System.out.println("Paises conforme ordem de nome: ");
        imprime(paises);
        Collections.sort(paises,new PaisComparadorArea());
        System.out.println("Paises conforme ordem de area: ");
        imprime(paises);
    }

    public static void imprime(ArrayList<Pais> paises) {
        for(Pais p : paises) {
            System.out.println("Pais: " + p);
        }
    }

}
