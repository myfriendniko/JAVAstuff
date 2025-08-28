public class Produto {
    private int codigo;
    private String descricao;
    private double precoCusto;
    private int qtdeEmEstoque;

    // Construtor
    public Produto(int codigo, String descricao, double precoCusto, int qtdeInicial) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.qtdeEmEstoque = qtdeInicial;
    }

    // Método para aumentar o estoque
    public int aumentarEstoque(int qtde) {
        qtdeEmEstoque += qtde;
        return qtdeEmEstoque;
    }

    // Método para baixar o estoque
    public int baixarEstoque(int qtde) {
        if (qtde <= qtdeEmEstoque) {
            qtdeEmEstoque -= qtde;
        } else {
            System.out.println("Quantidade solicitada maior que o estoque disponível.");
        }
        return qtdeEmEstoque;
    }

    // Método para calcular o valor total do estoque
    public double calcularValorEstoque() {
        return qtdeEmEstoque * precoCusto;
    }

    // Método para exibir a quantidade atual em estoque
    public int getQtdeEmEstoque() {
        return qtdeEmEstoque;
    }

    // Método para exibir os dados do produto
    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço de Custo: R$" + precoCusto);
        System.out.println("Quantidade em Estoque: " + qtdeEmEstoque);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Produto produto = new Produto(101, "Caneta Azul", 2.50, 15);

        produto.aumentarEstoque(5);     // Aumenta para 20
        produto.baixarEstoque(2);       // Reduz para 18

        System.out.println("Quantidade atual em estoque: " + produto.getQtdeEmEstoque());
        System.out.println("Valor total do estoque: R$" + produto.calcularValorEstoque());

        // Exibir todos os dados do produto
        System.out.println("\nDados do Produto:");
        produto.exibirDados();
    }
}
