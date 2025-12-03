import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Dijkstra {

    public static Map<String, Integer> calcular(Grafo grafo, String origen) {

        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<NodoDistancia> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));

        // Inicializamos distancias
        for (String nodo : grafo.getAdyacencia().keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }

        distancias.put(origen, 0);
        pq.add(new NodoDistancia(origen, 0));

        while (!pq.isEmpty()) {
            NodoDistancia actual = pq.poll();

            for (Arista arista : grafo.getAdyacencia().get(actual.nodo)) {
                int nuevaDist = actual.distancia + arista.peso;

                if (nuevaDist < distancias.get(arista.destino)) {
                    distancias.put(arista.destino, nuevaDist);
                    pq.add(new NodoDistancia(arista.destino, nuevaDist));
                }
            }
        }

        return distancias;
    }
}