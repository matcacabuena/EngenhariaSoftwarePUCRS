package com.trabalhofinal.transEspacial;

public enum EstadoTransporte {
    PENDENTE("PENDENTE"), TRANSPORTANDO("TRANSPORTANDO"), CANCELADO("CANCELADO"), FINALIZADO("FINALIZADO");

    private String estado;

    EstadoTransporte(String estado) {
        this.estado = estado;
    }

   public String getEstado() { return estado; }
}