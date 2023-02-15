/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.Random;

/**
 *
 * @author alejandro
 */
public class numerosBinarios {
    public static void main(String[] args) {
        int[][] matriz = generarMatriz(5);
        mostrarMatriz(matriz);
        
        System.out.println("");
        int[] coordenada = mirarEsquinas(matriz);
        
        for (int i = 0; i < coordenada.length; i++) {
            System.out.print(coordenada[i] + " ");
        }
    }
    
    //Método que genera una matriz rellena de 0 y 1 aleatoriamente
    public static int [][] generarMatriz(int tamanio){
        
        int[][] matriz = new int[tamanio][tamanio];
        Random random = new Random();
        int aleatorio;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aleatorio = random.nextInt(0, 2);
                matriz[i][j] = aleatorio;
            }
        }
        
        return matriz;
    }
    
    //Método para mostrar por pantalla una matriz de int
    public static void mostrarMatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    //Método que devuelve una coordenada de la matriz si las esquinas de esa coordenada
    //son 1
    public static int [] mirarEsquinas(int [][] matriz){
        int[] coordenadas = new int[2];
        
        //Bucle que recorre la matriz pero no los bordes de esta
        for (int i = 1; i < matriz.length - 1; i++) {
            for (int j = 1; j < matriz[i].length - 1; j++) {
                
                //filtro para comprobar que los valores que conforman las esquinas de un valor 
                //son iguales a 1
                if (matriz[i - 1][j - 1] == 1 && matriz[i -1][j + 1] == 1 &&
                        matriz[i + 1][j - 1] == 1 && matriz[i + 1][j + 1] == 1 && matriz[i][j] == 0) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    return coordenadas;
                }
            }
        }
        //Si no se encuentra ningún valor que concuerde con lo deseado devolverá una coordenada
        //con sus dos valores siendo -1
         coordenadas[0] = -1;
         coordenadas[1] = -1;
         
        return coordenadas;
    }
}
