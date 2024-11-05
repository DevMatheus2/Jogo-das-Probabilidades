import java.util.Scanner;

public class Sistema {
    private Usuario usuario;
    private Roleta roleta;
    private Scanner scanner;

    public Sistema() {
        this.usuario = new Usuario(10000);
        this.roleta = new Roleta();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao sistema de jogos!");

        while (true) {
            exibirMenu();
            int opcao = lerInt("Escolha uma opção: ");
            
            switch (opcao) {
                case 1:
                    acessarRoleta();
                    break;
                case 2:
                    acessarJogoDasMacas();
                    break;
                case 3:
                    System.out.println("Saldo de dabloons: " + usuario.mostrarSaldo());
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n1 - Acessar a Roleta");
        System.out.println("2 - Acessar o Jogo das Maçãs");
        System.out.println("3 - Ver saldo de pontos");
        System.out.println("4 - Sair");
    }

    private void acessarRoleta() {
        System.out.println("Acessando a roleta...");
        int numDaSorte = lerInt("Escolha um número de 1 a 36: ");
        boolean isEven = lerInt("Escolha par ou impar (1 - PAR / 2 - IMPAR): ") == 1;
        int valor = lerInt("Digite o valor (MIN: 100): ");

        int resultado = roleta.executarRoleta(numDaSorte, isEven, valor);
        System.out.println("Recompensa: " + resultado);
    }

    private void acessarJogoDasMacas() {
        System.out.println("Acessando o jogo das maçãs...");
        
        int valorInicial = solicitarValorInicial();
        int quantMinhocas = solicitarQuantidadeMinhocas();
        
        AppleGame game = new AppleGame(16, valorInicial, quantMinhocas);

        while (true) {
            System.out.println("Escolha uma maçã de 1 a 16 (0 para sair): ");
            System.out.println("Maçãs escolhidas: " + game.getMacasEscolhidas());
            int macaNum = scanner.nextInt();
            
            if (macaNum == 0) {
                System.out.println("Você ganhou: " + game.calcularPontuacao(game.valorInicial));
                break;
            }

            int resultado = game.selecionarMaca(macaNum);

            if (resultado == 0) {
                System.out.println("Você já escolheu essa maçã. Tente novamente.");
            } else if (resultado == -1) {
                System.out.println("Você escolheu uma maçã podre! Fim de jogo.");
                break;
            } else {
                System.out.println("Maçã escolhida com sucesso!");
                System.out.println("Dabloons iniciais: " + game.valorInicial);
                System.out.println("Valor da recompensa: " + game.calcularPontuacao(game.valorInicial));
            }

            if (game.macasEscolhidas == game.macas.size() - game.quantMinhocas) {
                System.out.println("Você escolheu todas as maçãs. Fim de jogo.");
                System.out.println("Dabloons iniciais: " + game.valorInicial);
                System.out.println("Valor da recompensa: " + game.calcularPontuacao(game.valorInicial));
                break;
            }
        }
        usuario.AdicionarPontos(game.calcularPontuacao(game.valorInicial));
    }

    private int solicitarValorInicial() {
        while (true) {
            int valor = lerInt("Digite os dabloons iniciais: ");
            if (valor <= usuario.mostrarSaldo()) {
                usuario.RemoverPontos(valor);
                return valor;
            }
            System.out.println("Saldo insuficiente.");
        }
    }

    private int solicitarQuantidadeMinhocas() {
        while (true) {
            int quantMinhocas = lerInt("Digite a quantidade de minhocas (grid 16x16): ");
            if (quantMinhocas >= 1 && quantMinhocas <= 15) {
                return quantMinhocas;
            }
            System.out.println("Valor inválido.");
        }
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Tente novamente.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        new Sistema().iniciar();
    }
}
