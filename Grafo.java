import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grafo {
    private final Map<String, List<Arista>> adyacencia = new HashMap<>();

    /**
     * Agrega un nodo al grafo.
     */
    public void agregarNodo(String nombre) {
        adyacencia.putIfAbsent(nombre, new ArrayList<>());
    }

    /**
     * Agrega una arista bidireccional (o unidireccional si se cambia).
     *
     * @param origen Nodo inicial
     * @param destino Nodo final
     * @param peso Costo del viaje
     */
    public void agregarArista(String origen, String destino, int peso) {
        agregarNodo(origen);
        agregarNodo(destino);
        adyacencia.get(origen).add(new Arista(destino, peso));
        // Si la red no es bidireccional, comenta la siguiente línea:
        adyacencia.get(destino).add(new Arista(origen, peso));
    }

    public Map<String, List<Arista>> getAdyacencia() {
        return adyacencia;
    }
}