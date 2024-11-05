import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Roleta {
    private Map<Integer, String> numerosECores;
    {
        numerosECores = new HashMap<>();
        numerosECores.put(0, "Verde");
        numerosECores.put(1, "Vermelho");
        numerosECores.put(2, "Preto");
        numerosECores.put(3, "Vermelho");
        numerosECores.put(4, "Preto");
        numerosECores.put(5, "Vermelho");
        numerosECores.put(6, "Preto");
        numerosECores.put(7, "Vermelho");
        numerosECores.put(8, "Preto");
        numerosECores.put(9, "Vermelho");
        numerosECores.put(10, "Preto");
        numerosECores.put(11, "Preto");
        numerosECores.put(12, "Vermelho");
        numerosECores.put(13, "Preto");
        numerosECores.put(14, "Vermelho");
        numerosECores.put(15, "Preto");
        numerosECores.put(16, "Vermelho");
        numerosECores.put(17, "Preto");
        numerosECores.put(18, "Vermelho");
        numerosECores.put(19, "Vermelho");
        numerosECores.put(20, "Preto");
        numerosECores.put(21, "Vermelho");
        numerosECores.put(22, "Preto");
        numerosECores.put(23, "Vermelho");
        numerosECores.put(24, "Preto");
        numerosECores.put(25, "Vermelho");
        numerosECores.put(26, "Preto");
        numerosECores.put(27, "Vermelho");
        numerosECores.put(28, "Preto");
        numerosECores.put(29, "Vermelho");
        numerosECores.put(30, "Preto");
        numerosECores.put(31, "Vermelho");
        numerosECores.put(32, "Preto");
        numerosECores.put(33, "Vermelho");
        numerosECores.put(34, "Preto");
        numerosECores.put(35, "Vermelho");
        numerosECores.put(36, "Preto");
    }
    private Random random;

    public Roleta() {
        this.random = new Random();
    }

    public int executarRoleta(int numDaSorte, boolean par, int valor){
        int recompensa = valor;
        int numSorteado = rodarRoleta();
        
        if(!(numSorteado % 2 == 0 ^ par)){
            recompensa *= 2;
            if(numDaSorte == numSorteado || numSorteado == 0) {
                recompensa *= 18;
            }
        } else {
            recompensa = 0;
            if(numDaSorte == numSorteado || numSorteado == 0) {
                recompensa += 18 * valor;
            }
        }
        return recompensa;
    }

    public int rodarRoleta() {
        int numAleatorio = this.random.nextInt(37) + 37;
        int i = 0;
        int numDaVez = 0;
        while(i < numAleatorio) {
            numDaVez = i % 37;
            escreverRoleta(numDaVez);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
            i++;
        }
        System.out.println("Número sorteado: " + numDaVez);
        return numDaVez;
    }
    
    public void escreverRoleta(int numDaVez){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int num : numerosECores.keySet()) {
            if(num == numDaVez) {
                System.out.print("vv ");
            } else {
                System.out.print("   ");
            }

        }
        System.out.println("");
        for (int num : numerosECores.keySet()) {
            System.out.printf("%02d ", num);
        }
        System.out.println("");
    }

    public int calcularPontuacao() {
        int pontos = random.nextInt(100);
        System.out.println("Pontuação calculada para a roleta: " + pontos);
        
        return pontos;
    }
}