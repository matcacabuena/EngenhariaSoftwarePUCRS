public abstract class Usina {
    private String nome;
    private double producaoMWh;
    private double custoMWh;

    Usina(String nome, double producaoMWh, double custoMWh) {
        this.nome = nome;
        this.producaoMWh = producaoMWh;
        this.custoMWh = custoMWh;
    }
    
    public abstract double calculaPrecoMWh();

    public abstract String geraResumo();

    public String getNome() {
        return nome;
    }

    public double getProducaoMWh() {
        return producaoMWh;
    }
    
    public double getCustoMWh() {
        return custoMWh;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProducaoMWh(double producaoMWh) {
        this.producaoMWh = producaoMWh;
    }

    public void setCustoMWh(double custoMWh) {
        this.custoMWh = custoMWh;
    }
}