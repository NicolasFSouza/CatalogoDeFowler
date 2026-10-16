
public class ProcessadorDeVendas {

    private final CalculadoraDeFrete calculadoraDeFrete;
    private final ImpressoraDeRecibo impressoraDeRecibo;

    public ProcessadorDeVendas() {
        this.calculadoraDeFrete = new CalculadoraDeFrete();
        this.impressoraDeRecibo = new ImpressoraDeRecibo();
    }

    public void processar(Cliente cliente, Pedido pedido) {
        System.out.println("Iniciando processamento...");

        if (!cliente.documentoValido()) {
            System.out.println("Erro: Documento invalido.");
            return;
        }

        double frete = calculadoraDeFrete.calcular(cliente);

        impressoraDeRecibo.imprimir(cliente, pedido, frete);
    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "João Silva",
                "12345678901",
                "Rua das Flores, 123 - SP",
                TipoCliente.COMUM
        );

        double[] valores = {50.0, 150.0, 30.0};
        int[] quantidades = {2, 1, 3};

        Pedido pedido = new Pedido(valores, quantidades);

        ProcessadorDeVendas processador = new ProcessadorDeVendas();
        processador.processar(cliente, pedido);
    }
}
