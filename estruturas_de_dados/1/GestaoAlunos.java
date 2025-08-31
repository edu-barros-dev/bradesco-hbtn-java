import java.util.ArrayList;

public class GestaoAlunos {

    ArrayList<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
    }

    public void excluirAluno(String nome) {

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                alunos.remove(aluno);
            }
        }

    }

    public void buscarAluno(String nome) {

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.println(aluno);
            }
        }

    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

}