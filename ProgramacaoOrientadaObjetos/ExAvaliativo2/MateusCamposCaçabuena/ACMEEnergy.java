import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEEnergy {
    private Conglomerado conglomerado;
    private Scanner in;

    ACMEEnergy() {
        conglomerado = new Conglomerado();
        in = new Scanner (System.in);
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
                    cadastraNovaUsina();
                    break;
                case 2:
                    pesquisaUsina();
                    break;
                case 3:
                    listaUsinas();
                    break;
                case 4: 
                    consultaPrecoMWh();
                    break;
                case 5:
                    salvaArquivo();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        while(opcao!=0);
    }

    public void inicializa() {
        Usina u;       
        UsinaRenovavel ur = new UsinaRenovavel("Lapa", 158.7, 2.00, FonteEnergia.SOLAR);
        UsinaRenovavel ur2 = new UsinaRenovavel("Itaipu", 158.7, 2.00, FonteEnergia.SOLAR);
        UsinaNaoRenovavel unr = new UsinaNaoRenovavel("Polu", 25.4, 75.5, Combustivel.CARVAO);
        //polimorfismo
        u = ur;
        conglomerado.cadastraUsina(u);
        u = unr;
        conglomerado.cadastraUsina(u);
        u = ur2;
        conglomerado.cadastraUsina(u);
    }

    public void menu() {
        System.out.println("==========================================");
        System.out.println("Bem-vindo ao sistema de controle de usinas");
        System.out.println("[0] Sair");
        System.out.println("[1] Cadastrar nova usina");
        System.out.println("[2] Pesquisar uma usina");
        System.out.println("[3] Listar todas as usinas");
        System.out.println("[4] Consulta o preço do MWh");
        System.out.println("[5] Salvar usinas em arquivo");
        System.out.println("Opção desejada: ");
    }

    public void cadastraNovaUsina() {
        UsinaRenovavel ur3;
        UsinaNaoRenovavel unr2;
        
        System.out.println("Digite o nome da usina: ");
        String nome = in.nextLine();
        if(conglomerado.pesquisaUsina(nome) != null) {
            System.out.println("Usina repetida");
            return;
        }

        System.out.println("Digite a quantia de produção MWh: ");
        double producaoMWh = -1;
        boolean ok;
            do {
                ok = true;
                try {
                    producaoMWh = in.nextDouble();
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

        System.out.println("Digite o custo MWh: ");
        double custoMWh = -1;
            do {
                ok = true;
                try {
                    custoMWh = in.nextDouble();
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
        Usina u;
        int opcao = -1;
        do {
            System.out.println("Selecione o tipo de usina: ");
            System.out.println("[0] Cancelar Cadastro");
            System.out.println("[1] Usina Renovável Solar");
            System.out.println("[2] Usina Renovável Eólica");
            System.out.println("[3] Usina Renovável Hídrica");
            System.out.println("[4] Usina Não-Renovável de Petróleo");
            System.out.println("[5] Usina Não-Renovável de Carvão");
            System.out.println("[6] Usina Não-Renovável Nuclear");

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
                    ur3 = new UsinaRenovavel(nome, producaoMWh, custoMWh, FonteEnergia.SOLAR);
                    u = ur3;
                    conglomerado.cadastraUsina(u);
                    break;
                case 2:
                    ur3 = new UsinaRenovavel(nome, producaoMWh, custoMWh, FonteEnergia.EOLICA);
                    u = ur3;
                    conglomerado.cadastraUsina(u);
                    break;
                case 3:
                    ur3 = new UsinaRenovavel(nome, producaoMWh, custoMWh, FonteEnergia.HIDRICA);
                    u = ur3;
                    conglomerado.cadastraUsina(u);
                    break;
                case 4:
                    unr2 = new UsinaNaoRenovavel(nome, producaoMWh, custoMWh, Combustivel.PETROLEO);
                    u = unr2;
                    conglomerado.cadastraUsina(u);
                    break;
                case 5:
                    unr2 = new UsinaNaoRenovavel(nome, producaoMWh, custoMWh, Combustivel.CARVAO);
                    u = unr2;
                    conglomerado.cadastraUsina(u);
                    break;
                case 6: 
                    unr2 = new UsinaNaoRenovavel(nome, producaoMWh, custoMWh, Combustivel.NUCLEAR);
                    u = unr2;
                    conglomerado.cadastraUsina(u);
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            } 
        } while(!(opcao >= 0 && opcao <= 6));
        System.out.println("Usina cadastrada");
    }

    public void pesquisaUsina() {
        System.out.println("Digite o nome da usina: ");
        String nome = in.nextLine();
        if(conglomerado.pesquisaUsina(nome) == null) {
            System.out.println("Nenhuma usina foi localizada com este nome.");
            return;
        }

        Usina u = conglomerado.pesquisaUsina(nome);
        System.out.println("===================");
        System.out.println("Nome: " + u.getNome());
        System.out.println("Produção MWh: " + u.getProducaoMWh());
        System.out.println("Custo MWh: " + u.getCustoMWh());
        if(u instanceof UsinaRenovavel) {
            System.out.println("Energia: " + ((UsinaRenovavel) u).getEnergia());
        }
        if(u instanceof UsinaNaoRenovavel) {
            System.out.println("Combustível: " + ((UsinaNaoRenovavel) u).getCombustivel());
        }
    }

    public void listaUsinas() {
        System.out.println("Todas as usinas:");
        
        ArrayList<Usina> usinas = conglomerado.listaTodasUsinas();

        if(usinas.size() == 0) {
            System.out.println("Nenhuma usina cadastrada.");
            return;
        }

        for(Usina u : usinas) {
            System.out.println("===================");
            System.out.println("Nome: " + u.getNome());
            System.out.println("Produção MWh: " + u.getProducaoMWh());
            System.out.println("Custo MWh: " + u.getCustoMWh());
            if(u instanceof UsinaRenovavel) {
                System.out.println("Energia: " + ((UsinaRenovavel) u).getEnergia());
            }
            if(u instanceof UsinaNaoRenovavel) {
                System.out.println("Combustível: " + ((UsinaNaoRenovavel) u).getCombustivel());
            }
        }
    }

    public void consultaPrecoMWh() {
        System.out.println("Digite o nome da usina: ");
        String nome = in.nextLine();
        if(conglomerado.pesquisaUsina(nome) == null) {
            System.out.println("Nenhuma usina foi localizada com este nome.");
            return;
        }
        Usina u = conglomerado.pesquisaUsina(nome);
        System.out.println("Preço de MWh da Usina " + u.getNome() + ": " + u.getCustoMWh());
    }

    public void salvaArquivo() {
        System.out.println("Digite o nome do arquivo que deseja salvar (sem extensão): ");
        String nomeArquivo = in.nextLine() + ".csv";
        conglomerado.salvaDadosArquivo(nomeArquivo);
    }
}