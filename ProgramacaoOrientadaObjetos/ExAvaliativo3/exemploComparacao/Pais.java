package genericos.comparacoes;

public class Pais implements Comparable {
    private String nome;
    private double area;    // Em Km2

    public Pais(String nome, double area) {
        this.nome = nome;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public double getArea() {
        return area;
    }

    /**
     * Compara este pais com outro
     * @param o Outro pais
     * @return -1 se area menor, 0 se area igual, +1 se area maior
     */
    @Override
    public int compareTo(Object o) {
        Pais outro;
        outro = (Pais) o;
        if (this.area < outro.getArea())
            return -1;
        else if(this.area < outro.getArea())
            return +1;
        return 0;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Nome: " + nome + ", " +
                "Area: " + area;
        return result;
    }

}
