
package br.eduardo.atv2edd.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class Banco {
    private Queue<Cliente> filaPrioritaria;
    private Queue<Cliente> filaNormal;
    private int contadorPrioritario;
    private Set<Integer> senhasUtilizadas;

    public Banco() {
        this.filaPrioritaria = new LinkedList<>();
        this.filaNormal = new LinkedList<>();
        this.contadorPrioritario = 0;
        this.senhasUtilizadas = new HashSet<>();
    }

    public void adicionarCliente(int senha, String nome, int anoNascimento, int anoAtual) {
        Cliente novoCliente = new Cliente(senha, nome, anoNascimento);
        if (senhasUtilizadas.contains(senha)) {
            return; // Não adiciona cliente se a senha já está em uso
        }
        senhasUtilizadas.add(senha);
        if (novoCliente.getIdade(anoAtual) >= 65) {
            filaPrioritaria.add(novoCliente);
        } else {
            filaNormal.add(novoCliente);
        }
    }

    public Cliente chamarCliente() {
        if (contadorPrioritario < 2 && !filaPrioritaria.isEmpty()) {
            contadorPrioritario++;
            return filaPrioritaria.poll();
        } else if (!filaNormal.isEmpty()) {
            contadorPrioritario = 0;
            return filaNormal.poll();
        } else if (!filaPrioritaria.isEmpty()) {
            return filaPrioritaria.poll();
        }
        return null;
    }

    public boolean senhaExistente(int senha) {
        return senhasUtilizadas.contains(senha);
    }
}
