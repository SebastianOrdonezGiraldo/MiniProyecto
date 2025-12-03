import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Crear grafo
        Grafo grafo = new Grafo();

        // Agregar nodos y aristas (ejemplo con 10 nodos)
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 2);
        grafo.agregarArista("B", "D", 5);
        grafo.agregarArista("C", "D", 8);
        grafo.agregarArista("C", "E", 10);
        grafo.agregarArista("D", "E", 2);
        grafo.agregarArista("D", "F", 6);
        grafo.agregarArista("E", "F", 3);
        grafo.agregarArista("B", "G", 7);
        grafo.agregarArista("E", "H", 1);
        grafo.agregarArista("H", "I", 4);
        grafo.agregarArista("I", "J", 6);

        // Elegir nodo origen
        String origen = "A";

        // Ejecutar Dijkstra
        Map<String, Integer> distancias = Dijkstra.calcular(grafo, origen);

        // Mostrar resultados
        System.out.println("Distancias mínimas desde el nodo " + origen + ":");
        for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
            System.out.println("→ " + entry.getKey() + " = " + entry.getValue());
        }
    }
}