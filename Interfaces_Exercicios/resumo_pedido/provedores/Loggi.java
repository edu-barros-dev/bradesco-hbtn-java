package provedores;

public class Loggi implements ProvedorFrete {

    public Loggi() {
    }

    @Override
    public Frete calcularFrete(double peso, double valor) {

        if (peso > 5000) {
            return new Frete(valor * 0.12, obterTipoProvedorFrete());
        } else {
            return new Frete(valor * 0.04, obterTipoProvedorFrete());
        }

    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }

}