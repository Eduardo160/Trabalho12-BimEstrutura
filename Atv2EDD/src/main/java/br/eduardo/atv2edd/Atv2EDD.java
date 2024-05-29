
package br.eduardo.atv2edd;

import br.eduardo.atv2edd.models.Banco;
import br.eduardo.atv2edd.models.Cliente;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Atv2EDD {

    public static void main(String[] args) {
        Banco banco = new Banco();
        int opcao = 0;
        int anoAtual = 2024;

        do {
            String menu = "Menu:\n"
                    + "1 - Adicionar cliente\n"
                    + "2 - Chamar próximo cliente\n"
                    + "3 - Sair\n"
                    + "Escolha uma opção:";
            String input = JOptionPane.showInputDialog(null,
                    menu, "Sistema de Banco", 
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
                    String senhaStr = JOptionPane.showInputDialog(
                            null, "Informe a senha do"
                                    + " cliente:", "Adicionar Cliente", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (senhaStr == null) {
                        break;
                    }
                    int senha;
                    try {
                        senha = Integer.parseInt(senhaStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, 
                                "Senha inválida. Tente novamente.", 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if (banco.senhaExistente(senha)) {
                        JOptionPane.showMessageDialog(null, 
                                "A senha já está em uso. Escolha outra"
                                        + " senha.", "Erro", 
                                        JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String nome = JOptionPane.showInputDialog(null, 
                            "Informe o nome do cliente:", 
                            "Adicionar Cliente", 
                            JOptionPane.QUESTION_MESSAGE);
                    if (nome == null) {
                        break;
                    }
                    String anoNascimentoStr = JOptionPane.showInputDialog(
                            null, "Informe o ano de nascimento"
                                    + " do cliente:", "Adicionar Cliente", 
                                    JOptionPane.QUESTION_MESSAGE);
                    if (anoNascimentoStr == null) {
                        break; 
                    }
                    int anoNascimento;
                    try {
                        anoNascimento = Integer.parseInt(anoNascimentoStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, 
                                "Ano de nascimento inválido. Tente "
                                        + "novamente.", "Erro", 
                                        JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    banco.adicionarCliente(senha, nome, anoNascimento, anoAtual);
                    JOptionPane.showMessageDialog(null, 
                            "Cliente adicionado à fila.", 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    Cliente proximoCliente = banco.chamarCliente();
                    if (proximoCliente != null) {
                        String clienteInfo = "Próximo cliente:\n"
                                + "Nome: " + proximoCliente.getNome() + "\n"
                                + "Senha: " + proximoCliente.getSenha() + "\n"
                                + "Ano de Nascimento: " + 
                                proximoCliente.getAnoNascimento() + "\n"
                                + "Idade: " + proximoCliente.getIdade(anoAtual);
                        JOptionPane.showMessageDialog(null, 
                                clienteInfo, "Chamar Cliente", 
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, 
                                "Não há clientes na fila.", "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, 
                            "Saindo...", "Sistema de Banco", 
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Opção inválida. Tente novamente.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 3);
    }
}
