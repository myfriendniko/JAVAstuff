public class TesteFoneOuvidoBluetooth {
    
    public static void main(String[] args) {
        System.out.println("========== TESTE FONE DE OUVIDO BLUETOOTH ==========\n");
        
        // Teste 1: Construtor padrão
        System.out.println("--- TESTE 1: Construtor Padrão ---");
        FoneOuvidoBluetooth fone1 = new FoneOuvidoBluetooth();
        exibirEstado(fone1);
        
        // Teste 2: Construtor com parâmetros
        System.out.println("\n--- TESTE 2: Construtor com Parâmetros ---");
        FoneOuvidoBluetooth fone2 = new FoneOuvidoBluetooth("Sony", "WH-1000XM5", "Preto");
        exibirEstado(fone2);
        
        // Teste 3: Conectar dispositivo com bateria OK
        System.out.println("\n--- TESTE 3: Conectar Dispositivo ---");
        boolean conectou = fone2.conectarDispositivo();
        System.out.println("Tentativa de conexão: " + (conectou ? "✓ Sucesso" : "✗ Falhou"));
        System.out.println("Status conexão: " + (fone2.isConectado() ? "Conectado" : "Desconectado"));
        
        // Teste 4: Tentar conectar novamente (já conectado)
        System.out.println("\n--- TESTE 4: Tentar Conectar Novamente ---");
        boolean conectouNovamente = fone2.conectarDispositivo();
        System.out.println("Tentativa de conexão: " + (conectouNovamente ? "✓ Sucesso" : "✗ Falhou (já conectado)"));
        
        // Teste 5: Ajustar volume
        System.out.println("\n--- TESTE 5: Ajustar Volume ---");
        System.out.println("Volume inicial: " + fone2.getVolume());
        fone2.setVolume(75);
        System.out.println("Volume após ajuste: " + fone2.getVolume());
        fone2.setVolume(150); // Valor inválido
        System.out.println("Volume após valor inválido (150): " + fone2.getVolume() + " (deve permanecer 75)");
        
        // Teste 6: Calcular autonomia sem cancelamento de ruído
        System.out.println("\n--- TESTE 6: Autonomia sem Cancelamento de Ruído ---");
        double autonomia = fone2.calcularAutonomia();
        System.out.println("Bateria: " + fone2.getNivelBateria() + "%");
        System.out.println("Cancelamento de ruído: " + (fone2.isCancelamentoRuidoAtivo() ? "Ativo" : "Inativo"));
        System.out.printf("Autonomia: %.2f horas (%.0f minutos)\n", autonomia, autonomia * 60);
        
        // Teste 7: Ativar cancelamento de ruído e recalcular
        System.out.println("\n--- TESTE 7: Autonomia com Cancelamento de Ruído ---");
        fone2.setCancelamentoRuidoAtivo(true);
        autonomia = fone2.calcularAutonomia();
        System.out.println("Bateria: " + fone2.getNivelBateria() + "%");
        System.out.println("Cancelamento de ruído: " + (fone2.isCancelamentoRuidoAtivo() ? "Ativo" : "Inativo"));
        System.out.printf("Autonomia: %.2f horas (%.0f minutos)\n", autonomia, autonomia * 60);
        
        // Teste 8: Bateria baixa
        System.out.println("\n--- TESTE 8: Conexão com Bateria Baixa ---");
        FoneOuvidoBluetooth fone3 = new FoneOuvidoBluetooth("JBL", "Tune 510BT", "Azul");
        fone3.setNivelBateria(3);
        System.out.println("Bateria: " + fone3.getNivelBateria() + "%");
        boolean conectouBateriaFraca = fone3.conectarDispositivo();
        System.out.println("Tentativa de conexão: " + (conectouBateriaFraca ? "✓ Sucesso" : "✗ Falhou (bateria insuficiente)"));
        
        // Teste 9: Diferentes níveis de bateria
        System.out.println("\n--- TESTE 9: Autonomia em Diferentes Níveis ---");
        int[] niveis = {100, 75, 50, 25, 10};
        for (int nivel : niveis) {
            fone3.setNivelBateria(nivel);
            fone3.setCancelamentoRuidoAtivo(false);
            double autoSemNC = fone3.calcularAutonomia();
            fone3.setCancelamentoRuidoAtivo(true);
            double autoComNC = fone3.calcularAutonomia();
            System.out.printf("Bateria %d%% -> Sem NC: %.1fh | Com NC: %.1fh\n", 
                nivel, autoSemNC, autoComNC);
        }
        
        // Teste 10: Testar setters
        System.out.println("\n--- TESTE 10: Modificar Atributos ---");
        fone2.setMarca("Bose");
        fone2.setModelo("QuietComfort 45");
        fone2.setCor("Branco");
        System.out.println("Nova marca: " + fone2.getMarca());
        System.out.println("Novo modelo: " + fone2.getModelo());
        System.out.println("Nova cor: " + fone2.getCor());
        
        System.out.println("\n========== TESTES CONCLUÍDOS ==========");
    }
    
    private static void exibirEstado(FoneOuvidoBluetooth fone) {
        System.out.println("Marca: " + fone.getMarca());
        System.out.println("Modelo: " + fone.getModelo());
        System.out.println("Cor: " + fone.getCor());
        System.out.println("Bateria: " + fone.getNivelBateria() + "%");
        System.out.println("Conectado: " + (fone.isConectado() ? "Sim" : "Não"));
        System.out.println("Volume: " + fone.getVolume());
        System.out.println("Cancelamento de ruído: " + (fone.isCancelamentoRuidoAtivo() ? "Ativo" : "Inativo"));
    }
}
