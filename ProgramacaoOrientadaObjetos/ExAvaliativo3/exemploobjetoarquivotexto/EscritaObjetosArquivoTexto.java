package exemploobjetoarquivotexto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscritaObjetosArquivoTexto {

    private Pessoa lista[];
    
    /**
     * Inicializacao de uma colecao de Pessoas
     */
    public void inicializa() {
        lista = new Pessoa[3];
        lista[0] = new Pessoa("Maria",22,"Porto Alegre");
        lista[1] = new Pessoa("Pedro",21,"Caxias");
        lista[2] = new Pessoa("Mario",23,"Alegrete");
    }
    
    /**
     * Gravacao das informacoes dos objetos Pessoa em arquivo texto
     * Campos separados por ponto-e-virgula (;)
     */
    public void gravaRegistrosTexto() {
        Path path1 = Paths.get("pessoas.txt");
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (Pessoa p : lista) {
                writer.format("%s;%d;%s%n",p.getNome(),p.getIdade(),p.getEnd());
            }
        } 
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void gravaRegistrosTexto2() {
        Path path = Paths.get("pessoas.txt");
        try{
            BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset());
            PrintWriter writer = new PrintWriter(bw);
            for (Pessoa p : lista) {
                writer.format("%s;%d;%s%n",p.getNome(),p.getIdade(),p.getEnd());
            }
            bw.close();
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }


}
