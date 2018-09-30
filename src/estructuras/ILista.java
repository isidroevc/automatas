package estructuras;

public interface ILista<TipoDato> {
	public void agregar(TipoDato d);
	public void quitar(int indice);
	public void agregarEn(int index, TipoDato d);
	public TipoDato obtener(int indice);
	public void asignar(int indice, TipoDato d);
	public boolean existe(TipoDato d);
}
