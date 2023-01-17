import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Conglomerado {
    private ArrayList<Usina> usinas;

    Conglomerado() {
        usinas = new ArrayList<Usina>();
    }

    public boolean cadastraUsina(Usina usina) {
        for (Usina u : usinas) {
            if (usina.getNome().equals(u.getNome())) {
                return false;
            }
        }
        usina.calculaPrecoMWh();
        return usinas.add(usina);
    }

    public Usina pesquisaUsina(String nome) {
        for (Usina u : usinas) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usina> listaTodasUsinas() { 
        return (ArrayList<Usina>)usinas.clone();
    }

    public double consultaPreco(String nome) {
        for (Usina u : usinas) {
            if (u.getNome().equals(nome)) {
                return u.getCustoMWh();
            }
        }
        return -1.0;
    }

    public boolean salvaDadosArquivo(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            for(Usina u : usinas) {
                writer.format(u.geraResumo() + "%n");
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: " + e);
            return false;
        }
        return true;
    }
}