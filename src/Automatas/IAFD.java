package Automatas;

import estructuras.Lista;

public interface IAFD<TipoSimbolo> {
	public void asignarEstadoInicial(String s);
	public void asignarEstadosFinales(Lista<String> estFinales);
	public void leerSiguiente();
	public String snapShot();
	public String snapShotChain(Palabra<TipoSimbolo> p);
	public boolean acepta(Palabra<TipoSimbolo> s);
}