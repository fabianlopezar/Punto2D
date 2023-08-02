//Author Fabian Esteban Lopez Arias
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Utilities {

    //Metodo para guardar Datos
    public static boolean saveFile(LinkedList<Punto2D> listaPuntos2D) throws IOException {
        boolean t = false;
        FileWriter fileWriter = new FileWriter("puntos2D.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Punto2D elem : listaPuntos2D) {
            printWriter.println(elem.toString());
        }
        // Utilizamos Gson para convertir la LinkedList en formato JSON

        t = true;
        printWriter.close();
        return t;
    }

}
