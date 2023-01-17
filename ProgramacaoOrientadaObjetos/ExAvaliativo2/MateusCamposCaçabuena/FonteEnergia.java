public enum FonteEnergia {
    SOLAR("solar"), EOLICA("eolica"), HIDRICA("hidrica");
    private final String nome;
    
    FonteEnergia(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
}