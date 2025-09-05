import java.util.Objects;

public class Autor implements Comparable {

    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Object o) {
        Autor outro = (Autor) o;
        int cmp = nome.compareTo(outro.nome);
        if (cmp != 0) return cmp;
        return sobrenome.compareTo(outro.sobrenome);
    }

}