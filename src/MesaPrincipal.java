
import java.util.Arrays;
import java.util.Scanner;

public class MesaPrincipal {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("***** Desafio Poker *****");

        Baralho baralho = new Baralho();
        baralho.embaralha();
        // baralho.imprimeBaralho();

        try {
            System.out.println("Quantos jogadores vão participar? ");
            Scanner scanner = new Scanner(System.in);
            int qtdJogadores = scanner.nextInt();
            if(qtdJogadores > 1){
                Jogador[] jogadores = new Jogador[qtdJogadores];
                boolean finalizar = false;
                for(int i = 0; i < qtdJogadores; i++){
                    Jogador jogador = new Jogador("Jogador"+(i+1));
                    jogador.setMinhasCartas(baralho.darCartas());
                    jogadores[i] = jogador;
                    utils.mostrarMaosIndividual(jogador);
                }
                double valorAtualDaMesa = 0.0;
                double valorAtualAposta = 0.0;
                double menorValorAposta = 0.0;
                while(!finalizar){
                    boolean alterouAposta = false;
                    for(int i = 0; i < jogadores.length; i++) {
                        if (!(jogadores[i].foiRemovido)) {
                            System.out.println("Jogador: " + jogadores[i].getNome());
                            System.out.println("Você deseja abandonar ou apostar? ");
                            System.out.println("1 - Apostar");
                            System.out.println("2 - Abandonar");
                            int opcao = scanner.nextInt();

                            if(opcao == 1){
                                System.out.println("Você escolheu apostar!");
                                System.out.println((valorAtualAposta > 0.0) ? "Você deverá apostar um valor igual ou superior a: " + valorAtualAposta : "Digite o valor da sua aposta inicial");
                                double valorAposta = scanner.nextDouble();
                                if(valorAtualAposta == 0.0){
                                    menorValorAposta = valorAposta;
                                }
                                while(valorAposta < valorAtualAposta){
                                    System.out.println("Valor inválido!");
                                    System.out.println("Você escolheu apostar!");
                                    System.out.println((valorAtualAposta > 0.0) ? "Você deverá apostar um valor igual ou superior a: " + valorAtualAposta : "Digite o valor da sua aposta");
                                    valorAposta = scanner.nextDouble();
                                }
                                double novoValor = jogadores[i].getMeuDinheiro() - valorAposta;
                                jogadores[i].setMeuDinheiro(novoValor);
                                jogadores[i].setMinhaUltimaAposta(valorAposta);
                                if((valorAposta > menorValorAposta || i == 0) && (utils.verificaSeAlguemAindaPrecisaSubirAAposta(i, valorAtualAposta, jogadores) == false)){
                                    finalizar = false;
                                    alterouAposta = true;
                                } else if(valorAtualAposta < valorAposta){
                                    finalizar = false;
                                    alterouAposta = true;
                                } else if((i + 1) == jogadores.length && valorAposta == menorValorAposta || utils.verificaSeAlguemAindaPrecisaSubirAAposta(i, valorAtualAposta, jogadores)) {
                                    finalizar = true;
                                    alterouAposta = false;
                                }
                                valorAtualAposta = valorAposta;
                                valorAtualDaMesa += valorAtualAposta;
                            } else {
                                System.out.println("Jogador: " + jogadores[i].getNome() + " abandonou a mesa!");
                                System.out.println("--------------------------------");
                                jogadores[i].foiRemovido = true;

                                utils.mostrarMaos(jogadores);
                                if(!utils.verificaSeExisteJogadoresNaMesa(jogadores)){
                                    finalizar = true;
                                }
                            }
                            System.out.println("Valor atual da mesa: " + valorAtualDaMesa);
                        }

                        if(!alterouAposta && valorAtualDaMesa > 0.0){
                            finalizar = true;
                            break;
                        }

                    }
                }
                for(int i = 0; i < jogadores.length; i++){
                    if(!(jogadores[i].foiRemovido)){
                        utils.mostrarMaosIndividual(jogadores[i]);
                    }
                }
                baralho.imprimirCartas();
                // System.out.println(baralho.temCarta());

                System.out.println("Nomes dos Jogadores da Mesa " + utils.jogadoresDisponíveis(jogadores) + "\n" + "Digite o nome do Jogador vencedor: ");
                String nomeJogadorVencedor = scanner.nextLine();
                nomeJogadorVencedor = scanner.nextLine();
                for(int i = 0; i < jogadores.length; i++){
                    if(jogadores[i].getNome().equals(nomeJogadorVencedor)){
                        System.out.println("O grande vencedor é: ");
                        System.out.println("\uD83C\uDFC6" + "\uD83D\uDD25" + " | Nome: " + jogadores[i].getNome() + " | Ganhou: " + valorAtualDaMesa + " | " + "\uD83C\uDFC6" + "\uD83D\uDD25");
                    }
                }
            } else {
                throw new NoMinimoDoisJogadoresException("Obrigatório no mínimo 2 jogadores!");
            }
        } catch(IllegalArgumentException | NoMinimoDoisJogadoresException error) {
            System.out.println(error);
        }
    }
}
