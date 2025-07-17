
public class PersonagemGame {

    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame (int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        this.nome = nome;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {

        this.saudeAtual = saudeAtual;

        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome != "") {
            this.nome = nome;
        }
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
        this.saudeAtual = this.saudeAtual > 0 ? this.saudeAtual : 0;
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
        this.saudeAtual = this.saudeAtual < 100 ? this.saudeAtual : 100;
    }

}