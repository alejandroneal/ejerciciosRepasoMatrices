/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 */
public class Trenes {

    public static void main(String[] args) {

        int[][] trenes = generarMatriz(7, 8);
        mostrarMatriz(trenes);
        
        Map<Integer, Tren> conjuntoTrenes = generarMap(trenes);
        
        System.out.println("");
        for (Map.Entry<Integer, Tren> filaMap : conjuntoTrenes.entrySet()) {
            Integer key = filaMap.getKey();
            Tren val = filaMap.getValue();
            System.out.println("Key: " + key +" -- value: " + val.toString());
        }
    }

    public static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        
        int[] tamanioVagones = {0, 20, 25, 30, 35, 40, 45, 50}; //Posibles tamaños de los vagones
        int codigo, valorVagon;
        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                //La primera columna contiene los códigos de cada tren
                if (j == 0) {
                    codigo = Integer.parseInt(RandomStringUtils.randomNumeric(3));
                    matriz[i][j] = codigo;
                } else {
                    //Condición para que cada tren tenga al menos un vagón
                    if (j == 1) {
                        valorVagon = random.nextInt(1, tamanioVagones.length);
                        matriz[i][j] = tamanioVagones[valorVagon];
                    } else {
                        //Condición para que cuando haya un cero en el vagón anterior poner ceros en
                        //los siguientes
                        if (matriz[i][j - 1] == 0) {
                            matriz[i][j] = 0;
                        } else {
                            valorVagon = random.nextInt(0, tamanioVagones.length);
                            matriz[i][j] = tamanioVagones[valorVagon];
                        }
                    }
                }
            }
        }

        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    //Crear una estructura Map cuya key es la primera columna de cada fila y el value será
    //una clase tipo Tren que contendrá el id del tren, el nº de vagones
    //y el nº de pasajeros que puede llevar el tren
    public static Map<Integer, Tren> generarMap(int [][] matriz){
        
        Map<Integer, Tren> conjuntoTrenes = new HashMap<>();
        
        
        for (int i = 0; i < matriz.length; i++) {
            //Lista para guardar una fila de la matriz, que corresponde con un tren
            List<Integer> lista = new ArrayList<>();
            
            //Guarda los valores de una fila de la matriz en la lista
            for (int j = 0; j < matriz[i].length; j++) {
                lista.add(matriz[i][j]);
            }
            
            int numeroVagones = calcularNumeroVagones(lista);
            
            int numeroPasajeros = calcularNumeroPasajerosMaximo(lista);
            
            //Guardo la primera posición de la lista que corresponde siempre con el id del tren,
            //el número de vagones del tren y la cantidad de personas máximas que puede llevar el tren
            //que se ha calculado anteriormente
            Tren trenAux = new Tren(lista.get(0), numeroVagones, numeroPasajeros);
            
            //Inserto la id del tren como la key del conjunto y el tren recien creado como value del Map
            conjuntoTrenes.put(lista.get(0), trenAux);
        }
        
        return conjuntoTrenes;
    }
    
    //Método para calcular el número de vagones que tiene un tren
    private static int calcularNumeroVagones(List<Integer> lista){
        int contador = 0;
        
        for (int i = 1; i < lista.size(); i++) {
            
            if (lista.get(i) != 0) {//Si el valor de la lista no vale 0 lo cuenta como vagón
                contador++;
            }
        }
        return contador;
    }
    
    //Método para calcular el número de pasajeros máximos que puede haber en el tren
    private static int calcularNumeroPasajerosMaximo(List<Integer> lista){
        int numPasajeros = 0;
        
        for (int i = 1; i < lista.size(); i++) {
            numPasajeros += lista.get(i); //Suma los valores de la lista menos el id
        }
        
        return numPasajeros;
    }
}
