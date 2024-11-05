public class Usuario {
    private String name;
    private float dabloons;

    public Usuario(int dabloons) {
        this.dabloons = dabloons;
    }

    public Usuario(int dabloons, String name) {
        this.dabloons = dabloons;
        this.name = name;
    }

    public float AdicionarPontos(float dabloons) {
        dabloons += dabloons;
        return dabloons;
    }

    public float RemoverPontos(float dabloons) {
        dabloons -= dabloons;
        return dabloons;
    }

    public float mostrarSaldo() {
        return dabloons;
    }
}
