package Excepciones;

public class IndiceFueradeLimites extends RuntimeException {
	public IndiceFueradeLimites() {
        super();
    }
    public IndiceFueradeLimites(String s) {
        super(s);
    }
    public IndiceFueradeLimites(String s, Throwable throwable) {
        super(s, throwable);
    }
    public IndiceFueradeLimites(Throwable throwable) {
        super(throwable);
    }
}
