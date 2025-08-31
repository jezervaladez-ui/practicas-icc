// Importa la clase Random para generar elecciones aleatorias de la computadora
import java.util.Random;

// Importa la clase Scanner para leer la entrada del usuario desde la consola
import java.util.Scanner;

// Clase principal del programa
public class PiedraPapelTijeraNumerico {

    // Método principal que ejecuta el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        Random random = new Random(); // Crea un objeto Random para generar elecciones aleatorias

        int jugadorVictorias = 0; // Contador de rondas ganadas por el jugador
        int computadoraVictorias = 0; // Contador de rondas ganadas por la computadora

        System.out.println("bienvenido al juego piedra papel o tijeras, diviertete"); // Mensaje de bienvenida

        // Bucle que continúa mientras ninguno de los dos haya ganado 2 rondas
        while (jugadorVictorias < 2 && computadoraVictorias < 2) {
            System.out.print("\nEscribe tu elección (piedra, papel o tijera): ");
            String eleccionJugador = scanner.nextLine().toLowerCase(); // Lee y convierte a minúsculas la elección del jugador

            int jugador = -1; // Inicializa la elección del jugador con un valor inválido

            // Convierte la elección del jugador en un número: piedra=0, papel=1, tijera=2
            if (eleccionJugador.equals("piedra")) {
                jugador = 0;
            } else if (eleccionJugador.equals("papel")) {
                jugador = 1;
            } else if (eleccionJugador.equals("tijera")) {
                jugador = 2;
            } else {
                // Si la entrada es inválida, muestra un mensaje y reinicia la iteración del bucle
                System.out.println("Entrada no válida. Intenta de nuevo.");
                continue;
            }

            int computadora = random.nextInt(3); // Genera un número aleatorio entre 0 y 2 para la elección de la computadora
            String eleccionComputadora = ""; // Variable para almacenar la elección de la computadora en texto

            // Asocia el número aleatorio con una elección textual
            if (computadora == 0) {
                eleccionComputadora = "piedra";
            } else if (computadora == 1) {
                eleccionComputadora = "papel";
            } else {
                eleccionComputadora = "tijera";
            }

            // Muestra la elección de la computadora
            System.out.println("La computadora eligió: " + eleccionComputadora);

            // Compara las elecciones y determina el resultado de la ronda
            if (jugador == computadora) {
                System.out.println("¡Empate!");
            } else if ((jugador == 0 && computadora == 2) || // piedra gana a tijera
                       (jugador == 1 && computadora == 0) || // papel gana a piedra
                       (jugador == 2 && computadora == 1)) { // tijera gana a papel
                System.out.println("¡Ganaste esta ronda!");
                jugadorVictorias++; // Suma una victoria al jugador
            } else {
                System.out.println("¡Perdiste esta ronda!");
                computadoraVictorias++; // Suma una victoria a la computadora
            }

            // Muestra el marcador actual
            System.out.println("Marcador -> Tú: " + jugadorVictorias + " | Computadora: " + computadoraVictorias);
        }

        // Mensaje final según quién haya ganado 2 rondas primero
        if (jugadorVictorias == 2) {
            System.out.println("\n🎉 ¡Ganaste el juego!");
        } else {
            System.out.println("\n💻 La computadora ganó el juego. ¡Suerte la próxima!");
        }
    }
}
