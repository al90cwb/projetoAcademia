package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

        public static int entradaInt() {
            boolean entradaValida = false;
            int numero=0;
            Scanner teclado = Teclado.getScanner();
            while (!entradaValida) {
                try {
                    numero = teclado.nextInt();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    teclado.nextLine(); // Limpa o buffer do scanner
                }
            }
            return numero;
        }

        public static float entradaFloat() {
            boolean entradaValida = false;
            float numero=0f;
            Scanner teclado = Teclado.getScanner();

            while (!entradaValida) {
                try {
                    numero = teclado.nextFloat();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    teclado.nextLine(); // Limpa o buffer do scanner
                }
            }
            return numero;
        }

        public static String entradaString(){
            boolean entradaValida = false;
            String frase="";
            Scanner teclado = Teclado.getScanner();
            //teclado.nextLine();
            while (!entradaValida) {
                try {
                    frase = teclado.nextLine();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    teclado.nextLine(); // Limpa o buffer do scanner
                }
            }
            return frase;
        }

        public static String entradaData(){
            Scanner teclado = Teclado.getScanner();
            String dataFormatada = "";

            boolean formatoCorreto = false;
            while (!formatoCorreto) {
                String entrada = teclado.nextLine();

                try {
                    // Verifica se a entrada possui o formato correto
                    String[] partes = entrada.split("/");
                    if (partes.length == 3) {
                        int dia = Integer.parseInt(partes[0]);
                        int mes = Integer.parseInt(partes[1]);
                        int ano = Integer.parseInt(partes[2]);
                        
                        // Verifica se os valores estão dentro dos limites aceitáveis
                        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1000 && ano <= 9999) {
                            // Se estiver tudo correto, formata a data
                            dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
                            formatoCorreto = true; // Sai do loop
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
