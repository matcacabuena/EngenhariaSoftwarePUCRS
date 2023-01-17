package exemploobjetoarquivotexto;

/**
 * Exemplo de escrita (gravacao) de objetos em arquivo-texto
 */
public class MainEscrita {
    public static void main(String args[]) {
        EscritaObjetosArquivoTexto exemplo = new EscritaObjetosArquivoTexto();
        exemplo.inicializa();
        exemplo.gravaRegistrosTexto2();
        System.out.println("Arquivo com objetos gravado.");
    }
}