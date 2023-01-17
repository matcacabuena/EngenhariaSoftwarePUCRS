package exemploobjetoarquivotexto;

public class Pessoa {
    private String nome, endereco;
    private int idade;
    
    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
        
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public String getEnd() {
        return endereco;
    }
    
    public String toString() {
        return "Nome: " + nome +
            ", Idade: " + idade + 
            ", Endereco: " + endereco;
    }
}
