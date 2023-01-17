import java.util.ArrayList;

public class Acervo {
    private ArrayList<Alugavel> cadastro;   

    public Acervo() {
        cadastro = new ArrayList<Alugavel>();
    }
    
    public boolean adicionaAlugavel(Alugavel alugavel) {
        return cadastro.add(alugavel);
    }

    public Alugavel pesquisaAlugavel(int codigo) {
        for(int i=0; i < cadastro.size(); i++ ) {
            Alugavel alugavel = cadastro.get(i);
            if(alugavel.getCodigo() == codigo) {
                return alugavel;
            } 
        } 
        return null; 
    }

    public ArrayList<Alugavel> pesquisaAlugavel(String nome) {
        ArrayList<Alugavel> nomePesquisado;
        nomePesquisado = new ArrayList<Alugavel>();
        for(int i=0; i < cadastro.size(); i++ ) {
            Alugavel alugavel = cadastro.get(i);
            if(alugavel.getNome().equals(nome)) {
                nomePesquisado.add(alugavel);
            }
        }
        if(nomePesquisado.size() > 0) {
            return nomePesquisado;
        } 
        else { 
            System.out.println("Não existe alugável com este nome."); 
            return null; 
        }
    }

    public ArrayList<Alugavel> getCadastro() {
        return cadastro;
    }
}
