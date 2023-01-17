public enum Combustivel {
    PETROLEO("petroleo", 40), CARVAO("carvao", 1), NUCLEAR("nuclear", 3);
    private final String nome;
    private final int durabilidade;

    Combustivel(String nome, int durabilidade) {
        this.nome = nome;
        this.durabilidade = durabilidade;
    }

    public String getNome() { return nome; }
    
    public int getDurabilidade() { return durabilidade; }
}