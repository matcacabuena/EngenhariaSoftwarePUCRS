package com.trabalhofinal.transEspacial;

public class TransportePessoa extends Transporte {

    private int qtdPessoas; 

    public TransportePessoa(int tipo, int identificador, int numOrigem, int numDestino, EspacoPorto eOrigem, EspacoPorto eDestino, EstadoTransporte estado, Espaconave espaconave, int qtdPessoas) {
        super(tipo, identificador, numOrigem, numDestino, eOrigem, eDestino, estado, espaconave);
        this.qtdPessoas = qtdPessoas;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    //Teste

    //métodos para calcular custo
    public double fatorDistancia() {
        if (calculaDistancia() >= 0.5) {
            return 100;
        }
        else if (calculaDistancia() < 0.5) { 
            return 1000000; 
        }
        else { return -1; }
    }

    public double custoTransportado() {
        return qtdPessoas * 100;
    }

    @Override
    public double calculaDistancia() {
        double origemCoordX = getEPOrigem().getCoordX();
        double origemCoordY = getEPOrigem().getCoordY();
        double origemCoordZ = getEPOrigem().getCoordZ();
        double destinoCoordX = getEPDestino().getCoordX();
        double destinoCoordY = getEPDestino().getCoordY();
        double destinoCoordZ = getEPDestino().getCoordZ();
        double distancia = Math.sqrt(Math.pow((destinoCoordX - origemCoordX),2)
                                    + Math.pow((destinoCoordY - origemCoordY),2) 
                                    + Math.pow((destinoCoordZ - origemCoordZ),2));   
        return distancia;
    }

    @Override
    public double calculaCusto() {
        double custoDistancia = calculaDistancia() * fatorDistancia();
        double calculaCusto = custoDistancia * custoTransportado();
        return calculaCusto;
    }

    @Override
    public String toString() {
        if (getEspaconave() == null) {
            return "\n-----------------------------" +
                    "\nIdentificador: " + getIdentificador() +
                    "\nEstado: " + getEstado() +
                    "\nQuantidade de pessoas: " + getQtdPessoas() +
                    "\nCalculo da distancia: " + calculaDistancia() +
                    "\nCalculo do custo: " + calculaCusto() +
                    "\nEspaço-Porto origem: " + getEPOrigem().toString() +
                    "\nEspaço-Porto destino: " + getEPDestino().toString() +
                    "\nEspaconave designada: " + getEspaconave() +
                    "\n-----------------------------";
        }
        else {
            return "\n-----------------------------" +
            "\nIdentificador: " + getIdentificador() +
            "\nEstado: " + getEstado() +
            "\nQuantidade de pessoas: " + getQtdPessoas() + 
            "\nCalculo da distancia: " + calculaDistancia() +
            "\nCalculo do custo: " + calculaCusto() +
            "\nEspaço-Porto origem: " + getEPOrigem().toString() +
            "\nEspaço-Porto destino: " + getEPDestino().toString() +
            "\nEspaconave: " + getEspaconave().toString() +
            "\n-----------------------------";
        }
    }
    
    @Override
    public String geraResumo() {
        return getTipo() + ":" + getIdentificador() + ":" + getOrigem() + ":" + getDestino() + ":" + getQtdPessoas() + "\n";
    }
}
