

import java.util.Scanner;

public class TesteFoneOuvidoBluetooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


                        //fones instanciados
        FoneOuvidoBluetooth fone1 = new FoneOuvidoBluetooth("sony", "sad4", "preto");
        FoneOuvidoBluetooth fone2 = new FoneOuvidoBluetooth("JBL", "TB32T", "Branco");



                        // conectar fones
        System.out.println("=== SISTEMA DE FONES BLUETOOTH ===");
        System.out.println("Qual fone deseja conectar? (1 ou 2)");
        int opcao = sc.nextInt();

        FoneOuvidoBluetooth foneEscolhido;
        if (opcao == 1) {
            foneEscolhido = fone1;
        } else if (opcao == 2) {
            foneEscolhido = fone2;
        } else {
            System.out.println("opcao invalida");
            sc.close();
            return;
        }

                        // verifica conexao
        if (foneEscolhido.isConectado()) {
            System.out.println("O dispositivo ja esta conectado.");
        } else {
            boolean conectado = foneEscolhido.conectarDispositivo();
            if (conectado) {
                System.out.println("dispositivo conectado");
            } else {
                System.out.println("falha ao conectar o dispositivo.");
            }
        }

                         // mostra status dos dois fones 
        System.out.println("\n=== STATUS DOS FONES ===");
        
        System.out.println("Fone 1 (" + fone1.getMarca() + "): Bateria " + fone1.getNivelBateria() + "% " +
                (fone1.isConectado() ? "Conectado" : "Não conectado"));

        System.out.println("Fone 2 (" + fone2.getMarca() + "): Bateria " + fone2.getNivelBateria() + "%" +
                (fone2.isConectado() ? "Conectado" : "Não conectado"));

        sc.close();
    }
}































    
  