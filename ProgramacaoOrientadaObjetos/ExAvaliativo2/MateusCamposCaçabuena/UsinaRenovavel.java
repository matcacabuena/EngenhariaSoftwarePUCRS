public class UsinaRenovavel extends Usina {
    private FonteEnergia energia;

    UsinaRenovavel(String nome, double producaoMWh, double custoMWh, FonteEnergia energia) {
        super(nome, producaoMWh, custoMWh);
        this.energia = energia;
    }

    public double calculaPrecoMWh() {
        double custoMWh = super.getCustoMWh();
        if(energia.getNome().equals("solar")) {
            custoMWh = custoMWh * 1.25;
            super.setCustoMWh(custoMWh);
        }

        else if(energia.getNome().equals("eolica")) {
            custoMWh = custoMWh * 1.15;
            super.setCustoMWh(custoMWh);
        }
        
        else if(energia.getNome().equals("hidrica")) {
            custoMWh = custoMWh * 1.05;
            super.setCustoMWh(custoMWh);
        }
        else { return -1; }
        return custoMWh;
    }

    public String geraResumo() {
        String resumo = "1;" + super.getNome() + ";" + super.getProducaoMWh() + ";" + super.getCustoMWh() + ";" + energia.getNome();
        return resumo;
    }

    public FonteEnergia getEnergia() {
        return energia;
    }
}