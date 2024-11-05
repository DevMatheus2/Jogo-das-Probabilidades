import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AppleGame {
    public HashMap<Integer, Boolean> macas;
    public List<Integer> macasPodres;
    public int quantMinhocas;
    public int macasEscolhidas = 0;
    public int valorInicial;

    public AppleGame(int quantMacas , int valorInicial, int quantMinhocas) {
        this.valorInicial = valorInicial;
        this.quantMinhocas = quantMinhocas;
        this.macas = new HashMap<Integer, Boolean>();
        this.macasPodres = new ArrayList<Integer>();
        iniciarMacas();
    }

    private void iniciarMacas() {
        for (int i = 1; i <= 16; i++) {
            macas.put(i, false);
        }
        macasPodres = escolherMacasPodres();
    }

    private List<Integer> escolherMacasPodres() {
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < quantMinhocas; i++) {
            int macaPodre = random.nextInt(macas.keySet().size());
            if (list.contains(macaPodre)) {
                i--;
                continue;
            } else {
                list.add(macaPodre);
            }
        }
        return list;
    }

    public int selecionarMaca(int macaNum) {
        if (macas.get(macaNum)) {
            return 0;
        }
        if (macasPodres.contains(macaNum)) {
            return -1;
        }

        macas.put(macaNum, true);
        macasEscolhidas++;

        return 1;
    }

    public String getMacasEscolhidas() {
        String macasEscolhidas = "";
        for (int i = 1; i <= macas.size(); i++) {
            if (macas.get(i)) {
                macasEscolhidas += i + " ";
            }
        }
        return macasEscolhidas;
    }

    public float calcularPontuacao(float valorInicial) {
        return valorInicial * ((float) (macas.size() - quantMinhocas) / (macas.size() - quantMinhocas - macasEscolhidas));
    }
}