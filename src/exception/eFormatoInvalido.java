package exception;

public class eFormatoInvalido extends Exception {
     public eFormatoInvalido(){
        super("Formato Inválido, digite um outro valor valido");
     }
     public eFormatoInvalido(String e){
        super("Formato Inválido, digite um outro valor valido"+ e );
     }
}
