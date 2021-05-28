import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {

    private Scanner scanDoc;
    private ArrayList<String> nombresCentros = new ArrayList<>();

    Lector () throws FileNotFoundException{
        File guategrafo = new File("guategrafo.txt");
        scanDoc = new Scanner(guategrafo);
    }

    public ArrayList<String> NombresCentros()throws  FileNotFoundException{
        while (scanDoc.hasNextLine()){
            String temp[] = scanDoc.nextLine().split(",");
            if (!nombresCentros.contains(temp[0])){
                //Si no contiene el primer lugar, lo añade
                nombresCentros.add(temp[0]);
            }
            if (!nombresCentros.contains(temp[1])){
                //si no contiene al centro de destino, lo añade
                nombresCentros.add(temp[1]);
            }
        }
        scanDoc.close();
        return nombresCentros;
    }

    public Grafo GenerarGrafo(Grafo grafo) throws FileNotFoundException{
        return grafo;
    }
}
