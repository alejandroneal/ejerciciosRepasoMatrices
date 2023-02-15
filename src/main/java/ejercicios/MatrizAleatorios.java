/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.ArrayList;
import java.util.Random;

/**
 * Hacer una matriz nxn rellenando cada posición con valores comprendidos
 * entre 1 y n^2, pero no se pueden repetir
 */
public class MatrizAleatorios {
    public static void main(String[] args) {
        
        int[][] matriz = generarMatriz(5);
        imprimirMatriz(matriz);
    }
    
    public static int [][] generarMatriz(int tamanio){
        
        int[][] matriz = new int[tamanio][tamanio];
        ArrayList<Integer> lista = new ArrayList<>();
        
        //Bucle para rellenar la lista con todos los valores posibles de la matriz
        for (int i = 1; i <= Math.pow(tamanio, 2); i++) {
            lista.add(i);
        }
        
        Random random = new Random();
        int aleatorio;
        
        for (int j = 0; j < tamanio; j++) {
            for (int x = 0; x < tamanio; x++) {
                //Genera un nº aleatorio entre 0 y el tamaño de la lista
                aleatorio = random.nextInt(0, lista.size());
                //con el nº aleatorio se coge el valor que esté en esa posición
                matriz[j][x] = lista.get(aleatorio);
                //una vez introducido el valor en la matriz se borra de la lista para que no se repita
                lista.remove(aleatorio);
            }
        }
        
        return matriz;
    }
    
    public static void imprimirMatriz(int [][] matriz){
        
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
