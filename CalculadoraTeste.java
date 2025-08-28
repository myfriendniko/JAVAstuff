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
		
		
		System.out.println(" Subb 10 - 20 = 10");
			resposta = calc1.subtracao();
			System.out.println(resposta);
		
		
		System.out.println(" Multiplique 10 * 20 = 200");
			double resposta1 = calc1.multiplicacao();
			System.out.println(resposta1);
		
		System.out.println(" Divida 10 / 20 = 0.5");
			double resposta1 = calc1.divisao();
			System.out.println(resposta1);
		
		
		
		
		Calculadora calc2;
		
	
	
	
	}
	
	
}
