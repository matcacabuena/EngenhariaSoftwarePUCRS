import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Arquivador {
    private ArrayList<Trabalhador> trabalhadores;
    private ArrayList<Trabalhador> consulta;

    Arquivador() {
        trabalhadores = new ArrayList<Trabalhador>();
        consulta = new ArrayList<Trabalhador>(150);
    }
    
    public void carregarDadosAbertos(String arquivo) {
        String linha;
        String[] conteudosLinha = {""};
        String matricula;     
        String nome;
        String funcao;
        String cargo;
        try {
            BufferedReader br = 
                new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(arquivo),
                        "UTF-8"
                    )
                );
            
            while (true) {
                linha = br.readLine();
                if (linha == null) break;
                conteudosLinha = linha.split(";");
                matricula = conteudosLinha[0];
                nome = conteudosLinha[1];
                funcao = conteudosLinha[2];
                cargo = conteudosLinha[3];
                trabalhadores.add(new Trabalhador(matricula, nome, funcao, cargo));
            }
            br.close();
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
            if(trabalhadores.size() > 0) { System.out.println("Dados de trabalhadores carregados."); } 
            else { System.out.println("Nenhum dado foi carregado. "); }
        }
    }

    public void classificarDadosNome(int opcao) {
        if(trabalhadores.size() == 0) {
            System.out.println("erro: não há trabalhadores no arquivo");
            return;
        }
        if(opcao==1) {
            Collections.sort(trabalhadores,new ComparadorTrabalhador());
            System.out.println("Os trabalhadores foram classificados conforme ordem crescente de nome com sucesso.");
        }
        else {
            Collections.sort(trabalhadores,new ComparadorTrabalhador());
            Collections.reverse(trabalhadores);
            System.out.println("Os trabalhadores foram classificados conforme ordem decrescente de nome com sucesso.");
        }
    }

    public ArrayList<Trabalhador> consultarDados() {
        consulta.removeAll(consulta);
        trabalhadores.stream().forEach(t -> consulta.add(t));
        return (ArrayList<Trabalhador>) trabalhadores.clone();
    }

    public void consultarDadosNome(String s) {
        consulta.removeAll(consulta);
        trabalhadores.stream().filter(t -> t.getNome().contains(s)).forEach(t -> consulta.add(t));
        if(consulta.size() > 0) {
            consulta.stream().forEach(t -> System.out.println(t));
        }
        else { System.out.println("Não há dados no arquivo com este nome."); }
    }

    public boolean salvarArquivo(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo + ".txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            for(Trabalhador t : consulta) {
                writer.format(t.geraResumo() + "%n");
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: " + e);
            return false;
        }
        return true;
    }
}         