package calculadorabasica;

public class CalculadoraTeste {

	public static void main(String[] args) {
		
		
		
		Calculadora calc1 = new Calculadora();
		
		
		calc1.operand1 = 10;
		calc1.operand2 = 20;
		
		
		System.out.println(" Operando 1:" + calc1.operand1);
		System.out.println(" Operando 2:" + calc1.operand2);

		
		System.out.println(" Add 10+ 20 = 30");
			int resposta = calc1.adicao();
			System.out.println( "adicao " + resposta);
		mostrarMensagem(resposta == 30);
		
		System.out.println(" Subb 10 - 20 = 10");
			resposta = calc1.subtracao();
			System.out.println(resposta);
		mostrarMensagem(resposta == 10);
		
		System.out.println(" Multiplique 10 * 20 = 200");
			double resposta1 = calc1.multiplicacao();
			System.out.println(resposta1);
		mostrarMensagem(resposta1 == 200);
		
		System.out.println(" Divida 10 / 20 = 0.5");
			double resposta2 = calc1.divisao();
			System.out.println(resposta2);
		mostrarMensagem(resposta2 == 0.5);
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
	
