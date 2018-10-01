package Excepciones;

public class NoEsUnaFuncion extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoEsUnaFuncion() {
        super();
    }
    public NoEsUnaFuncion(String s) {
        super(s);
    }
    public NoEsUnaFuncion(String s, Throwable throwable) {
        super(s, throwable);
    }
    public NoEsUnaFuncion(Throwable throwable) {
        super(throwable);
    }
}
