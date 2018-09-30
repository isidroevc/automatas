package Automatas;
import Excepciones.EntradaIncorrecta;
import estructuras.Lista;

public class Palabra<TipoSimbolo> {
	private Lista<TipoSimbolo> palabra;
	
	public Palabra(Lista<TipoSimbolo> p){
		this.palabra=p;
	}
	public Palabra<TipoSimbolo> concatenar(Palabra<TipoSimbolo>p){
		Lista<TipoSimbolo> nuevaLista=new Lista<TipoSimbolo>();
		for(int i=0;i<this.palabra.longitud;i++){
			p.palabra.agregar(this.palabra.obtener(i));
		}
		for(int i=0;i<=p.palabra.longitud;i++){
			nuevaLista.agregar(p.palabra.obtener(i));
		}
		
	return new Palabra<TipoSimbolo>(nuevaLista);	
	}
	public Lista<TipoSimbolo> obtenerSimbolos(){
		return palabra;
	}
	public TipoSimbolo simboloEn(int i){
		return palabra.obtener(i);
	}
	public Palabra<TipoSimbolo> subPalabra(int a, int b){
		Lista<TipoSimbolo>otraPalabra=new Lista<TipoSimbolo>();
		if(a<b){
			for(int i =a;i<b;i++){
				otraPalabra.agregar(palabra.obtener(a));
			}
			return new Palabra<TipoSimbolo>(otraPalabra);
		}else{
			throw new EntradaIncorrecta("Not found");
		}
		
	}

}
