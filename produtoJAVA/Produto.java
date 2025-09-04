public class Produto{

int codigo;
String descricao;
double precoCusto;
int qtdeEmEstoque;

int aumentarEstoque(int qtdeParaAumentar){
    qtdeEmEstoque += qtdeParaAumentar;
    return qtdeEmEstoque;
    }

int baixarEstoque(int qtdeParaBaixar){
    if (qtdeParaBaixar <= qtdeEmEstoque){
    qtdeEmEstoque -= qtdeParaBaixar;
    return qtdeEmEstoque;
    } 
    return -1;
    }


double calcularValorEstoque(){  
    return qtdeEmEstoque * precoCusto;
}    


}

