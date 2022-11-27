
public class Carta {
    String nome;
    Naipes naipe;
    boolean estaEmUso;

    public Carta(String nome, Naipes naipe){
        this.nome = nome;
        this.naipe = naipe;
        this.estaEmUso = false;
    }

    public String getNome() {
        return nome;
    }

    public Naipes getNaipe() {
        return naipe;
    }

    public void setNome(String nome) {
        this.nome =
                nome;
    }

    public void setNaipe(Naipes naipe) {
        this.naipe =
                naipe;
    }

    @Override
    public String toString() {
        return "Carta{" + "nome='" + nome + '\'' + ", naipe=" + naipe + '}';
    }
}
