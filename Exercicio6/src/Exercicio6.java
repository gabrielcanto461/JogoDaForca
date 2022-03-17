import javax.swing.*;
import java.util.Scanner;

public class Exercicio6 {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void imprimeTabuleiro(char[][] tabuleiro) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != 2) {
                    System.out.printf("%2c │", tabuleiro[i][j]);
                }else{
                    System.out.printf("%2c", tabuleiro[i][j]);
                }

            }
            if (i!=2) {
                System.out.println();
                System.out.print("───┼───┼───");
                System.out.println();
            } else {
                System.out.println();
            }

        }
    }

    static boolean validaJogada(int linha, int coluna, char[][] tabuleiro){

        if (linha < 0 | linha > 3){
            System.out.println("Posição inválida!\nEscolha uma linha e coluna entre 1 e 3");
            return false;
        }
        if (coluna < 0 | coluna > 3){
            System.out.println("Posição inválida!\nEscolha uma linha e coluna entre 1 e 3");
            return false;
        }
        if (tabuleiro[linha][coluna] == 'O' || tabuleiro[linha][coluna] == 'X'){
            System.out.println("Posição já escolhida!\nEscolha uma posição que ainda não foi selecionada!");
            return false;
        }
        return true;
    }

    static boolean checaVencedor(char[][] tabuleiro){

        //possibilidade 1: tab[1][j] são iguais
        for (int i = 0; i<3; i++){
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] != 32){
                if (tabuleiro[i][1] == tabuleiro[i][2]){
                    return true;
                }
            }
        }
        for (int j = 0; j<3; j++){
            if (tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[0][j] != 32){
                if (tabuleiro[1][j] == tabuleiro[2][j]){
                    return true;
                }
            }
        }
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] != 32){
            if (tabuleiro[1][1] == tabuleiro[2][2]){
                return true;
            }
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] != 32){
            if (tabuleiro[1][1] == tabuleiro[2][0]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] tabuleiro = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0; j<3;j++){
                tabuleiro[i][j] = 32;
            }
        }


        boolean vencedor = false;
        int linha;
        int coluna;
        String jogador1 = new String();
        String jogador2  = new String();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Jogo da Velha\n----------------");
        System.out.println("Nome jogador 1: ");
        jogador1 = scanner.nextLine();
        System.out.println("Nome jogador 2: ");
        jogador2 = scanner.nextLine();
        clearScreen();
        imprimeTabuleiro(tabuleiro);

        do{
            do {
                System.out.println("\nVEZ DE " + jogador1);
                System.out.println("Escolha um local para jogar!");
                System.out.println("Linha: ");
                linha = scanner.nextInt();
                System.out.println("Coluna: ");
                coluna = scanner.nextInt();
            }while(!validaJogada(linha-1, coluna-1, tabuleiro));
            tabuleiro[linha-1][coluna-1] = 'X';
            if (checaVencedor(tabuleiro)) {
                System.out.println("Parabéns, " + jogador1 + " venceu!!!");
                vencedor = true;
                break;
            }
            clearScreen();
            imprimeTabuleiro(tabuleiro);
            do {
                System.out.println("\nVEZ DE " + jogador2);
                System.out.println("Escolha um local para jogar!");
                System.out.println("Linha: ");
                linha = scanner.nextInt();
                System.out.println("Coluna: ");
                coluna = scanner.nextInt();
            }while(!validaJogada(linha-1, coluna-1, tabuleiro));
            tabuleiro[linha-1][coluna-1] = 'O';
            if (checaVencedor(tabuleiro)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Parabéns, " + jogador2 + " venceu!!!");
                vencedor = true;
                break;
            }
            clearScreen();
            imprimeTabuleiro(tabuleiro);
        }while(!vencedor);


    }
}
