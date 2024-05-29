package br.eduardo.atv5edd;

import br.eduardo.atv5edd.models.Deposito;
import br.eduardo.atv5edd.models.Produto;
import javax.swing.JOptionPane;

public class Atv5EDD {

    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        int opcao = 0;

        do {
            String menu = "Menu:\n"
                    + "1 - Adicionar produto\n"
                    + "2 - Listar produtos\n"
                    + "3 - Retirar produto\n"
                    + "4 - Sair\n"
                    + "Escolha uma opção:";
            String input = JOptionPane.showInputDialog(null,
                    menu, "Sistema de Depósito",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Opção inválida. Tente novamente.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                    String indicePilhaStr = JOptionPane.showInputDialog(
                            null, "Informe o índice da pilha"
                                    + " (1 a 5):", "Adicionar Produto",
                                    JOptionPane.QUESTION_MESSAGE);
                    if (indicePilhaStr == null) {
                        break;
                    }
                    int indicePilhaAdicionar = 
                            Integer.parseInt(indicePilhaStr) - 1;

                    String codProdutoStr = JOptionPane.showInputDialog(
                            null, "Informe o código do "
                                    + "produto:", "Adicionar Produto", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (codProdutoStr == null) {
                        break;
                    }
                    int codProduto = Integer.parseInt(codProdutoStr);

                    String descricao = JOptionPane.showInputDialog(
                            null, "Informe a descrição do"
                                    + " produto:", "Adicionar Produto", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (descricao == null) {
                        break;
                    }

                    String dataEntrada = JOptionPane.showInputDialog(
                            null, "Informe a data de entrada"
                                    + " do produto (dd/mm/aaaa):", 
                            "Adicionar Produto", 
                            JOptionPane.QUESTION_MESSAGE);
                    if (dataEntrada == null) {
                        break;
                    }

                    String ufOrigem = JOptionPane.showInputDialog(
                            null, "Informe a UF de origem do"
                                    + " produto:", "Adicionar Produto", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (ufOrigem == null) {
                        break;
                    }

                    String ufDestino = JOptionPane.showInputDialog(
                            null, "Informe a UF de destino do"
                                    + " produto:", "Adicionar Produto", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (ufDestino == null) {
                        break;
                    }

                    Produto novoProduto = new Produto(codProduto, descricao,
                            dataEntrada, ufOrigem, ufDestino);
                    if (deposito.adicionarProduto(indicePilhaAdicionar,
                            novoProduto)) {
                        JOptionPane.showMessageDialog(null, 
                                "Produto adicionado à pilha " + 
                                        (indicePilhaAdicionar + 1) + ".", 
                                "Sucesso", 
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A pilha " + (indicePilhaAdicionar + 1) + 
                                " está cheia. Não é possível adicionar "
                                + "mais produtos.", "Erro",
                                 JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Código do produto ou índice da pilha "
                                    + "inválido. Tente novamente.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
                case 2:
                    deposito.listarProdutos();
                    break;
                case 3:
                    try {
                    String indicePilhaStr = JOptionPane.showInputDialog(
                            null, "Informe o índice da pilha "
                                    + "(1 a 5):", "Retirar Produto",
                                    JOptionPane.QUESTION_MESSAGE);
                    if (indicePilhaStr == null) {
                        break;
                    }
                    int indicePilhaRetirar = 
                            Integer.parseInt(indicePilhaStr) - 1;

                    Produto produtoRemovido = deposito.retirarProduto(
                            indicePilhaRetirar);
                    if (produtoRemovido != null) {
                        JOptionPane.showMessageDialog(null, 
                                "Produto removido da pilha " +
                                (indicePilhaRetirar + 1) + ":\n" +
                                produtoRemovido, "Produto Removido",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Índice de pilha inválido. Tente novamente.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Saindo...", "Sistema de Depósito", 
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Opção inválida. Tente novamente.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 4);
    }
}
