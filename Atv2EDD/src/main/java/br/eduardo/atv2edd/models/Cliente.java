
package br.eduardo.atv2edd.models;

public class Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getIdade(int anoAtual) {
        return anoAtual - anoNascimento;
    }
}
