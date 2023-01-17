package com.trabalhofinal.transEspacial;

public class EspacoPorto {

	private int numero;

	private String nome;

	private double coordX;

	private double coordY;

	private double coordZ;

	public EspacoPorto(int numero, String nome, double coordX, double coordY, double coordZ) {
		this.numero = numero;
		this.nome = nome;
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;
	}

	public int getNumero () {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public double getCoordX () {
		return coordX;
	}

	public double getCoordY () {
		return coordY;
	}

	public double getCoordZ() {
		return coordZ;
	}

	public void setNumero (int numero) {
		this.numero = numero;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}	

	public void setCoordX (double coordX) {
		this.coordX = coordX;
	}

	public void setCoordY (double coordY) {
		this.coordY = coordY;
	}

	public void setCoordZ (double coordZ) {
		this.coordZ = coordZ;
	}

	public void setCoord (double coordX, double coordY, double coordZ) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;
	}

	public String toString() {
		return "\n-----------------------------" +
				"\nNumero: " + getNumero() + 
				"\nNome: " + getNome() + 
				"\ncoordX: " + getCoordX() + 
				"\ncoordY: " + getCoordY() +
				"\ncoordZ: " + getCoordZ() +
				"\n-----------------------------";
	}
	
	public String geraResumo() {
		return getNumero() + ":" + getNome() + ":" + getCoordX() + ":" + getCoordY() + ":" + getCoordZ() + "\n";
	}
}
