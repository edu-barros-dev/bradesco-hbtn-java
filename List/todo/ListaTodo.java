import java.util.ArrayList;

public class ListaTodo {

    ArrayList<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa (Tarefa tarefa) {

        if (tarefa.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }

        for (Tarefa t : tarefas) {
            if ((t.getIdentificador() == tarefa.getIdentificador()) || tarefa.getDescricao().trim().isEmpty()) {
                throw new IllegalArgumentException(String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador()));
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita (int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setEstahFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa (int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setEstahFeita(false);
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.setEstahFeita(false);
        }
    }

    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.setEstahFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String status = t.isEstahFeita() ? "[X]" : "[ ]";
            System.out.println(String.format("%s Id: %d - Descricao: %s", status, t.getIdentificador(), t.getDescricao()));
        }
    }

}