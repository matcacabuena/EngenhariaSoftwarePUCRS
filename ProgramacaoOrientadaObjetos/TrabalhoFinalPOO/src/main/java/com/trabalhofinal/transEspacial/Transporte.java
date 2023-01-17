package com.trabalhofinal.transEspacial;

public abstract class Transporte {

	private int identificador;

	private Espaconave espaconave;

	private int tipo;

	private int numOrigem;

	private EstadoTransporte estado;

	private int numDestino;

	private EspacoPorto eOrigem;

	private EspacoPorto eDestino;

	public Transporte(int tipo, int identificador, int numOrigem, int numDestino, EspacoPorto eOrigem, EspacoPorto eDestino, EstadoTransporte estado, Espaconave espaconave) {
		this.tipo = tipo;
		this.identificador = identificador;
		this.numOrigem = numOrigem;
		this.numDestino = numDestino;
		this.eOrigem = eOrigem;
		this.eDestino = eDestino;
		this.estado = estado;
		this.espaconave = espaconave;
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getOrigem() {
		return numOrigem;
	}

	public int getDestino() {
		return numDestino;
	}

	public EspacoPorto getEPOrigem() {
		return eOrigem;
	}

	public EspacoPorto getEPDestino() {
		return eDestino;
	}

	public int getTipo() {
		return tipo;
	}

	public Espaconave getEspaconave() {
		return espaconave;
	}

	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
	}

	public EstadoTransporte getEstado() {
		return estado;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public void setOrigem(int numOrigem) {
		this.numOrigem = numOrigem;
	}

	public void setDestino(int numDestino) {
		this.numDestino = numDestino;
	}

	public void setEstado(EstadoTransporte estado){
		this.estado = estado;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public abstract String toString();

	public abstract String geraResumo();

}
