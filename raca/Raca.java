public class Raca {


    private int idRaca;
    private String nome;
    private String especie;
    private String paisDeOrigem;
    private boolean riscoDeExtincao;



    public Raca(int idRaca, String nome, String especie, String paisDeOrigem) {
        this.idRaca = idRaca;
        this.nome = nome;
        this.especie = especie;
        this.paisDeOrigem = paisDeOrigem;
        this.riscoDeExtincao = false;


    }

    public int getIdRaca() {
        return idRaca;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public boolean isRiscoDeExtincao() {
        return riscoDeExtincao;
    }

    public boolean analisarExtincao(boolean c1, boolean c2, boolean c3, boolean c4) {
        int totalPontos = 0;

        if (c1) { 
            totalPontos += 1; 
        }
        if (c2) {
            totalPontos += 1; 
        }
        if (c3) {
            totalPontos += 2; 
        }
        if (c4) {
            totalPontos += 2; 
        }

       
        this.riscoDeExtincao = totalPontos >= 5;
        return this.riscoDeExtincao;
   
    }
}
