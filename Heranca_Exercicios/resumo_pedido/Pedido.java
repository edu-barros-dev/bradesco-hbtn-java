public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        return total * (1 - percentualDesconto / 100);
    }

    public void apresentarResumoPedido() {

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            System.out.println(String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f",
                    item.getProduto().getClass().getSimpleName(),
                    item.getProduto().getTitulo(),
                    item.getProduto().obterPrecoLiquido(),
                    item.getQuantidade(),
                    item.getProduto().obterPrecoLiquido() * item.getQuantidade()));
        }
        System.out.println("----------------------------");
        System.out.println("DESCONTO: %.2f".formatted(
                (calcularTotal() / (1 - percentualDesconto / 100)) - calcularTotal()));
        System.out.println("TOTAL PRODUTOS: %.2f".formatted(calcularTotal() / (1 - percentualDesconto / 100)));
        System.out.println("----------------------------");
        System.out.println("TOTAL PEDIDO: %.2f".formatted(calcularTotal()));
    }

}