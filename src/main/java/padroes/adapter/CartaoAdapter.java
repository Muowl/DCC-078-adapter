package padroes.adapter;

public class CartaoAdapter implements GatewayPagamento {

    private final ServicoCartaoLegado servico;
    private final String numeroCartao;

    public CartaoAdapter(ServicoCartaoLegado servico, String numeroCartao) {
        this.servico = servico;
        this.numeroCartao = numeroCartao;
    }

    @Override
    public String pagar(String cliente, double valor) {
        int centavos = (int) Math.round(valor * 100);
        return cliente + ": " + servico.cobrarEmCentavos(numeroCartao, centavos);
    }
}
