package util;

import java.util.Scanner;
/**
 * Este Objeto permite uma instancia somente para todo codigo
 * Ele lealiza oprações do Scanner(System.in);
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public class Teclado {
    private static Scanner teclado = new Scanner(System.in);

    private Teclado() {
        // Construtor privado para evitar instanciação externa
    }

    public static Scanner getScanner() {
        return teclado;
    }
}
