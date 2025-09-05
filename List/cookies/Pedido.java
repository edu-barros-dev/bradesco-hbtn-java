import java.util.ArrayList;

public class Pedido {

    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<PedidoCookie>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        this.cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedidoCookie : this.cookies) {
            total += pedidoCookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int totalRemovidos = 0;
        ArrayList<PedidoCookie> cookiesParaRemover = new ArrayList<PedidoCookie>();

        for (PedidoCookie pedidoCookie : this.cookies) {
            if (pedidoCookie.getSabor().equals(sabor)) {
                totalRemovidos += pedidoCookie.getQuantidadeCaixas();
                cookiesParaRemover.add(pedidoCookie);
            }
        }

        this.cookies.removeAll(cookiesParaRemover);

        return totalRemovidos;
    }

}