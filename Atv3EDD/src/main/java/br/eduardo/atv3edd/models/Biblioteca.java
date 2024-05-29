
package br.eduardo.atv3edd.models;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Biblioteca {

    private Stack<Livro> pilhaDeLivros;

    public Biblioteca() {
        this.pilhaDeLivros = new Stack<>();
    }

    public void adicionarLivro(Livro livro) {
        pilhaDeLivros.push(livro);
    }

    public void listarLivros() {
        if (pilhaDeLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "A pilha de livros está vazia.", 
                    "Livros na Pilha", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder livros = new StringBuilder("Livros na pilha:\n");
            for (int i = pilhaDeLivros.size() - 1; i >= 0; i--) {
                livros.append(pilhaDeLivros.get(i)).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, 
                    livros.toString(), "Livros na Pilha", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Livro retirarLivro() {
        if (pilhaDeLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "A pilha de livros está vazia.", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            return pilhaDeLivros.pop();
        }
    }
}
