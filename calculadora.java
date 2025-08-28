package calculadorabasica;

public class Calculadora {

	int operand1;
	int operand2;
	
	int adicao() {
		return operand1 + operand2;
	}
	int subtracao() {
		return operand1 - operand2;
	}
	double multiplicacao() {
		return (double) operand1 * operand2;
	}
	double divisao() {
		return (double) operand1 / operand2;
	}
}


