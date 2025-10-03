public class SistemaFilas {

    public static void main(String[] args) {
        Fila fila = new Fila(10); // Tamanho maximo da fila


        // Criar e iniciar as threads do produtor e consumidor

        Produtor produtor = new Produtor(fila);
        Produtor produtor1 = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);
        Consumidor consumidor1 = new Consumidor(fila);

        produtor.start();
        consumidor.start();
        produtor1.start();
        consumidor1.start();

        try {
            Thread.sleep(20000); // Deixa o sistema rodar por 20 segundos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);

    }

}