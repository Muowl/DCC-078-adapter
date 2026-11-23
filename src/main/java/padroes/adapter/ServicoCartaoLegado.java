package padroes.adapter;

public class ServicoCartaoLegado {

    public String cobrarEmCentavos(String numeroCartao, int centavos) {
        String finalCartao = numeroCartao.substring(numeroCartao.length() - 4);
        return "Cobrança de " + centavos + " centavos no cartão final " + finalCartao;
    }
}
