import java.util.Map;

public class Armazem <T> implements Armazenavel<T> {

    private Map<String, T> inventario;

    public Armazem() {
        this.inventario = new java.util.HashMap<>();
    }

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        this.inventario.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}