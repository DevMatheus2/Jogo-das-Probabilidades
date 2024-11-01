import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AppleGame {
    public HashMap<Integer, Boolean> macas;
    public ArrayList<Integer> macasPodres;
    public int quantMinhocas;
    public int macasEscolhidas = 0;
    public float multiplicador;
    public int valorInicial;

    public AppleGame(int quantMacas , int valorInicial, int quantMinhocas) {
        this.valorInicial = valorInicial;
        this.quantMinhocas = quantMinhocas;
        this.macas = new HashMap<Integer, Boolean>();
        this.macasPodres = new ArrayList<Integer>();
        iniciarMacas();
        this.multiplicador = (float) (macas.size() - quantMinhocas) / (macas.size() - quantMinhocas - macasEscolhidas);
    }

    private void iniciarMacas() {
        for (int i = 1; i <= 16; i++) {
            macas.put(i, false);
        }
        escolherMacasPodres();
    }

    private void escolherMacasPodres() {
        Random random = new Random();
        for (int i = 0; i < quantMinhocas; i++) {
            int macaPodre = random.nextInt(macas.keySet().size());
            if (macasPodres.contains(macaPodre)) {
                i--;
                continue;
            } else {
                macasPodres.add(macaPodre);
            }
        }
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
        setMultiplicador();

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

    public int calcularPontuacao() {
        int pontos = (int) ((int) valorInicial * multiplicador);

        return pontos;
    }

    public void setMultiplicador() {
        this.multiplicador = (float) (macas.size() - quantMinhocas) / (macas.size() - quantMinhocas - macasEscolhidas);
    }
}