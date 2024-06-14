package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Aluno;

public abstract class SerAluno {
    private static final File ALUNO_ARQUIVO = new File("src/obj/aluno.bin");

    public static void salvarDados(List<Aluno> lista) throws Exception {
        try {
            ALUNO_ARQUIVO.getParentFile().mkdirs();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ALUNO_ARQUIVO));
            oos.writeObject(lista);
            oos.close();

        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o arquivo");
        }
    }

    public static List<Aluno> carregarDados() throws Exception {
        try {
            if (ALUNO_ARQUIVO.exists() && ALUNO_ARQUIVO.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ALUNO_ARQUIVO));

                return (List<Aluno>) ois.readObject();
            } else {
                throw new Exception("Arquivo inválido");
            }

        } catch (Exception e) {
            throw new Exception("Não foi possível ler o arquivo");
        }

    }

}
