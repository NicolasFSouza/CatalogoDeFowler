
public class Pedido {

    private static final double LIMITE_PRECO_PRODUTO = 100.0;
    private static final double IMPOSTO_PRODUTO_CARO = 0.15;
    private static final double IMPOSTO_PRODUTO_BARATO = 0.05;

    private final double[] valores;
    private final int[] quantidades;

    public Pedido(double[] valores, int[] quantidades) {
        if (valores == null || quantidades == null
                || valores.length != quantidades.length) {
            throw new IllegalArgumentException(
                    "Valores e quantidades devem ser compatíveis.");
        }

        this.valores = valores.clone();
        this.quantidades = quantidades.clone();
    }

    public double calcularSubtotal() {
        double subtotal = 0;

        for (int i = 0; i < valores.length; i++) {
            subtotal += valores[i] * quantidades[i];
        }

        return subtotal;
    }

    public double calcularImpostos() {
        double impostos = 0;

        for (int i = 0; i < valores.length; i++) {
            double subtotalItem = valores[i] * quantidades[i];

            if (valores[i] > LIMITE_PRECO_PRODUTO) {
                impostos += subtotalItem * IMPOSTO_PRODUTO_CARO;
            } else {
                impostos += subtotalItem * IMPOSTO_PRODUTO_BARATO;
            }
        }

        return impostos;
    }

    public double calcularTotal(double frete) {
        return calcularSubtotal() + calcularImpostos() + frete;
    }
}
