import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa un grafo ponderado para modelar la red de telecomunicaciones.
 * Cada edificio es un nodo y cada enlace de fibra óptica es una arista con latencia en ms.
 */
class Grafo {
    private final Map<String, List<Arista>> adyacencia = new HashMap<>();

    public void agregarNodo(String nombre) {
        adyacencia.putIfAbsent(nombre, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int peso) {
        agregarNodo(origen);
        agregarNodo(destino);
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso)); // red bidireccional
    }

    public Map<String, List<Arista>> getAdyacencia() {
        return adyacencia;
    }
}