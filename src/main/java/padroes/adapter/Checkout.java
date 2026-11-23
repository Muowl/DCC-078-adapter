package padroes.adapter;

public class Checkout {

    private final GatewayPagamento gateway;

    public Checkout(GatewayPagamento gateway) {
        this.gateway = gateway;
    }

    public String finalizarCompra(String cliente, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser positivo");
        }
        return gateway.pagar(cliente, valor);
    }
}
