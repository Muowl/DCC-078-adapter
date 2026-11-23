package padroes.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckoutTest {

    @Test
    void devePagarComCartaoAdaptandoValorParaCentavos() {
        Checkout checkout = new Checkout(
                new CartaoAdapter(new ServicoCartaoLegado(), "4111111111111234"));

        assertEquals("Ana: Cobrança de 15090 centavos no cartão final 1234",
                checkout.finalizarCompra("Ana", 150.90));
    }

    @Test
    void devePagarComPixAdaptandoValorParaTexto() {
        Checkout checkout = new Checkout(
                new PixAdapter(new ServicoPixExterno(), "loja@exemplo.com"));

        assertEquals("Bruno: Pix de R$ 80.50 enviado para a chave loja@exemplo.com",
                checkout.finalizarCompra("Bruno", 80.5));
    }

    @Test
    void deveArredondarCentavosCorretamente() {
        Checkout checkout = new Checkout(
                new CartaoAdapter(new ServicoCartaoLegado(), "4111111111119999"));

        assertEquals("Ana: Cobrança de 1999 centavos no cartão final 9999",
                checkout.finalizarCompra("Ana", 19.99));
    }

    @Test
    void deveRejeitarValorNaoPositivo() {
        Checkout checkout = new Checkout(
                new PixAdapter(new ServicoPixExterno(), "loja@exemplo.com"));

        assertThrows(IllegalArgumentException.class, () -> checkout.finalizarCompra("Ana", 0));
    }
}
