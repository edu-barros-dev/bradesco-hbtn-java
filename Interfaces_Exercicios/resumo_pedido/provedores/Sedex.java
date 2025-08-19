package provedores;

public class Sedex implements ProvedorFrete {

    public Sedex() {
    }

    @Override
    public Frete calcularFrete(double peso, double valor) {

        if (peso > 1000) {
            return new Frete(valor * 0.1, obterTipoProvedorFrete());
        } else {
            return new Frete(valor * 0.05, obterTipoProvedorFrete());
        }

    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }

}