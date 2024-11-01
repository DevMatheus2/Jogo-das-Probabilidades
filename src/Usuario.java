public class Usuario {
    private String name;
    private int dabloons;

    public Usuario(int dabloons) {
        this.dabloons = dabloons;
    }

    public Usuario(int dabloons, String name) {
        this.dabloons = dabloons;
        this.name = name;
    }

    public int AdicionarPontos(int dabloons) {
        dabloons += dabloons;
        return dabloons;
    }

    public int RemoverPontos(int dabloons) {
        dabloons -= dabloons;
        return dabloons;
    }

    public int mostrarSaldo() {
        return dabloons;
    }
}
