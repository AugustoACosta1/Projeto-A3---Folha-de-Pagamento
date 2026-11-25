
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar colaborador");
            System.out.println("2 - Consultar colaboradores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("\nTIPO DE COLABORADOR");
                    System.out.println("1 - Padrao");
                    System.out.println("2 - Comissionado");
                    System.out.println("3 - Producao");
                    System.out.print("Escolha o tipo: ");

                    int tipo = entrada.nextInt();

                    System.out.print("Digite a matricula: ");
                    int matricula = entrada.nextInt();

                    entrada.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = entrada.nextLine();

                    if (matricula < 0) {
                        System.out.println("Matricula invalida!");
                        break;
                    }

                    switch (tipo) {

                        case 1:

                            ColaboradorPadrao padrao =
                                    new ColaboradorPadrao(matricula, nome);

                            colaboradores.add(padrao);

                            System.out.println("Colaborador cadastrado!");

                            break;

                        case 2:

                            System.out.print("Valor das vendas: ");
                            double valorVendas = entrada.nextDouble();

                            System.out.print("Percentual de comissao: ");
                            double percentualComissao = entrada.nextDouble();

                            if (valorVendas < 0 || percentualComissao < 0) {
                                System.out.println("Valores invalidos!");
                                break;
                            }

                            ColaboradorComissionado comissionado =
                                    new ColaboradorComissionado(
                                            matricula,
                                            nome,
                                            valorVendas,
                                            percentualComissao
                                    );

                            colaboradores.add(comissionado);

                            System.out.println("Colaborador cadastrado!");

                            break;

                        case 3:

                            System.out.print("Quantidade de pecas produzidas: ");
                            int quantidadePecas = entrada.nextInt();

                            System.out.print("Valor por peca: ");
                            double valorPorPeca = entrada.nextDouble();

                            if (quantidadePecas < 0 || valorPorPeca < 0) {
                                System.out.println("Valores invalidos!");
                                break;
                            }

                            ColaboradorProducao producao =
                                    new ColaboradorProducao(
                                            matricula,
                                            nome,
                                            quantidadePecas,
                                            valorPorPeca
                                    );

                            colaboradores.add(producao);

                            System.out.println("Colaborador cadastrado!");

                            break;

                        default:

                            System.out.println("Tipo invalido!");

                    }

                    break;

                case 2:

                    System.out.println("\n===== COLABORADORES CADASTRADOS =====");

                    if (colaboradores.isEmpty()) {

                        System.out.println("Nenhum colaborador cadastrado.");

                    } else {

                        for (Colaborador colaborador : colaboradores) {

                            System.out.println("\n-------------------------");

                            colaborador.exibirDados();

                        }
                    }

                    break;

                case 0:

                    System.out.println("Encerrando o sistema...");

                    break;

                default:

                    System.out.println("Opcao invalida!");

            }

        } while (opcao != 0);

        entrada.close();
    }
}
