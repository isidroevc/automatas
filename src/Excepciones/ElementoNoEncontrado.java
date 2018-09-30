package Excepciones;

public class ElementoNoEncontrado extends RuntimeException 	{
	public ElementoNoEncontrado() {
        super();
    }
    public ElementoNoEncontrado(String s) {
        super(s);
    }
    public ElementoNoEncontrado(String s, Throwable throwable) {
        super(s, throwable);
    }
    public ElementoNoEncontrado(Throwable throwable) {
        super(throwable);
    }
}
