package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public abstract class SerProfessor {
    private static final File PROFESSOR_ARQUIVO = new File("src/obj/professor.bin");

    public static <T> void salvar(List<T> lista) throws Exception {
        try {
            PROFESSOR_ARQUIVO.getParentFile().mkdirs();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROFESSOR_ARQUIVO));
            oos.writeObject(lista);
            oos.close();
        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o arquivo");
        }
    }

    public static <T> List<T> ler() throws Exception {
        try {
            if (PROFESSOR_ARQUIVO.exists() && PROFESSOR_ARQUIVO.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROFESSOR_ARQUIVO));
                return (List<T>) ois.readObject();
            } else {
                throw new Exception("Arquivo inválido");
            }

        } catch (Exception e) {
            throw new Exception("Não foi possível ler o arquivo");
        }

    }

}
