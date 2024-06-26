package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Administrador;

public abstract class SerAdministrador {
    private static final File ADMINISTRADOR_ARQUIVO = new File("src/obj/administrador.bin");

    public static void salvarDados(List<Administrador> lista) throws Exception {
        try {
            ADMINISTRADOR_ARQUIVO.getParentFile().mkdirs();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADMINISTRADOR_ARQUIVO));
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o arquivo");
        }
    }

    public static List<Administrador> carre() throws Exception {
        try {
            if (ADMINISTRADOR_ARQUIVO.exists() && ADMINISTRADOR_ARQUIVO.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ADMINISTRADOR_ARQUIVO));

                return (List<Administrador>) ois.readObject();
            } else {
                throw new Exception("Arquivo inválido");
            }

        } catch (Exception e) {
            throw new Exception("Não foi possível ler o arquivo");
        }

    }

}
