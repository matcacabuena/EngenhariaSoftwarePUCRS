import java.util.ArrayList;

public class Alugavel {
    private String nome;
    private int codigo;
    private double precoDiario;
    private int ano;
    private String placa;
    private ArrayList<Aluguel> cadastro;

    public Alugavel(String nome, int codigo, double precoDiario, int ano, String placa) {
        this.nome = nome;
        this.codigo = codigo;
        this.precoDiario = precoDiario;
        this.ano = ano;
        this.placa = placa;
    }

    public Alugavel() {
        cadastro = new ArrayList<Aluguel>();
    }
    
    public boolean adicionaAluguel(Aluguel aluguel) {
        return cadastro.add(aluguel);
    }

    public ArrayList<Aluguel> pesquisaAluguel(int codigo) {
        ArrayList<Aluguel> Aluguel;
        Aluguel = new ArrayList<Aluguel>();
        return Aluguel;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public double getPrecoDiario() {
        return precoDiario;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
