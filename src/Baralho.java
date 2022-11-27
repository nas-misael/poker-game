import java.util.Arrays;

public class Baralho {
    private Carta[] cartas = new Carta[52];

    public Baralho(){
        int cont = 0;
        Naipes[] naipes = {Naipes.COPAS, Naipes.PAUS, Naipes.OUROS, Naipes.ESPADAS};
        for(int i = 0; i < cartas.length; i++ ){
            if(cont == 0){
                String nome = verificaETransformaParaJQK(String.valueOf(i + 1));
                cartas[i] = new Carta(nome, naipes[cont]);
                if((i + 1) == 13) {
                    cont++;
                }
            } else {
                String nome = verificaETransformaParaJQK(String.valueOf((i + 1) - (cont * 13)));
                cartas[i] = new Carta(nome, naipes[cont]);
                if((i + 1) - (cont * 13) == 13) {
                    cont++;
                }
            }
            // System.out.println(cartas[i].toString());

        }
    }

    private String verificaETransformaParaJQK(String numero){
        switch (numero){
            case "11":
                return "J";
            case "12":
                return "Q";
            case "13":
                return "K";
            case "1":
                return "A";
            default:
                return numero;
        }
    }

    public void embaralha(){
        for(int i = 0; i < 25; i++){
            int indiceDoQueSeraAlterado = (int) Math.round(Math.random() * 51);
            int indiceDeOndeVai = (int) Math.round(Math.random() * 51);
            Carta cartaAlterada1 = cartas[indiceDoQueSeraAlterado];
            Carta cartaAlterada2 = cartas[indiceDeOndeVai];

            cartas[indiceDoQueSeraAlterado] = cartaAlterada2;
            cartas[indiceDeOndeVai] = cartaAlterada1;
        }
    }

    public Carta[] darCartas(){
        int cont = 0;
        Carta[] minhasCartas = new Carta[2];
        for(int i = 0; i < getCartas().length; i++){
            if(!(cartas[i].estaEmUso) && !(cartas[i].estaEmUso)){
                Carta carta = cartas[i];
                minhasCartas[cont] = carta;
                cont++;

                cartas[i].estaEmUso = true;
                cartas[i].estaEmUso = true;

                if(cont == 2){
                    break;
                }
            }

        }

        return minhasCartas;
    }

    public void imprimirCartas(){
        int contador = 0;

        // imprimeBaralho();
        System.out.println("----------------------");
        System.out.println("***** Cartas Na Mesa *****");
        for(int i = 0; i < getCartas().length; i++){
            if(!(getCartas()[i].estaEmUso)){
                System.out.println("| "+ getCartas()[i].getNome() + " de " + getCartas()[i].getNaipe() + " |");
                contador++;
                if(contador == 5){
                    break;
                }
            }
        }
    }

    public boolean temCarta(){
        boolean temCartaAinda = false;
        for(int i = 0; i < getCartas().length; i++){
            if(cartas[i].nome != null && cartas[i].nome != null){
                temCartaAinda = true;
            }
        }

        return temCartaAinda;
    }


    public void imprimeBaralho(){
        String baralho = "**** Baralho **** \n";
        for(int i = 0; i < cartas.length; i++){
            baralho += "| Carta: " + cartas[i].nome + " | Naipe: " + cartas[i].naipe + " | \n";
        }
        System.out.println(baralho);
    }

    public Carta[] getCartas() {
        return cartas;
    }

    @Override
    public String toString() {
        return "Baralho{" + "cartas=" + Arrays.toString(cartas) + '}';
    }
}
