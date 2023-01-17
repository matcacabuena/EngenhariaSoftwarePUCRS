package exemploobjetoarquivotexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeituraObjetosArquivoTexto {

    private Pessoa lista[];

    public LeituraObjetosArquivoTexto() {
        lista = new Pessoa[5];
    }
    
    /**
     * Leitura dos dados dos objetos Pessoa de arquivo texto
     * Alternativa 1: uso do Scanner token a token
     */
    public void leRegistrosTexto() {
        String nome;
        int idade;
        String endereco;
        int indice = 0;
        Path path = Paths.get("pessoas.txt");
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            String token = null;
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            while (sc.hasNext()) {
                nome = sc.next();       // Primeiro campo: nome
                endereco = sc.next();   // Terceiro campo: endereco
                lista[indice] = new Pessoa(nome,endereco);
                indice++;
            }
        } 
        catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        }
        catch (Exception e2) {
            System.out.println("Erro: " + e2);
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
        finally {
            System.out.println("Dados de pessoas do arquivo:");
            for(Pessoa p : lista) {
                System.out.println(p);
            }
        }
    }

    /**
     * Leitura dos dados dos objetos Pessoa de arquivo texto
     * Alternativa 2: uso do Scanner linha a linha
     */
    public void leRegistrosTexto2() {
        String nome;
        int idade;
        String endereco;
        int indice = 0;
        Path path = Paths.get("pessoas.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = null;
            String token;
            while ((linha = br.readLine()) != null) {   
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";"); 
                nome = sc.next();       // Primeiro campo: nome
                endereco = sc.next();   // Terceiro campo: endereco
                lista[indice] = new Pessoa(nome,endereco);
                indice++;                
            }
        } 
        catch (IOException e1) {
            System.err.format("Erro de E/S: %s%n", e1);
        }
        catch (Exception e2) {
            System.out.print("Erro - trace da falha: ");
            e2.printStackTrace();
        }
        finally {
            System.out.println("Dados de pessoas do arquivo:");
            for(Pessoa p : lista) {
                System.out.println(p);
            }
        }
    }

}

