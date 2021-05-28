import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

    //clases importadas
    Scanner scan = new Scanner(System.in);

    //variables a utilizar
    private int OpcionMenu = 0;
    private boolean verificador = true;
    final private String errormsg = "Ha ocurrido un error, la opción que eligió no existe";

    private void print(String a){
        //para evitar tener que poner System.out.println
        System.out.println(a);
    }

    public int MenuPrincipal(){

        verificador = true; //reiniciar el verificador
        while (verificador) {
            //impresion de las opciones para el usuario
            print("_________________________________________________");
            print("Escriba el número de la opción que desea realizar");
            print("1)Obtener la distancia mas corta entre 2 centros");
            print("2)Obtener el centro de vacunación más céntrico");
            print("3)Actualizar rutas");
            print("4)Finalizar");
            print("_________________________________________________");
            print("Número de la opcion que desaea realizar");
            try {
                OpcionMenu = scan.nextInt();

                //si es un número continua

                //verifcar que sea un número válido
                if (OpcionMenu <= 4 && OpcionMenu >= 0 ){
                    //se puede salir del while
                    verificador = false;
                }
                else {
                    //se repite el cilco
                    print(errormsg);
                }

            } catch (InputMismatchException ime) {
                scan.nextLine();
                print(errormsg);
                //se repite el ciclo hasta que el usuario ingrese una opcion válida
            }
        }
        return OpcionMenu;
    }


}
