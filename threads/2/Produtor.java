import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;


    public Produtor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            Random random = new Random();
            while (true) {
                int numero = random.nextInt(100) + 1; // Gera entre 1 e 100
                fila.adicionar(numero);  // O produtor coloca os itens no buffer
                Thread.sleep(1000);   // Simula o tempo para produzir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}