public class Floyd {
    private int[][] dist;
    private String[][] path;
    private int n;
    private String[] nombres;

    public Floyd(Grafo grafo) {
        this.n = grafo.getSize();
        this.nombres = grafo.getNombres();

        dist = new int[n][n];
        path = new String[n][n];

        int[][] matriz = grafo.getMatriz();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = matriz[i][j];
                if (i != j && matriz[i][j] < 999999) {
                    path[i][j] = nombres[i];
                } else {
                    path[i][j] = "";
                }
            }
        }
    }

    public void calcular() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }

    public int getDistancia(int i, int j) {
        return dist[i][j];
    }

    public String getPath(int i, int j) {
        return path[i][j];
    }

    public int[][] getDistMatrix() {
        return dist;
    }
}