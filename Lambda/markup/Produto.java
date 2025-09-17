import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private Double preco;
    private String nome;
    private Double percentualMarkup;

    public Supplier<Double> precoComMarkup = () -> preco * (1 + percentualMarkup / 100);

    public Consumer<Double> atualizarMarkup = novoPercentual -> this.percentualMarkup = novoPercentual;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
        this.percentualMarkup = 10.0;
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

}