import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Crear el grafo con los edificios del campus
        Grafo grafo = new Grafo();

        // Conexiones del campus (latencias reales en ms)
        grafo.agregarArista("BIB", "LAB", 5);
        grafo.agregarArista("BIB", "ADM", 3);
        grafo.agregarArista("LAB", "ING", 4);
        grafo.agregarArista("LAB", "MED", 9);
        grafo.agregarArista("ADM", "ING", 6);
        grafo.agregarArista("ADM", "CAF", 7);
        grafo.agregarArista("ING", "MED", 2);
        grafo.agregarArista("MED", "CAF", 5);
        grafo.agregarArista("CAF", "DEP", 11);
        grafo.agregarArista("DEP", "RES", 6);
        grafo.agregarArista("RES", "AUD", 4);
        grafo.agregarArista("AUD", "PAR", 7);
        grafo.agregarArista("PAR", "BIB", 10);

        // Seleccionar el edificio origen para medir latencias
        String origen = "BIB";

        // Ejecutar Dijkstra
        Map<String, Integer> distancias = Dijkstra.calcular(grafo, origen);

        // Mostrar resultados
        System.out.println("Latencias mínimas (ms) desde " + origen + " hacia todos los edificios:\n");
        for (Map.Entry<String, Integer> entry : distancias.entrySet()) {
            System.out.println("→ " + entry.getKey() + ": " + entry.getValue() + " ms");
        }
    }
}