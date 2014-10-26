package schoolprojects;

import java.util.Random;
import java.util.Scanner;

/**
 * Piedra, papel o tijera es un juego infantil.
 * Un juego de manos en el cual existen tres elementos. 
 * La piedra que vence a la tijera rompiéndola; la tijera que vencen al papel cortándolo; 
 * y el papel que vence a la piedra envolviéndola. Esto representa un ciclo, el cual 
 * le da su esencia al juego. Este juego es muy utilizado para decidir quien de dos 
 * personas hará algo, tal y como a veces se hace usando una moneda, o para dirimir algún asunto.
 * 
 * En esta version del juego habra un Jugador Humano y un jugador artificial ( es decir el ordenador )
 *
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class Juego {

    /**
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        /**
         * Movimientos disponibles en forma de cadena.
         */
        String[] movimientos = {"Piedra", "Papel", "Tijera"};

        /**
         * Moviemiento elegido por el usuario en forma de numero entero.
         */
        int entradaUsuario = 0;

        /**
         * Un numero aleatorio que representara el movimiento del ordenador.
         */
        int movimientoAleatorio = 0;

        /**
         * Los resultados posibles de la partida. 0 EMPATE 1 El jugador gana 2
         * El jugador pierde
         */
        String[] resultados = {"Empate", "Ganas", "Pierdes"};

        /**
         * El resultado de la partida respecto el jugador.
         */
        int resultadoJugador = -1;

        /**
         * Aqui es donde epieza el juego.
         * 
         * Pedimos al usuario que elija uno de los movimientos disponibles
         * y generamos un movimiento aleatorio, que sera el movimiento del ordenador.
         * Despues comptrobamos si el jugador gana al ordenador , si pierde o si hay un empate.
         * Mostramos el resultado en la pantalla y el bucle se repite hasta que
         * el jugador no introduce -1 como movimiento.
         */
        do {
            // Mostramos informacion sobre los movimientos validos y 
            // los numeros que le corresponden.
            for (int i = 0; i < movimientos.length; i++) {
                System.out.print("(" + (i + 1) + ") " + movimientos[i] + "\n");
            }

            // Valor predeterminado ( o entrada no valida, por si el usuario no introduce ningun valor )
            entradaUsuario = 0;

            // Leemos la entrada ( el moviemiento ) del usuario
            try {
                System.out.print("Movimiento: ");
                entradaUsuario = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                // Si la entrada no tiene un formato valido, mostraremos un mensaje de error 
                // y le pediremos al usuario que introduzca un movimiento nuevamente.
                entradaUsuario = 0;
            } 
            
            // Si la opcion elegida por el usuario no es valida imprimimos un 
            // mensaje de error y le volvemos a pedir que introduzca una opcion
            if (entradaUsuario < 1 || entradaUsuario > 3) {
                System.out.println("\n*** El movimiento elegido no es valido. ***");
                continue;
            }

            // Restamos 1 a la entrada del usuario. 
            // Esto lo hacemos para que sea un indice de vector valido.
            entradaUsuario -= 1;
            
            // Generamos un movimiento aleatorio
            movimientoAleatorio = rand.nextInt(movimientos.length);

            // Para separar el "menu" de moviemientos y la entrada del usuario
            // con la salida/resultado de la partida marco
            System.out.println("\n*******************************\n");
            
            // Imprimimos las jugadas del jugador y del ordenador
            System.out.println("Tu: (" + movimientos[entradaUsuario] + ") [VS] PC: (" + movimientos[movimientoAleatorio] + ")");

            // Comprobamos si el jugador gana
            if ((entradaUsuario == 0 && movimientoAleatorio == 2) || 
                (entradaUsuario == 1 && movimientoAleatorio == 0) ||
                (entradaUsuario == 2 && movimientoAleatorio == 1)) {
                
                resultadoJugador = 1;
            } else if(entradaUsuario == movimientoAleatorio) { // Comprobamos si es un empate
                resultadoJugador = 0;
            } else { // en el resto de los casos el jugador pierde
                resultadoJugador = 2;
            }

            // Imprimimos el resultado de la partida
            System.out.println("Resultado: " + resultados[resultadoJugador]);
            
            // Para separar el "menu" de moviemientos y la entrada del usuario
            // con la salida/resultado de la partida marco
            System.out.println("\n*******************************\n");
            
        } while (entradaUsuario != -1);
    }
}
