
package br.eduardo.atv1edd;

import br.eduardo.atv1edd.models.Clinica;
import br.eduardo.atv1edd.models.Paciente;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Atv1EDD {

    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        int opcao = 0;

        do {
            String menu = "Menu:\n"
                    + "1 - Adicionar paciente\n"
                    + "2 - Chamar próximo paciente\n"
                    + "3 - Sair\n"
                    + "Escolha uma opção:";
            String input = JOptionPane.showInputDialog(null,
                    menu, "Sistema de Clínica", 
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
                    String nome = JOptionPane.showInputDialog(null,
                            "Informe o nome do paciente:", 
                            "Adicionar Paciente", 
                            JOptionPane.QUESTION_MESSAGE);
                    if (nome != null && !nome.trim().isEmpty()) {
                        if (clinica.adicionarPaciente(nome)) {
                            JOptionPane.showMessageDialog(null, 
                                    "Paciente adicionado à fila.", 
                                    "Sucesso", 
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "A fila está cheia. Não é possível "
                                            + "adicionar mais pacientes.", 
                                    "Erro", 
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, 
                                "Nome do paciente não pode ser vazio.", 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    Paciente proximoPaciente = clinica.chamarProximoPaciente();
                    if (proximoPaciente != null) {
                        JOptionPane.showMessageDialog(null, 
                                "Próximo paciente: " + proximoPaciente.getNome(),
                                "Chamar Paciente", 
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, 
                                "Não há pacientes na fila.", 
                                "Aviso", 
                                JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, 
                            "Saindo...", "Sistema de Clínica",
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
