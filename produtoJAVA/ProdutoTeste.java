public class ProdutoTeste {
    public static void main(String[] args) {
        Produto produto;

        produto = new Produto(120, "mouse", 50.20);
        produto.codigo = 120;
        produto.descricao = "mouse";
        produto.precoCusto = 50.20;
        produto.qtdeEmEstoque = 0;


        Produto(int codigo, String descricao, double precoCusto){
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
    }




        System.out.println("Codigo....:" + produto.codigo);
        System.out.println("Descricao....:" + produto.descricao);
        System.out.println("Preço....:" + produto.precoCusto);
        System.out.println("Estoque....:" + produto.qtdeEmEstoque);

        System.out.println("Tendo estoque = 0 , aumentando 15 unidades. Espero receber 15");
        int respostaObtida = produto.aumentarEstoque(15);
        mostrarMensagem( respostaObtida == 15);

    }
         static void mostrarMensagem(boolean teste){
	        final String ANSI_GREEN = "\u001B[32m";
	        final String ANSI_RED   = "\u001B[31m";
	        final String ANSI_RESET = "\u001B[0m";

	        System.out.println( (teste ? ANSI_GREEN : ANSI_RED) +
	        		            (teste ? "Passou": "Não passou") +
	        		             ANSI_RESET);
        }


    }
    

