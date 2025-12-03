import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Dijkstra {

    /**
     * Calcula la ruta más corta desde un nodo origen.
     *
     * @param grafo Grafo ponderado
     * @param origen Nodo inicial
     * @return Un mapa con las distancias mínimas desde el origen a todos los nodos
     */
    public static Map<String, Integer> calcular(Grafo grafo, String origen) {
        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<NodoDistancia> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distancia));

        // Inicializar todas las distancias en "infinito"
        for (String nodo : grafo.getAdyacencia().keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }

        distancias.put(origen, 0);
        pq.add(new NodoDistancia(origen, 0));

        while (!pq.isEmpty()) {
            NodoDistancia actual = pq.poll();

            // Si el nodo tiene vecinos, recorrerlos
            for (Arista arista : grafo.getAdyacencia().get(actual.nodo)) {
                int nuevaDistancia = actual.distancia + arista.peso;

                if (nuevaDistancia < distancias.get(arista.destino)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    pq.add(new NodoDistancia(arista.destino, nuevaDistancia));
                }
            }
        }

        return distancias;
    }
}