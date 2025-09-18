public class RacaTeste {
    public static void main(String[] args) {
        System.out.println("Iniciando a avaliação de risco de extinção para diferentes raças:\n" + "=".repeat(50) + "\n");

        Raca dogBreed = new Raca(1, "Golden Retriever", "Canis lupus familiaris", "United Kingdom");
        Raca catBreed = new Raca(2, "Scottish Fold", "Felis catus", "Scotland");
        Raca horseBreed = new Raca(3, "Akhal-Teke", "Equus ferus caballus", "Turkmenistan");
        Raca rabbitBreed = new Raca(4, "Angora Rabbit", "Oryctolagus cuniculus", "Turkey");

        System.out.println(" Teste 1: Risco de extinção (pontos >= 5)");
        horseBreed.analisarExtincao(true, false, true, true); // Total points = 5
        System.out.println(horseBreed);

        System.out.println(" Teste 2: SEM risco de extinção (pontos < 5)");
        dogBreed.analisarExtincao(false, true, false, true); // Total points = 3
        System.out.println(dogBreed);

        System.out.println(" Teste 3: Risco de extinção (pontos >= 5)");
        catBreed.analisarExtincao(true, true, true, true); // Total points = 6
        System.out.println(catBreed);

        System.out.println("Teste 4: SEM risco de extinção (pontos < 5)");
        rabbitBreed.analisarExtincao(true, true, false, false); // Total points = 2
        System.out.println(rabbitBreed);
    }
}