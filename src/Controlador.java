import java.util.InputMismatchException;

public class Controlador {

    //clases
    Vista vista = new Vista();
    Lector lector = new Lector();

    //variables
    boolean verificador = true;
    int OpcionMenu;

    /**
     * Esta es la función principal en la que se basa todo el programa
     */
    public void Menu(){
        //Generar el grafo

        while (verificador){
            OpcionMenu = vista.MenuPrincipal();

            if (OpcionMenu == 1){}
            else if (OpcionMenu == 2){}
            else if (OpcionMenu == 3){}
            else if (OpcionMenu == 4){
                //salir del programa
                System.out.println("Gracias por utilizar el programa\n");
            }
        }


    }
}
