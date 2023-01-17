package com.trabalhofinal.transEspacial;

public enum Combustivel {
    nuclear("nuclear"), ion("ion");

    private String comb;

    Combustivel(String comb) {
        this.comb = comb;
   }

   public String getCombustivel() {
       return comb;
   }
}
