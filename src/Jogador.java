
import java.util.Arrays;

public class Jogador {
    String nome;
    Carta minhasCartas[];
    double meuDinheiro;
    double minhaUltimaAposta;
    boolean foiRemovido;

    public Jogador(String nome){
        this.nome = nome;
        this.minhasCartas = new Carta[2];
        this.meuDinheiro = 5000;
        this.foiRemovido = false;
        this.minhaUltimaAposta = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public Carta[] getMinhasCartas() {
        return minhasCartas;
    }

    public void setMinhasCartas(Carta[] minhasCartas) {
        this.minhasCartas =
                minhasCartas;
    }

    public void setMeuDinheiro(double meuDinheiro) {
        this.meuDinheiro =
                meuDinheiro;
    }

    public double getMeuDinheiro() {
        return meuDinheiro;
    }

    public double getMinhaUltimaAposta() {
        return minhaUltimaAposta;
    }

    public void setMinhaUltimaAposta(double minhaUltimaAposta) {
        this.minhaUltimaAposta =
                minhaUltimaAposta;
    }

    @Override
    public String toString() {
        return "Jogador{" + "nome='" + nome + '\'' + ", minhasCartas=" + Arrays.toString(minhasCartas) + '}';
    }
}
