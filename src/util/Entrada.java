package util;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe para objetos do tipo {@code Entrada}, onde filtra e processa os erros
 * de entrada
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */

public abstract class Entrada {
    
    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private static Scanner in = new Scanner(System.in);

  
    public static Scanner getEntrada(){
        return in;
    }

    public static void limparBuffer(){
        in.nextLine();
    }

    public static DateTimeFormatter getFormatoData(){
        return formatoData;
    }
    
    public static int entradaInt() {
        boolean entradaValida = false;
        int numero = 0;
        while (!entradaValida) {
            try {
                numero = in.nextInt();
                entradaValida = true; 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine(); 
            }
        }
        return numero;
    }

    public static int entradaZeroUm() {
        boolean entradaValida = false;
        int numero = 0;
        while (!entradaValida) {
            try {
                numero = in.nextInt();
                if (numero == 0 || numero == 1) {
                    entradaValida = true; 
                } else {
                    entradaValida = false; 
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine(); 
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine(); 
            }
        }
        return numero;
    }

    public static int entradaMinMax(int min, int max) {
        boolean entradaValida = false;
        int numero = 0;
        while (!entradaValida) {
            try {
                numero = in.nextInt();
                if (numero >= min && numero <= max) {
                    entradaValida = true;
                } else {
                    entradaValida = false; 
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine();
            }
        }
        return numero;
    }

    public static float entradaFloat() {
        boolean entradaValida = false;
        float numero = 0f;

        while (!entradaValida) {
            try {
                numero = in.nextFloat();
                entradaValida = true; 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine(); 
            }
        }
        return numero;
    }

    public static String entradaCPF() {
        return in.nextLine();
    }

    public static String entradaEmail() {
        return in.nextLine();
    }

    public static String entradaSexo() {
        return in.nextLine();
    }

    public static String entradaString() {
        boolean entradaValida = false;
        String frase = "";
        while (!entradaValida) {
            try {
                frase = in.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine();
            }
        }
        return frase;
    }

    public static String entradaTipoTreino() {
        boolean entradaValida = false;
        String frase = "";
        while (!entradaValida) {
            try {
                frase = in.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                in.nextLine();
            }
        }
        return frase;
    }

    public static String entradaData() {
        String dataFormatada = "";

        boolean formatoCorreto = false;
        while (!formatoCorreto) {
            String entrada = in.nextLine();

            try {
                String[] partes = entrada.split("/");
                if (partes.length == 3) {
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);
                    if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1000 && ano <= 9999) {
                        dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
                        formatoCorreto = true;
                    }
                }
                if (!formatoCorreto) {
                    System.out.println("Formato inválido. Por favor, digite uma data válida no formato (dd/mm/aaaa).");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Formato inválido. Por favor, digite uma data válida no formato (dd/mm/aaaa).");
            }
        }

        return dataFormatada;
    }

}
