import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEData {
    private Arquivador arquivador;
    private Scanner in;

    ACMEData() {
        arquivador = new Arquivador();
        in = new Scanner(System.in);
    }

    public void executa() {
        int opcao = -1;
        do {
            menu();
            boolean ok;
            do {
                ok = true;
                try {
                    opcao = in.nextInt();
                } catch (InputMismatchException e1) {
                    in.nextLine();
                    ok = false;
                    System.out.println("Tipo incorreto. Redigite.");
                } catch (Exception e2) {
                    in.nextLine();
                    ok = false;
                    e2.printStackTrace();
                    System.out.println("Redigite.");
                }
            } while(!ok);
            in.nextLine();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    carregaDados();
                    break;
                case 2:
                    //classificaDadosNome();
                    break;
                case 3:
                    //consultaDados();
                    break;
                case 4: 
                    //consultaDadosNome();
                    break;
                case 5:
                    //salvaArquivo();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        while(opcao!=0);
    }


    public void menu() {
        System.out.println("==========================================");
        System.out.println("Bem-vindo ao sistema de controle de dados");
        System.out.println("[0] Sair");
        System.out.println("[1] Carregar novos dados");
        System.out.println("[2] Classificar os dados por nome A-Z");
        System.out.println("[3] Consultar todos os dados");
        System.out.println("[4] Consultar todos os dados por nome");
        System.out.println("[5] Salvar dados em arquivo");
        System.out.println("Opção desejada: ");
    }

    public void carregaDados() {
        System.out.println("Digite o nome do arquivo que deseja carregar (com .txt): ");
        String arquivo = in.nextLine();
        arquivador.carregaDadosAbertos(arquivo);
    }
}