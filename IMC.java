import java.util.Scanner;
public class MassaCorporea {
	 double peso;
	 double altura;
	 double imc;
	 String situacao;
	 
	 
	 
	
public class AppMassaCorporea {
public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 // Declarando e instanciando um objeto da classe MassaCorporea
	 MassaCorporea mc = new MassaCorporea();
	 // Recebendo dados do teclado e armazenando em atributos no objeto mc
	 System.out.println("Peso..:");
	 mc.peso = input.nextDouble();
	 System.out.println("Altura:");
	 mc.altura = input.nextDouble();
	 // Chamando métodos do objeto mc
	 mc.calcularImc();
	 mc.definirSituacao();
	  // Exibindo atributos do objeto mc
	 System.out.printf("IMC.....: %.1f\n", mc.imc);
	 System.out.printf("Situação: %s\n", mc.situacao);
	 input.close();
	 }
	 }
	 
	 
	 
	 void calcularImc() {
	 imc = peso / (altura * altura);
	 }
	 void definirSituacao() {
	 if (imc<17) {
	 situacao="Muito abaixo do peso";
	 } 
	 else if (imc<18.5) {
	 situacao="Abaixo do peso";
	 }
	 else if (imc<25) {
	 situacao="Peso normal";
	 }
	 else if (imc<30) {
	 situacao="Acima do peso";
	 }
	 else if (imc<35) {
	 situacao="Obesidade grau 1";
	 }
	 else if (imc<=40) {
	 situacao="Obesidade grau 2";
	 }
	 else {
	 situacao="Obesidade grau 3";
	 }
	 }
	 

	 
	 
	 
	}

