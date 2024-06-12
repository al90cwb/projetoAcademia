package exception;

public class TesteException extends Exception {
     public TesteException(){
        super("Minha Exceção");
     }
     public TesteException(String e){
        super("Minha Exceção "+ e );
     }
}
