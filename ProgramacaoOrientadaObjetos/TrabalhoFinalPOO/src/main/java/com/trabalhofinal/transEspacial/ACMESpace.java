package com.trabalhofinal.transEspacial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class ACMESpace {
    private Scanner in;
    private Frota frota;

    ACMESpace() {
        in = new Scanner(System.in).useLocale(Locale.US);
        frota = new Frota();
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
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e2) {
                    in.nextLine();
                    ok = false;
                    e2.printStackTrace();
                    System.out.println("Redigite.\n");
                }
            } while (!ok);
            in.nextLine();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastraEspacoPorto();
                    break;
                case 2:
                    cadastraEspacoNave();
                    break;
                case 3:
                    cadastraTransporte();
                    break;
                case 4:
                    consultaTransporte();
                    break;
                case 5:
                    alteraEstado();
                    break;
                case 6:
                    cadastraArquivo();
                    break;
                case 7:
                    designaTransporte();
                    break;
                case 8:
                    salvaArquivo();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public void menu() {
        System.out.println("\n==========================================");
        System.out.println("Bem-vindo ao sistema de controle de dados");
        System.out.println("[0] Sair");
        System.out.println("[1] Cadastrar novo espaço-porto");
        System.out.println("[2] Cadastrar nova espaçonave");
        System.out.println("[3] Cadastrar novo transporte");
        System.out.println("[4] Consultar todos os transportes");
        System.out.println("[5] Alterar estado do transporte");
        System.out.println("[6] Carregar dados iniciais");
        System.out.println("[7] Designar transportes");
        System.out.println("[8] Salvar dados em arquivo");
        System.out.println("==========================================");
        System.out.println("\nOpção desejada: ");
    }

    public void cadastraEspacoPorto() {
        boolean ok;
        EspacoPorto espacoPorto = null;
        System.out.println("Insira o numero do espaco porto: ");
        int numero =0;
        do {
            ok = true;
            try {
                numero = in.nextInt();
            } catch (InputMismatchException e1) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e2) {
                ok = false;
                e2.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }
            } while(ok!=true);
            in.nextLine();

            if (frota.pesquEspacoPorto(numero) != null) {
                System.out.println("Ja existe um espaco porto cadastrado com este numero.");
                return;
            }

            System.out.println("Insira o nome do espaco porto: ");
            String nome = in.nextLine();

            System.out.println("Insira a coordenada X do espaco porto: ");
            double coordX = 0;
            do {
                ok=true;
                try{
                    coordX=in.nextDouble();
                } catch (InputMismatchException e3) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e4) {
                ok = false;
                e4.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }
            } while(ok!=true);
        
            System.out.println("Insira a coordenada Y do espaco porto: ");
            double coordY = 0;
            do {
                ok=true;
                try{
                    coordY=in.nextDouble();
                } catch (InputMismatchException e5) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e6) {
                ok = false;
                e6.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }
            } while(ok!=true);

            System.out.println("Insira a coordenada Z do espaco porto: ");
            double coordZ = 0;
            do {
                ok=true;
                try{
                    coordZ=in.nextDouble();
                } catch (InputMismatchException e7) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e8) {
                ok = false;
                e8.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }
            } while(ok!=true);

            espacoPorto = new EspacoPorto(numero, nome, coordX, coordY, coordZ);

            if (frota.cadastraEspPorto(espacoPorto)) {
                System.out.println(espacoPorto.toString());
                System.out.println("Espaco porto cadastrado.");
            } else {
                System.out.println("Espaco porto nao cadastrado.");
            }
    }
    

    public void cadastraEspacoNave() {
        boolean ok;
        Espaconave espaconave = null;

        System.out.println("Insira o tipo da espaconave (1-Subluz, 2-FTL): ");
        int tipo =0;
        do{
            ok=true;
            try{
                tipo=in.nextInt();
            } catch (InputMismatchException e9) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e10) {
                ok = false;
                e10.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }
            } while(ok!=true);
            in.nextLine();

        if(tipo != 1 && tipo != 2) {
            System.out.println("Tipo de espaconave incorreto, retorne ao menu.");
            return;
        }

        System.out.println("Insira o nome da espaco nave: ");
        String nome = in.nextLine();

        if (frota.pesquEspacoNave(nome) != null) {
            System.out.println("Ja existe uma espaco nave cadastrada com este nome.");
            return;
        }

        System.out.println("Insira o número do Espaco Porto desta espaco nave: ");
        int espacoPorto =0;
        do{
            ok=true;
            try{
                espacoPorto=in.nextInt();
            } catch (InputMismatchException e11) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e12) {
                ok = false;
                e12.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }   
        } while(ok!=true);
                
        if(frota.pesquEspacoPorto(espacoPorto) == null) {
            System.out.println("Não existe espaco-porto com este número, volte ao menu.");
            return;
        }

        if (tipo == 1) {
            System.out.println("Insira a Velocidade Maxima de Impulso da espaco nave: ");
            double velMaxImpulso=0;
            do{
                ok=true;
                try{
                    velMaxImpulso=in.nextDouble();
                } catch (InputMismatchException e13) {
                    ok = false;
                    in.nextLine();
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e14) {
                    ok = false;
                    e14.printStackTrace();
                    System.out.println("Erro: Redigite.\n");
                }   
            } while(ok!=true);
            in.nextLine();
            if(velMaxImpulso > 0.3) {
                System.out.println("Erro: a velocidade limite permitida é de 0,3 Warps.");
                return;
            }
            System.out.println("Insira o combustivel da espaco nave (ion ou nuclear): ");
            String comb = "";
            do{
                ok=true;
                comb=in.nextLine();
                try{
                    espaconave = new Subluz(tipo, nome, espacoPorto, velMaxImpulso, comb, null);
                }  catch (IllegalArgumentException e15) {
                    ok = false;
                    System.out.println("Combustivel inexistente. Redigite.");
                } catch (Exception e16) {
                    ok = false;
                    e16.printStackTrace();
                    System.out.println("Redigite.");
                }
            } while (!ok);
            frota.cadastraEspNave(espaconave);
            System.out.println(espaconave.toString());
            System.out.println("Espaconave cadastrada com sucesso!");
        }

        if (tipo == 2) {
            System.out.println("Insira a Velocidade Maxima de Warps da espaco nave: ");
            double velMaxWarp =0;
            do{
                ok=true;
                try{
                    velMaxWarp=in.nextDouble();
                } catch (InputMismatchException e17) {
                    ok = false;
                    in.nextLine();
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e18) {
                    ok = false;
                    e18.printStackTrace();
                    System.out.println("Erro: Redigite.\n");
                }   
            } while(ok!=true);
            in.nextLine();

            System.out.println("Insira a quantidade maxima de pessoas ou carga da espaco nave: ");
            int qtdMaXPessoasOuCarga =0;
            do{
                ok=true;
                try{
                    qtdMaXPessoasOuCarga=in.nextInt();
                } catch (InputMismatchException e19) {
                    ok = false;
                    in.nextLine();
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e20) {
                    ok = false;
                    e20.printStackTrace();
                    System.out.println("Erro: Redigite.\n");
                }   
            } while(ok!=true); 
            in.nextLine();

            espaconave = new FTL(tipo, nome, espacoPorto, velMaxWarp, qtdMaXPessoasOuCarga, null);
            frota.cadastraEspNave(espaconave);
            System.out.println("Espaconave cadastrada com sucesso!");
        }
    }

    public void cadastraTransporte() {
        boolean ok;

        System.out.println("Insira o código do transporte: ");
        int identificador = 0;
        do{
            ok=true;
            try{
                identificador=in.nextInt();
            } catch (InputMismatchException e21) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e22) {
                ok = false;
                e22.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }   
        } while(ok!=true); 
        in.nextLine();
        
        if (frota.pesquTransporte(identificador) != null) {
            System.out.println("Já existe um transporte com este identificador.");
            return;
        }

        System.out.println("Insira o tipo de transporte: ");
        System.out.println("[1] Transporte de Pessoas");
        System.out.println("[2] Transporte Material");
        int tipo =0;
        do{
            ok=true;
            try{
                tipo=in.nextInt();
            } catch (InputMismatchException e23) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e24) {
                ok = false;
                e24.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }   
        } while(ok!=true); 
        in.nextLine();

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.println("Insira o número de identificação do espaço-porto de origem do transporte: ");
        int numOrigem =0;
        do{
            ok=true;
            try{
                numOrigem=in.nextInt();
            } catch (InputMismatchException e25) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e26) {
                ok = false;
                e26.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }   
        } while(ok!=true); 
        in.nextLine();

        if (frota.pesquEspacoPorto(numOrigem) == null) {
            System.out.println("Não existe espaço-porto com este número de identificação");
            return;
        }

        System.out.println("Insira o número do espaço-porto de destino do transporte: ");
        int numDestino =0;
        do{
            ok=true;
            try{
                numDestino=in.nextInt();
            } catch (InputMismatchException e27) {
                ok = false;
                in.nextLine();
                System.out.println("Tipo incorreto. Redigite.\n");
            } catch (Exception e28) {
                ok = false;
                e28.printStackTrace();
                System.out.println("Erro: Redigite.\n");
            }   
        } while(ok!=true); 
        in.nextLine();

        if (frota.pesquEspacoPorto(numDestino) == null) {
            System.out.println("Não existe espaço-porto com este número de identificação");
            return;
        }

        if (tipo == 2) {
            System.out.println("Insira a descrição do seu transporte material: ");
            String descricao = in.nextLine();

            System.out.println("Insira a carga (em toneladas) do seu transporte Material: ");
            double carga =0;
            do{
                ok=true;
                try{
                    carga=in.nextDouble();
                } catch (InputMismatchException e29) {
                    ok = false;
                    in.nextLine();
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e30) {
                    ok = false;
                    e30.printStackTrace();
                    System.out.println("Erro: Redigite.\n");
                }   
            } while(ok!=true); 
            in.nextLine();

            Transporte t = new TransporteMaterial(tipo, identificador, numOrigem,
                    numDestino, frota.pesquEspacoPorto(numOrigem), frota.pesquEspacoPorto(numDestino), EstadoTransporte.PENDENTE, null, carga, descricao);
            frota.cadastraTransp(t);
            System.out.println("----------------------------");
            System.out.println(t.toString());
            System.out.println("----------------------------");
            System.out.println("Transporte cadastrado!");
        }

        if (tipo == 1) {
            System.out.println("Insira a quantia de pessoas do seu transporte de pessoas: ");
            int qtdPessoas =0;
            do{
                ok=true;
                try{
                    qtdPessoas=in.nextInt();
                } catch (InputMismatchException e31) {
                    ok = false;
                    in.nextLine();
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e32) {
                    ok = false;
                    e32.printStackTrace();
                    System.out.println("Erro: Redigite.\n");
                }   
            } while(ok!=true); 
            in.nextLine();

            Transporte t = new TransportePessoa(tipo, identificador, numOrigem, numDestino, frota.pesquEspacoPorto(numOrigem), frota.pesquEspacoPorto(numDestino), EstadoTransporte.PENDENTE, null, qtdPessoas);
            frota.cadastraTransp(t);
            System.out.println(t.toString());
            System.out.println("Transporte cadastrado!");
        }
    }

    public void consultaTransporte() {
        if (frota.mostraTransportes().size() == 0 && frota.mostraTransportesNP().size() == 0) {
            System.out.println("Nenhum transporte cadastrado.");
            return;
        }
        System.out.println("Lista de transportes cadastrados: \n");
        frota.mostraTransportes().stream().forEach(t -> System.out.println(t.toString()));
        frota.mostraTransportesNP().stream().forEach(t -> System.out.println(t.toString()));
    }

    public void alteraEstado() {
        boolean ok;
        

        System.out.println("Insira o identificador do transporte: ");
        int identificador = 0;
        do{
            ok=true;
            try{
            identificador = in.nextInt();
            } catch (InputMismatchException e3) {
                in.nextLine();
                ok = false;
                System.out.println("Tipo incorreto. Redigite");
            } catch (Exception e4) {
                ok = false;
                e4.printStackTrace();
                System.out.println("Redigite.");
            }
        } while(!ok);
        in.nextLine();
        
        Transporte t1 = frota.pesquTransporte(identificador);
        Transporte t2 = frota.pesquTransporteNP(identificador);
        Transporte t = null;
        if(t1 != null) {
            t = t1;
        }
        else if(t2 != null) {
            t = t2;
        }
        else {
            System.out.println("Não existe transporte com este identificador.");
            return;
        }

        System.out.println("\nInsira o novo estado do transporte (pendente || transportando || cancelado || finalizado): ");
        String estado = in.nextLine();
        estado = estado.toUpperCase();

        if (t.getEstado() == EstadoTransporte.CANCELADO || t.getEstado() == EstadoTransporte.FINALIZADO) {
            System.out.println("Erro: não é possível alterar o estado pois o transporte já está finalizado ou foi cancelado.");
            return;
        }

        if (estado.equals("PENDENTE")) {
            t.setEstado(EstadoTransporte.PENDENTE);
            frota.cadastraTransp(t);
        } else if (estado.equals("TRANSPORTANDO")) {
            if(t.getEspaconave() == null) {
                System.out.println("Nao é possivel alterar o estado para \"transportando\", pois o transporte não possui uma espaconave.");
                return;
            }
            t.setEstado(EstadoTransporte.TRANSPORTANDO);
            frota.cadastraNaoPendentes(t);
            frota.removeTransp(t);
        } else if (estado.equals("CANCELADO")) {
            if (t.getEstado() == EstadoTransporte.TRANSPORTANDO || t.getEstado() == EstadoTransporte.PENDENTE) {
                t.setEstado(EstadoTransporte.CANCELADO);
                frota.cadastraNaoPendentes(t);
                frota.removeTransp(t);
            }
            else {
                System.out.println("Um pedido só pode ser cancelado caso ele esteja transportando ou pendente, no momento ele está: " + t.getEstado());
            }
        } else if (estado.equals("FINALIZADO")) {
            t.setEstado(EstadoTransporte.FINALIZADO);
            frota.cadastraNaoPendentes(t);
            frota.removeTransp(t);
        } else {
            System.out.println("erro: não existe este estado.");
            return;
        }
        System.out.println("Estado alterado!");
        return;

    }

    public void cadastraArquivo() {
        boolean ok;
        

        System.out.println("O que voce deseja adicionar (1-Espaconave, 2-Espaco-Porto, 3-Transporte)?");
        int escolha = 0;
        do{
            ok=true;
            try{
                escolha = in.nextInt();
            } catch (InputMismatchException e3) {
                in.nextLine();
                ok = false;
                System.out.println("Tipo incorreto. Redigite");
            } catch (Exception e4) {
                ok = false;
                e4.printStackTrace();
                System.out.println("Redigite.");
            }
        } while(!ok);
        in.nextLine();

        if (escolha == 1) {
            System.out.println("Insira o caminho relativo do arquivo (sem .dat): ");
            String nomeArquivo = in.nextLine();
            leArquivoEspacoNave(nomeArquivo);
            return;
        }
        if (escolha == 2) {
            System.out.println("Insira o caminho relativo do arquivo (sem .dat): ");
            String nomeArquivo = in.nextLine();
            leArquivoEspacoPorto(nomeArquivo);
            return;
        }
        if (escolha == 3) {
            System.out.println("Insira o caminho relativo do arquivo (sem .dat): ");
            String nomeArquivo = in.nextLine();
            leArquivoTransporte(nomeArquivo);
            return;
        }

        if (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("Opção Inválida.");
            return;
        }
    }

    public void leArquivoEspacoNave(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo + ".dat");
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = null;
            int tipo;
            String nome;
            int espacoPorto;
            double velMaxWarp;
            double velMaxImpulso;
            int qtdMaXPessoasOuCarga;
            String comb;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(":");
                tipo = Integer.parseInt(lines[0]);
                nome = lines[1];
                espacoPorto = Integer.parseInt(lines[2]);
                if (tipo == 1) {
                    velMaxImpulso = Double.parseDouble(lines[3]);
                    comb = lines[4];
                    Espaconave espaconave = new Subluz(tipo, nome, espacoPorto, velMaxImpulso, comb, null);
                    frota.cadastraEspNave(espaconave);
                    System.out.println(espaconave.toString());
                    System.out.println("Espaconave cadastrada!");
                } 
                else if (tipo == 2) {
                    velMaxWarp = Double.parseDouble(lines[3]);
                    qtdMaXPessoasOuCarga = Integer.parseInt(lines[4]);
                    Espaconave espaconave = new FTL(tipo, nome, espacoPorto, velMaxWarp, qtdMaXPessoasOuCarga, null);
                    frota.cadastraEspNave(espaconave);
                    System.out.println(espaconave.toString());
                    System.out.println("Espaconave cadastrada!");

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void leArquivoEspacoPorto(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo + ".dat");
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = null;
            int numero;
            String nome;
            double coordX;
            double coordY;
            double coordZ;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(":");
                numero = Integer.parseInt(lines[0]);
                nome = lines[1];
                coordX = Double.parseDouble(lines[2]);
                coordY = Double.parseDouble(lines[3]);
                coordZ = Double.parseDouble(lines[4]);

                EspacoPorto espacoPorto = new EspacoPorto(numero, nome, coordX, coordY, coordZ);
                frota.cadastraEspPorto(espacoPorto);
                System.out.println(espacoPorto.toString());
                System.out.println("Espaco-porto cadastrado!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void leArquivoTransporte(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo + ".dat");
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = null;
            int tipo;
            int identificador;
            int origem;
            int destino;
            double carga;
            int qtdMaxPessoasOuCarga;
            String descricao;

            EstadoTransporte estado;
            String espaconave;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(":");
                tipo = Integer.parseInt(lines[0]);
                identificador = Integer.parseInt(lines[1]);
                origem = Integer.parseInt(lines[2]);
                destino = Integer.parseInt(lines[3]);
                if (tipo == 1) {
                    qtdMaxPessoasOuCarga = Integer.parseInt(lines[4]);

                    Transporte transporte = new TransportePessoa(tipo, identificador, origem,
                            destino, frota.pesquEspacoPorto(origem), frota.pesquEspacoPorto(destino), EstadoTransporte.PENDENTE, null, qtdMaxPessoasOuCarga);
                    frota.cadastraTransp(transporte);
                    System.out.println(transporte.toString());
                    System.out.println("Transporte cadastrado!");
                }
                if (tipo == 2) {
                    carga = Double.parseDouble(lines[4]);
                    descricao = lines[5];

                    Transporte transporte = new TransporteMaterial(tipo, identificador, origem,
                            destino, frota.pesquEspacoPorto(origem), frota.pesquEspacoPorto(destino), EstadoTransporte.PENDENTE, null, carga, descricao);
                    frota.cadastraTransp(transporte);
                    System.out.println(transporte.toString());
                    System.out.println("Transporte cadastrado!");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void designaTransporte() {
        Queue<Transporte> transpPendentes = frota.mostraTransportes();
        ArrayList<Espaconave> navesDisponiveis = frota.espacoDisponiveis();
        if (transpPendentes.size() == 0 && navesDisponiveis.size() == 0) {
            System.out.println("Não há transportes na fila de transportes pendentes nem naves disponíveis na lista");
            return;
        } 
        else if (navesDisponiveis.size() == 0 ){
            System.out.println("Não há naves disponiveis na lista");
            return;
        }
        else if( transpPendentes.size() == 0 ) {
            System.out.println("Não há transportes na fila de transportes pendentes");
            return;
        }
        else {
                for (Espaconave espacoCad : navesDisponiveis) {
                    Transporte transpCad = transpPendentes.remove();

                        if (espacoCad instanceof FTL && transpCad instanceof TransporteMaterial) {
                            if (((FTL) espacoCad).getQtdMax() >= ((TransporteMaterial) transpCad).getCarga()) {
                                transpCad.setEstado(EstadoTransporte.TRANSPORTANDO);
                                frota.cadastraNaoPendentes(transpCad);
                                espacoCad.setTransporte(transpCad);
                                transpCad.setEspaconave(espacoCad);
                                System.out.println("Um transporte foi designado com sucesso!");
                            }
                            
                        } 
                        else if (espacoCad instanceof FTL && transpCad instanceof TransportePessoa) {
                            if (((FTL) espacoCad).getQtdMax() >= ((TransportePessoa) transpCad).getQtdPessoas()) {
                                transpCad.setEstado(EstadoTransporte.TRANSPORTANDO);
                                frota.cadastraNaoPendentes(transpCad);
                                espacoCad.setTransporte(transpCad);
                                transpCad.setEspaconave(espacoCad);
                                System.out.println("Um transporte foi designado com sucesso!");
                            }
                        } 
                        else {
                            transpCad.setEstado(EstadoTransporte.TRANSPORTANDO);
                            frota.cadastraNaoPendentes(transpCad);
                            frota.removeTransp(transpCad);
                            espacoCad.setTransporte(transpCad);
                            transpCad.setEspaconave(espacoCad);
                            System.out.println("Um transporte foi designado com sucesso!");
                        }
                }
            return;
        }
    }

    public void salvaArquivo() {
        try {
            System.out.println("Informe o nome do arquivo em que os dados serao salvos:");
            String nomeArquivo = in.nextLine();
            frota.salvaDadosArquivo(nomeArquivo);
        } catch (InputMismatchException e) {
            in.nextLine();
            System.err.println("Erro: entrada de dados incorreta.");
        }
    }
}
