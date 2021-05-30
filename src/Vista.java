import java.util.ArrayList;
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

    //no debe ser void
    public String[] SeleccionarCentros(ArrayList<String> centros){
        String Seleccion[] = new String[2];
        int op1,op2;
        verificador = true;
        while (verificador){
            try {
                //impresion
                print("_________________________________________________");
                for (String s:centros){
                    print((centros.indexOf(s)+1)+")\t"+s);
                }
                print("_________________________________________________");

                print("Escrba el numero del primer centro");
                op1 = scan.nextInt();

                //verificar que esté en el rango
                if ((op1-1) >= 0 && (op1-1)<centros.size()){
                    //está en el rango

                    print("Escriba el numero del segundo centro");
                    op2 = scan.nextInt();

                    if ((op2-1) >= 0 && (op2-1)<centros.size()){
                        Seleccion[0] = centros.get(op1-1);
                        Seleccion[1] = centros.get(op2-1);
                        //se puede salir del ciclo while
                        verificador = false;
                    }
                    else {
                        print(errormsg);
                    }

                }
                else {
                    //no esta en el rango
                    print(errormsg);
                    //repetir el ciclo while
                }

            }
            catch (InputMismatchException mie){
                scan.nextLine();
                print(errormsg);
            }
        }

        return Seleccion;
    }


}
