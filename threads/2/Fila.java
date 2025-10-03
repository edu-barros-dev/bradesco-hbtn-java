import java.util.LinkedList;

public class Fila {

    private LinkedList<Integer> fila;
    private int tamanhoMaximo;

    public Fila (int tamanhoMaximo) {
        this.fila = new LinkedList<>();
        this.tamanhoMaximo = tamanhoMaximo;
    }


    public synchronized void adicionar(int item) throws InterruptedException {

        while (fila.size() == tamanhoMaximo) {
            wait();
        }

        this.fila.add(item);
        System.out.println("Produtor adicionou: " + item);

        notifyAll();
    }


    public synchronized void retirar() throws InterruptedException {

        while (fila.isEmpty()) {
            wait();
        }

        int consumido = fila.removeFirst();
        System.out.println("Consumidor retirou: " + consumido);

        notifyAll();

    }

}