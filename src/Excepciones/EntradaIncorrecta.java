package Excepciones;

public class EntradaIncorrecta extends RuntimeException 	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EntradaIncorrecta() {
        super();
    }
    public EntradaIncorrecta(String s) {
        super(s);
    }
    public EntradaIncorrecta(String s, Throwable throwable) {
        super(s, throwable);
    }
    public EntradaIncorrecta(Throwable throwable) {
        super(throwable);
    }
}