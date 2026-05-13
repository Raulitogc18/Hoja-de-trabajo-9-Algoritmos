public class CentroGrafo {

    public static String calcularCentro(int[][] dist, String[] nombres) {
        int n = dist.length;
        int INF = 999999;

        int centro = -1;
        int min = INF;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] > max) {
                    max = dist[i][j];
                }
            }

            if (max < min) {
                min = max;
                centro = i;
            }
        }

        return nombres[centro];
    }
}