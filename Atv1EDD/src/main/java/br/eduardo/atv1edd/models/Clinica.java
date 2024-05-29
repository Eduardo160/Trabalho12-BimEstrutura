
package br.eduardo.atv1edd.models;

import java.util.LinkedList;
import java.util.Queue;

public class Clinica {
    private Queue<Paciente> filaPacientes;

    public Clinica() {
        this.filaPacientes = new LinkedList<>();
    }

    public boolean adicionarPaciente(String nome) {
        if (filaPacientes.size() < 20) {
            Paciente novoPaciente = new Paciente(nome);
            filaPacientes.add(novoPaciente);
            return true;
        } else {
            return false;
        }
    }

    public Paciente chamarProximoPaciente() {
        return filaPacientes.poll();
    }
}
