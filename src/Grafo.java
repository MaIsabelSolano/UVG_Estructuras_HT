//referencia: https://stackabuse.com/graphs-in-java-representing-graphs-in-code/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Grafo<Centro> {

    private Map<Centro, List<Centro>> adjCentros;
    private ArrayList<String> ListaCentros = new ArrayList<>();
    private int numOfNodes;

    private float[][] matrix;
    private boolean[][] isSetMatrix;

    private class Centro{
        final String nombre;

        private Centro(String nombre) {
            this.nombre = nombre;
        }
    }

    public Grafo(int numOfNodes, ArrayList<String> NombCentros) {
        this.numOfNodes = numOfNodes;

        matrix = new float[numOfNodes][numOfNodes]; //matriz cuadrada
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
        this.ListaCentros = NombCentros;
    }

    public void AgregarCentro(String nombresrc, String nombredest, int src, int destino, float peso){

        matrix[ListaCentros.indexOf(nombresrc)][ListaCentros.indexOf(nombredest)] = peso;

        isSetMatrix[ListaCentros.indexOf(nombresrc)][ListaCentros.indexOf(nombredest)] = true;
        //como siempre va a ser direccionado no es nec
    }

    public ArrayList<String> getListaCentros() {
        return ListaCentros;
    }

    public void printMatrix(){
        for (int i = 0; i <numOfNodes; i++){
            for (int j = 0; j < numOfNodes; j ++){
                if (isSetMatrix[i][j]){
                    System.out.format("%8s",String.valueOf(matrix[i][j]));
                }
                else {
                    System.out.format("%8s","/");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int src, int destination){
        return isSetMatrix[src][destination];
    }

    public boolean hasEdge(String nombreCentro){
        return ListaCentros.contains(nombreCentro);
    }

    public Float getEdgeValue(int src, int destination){
        if (isSetMatrix[src][destination]){
            return null;
        }
        return matrix[src][destination];
    }
}
