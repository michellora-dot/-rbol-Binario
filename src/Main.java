import java.util.Scanner;

// Clase nodo
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

// Clase árbol binario
class ArbolBinario {
    Nodo raiz;

    // Insertar nodo
    public Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertar(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertar(raiz.derecho, valor);
        }

        return raiz;
    }

    // Recorrido inorden
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inorden(raiz.derecho);
        }
    }

    // Buscar un valor
    public boolean buscar(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor == valor) {
            return true;
        }

        if (valor < raiz.valor) {
            return buscar(raiz.izquierdo, valor);
        } else {
            return buscar(raiz.derecho, valor);
        }
    }
}

// Clase principal (menú)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion, valor;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número: ");
                    valor = sc.nextInt();
                    arbol.raiz = arbol.insertar(arbol.raiz, valor);
                    break;

                case 2:
                    System.out.println("Recorrido inorden:");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Número a buscar: ");
                    valor = sc.nextInt();
                    if (arbol.buscar(arbol.raiz, valor)) {
                        System.out.println("El número ¡SI! existe");
                    } else {
                        System.out.println("El número ¡NO! existe");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);

        sc.close();
    }
}