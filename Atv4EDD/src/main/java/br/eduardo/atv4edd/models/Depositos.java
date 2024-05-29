package br.eduardo.atv4edd.models;

import javax.swing.JOptionPane;
import java.util.Stack;

public class Depositos {

    private Stack<Produto> pilhaDeProdutos;
    private static final int LIMITE = 10;

    public Depositos() {
        this.pilhaDeProdutos = new Stack<>();
    }

    public boolean adicionarProduto(Produto produto) {
        if (pilhaDeProdutos.size() < LIMITE) {
            pilhaDeProdutos.push(produto);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A pilha está cheia. Não é possível adicionar mais produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void listarProdutos() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de produtos está vazia.", "Produtos na Pilha", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder produtos = new StringBuilder("Produtos na pilha:\n");
            for (int i = pilhaDeProdutos.size() - 1; i >= 0; i--) {
                produtos.append(pilhaDeProdutos.get(i)).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, produtos.toString(), "Produtos na Pilha", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Produto retirarProduto() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de produtos está vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            return pilhaDeProdutos.pop();
        }
    }
}
