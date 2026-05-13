import java.io.*;
import java.util.*;

public class Archivo {

    public static List<String[]> leer(String archivo) throws Exception {
        List<String[]> datos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea;
        while ((linea = br.readLine()) != null) {
            datos.add(linea.split(" "));
        }

        return datos;
    }

    public static Set<String> obtenerCiudades(List<String[]> datos) {
        Set<String> ciudades = new HashSet<>();

        for (String[] d : datos) {
            ciudades.add(d[0]);
            ciudades.add(d[1]);
        }

        return ciudades;
    }
}