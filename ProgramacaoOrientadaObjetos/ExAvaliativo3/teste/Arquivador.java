import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//nome do arquivo: bolsistas_apoio_desenv.txt

public class Arquivador {
    private ArrayList<Receita> receita;

    Arquivador() {
        receita = new ArrayList<Receita>();
    }
    
    public void carregaDadosAbertos(String arquivo) { 
        String comida;
        String duracao;
        String acompanhamento;
        String corno;
        Path path = Paths.get(arquivo);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path,Charset.defaultCharset()))) {
            String token = null;
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            while (sc.hasNext()) {
                comida = sc.next();
                duracao = sc.next();
                acompanhamento = sc.next();
                corno = sc.next();
                receita.add(new Receita(comida, duracao, acompanhamento, corno));
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
        catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
        finally {
            System.out.println("Dados de bolsistas do arquivo:");
            for(Receita r : receita) {
                System.out.println(r);
            }
        }
    }
}