package padroes.adapter;

import java.util.Locale;

public class PixAdapter implements GatewayPagamento {

    private final ServicoPixExterno servico;
    private final String chaveRecebedor;

    public PixAdapter(ServicoPixExterno servico, String chaveRecebedor) {
        this.servico = servico;
        this.chaveRecebedor = chaveRecebedor;
    }

    @Override
    public String pagar(String cliente, double valor) {
        String valorTexto = String.format(Locale.US, "%.2f", valor);
        return cliente + ": " + servico.enviar(chaveRecebedor, valorTexto);
    }
}
