import java.util.*;

public class Grafo {
    private static final int INF = 999999;
    private Map<String, Integer> mapa;
    private String[] nombres;
    private int[][] matriz;
    private int size;

    public Grafo(Set<String> ciudades) {
        size = ciudades.size();
        mapa = new HashMap<>();
        nombres = new String[size];
        matriz = new int[size][size];

        int i = 0;
        for (String c : ciudades) {
            mapa.put(c, i);
            nombres[i] = c;
            i++;
        }

        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = (i == j) ? 0 : INF;
            }
        }
    }

    public void agregarArco(String origen, String destino, int peso) {
        matriz[mapa.get(origen)][mapa.get(destino)] = peso;
    }

    public void eliminarArco(String origen, String destino) {
        matriz[mapa.get(origen)][mapa.get(destino)] = INF;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public String[] getNombres() {
        return nombres;
    }

    public Map<String, Integer> getMapa() {
        return mapa;
    }

    public int getSize() {
        return size;
    }
}