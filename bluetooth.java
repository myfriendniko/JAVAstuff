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

public FoneOuvidoBluetooth(String marca, String modelo, String cor) { this.marca = marca; 
this.modelo = modelo; 
this.cor = cor; 
this.nivelBateria = 100; 
this.conectado = false; 
this.volume = 50;
this.volume = 50; 
this.cancelamentoRuidoAtivo = false; 
} 

public boolean conectarDispositivo() { 
if (this.nivelBateria < 5) { 
System.out.println("Bateria insuficiente para conectar."); return false; 
} 
if (this.conectado) { 
System.out.println("Fone já está conectado."); 
return true; 
} 
this.conectado = true; 
System.out.println("Fone conectado com sucesso!"); return true; 
} 

public double calcularAutonomia() { 

double autonomiaMinutos = this.nivelBateria * 30.0; 

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
public void setNivelBateria(int nivelBateria) { 
if (nivelBateria >= 0 && nivelBateria <= 100) { 
this.nivelBateria = nivelBateria; 
} else { 
System.out.println("Nível inválido (0-100)."); 
} 
} 
public boolean isConectado() { 
return conectado; 
} 
public void setConectado(boolean conectado) { 
this.conectado = conectado; 
} 
public int getVolume() { 
return volume; 
} 
public void setVolume(int volume) { 
if (volume >= 0 && volume <= 100) { 
this.volume = volume; 
} else { 
System.out.println("Volume inválido (0-100)."); 
} 
} 
public boolean isCancelamentoRuidoAtivo() { 
return cancelamentoRuidoAtivo; 
} 
public void setCancelamentoRuidoAtivo(boolean cancelamentoRuidoAtivo) { this.cancelamentoRuidoAtivo = cancelamentoRuidoAtivo; 
} 
}


