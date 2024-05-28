package util;

import java.util.Scanner;

public class Teclado {
    private static Scanner teclado = new Scanner(System.in);

    private Teclado() {
        // Construtor privado para evitar instanciação externa
    }

    public static Scanner getScanner() {
        return teclado;
    }
}
