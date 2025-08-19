package provedores;

public class JadLog implements ProvedorFrete {

    public JadLog() {
    }

    @Override
    public Frete calcularFrete(double peso, double valor) {

        if (peso > 2000) {
            return new Frete(valor * 0.07, obterTipoProvedorFrete());
        } else {
            return new Frete(valor * 0.045, obterTipoProvedorFrete());
        }

    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

}