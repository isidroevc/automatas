package Excepciones;

public class ElementoNoEncontrado extends RuntimeException 	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
