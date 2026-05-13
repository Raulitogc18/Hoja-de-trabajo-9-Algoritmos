import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {

    @Test
    public void testAgregarArco() {
        Set<String> ciudades = new HashSet<>(Arrays.asList("A", "B"));
        Grafo g = new Grafo(ciudades);

        g.agregarArco("A", "B", 10);

        int[][] m = g.getMatriz();
        assertEquals(10, m[g.getMapa().get("A")][g.getMapa().get("B")]);
    }

    @Test
    public void testEliminarArco() {
        Set<String> ciudades = new HashSet<>(Arrays.asList("A", "B"));
        Grafo g = new Grafo(ciudades);

        g.agregarArco("A", "B", 10);
        g.eliminarArco("A", "B");

        int[][] m = g.getMatriz();
        assertEquals(999999, m[g.getMapa().get("A")][g.getMapa().get("B")]);
    }
}