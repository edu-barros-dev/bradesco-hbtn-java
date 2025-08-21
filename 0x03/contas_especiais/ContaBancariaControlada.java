import exceptions.OperacaoInvalidaException;

public class ContaBancariaControlada extends ContaBancariaBasica {

    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {

        super.aplicarAtualizacaoMensal();

        if (getSaldo() < this.saldoMinimo) {
            try {
                super.sacar(valorPenalidade);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro ao aplicar penalidade: " + e.getMessage());
            }
        }

    }

}