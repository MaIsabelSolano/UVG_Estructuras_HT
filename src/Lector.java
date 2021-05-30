import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {

    private Scanner scanDoc;
    private ArrayList<String> nombresCentros = new ArrayList<>();

    public ArrayList<String> GenerarGrafo() throws FileNotFoundException{
        ArrayList<String> grafo = new ArrayList<>();
        try {
            FileReader guategrafo = new FileReader("guategrafo.txt");
            scanDoc = new Scanner(guategrafo);
            while (scanDoc.hasNextLine()) {
                String temp = scanDoc.nextLine();
                grafo.add(temp);
            }



        }catch (FileNotFoundException fnfe){
            System.out.println("Se ha producido un error con la lectura del archivo");
        }
        scanDoc.close();
        return grafo;


    }

    public ArrayList<String> NombresCentros()throws  FileNotFoundException{

        File guategrafo = new File("guategrafo.txt");
        scanDoc = new Scanner(guategrafo);
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


}
