package abb;

public class Arbol {
    Nodo raiz;

    public Arbol(){
        raiz = null;
    }

    public void insertar(int dato){
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo actual, int dato){
        if(actual == null){
            return new Nodo(dato);
        }

        if(dato < actual.dato){
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        }else{
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        }
        return actual;
    }


    public void inOrder(Nodo actual){
        if (actual != null) {
            inOrder(actual.izquierdo);
            System.out.print(actual.dato+ " ");
            inOrder(actual.derecho);
        }
    }

    public void insertarMayores(Nodo actual, Arbol arbol2){
        insertarMayoresRecursivo(raiz, arbol2);
    }

    private Nodo insertarMayoresRecursivo(Nodo actual, Arbol arbol2){
        if (actual != null) {
            if (actual.dato > 50) {
                arbol2.insertar(actual.dato);
            }
            insertarMayoresRecursivo(actual.izquierdo, arbol2);
            insertarMayoresRecursivo(actual.derecho, arbol2);
        }
        return actual;
    }

    public void eliminarImpares(){
        int contador = contarPares(raiz);
        int[] pares = new int[contador];
        int index = 0;
        recolectarPares(raiz, pares, index);
        raiz = null; // Limpiar el árbol
        for (int val : pares) {
            insertar(val); // Reinsertar solo los pares
        }
    }

    private int contarPares(Nodo actual){
        if (actual == null) return 0;
        int count = (actual.dato % 2 == 0) ? 1 : 0;
        return count + contarPares(actual.izquierdo) + contarPares(actual.derecho);
    }

    private void recolectarPares(Nodo actual, int[] pares, int index){
        if (actual != null) {
            if (actual.dato % 2 == 0) {
                pares[index++] = actual.dato;
            }
            recolectarPares(actual.izquierdo, pares, index);
            recolectarPares(actual.derecho, pares, index);
        }
    }

}



