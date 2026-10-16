import java.util.Date;

public class ImpressoraDeRecibo {

    public void imprimir(Cliente cliente, Pedido pedido,
                         double frete) {

        System.out.println("=====================================");
        System.out.println("RECIBO DE VENDA");
        System.out.println("=====================================");
        System.out.println("Data: " + new Date());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Documento: " + cliente.getDocumento());
        System.out.println("-------------------------------------");
        System.out.printf("Subtotal Itens: R$ %.2f%n",
                pedido.calcularSubtotal());
        System.out.printf("Total Impostos: R$ %.2f%n",
                pedido.calcularImpostos());
        System.out.printf("Frete: R$ %.2f%n", frete);
        System.out.println("-------------------------------------");
        System.out.printf("TOTAL A PAGAR: R$ %.2f%n",
                pedido.calcularTotal(frete));
        System.out.println("=====================================");
    }
}
