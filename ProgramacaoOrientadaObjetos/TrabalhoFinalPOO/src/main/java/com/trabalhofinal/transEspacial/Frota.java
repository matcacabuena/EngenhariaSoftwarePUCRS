package com.trabalhofinal.transEspacial;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Frota {
    private ArrayList<EspacoPorto> cadastroEspPorto;

    private ArrayList<Espaconave> cadastroEspNave;

    private Queue<Transporte> cadastroTransp;

    private Queue<Transporte> transpNaoPendentes;

    public Frota() {
        cadastroEspPorto = new ArrayList<>();
        cadastroEspNave = new ArrayList<>();
        cadastroTransp = new LinkedList<>();
        transpNaoPendentes = new LinkedList<>();
    }

    public boolean cadastraEspPorto(EspacoPorto espacoPorto) {
        for (EspacoPorto espPortoCad : cadastroEspPorto) {
            if (espPortoCad.getNumero() == espacoPorto.getNumero()) {
                return false;
            }
        }
        cadastroEspPorto.add(espacoPorto);
        return true;
    }

    public boolean cadastraEspNave(Espaconave espaconave) {
        for (Espaconave espaconaveCad : cadastroEspNave) {
            if (espaconaveCad.getNome().equals(espaconave.getNome())) {
                return false;
            }
        }
        cadastroEspNave.add(espaconave);
        return true;
    }

    public boolean cadastraTransp(Transporte transporte) {
        for (Transporte transporteCad : cadastroTransp) {
            if (transporteCad.getIdentificador() == transporte.getIdentificador()) {
                return false;
            }
        }
        cadastroTransp.add(transporte);
        return true;
    }

    public boolean cadastraNaoPendentes(Transporte transporte) {
        return transpNaoPendentes.add(transporte);
    }

    public void removeTransp(Transporte transporte) {
        cadastroTransp.remove(transporte);
    }

    public EspacoPorto pesquEspacoPorto(int numero) {
        for (EspacoPorto espPortoCad : cadastroEspPorto) {
            if (espPortoCad.getNumero() == numero) {
                return espPortoCad;
            }
        }
        return null;
    }

    public Espaconave pesquEspacoNave(String nome) {
        for (Espaconave espNaveCad : cadastroEspNave) {
            if (espNaveCad.getNome().equals(nome)) {
                return espNaveCad;
            }
        }
        return null;
    }

    public Transporte pesquTransporte(int identificador) {
        for (Transporte transpCad : cadastroTransp) {
            if (transpCad.getIdentificador() == identificador) {
                return transpCad;
            }
        }
        return null;
    }

    public Transporte pesquTransporteNP(int identificador) {
        for (Transporte transpCad : transpNaoPendentes) {
            if (transpCad.getIdentificador() == identificador) {
                return transpCad;
            }
        }
        return null;
    }

    public void setCadastroTransp(Queue<Transporte> cadastroTransp) {
        this.cadastroTransp = cadastroTransp;
    }

    public ArrayList<Espaconave> espacoDisponiveis() {
        ArrayList<Espaconave> espaconaves = mostraEspaconaves();
        ArrayList<Espaconave> navesDisponiveis = new ArrayList<>();
        for (Espaconave espacoCad : espaconaves) {
            if (espacoCad.getTransporte() == null) {
                navesDisponiveis.add(espacoCad);
            }
        }
        return navesDisponiveis;
    }

    public Queue<Transporte> mostraTransportes() {
        if (cadastroTransp == null) {
            return null;
        }
        return cadastroTransp;
    }

    public Queue<Transporte> mostraTransportesNP() {
        if (transpNaoPendentes == null) {
            return null;
        }
        return transpNaoPendentes;
    }

    public ArrayList<EspacoPorto> mostraPortos() {
        return cadastroEspPorto;
    }

    public ArrayList<Espaconave> mostraEspaconaves() {
        if (cadastroEspNave == null) {
            return null;
        }
        return cadastroEspNave;
    }

    public boolean salvaDadosArquivo(String nomeArquivo) {
        String line = " ";
        try {
            File datFile = new File(nomeArquivo + ".dat");
            PrintWriter out = new PrintWriter(datFile);
            for (EspacoPorto porto : cadastroEspPorto) {
                line = porto.toString();
                out.write(line);
            }
            for (Espaconave espaconave : cadastroEspNave) {
                line = espaconave.geraResumo();
                out.write(line);
            }
            for (Transporte trans : cadastroTransp) {
                line = trans.geraResumo();
                out.write(line);
            }
            for (Transporte trans : transpNaoPendentes) {
                line = trans.geraResumo();
                out.write(line);
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}