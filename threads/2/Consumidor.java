public class Consumidor extends Thread {
    private Fila fila;


    public Consumidor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                fila.retirar();
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}