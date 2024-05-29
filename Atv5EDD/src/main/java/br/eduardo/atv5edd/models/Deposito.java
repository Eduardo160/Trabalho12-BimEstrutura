package br.eduardo.atv5edd.models;

import javax.swing.JOptionPane;
import java.util.Stack;

public class Deposito {

    private Stack<Produto>[] pilhasDeProdutos;
    private static final int LIMITE = 10;
    private static final int NUMERO_DE_PILHAS = 5;

    public Deposito() {
        pilhasDeProdutos = new Stack[NUMERO_DE_PILHAS];
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            pilhasDeProdutos[i] = new Stack<>();
        }
    }

    public boolean adicionarProduto(int indicePilha, Produto produto) {
        if (indicePilha < 0 || indicePilha >= NUMERO_DE_PILHAS) {
            JOptionPane.showMessageDialog(null,
                    "Índice de pilha inválido.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (pilhasDeProdutos[indicePilha].size() < LIMITE) {
            pilhasDeProdutos[indicePilha].push(produto);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A pilha " +
                    (indicePilha + 1) + " está cheia. Não é possível adicionar"
                            + " mais produtos.", "Erro", 
                            JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void listarProdutos() {
        StringBuilder produtos = new StringBuilder();
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            produtos.append("Pilha ").append(i + 1).append(":\n");
            if (pilhasDeProdutos[i].isEmpty()) {
                produtos.append("  A pilha está vazia.\n");
            } else {
                for (int j = pilhasDeProdutos[i].size() - 1; j >= 0; j--) {
                    produtos.append("  ").
                            append(pilhasDeProdutos[i].
                                    get(j)).append("\n");
                }
            }
            produtos.append("\n");
        }
        JOptionPane.showMessageDialog(null, 
                produtos.toString(), "Produtos na Pilha", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    public Produto retirarProduto(int indicePilha) {
        if (indicePilha < 0 || indicePilha >= NUMERO_DE_PILHAS) {
            JOptionPane.showMessageDialog(null,
                    "Índice de pilha inválido.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (pilhasDeProdutos[indicePilha].isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha " +
                    (indicePilha + 1) + " está vazia.", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            return pilhasDeProdutos[indicePilha].pop();
        }
    }
}
