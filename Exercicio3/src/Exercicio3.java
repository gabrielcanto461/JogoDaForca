/*
 *  matriz 3 x 3, do teclado, contar o numero de pares e impares
 * */


import java.util.Scanner;

class Exercicio3 {
    public static void main(String[] args) {

        int[][] matriz = new int[3][3];
        int qtdPares = 0;
        int qtdImpares = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Digite um número inteiro: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int[] vetor : matriz) {
            for (int numero : vetor) {
                if (numero % 2 == 0) {
                    qtdPares += 1;
                } else {
                    qtdImpares += 1;
                }
            }
        }

        System.out.println("Quantidade de Pares: " + qtdPares + "\nQuantidade de Ímpares: " + qtdImpares);

    }
}
