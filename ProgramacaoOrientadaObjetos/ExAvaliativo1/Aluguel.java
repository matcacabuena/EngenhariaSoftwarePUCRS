public class Aluguel {
    private String nome;
    private String data;
    private String cpf;
    private int periodo;
    private double valorFinal;
    private Alugavel alugavel;

    public Aluguel(String nome, String data, String cpf, int periodo, Alugavel alugavel) {
        this.nome = nome;
        this.data = data;
        this.cpf = cpf;
        this.periodo = periodo;
        this.alugavel = alugavel;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getCpf() {
        return cpf;
    }

    public int getPeriodo() {
        return periodo;
    }

    public Alugavel getAlugavel() {
        return alugavel;
    }

    public double getValorFinal() {
        return valorFinal;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPeriodo (int periodo) {
        this.periodo = periodo;
    }

    public void setAlugavel(Alugavel alugavel) {
        this.alugavel = alugavel;
    }

    public double calculaValorFinal() {
        double precoDiario = alugavel.getPrecoDiario();
        if(periodo <= 7) {
            valorFinal = periodo * precoDiario;
        } else { valorFinal = (periodo * precoDiario) * 0.9; }
        return valorFinal;
    }
}