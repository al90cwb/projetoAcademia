package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Professor;

public abstract class SerProfessor {
    private static final File PROFESSOR_ARQUIVO = new File("src/obj/administrador.ser");
    public static void salvar(List<Professor> lista) throws Exception {
        try {
            PROFESSOR_ARQUIVO.getParentFile().mkdirs();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROFESSOR_ARQUIVO));
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o arquivo");
        }
    }

    public static List<Professor> ler() throws Exception {
        try {
            if (PROFESSOR_ARQUIVO.exists() && PROFESSOR_ARQUIVO.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROFESSOR_ARQUIVO));

                return (List<Professor>) ois.readObject();
            } else {
                throw new Exception("Arquivo inválido");
            }

        } catch (Exception e) {
            throw new Exception("Não foi possível ler o arquivo");
        }

    }

}
