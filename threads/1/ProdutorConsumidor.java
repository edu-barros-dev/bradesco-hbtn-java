public class ProdutorConsumidor {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();


        // Criar e iniciar as threads do produtor e consumidor

        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();

        // Esperar as threads terminarem
        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}