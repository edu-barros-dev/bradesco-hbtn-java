import atividades.Atividade;
import java.util.ArrayList;

public class Workflow {

    private final ArrayList<Atividade> atividades;

    public Workflow() {
        this.atividades = new ArrayList<Atividade>();
    }

    public void registrarAtividade (Atividade atividade) {
        this.atividades.add(atividade);
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }
}