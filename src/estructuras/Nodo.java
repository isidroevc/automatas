package estructuras;

public class Nodo<TipoDato> {
	public TipoDato dato;
	public Nodo<TipoDato> siguiente;
	
	public Nodo(TipoDato dato) {
		this.dato = dato;
	}
}
