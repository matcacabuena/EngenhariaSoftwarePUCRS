import java.util.ArrayList;
import java.util.Scanner;

public class ACMERental {
        private Acervo acervo;
        private Locacoes locacoes;
        private Scanner entrada;
        
    public ACMERental() {
        acervo = new Acervo();
        locacoes = new Locacoes();
        entrada = new Scanner(System.in);
    }

    public void preCadastra() {
        Alugavel alugavel1 = new Alugavel ("Renault Duster", 1111, 300.00, 2017, "IVK0451");
        acervo.adicionaAlugavel(alugavel1);
        Alugavel alugavel2 = new Alugavel ("Chevrolet Onix", 2222, 200.00, 2018, "IWV1823");
        acervo.adicionaAlugavel(alugavel2);
        Alugavel alugavel3 = new Alugavel ("Fiat Uno", 3333, 100.00, 2021, "ICR7421");
        acervo.adicionaAlugavel(alugavel3);

        Aluguel aluguel1 = new Aluguel ("Mateus Campos", "28/08", "039.539.680-20", 5, alugavel1);
        locacoes.adicionaAluguel(aluguel1);
        Aluguel aluguel2 = new Aluguel ("André Ferreira", "15/07", "599.455.400-20", 2, alugavel1);
        locacoes.adicionaAluguel(aluguel2);
        Aluguel aluguel3 = new Aluguel ("Caio Silva", "02/08", "658.342.988-20", 3, alugavel1);
        locacoes.adicionaAluguel(aluguel3);
        Aluguel aluguel4 = new Aluguel ("Mateus Campos", "23/05", "039.539.680-20", 1, alugavel2);
        locacoes.adicionaAluguel(aluguel4);
        Aluguel aluguel5 = new Aluguel ("Rodrigo Machado", "26/06", "598.864.760-20", 10, alugavel3);
        locacoes.adicionaAluguel(aluguel5);
    }

    public void executa() {
        int opcao;
        do {
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    mostraDadosCadastrados();
                    break;
                case 2:
                    consultaAlugavelCodigo();
                    break;
                case 3:
                    consultaAlugavelNome();
                    break;
                case 4:
                    consultaAluguelCliente();
                    break;
                case 5: 
                    cadastrarAluguel();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        while(opcao!=0);
    }

    private void menu() {
        System.out.println("========================================================================");
        System.out.println("Bem-vindo ao sistema de aluguéis de carro, selecione a opção desejada: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Mostrar todos os dados cadastrados");
        System.out.println("[2] Pesquisar item alugável pelo código");
        System.out.println("[3] Pesquisar itens alugáveis pelo nome");
        System.out.println("[4] Pesquisar aluguéis de um cliente");
        System.out.println("[5] Cadastrar um aluguél");
        System.out.println("Opção desejada: ");
    }

    private void mostraDadosCadastrados() {
       System.out.println("Dados de todos os itens alugáveis: ");
        for(int i = 0; i < acervo.getCadastro().size(); i++) {
            Alugavel alugavel = acervo.getCadastro().get(i);
            System.out.println("__________________________________________");
            System.out.println("Nome: " + alugavel.getNome());
            System.out.println("Código: " + alugavel.getCodigo());
            System.out.println("Preço Diário: " + alugavel.getPrecoDiario());
            System.out.println("Ano: " + alugavel.getAno());
            System.out.println("Placa: " + alugavel.getPlaca());
            System.out.println("------------------------------------------");
            System.out.println("Dados de aluguéis deste veículo: ");
            for (int j = 0; j < locacoes.pesquisaAlugavelNome(alugavel.getNome()).size(); j++) {
                Aluguel aluguel = locacoes.pesquisaAlugavelNome(alugavel.getNome()).get(j);
                    System.out.println("Nome cadastrado: " + aluguel.getNome());
                    System.out.println("Data de aluguél: " + aluguel.getData());
                    System.out.println("Cpf do cadastrado: " + aluguel.getCpf());
                    System.out.println("Período de aluguél: " + aluguel.getPeriodo() + " dias");
                    System.out.println("Valor total a ser pago: R$" + aluguel.calculaValorFinal());
                    System.out.println("------------------------------------------");
            }
        }
    }

    private void consultaAlugavelCodigo() {
        System.out.println("Digite o código de um item alugável: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        Alugavel alugavel = acervo.pesquisaAlugavel(codigo);
        if(alugavel == null) {
            System.out.println("Nenhum item alugavel encontrado com este codigo");
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Item alugável encontrado, dados do item: ");
            System.out.println("Nome: " + alugavel.getNome());
            System.out.println("Código: " + alugavel.getCodigo());
            System.out.println("Preço Diário: " + alugavel.getPrecoDiario());
            System.out.println("Ano: " + alugavel.getAno());
            System.out.println("Placa: " + alugavel.getPlaca());
            if(locacoes.pesquisaAlugavel(codigo) == null){
                System.out.println("Nenhum aluguél cadastrado neste código.");
            } else {    
                System.out.println("------------------------------------------");
                System.out.println("Dados de aluguéis do item alugável: ");
                for(int i = 0; i < locacoes.pesquisaAlugavel(codigo).size(); i++ ) {
                    Aluguel aluguel = locacoes.pesquisaAlugavel(codigo).get(i);
                    System.out.println("Nome cadastrado: " + aluguel.getNome());
                    System.out.println("Data de aluguél: " + aluguel.getData());
                    System.out.println("Cpf do cadastrado: " + aluguel.getCpf());
                    System.out.println("Período de aluguél: " + aluguel.getPeriodo() + " dias");
                    System.out.println("Valor total a ser pago: R$" + aluguel.calculaValorFinal());
                    System.out.println("------------------------------------------");
                }  
            }
        }
    }

    private void consultaAlugavelNome() {
        System.out.println("Digite o nome de um item alugável: ");
        String nome = entrada.nextLine();
        ArrayList<Alugavel> alugavel = acervo.pesquisaAlugavel(nome);
        if(alugavel == null) {
            System.out.println("nome inválido: não existe nenhum item alugável com este nome");
        } else {
            for(int i = 0; i < alugavel.size(); i++) {
                System.out.println("------------------------------------------");
            System.out.println("Item alugável encontrado, dados do item: ");
            System.out.println("Nome: " + alugavel.get(i).getNome());
            System.out.println("Código: " + alugavel.get(i).getCodigo());
            System.out.println("Preço Diário: " + alugavel.get(i).getPrecoDiario());
            System.out.println("Ano: " + alugavel.get(i).getAno());
            System.out.println("Placa: " + alugavel.get(i).getPlaca());
            if(locacoes.pesquisaAlugavelNome(nome) == null){
                System.out.println("Nenhum aluguél cadastrado neste código.");
            } else { 
                System.out.println("------------------------------------------");
                System.out.println("Dados de aluguéis do item alugável: ");
                    for(int j = 0; j < locacoes.pesquisaAlugavelNome(nome).size(); j++ ) {
                        Aluguel aluguel = locacoes.pesquisaAlugavelNome(nome).get(j);
                        System.out.println("Nome cadastrado: " + aluguel.getNome());
                        System.out.println("Data de aluguél: " + aluguel.getData());
                        System.out.println("Cpf do cadastrado: " + aluguel.getCpf());
                        System.out.println("Período de aluguél: " + aluguel.getPeriodo() + " dias");
                        System.out.println("Valor total a ser pago: R$" + aluguel.calculaValorFinal());
                        System.out.println("------------------------------------------");
                    }
                }
            }
        }
    }

    private void consultaAluguelCliente() {
        System.out.println("Digite o cpf de um cliente, no modelo 'xxx.xxx.xxx-xx', escrevendo corretamente tanto as pontuações, quanto o traço: ");
        String cpf = entrada.nextLine();
        if(locacoes.pesquisaAluguel(cpf) == null) { System.out.println("cpf inexistente ou não cadastrado."); }
        else {
            for(int i = 0; i < locacoes.pesquisaAluguel(cpf).size(); i++) {
                Aluguel aluguel = locacoes.pesquisaAluguel(cpf).get(i);
                System.out.println("Dados do cliente: ");
                System.out.println("Nome cadastrado: " + aluguel.getNome());
                System.out.println("Data de aluguél: " + aluguel.getData());
                System.out.println("Cpf do cadastrado: " + aluguel.getCpf());
                System.out.println("Período de aluguél: " + aluguel.getPeriodo() + " dias");
                System.out.println("Valor total a ser pago: R$" + aluguel.calculaValorFinal());
                System.out.println("------------------------------------------");
                Alugavel alugavel = aluguel.getAlugavel();
                if(alugavel != null) {
                    System.out.println("Dados do item alugado pelo cliente: ");
                    System.out.println("Nome: " + alugavel.getNome());
                    System.out.println("Código: " + alugavel.getCodigo());
                    System.out.println("Preço Diário: " + alugavel.getPrecoDiario());
                    System.out.println("Ano: " + alugavel.getAno());
                    System.out.println("Placa: " + alugavel.getPlaca());
                    System.out.println("------------------------------------------");
                } else { System.out.println("Nenhum aluguel encontrado com este CPF"); }
            }
        }
    }

    private void cadastrarAluguel() {
        System.out.println("Para cadastrar o seu aluguél, precisaremos de algumas informações para registrá-lo no sistema. ");
        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a data em que deseja alugar no modelo 'xx/xx': ");
        String data = entrada.nextLine();
        System.out.println("Digite o seu cpf, no modelo 'xxx.xxx.xxx-xx', escrevendo corretamente tanto as pontuações, quanto o traço: ");
        String cpf = entrada.nextLine();
        System.out.println("Digite o periodo, em dias, que deseja alugar o carro: ");
        int periodo = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o código do carro que você quer alugar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        Aluguel aluguel6 = new Aluguel (nome, data, cpf, periodo, acervo.pesquisaAlugavel(codigo));
        locacoes.adicionaAluguel(aluguel6);
        System.out.println("Aluguél cadastrado com sucesso!");
    }
}