import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FloydTest {

    @Test
    public void testFloydDistancia() {
        Set<String> ciudades = new HashSet<>(Arrays.asList("A", "B", "C"));
        Grafo g = new Grafo(ciudades);

        g.agregarArco("A", "B", 5);
        g.agregarArco("B", "C", 3);

        Floyd f = new Floyd(g);
        f.calcular();

        int i = g.getMapa().get("A");
        int j = g.getMapa().get("C");

        assertEquals(8, f.getDistancia(i, j));
    }
}