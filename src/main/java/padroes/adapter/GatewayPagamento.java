package padroes.adapter;

public interface GatewayPagamento {

    String pagar(String cliente, double valor);
}
