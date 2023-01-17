package com.trabalhofinal.transEspacial;

public class FTL extends Espaconave{
    
    private double velMaxWarp;
    
    private double qtdMax;
    
    public FTL (int tipo, String nome, int espacoPorto, double velMaxWarp, double qtdMax, Transporte transporte) {
        super(tipo, nome, espacoPorto, transporte);
        this.velMaxWarp = velMaxWarp;
        this.qtdMax = qtdMax;
    }

    public double getVelMaxWarp() {
        return velMaxWarp;
    }
    
    public double getQtdMax() {
        return qtdMax;
    }

    public void setVelMaxWarp(double velMaxWarp) {
        this.velMaxWarp = velMaxWarp;
    }

    public void setQtdMax(double qtdMax) {
        this.qtdMax = qtdMax;
    }
    
    @Override
    public String toString() {
        return "\n-----------------------------" +
                "\nEspaconave: " + getNome() +
                "\nTipo: " + getTipo() + 
                "\nNúmero do Espaço Porto: " + getEspacoPorto() + 
                "\nVelocidade Maxima: " + getVelMaxWarp() + "Warps" +
                "\nQuantiade de pessoas/carga: " + getQtdMax() + " pessoas/toneladas" +
                "\n-----------------------------";
    }

    @Override
    public String geraResumo() {
        return getTipo() + ":" + getNome() + ":" + getEspacoPorto() + ":" + getVelMaxWarp() + ":" + getQtdMax() + "\n";
    }
}