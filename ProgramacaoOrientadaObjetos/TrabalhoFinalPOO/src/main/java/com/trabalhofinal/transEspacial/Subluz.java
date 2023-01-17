package com.trabalhofinal.transEspacial;

public class Subluz extends Espaconave {

    private double velMaxImpulso;

    private Combustivel combustivel;

    public Subluz (int tipo, String nome, int espacoPorto, double velMaxImpulso, String comb, Transporte transporte) {
        super(tipo, nome, espacoPorto, transporte);
        this.velMaxImpulso = velMaxImpulso;
        this.combustivel = Combustivel.valueOf(comb);
    }

    public double getVelMaxImpulso() {
        return velMaxImpulso;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setVelMaxImpulso(double velMaxImpulso) {
        this.velMaxImpulso = velMaxImpulso;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "\n-----------------------------" +
                "\nEspaconave: " + getNome() +
                "\nTipo: " + getTipo() + 
                "\nNúmero do Espaço Porto: " + getEspacoPorto() + 
                "\nVelocidade Maxima: " + getVelMaxImpulso() + "Warps" +
                "\nCombustivel: " + getCombustivel() +
                "\n-----------------------------";
    }

    @Override
    public String geraResumo() {
        return getTipo() + ":" + getNome() + ":" + getEspacoPorto() + ":" + getVelMaxImpulso() + ":" + getCombustivel() + "\n";
    }
}