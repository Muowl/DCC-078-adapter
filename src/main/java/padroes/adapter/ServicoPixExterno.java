package padroes.adapter;

public class ServicoPixExterno {

    public String enviar(String chaveRecebedor, String valorTexto) {
        return "Pix de R$ " + valorTexto + " enviado para a chave " + chaveRecebedor;
    }
}
