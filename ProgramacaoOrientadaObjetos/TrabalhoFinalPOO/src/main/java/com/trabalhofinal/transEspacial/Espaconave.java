package com.trabalhofinal.transEspacial;

import java.util.ArrayList;

public abstract class Espaconave {

	private String nome;

	private int espacoPorto;

	private int tipo;

	private ArrayList<Transporte> historico;

	private Transporte transporte;

	public Espaconave(int tipo, String nome, int espacoPorto, Transporte transporte) {
		this.tipo = tipo;
		this.nome = nome;
		this.espacoPorto = espacoPorto;
		this.transporte = transporte;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public String getNome() {
		return nome;
	}

	public int getTipo() {
		return tipo;
	}

	public int getEspacoPorto() {
		return espacoPorto;
	}

	public ArrayList<Transporte> getHistorico() {
		return historico;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public void setEspacoPorto(int espacoPorto) {
		this.espacoPorto = espacoPorto;
	}
	
	public boolean setHistorico(Transporte transporte) {
		return historico.add(transporte);
	}

	public abstract String toString();

	public abstract String geraResumo();
}
