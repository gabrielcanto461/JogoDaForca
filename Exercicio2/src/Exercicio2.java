/*
matriz 10x10, random de 0 a 9, maior e menor valor da linha 5 e  coluna 7
 */


import java.util.Random;

public class Exercicio2 {

    public static void main(String[] args) {
        int[][] matriz = new int[10][10];
        int maiorLinha5 = 0;
        int menorLinha5 = 10;
        int maiorCol7 = 0;
        int menorCol7 = 10;

        Random random = new Random();

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                matriz[i][j] = random.nextInt(10);
                if (i == 5){
                    if (matriz[i][j] > maiorLinha5){
                        maiorLinha5 = matriz[i][j];
                    }else if (matriz[i][j] < menorLinha5){
                        menorLinha5 = matriz[i][j];
                    }
                }else if (j == 7){
                    if (matriz[i][j] > maiorCol7){
                        maiorCol7 = matriz[i][j];
                    }else if (matriz[i][j] < menorCol7){
                        menorCol7 = matriz[i][j];
                    }

                }
            }
        }
        for (int i = 0; i<10; i++){
            for (int j = 0; j < 10; j++){
                System.out.printf("%d ", matriz[i][j]);

            }
            System.out.println();
        }


        System.out.println("Linha 5: Maior " + maiorLinha5 + " Menor: " + menorLinha5);
        System.out.println("Coluna 7: Maior " + maiorCol7 + " Menor: " + menorCol7);
    }

}
