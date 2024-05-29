
package br.eduardo.atv3edd;

import br.eduardo.atv3edd.models.Biblioteca;
import br.eduardo.atv3edd.models.Livro;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Atv3EDD {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcao = 0;

        do {
            String menu = "Menu:\n"
                    + "1 - Adicionar livro\n"
                    + "2 - Listar livros\n"
                    + "3 - Retirar livro\n"
                    + "4 - Sair\n"
                    + "Escolha uma opção:";
            String input = JOptionPane.showInputDialog(null, 
                    menu, "Sistema de Biblioteca", 
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
                    String titulo = JOptionPane.showInputDialog(null, 
                            "Informe o título do livro:", 
                            "Adicionar Livro", 
                            JOptionPane.QUESTION_MESSAGE);
                    if (titulo == null) {
                        break;
                    }
                    String autor = JOptionPane.showInputDialog(null, 
                            "Informe o autor do livro:", 
                            "Adicionar Livro", 
                            JOptionPane.QUESTION_MESSAGE);
                    if (autor == null) {
                        break;
                    }
                    Livro novoLivro = new Livro(titulo, autor);
                    biblioteca.adicionarLivro(novoLivro);
                    JOptionPane.showMessageDialog(null, 
                            "Livro adicionado à pilha.", 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    Livro livroRemovido = biblioteca.retirarLivro();
                    if (livroRemovido != null) {
                        JOptionPane.showMessageDialog(null,
                                "Livro removido:\n" + livroRemovido, 
                                "Livro Removido", 
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Saindo...", 
                            "Sistema de Biblioteca", 
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
