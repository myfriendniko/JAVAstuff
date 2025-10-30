public class FoneOuvidoBluetooth {
  
    private String marca;
    private String modelo;
    private String cor;
    private int nivelBateria;
    private boolean conectado;
    private int volume;
    private boolean cancelamentoRuidoAtivo;
    
    public FoneOuvidoBluetooth() {
        this.nivelBateria = 100;
        this.conectado = false;
        this.volume = 50;
        this.cancelamentoRuidoAtivo = false;
    }
    
    public FoneOuvidoBluetooth(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.nivelBateria = 100;
        this.conectado = false;
        this.volume = 50;
        this.cancelamentoRuidoAtivo = false;
    }
    
    public boolean conectarDispositivo() {
        if (this.nivelBateria < 5) {
            return false;
        }
        if (this.conectado) {
            return false;
        }
        this.conectado = true;
        return true;
    }
    
    public double calcularAutonomia() {
        // Cada 1% de bateria = 30 minutos de reprodução
        double autonomiaMinutos = this.nivelBateria * 30.0;
        // Se cancelamento de ruído ativo, consumo aumenta 30%
        if (this.cancelamentoRuidoAtivo) {
            autonomiaMinutos = autonomiaMinutos * 0.70;
        }
        double autonomiaHoras = autonomiaMinutos / 60.0;
        return autonomiaHoras;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public int getNivelBateria() {
        return nivelBateria;
    }
    
    public void setNivelBateria(int nivelBateria) {
        if (nivelBateria >= 0 && nivelBateria <= 100) {
            this.nivelBateria = nivelBateria;
        }
    }
    
    public boolean isConectado() {
        return conectado;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        }
    }
    
    public boolean isCancelamentoRuidoAtivo() {
        return cancelamentoRuidoAtivo;
    }
    
    public void setCancelamentoRuidoAtivo(boolean cancelamentoRuidoAtivo) {
        this.cancelamentoRuidoAtivo = cancelamentoRuidoAtivo;
    }
}
