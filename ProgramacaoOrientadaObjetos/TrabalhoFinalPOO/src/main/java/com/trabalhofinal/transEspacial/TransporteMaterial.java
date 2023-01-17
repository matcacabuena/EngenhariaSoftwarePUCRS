package com.trabalhofinal.transEspacial;

import java.util.ArrayList;

public class TransporteMaterial extends Transporte {

    private String descricao;

    private double carga;

    public TransporteMaterial(int tipo, int identificador, int numOrigem, int numDestino, EspacoPorto eOrigem, EspacoPorto eDestino, EstadoTransporte estado, Espaconave espaconave, double carga, String descricao) {
        super(tipo, identificador, numOrigem, numDestino, eOrigem, eDestino, estado, espaconave);
        this.carga = carga;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getCarga() {
        return carga;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
    
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
        return carga * 500;
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
                    "\nDescricao: " + getDescricao() +
                    "\nCarga em toneladas: " + getCarga() + 
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
            "\nDescricao: " + getDescricao() +
            "\nCarga em toneladas: " + getCarga() + 
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
        return getTipo() + ":" + getIdentificador() + ":" + getOrigem() + ":" + getDestino() + ":" + getCarga() + ":" + getDescricao() + "\n";
    }
    
}