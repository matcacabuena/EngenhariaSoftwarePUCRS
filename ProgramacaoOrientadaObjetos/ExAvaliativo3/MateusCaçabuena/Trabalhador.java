public class Trabalhador {
    private String matricula;            
    private String nome;            
    private String funcao;        
    private String cargo;            

    Trabalhador(String matricula, String nome, String funcao, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.funcao = funcao;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String geraResumo() {
        String resumo = matricula + ";" + nome + ";" + funcao + ";" + cargo;
        return resumo;
    }

    public String toString() {
        return (
            "\nMatrícula: " + matricula +
            "\nNome: " + nome +
            "\nFunção: " + funcao +
            "\nCargo: " + cargo
        );
    }
}