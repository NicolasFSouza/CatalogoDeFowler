
public class CalculadoraDeFrete {

    private static final double FRETE_GRATIS = 0.0;
    private static final double FRETE_REGIAO_PROXIMA = 15.0;
    private static final double FRETE_REGIAO_DISTANTE = 50.0;

    private static final String ESTADO_SP = "SP";
    private static final String ESTADO_RJ = "RJ";
    private static final String ESTADO_MG = "MG";

    public double calcular(Cliente cliente) {

        if (cliente.getTipo() == TipoCliente.VIP) {
            return FRETE_GRATIS;
        }

        String endereco = cliente.getEndereco();

        if (cliente.getTipo() == TipoCliente.COMUM
                && (endereco.contains(ESTADO_SP)
                || endereco.contains(ESTADO_RJ)
                || endereco.contains(ESTADO_MG))) {
            return FRETE_REGIAO_PROXIMA;
        }

        return FRETE_REGIAO_DISTANTE;
    }
}
