package view;

import util.Entrada;

public abstract class MenusStandard {

    // GERAL----------------------------
    public static boolean confimar() {
        // ver exercicio
        System.out.println("0=NÃO,1=SIM");
        boolean op = Entrada.entradaZeroUm() == 1;
        return op;
    }

}
