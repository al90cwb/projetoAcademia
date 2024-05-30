package util;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Este Objeto filtra as entradas do teclado, todos tratamento
 * poderm ser feitos aqui 
 * Ele lealiza oprações do Scanner(System.in);
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public abstract class Entrada {
        //formatação entradas
        public static  DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyy");
        public static Scanner in = new Scanner(System.in);

        //tratamento entradas
        public static int entradaInt() {
            boolean entradaValida = false;
            int numero=0;
            while (!entradaValida) {
                try {
                    numero = in.nextInt();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine(); // Limpa o buffer do scanner
                }
            }
            return numero;
        }

        public static int entradaZeroUm() {
            boolean entradaValida = false;
            int numero=0;
            while (!entradaValida) {
                try {
                    numero = in.nextInt();
                    if (numero==0 || numero ==1){
                        entradaValida = true; // Se a entrada for válida, saímos do loop
                    }else{
                        entradaValida = false; // Se a entrada for válida, saímos do loop
                        System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine(); // Limpa o buffer do scanner
                }
            }
            return numero;
        }

        public static float entradaFloat() {
            boolean entradaValida = false;
            float numero=0f;

            while (!entradaValida) {
                try {
                    numero = in.nextFloat();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine(); // Limpa o buffer do scanner
                }
            }
            return numero;
        }

        public static String entradaCPF(){
            return in.nextLine();
        }
        
        public static String entradaEmail(){
            return in.nextLine();
        }

        public static String entradaSexo(){
            return in.nextLine();
        }

        public static String entradaString(){
            boolean entradaValida = false;
            String frase="";
            //teclado.nextLine();
            while (!entradaValida) {
                try {
                    frase = in.nextLine();
                    entradaValida = true; // Se a entrada for válida, saímos do loop
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número válido.");
                    in.nextLine(); // Limpa o buffer do scanner
                }
            }
            return frase;
        }

        public static String entradaData(){
            String dataFormatada = "";

            boolean formatoCorreto = false;
            while (!formatoCorreto) {
                String entrada = in.nextLine();

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
