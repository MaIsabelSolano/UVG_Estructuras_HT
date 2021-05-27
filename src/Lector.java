import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {

    Scanner scanDoc;
    ArrayList<String> nombresCentros = new ArrayList<>();

    Lector () throws FileNotFoundException{
        scanDoc = new Scanner("guategrafo.txt");
    }

    public int NumOfcentros() throws FileNotFoundException {
        int noNodos = 0;
        //if (scanDoc.nextLine()){}
        return noNodos;
    }

    public Grafo GenerarGrafo(Grafo grafo) throws FileNotFoundException{
        return grafo;
    }
}
