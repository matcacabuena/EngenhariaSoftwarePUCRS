import java.util.ArrayList;

public class Locacoes {
    private ArrayList<Aluguel> cadastro; 

    public Locacoes() {
        cadastro = new ArrayList<Aluguel>();
    }
    
    public void adicionaAluguel(Aluguel aluguel) {
        cadastro.add(aluguel);
    }

    public int getQtdAluguel() {
        return cadastro.size();
    }

    public Aluguel pesquisaCpf(String cpf) {
        for(int i=0; i < cadastro.size(); i++ ) {
            Aluguel aluguel = cadastro.get(i);
            if(aluguel.getCpf().equals(cpf)) {
                return aluguel;
            }
        }
        return null;
    }

    public ArrayList<Aluguel> pesquisaAluguel(String cpf) {
        ArrayList<Aluguel> nomePesquisado = new ArrayList<Aluguel>();
        for(int i=0; i < cadastro.size(); i++ ) {
            Aluguel aluguel = cadastro.get(i);
            if(aluguel.getCpf().equals(cpf)) {
                nomePesquisado.add(aluguel);
            }
        }
        if(nomePesquisado.size() > 0) {
            return nomePesquisado;
        } else { return null; }
    }

    public ArrayList<Aluguel> pesquisaAlugavel(int codigo) {
        ArrayList<Aluguel> aluguelCodigo = new ArrayList<Aluguel>();
        for (int i = 0; i < cadastro.size(); i++) {
            Aluguel aluguel = cadastro.get(i);
            if(aluguel.getAlugavel().getCodigo() == codigo) {
                aluguelCodigo.add(aluguel);
            }
        }
        if(aluguelCodigo.size() > 0) {
            return aluguelCodigo;
        } else { return null; }
    }

    public ArrayList<Aluguel> pesquisaAlugavelNome(String nome) {
        ArrayList<Aluguel> aluguelNome = new ArrayList<Aluguel>();
        for (int i = 0; i < cadastro.size(); i++) {
            Aluguel aluguel = cadastro.get(i);
            if(aluguel.getAlugavel().getNome().equals(nome)) {
                aluguelNome.add(aluguel);
            }
        }
        if(aluguelNome.size() > 0) {
            return aluguelNome;
        } else { return null; }
    }
}