import atividades.Atividade;

public class MaquinaWorkflow {

    public MaquinaWorkflow() {
    }

    public void executar(Workflow workflow) {
        for (Atividade atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }

}