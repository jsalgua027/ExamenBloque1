/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package prueba;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class Margaritas {

    //variables y constantes para los metodos 
    private static Scanner teclado = new Scanner(System.in);

    private static Random aleatorio = new Random();

    private static final String MENU_PRINCIPAL = """
                                                
                                                **********VIVA EL AMOR*********
                                                
                                                    .Escriba Si para iniciar
                                                    .Escriba No para terminiar
                                                    
                                                *********************************
                                                """;

    public static String pidoMuestroMenu() {

        String aux = "";

        System.out.println(MENU_PRINCIPAL);
        aux = teclado.nextLine();

        return aux;
    }
//metodo para generar el dado-->aqui controlo que si es 3 se repite

    public static int generadorTiradas() {
        int aux = 0;

        do {

            aux = aleatorio.nextInt(6 - 1 + 1) + 1;

            if (aux == 3) {

                System.out.println("Ha salido 3 se repite");

            }

        } while (aux == 3);

        return aux;
    }
//pido margaritas controlando el numero que sea de 1 a 10
    public static int pidoNumeroMargaritas() {
        int num = 0;
        boolean repetir = true;
        do {

            do {
                System.out.println("¿Cuantas Margaritas tienes entre (1 y 10)?");
                try {

                    num = teclado.nextInt();
                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("No has introducido un numero entero");
                    //limpio buffer
                    teclado.nextLine();
                }

            } while (repetir);

        } while (num < 1 || num > 10);

        return num;
    }

    public static int pidoNumeroPetalos(int contador) {
        int num = 0;
        boolean repetir = true;
      int  auxContador=contador+1;
        do {
            System.out.println("Introduce el numero petalos que tiene cada margarita N: "+auxContador);
            try {

                num = teclado.nextInt();
                repetir = false;

            } catch (InputMismatchException ime) {
                System.out.println("No has introducido un numero entero");
                //limpio buffer
                teclado.nextLine();
            }

        } while (repetir);

        return num;
    }
// meotodo para saber si es te quiere o no segun la tirada

    public static boolean mequiereSiNo(int numero) {
        boolean aux = true;
        if (numero % 2 == 0) {
            aux = true;

        } else {
            aux = false;

        }

        return aux;
    }
//metodo para cambiar el valor por cada quitada de petalo

    public static boolean cambiaAmor(boolean aux) {
        boolean amor = true;

        if (aux == true) {
            amor = false;

        } else {
            amor = true;
        }

        return amor;
    }

    public static String muestroElAmorFinal(boolean resultado) {
        String aux = "";

        if (resultado == true) {
            aux = "ME QUIERE";

        } else {
            aux = "NO ME QUIERE";
        }

        return aux;
    }

    public static void main(String[] args) {

        Scanner limpieza = new Scanner(System.in);//para la limpieza bufer

        //variables para los porcesos
        String opcionMenu = "";
        int numeroMargaritas = 0;
        int numeroPetalos = 0;
        int contadorMargaritas = 0;
        int tiradaDado = 0;
        boolean amor = true;//me quiere true
        boolean cuentoAmor = true; // para usar el metodo de cambio.
        String resultadoFinalAmor = "";
        String amorInicial = "";

        do {

            opcionMenu = pidoMuestroMenu();

            if (opcionMenu.equalsIgnoreCase("si")) {

                numeroMargaritas = pidoNumeroMargaritas();

                for (int i = 0; i < numeroMargaritas; i++) {//bucle para jugar con el numero de margaritas
                    numeroPetalos = pidoNumeroPetalos(contadorMargaritas);

                    tiradaDado = generadorTiradas();
                    amor = mequiereSiNo(tiradaDado);
                    contadorMargaritas++;
                    for (int j = numeroPetalos; j >= 1; j--) {// bucle para quitar petalos cambio con el método el valor
                        cuentoAmor = cambiaAmor(amor);
                    }
                    //muestro el resultado final por cada margarita
                    System.out.println("La margarita N: " + contadorMargaritas + " tiene: " + numeroPetalos + " petalos "
                            + " la tirada de dados fue: " + tiradaDado + "  y comenzo con " + muestroElAmorFinal(amor)
                            + " el resultado final es: " + muestroElAmorFinal(cuentoAmor));
                          
                }
                System.out.println("¿Quieres repetir?");
                opcionMenu=limpieza.nextLine();//controlo la opcion de repetir
                 if(opcionMenu.equalsIgnoreCase("no")||(!opcionMenu.equalsIgnoreCase("si"))){
                 
                 opcionMenu="no";
                 }else{
                     opcionMenu="si";
                 
                 }
            }
            
            

        } while (opcionMenu.equalsIgnoreCase("si") || (!opcionMenu.equalsIgnoreCase("no")));

    }

}
