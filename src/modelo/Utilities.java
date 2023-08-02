//Author Fabian Esteban Lopez Arias
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

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

    //Metodo para cargar datos.
    public static LinkedList<Punto2D> readFile() throws IOException {
        LinkedList<Punto2D> listaPuntos2D = new LinkedList<>();
        {
            try {
                File myObj = new File("puntos2D.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (data.equals("")) {

                    } else {
                        String[] arrLinea = data.split(",");

                        listaPuntos2D.add(new Punto2D(Double.parseDouble(arrLinea[0]), Double.parseDouble(arrLinea[1])));
                    }
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return listaPuntos2D;
        }
    }
}
