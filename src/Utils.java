
public class Utils {

    public void mostrarMaos(Jogador[] jogadores){
        for(int i = 0; i < jogadores.length; i++){
            if(!(jogadores[i].foiRemovido)){
                System.out.println("Jogador: " + jogadores[i].nome);
                String carta1 = jogadores[i].getMinhasCartas()[0].nome + " de " + jogadores[i].getMinhasCartas()[0].naipe + " | ";
                String carta2 = jogadores[i].getMinhasCartas()[1].nome + " de " + jogadores[i].getMinhasCartas()[1].naipe;
                System.out.println("Suas cartas são: " + carta1 + carta2 + "\n");
                System.out.println("Seu dinheiro inicial: " + jogadores[i].meuDinheiro);
                System.out.println("--------------------------------");
            }
        }
    }

    public void mostrarMaosIndividual(Jogador jogador){
        System.out.println("Jogador: " + jogador.nome);
        String carta1 = jogador.getMinhasCartas()[0].nome + " de " + jogador.getMinhasCartas()[0].naipe + " | ";
        String carta2 = jogador.getMinhasCartas()[1].nome + " de " + jogador.getMinhasCartas()[1].naipe;
        System.out.println("Suas cartas são: " + carta1 + carta2 + "\n");
        System.out.println("Seu dinheiro inicial: " + jogador.meuDinheiro);
        System.out.println("--------------------------------");
    }

    public boolean verificaSeExisteJogadoresNaMesa(Jogador[] jogadores){
        int cont = 0;
        for (Jogador jogadore : jogadores) {
            if (!jogadore.foiRemovido) {
                cont++;
            }
        }
        return cont > 1;
    }

    public boolean verificaSeAlguemAindaPrecisaSubirAAposta(int i, double maiorAposta, Jogador[] jogadores){
        boolean verificacao = false;

        if(i == 2){
            if(!jogadores[0].foiRemovido){
                if(jogadores[0].getMinhaUltimaAposta() == maiorAposta){
                    verificacao = true;
                }
            }
        } else {
            if(!jogadores[i + 1].foiRemovido){
                if(jogadores[i + 1].getMinhaUltimaAposta() == maiorAposta){
                    verificacao = true;
                }
            }
        }
        return verificacao;
    }

    public String jogadoresDisponíveis(Jogador[] jogadores){
        String nomes = "";
        for(int i = 0; i < jogadores.length; i++){
            if(!jogadores[i].foiRemovido){
                nomes += " | " + jogadores[i].getNome() + " | ";
            }
        }

        return nomes;
    }

}
