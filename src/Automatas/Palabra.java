package Automatas;

import estructuras.Lista;

public class Palabra<TipoSimbolo> {
	public Lista<TipoSimbolo> palabra;
	public Palabra(Lista<TipoSimbolo> p){
		this.palabra=p;
	}
	public Palabra<TipoSimbolo> concatenar(Palabra<TipoSimbolo>p){
	return p;	
	}

}
