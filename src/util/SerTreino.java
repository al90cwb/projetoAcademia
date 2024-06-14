package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Treino;

public abstract class SerTreino {
    private static final File TREINO_ARQUIVO = new File("src/obj/treino.bin");

    public static void salvarDados(List<Treino> lista) throws Exception {
        try {
            TREINO_ARQUIVO.getParentFile().mkdirs();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TREINO_ARQUIVO));
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o arquivo");
        }
    }

    public static List<Treino> carregarDados() throws Exception {
        try {
            if (TREINO_ARQUIVO.exists() && TREINO_ARQUIVO.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TREINO_ARQUIVO));

                return (List<Treino>) ois.readObject();
            } else {
                throw new Exception("Arquivo inválido");
            }

        } catch (Exception e) {
            throw new Exception("Não foi possível ler o arquivo");
        }

    }

}
