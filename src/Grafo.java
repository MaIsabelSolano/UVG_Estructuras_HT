//referencia: https://stackabuse.com/graphs-in-java-representing-graphs-in-code/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.NullPointerException;

public class Grafo<String> {

    private Map<String, List<String>> adjCentros;
    private ArrayList<String> ListaCentros = new ArrayList<>();
    private int numOfNodes;

    private Float[][] matrix;
    private boolean[][] isSetMatrix;
    private Integer[][] S;


    public Grafo(ArrayList<String> NombCentros) {
        this.numOfNodes = NombCentros.size();

        //se crean 2 matrices cuadradas vacías
        matrix = new Float[numOfNodes][numOfNodes]; //matriz cuadrada
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
        S = new Integer[numOfNodes][numOfNodes];

        for (int i = 0; i < numOfNodes; i++){
            for (int j = 0; j < numOfNodes; j ++){
                if (i == j){
                    S[i][j] = 0;
                }
                else {
                    S[i][j] = j+1;
                }
            }

        }

        this.ListaCentros = NombCentros;
    }

    public void GenerarGrafo(ArrayList<String[]> lineasdoc){

        //llenar las matrices
        for (int i = 0; i < lineasdoc.size(); i++){
            String src = lineasdoc.get(i)[0];
            String destino = lineasdoc.get(i)[1];
            Float peso = Float.parseFloat(lineasdoc.get(i)[2].toString());
            AgregarCentro(src,destino,peso);
        }
        /*
        for (int i = 0; i < lineasdoc.size(); i++){
            String tempS = lineasdoc.get(i);
            String[] temp = tempS.toString().split(",");
            Float peso = Float.parseFloat((java.lang.String) temp[2]);
            AgregarCentro(temp[0],temp[1],peso);
            //AgregarCentro(temp[0],temp[1]);
        }

         */

        //Algorithm();
    }

    public void AgregarCentro(String nombresrc, String nombredest, float peso){

        try {

            matrix[ListaCentros.indexOf(nombresrc)][ListaCentros.indexOf(nombredest)] = peso;

            isSetMatrix[ListaCentros.indexOf(nombresrc)][ListaCentros.indexOf(nombredest)] = true;

            //llenar el mapa

            if (adjCentros.containsKey(nombresrc)) {
                if (!adjCentros.get(nombresrc).contains(nombredest)) {
                    //si no lo contiene se añade

                    adjCentros.get(nombresrc).add(nombredest);
                }
            } else {
                //se crea
                ArrayList<String> destTemp = new ArrayList<>();
                destTemp.add(nombredest);
                adjCentros.put(nombresrc, destTemp);
            }
        }
        catch (NullPointerException npe){
            System.out.println("Ocurrio un error");
        }

    }

    public ArrayList<String> getListaCentros() {
        return ListaCentros;
    }

    public void printMatrix(){
        for (int i = 0; i <numOfNodes; i++){
            for (int j = 0; j < numOfNodes; j ++){
                if (isSetMatrix[i][j]){
                    //System.out.format("%8s",String.valueOf(matrix[i][j]));
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
/*
    public void Algorithm() throws NullPointerException{
        int size = ListaCentros.size();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; i < size; i++) {
                    if (i != j) {
                        //si son iguales se mantienen en 0
                        if (matrix[i][j] != null) {
                            if (matrix[i][j] > (matrix[i][k] + matrix[k][j])) {
                                matrix[i][j] = matrix[i][k] + matrix[k][j];
                                S[i][j] = k;
                            }
                        } else {
                            matrix[i][j] = matrix[k][j];
                            S[i][j] = k;
                        }
                    }

                }
            }
        }
        //return path;
    }

    public void CambiarRuta(){

    }

 */
}
