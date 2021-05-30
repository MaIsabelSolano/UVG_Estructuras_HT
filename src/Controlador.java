import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Controlador {

    //clases
    Vista vista = new Vista();
    Lector lector = new Lector();
    Grafo grafo;

    //variables
    boolean verificador = true;
    int OpcionMenu;

    public Controlador() throws FileNotFoundException {
        //generar el grafo
        grafo = new Grafo(lector.NombresCentros()); //crea los espacios para las matrice
        grafo.GenerarGrafo(lector.GenerarGrafo()); //llena las matrices
    }

    /**
     * Esta es la función principal en la que se basa todo el programa
     */
    public void Menu(){

        while (verificador){
            OpcionMenu = vista.MenuPrincipal();

            if (OpcionMenu == 1){
                //Preguntar 2 centros y btener la distancia más corta
                String Consulta[] = vista.SeleccionarCentros(lector.getNombresCentros());
            }
            else if (OpcionMenu == 2){
                //Mostrar el centro del grafo
            }
            else if (OpcionMenu == 3){
                //modificar conexiones
            }
            else if (OpcionMenu == 4){
                //salir del programa
                System.out.println("Gracias por utilizar el programa\n");
            }
        }


    }
}
