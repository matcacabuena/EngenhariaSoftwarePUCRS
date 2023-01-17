public class UsinaNaoRenovavel extends Usina {
    private Combustivel combustivel;

    UsinaNaoRenovavel(String nome, double producaoMWh, double custoMWh, Combustivel combustivel) {
        super(nome, producaoMWh, custoMWh);
        this.combustivel = combustivel;
    }

    public double calculaPrecoMWh() {
        double custoMWh = super.getCustoMWh();
        if(combustivel.getNome().equals("petroleo")){
            custoMWh = custoMWh * 1.3;
            super.setCustoMWh(custoMWh);
        }

        else if(combustivel.getNome().equals("carvao")){
            custoMWh = custoMWh * 1.2;
            super.setCustoMWh(custoMWh);
        }
            
        else if(combustivel.getNome().equals("nuclear")){
            custoMWh = custoMWh * 1.1;
            super.setCustoMWh(custoMWh);
        }
        else { return -1; }
        return custoMWh;
    }

    public String geraResumo() {
        String resumo = "2;" + super.getNome() + ";" + super.getProducaoMWh() + ";" + super.getCustoMWh() + ";" + combustivel.getNome();
        return resumo;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }
}