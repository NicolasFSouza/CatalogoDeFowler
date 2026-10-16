public class Cliente {

    private final String nome;
    private final String documento;
    private final String endereco;
    private final TipoCliente tipo;

    public Cliente(String nome, String documento,
                   String endereco, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public boolean documentoValido() {
        return documento != null && documento.length() == 11;
    }
}
