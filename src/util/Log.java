package util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Modelo de LOG em arquivo de texto
 * Ele realiza gravação de dados em um arquivo de texto
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public abstract class Log {
    private static final File ARQUIVO = new File("src/log/log.txt");

    public static void escrever(String texto) throws Exception {
        List<String> log = new ArrayList<>();
        try {
            ARQUIVO.getParentFile().mkdirs();

            if (ARQUIVO.exists())
                log = ler();
            log.add(texto);

            PrintWriter print = new PrintWriter(new FileWriter(ARQUIVO));
            for (String string : log) {
                print.println(string);
            }
            print.close();

        } catch (Exception e) {
            throw new Exception("Não foi possível gravar o arquivo");
        }
    }

    public static List<String> ler() throws Exception {
        List<String> textos = new ArrayList<>();
        try {
            Scanner scan = new Scanner(ARQUIVO);
            while (scan.hasNextLine()) {
                textos.add(scan.nextLine());
            }
            scan.close();
            return textos;
        } catch (Exception e) {
            throw new Exception("Arquivo não Encontrado");
        }
    }

}
