import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String[]> datos = Archivo.leer("guategrafo.txt");
        Set<String> ciudades = Archivo.obtenerCiudades(datos);

        Grafo grafo = new Grafo(ciudades);

        for (String[] d : datos) {
            grafo.agregarArco(d[0], d[1], Integer.parseInt(d[2]));
        }

        Floyd floyd = new Floyd(grafo);
        floyd.calcular();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Ruta más corta");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Salir");

            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("Origen: ");
                String o = sc.next();
                System.out.print("Destino: ");
                String d = sc.next();

                int i = grafo.getMapa().get(o);
                int j = grafo.getMapa().get(d);

                System.out.println("Distancia: " + floyd.getDistancia(i, j));
            } else if (op == 2) {
                String centro = CentroGrafo.calcularCentro(
                        floyd.getDistMatrix(),
                        grafo.getNombres()
                );
                System.out.println("Centro: " + centro);
            } else {
                break;
            }
        }
    }
}