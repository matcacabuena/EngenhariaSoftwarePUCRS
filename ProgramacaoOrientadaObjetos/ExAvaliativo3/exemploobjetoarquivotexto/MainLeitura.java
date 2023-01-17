package exemploobjetoarquivotexto;

import exemploobjetoarquivotexto.LeituraObjetosArquivoTexto;

/**
 * Exemplo de leitura de arquivo texto
 */

public class MainLeitura {
    public static void main(String args[]) {
        LeituraObjetosArquivoTexto exemplo = new LeituraObjetosArquivoTexto();
        System.out.println("--- ALTERNATIVA 1 ---");
        exemplo.leRegistrosTexto();
        System.out.println("--- ALTERNATIVA 2 ---");
        exemplo.leRegistrosTexto2();
        System.out.println("Arquivo com objetos lido.");
    }
}
