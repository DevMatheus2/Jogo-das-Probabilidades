import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AppleGameTest {
    private AppleGame game;
    private int valorInicial = 100;
    private int quantMacas = 16;
    private int quantMinhocas = 4;

    @BeforeEach
    public void setUp() {
        game = new AppleGame(quantMacas, valorInicial, quantMinhocas);
    }

    @Test
    public void testSelecionarMaca_Success() {
        for (int i = 1; i <= quantMacas; i++) {
            if (!game.macasPodres.contains(i)) {
                int result = game.selecionarMaca(i);
                assertEquals(1, result);
                assertTrue(game.macas.get(i));
                return;
            }
        }
        fail("No non-rotten apples available for testing.");
    }

    @Test
    public void testSelecionarMaca_AlreadySelected() {
        for (int i = 1; i <= quantMacas; i++) {
            if (!game.macasPodres.contains(i)) {
                game.selecionarMaca(i);
                int result = game.selecionarMaca(i);
                assertEquals(0, result);
                return;
            }
        }
        fail("No non-rotten apples available for testing.");
    }

    @Test
    public void testSelecionarMaca_Rotten() {
        List<Integer> podres = game.macasPodres;
        if (!podres.isEmpty()) {
            int rottenApple = podres.get(0);
            int result = game.selecionarMaca(rottenApple);
            assertEquals(-1, result);
            assertFalse(game.macas.get(rottenApple));
        } else {
            fail("No rotten apples available for testing.");
        }
    }

    @Test
    public void testCalcularPontuacao() {
        game.macasEscolhidas = 1;
        float result = game.calcularPontuacao(valorInicial);
        assertEquals(109.09091186523438, result);
    }
}