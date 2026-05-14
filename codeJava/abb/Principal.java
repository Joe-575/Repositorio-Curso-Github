package abb;

import java.util.Random;
import java.util.Scanner;


/*  Desarrolle un programa en Java que permita trabajar con Árboles Binarios de Búsqueda (ABB)
     y realice las siguientes tareas:

    Genere un arreglo con n números enteros aleatorios comprendidos entre 10 y 99. 
    Considere que n debe ser un valor tambien aleatorio comprendido entre 6 y 15.
    Inserte los valores del arreglo en un primer Árbol Binario de Búsqueda (ABB).
    Recorra el primer ABB en preOrder e inserte solo los valores mayores que 50 en un segundo ABB.
    Muestre los recorridos inOrder de ambos árboles.
    Elimine del primer ABB todos los valores impares.
    El sistema debe operar mediante un menú interactivo, con opciones claras y mensajes informativos para el usuario.
    
    */

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arbol arbol1 = new Arbol();
        Arbol arbol2 = new Arbol();
        int [] lista = new int[0];
        
        int opcion = 0;

        do {
            System.out.println("\n + -------------------------------------- + ");
            System.out.println(" 1. Generar arreglo y agregar al árbol  ");
            System.out.println(" 2. Guardar los datos mayores a 50 en otro árbol");
            System.out.println(" 3. ");
            System.out.println(" 4. ");
            System.out.println(" 5. Salir");
            System.out.print(" Ingrese una opcion:  ");
            opcion = sc.nextInt();
            System.out.println(" + -------------------------------------- + \n");

            switch (opcion) {
                case 1:
                    arbol1 =  new Arbol();
                    Random rnd = new Random();
                    System.out.println(" Se va a generar un numero random entre 6 y 15 ");
                    int min = 6;
                    int maxi = 15;
                    int numAleatorio = rnd.nextInt(maxi - min + 1) + min;
                    System.out.println(" El numero generado es: " + numAleatorio);
                    
                    System.out.println(" Se genera un arreglo de "+ numAleatorio+" entre 10 y 99 ");
                    lista = new int[numAleatorio];
                    int minimo = 10;
                    int maximo = 99;
                    for (int i = 0; i < lista.length; i++) {
                        int numAlea = rnd.nextInt(maximo - minimo + 1) + minimo;
                        lista[i] = numAlea;
                    }

                    for (int i = 0; i < lista.length; i++) {
                        arbol1.insertar(lista[i]);
                    }
                    
                    System.out.print(" ");
                    arbol1.inOrder(arbol1.raiz);


                    break;
                    
                case 2:
                    arbol2 = new Arbol();
                    arbol1.insertarMayores(arbol1.raiz, arbol2);
                    System.out.println(" ");
                    arbol2.inOrder(arbol2.raiz);


                    break;

                case 5:
                    System.out.println(" Saliendo del programa ");
                    break;
                
                default:
                    System.out.println(" Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
        sc.close();
    }
}